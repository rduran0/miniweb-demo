package minimap;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import miniweb.controller.CountriesRequestTest;
import miniweb.controller.CountryFactorsRequestTest;
import miniweb.controller.CountryScoreRequestTest;

@RunWith(Suite.class)

@Suite.SuiteClasses({
	CountriesRequestTest.class,
	CountryScoreRequestTest.class,
	CountryFactorsRequestTest.class
})

public class TestSuite {
}
