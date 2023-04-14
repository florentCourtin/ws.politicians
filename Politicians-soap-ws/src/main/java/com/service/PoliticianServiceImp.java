package com.service;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
* Web Service to add or get informations about Politicians
* implementing PoliticianService interface
*
* @author  Fleutry Eva
* @version 1.0
* @since   2023-04-14
*/

@WebService(targetNamespace="http://www.wsPolitician.com")
public class PoliticianServiceImp implements PoliticianService{

	//the HashMap where all the data is stored
	private static Map<Integer,Politician> Politicians = new HashMap<Integer,Politician>();
	
	/**
	* Returns true if the Politician has been added to the hashmap successfully 
	* Return false if the Politician doesn't exist or doesn't have an id 
	*
	* @param  p the Politician we want to add
	* @return true if added
	* @return false if error
	*/
	@WebMethod
	public boolean addPolitician(Politician p) {
		if(Politicians.get(p.getId()) != null) return false;
		Politicians.put(p.getId(), p);
		return true;
	}

	/**
	* Returns true if the Politician has been deleted from the hashmap successfully 
	* Return false if the Politician doesn't exist or doesn't have an id 
	*
	* @param  id of the politician we want to delete
	* @return true if deleted
	* @return false if error
	*/
	@WebMethod
	public boolean deletePolitician(int id) {
		if(Politicians.get(id) == null) return false;
		Politicians.remove(id);
		return true;
	}

	/**
	* Returns a Politician object from and id given
	*
	* @param  id of the politician we want get
	* @return the Politician object if it exists
	*/
	@WebMethod
	public Politician getPolitician(int id) {
		return Politicians.get(id);
	}

	/**
	* Returns a list of all the politicians in the static hashmap
	*
	* @return a list of Politicians
	*/
	@WebMethod
	public Politician[] getAllPoliticians() {
		Set<Integer> ids = Politicians.keySet();
		Politician[] p = new Politician[ids.size()];
		int i=0;
		for(Integer id : ids){
			p[i] = Politicians.get(id);
			i++;
		}
		return p;
	}
	
	/**
	* Returns the id of a politician politic party
	*
	* @param  id of the politician 
	* @return the id of their politic party
	*/
	@WebMethod
	public String getPoliticianParti(int id) {
		return Politicians.get(id).getPartyId();
	}

	

}
