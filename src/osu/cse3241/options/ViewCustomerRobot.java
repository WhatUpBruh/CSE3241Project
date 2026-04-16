package osu.cse3241.options;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import osu.cse3241.GRS;
import osu.cse3241.sql.SQL;
import osu.cse3241.utilities.Utilities;

public class ViewCustomerRobot {
	
	private static Set<Character> MENU_OPTIONS = new HashSet<>(Arrays.asList('1', '2', 'x'));
	
	public static void menu(Scanner cin) {
		Utilities.printDivider();
		System.out.print("VIEW ALL:\n"
				+ "1. Customer\n"
				+ "2. Robot\n"
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
				viewCustomer();
				break;
			case '2':
				viewRobots();
				break;
			default:
				break;
		}
	}
	
	/*
	 * PART 4:
	 * Remove the placeholder method and complete one of the following methods:
	 * 	
	 * 	viewTracks()
	 * 	viewArtists()
	 * 
	 */
	
	/**
	 * Query all customers contained in database.
	 */
	private static void viewCustomer() {
		Utilities.placeholder();
		/* TODO
		String sql = null; 
		SQL.sqlQuery(GRS.conn, sql);
		*/
		String sql = "SELECT * FROM CUSTOMER;";
		SQL.sqlQuery(GRS.conn, sql);	
	}
	
	/**
	 * Query all robots contained in database.
	 */
	private static void viewRobots() {
		Utilities.placeholder();
		
		String sql = "SELECT * FROM ROBOT;";
		SQL.sqlQuery(GRS.conn, sql);
	}
	
}
