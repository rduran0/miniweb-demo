package miniweb.jdbc;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import miniweb.dao.CountriesDAO;
import miniweb.mapper.CountryMapper;
import miniweb.model.Country;

public class CountriesTemplate implements CountriesDAO {
	
	private JdbcTemplate countriesTemplate;
	
	public void setDataSource(DataSource dataSource) {
		this.countriesTemplate = new JdbcTemplate(dataSource);
	}
	
	public List<Country> getAllCountries() {
		
		String sql = "SELECT C.country_code ccode, C.country_name cname, IG.income_group_code igCode, "
				+ "IG.income_group_name igName "
				+ "FROM countries C "
				+ "INNER JOIN income_group IG ON C.income_group_id = IG.id "
				+ "ORDER BY C.country_code";
		
		List<Country> countries = this.countriesTemplate.query(sql, new CountryMapper());
		
		return countries;
		
	}

}
