package miniweb.mapper;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import miniweb.model.Factor;
import miniweb.utils.Constants;

public class FactorsMapper implements RowMapper<List<Factor>>{
	
	public List<Factor> mapRow(ResultSet rs, int rowNumb) throws SQLException {
		List<Factor> factors = new ArrayList<Factor>();
		
		factors.add(new Factor(Constants.FACTOR_GOV_POWER, rs.getDouble(Constants.GOV_POWERS)));
		factors.add(new Factor(Constants.FACTOR_ABS_CORRUPT, rs.getDouble(Constants.ABS_CORRUPT)));
		factors.add(new Factor(Constants.FACTOR_CIV_JUSTICE, rs.getDouble(Constants.CIVIL_JUSTICE)));
		factors.add(new Factor(Constants.FACTOR_CRIM_JUSTICE, rs.getDouble(Constants.CRIMINAL_JUSTICE)));
		factors.add(new Factor(Constants.FACTOR_REG_ENFORCE, rs.getDouble(Constants.REGULATORY_ENFORCEMENT)));
		factors.add(new Factor(Constants.FACTOR_OPEN_GOV, rs.getDouble(Constants.OPEN_GOV)));
		factors.add(new Factor(Constants.FACTOR_ORDER_SECURE, rs.getDouble(Constants.ORDER_SECUR)));
		factors.add(new Factor(Constants.FACTOR_FUND_RIGHTS, rs.getDouble(Constants.FUND_RIGHTS)));
		
		return factors;
	}

}
