package osu.cse3241.options;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import osu.cse3241.sql.SQL;
import osu.cse3241.utilities.Utilities;

public class TransactionMenu {
    private static final Set<Character> MENU_OPTIONS = new HashSet<>(Arrays.asList('1', '2', '3', '4', '5', '6', 'x'));
	
	public static void menu(Scanner cin) {
		Utilities.printDivider();
		System.out.print("EDIT MENU:\n"
				+ "1. Rent Robots\n"
				+ "2. Return Equipment\n"
				+ "3. Delivery of Robots\n"
				+ "4. Pick up of Robots\n"
				+ "Input numerical selection (or 'x' to quit): ");
		String input = cin.nextLine();
		char selection = !input.isEmpty() ? input.charAt(0) : ' ';		
		
		while(!MENU_OPTIONS.contains(selection)) {
			System.out.print("Incorrect option specified! Try again: ");
			input = cin.nextLine();
			selection = !input.isEmpty() ? input.charAt(0) : ' ';
		}

		switch(selection) {
			case '1':
				rentRobots(cin);
				break;
			case '2':
				rentEquipment(cin);
				break;
			case '3':
				deliveryOfRobots(cin);
				break;
			case '4':
				pickUpOfRobots(cin);
				break;
			default:
				break;
		}
	}



	

	/* 
	 * Edit menu functions that adds, updates, or deletes records from the Customer
	 * or the Robot tables
	 */
	
	

    private static void rentRobots(Scanner cin) {
		Utilities.placeholder();

		System.out.print("Enter Customer ID: ");
		int customerId = cin.nextInt();

		System.out.print("Enter Robot ID: ");
		int robotId = cin.nextInt();

		System.out.print("Enter Car ID for dispatch: ");
		int carId = cin.nextInt();

		java.sql.Date checkoutDate = new java.sql.Date(System.currentTimeMillis());
		java.sql.Date dueDate = java.sql.Date.valueOf("2026-12-31"); 

		SQL.rentRobotTransaction(customerId, robotId, carId, checkoutDate, dueDate);


		
	}

    

    private static void rentEquipment(Scanner cin) {
        Utilities.placeholder();
		System.out.print("Enter Rental ID: ");
		int rentalId = cin.nextInt();

		System.out.print("Enter Car ID for pickup: ");
		int carId = cin.nextInt();

		// java.sql.Date checkoutDate = new java.sql.Date(System.currentTimeMillis());
		// java.sql.Date dueDate = java.sql.Date.valueOf("2026-12-31");

		SQL.returnEquipmentTransaction(rentalId, carId);
    }   

    private static void deliveryOfRobots(Scanner cin) {
        Utilities.placeholder();
		System.out.print("Enter Rental ID: ");
		int rentalId = cin.nextInt();

		System.out.print("Enter Car ID for delivery: ");
		int carId = cin.nextInt();

		SQL.deliveryOfRobotsTransaction(rentalId, carId);
    }

    private static void pickUpOfRobots(Scanner cin) {
        Utilities.placeholder();
		System.out.print("Enter Rental ID: ");
		int rentalId = cin.nextInt();

		System.out.print("Enter Car ID for pickup: ");
		int carId = cin.nextInt();

		SQL.pickupOfRobotsTransaction(rentalId, carId);
    }

}
