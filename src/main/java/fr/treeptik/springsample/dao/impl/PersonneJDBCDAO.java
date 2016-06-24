package fr.treeptik.springsample.dao.impl;


import fr.treeptik.springsample.dao.PersonneDAO;
import fr.treeptik.springsample.model.Personne;

//@Repository
public class PersonneJDBCDAO implements PersonneDAO{
	
	@Override
	public Personne save(Personne p){
		System.out.println("JDBC");
		return p;
	}

}
