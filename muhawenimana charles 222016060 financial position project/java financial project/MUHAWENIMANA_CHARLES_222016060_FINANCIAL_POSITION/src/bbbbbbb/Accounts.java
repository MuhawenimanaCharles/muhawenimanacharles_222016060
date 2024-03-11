package bbbbbbb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Accounts {
		private int account_id;
		private String account_name;
		private String balance;
		public Accounts() {}
		public Accounts(int account_id,String account_name,String balance) {
			super();
			this.account_id = account_id;
			this.account_name = account_name;
			this.balance = balance;
		}
		public int getAccount_id() {
			return account_id;
		}
		public void setAccount_id(int account_id) {
			this.account_id = account_id;
		}
		public String getAccount_name() {
			return account_name;
		}
		public void setAccount_name(String account_name) {
			this.account_name = account_name;
		}
		public String getBalance() {
			return balance;
		}
		public void setBalance(String balance) {
			this.balance = balance;
		}
		
		public void makeconnection() {
		}
				public void insertData() {
			// JDBC URL, username, and password of MySQL server
		    String host = "jdbc:mysql://localhost/financial_position";
		    String user = "root";
		    String password = "";

		    // SQL query to insert data
		    String sql = "INSERT INTO accounts (	account_name, balance) VALUES (?,?)";
			
		    try (
		        // Establish the connection
		        Connection con = DriverManager.getConnection(host, user, password);

		        // Create a prepared statement
		    		   PreparedStatement preparedStatement = con.prepareStatement(sql);
		    	    ) {
		        // Set the values for the prepared statement
		       preparedStatement.setString(1, this.account_name);
		       preparedStatement.setString(2, this.balance);
		      
		       
		        
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

			        String sql = "SELECT * FROM accounts";

			        try {
			            Connection con = DriverManager.getConnection(host, user, password);
			            PreparedStatement preparedStatement = con.prepareStatement(sql);
			            return preparedStatement.executeQuery();
			        } catch (SQLException e) {
			            e.printStackTrace();
			            return null;
			        }
			    }
		
				public void update(int inputaccount_id) {
			// JDBC URL, user name, and password of MySQL server
		    String url = "jdbc:mysql://localhost/financial_position";
		    String user = "root";
		    String password = "";

		    // SQL query to update data
		    String sql = "UPDATE accounts SET  account_Name= ?,balance= ? WHERE account_Id = ?";

		    try (
		        // Establish the connection
		        Connection con = DriverManager.getConnection(url, user, password);

		        // Create a prepared statement
		        PreparedStatement stm = con.prepareStatement(sql);
		    ) {
		        // Set the new values for the update
		    	 
		          stm.setString(1, this.getAccount_name());
		          stm.setString(2, this.getBalance()); // Assuming there is a column named 'id' for the WHERE clause
		       
		          stm.setInt(3, inputaccount_id);
		       
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
		public void delete(int inputaccount_id) {
			// JDBC URL, username, and password of MySQL server
		    String url = "jdbc:mysql://localhost/financial_position";
		    String user = "root";
		    String password = "";

		    // SQL query to delete data
		    String sql = "DELETE FROM accounts WHERE  account_Id = ?";

		    try (
		        // Establish the 
		        Connection con= DriverManager.getConnection(url, user, password);

		        // Create a prepared statement
		        PreparedStatement pl = con.prepareStatement(sql);
		    ) {
		        // Set the value for the WHERE clause
		        pl.setInt(1, inputaccount_id); // Assuming there is a column named 'id' for the WHERE clause

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


