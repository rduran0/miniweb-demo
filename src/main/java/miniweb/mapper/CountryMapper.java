package miniweb.mapper;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import miniweb.model.Country;
import miniweb.utils.Constants;

public class CountryMapper implements RowMapper<Country>{
	
	public Country mapRow(ResultSet rs, int rowNumber) throws SQLException {
		Country country = null;
		
		country = new Country(rs.getString(Constants.COUNTRY_CODE),
				rs.getString(Constants.COUNTRY_NAME), 
				rs.getString(Constants.INCOME_GROUP_CODE),
				rs.getString(Constants.INCOME_GROUP_NAME));
		
		return country;
	}
}
