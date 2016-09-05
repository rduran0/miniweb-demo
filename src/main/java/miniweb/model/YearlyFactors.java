package miniweb.model;

import java.util.List;

public class YearlyFactors {
	private String year;
	private List<Factor> factors;
	
	public YearlyFactors(String year, List<Factor> factors) {
		this.year = year;
		this.factors = factors;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public List<Factor> getFactors() {
		return factors;
	}

	public void setFactors(List<Factor> factors) {
		this.factors = factors;
	}
}
