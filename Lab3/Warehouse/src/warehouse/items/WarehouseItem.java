package warehouse.items;

public abstract class WarehouseItem implements Comparable<WarehouseItem>{
	
	// Class attributes
	protected String name;
	protected double weight;
	
	// Constructor
	public WarehouseItem(double weight, String name) {
		setName(name);
		setWeight(weight);
	}
	
	// Must implement `compareTo` to satisfy 
	// interface contract.
	@Override
	public int compareTo(WarehouseItem item) {
		
		int result = 0; // Implicit equal
		double comparedWeight = item.getWeight();
		
		if (weight < comparedWeight) result = -1; // Less than
		if (weight > comparedWeight) result = 1; // Greater than
		
		return result;
	}
	
	
	// Accessors and Modifiers
	// -----------------------
	
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
