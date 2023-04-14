package ws.rest.client.politicians;

import java.util.List;

import javax.ws.rs.client.*;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class PoliticianRestClient {
	private static final String REST_URI = "http://localhost:8080/ws.rest.politicians/api/politicians";
	private Client client = ClientBuilder.newClient();
	
	public Politician getPolitician(String id) {
		return client.target(REST_URI)
				.path(id).
				request(MediaType.APPLICATION_XML).
				get(Politician.class);
	}
	
	public Response createXMLPolitician(Politician p) {
		return client
				.target(REST_URI)
				.request(MediaType.APPLICATION_XML)
				.post(Entity.entity(p, MediaType.APPLICATION_XML));
	}
	
	public List<Politician> getAllPoliticians(String partyIdRestriction) {
		String uri = REST_URI;
		if (partyIdRestriction != null) {
			uri += "?party_id=" + partyIdRestriction;
		}
		return client
				.target(uri)
				.request(MediaType.APPLICATION_XML)
				.get(new GenericType<List<Politician>>() {});
	}
	
	public Response deletePolitician(String id) {
		return client
				.target(REST_URI)
				.path(id)
				.request()
				.delete();
	}
}
