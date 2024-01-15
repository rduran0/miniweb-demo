package miniweb.controller;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import miniweb.jdbc.CountriesTemplate;
import miniweb.model.Country;

@RestController
public class CountriesRequest {
	
	@GetMapping(value = "/countries/all")
	public List<Country> obtainAllCountries() {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-mysql.xml");
		CountriesTemplate countriesTemplate = (CountriesTemplate) context.getBean("countriesTemplate");
		
		((ConfigurableApplicationContext)context).close();
		
		return countriesTemplate.getAllCountries();
	}

}
