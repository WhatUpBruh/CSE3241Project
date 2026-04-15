package osu.cse3241;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import osu.cse3241.options.*;
import osu.cse3241.utilities.Utilities;

public class GRS {	
	
	// private static final String DATABASE = "database_binary.db";
	private static final String DATABASE = "checkpointDB.db";
	
	public static Connection conn = null;
	
    /**
     * Connects to the database if it exists, creates it if it does not, and returns the connection object.
     * 
     * @param databaseFileName the database file name
     * @return a connection object to the designated database
     */
    public static Connection initializeDB(String databaseFileName) {
    	/**
    	 * The "Connection String" or "Connection URL".
    	 * 
    	 * "jdbc:sqlite:" is the "subprotocol".
    	 * (If this were a SQL Server database it would be "jdbc:sqlserver:".)
    	 */
        String url = "jdbc:sqlite:" + databaseFileName;
        Connection conn = null; // If you create this variable inside the Try block it will be out of scope
        try {
            conn = DriverManager.getConnection(url);
            if (conn != null) {
            	// Provides some positive assurance the connection and/or creation was successful.
                DatabaseMetaData meta = conn.getMetaData();
                System.out.println("The driver name is " + meta.getDriverName());
                System.out.println("The connection to the database was successful.");
            } else {
            	// Provides some feedback in case the connection failed but did not throw an exception.
            	System.out.println("Null Connection");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("There was a problem connecting to the database.");
        }
        return conn;
    }
	
    private static final Set<Character> MENU_OPTIONS = new HashSet<>(Arrays.asList('1', '2', '3', '4', '5', 'x'));
	
	private static void mainMenu(Scanner cin) {
	
		char selection;
		do {
			System.out.print("~GROOVE RECORD STORE~\n"
					+ "1. View all Customer/Robots\n"
					+ "2. Search Artists/Tracks\n"
					+ "3. Transactions\n"
					+ "4. EDIT MENU\n"
					+ "Input numerical selection (or 'x' to quit): ");
			String input = cin.nextLine();
			selection = !input.isEmpty() ? input.charAt(0) : ' ';
			
			while(!MENU_OPTIONS.contains(selection)) {
				System.out.print("Incorrect option specified! Try again: ");
				input = cin.nextLine();
				selection = !input.isEmpty() ? input.charAt(0) : ' ';
			}
		
			switch(selection) {
				case '1':
					ViewCustomerRobot.menu(cin);
					break;
				case '2':
					SearchArtistTrack.menu(cin);
					break;
				case '3':
					TransactionMenu.menu(cin);
					break;
				case '4':
					EditMenu.menu(cin);
					break;
				default: 
					break;
			}
			Utilities.printDivider();
		} while(selection!='x');
	}
	
	public static void main(String[] args) {
		conn = initializeDB(DATABASE);
		
		Scanner cin = new Scanner(System.in);
		mainMenu(cin);
		
		cin.close();
		try {
			conn.close();
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
		
		System.out.println("Bye");
	}

}
