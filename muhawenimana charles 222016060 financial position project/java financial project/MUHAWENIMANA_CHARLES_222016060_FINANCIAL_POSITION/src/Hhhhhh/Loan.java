package Hhhhhh;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Loan{
		private int loan_id;
		private String account_id;
		private String amount;
		private String interest_rate;
		public Loan() {}
		public Loan(int loan_id,String account_id,String amount,String interest_rate) {
			super();
			this.loan_id = loan_id;
			this.account_id = account_id;
			this.amount = amount; 
			this.interest_rate = interest_rate;

}
		
		public int getLoan_id() {
			return loan_id;
		}
		public void setLoan_id(int loan_id) {
			this.loan_id = loan_id;
		}
		public String getAccount_id() {
			return account_id;
		}
		public void setAccount_id(String account_id) {
			this.account_id = account_id;
		}
		public String getAmount() {
			return amount;
		}
		public void setAmount(String amount) {
			this.amount = amount;
		}
		public String getInterest_rate() {
			return interest_rate;
		}
		public void setInterest_rate(String interest_rate) {
			this.interest_rate = interest_rate;
		}
		public void insertData() {
			// JDBC URL, username, and password of MySQL server
		    String host = "jdbc:mysql://localhost/financial_position";
		    String user = "root";
		    String password = "";

		    // SQL query to insert data
		    String sql = "INSERT INTO Loans(	account_id,amount, interest_rate) VALUES (?,?,?)";
			
		    try (
		        // Establish the connection
		        Connection con = DriverManager.getConnection(host, user, password);

		        // Create a prepared statement
		    		   PreparedStatement preparedStatement = con.prepareStatement(sql);
		    	    ) {
		        // Set the values for the prepared statement
		       preparedStatement.setString(1, this.account_id);
		       preparedStatement.setString(2, this.amount);
		       preparedStatement.setString(3, this.interest_rate);
		      
		       
		        
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

	        String sql = "SELECT * FROM loans";

	        try {
	            Connection con = DriverManager.getConnection(host, user, password);
	            PreparedStatement preparedStatement = con.prepareStatement(sql);
	            return preparedStatement.executeQuery();
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return null;
	        }
	    }	
		
		public void update(int inputloan_id) {
			// JDBC URL, username, and password of MySQL server
		    String url = "jdbc:mysql://localhost/financial_position";
		    String user = "root";
		    String password = "";

		    // SQL query to update data
		    String sql = "UPDATE Loans SET loan_id= ?,amount= ?,interest_rate= ? WHERE loan_id = ?";

		    try (
		        // Establish the con
		        Connection con = DriverManager.getConnection(url, user, password);

		        // Create a prepared statement
		        PreparedStatement stm = con.prepareStatement(sql);
		    ) {
		        // Set the new values for the update
		    	 
		    	  stm.setString(1, this.getAccount_id());
		          stm.setString(2, this.getAmount());
		          stm.setString(3, this.getInterest_rate()); // Assuming there is a column named 'id' for the WHERE clause
		       
		          stm.setInt(4, inputloan_id);
		       
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
		public void delete(int inputloan_id) {
			// JDBC URL, username, and password of MySQL server
		    String url = "jdbc:mysql://localhost/financial_position";
		    String user = "root";
		    String password = "";

		    // SQL query to delete data
		    String sql = "DELETE FROM Loans WHERE  loan_id = ?";

		    try (
		        // Establish the 
		        Connection con= DriverManager.getConnection(url, user, password);

		        // Create a prepared statement
		        PreparedStatement pl = con.prepareStatement(sql);
		    ) {
		        // Set the value fr the WHERE clause
		        pl.setInt(1, inputloan_id); // Assuming there is a column named 'id' for the WHERE clause

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
