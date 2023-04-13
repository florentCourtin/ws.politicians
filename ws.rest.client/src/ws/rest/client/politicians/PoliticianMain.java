package ws.rest.client.politicians;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Response;

public class PoliticianMain {

	public static void main(String[] args) {
		PoliticianRestClient client = new PoliticianRestClient();
		
		// Add a politician
		/*
		Politician politician = new Politician("sabine-thillaye");
		Response response = client.createXMLPolitician(politician);
		
		// OK or CREATED
		if (response.getStatus() == 200 || response.getStatus() == 201) {
			System.out.println("Politician created");
		// Already exists or isn't recognize by the API
		} else {
			System.out.println("Response status : " + response.getStatus());
		}*/
		
		
		// Get a politician
		// We have to indicate the unique id for the politician
		try {
			Politician politician = client.getPolitician("sabine-thillaye");
			System.out.println(politician.toString());
		} catch (NotFoundException e) {
			System.out.println("Key not found in database");
			e.printStackTrace();
		}
	}

}
