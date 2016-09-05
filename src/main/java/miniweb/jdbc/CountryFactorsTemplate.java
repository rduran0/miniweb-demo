package miniweb.jdbc;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import miniweb.dao.CountryFactorsDAO;
import miniweb.mapper.CountryMapper;
import miniweb.mapper.FactorsMapper;
import miniweb.model.Country;
import miniweb.model.CountryFactors;
import miniweb.model.Factor;

public class CountryFactorsTemplate implements CountryFactorsDAO {
	
	private JdbcTemplate factorsTemplate;
	
	public void setDataSource(DataSource dataSource) {
		factorsTemplate = new JdbcTemplate(dataSource);
	}
	
	public CountryFactors getCountryFactors(String countryCode) {
		
		String sqlCountry = "SELECT C.country_code AS ccode, C.country_name AS cname, IG.income_group_code AS igCode, IG.income_group_name AS igName "
				+ "FROM countries AS C, income_group AS IG "
				+ "WHERE C.country_code = ? AND C.income_group_id = IG.id";
		
		String sqlFactors = "SELECT GPW.score_2015 AS govPower, CVJ.score_2015 AS civJust, CRJ.score_2015 AS crimJust, "
				+ "REG.score_2015 AS regEnforce, OPG.score_2015 AS opGov, SEC.score_2015 AS ordSecurity, "
				+ "COR.score_2015 AS absCorrupt, FUN.score_2015 AS fundRights "
				+ "FROM countries AS C, constraints_gov_power AS GPW, civil_justice AS CVJ, criminal_justice AS CRJ, "
				+ "regulatory_enforcement AS REG, open_gov AS OPG, order_security AS SEC, absence_corruption AS COR, "
				+ "fundamental_rights AS FUN "
				+ "WHERE C.country_code = ? AND C.id = GPW.country_id AND C.id = CVJ.country_id "
				+ "AND C.id = CRJ.country_id AND C.id = REG.country_id AND C.id = OPG.country_id "
				+ "AND C.id = SEC.country_id AND C.id = COR.country_id = FUN.country_id";
		
		
		Country country = this.factorsTemplate
				.queryForObject(sqlCountry, new Object[]{countryCode}, new CountryMapper());
		List<Factor> factors = this.factorsTemplate
				.queryForObject(sqlFactors, new Object[]{countryCode}, new FactorsMapper());
		
		return new CountryFactors(country, factors);
	}

}
