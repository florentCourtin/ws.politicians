package ws.rest.politicians.resource;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
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

@Path("/politicians")
public class PoliticianResource {
	/* The jar file need to be had in /WEB-INF/lib/ and in the modulepath of the project */
	private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String DB_URL = "jdbc:mysql://mysql-courtin.alwaysdata.net:3306/courtin_ws";
	private static final String USERNAME = "courtin_ws";
	private static final String PASSWORD = "quddusArti";
	private Connection conn;
	
	@Context
	UriInfo uriInfo;
	
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
		    
		    Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
		    
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
				URI uri = uriInfo.getRequestUri();
				/* Build the uri for the updated political party */
				// String newUri = uri.getPath() + "/" + id;
				System.out.println("It work");
				return Response.status(Response.Status.OK).entity(plt).build();
			} else {
				return Response.status(Response.Status.BAD_REQUEST).build();
			}
		} catch (IOException | SAXException | ParserConfigurationException | XPathExpressionException | SQLException | ClassNotFoundException e1) {
			e1.printStackTrace();
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
	}
}
