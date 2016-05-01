package converter;

public enum UnitType {
	LENGTH(Length.values()),
	AREA(Area.values()),
	VOLUME(Volume.values()),
	WEIGTH(Weight.values());
	
	
	private Unit[] u;
	private UnitType(Unit[] u) {
		this.u = u;
	}
	
	public Unit[] getValue(){
		return u;
	}
}
