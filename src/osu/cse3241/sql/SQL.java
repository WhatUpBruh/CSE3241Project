package osu.cse3241.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import osu.cse3241.GRS;

/**
 * 
 * All database connectivity should be handled from within here.
 *
 */
public class SQL {
	
	private static PreparedStatement ps;
	
    /**
     * Queries the database and prints the results.
     * 
     * @param conn a connection object
     * @param sql a SQL statement that returns rows:
     * 		this query is written with the Statement class, typically 
     * 		used for static SQL SELECT statements.
     */
    public static void sqlQuery(Connection conn, String sql){
        try {
        	Statement stmt = conn.createStatement();
        	ResultSet rs = stmt.executeQuery(sql);
        	ResultSetMetaData rsmd = rs.getMetaData();
        	int columnCount = rsmd.getColumnCount();
        	for (int i = 1; i <= columnCount; i++) {
        		String value = rsmd.getColumnName(i);
        		System.out.print(value);
        		if (i < columnCount) System.out.print(",  ");
        	}
			System.out.print("\n");
        	while (rs.next()) {
        		for (int i = 1; i <= columnCount; i++) {
        			String columnValue = rs.getString(i);
            		System.out.print(columnValue);
            		if (i < columnCount) System.out.print(",  ");
        		}
    			System.out.print("\n");
        	}
        	rs.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    
    /**
     * Queries the database and prints the results.
     * 
     * @param conn a connection object
     * @param sql a SQL statement that returns rows:
     * 		this query is written with the PrepareStatement class, typically 
     * 		used for dynamic SQL SELECT statements.
     */
    public static void sqlQuery(Connection conn, PreparedStatement sql){
        try {
        	ResultSet rs = sql.executeQuery();
        	ResultSetMetaData rsmd = rs.getMetaData();
        	int columnCount = rsmd.getColumnCount();
        	for (int i = 1; i <= columnCount; i++) {
        		String value = rsmd.getColumnName(i);
        		System.out.print(value);
        		if (i < columnCount) System.out.print(",  ");
        	}
			System.out.print("\n");
        	while (rs.next()) {
        		for (int i = 1; i <= columnCount; i++) {
        			String columnValue = rs.getString(i);
            		System.out.print(columnValue);
            		if (i < columnCount) System.out.print(",  ");
        		}
    			System.out.print("\n");
        	}
        	rs.close();
        	ps.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    
    /**
     * (PART 5) Create PreparedStatement to search a track by track name.
     * 
     * @param sql query for prepared statement
     * 
     * @param track_name track name to search by 
     */
    public static void ps_SearchTracks(String sql, String track_name){
    	try {
    		ps = GRS.conn.prepareStatement(sql);
    		ps.setString(1, track_name);
    	} catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    	
    	sqlQuery(GRS.conn, ps);
    }
    
    /**
     * (PART 5) Create PreparedStatement to search an artist by artist name.
     * 
     * @param sql query for prepared statement
     * 
     * @param track_name track name to search by 
     */
    public static void ps_SearchArtists(String sql, String artist_name){
    	try {
    		ps = GRS.conn.prepareStatement(sql);
    		ps.setString(1, artist_name);
    	} catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    	
    	sqlQuery(GRS.conn, ps);
    }
    
    /**
     * (PART 6) Create PreparedStatement to search number of records in stock according to album name.
     * 
     * @param sql query for prepared statement
     * 
     * @param album_name album name to search by
     */
    public static void ps_SearchRecordStockCount(String sql, String album_name) {
    	/* TODO */
        try {
    		ps = GRS.conn.prepareStatement(sql);
    		ps.setString(1, album_name);
    	} catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    	
    	sqlQuery(GRS.conn, ps);
    }

    /**
     * Adding new customer to the database. 
     */
    public static void ps_addCustomer(String sql, String customer_id, String facility_id, String Fname, String Lname, String address, String phone_number, String email, String start_date, String facility_distance, Boolean active_status) {
	
        try {
    		ps = GRS.conn.prepareStatement(sql);
    		ps.setString(1, customer_id);
    		ps.setString(2, facility_id);
    		ps.setString(3, Fname);
    		ps.setString(4, Lname);
    		ps.setString(5, address);
    		ps.setString(6, phone_number);
    		ps.setString(7, email);
    		ps.setString(8, start_date);
    		ps.setString(9, facility_distance);
    		ps.setBoolean(10, active_status);

            ps.executeUpdate();
    	} catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    	
    	sqlQuery(GRS.conn, ps);
    }


    /**
     * Deleting a customer from the database. 
     */
    public static void ps_deleteCustomer(String sql, String customer_id) {
    
        try {
    		ps = GRS.conn.prepareStatement(sql);
    		ps.setString(1, customer_id);

            ps.executeUpdate();
    	} catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Updating a customer's information in the database. 
     */
    public static void ps_updateCustomer(String sql, String phone_number, String email, String address, Boolean active_status, String customer_id) {
    
        try {
    		ps = GRS.conn.prepareStatement(sql);
    		ps.setString(1, phone_number);
    		ps.setString(2, email);
    		ps.setString(3, address);
    		ps.setBoolean(4, active_status);
    		ps.setString(5, customer_id);

            ps.executeUpdate();
    	} catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Adding new robot to the database. 
     */

    public static void ps_addRobot(String sql, String robot_id, String manufacturer_id, String robot_name, String robot_model, String serial_number, String status, String warehouse, String year, String battery_autonomy, String sensor_suite, String function, String training_level, String warranty_date) {
    
        try {
    		ps = GRS.conn.prepareStatement(sql);
            ps.setString(1, robot_id);
    		ps.setString(2, manufacturer_id);
            ps.setString(3, robot_name);
            ps.setString(4, robot_model);
            ps.setString(5, serial_number);
            ps.setString(6, status);
            ps.setString(7, warehouse);
            ps.setString(8, year);
            ps.setString(9, battery_autonomy);  
            ps.setString(10, sensor_suite);
            ps.setString(11, function);
            ps.setString(12, training_level);
            ps.setString(13, warranty_date);   

            ps.executeUpdate();
    	} catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }








    /**
     * Transaction logic
     */



     /**
      * RentRobotTransaction: Rents a robot to a customer, updates the robot's status, and creates a dispatch record for the delivery.
      */
    public static void rentRobotTransaction(int customerId, int robotId, int carId, java.sql.Date checkoutDate, java.sql.Date dueDate) {
        Connection conn = GRS.conn;

        try {
            conn.setAutoCommit(false);

            int rentalId = SQL.insertRental(customerId, robotId, checkoutDate, dueDate);
            SQL.updateRobotStatus(conn, robotId, "RENTED");
            SQL.insertDispatch(conn, robotId, customerId, rentalId, carId, checkoutDate, "DELIVERY");

            conn.commit();
            System.out.println("Robot rented successfully!");

        } catch (SQLException e) {
            try {
                conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            System.out.println("Failed to rent robot. Transaction rolled back.");
            System.out.println("SQL Error: " + e.getMessage());
            // NO rethrow
        } finally {
            try {
                conn.setAutoCommit(true);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static int insertRental(int customerId, int robotId, java.sql.Date checkoutDate, java.sql.Date dueDate) throws SQLException {
        String sql = "INSERT INTO Rental (CustomerID, RobotID, CheckoutDate, DueDate, ReturnDate, RentalFee, DamageFee, DailyServiceCost) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = GRS.conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setInt(1, customerId);
            pstmt.setInt(2, robotId);
            pstmt.setDate(3, checkoutDate);
            pstmt.setDate(4, dueDate);
            pstmt.setDate(5, dueDate); 
            pstmt.setInt(6, java.sql.Types.DOUBLE); 
            pstmt.setInt(7, java.sql.Types.DOUBLE); 
            pstmt.setInt(8, java.sql.Types.DOUBLE); 
            pstmt.executeUpdate();

            try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return generatedKeys.getInt(1);
                } else {
                    throw new SQLException("Creating rental failed, no ID obtained.");
                }
            }
        }
    }

    public static void updateRobotStatus(Connection conn, int robotId, String status) throws SQLException {
        String sql = "UPDATE Robot SET Status = ? WHERE RobotID = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, status);
            pstmt.setInt(2, robotId);
            pstmt.executeUpdate();
        }
    }

    public static int insertDispatch(Connection conn, int robotId, int customerId, int rentalId, int carId, java.sql.Date dispatchDate, String dispatchType) throws SQLException {

        String sql = "INSERT INTO Dispatch (RobotID, CustomerID, RentalID, CarID, DispatchDate, DispatchType) " +
                    "VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            pstmt.setInt(1, robotId);
            pstmt.setInt(2, customerId);
            pstmt.setInt(3, rentalId);
            pstmt.setInt(4, carId);
            pstmt.setDate(5, dispatchDate);
            pstmt.setString(6, dispatchType);  

            pstmt.executeUpdate();

            try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return generatedKeys.getInt(1);   // DispatchID
                } else {
                    throw new SQLException("Creating dispatch failed, no ID obtained.");
                }
            }
        }
    }








    /**
     * Transaction for return equipement
     */


     public static class RentalInfo {
        public int robotId;
        public int customerId;

        public RentalInfo(int robotId, int customerId) {
            this.robotId = robotId;
            this.customerId = customerId;
        }
    }

    public static RentalInfo getRentalInfo(int rentalId) throws SQLException {
        String sql = "SELECT RobotID, CustomerID FROM Rental WHERE RentalID = ?";
        try (PreparedStatement pstmt = GRS.conn.prepareStatement(sql)) {
            pstmt.setInt(1, rentalId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new RentalInfo(rs.getInt("RobotID"), rs.getInt("CustomerID"));
            }
            return null;
        }
    }


    public static void returnEquipmentTransaction(int rentalId, int carId) {
        Connection conn = GRS.conn;

        try {
            conn.setAutoCommit(false);

            // 1. Get robot + customer from rental
            RentalInfo info = SQL.getRentalInfo(rentalId);
            if (info == null) {
                throw new SQLException("Rental not found.");
            }

            java.sql.Date returnDate = new java.sql.Date(System.currentTimeMillis());

            // 2. Update rental return date
            SQL.updateRentalReturnDate(rentalId, returnDate);

            // 3. Mark robot as available
            SQL.updateRobotStatus(conn, info.robotId, "AVAILABLE");

            // 4. Insert pickup dispatch
            SQL.insertDispatch(conn, info.robotId, info.customerId, rentalId, carId, returnDate, "PICKUP");

            conn.commit();
            System.out.println("Equipment returned successfully!");

        } catch (SQLException e) {
            try { conn.rollback(); } catch (SQLException ex) { ex.printStackTrace(); }
            System.out.println("Failed to return equipment. Transaction rolled back.");
            System.out.println("SQL Error: " + e.getMessage());
        } finally {
            try { conn.setAutoCommit(true); } catch (SQLException e) { e.printStackTrace(); }
        }
    }


    public static void updateRentalReturnDate(int rentalId, java.sql.Date returnDate) throws SQLException {
        String sql = "UPDATE Rental SET ReturnDate = ? WHERE RentalID = ?";
        try (PreparedStatement pstmt = GRS.conn.prepareStatement(sql)) {
            pstmt.setDate(1, returnDate);
            pstmt.setInt(2, rentalId);
            pstmt.executeUpdate();
        }
    }



}
    
  

	

