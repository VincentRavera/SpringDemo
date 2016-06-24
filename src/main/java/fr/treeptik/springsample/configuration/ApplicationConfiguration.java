package fr.treeptik.springsample.configuration;


import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import fr.treeptik.springsample.dao.PersonneDAO;
import fr.treeptik.springsample.dao.impl.PersonneJDBCDAO;
import fr.treeptik.springsample.dao.impl.PersonneJPADAO;
import fr.treeptik.springsample.service.PersonneService;
import fr.treeptik.springsample.service.impl.PersonneServiceImpl;

@Configuration
//@ComponentScan(basePackages={"fr.treeptik.springsample.service", "fr.treeptik.springsample.dao"})
//@ImportResource(value="classpath:/application-context.xml") // sis on change d'avis on peut le faire en xml 
//@Import(value={DAOconfig.class})
@PropertySource(value = "classpath:/config.properties", name = "conf")
public class ApplicationConfiguration {
	
//	@Autowired
//	private Environment environment;
	
	@Value("${db.driverclassname}")
	private String driverClassName;
	
	@Value("${db.url}")
	private String url;
	
	@Value("${db.username}")
	private String user;
	
	@Value("${db.password}")
	private String pass;
	
	
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}
	
	
	@Bean
	public DataSource dataSource(){
		BasicDataSource dataS = new BasicDataSource();
		
		System.out.println(url);
		
		dataS.setDriverClassName(driverClassName);
		dataS.setUrl(url);
		dataS.setUsername(user);
		dataS.setPassword(pass);
//		dataS.setPassword(environment.getProperty("db.password"));
		return dataS;
	}
	
	
	@Bean
	@Profile("jdbc")
	public PersonneDAO personneDAO(){
		return new PersonneJDBCDAO();
	}
	@Bean(name="personneDAO")
	@Profile("jpa")
	public PersonneDAO personneJPADAO(){
		return new PersonneJPADAO();
	}
//	@Autowired
//	private PersonneDAO personneDAO;
	
	@Bean
	@Scope("singleton") //le default - "singleton", "prototype" - instancies de nouveau objets a chaque appel
	public PersonneService personneService(PersonneDAO personneDAO) {//@qualifier pour choisir son implementation 
		PersonneServiceImpl personneServiceImpl = new PersonneServiceImpl();
		personneServiceImpl.setPersonneDAO(personneDAO);
		return personneServiceImpl;
	}
	
	
	

}
