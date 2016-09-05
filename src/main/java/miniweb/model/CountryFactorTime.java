package miniweb.model;

import java.util.List;

public class CountryFactorTime {
	private Country country;
	private List<YearlyFactors> timeFactors;
	
	public CountryFactorTime(Country country, List<YearlyFactors> timeFactors) {
		this.country = country;
		this.timeFactors = timeFactors;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public List<YearlyFactors> getTimeFactors() {
		return timeFactors;
	}

	public void setTimeFactors(List<YearlyFactors> timeFactors) {
		this.timeFactors = timeFactors;
	}
	
	
}
