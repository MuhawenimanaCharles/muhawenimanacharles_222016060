package ccccccccc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Assets {
	private int asset_id;
	private String account_id;
	private String asset_name;
	private String value;
	public Assets() {}
	public Assets(int asset_id,String account_id,String asset_name,String value) {
		super();
		this.asset_id = asset_id;
		this.account_id = account_id;
		this.asset_name = asset_name;
		this.value = value;
}
	public int getAsset_id() {
		return asset_id;
	}
	public void setAsset_id(int asset_id) {
		this.asset_id = asset_id;
	}
	public String getAccount_id() {
		return account_id;
	}
	public void setAccount_id(String account_id) {
		this.account_id = account_id;
	}
	public String getAsset_name() {
		return asset_name;
	}
	public void setAsset_name(String asset_name) {
		this.asset_name = asset_name;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public void makeconnection() {
	}
			public void insertData() {
		// JDBC URL, username, and password of MySQL server
	    String host = "jdbc:mysql://localhost/financial_position";
	    String user = "root";
	    String password = "";

	    // SQL query to insert data
	    String sql = "INSERT INTO assets (	account_id,asset_name, value) VALUES (?,?,?)";
		
	    try (
	        // Establish the connection
	        Connection con = DriverManager.getConnection(host, user, password);

	        // Create a prepared statement
	    		   PreparedStatement preparedStatement = con.prepareStatement(sql);
	    	    ) {
	        // Set the values for the prepared statement
	       preparedStatement.setString(1, this.account_id);
	       preparedStatement.setString(2, this.asset_name);
	       preparedStatement.setString(3, this.value);
	      
	       
	        
	        // Execute the query
	        int rowsAffected = preparedStatement.executeUpdate();

	        // Check the result
	        if (rowsAffected > 0) {
	        	System.out.println("Well Data insert successfully!");
	            JOptionPane.showMessageDialog(null, "Data insert successfully!","After insert",JOptionPane.INFORMATION_MESSAGE);
	        } else {
	            System.out.println("Failed to insert data.");
	            JOptionPane.showMessageDialog(null, "Failed to register data.!","After insert",JOptionPane.ERROR_MESSAGE);

	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }}
	 
			
			public static ResultSet viewData() {
		        String host = "jdbc:mysql://localhost/financial_position";
		        String user = "root";
		        String password = "";

		        String sql = "SELECT * FROM assets";

		        try {
		            Connection con = DriverManager.getConnection(host, user, password);
		            PreparedStatement preparedStatement = con.prepareStatement(sql);
		            return preparedStatement.executeQuery();
		        } catch (SQLException e) {
		            e.printStackTrace();
		            return null;
		        }
		    }
	public void update(int inputasset_id) {
		// JDBC URL, username, and password of MySQL server
	    String url = "jdbc:mysql://localhost/financial_position";
	    String user = "root";
	    String password = "";

	    // SQL query to update data
	    String sql = "UPDATE assets SET  account_id= ?,asset_name=?,value= ? WHERE asset_id = ?";

	    try (
	        // Establish the con
	        Connection con = DriverManager.getConnection(url, user, password);

	        // Create a prepared statement
	        PreparedStatement stm = con.prepareStatement(sql);
	    ) {
	        // Set the new values for the update
	    	 
	    	  stm.setString(1, this.getAccount_id());
	          stm.setString(2, this.getAsset_name());
	          stm.setString(3, this.getValue()); // Assuming there is a column named 'id' for the WHERE clause
	       
	          stm.setInt(4, inputasset_id);
	       
	        // Execute the update
	        int rowsAffected = stm.executeUpdate();

	        // Check the result
	        if (rowsAffected > 0) {
	            System.out.println("Data updated successfully!");
	            JOptionPane.showMessageDialog(null, "Data updated successfully!!","After update",JOptionPane.INFORMATION_MESSAGE);
	        } else {
	            System.out.println("Failed to update data. No matching record found.");
	            JOptionPane.showMessageDialog(null, "Failed to update data. No matching record found.!","After insert",JOptionPane.INFORMATION_MESSAGE);
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }   
	}
	public void delete(int inputasset_id) {
		// JDBC URL, username, and password of MySQL server
	    String url = "jdbc:mysql://localhost/financial_position";
	    String user = "root";
	    String password = "";

	    // SQL query to delete data
	    String sql = "DELETE FROM assets WHERE  asset_Id = ?";

	    try (
	        // Establish the 
	        Connection con= DriverManager.getConnection(url, user, password);

	        // Create a prepared statement
	        PreparedStatement pl = con.prepareStatement(sql);
	    ) {
	        // Set the value for the WHERE clause
	        pl.setInt(1, inputasset_id); // Assuming there is a column named 'id' for the WHERE clause

	        // Execute the delete
	        int rowsAffected = pl.executeUpdate();

	        // Check the result
	        if (rowsAffected > 0) {
	            System.out.println("WELL Data deleted successfully!");
	            JOptionPane.showMessageDialog(null, "WELL Data deleted successfully!","After delete",JOptionPane.INFORMATION_MESSAGE);
	        } else {
	            System.out.println("Failed to delete data. No matching record found.");
	            JOptionPane.showMessageDialog(null, "Failed to delete data. No matching record found. No matching record found.!","After insert",JOptionPane.INFORMATION_MESSAGE);
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	
	}
}



