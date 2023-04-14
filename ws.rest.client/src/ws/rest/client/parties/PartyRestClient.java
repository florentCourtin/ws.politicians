package ws.rest.client.parties;

import java.util.List;

import javax.ws.rs.client.*;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import ws.rest.client.politicians.Politician;

public class PartyRestClient {
	private static final String REST_URI = "http://localhost:8080/ws.rest.politicians/api/parties";
	private Client client = ClientBuilder.newClient();
	
	public PoliticalParty getPoliticalParty(String id) {
		return client
				.target(REST_URI)
				.path(id)
				.request(MediaType.APPLICATION_XML)
				.get(PoliticalParty.class);
	}
	
	public Response createXMLPoliticalParty(PoliticalParty pp) {
		return client
				.target(REST_URI)
				.request(MediaType.APPLICATION_XML)
				.post(Entity.entity(pp, MediaType.APPLICATION_XML));
	}
	
	public Response putPoliticalParty(PoliticalParty pp) {
		return client
				.target(REST_URI)
				.path(pp.getId())
				.request(MediaType.APPLICATION_XML)
				.put(Entity.entity(pp, MediaType.APPLICATION_XML));
	}
	
	public List<PoliticalParty> getAllPoliticalParties() {
		return client
				.target(REST_URI)
				.request(MediaType.APPLICATION_XML)
				.get(new GenericType<List<PoliticalParty>>() {});
	}
}
