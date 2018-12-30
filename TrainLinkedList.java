/**
 * TrainlinkedList which implements a Double-Linked List ADT. 
 */
public class TrainLinkedList {
	
	TrainCarNode head;
	TrainCarNode tail;
	TrainCarNode cursor;
	int size = 0;
	double totalLength;
	double totalWeight;
	double totalValue;
	boolean isDangerous;
	
	public TrainLinkedList() {
		head = null;
		tail = null;
		cursor = null;
	}
	
	/**
	 * Returns a reference to the TrainCar at the node currently referenced by the cursor.
	 * 
	 * @return the reference to the TrainCar at the node currently referenced by the cursor.
	 */
	public TrainCar getCursorData() {
		if (cursor != null)
			return cursor.getCar();
		return null;
	}
	
	/**
	 * Places car in the node currently referenced by the cursor.
	 * 
	 * @param The cursor node now contains a reference to car as its data.
	 */
	public void setCursorData(TrainCar car) {
		if (cursor != null) {
			car = cursor.getCar();
		}
	}
	
	
	/**
	 * Moves the cursor to point at the next TrainCarNode.
	 */
	public void cursorForward() {
		if (cursor.getNext() == null) {
			System.out.println("No next car, cannot move cursor forward.");
		}
		else if (cursor != null && cursor != tail)
			cursor = cursor.getNext();
		
	}
	
	/**
	 * Moves the cursor to point at the previous TrainCarNode. 
	 */
	public void cursorBackward() {
		if (cursor.getPrev() == null) {
			System.out.println("No previous car, cannot move cursor backward.");
		}
		else if (cursor != null && cursor != head) {
			cursor = cursor.getPrev();
			System.out.println("Cursor moved backward.");
		}
	}
	
