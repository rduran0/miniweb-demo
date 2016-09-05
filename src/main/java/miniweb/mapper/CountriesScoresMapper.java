package miniweb.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import miniweb.model.CountryScore;
import miniweb.model.YearlyScore;
import miniweb.utils.Constants;

public class CountriesScoresMapper implements RowMapper<CountryScore> {
	
	public CountryScore mapRow(ResultSet rs, int rowNumb) throws SQLException {
		
		String countryCode = rs.getString(Constants.COUNTRY_CODE);
		String countryName = rs.getString(Constants.COUNTRY_NAME);
		List<YearlyScore> scores = new ArrayList<YearlyScore>();
		
		scores.add(new YearlyScore(2013, rs.getDouble(Constants.SCORE_2013)));
		scores.add(new YearlyScore(2014, rs.getDouble(Constants.SCORE_2014)));
		scores.add(new YearlyScore(2015, rs.getDouble(Constants.SCORE_2015)));
		
		return new CountryScore(countryCode, countryName, scores);
		
	}
	
}
