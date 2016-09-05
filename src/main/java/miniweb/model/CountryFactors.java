package miniweb.model;

import java.util.List;

public class CountryFactors {
	
	private Country country;
	private List<Factor> factors;
	
	public CountryFactors(Country country, List<Factor> factors) {
		this.country = country;
		this.factors = factors;
	}
	
	public List<Factor> getFactors() {
		return factors;
	}
	
	public Factor getFactor(int pos) {
		return factors.get(pos);
	}
	
	public void setFactors(List<Factor> factors) {
		this.factors = factors;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}
	
}
