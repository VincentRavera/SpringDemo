package fr.treeptik.springsample.dao.impl;

import fr.treeptik.springsample.dao.PersonneDAO;
import fr.treeptik.springsample.model.Personne;

//@Repository
public class PersonneJPADAO implements PersonneDAO{
	
	public Personne save(Personne p){
		System.out.println("JPA");
		return p;
	}

}
