package miniweb.model;

import java.util.List;

public class CountryTimeScore {
	private Country country;
	private List<YearlyScore> recordedScores;
	
	public CountryTimeScore(Country country, List<YearlyScore> recordedScores) {
		this.country = country;
		this.setRecordedScores(recordedScores);
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public List<YearlyScore> getRecordedScores() {
		return recordedScores;
	}

	public void setRecordedScores(List<YearlyScore> recordedScores) {
		this.recordedScores = recordedScores;
	}
}
