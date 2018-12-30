/**
 * Acts as a node wrapper around a TrainCar object. 
 */
public class TrainCarNode {
	
	private TrainCarNode prev;
	private TrainCarNode next;
	private TrainCar car;
	
	public TrainCarNode() {
		
	}
	
	/**
	 * @param car
	 */
	public TrainCarNode(TrainCar car) {
		this.car = car;
	}
	
	/**
	 * @return node at prev
	 */
	public TrainCarNode getPrev() {
		return prev;
	}
	
	/**
	 * @param prev the node before cursor
	 */
	public void setPrev(TrainCarNode prev) {
		this.prev = prev;
	}
	
	/**
	 * @return node after cursor
	 */
	public TrainCarNode getNext() {
		return next;
	}
	
	/**
	 * @param next the node after cursor
	 */
	public void setNext(TrainCarNode next) {
		this.next = next;
	}
	
	/**
	 * @return TrainCar
	 */
	public TrainCar getCar() {
		return car;
	}
	
	/**
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
