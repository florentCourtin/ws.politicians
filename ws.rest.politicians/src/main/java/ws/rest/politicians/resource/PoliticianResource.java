package ws.rest.politicians.resource;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Link;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import ws.rest.politicians.data.Politician;
import ws.rest.politicians.dbconfig.DatabaseConfig;

/**
 * This class implements multiple HTTP methods to interact with the politicians resource in the REST web service.
 * @author Courtin Florent
 * @version 1.0
 * @since 2023-04-14
 */
@Path("/politicians")
public class PoliticianResource {
	/* The mysql-connector jar file need to be add in /WEB-INF/lib/ and in the modulepath of the project */
	private Connection conn;
	
	@Context
	UriInfo uriInfo;
	
	/**
	 * HTTP POST method that allows to add a politician in the REST web service (and database). The political party
	 * (which is a foreign key in Politican table) of the politician must be added before, otherwise the request will
	 * be refused.
	 * @param p The politician to add
	 * @return Return a Response object according to the state of the request
	 */
	@POST
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public Response addPolitician(Politician p) {
		
		if (p.getId() == null) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
		
		/* We have to check that the politician exists */
		try {
			URL url = new URL("https://www.nosdeputes.fr/" + p.getId() + "/xml");
			HttpURLConnection http = (HttpURLConnection) url.openConnection();
			http.setRequestMethod("GET");
			
			BufferedReader br = new BufferedReader(new InputStreamReader(http.getInputStream()));
			String inputLine;
		    StringBuilder rb = new StringBuilder();
		    while ((inputLine = br.readLine()) != null) {
		    	rb.append(inputLine);
		    }
		    br.close();
		    
		    String response = rb.toString();
		    
		    // Parse the reponse
		    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		    Document doc = factory.newDocumentBuilder().parse(new ByteArrayInputStream(response.getBytes()));
		    
		    XPathFactory xPathFactory = XPathFactory.newInstance();
		    XPath xPath = xPathFactory.newXPath();

		    String expression = "/depute";
		    NodeList nodes = (NodeList) xPath.evaluate(expression, doc, XPathConstants.NODESET);
		    
		    Node node = nodes.item(0);
		    
		    String getFirstName = xPath.evaluate("prenom", node);
		    String getLastName = xPath.evaluate("nom_de_famille", node);
		    String getSex = xPath.evaluate("sexe", node);
		    String getDeptNumber = xPath.evaluate("num_deptmt", node);
		    String getDeptName = xPath.evaluate("nom_circo", node);
		    /* ID linked to PoliticalParty table */
		    String getPartyId = xPath.evaluate("groupe_sigle", node); 
		    String getJob = xPath.evaluate("profession", node);
		    String getTwitter = xPath.evaluate("twitter", node);
		    /* Photo with an other call */
		    
		    Politician plt = new Politician(getFirstName, getLastName, p.getId(), getSex, getDeptNumber, getDeptName, getPartyId, getJob, getTwitter);
		    
		    Class.forName(DatabaseConfig.JDBC_DRIVER);
			conn = DriverManager.getConnection(DatabaseConfig.DB_URL, DatabaseConfig.USERNAME, DatabaseConfig.PASSWORD);
		    
		    String sql = "INSERT INTO Politician (politician_id, politician_fname, politician_lname, politician_sex, politician_dept_number, politician_dept_name, politician_party_id, politician_job, politician_twitter)"
		    		+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		    PreparedStatement pstmt = conn.prepareStatement(sql);
		    pstmt.setNString(1, p.getId());
		    pstmt.setNString(2, getFirstName);
		    pstmt.setNString(3, getLastName);
		    pstmt.setNString(4, getSex);
		    pstmt.setNString(5, getDeptNumber);
		    pstmt.setNString(6, getDeptName);
		    pstmt.setNString(7, getPartyId);
		    pstmt.setNString(8, getJob);
		    pstmt.setNString(9, getTwitter);
		    
		    int result= pstmt.executeUpdate();
		    pstmt.close();
		    conn.close();
		    if (result > 0) {
				return Response.status(Response.Status.OK).entity(plt).build();
			} else {
				return Response.status(Response.Status.BAD_REQUEST).build();
			}
		} catch (IOException | SAXException | ParserConfigurationException | XPathExpressionException | SQLException | ClassNotFoundException e1) {
			e1.printStackTrace();
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
	}
	
	/**
	 * HTTP GET method that allows to get politician informations with his id.
	 * @param id The id of the politician
	 * @return Return a Response object according to the state of the request
	 */
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_XML)
	public Response getPolitician(@PathParam("id") String id) {
		try {
			Class.forName(DatabaseConfig.JDBC_DRIVER);
			conn = DriverManager.getConnection(DatabaseConfig.DB_URL, DatabaseConfig.USERNAME, DatabaseConfig.PASSWORD);
			String sql = "SELECT * FROM Politician WHERE politician_id=?";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			boolean hasResults = pstmt.execute();
			
			if (hasResults) {
				ResultSet rs = pstmt.getResultSet();
				if (rs.next()) {
					String firstName = rs.getString("politician_fname");
					String lastName = rs.getString("politician_lname");
					String sex = rs.getString("politician_sex");
					String deptNumber = rs.getString("politician_dept_number");
					String deptName = rs.getString("politician_dept_name");
					String partyId = rs.getString("politician_party_id");
					String job = rs.getString("politician_job");
					String twitter = rs.getString("politician_twitter");
					
					Politician p = new Politician(firstName, lastName, id, sex, deptNumber, deptName, partyId, job, twitter);
					
					Link link = Link.fromUri(uriInfo.getRequestUri()).rel("self").type("application/xml").build();
					return Response.status(Response.Status.OK).entity(p).links(link).build();
				}
				rs.close();
			}
			pstmt.close();
			conn.close();
			
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return Response.status(Response.Status.NOT_FOUND).build();
	}
	
	/**
	 * HTTP GET method that allows to get all politicians, or all politicians from the same political party.
	 * @param partyIdRestriction The parameter the restrict the resultset to politicians from a certain political
	 * party. Set with null to disable restriction.
	 * @return Return a Response object according to the state of the request
	 */
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public Response getAllPoliticians(@QueryParam("party_id") String partyIdRestriction) {
		List<Politician> politicians = new ArrayList<>();
		
		try {
			Class.forName(DatabaseConfig.JDBC_DRIVER);
			conn = DriverManager.getConnection(DatabaseConfig.DB_URL, DatabaseConfig.USERNAME, DatabaseConfig.PASSWORD);
			String sql;
			if (partyIdRestriction == null) {
	            sql = "SELECT * FROM Politician";
	        } else {
	            sql = "SELECT * FROM Politician WHERE politician_party_id=?";
	        }

	        PreparedStatement pstmt = conn.prepareStatement(sql);
	        if (partyIdRestriction != null) {
	            pstmt.setString(1, partyIdRestriction);
	        }
	        boolean hasResult = pstmt.execute();
			
			if (hasResult) {
				Politician p;
				ResultSet rs = pstmt.getResultSet();
				while (rs.next()) {
					String id = rs.getString("politician_id");
					String firstName = rs.getString("politician_fname");
					String lastName = rs.getString("politician_lname");
					String sex = rs.getString("politician_sex");
					String deptNumber = rs.getString("politician_dept_number");
					String deptName = rs.getString("politician_dept_name");
					String partyId = rs.getString("politician_party_id");
					String job = rs.getString("politician_job");
					String twitter = rs.getString("politician_twitter");
					
					p = new Politician(firstName, lastName, id, sex, deptNumber, deptName, partyId, job, twitter);
					politicians.add(p);
				}
				rs.close();
			}
			pstmt.close();
			conn.close();
			
			GenericEntity<List<Politician>> entity = new GenericEntity<List<Politician>>(politicians) {};
			return Response.status(Response.Status.OK).entity(entity).build();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return Response.status(Response.Status.NOT_FOUND).build();
	}
	
	/**
	 * HTTP DELETE method that allow to delete a politician in the REST web service.
	 * @param id The id of the politician to delete
	 * @return Return a Response object according to the state of the request
	 */
	@DELETE
	@Path("/{id}")
	public Response deletePolitician(@PathParam("id") String id) {
		try {
			Class.forName(DatabaseConfig.JDBC_DRIVER);
			conn = DriverManager.getConnection(DatabaseConfig.DB_URL, DatabaseConfig.USERNAME, DatabaseConfig.PASSWORD);
			String sql = "DELETE FROM Politician WHERE politician_id=?";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			int result = pstmt.executeUpdate();
			
			pstmt.close();
			conn.close();
			
			if (result > 0) {
				return Response.status(Response.Status.OK).build();
			} else {
				return Response.status(Response.Status.NOT_FOUND).build();
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
	}
}
