package ws.rest.client.parties;

import java.util.List;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Response;

import ws.rest.client.politicians.Politician;

public class PoliticalPartyMain {

	public static void main(String[] args) {
		PartyRestClient client = new PartyRestClient();
		/*
		// Add a political party
		PoliticalParty pp = new PoliticalParty("LIOT");
		Response response = client.createXMLPoliticalParty(pp);
		
		// OK or CREATED
		if (response.getStatus() == 200 || response.getStatus() == 201) {
			System.out.println("Political party created in database");
		} else {
			System.out.println("Error while trying to create the political party : " + response.getStatus());
		}
		*/
		
		
		/*
		// Get a political party
		try {
			PoliticalParty pp = client.getPoliticalParty("LIOT");
			System.out.println(pp.toString());
		} catch (NotFoundException e) {
			System.out.println("Key not found in database");
			e.printStackTrace();
		}*/
		

		/*
		// Add information on a political party
		try {
			PoliticalParty pp = new PoliticalParty("LIOT");
			Response response = client.putPoliticalParty(pp);
			
			if (response.getStatus() == 200) {
				System.out.println("Political party edited in database");
			} else {
				System.out.println("Error while trying to edit the political party : " + response.getStatus());
			}
		} catch (NotFoundException e) {
			System.out.println("Key not found in database");
			e.printStackTrace();
		}*/
		
		
		// Get all political parties
		List<PoliticalParty> politicalParties = client.getAllPoliticalParties();
		for (PoliticalParty pp : politicalParties) {
		    System.out.println(pp.toString());
		}
	}

}
