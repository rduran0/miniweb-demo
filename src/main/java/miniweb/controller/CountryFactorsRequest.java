package miniweb.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import miniweb.jdbc.CountryFactorsTemplate;
import miniweb.jdbc.CountryTimeFactorsTemplate;
import miniweb.model.CountryFactorTime;
import miniweb.model.CountryFactors;

@RestController
public class CountryFactorsRequest {
	
	@RequestMapping(value = "/country/{id}/factors", method = RequestMethod.GET)
	public CountryFactors obtainCountryFactors(@PathVariable("id") String countryCode) {

		ApplicationContext context = new ClassPathXmlApplicationContext("spring-mysql.xml");
		CountryFactorsTemplate template = (CountryFactorsTemplate) context.getBean("countryFactorsTemplate");
		
		((ConfigurableApplicationContext)context).close();
		
		return template.getCountryFactors(countryCode);
	}
	
	@RequestMapping(value = "/country/{id}/factors/time", method = RequestMethod.GET)
	public CountryFactorTime obtainFactorsOverTime(@PathVariable("id") String countryCode) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-mysql.xml");
		CountryTimeFactorsTemplate template = (CountryTimeFactorsTemplate) context.getBean("countryTimeFactorsTemplate");
		
		((ConfigurableApplicationContext)context).close();
		
		return template.getFactorsOverTime(countryCode);
	}
}
