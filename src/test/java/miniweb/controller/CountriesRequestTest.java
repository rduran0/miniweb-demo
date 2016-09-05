package miniweb.controller;

import org.junit.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class CountriesRequestTest {

	@Test
	public void testSuccess() {
		given().when().get("http://localhost:8080/miniweb-demo/countries/all").then().statusCode(200);
	}
	
	@Test
	public void testCountryCode() {
		//Note that this value is assumed to be inside the DB, which it is!!!
		String countryCode = "MEX";
		
		given().when().get("http://localhost:8080/miniweb-demo/countries/all")
		.then().body("countryCode", hasItems(countryCode));
	}
	
}
