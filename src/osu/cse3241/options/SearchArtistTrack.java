package osu.cse3241.options;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import osu.cse3241.utilities.Utilities;
import osu.cse3241.sql.SQL;
import osu.cse3241.GRS;

public class SearchArtistTrack {

	private static Set<Character> MENU_OPTIONS = new HashSet<>(Arrays.asList('1', '2', 'x'));
	
	public static void menu(Scanner cin) {
		Utilities.printDivider();
		System.out.print("SEARCH:\n"
				+ "1. Artists\n"
				+ "2. Tracks\n"
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
				searchArtists(cin);
				break;
			case '2':
				searchTracks(cin);
				break;
			default:
				break;
		}
	}

	/*
	 * PART 5:
	 * From the following, complete the method that corresponds
	 * to the approach taken in the prior question and remove its placeholder:
	 * 	
	 * 	searchTracks()
	 * 	searchArtists()
	 * 
	 */
	
	/**
	 * Search tracks in database according to input track name. 
	 * 
	 * @param cin scanner
	 */
	private static void searchTracks(Scanner cin) {
		Utilities.placeholder();

		System.out.println("Input track name (or 'x' to quit): ");
		String track_name = cin.nextLine();
		
		if(!track_name.equals("x") || !track_name.trim().isEmpty()) {
			String sql = "SELECT * FROM Track WHERE track_name LIKE ?;"; 
			SQL.ps_SearchTracks(sql, "%" + track_name + "%");
		}
	}

	/**
	 * Search artists in database according to input artist name.
	 * 
	 * @param cin scanner
	 */
	private static void searchArtists(Scanner cin) {
		Utilities.placeholder();
		/* TODO
		System.out.println("Input artist name (or 'x' to quit): ");
		String artist_name = cin.nextLine();
		
		if(!artist_name.equals("x") || !artist_name.trim().isEmpty()) {
			String sql = null; 
			SQL.ps_SearchTracks(sql, artist_name);
		}
		*/
	}
}
