package fr.treeptik.springsample.service.impl;


import fr.treeptik.springsample.dao.PersonneDAO;
import fr.treeptik.springsample.model.Personne;
import fr.treeptik.springsample.service.PersonneService;


//@Component
public class PersonneServiceImpl implements PersonneService{
	
	
//	@Autowired // c'est pas cool pour le TU
	private PersonneDAO personneDAO;
	
	
	public Personne save(Personne p) {
		return personneDAO.save(p);
	}
	
//	@Autowired
	public PersonneServiceImpl(PersonneDAO personneDAO) {
		this.personneDAO = personneDAO;
	}

	public PersonneServiceImpl() {
	}
	
//	@Autowired(required = false)
	public PersonneDAO getPersonneDAO() {
		return personneDAO;
	}

	public void setPersonneDAO(PersonneDAO personneDAO) {
		this.personneDAO = personneDAO;
	}
	

}
