package miniweb.dao;

import javax.sql.DataSource;

import miniweb.model.CountryFactorTime;

public interface CountryTimeFactorsDAO {

	public void setDataSource(DataSource dataSource);
	public CountryFactorTime getFactorsOverTime(String countryCode);
	
}
