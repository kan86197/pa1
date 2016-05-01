package converter;

public enum Area implements Unit {
	
	SQUAREMETER(1.0, "Square Meter"),
	
	SQUAREKILOMETER(1000000.0, "Square Kilometer"),
	
	SQUARECENTIMETER(0.0001, "Square Centimeter"),
	
	HECTARE(10000.0, "Hectare"),
	
	SQUAREMILE(2589990.0, "Square Mile"),
	
	SQUAREWA(4.0, "Square Wa")
	;
	
	private double value;
	private String name;
	
	private Area(double value, String name) {
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
