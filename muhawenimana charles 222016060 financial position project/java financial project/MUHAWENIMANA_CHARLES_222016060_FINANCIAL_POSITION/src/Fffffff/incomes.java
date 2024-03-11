package Fffffff;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import javax.swing.JOptionPane;

public class incomes {
		private int income_id;
		private String account_id;
		private String amount;
		private String income_date;
		public incomes() {}
		public incomes(int income_id,String account_id,String amount, String income_date) {
			super();
			this.income_id = income_id;
			this.account_id = account_id;
			this.amount = amount;
			this.income_date = income_date;
	}
	       public int getIncome_id() {
			return income_id;
		}
		public void setIncome_id(int income_id) {
			this.income_id = income_id;
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
		public String getIncome_date() {
			return income_date;
		}
		public void setIncome_date(String income_date) {
			this.income_date = income_date;
		}
		public void insertData() {
	// JDBC URL, username, and password of MySQL server
    String host = "jdbc:mysql://localhost/financial_position";
    String user = "root";
    String password = "";

    // SQL query to insert data
    String sql = "INSERT INTO incomes(	account_id,amount, income_date) VALUES (?,?,?)";
	
    try (
        // Establish the connection
        Connection con = DriverManager.getConnection(host, user, password);

        // Create a prepared statement
    		   PreparedStatement preparedStatement = con.prepareStatement(sql);
    	    ) {
        // Set the values for the prepared statement
       preparedStatement.setString(1, this.account_id);
       preparedStatement.setString(2, this.amount);
       preparedStatement.setString(3, this.income_date);
      
       
        
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

	        String sql = "SELECT * FROM incomes";

	        try {
	            Connection con = DriverManager.getConnection(host, user, password);
	            PreparedStatement preparedStatement = con.prepareStatement(sql);
	            return preparedStatement.executeQuery();
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return null;
	        }
	    }public void update(int inputincome_id) {
	// JDBC URL, username, and password of MySQL server
    String url = "jdbc:mysql://localhost/financial_position";
    String user = "root";
    String password = "";

    // SQL query to update data
    String sql = "UPDATE incomes SET account_id= ?,amount= ?,income_date= ? WHERE income_id = ?";

    try (
        // Establish the con
        Connection con = DriverManager.getConnection(url, user, password);

        // Create a prepared statement
        PreparedStatement stm = con.prepareStatement(sql);
    ) {
        // Set the new values for the update
    	 
    	  stm.setString(1, this.getAccount_id());
          stm.setString(2, this.getAmount());
          stm.setString(3, this.getIncome_date()); // Assuming there is a column named 'id' for the WHERE clause
       
          stm.setInt(4, inputincome_id);
       
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
public void delete(int inputincome_id) {
	// JDBC URL, username, and password of MySQL server
    String url = "jdbc:mysql://localhost/financial_position";
    String user = "root";
    String password = "";

    // SQL query to delete data
    String sql = "DELETE FROM incomes WHERE  income_id = ?";

    try (
        // Establish the 
        Connection con= DriverManager.getConnection(url, user, password);

        // Create a prepared statement
        PreparedStatement pl = con.prepareStatement(sql);
    ) {
        // Set the value for the WHERE clause
        pl.setInt(1, inputincome_id); // Assuming there is a column named 'id' for the WHERE clause

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




