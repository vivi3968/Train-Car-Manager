/* Vivian Lam
 * ID: 111549991
 * vivian.lam@stonybrook.edu
 * Homework 2
 * CSE214, R11 (Reed Gantz)
 */ 

/**
 *  TrainCar which contains a length in meters, a weight in tons, and a load reference (ProductLoad). 
 *  The load variable of the train may be null, which indicates that the train car is empty and contains no product.
 */
public class TrainCar extends ProductLoad {
	
	private double carLength;
	private double carWeight;
	private ProductLoad load;
	
	/**
	 * Constructor for TrainCar
	 */
	public TrainCar() {
		
	}
	
	/**
	 * Constructor for TrainCar with parameters
	 * 
	 * @param carLength length in meters
	 * @param carWeight weight in tons
	 */
	public TrainCar(double carLength, double carWeight) {
		this.carLength = carLength;
		this.carWeight = carWeight;
	}
	
	/**
	 * Accessor method for car length
	 * @return length of car
	 */
	public double getCarLength() {
		return carLength;
	}
	
	/**
	 * Accessor method for car weight
	 * @return weight of car
	 */
	public double getCarWeight() {
		return carWeight;
	}
	
	/**
	 * Accessor method for ProductLoad
	 * @return ProductLoad
	 */
	public ProductLoad getProductLoad() {
		return load;
	}
	
	/**
	 * Mutator method for ProductLoad
	 * @param load 
	 */
	public void setProductLoad(ProductLoad load) {
		this.load = load;
	}
	
	/**
	 * Checks if TrainCar is empty
	 * @return true if empty, false otherwise
	 */
	public boolean isEmpty() {
		if (load != null)
			return false;
		else
			return true;
	}
}
