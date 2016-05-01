package converter;

public enum Weight implements Unit {
	GRAM(1, "Gram"),
	
	KILOGRAM(1000, "Kilogram"),
	
	TON(1000000, "Ton"),
	
	POUNDS(453.592, "Pounds"),
	
	GVIAN(1000000, "Gvian");
	
	private String name;
	private double value;
	
	private Weight(double value, String name) {
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
