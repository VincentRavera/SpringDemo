package fr.treeptik.springsample.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import fr.treeptik.springsample.dao.PersonneDAO;
import fr.treeptik.springsample.dao.impl.PersonneJDBCDAO;

@Configuration
public class DAOconfig {
	@Bean
	public PersonneDAO personneDAO(){
		return new PersonneJDBCDAO();
	}
	

}
