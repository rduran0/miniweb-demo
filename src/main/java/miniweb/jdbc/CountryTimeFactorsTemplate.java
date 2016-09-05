package miniweb.jdbc;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import miniweb.dao.CountryTimeFactorsDAO;
import miniweb.mapper.CountryMapper;
import miniweb.mapper.YearlyFactorsMapper;
import miniweb.model.CountryFactorTime;
import miniweb.model.Country;
import miniweb.model.YearlyFactors;

public class CountryTimeFactorsTemplate implements CountryTimeFactorsDAO {
	
	private JdbcTemplate factorsTemplate;
	
	public void setDataSource(DataSource dataSource) {
		factorsTemplate = new JdbcTemplate(dataSource);
	}
	
	public CountryFactorTime getFactorsOverTime(String countryCode) {
		
		String sqlCountry = "SELECT C.country_code AS ccode, C.country_name AS cname, IG.income_group_code AS igCode, IG.income_group_name AS igName "
				+ "FROM countries AS C, income_group AS IG "
				+ "WHERE C.country_code = ? AND C.income_group_id = IG.id";
		
		String sqlFactors = "SELECT GPW.score_2013 govPower2013, GPW.score_2014 govPower2014, GPW.score_2015 govPower2015, "
				+ "CVJ.score_2013 civJust2013, CVJ.score_2014 civJust2014, CVJ.score_2015 civJust2015, "
				+ "CRJ.score_2013 crimJust2013, CRJ.score_2014 crimJust2014, CRJ.score_2015 crimJust2015, "
				+ "REG.score_2013 regEnforce2013, REG.score_2014 regEnforce2014, REG.score_2015 regEnforce2015, "
				+ "OPG.score_2013 opGov2013, OPG.score_2014 opGov2014, OPG.score_2015 opGov2015, "
				+ "SEC.score_2013 ordSecurity2013, SEC.score_2014 ordSecurity2014, SEC.score_2015 ordSecurity2015, "
				+ "COR.score_2013 absCorrupt2013, COR.score_2014 absCorrupt2014, COR.score_2015 absCorrupt2015, "
				+ "FUN.score_2013 fundRights2013, FUN.score_2014 fundRights2014, FUN.score_2015 fundRights2015 "
				+ "FROM countries AS C, constraints_gov_power AS GPW, civil_justice AS CVJ, criminal_justice AS CRJ, regulatory_enforcement AS REG, "
				+ "open_gov AS OPG, order_security AS SEC, absence_corruption AS COR, fundamental_rights AS FUN "
				+ "WHERE C.country_code = ? AND C.id = GPW.country_id AND C.id = CVJ.country_id AND C.id = CRJ.country_id AND C.id = REG.country_id AND C.id = OPG.country_id "
				+ "AND C.id = SEC.country_id AND C.id = COR.country_id AND C.id = FUN.country_id";
		
		Country country = this.factorsTemplate
		.queryForObject(sqlCountry, new Object[]{countryCode}, new CountryMapper());
		
		List<YearlyFactors> recordFactors = this.factorsTemplate
				.queryForObject(sqlFactors, new Object[]{countryCode}, new YearlyFactorsMapper());
		
		return new CountryFactorTime(country, recordFactors);
	}

}
