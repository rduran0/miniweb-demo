package miniweb.dao;

import javax.sql.DataSource;

import miniweb.model.CountryFactors;

public interface CountryFactorsDAO {

	public void setDataSource(DataSource dataSource);
	public CountryFactors getCountryFactors(String code);
	
}