	/**
	 * Inserts a car into the train after the cursor position.
	 * 
	 * @param newcar
	 * @throws IllegalArgumentException if newcar is null
	 */
	public void insertAfterCursor(TrainCar newcar) throws IllegalArgumentException {
		
		TrainCarNode newNode = new TrainCarNode(newcar);
		
		if (newcar == null) 
			throw new IllegalArgumentException("NewCar is null");
		
		else if (cursor == null) {
			head  = newNode;
			tail = newNode;
			cursor = newNode;
		}
		
		else if (size == 2 && cursor == head) {
			newNode.setPrev(cursor);
			newNode.setNext(cursor.getNext());
			cursor.getNext().setPrev(newNode);
			cursor.setNext(newNode);
			cursor = newNode;
		}
		
		else if (cursor == tail && cursor != head) {
			newNode.setPrev(cursor);
			cursor.setNext(newNode);
			cursor = newNode;	
			tail = cursor;
		}
		
		else if (cursor != head && cursor != tail) {
			newNode.setPrev(cursor);
			newNode.setNext(cursor.getNext());
			cursor.getNext().setPrev(newNode);
			cursor.setNext(newNode);
			cursor = newNode;

			if (cursor.getNext() == null)
				tail = cursor;
		}
		
		else if (cursor == head && size == 1) {
			cursor.setNext(newNode);
			newNode.setPrev(cursor);
			cursor = newNode;
			tail = cursor;
		}
 			
		
		size++;
		totalLength += newcar.getCarLength();
		totalWeight += newcar.getCarWeight();
		
		if (newcar.getProductLoad().getProductName() != null && newcar.getProductLoad().getDanger() == true) 
			isDangerous = true;	
	}
	
	
	/**
	 * Removes the TrainCarNode referenced by the cursor and returns the TrainCar contained within the node.
	 * 
	 * @return the TrainCar that is removed 
	 */
	public TrainCar removeCursor() {
		if (cursor != null) {
		if (size == 1) {
			TrainCarNode node1  = cursor;
			totalLength -= cursor.getCar().getCarLength();
			totalWeight -= cursor.getCar().getCarWeight();
			totalValue -= cursor.getCar().getProductLoad().getValue();
			head = null;
			tail = null;
			cursor = null;
			size--;
			
			System.out.println("     Name\tWeight (t)\tValue ($)\tDangerous");
			System.out.println("===========================================================");
			if (node1.getCar().getProductLoad().getDanger())
			System.out.println(String.format("%9s\t%-17.1f%-17.2f%-20s", node1.getCar().getProductLoad().getProductName(), node1.getCar().getProductLoad().getWeight(), node1.getCar().getProductLoad().getValue(), "YES"));
			else
				System.out.println(String.format("%9s\t%-17.1f%-17.2f%-20s",node1.getCar().getProductLoad().getProductName(), node1.getCar().getProductLoad().getWeight(), node1.getCar().getProductLoad().getValue(), "NO"));
			
			return null;
		}
		
		else if (size == 2) {
			
			totalLength -= cursor.getCar().getCarLength();
			totalWeight -= cursor.getCar().getCarWeight();
			totalValue -= cursor.getCar().getProductLoad().getValue();
			
			TrainCarNode node = cursor;
			size--;
			
			if (cursor == head) {
				cursor = cursor.getNext();
				head = cursor;
				tail = cursor;
				cursor.setPrev(null);
			}
			
			else if (cursor == tail) {
				cursor = cursor.getPrev();
				head = cursor;
				tail = cursor;
				cursor.setNext(null);
			}
			
			System.out.println("     Name\tWeight (t)\tValue ($)\tDangerous");
			System.out.println("===========================================================");
			if (node.getCar().getProductLoad().getDanger())
			System.out.println(String.format("%9s\t%-17.1f%-17.2f%-20s", node.getCar().getProductLoad().getProductName(), node.getCar().getProductLoad().getWeight(), node.getCar().getProductLoad().getValue(), "YES"));
			else
				System.out.println(String.format("%9s\t%-17.1f%-17.2f%-20s", node.getCar().getProductLoad().getProductName(), node.getCar().getProductLoad().getWeight(), node.getCar().getProductLoad().getValue(), "NO"));
			
			return node.getCar();

		}
		
		else if (cursor == tail && cursor != head) {
			totalLength -= cursor.getCar().getCarLength();
			totalWeight -= cursor.getCar().getCarWeight();
			totalValue -= cursor.getCar().getProductLoad().getValue();
			
			TrainCarNode node = cursor;
			cursor = cursor.getPrev();
			cursor.setNext(null);
			tail = cursor;
			size--;
			
			System.out.println("     Name\tWeight (t)\tValue ($)\tDangerous");
			System.out.println("===========================================================");
			if (node.getCar().getProductLoad().getDanger())
			System.out.println(String.format("%9s\t%-17.1f%-17.2f%-20s", node.getCar().getProductLoad().getProductName(), node.getCar().getProductLoad().getWeight(), node.getCar().getProductLoad().getValue(), "YES"));
			else
				System.out.println(String.format("%9s\t%-17.1f%-17.2f%-20s", node.getCar().getProductLoad().getProductName(), node.getCar().getProductLoad().getWeight(), node.getCar().getProductLoad().getValue(), "NO"));
			return node.getCar();
		}
		
		else if (cursor == head && cursor != tail) {
			totalLength -= cursor.getCar().getCarLength();
			totalWeight -= cursor.getCar().getCarWeight();
			totalValue -= cursor.getCar().getProductLoad().getValue();
			
			TrainCarNode node = cursor;
			cursor = cursor.getNext();
			cursor.setPrev(null);
			head = cursor;
			size--;
			
			System.out.println("     Name\tWeight (t)\tValue ($)\tDangerous");
			System.out.println("===========================================================");
			if (node.getCar().getProductLoad().getDanger())
			System.out.println(String.format("%9s\t%-17.1f%-17.2f%-20s", node.getCar().getProductLoad().getProductName(), node.getCar().getProductLoad().getWeight(), node.getCar().getProductLoad().getValue(), "YES"));
			else
				System.out.println(String.format("%9s\t%-17.1f%-17.2f%-20s", node.getCar().getProductLoad().getProductName(), node.getCar().getProductLoad().getWeight(), node.getCar().getProductLoad().getValue(), "NO"));
			return node.getCar();
		}
		
		else {
			totalLength -= cursor.getCar().getCarLength();
			totalWeight -= cursor.getCar().getCarWeight();
			totalValue -= cursor.getCar().getProductLoad().getValue();
			
			TrainCarNode node = cursor;
			TrainCarNode next = cursor.getNext();
			
			cursor.getPrev().setNext(cursor.getNext());
			cursor.getNext().setPrev(cursor.getPrev());
			cursor = cursor.getNext();
			size--;
			System.out.println("     Name\tWeight (t)\tValue ($)\tDangerous");
			System.out.println("===========================================================");
			if (node.getCar().getProductLoad().getDanger())
			System.out.println(String.format("%9s\t%-17.1f%-17.2f%-20s", node.getCar().getProductLoad().getProductName(), node.getCar().getProductLoad().getWeight(), node.getCar().getProductLoad().getValue(), "YES"));
			else
				System.out.println(String.format("%9s\t%-17.1f%-17.2f%-20s", node.getCar().getProductLoad().getProductName(), node.getCar().getProductLoad().getWeight(), node.getCar().getProductLoad().getValue(), "NO"));
			return node.getCar();
		}
		}
		else {
			System.out.println("Cursor is null");
			return null;
		}
		

	}
	
	/**
	 * Determines the number of TrainCar objects currently on the train.
	 * 
	 * @return The number of TrainCar objects on this train.
	 */
	public int size() {
		return size;
	}
	
	/**
	 * Returns the total length of the train in meters.
	 * 
	 * @return The sum of the lengths of each TrainCar in the train.
	 */
	public double getLength() {
		return totalLength;
	}
	
	/**
	 * Returns the total value of product carried by the train.
	 * 
	 * @return The sum of the values of each TrainCar in the train.
	 */
	public double getValue() {
		return totalValue;
	}
	
