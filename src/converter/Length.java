package converter;

public enum Length implements Unit{
	METER("Meter", 1),
	
	KILOMETER("Kilometer", 1000.0),
	
	CENTIMETER("Centimeter", 0.01),
	
	MILE("Mile", 1609.344),
	
	FOOT("Foot", 0.3048),
	
	WA("Wa", 2)
	;
	
	
	private String name;
	private double value;
	
	private Length(String name, double value){
		this.name = name;
		this.value = value;
	}
	
	public double getValue(){
		return value;
	}
	
	public String toString(){
		return name;
	}
}
