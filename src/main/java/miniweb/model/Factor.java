package miniweb.model;

public class Factor {
	
	private String label;
	private double value;
	
	public Factor(String label, double value) {
		this.label = label;
		this.value = value;
	}
	
	public String getLabel() {
		return this.label;
	}
	
	public double getValue() {
		return this.value;
	}
	
	public void setLabel(String label) {
		this.label = label;
	}
	
	public void setValue(double value) {
		this.value = value;
	}
}
