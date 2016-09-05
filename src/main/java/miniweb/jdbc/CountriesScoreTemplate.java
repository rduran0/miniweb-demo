package miniweb.jdbc;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import miniweb.dao.CountriesScoreDAO;
import miniweb.mapper.CountriesScoresMapper;
import miniweb.model.CountryScore;

public class CountriesScoreTemplate implements CountriesScoreDAO {
	
	private JdbcTemplate scoresTemplate;
	
	public void setDataSource(DataSource dataSource) {
		this.scoresTemplate = new JdbcTemplate(dataSource);
	}
	
	public List<CountryScore> getAllCountriesScores() {
		
		String sql = "SELECT C.country_code ccode, C.country_name cname, OSC.score_2013, OSC.score_2014, OSC.score_2015 "
				+ "FROM countries C, overall_score OSC "
				+ "WHERE C.id = OSC.country_id "
				+ "ORDER BY C.country_code";
		
		List<CountryScore> countriesScores = this.scoresTemplate.query(sql, new CountriesScoresMapper());
		
		return countriesScores;
	}

}
