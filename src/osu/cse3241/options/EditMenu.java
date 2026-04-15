package osu.cse3241.options;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import osu.cse3241.sql.SQL;
import osu.cse3241.utilities.Utilities;

public class EditMenu {
	
	private static final Set<Character> MENU_OPTIONS = new HashSet<>(Arrays.asList('1', '2', '3', '4', '5', '6', 'x'));
	
	public static void menu(Scanner cin) {
		Utilities.printDivider();
		System.out.print("EDIT MENU:\n"
				+ "1. Add Customer\n"
				+ "2. Delete Customer\n"
				+ "3. Update Customer\n"
				+ "4. Add Robot\n"
				+ "5. Delete Robot\n"
				+ "6. Update Robot\n"
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
				addCustomer(cin);
				break;
			case '2':
				deleteCustomer(cin);
				break;
			case '3':
				updateCustomer(cin);
				break;
			case '4':
				addRobot(cin);
				break;
			case '5':
				deleteRobot(cin);
				break;
			case '6':
				updateRobot(cin);
				break;
			default:
				break;
		}
	}



	

	/* 
	 * Edit menu functions that adds, updates, or deletes records from the Customer
	 * or the Robot tables
	 */
	
	
	private static void addCustomer(Scanner cin) {
		Utilities.placeholder();
		
		System.out.println("Input Customer ID: ");
		String customer_id = cin.nextLine();
		System.out.println("Input customer's Facility ID: ");
		String facility_id = cin.nextLine();
		System.out.print("Input customer first name: ");
		String Fname = cin.nextLine();
		System.out.print("Input customer last name: ");
		String Lname = cin.nextLine();
		System.out.println("Address: ");
		String address = cin.nextLine();
		System.out.println("Input customer phone number: ");
		String phone_number = cin.nextLine();
		System.out.println("Input customer email: ");
		String email = cin.nextLine();
		System.out.println("Start date: ");
		String start_date = cin.nextLine();
		System.out.println("Facility Distance");
		String facility_distance = cin.nextLine();
		System.out.println("Active Status: ");
		Boolean active_status = cin.nextBoolean();


		String sql = "INSERT INTO CUSTOMER (CustomerID, FacilityID, FirstName, LastName, Address, Phone, Email, StartDate, FacilityDistance, ActiveStatus) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
		SQL.ps_addCustomer(sql, customer_id, facility_id, Fname, Lname, address, phone_number, email, start_date, facility_distance, active_status);


	}

	private static void deleteCustomer(Scanner cin) {
		Utilities.placeholder();
		System.out.println("Input Customer ID: ");
		String customer_id = cin.nextLine();


		String sql = "DELETE FROM CUSTOMER WHERE CustomerID = ?;";
		SQL.ps_deleteCustomer(sql, customer_id);

	}

	private static void updateCustomer(Scanner cin) {
		Utilities.placeholder();
		System.out.println("Input Customer ID: ");
		String customer_id = cin.nextLine();
		System.out.println("Input new phone number: ");
		String phone_number = cin.nextLine();
		System.out.println("Input new email: ");
		String email = cin.nextLine();
		System.out.println("Input new address: ");
		String address = cin.nextLine();
		System.out.println("Input new Active Status: ");
		Boolean active_status = cin.nextBoolean();


		String sql = "UPDATE CUSTOMER SET Phone = ?, Email = ?, Address = ?, ActiveStatus = ? WHERE CustomerID = ?;";
		SQL.ps_updateCustomer(sql, phone_number, email, address, active_status, customer_id);


	}

	private static void addRobot(Scanner cin) {
		Utilities.placeholder();
		System.out.println("Input Robot ID: ");
		String robot_id = cin.nextLine();
		System.out.println("Input robot's Manufacturer ID: ");
		String manufacturer_id = cin.nextLine();
		System.out.println("Input robot name: ");
		String robot_name = cin.nextLine();
		System.out.println("Input robot model: ");
		String robot_model = cin.nextLine();
		System.out.println("Input robot SerialNumber: ");
		String serial_number = cin.nextLine();
		System.out.println("Input robot's status: ");
		String status = cin.nextLine();
		System.out.println("Input robot's Warehouse: ");
		String warehouse = cin.nextLine();
		System.out.println("Input robot's year: ");
		String year = cin.nextLine();
		System.out.println("Input robot's Battery Autonomy: ");
		String battery_autonomy = cin.nextLine();
		System.out.println("Input robot's sensor suite: ");
		String sensor_suite = cin.nextLine();
		System.out.println("Input robot's Function: ");
		String function = cin.nextLine();
		System.out.println("Input robot's Training level: ");
		String training_level = cin.nextLine();
		System.out.println("Input robot's Warranty date: ");
		String warranty_date = cin.nextLine();


		String sql = "INSERT INTO ROBOT (RobotID, ManufacturerID, Name, Model, SerialNumber, Status, Warehouse, Year, BatteryAutonomy, SensorSuite, Function, TrainingLevel, WarrantyDate) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
		SQL.ps_addRobot(sql, robot_id, manufacturer_id, robot_name, robot_model, serial_number, status, warehouse, year, battery_autonomy, sensor_suite, function, training_level, warranty_date);

	}

	private static void deleteRobot(Scanner cin) {
		Utilities.placeholder();
	}

	private static void updateRobot(Scanner cin) {
		Utilities.placeholder();
	}
	
}
