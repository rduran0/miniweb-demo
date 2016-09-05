package miniweb.model;

import java.util.List;

public class CountryScore {
	
	private String countryName;
	private String countryCode;
	private List<YearlyScore> scores;
	
	public CountryScore(String countryCode, String countryName, List<YearlyScore> scores) {
		this.countryCode = countryCode;
		this.countryName = countryName;
		this.scores = scores;
	}
	
	public String getCountryName() {
		return countryName;
	}
	
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	
	public String getCountryCode() {
		return countryCode;
	}
	
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	
	public List<YearlyScore> getScores() {
		return this.scores;
	}
	
	public void setScores(List<YearlyScore> scores) {
		this.scores = scores;
	}
	
}
