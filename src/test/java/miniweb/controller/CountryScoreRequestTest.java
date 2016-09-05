package miniweb.controller;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.junit.Test;

public class CountryScoreRequestTest {
	
	@Test
	public void testStatus() {
		given().when().get("http://localhost:8080/miniweb-demo/score/all")
		.then().statusCode(200);
	}
	
	@Test
	public void testYearRequest() {
		given().when().get("http://localhost:8080/miniweb-demo/score/all")
		.then().body("countryName", hasItems("Argentina"));
	}
}
