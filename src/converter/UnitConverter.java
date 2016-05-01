package converter;
/**
 * Unit converter that can convert a value of a unit to another unit with the same value. 
 * @author Kan Kamalanon
 *
 */
public class UnitConverter {
	
	/**
	 * Use to convert a unit to another unit with the same value
	 * @param amount is the value of the unit we want to convert
	 * @param fromUnit the unit of the value we want to convert
	 * @param toUnit the unit of the value after we converted it
	 * @return the value of the double in new unit
	 */
	public double convert(double amount, Unit fromUnit, Unit toUnit){
		return (amount * fromUnit.getValue()) / toUnit.getValue();
	}
	/**
	 * Call to get the array of all the available units
	 * @return an array of units from the Length enumerator
	 */
	public Unit[] getUnits(){
		return Length.values();
	}
}
