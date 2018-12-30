/**
 *  TrainCar which contains a length in meters, a weight in tons, and a load reference (ProductLoad). 
 *  The load variable of the train may be null, which indicates that the train car is empty and contains no product.
 */
public class TrainCar extends ProductLoad {
	
	private double carLength;
	private double carWeight;
	private ProductLoad load;
	
	public TrainCar() {
		
	}
	
	/**
	 * @param carLength length in meters
	 * @param carWeight weight in tons
	 */
	public TrainCar(double carLength, double carWeight) {
		this.carLength = carLength;
		this.carWeight = carWeight;
	}
	
	/**
	 * @return length of car
	 */
	public double getCarLength() {
		return carLength;
	}
	
	/**
	 * @return weight of car
	 */
	public double getCarWeight() {
		return carWeight;
	}
	
	/**
	 * @return ProductLoad
	 */
	public ProductLoad getProductLoad() {
		return load;
	}
	
	/**
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
