package miniweb.model;

public class YearlyScore {
	private int year;
	private double score;
	
	public YearlyScore(int year, double score) {
		this.year = year;
		this.score= score;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public double getScore() {
		return this.score;
	}

	public void setCountryScores(double score) {
		this.score = score;
	}
	
	
}
