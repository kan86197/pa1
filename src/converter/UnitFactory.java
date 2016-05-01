package converter;

import java.util.ArrayList;

public class UnitFactory {
	private static UnitFactory factory = null;
	private UnitType[] unitList;
	
	
	private UnitFactory(){
		this.unitList = UnitType.values();
	}
	public static UnitFactory getInstance(){
		if(factory == null) factory = new UnitFactory();
		return factory;
	}
	public UnitType[] getUnitTypes(){
		return unitList;
	}
}
