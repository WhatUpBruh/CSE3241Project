package osu.cse3241.options;

import java.util.Scanner;
import osu.cse3241.utilities.Utilities;

public class GenerateReports {

	//TODO
	//THIS IMPLEMENTATION IS WRONG. PLEASE DO THE PROPER IMPLEMENTATION. 
	
	public static void menu(Scanner cin) {
		Utilities.printDivider();
		System.out.print("SEARCH RECORD STOCK COUNT:\n"
				+ "Input album name (or 'x' to quit): ");
		String album_name = cin.nextLine();
		
		if (!"x".equals(album_name) && !album_name.trim().isEmpty()) {
		    searchRecordStockCount();
		}
	}


	
	/**
	 * Search record stock count by album name.
	 */
	private static void searchRecordStockCount() {
		Utilities.placeholder();
		/* TODO */
	}
	
}
