
package Dashboard;

import static Dashboard.Dashboard.count;
import static Dashboard.Dashboard.countId;
import static Dashboard.Dashboard.subtotal;
import static Dashboard.Dashboard.tax;
import static Dashboard.Dashboard.total;
import javax.swing.*;
import java.awt.*;
import java.awt.print.PrinterException;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.sql.Timestamp;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.text.DecimalFormat;

import java.sql.*;




public class DatabaseAccess {
    
    private static final String URL = "jdbc:mysql://localhost:3306/restaurant";
    private static final String USER = "root";
    private static final String PASSWORD = "0503838Aqq";
    //private Connection connection;
    
    
    
     public void insertInvoiceItems(int quantity, int itemId) {
        // SQL statement to insert into invoice_items table
        String invoiceItemsSql = "INSERT INTO Take (Invoice_ID, Item_Id, Quantity) VALUES (?, ?, ?)";

        try (
            // Establishing a connection
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)
        ) {
            // Disabling foreign key constraints
            

            // Creating a PreparedStatement
            try (PreparedStatement preparedStatement = connection.prepareStatement(invoiceItemsSql)) {
                // Setting parameters for the PreparedStatement
                preparedStatement.setInt(1, count);
                preparedStatement.setInt(2, itemId);
                preparedStatement.setInt(3, quantity);

                // Executing the PreparedStatement to insert the data
                int rowsAffected = preparedStatement.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.println("Data inserted successfully into Take table.");
                } else {
                    System.out.println("No rows affected. Data insertion failed.");
                }
            }

            

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

   
    
    
     
     public int lastOrderID() {
    int lastId = 0; // Initialize the variable to hold the last order ID
    try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
        Statement stmt = connection.createStatement();

        ResultSet rs = stmt.executeQuery("SELECT MAX(order_ID) FROM invoice");
        if (rs.next()) {
            lastId = rs.getInt(1);
        }

        rs.close(); // Close ResultSet
        stmt.close(); // Close Statement
    } catch (SQLException e) {
        e.printStackTrace();
        // You can choose to return a default value or throw the exception here
    }
    return lastId;
}
     
     
      public  void insertRecord() {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
        Statement stmt = connection.createStatement();

    
        ResultSet rs = stmt.executeQuery("SELECT MAX(order_ID) FROM invoice");
        rs.next();
        int lastId = rs.getInt(1);
        int  newId = lastId + 1;
        count = countId(newId);
        
        //int empoleey_id = e_is();
         
         String sql = "INSERT INTO invoice (Order_ID, Timed, Order_Date, Total, Subtotal, Tax) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

       

        preparedStatement.setInt(1, newId); // order_ID
        preparedStatement.setTimestamp(2, new Timestamp(System.currentTimeMillis())); // Timed (current timestamp)
        preparedStatement.setDate(3, new java.sql.Date(System.currentTimeMillis())); // Order_Date (current date)
       preparedStatement.setDouble(4, total); // Total
        preparedStatement.setDouble(5, subtotal); // Subtotal
        preparedStatement.setDouble(6, tax); // Tax

          
            int rowsInserted = preparedStatement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Values inserted successfully.");
            } else {
                System.out.println("No rows affected.");
            }
        

       stmt.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    }
      
     public static void lastOrder(){
       try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
        Statement stmt = connection.createStatement();

        ResultSet rs = stmt.executeQuery("SELECT MAX(order_ID) FROM invoice");
        rs.next();
        int lastId = rs.getInt(1);
        //int  newId = lastId + 1;
        count = countId(lastId);

        stmt.close();
        
        
    } catch (SQLException e) {
        e.printStackTrace();
    }
    
    
    
}



public static void countValue(){
        lastOrder();
        count= count+1;
       
    }


}














