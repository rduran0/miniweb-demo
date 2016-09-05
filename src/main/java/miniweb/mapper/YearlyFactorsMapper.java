package miniweb.mapper;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import miniweb.model.Factor;
import miniweb.model.YearlyFactors;
import miniweb.utils.Constants;

public class YearlyFactorsMapper implements RowMapper<List<YearlyFactors>> {
	
	public List<YearlyFactors> mapRow(ResultSet rs, int rowNumb) throws SQLException {
		List<YearlyFactors> recordedFactors = new ArrayList<YearlyFactors>();
		List<Factor> factors;
		
		String[] years = new String[] {"2013", "2014", "2015"};
		
		for(int i = 0; i < 3; i++) {
			factors = new ArrayList<Factor>();
			
			factors.add(new Factor(Constants.FACTOR_ABS_CORRUPT, 
					rs.getDouble(Constants.ABS_CORRUPT + years[i])));
			factors.add(new Factor(Constants.FACTOR_CIV_JUSTICE, 
					rs.getDouble(Constants.CIVIL_JUSTICE + years[i])));
			factors.add(new Factor(Constants.FACTOR_CRIM_JUSTICE, 
					rs.getDouble(Constants.CRIMINAL_JUSTICE + years[i])));
			factors.add(new Factor(Constants.FACTOR_FUND_RIGHTS, 
					rs.getDouble(Constants.FUND_RIGHTS + years[i])));
			factors.add(new Factor(Constants.FACTOR_GOV_POWER, 
					rs.getDouble(Constants.GOV_POWERS + years[i])));
			factors.add(new Factor(Constants.FACTOR_OPEN_GOV, 
					rs.getDouble(Constants.OPEN_GOV + years[i])));
			factors.add(new Factor(Constants.FACTOR_ORDER_SECURE, 
					rs.getDouble(Constants.ORDER_SECUR + years[i])));
			factors.add(new Factor(Constants.FACTOR_REG_ENFORCE, 
					rs.getDouble(Constants.REGULATORY_ENFORCEMENT + years[i])));
			
			recordedFactors.add(new YearlyFactors(years[i], factors));
		}
		
		
		return recordedFactors;
	}

}
