package miniweb.dao;

import java.util.List;

import javax.sql.DataSource;

import miniweb.model.CountryScore;

public interface CountriesScoreDAO {
	
	public void setDataSource(DataSource dataSource);
	public List<CountryScore> getAllCountriesScores();

}
