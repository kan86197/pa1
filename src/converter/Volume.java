package converter;

public enum Volume implements Unit {
	CUBICMETER(1, "Cubic Meter"),
	
	CUBICKILOMETER(1000000000, "Cubic Kilometer"),
	
	LITER(0.001, "Liter"),
	
	IMPERIALGALLON(0.00454609, "Imperial Gallon"),

	//2000 liter
	GVIAN(2, "Gvian");
	
	private double value;
	private String name;
	
	private Volume(double value, String name){
		this.value = value;
		this.name = name;
	}
	
	public double getValue(){
		return value;
	}
	
	public String toString(){
		return name;
	}
}
