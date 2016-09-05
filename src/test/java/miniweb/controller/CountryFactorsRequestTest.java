package miniweb.controller;

import org.junit.Test;

import miniweb.utils.Constants;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class CountryFactorsRequestTest {
	
	@Test
	public void testStatus() {
		given().when().get("http://localhost:8080/miniweb-demo/country/MEX/factors")
		.then().statusCode(200);
	}
	
	@Test
	public void testFactorContainer() {
		given().when().get("http://localhost:8080/miniweb-demo/country/MEX/factors")
		.then().body("factors.label", hasItems(Constants.FACTOR_CIV_JUSTICE));
	}

}
