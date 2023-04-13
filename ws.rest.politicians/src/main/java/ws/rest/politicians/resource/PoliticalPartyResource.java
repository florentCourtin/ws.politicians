package ws.rest.politicians.resource;

import java.io.*;
import java.net.*;
import java.sql.*;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import javax.xml.parsers.*;
import javax.xml.xpath.*;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import ws.rest.politicians.data.*;

@Path("/parties")
public class PoliticalPartyResource {
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
	public Response addPoliticalParty(PoliticalParty pp) {
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
			String sql = "INSERT INTO PoliticalParty (party_id) VALUES (?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setNString(1, pp.getId());
			
			int result = pstmt.executeUpdate();
			pstmt.close();
			conn.close();
			if (result > 0) {
				System.out.println("Political party inserted with success...");
				/* Get the current URI */
				URI uri = uriInfo.getRequestUri();
				/* Build the uri for the new political party */
				String newUri = uri.getPath() + "/" + pp.getId();
				return Response.status(Response.Status.CREATED).entity(pp).contentLocation(uri.resolve(newUri)).build();
			} else {
				System.out.println("Error...");
				return Response.status(Response.Status.BAD_REQUEST).build();
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		/* The key already exists or isn't among the possible political parties  */
		return Response.status(Response.Status.NOT_ACCEPTABLE).build();
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_XML)
	public Response getPoliticalParty(@PathParam("id") String id) {
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
			String sql = "SELECT * FROM PoliticalParty WHERE party_id=?";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			boolean hasResults = pstmt.execute();
			
			if (hasResults) {
				ResultSet rs = pstmt.getResultSet();
				if (rs.next()) {
					String name = rs.getString("party_name");
					String color = rs.getString("party_color");
					PoliticalParty pp = new PoliticalParty(id, name, color);
					Link link = Link.fromUri(uriInfo.getRequestUri()).rel("self").type("application/xml").build();
					return Response.status(Response.Status.OK).entity(pp).links(link).build();
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
	
	/* Update the political party with the information from the API */
	@PUT
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_XML)
	public Response addInfoPoliticalParty(@PathParam("id") String id) {
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
			String sql = "SELECT * FROM PoliticalParty WHERE party_id=?";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			boolean hasResults = pstmt.execute();
			
			if (hasResults) {
				ResultSet rs = pstmt.getResultSet();
				if (rs.next()) {
					String name = rs.getString("party_name");
					String color = rs.getString("party_color");
					
					if (name == null) {
						System.out.println("Name is null");
						
						try {
							// API URL
							URL url = new URL("https://www.nosdeputes.fr/organismes/groupe/xml");
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
						    // Get the informations about the party with the id
						    String expression = "/organismes/organisme[acronyme='" + id + "']";
						    NodeList nodes = (NodeList) xPath.evaluate(expression, doc, XPathConstants.NODESET);

						    Node node = nodes.item(0);
						    String getName = xPath.evaluate("nom", node);
						    String getColor = xPath.evaluate("couleur", node);
						    System.out.println("Nom: " + getName + ", Couleur: " + getColor);
						    
						    /* Update the political party in the database */
						    String sqlUpdate = "UPDATE PoliticalParty SET party_name=?, party_color=? WHERE party_id=?";
							PreparedStatement pstmtUpdate = conn.prepareStatement(sqlUpdate);
							pstmtUpdate.setNString(1, getName);
							pstmtUpdate.setNString(2, getColor);
							pstmtUpdate.setNString(3, id);
							
							PoliticalParty party = new PoliticalParty(id, getName, getColor);
							
							int resultUpdate = pstmtUpdate.executeUpdate();
							pstmtUpdate.close();
							conn.close();
							if (resultUpdate > 0) {
								//URI uri = uriInfo.getRequestUri();
								/* Build the uri for the updated political party ???*/
								//String newUri = uri.getPath() + "/" + id;
								return Response.status(Response.Status.OK).entity(party).build();
							} else {
								return Response.status(Response.Status.BAD_REQUEST).build();
							}
							
						} catch (IOException | SAXException | ParserConfigurationException | XPathExpressionException e) {
							e.printStackTrace();
						}
					} else {
						System.out.println("Name is not null"); // already implemented by the API
						return Response.status(Response.Status.BAD_REQUEST).build();
					}
				}
				rs.close();
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return Response.status(Response.Status.NOT_FOUND).build();
	}
	
}
