package miniweb.model;

public class Country {
	private String countryCode;
	private String name;
	private String incomeGroupCode;
	private String incomeGroupName;
	
	public Country(String countryCode, String name, String incomeGroupCode, String incomeGroupName) {
		this.countryCode = countryCode;
		this.name = name;
		this.incomeGroupCode = incomeGroupCode;
		this.incomeGroupName = incomeGroupName;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIncomeGroupCode() {
		return incomeGroupCode;
	}

	public void setIncomeGroupCode(String incomeGroupCode) {
		this.incomeGroupCode = incomeGroupCode;
	}

	public String getIncomeGroupName() {
		return incomeGroupName;
	}

	public void setIncomeGroupName(String incomeGroupName) {
		this.incomeGroupName = incomeGroupName;
	}
	
	
}
