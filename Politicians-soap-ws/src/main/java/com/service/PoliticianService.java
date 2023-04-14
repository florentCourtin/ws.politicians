package com.service;

/**
* Web service interface
*
* @author  Fleutry Eva
* @version 1.0
* @since   2023-04-14
*/
public interface PoliticianService {
	
	public boolean addPolitician(Politician p);
	public boolean deletePolitician(int id);
	public Politician getPolitician(int id);
	public Politician[] getAllPoliticians();
	public String getPoliticianParti(int id);

}
