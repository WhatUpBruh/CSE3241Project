package osu.cse3241.options;

import java.util.Scanner;

import osu.cse3241.utilities.Utilities;
import osu.cse3241.sql.SQL;
import osu.cse3241.GRS;

public class SearchRecordStockCount {
	
	public static void menu(Scanner cin) {
		Utilities.printDivider();
		System.out.print("SEARCH RECORD STOCK COUNT:\n"
				+ "Input album name (or 'x' to quit): ");
		String album_name = cin.nextLine();
		
		if (!"x".equals(album_name) && !album_name.trim().isEmpty()) {
		    searchRecordStockCount(album_name);
		}
	}

	/*
	 * PART SIX:
	 * Complete the following method and remove its placeholder.
	 */
	
	/**
	 * Search record stock count by album name.
	 */
	private static void searchRecordStockCount(String album_name) {
		Utilities.placeholder();
		/* TODO */
		// String sql =
        // "SELECT Album.album_name, Record.stock_count " +
        // "FROM Album " +
        // "JOIN Record ON Album.Record_id = Record.Record_id " +
        // "WHERE Album.album_name LIKE ?;";
		String sql =
    "SELECT Album.Album_Name, Record.Record_Count " +
    "FROM Album " +
    "JOIN Record ON Album.Record_ID = Record.Record_ID " +
    "WHERE Album.Album_Name LIKE ?;";


		SQL.ps_SearchRecordStockCount(sql, "%" + album_name + "%");
		
	}
	
}

