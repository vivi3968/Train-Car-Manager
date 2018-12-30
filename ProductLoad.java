/* Vivian Lam
 * ID: 111549991
 * vivian.lam@stonybrook.edu
 * Homework 2
 * CSE214, R11 (Reed Gantz)
 */ 

/**
 * class named ProductLoad which contains the product name, it's weight in tons, it's value in dollars, and whether the product is dangerous or not . 
 * The mutator methods for weight and value should throw exceptions for illegal arguments (i.e. negative values). 
 */
public class ProductLoad {
	
	private String name;
	private double weight;
	private double value;
	private boolean isDangerous;
	
	/**
	 * Constructor for ProductLoad
	 */
	public ProductLoad() {
		
	}
	
	/**
	 * Constructor for ProductLoad with parameters
	 * @param name product name
	 * @param weight weight on product in tons
	 * @param value value of products in dollars
	 * @param isDangerous whether the product is dangerous or not
	 */
	public ProductLoad(String name, double weight, double value, boolean isDangerous) {
		this.name = name;
		this.weight = weight;
		this.value = value;
		this.isDangerous = isDangerous;
	}
	
	/**
	 * Accessor method for product name
	 * 
	 * @return product name
	 */
	public String getProductName() {
		return name;
	}
	
	/**
	 * Mutator method for product name
	 * 
	 * @param name sets name of product
	 */
	public void setProductName(String name) {
		this.name = name;
	}
	
	/**
	 * Accessor method for product weight 
	 * 
	 * @return product weight
	 */
	public double getWeight() {
		return weight;
	}
	
	/**
	 * Mutator method for product weight
	 * 
	 * @param weight weight of product
	 * @throws IllegalArgumentException if weight is negative
	 */
	public void setWeight(double weight) throws IllegalArgumentException {
		if (weight < 0) 
			throw new IllegalArgumentException("Weight cannot be negative.");
		else
			this.weight = weight;
	}
	
	/**
	 * Accessor method for product value
	 * 
	 * @return value of product
	 */
	public double getValue() {
		return value;
	}
	
	/**
	 * Mutator method for product value
	 * 
	 * @param value value of product
	 * @throws IllegalArgumentException if value is negative
	 */
	public void setValue(double value) throws IllegalArgumentException {
		if (value < 0) 
			throw new IllegalArgumentException("Value in dollars cannot be negative.");
		else
			this.value = value;
	}
	
	/**
	 * Accessor method for danger
	 * 
	 * @return whether product is dangerous or not
	 */
	public boolean getDanger() {
		return isDangerous;
	}
	
	/**
	 * Mutator method for danger
	 * 
	 * @param isDangerous
	 */
	public void setDanger(boolean isDangerous) {
		this.isDangerous = isDangerous; 
	}
	
	
}
