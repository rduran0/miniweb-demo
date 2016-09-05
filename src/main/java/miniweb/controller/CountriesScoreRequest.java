package miniweb.controller;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import miniweb.jdbc.CountriesScoreTemplate;
import miniweb.model.CountryScore;

@RestController
public class CountriesScoreRequest {

	@RequestMapping(value = "/score/all", method = RequestMethod.GET)
	public List<CountryScore> obtainCountriesFactors() {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-mysql.xml");
		
		CountriesScoreTemplate countries = (CountriesScoreTemplate) context.getBean("countriesScoreTemplate");
		
		((ConfigurableApplicationContext)context).close();
		
		return countries.getAllCountriesScores();
	}
}
