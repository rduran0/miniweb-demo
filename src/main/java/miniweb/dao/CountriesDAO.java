package miniweb.dao;

import java.util.List;

import javax.sql.DataSource;

import miniweb.model.Country;

public interface CountriesDAO {

	public void setDataSource(DataSource dataSource);
	public List<Country> getAllCountries();
	
}
