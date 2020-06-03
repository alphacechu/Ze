package api.tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import api.Config;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class WeatherTest {
	
	@Test(testName = "Weather - Temperature Range", description = "Validate temperature of a location is within an specific range",
			groups = { "positive", "regression" })	
	@Parameters({"location","tempLow","tempHigh"})
	public void weatherRange(String location, double tempLow, double tempHigh) {
		String uri = Config.url+"data/2.5/weather";
		Response resp = RestAssured.given().param("q", location).param("appid", Config.appid)
		.get(uri);
		double temperature = resp.body().jsonPath().getDouble("main.temp");
		
		assertTrue(temperature > tempLow, "Temperature is too low, expected in higher than " + tempLow + ", actual is " + temperature + ".");
		assertTrue(temperature < tempHigh, "Temperature is too high, expected in lower than " + tempHigh + ", actual is " + temperature + ".");
	}
	
}
