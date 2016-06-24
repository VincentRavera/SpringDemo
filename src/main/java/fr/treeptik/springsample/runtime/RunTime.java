package fr.treeptik.springsample.runtime;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import fr.treeptik.springsample.configuration.ApplicationConfiguration;
import fr.treeptik.springsample.model.Personne;
import fr.treeptik.springsample.service.PersonneService;

public class RunTime {
	@SuppressWarnings({ "unused", "resource" })
	public static void main(String[] args) {
		
		System.setProperty("spring.profiles.active", "jdbc");
		ApplicationContext applicationContext =  new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
//		ApplicationContext applicationContext =  new ClassPathXmlApplicationContext("application-context.xml");
		for (String string : applicationContext.getBeanDefinitionNames()) {
			System.out.println(string);
		}
		
		
		
		PersonneService personneService = (PersonneService )applicationContext.getBean("personneService");
		//c'est le nom de la methode
		
		personneService = applicationContext.getBean(PersonneService.class);
		
		personneService = applicationContext.getBean("personneService",PersonneService.class);
		
		personneService.save(new Personne());
		
		BasicDataSource dt = applicationContext.getBean("dataSource", BasicDataSource.class);
		System.out.println(dt.getUrl());
		
	}

}
