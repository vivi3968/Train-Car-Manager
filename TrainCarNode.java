/* Vivian Lam
 * ID: 111549991
 * vivian.lam@stonybrook.edu
 * Homework 2
 * CSE214, R11 (Reed Gantz)
 */ 

/**
 * Acts as a node wrapper around a TrainCar object. 
 *
 */
public class TrainCarNode {
	
	private TrainCarNode prev;
	private TrainCarNode next;
	private TrainCar car;
	
	/**
	 * Constructor for TrainCarNode
	 */
	public TrainCarNode() {
		
	}
	
	/**
	 * Constructor for TrainCarNode with parameters
	 * 
	 * @param car
	 */
	public TrainCarNode(TrainCar car) {
		this.car = car;
	}
	
	/**
	 * Accessor method for TrainCarNode before cursor
	 * 
	 * @return node at prev
	 */
	public TrainCarNode getPrev() {
		return prev;
	}
	
	/**
	 * Mutator method for TrainCarNode before cursor
	 * 
	 * @param prev the node before cursor
	 */
	public void setPrev(TrainCarNode prev) {
		this.prev = prev;
	}
	
	/**
	 * Accessor method for node after cursor
	 * @return node after cursor
	 */
	public TrainCarNode getNext() {
		return next;
	}
	
	/**
	 * Mutator method for TrainCarNode after cursor
	 * 
	 * @param next the node after cursor
	 */
	public void setNext(TrainCarNode next) {
		this.next = next;
	}
	
	/**
	 * Accessor Method for TrainCar
	 * @return TrainCar
	 */
	public TrainCar getCar() {
		return car;
	}
	
	/**
	 * Mutator Method for TrainCar
	 * @param car
	 */
	public void setCar(TrainCar car) {
		this.car = car;
	}
	
	/**
	 * toString method
	 */
	public String toString() {
		String str = "";
		str += "Car Length: ";
		str += car.getCarLength();
		str += "Car Weight: ";
		str += car.getCarWeight();
		str += "Product name: ";
		str += car.getProductLoad().getProductName();
		str += "Product Weight: ";
		str += car.getProductLoad().getWeight();
		str += "Product Value: ";
		str += car.getProductLoad().getValue();
		return str;
	}
}