	/**
	 * Returns the total weight in tons of the train.
	 * 
	 * @return The sum of the weight of each TrainCar plus the sum of the ProductLoad carried by that car.
	 */
	public double getWeight() {
		return totalWeight;
	}
	
	/**
	 * Whether or not there is a dangerous product on one of the TrainCar objects on the train.
	 * 
	 * @return Returns true if the train contains at least one TrainCar carrying a dangerous ProductLoad, false otherwise.
	 */
	public boolean isDangerous() {
		return isDangerous;
	}
	
	/**
	 * Searches the list for all ProductLoad objects with the indicated name and sums together their weight and value, 
	 * then prints a single ProductLoad record to the console.
	 * 
	 * @param name the name of the ProductLoad to find on the train.
	 */
	public void findProduct(String name) {
		TrainCarNode node = cursor;
		cursor = head;
		double productWeight = 0;		
		double productValue = 0;
		
		int count = 1;
		int a = 0;
		boolean danger = false;
		
		while (count <= size) {
			String str = cursor.getCar().getProductLoad().getProductName();
			if (str == null) {
				
			}
			else if (str.equals(name)) {
				productWeight += cursor.getCar().getProductLoad().getWeight();
				productValue +=  cursor.getCar().getProductLoad().getValue();
				a++;
				if (cursor.getCar().getProductLoad().getDanger() == true)
					danger = true;
			}
				
			count++;
			cursor = cursor.getNext();
		}
		if (a == 0)
			System.out.println("No record of " + name + " on board train");
		else {
			System.out.println("The following products were found on " + a + " cars");
			System.out.println("     Name\tWeight (t)\tValue ($)\tDangerous");
			System.out.println("===========================================================");
			if (danger)
			System.out.println(String.format("%9s\t%-17.1f%-17.2f%-20s", name, productWeight, productValue, "YES"));
			else
				System.out.println(String.format("%9s\t%-17.1f%-17.2f%-20s", name, productWeight, productValue, "NO"));

		}
		
		cursor = node;

	}
	
	/**
	 * Prints a neatly formatted table of the car number, car length, car weight, load name, load weight, load value, 
	 * and load dangerousness for all of the car on the train.
	 */
	public void printManifest() {
		toString();
	}
	
	/**
	 * Removes all dangerous cars from the train, maintaining the order of the cars in the train.
	 */
	public void removeDangerousCars() {
		if (cursor != null) {
		TrainCarNode node = cursor;
		cursor = head;
		int count = 1;
		if (size == 1 && cursor.getCar().getProductLoad().getDanger()) {
			removeCursor();
		}
		
		else {
			while (count <= size && cursor.getNext() != null) {
				if (cursor.getCar().getProductLoad().getDanger() == true) {
					removeCursor();
					cursor = cursor.getNext();
				}
				else {
					cursor = cursor.getNext();
				}
				count++;
			}
			}
		cursor = node;
		}
		else {
			System.out.println("Cursor is null.");
		}
	}
	
	/** 
	 * Returns a neatly formatted String representation of the train.
	 */
	public String toString() {
		int count = 1;
		TrainCarNode node = cursor;
		cursor = head;
		String str;
		TrainCarNode search = head;
		System.out.println("CAR:\t\t\t\t\t\tLOAD:");
		System.out.println("\tNum\tLength (m)\tWeight (t)\t|\tName\tWeight (t)\tValue ($)\tDangerous");
		System.out.println("================================================+=========================================================");
		while (count <= size && cursor != null) {
			if (cursor == node) {
				System.out.print("->");
			}
			if (cursor.getCar().getProductLoad().getProductName() != null) {
				if (cursor.getCar().getProductLoad().getDanger() == true)
					System.out.println(String.format("\t%-10d%-15.1f%-23.1f%-10s%-15.1f%-15.2f%-16s", count, cursor.getCar().getCarLength(),
							cursor.getCar().getCarWeight(), cursor.getCar().getProductLoad().getProductName(), cursor.getCar().getProductLoad().getWeight(),
							cursor.getCar().getProductLoad().getValue(), "YES"));
				else if (cursor.getCar().getProductLoad().getDanger() == false)
					System.out.println(String.format("\t%-10d%-15.1f%-23.1f%-10s%-15.1f%-15.2f%-16s", count, cursor.getCar().getCarLength(),
						cursor.getCar().getCarWeight(), cursor.getCar().getProductLoad().getProductName(), cursor.getCar().getProductLoad().getWeight(),
						cursor.getCar().getProductLoad().getValue(), "NO"));
		
		}
			else
				System.out.println(String.format("\t%-10d%-15.1f%-23.1f%-10s%-15.1f%-15.2f%-16s", count, cursor.getCar().getCarLength(), 
					cursor.getCar().getCarWeight(), "Empty", 0.0, 0.00, "NO"));
		
			count++;
			cursor = cursor.getNext();
	}
		cursor  = node;
		return "";
	}
		
}
