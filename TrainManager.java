import java.util.Scanner;

public class TrainManager {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		TrainCar car = new TrainCar();
		ProductLoad load = new ProductLoad();
		car.setProductLoad(load);
		TrainCarNode node;
		TrainLinkedList linkedList = new TrainLinkedList();
		String letter;
		
		
		do {
			input = new Scanner(System.in);
					
			System.out.println("(F) Cursor Forward");
			System.out.println("(B) Cursor Backward");
			System.out.println("(I) Insert Car After Cursor");
			System.out.println("(R) Remove Car At Cursor");
			System.out.println("(L) Set Product Load");
			System.out.println("(S) Search for Product");
			System.out.println("(T) Display Train");
			System.out.println("(M) Display Manifest");
			System.out.println("(D) Remove Dangerous Cars");
			System.out.println("(Q) Quit");
			
			System.out.println();
			System.out.print("Enter a selection: ");

			letter = input.nextLine();
			letter = letter.toUpperCase();
			
			if (letter.equals("F")) {
				System.out.println();
				linkedList.cursorForward();
				System.out.println();
			}
			
			else if (letter.equals("B"))  {
				System.out.println();
				linkedList.cursorBackward();
				System.out.println();
			}
			
			else if (letter.equals("I")) {
				System.out.println();
				System.out.print("Enter car length in meters: ");
				double length = input.nextDouble();
				System.out.print("Enter car weight in tons: ");
				double weight = input.nextDouble();
				
				if (length >= 0 && weight >= 0) {
					car = new TrainCar(length, weight);
					car.setProductLoad(load);
					linkedList.insertAfterCursor(car);
					System.out.println();
	
					System.out.println("New train car " + length + " meters " + weight + " tons inserted into train.");
					System.out.println();
				}
				
				else {
					System.out.println("Input cannot be negative");
				}
			}
			
			else if (letter.equals("R")) {
				if (linkedList.cursor != null) {
				System.out.println();
				linkedList.removeCursor();
				System.out.println("Car succesfully unlinked. The following load has been removed from the train.");
				System.out.println();
				}
				else {
					System.out.println();
					System.out.println("Cursor is null");
					System.out.println();

				}

			}
			
			else if (letter.equals("L")) {
				System.out.println();
				System.out.print("Enter product name: ");
				String name = input.next();
				System.out.print("Enter product weight in tons: ");
				double productWeight = input.nextDouble();
				System.out.print("Enter product value in dollars: ");
				double productValue = input.nextDouble();
				System.out.print("Enter is product dangerous (y/n): ");
				String danger = input.next().toLowerCase();
				
				if (danger.equals("y")) {
					load = new ProductLoad(name, productWeight, productValue, true);
				}
				
				else if (danger.equals("n")) {
					load = new ProductLoad(name, productWeight, productValue, false);
				}
				
				car.setProductLoad(load);
				System.out.println();
				System.out.println(productWeight + " tons of " + name + " added to the current car");
				load = new ProductLoad();
				System.out.println();
			}
			
			else if (letter.equals("S")) {
				System.out.println();
				System.out.print("Enter product name: ");
				String name = input.nextLine();
				System.out.println();
				linkedList.findProduct(name);
				System.out.println();

			}
			
			else if (letter.equals("T")) {
				System.out.println();
				double tot = 0;
				double total1 = 0;
				
				TrainCarNode node1 = linkedList.cursor;
				linkedList.cursor = linkedList.head;
				
				for (int i = 1; i <= linkedList.size; i++) {
					tot += linkedList.getCursorData().getProductLoad().getValue();
					total1 += linkedList.getCursorData().getProductLoad().getWeight();
					if (linkedList.getCursorData().getProductLoad().getDanger()) {
						linkedList.isDangerous = true;
				}
					linkedList.cursor = linkedList.cursor.getNext();
				}

				if (linkedList.isDangerous) {
					System.out.println("Train: " + linkedList.size + " cars, " +  linkedList.totalLength + " meters, " + (total1 + linkedList.totalWeight) + " tons, $" + tot + " value, DANGEROUS");
				}
				
				else 
				System.out.println("Train: " + linkedList.size + " cars, " +  linkedList.totalLength + " meters, " + (total1 + linkedList.totalWeight) + " tons, $" + tot + ", NOT DANGEROUS");
				
				
				linkedList.cursor = node1;
				System.out.println();

			}
			
			else if (letter.equals("M")) {
				System.out.println();
				linkedList.printManifest();
				System.out.println();
			}
			
			else if (letter.equals("D")) {
				if (linkedList.cursor != null) {
					System.out.println();
					linkedList.removeDangerousCars();
					System.out.println();
					System.out.println("Dangerous cars successfully removed from train.");
					System.out.println();
				}
				else {
					System.out.println();
					System.out.println("Cursor is null");
					System.out.println();
				}
				
			}
			else if (letter.equals("Q")) {
				System.out.println();
				System.out.println("Program terminating successfully...");
				System.exit(0);
			}
			
			else {
				System.out.println();
				System.out.println("Invalid input. Try again.");
				System.out.println();
			}
		} while (letter != "Q");
	}

}
