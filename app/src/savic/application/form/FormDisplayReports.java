/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package savic.application.form;
import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.FlatLightLaf;
import com.raven.datechooser.DateBetween;
import com.raven.datechooser.DateChooser;
import com.raven.datechooser.listener.DateChooserAction;
import com.raven.datechooser.listener.DateChooserAdapter;
import java.awt.print.PrinterException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
//import com.toedter.calendar.JDateChooser;
import java.util.Date;
import java.text.SimpleDateFormat;


/**
 *
 * @author ABDURAHMAN
 */
public class FormDisplayReports extends javax.swing.JPanel {

    /**
     * Creates new form FormDisplayReports
     */
    
    private DateChooser chDate = new DateChooser();

    
    public FormDisplayReports() 
    {
        initComponents();
        Connect();
        update_table();
        
        chDate.setTextField(txt_from);
        chDate.setDateSelectionMode(DateChooser.DateSelectionMode.BETWEEN_DATE_SELECTED);
        chDate.setLabelCurrentDayVisible(false);
        chDate.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        
      chDate.addActionDateChooserListener(new DateChooserAdapter() {
    @Override
    public void dateBetweenChanged(DateBetween date, DateChooserAction action) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        
       
        String dateFrom = dateFormat.format(date.getFromDate());
        String toDate = dateFormat.format(date.getToDate());
        loadData("SELECT * FROM Sales_Report WHERE Report_Date BETWEEN '"+dateFrom+"' AND '"+toDate+"'", dateFrom, toDate);
    }
});
    }   
      
    Connection con;
    PreparedStatement pst;
    
   public void Connect() {
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant", "root", "0503838Aqq");
        System.out.println("Connected to database."); // Add logging statement
    } catch (ClassNotFoundException | SQLException ex) {
        System.err.println("Error connecting to database: " + ex.getMessage()); // Add error handling
    }
}
  
      
    private void loadData(String sql, String dateFrom, String toDate) {
    try {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        model.setRowCount(0);
        String query = "SELECT * FROM Sales_Report WHERE Report_Date BETWEEN ? AND ?";
        pst = con.prepareStatement(query);
        pst.setString(1, dateFrom); // Set the start date parameter
        pst.setString(2, toDate);   // Set the end date parameter
        ResultSet rs = pst.executeQuery();

        while (rs.next()) {
            // Retrieve data from the result set and add to the model
            int salesId = rs.getInt("Sales_Id");
            String moItem = rs.getString("MO_Item");
            String loItem = rs.getString("LO_Item");
            int totalOrders = rs.getInt("Total_Orders");
            Date reportDate = rs.getDate("Report_Date");
            int eId = rs.getInt("E_Id");
            model.addRow(new Object[]{salesId, moItem, loItem, totalOrders, dateFormat.format(reportDate), eId});
        }
    } catch (SQLException e) {
        System.err.println("Error loading data: " + e.getMessage()); // Add error handling
    } finally {
        try 
        {
                if (pst != null)
                    pst.close();
            // Close the ResultSet if needed
        }       catch (SQLException e) {
                System.err.println("Error closing resources: " + e.getMessage());
            }
        }
    }

    
        public void update_table() 
    {
        try {
            pst = con.prepareStatement("SELECT * FROM sales_report;");
            ResultSet Rs = pst.executeQuery();
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);

            while (Rs.next()) {
                // Add data to the table model
                model.addRow(new Object[]{
                        Rs.getInt("Sales_Id"),
                        Rs.getString("MO_Item"),
                        Rs.getString("LO_Item"),
                        Rs.getInt("Total_Orders"),
                        Rs.getDate("Report_Date"),
                        Rs.getInt("E_Id")
                });
            }
        } catch (SQLException e) {
            System.err.println("Error updating table: " + e.getMessage()); // Add error handling
        }
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        txt_from = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txt_Search = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();

        jPanel2.setBackground(new java.awt.Color(36, 103, 155));

        jLabel1.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 48)); // NOI18N
        jLabel1.setText("Display Reports");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(456, 456, 456))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(jLabel1)
                .addContainerGap(70, Short.MAX_VALUE))
        );

        jTable1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Sales_ID", "MO_Item", "LO_Item", "Total_Orders", "Report_Date", "E_ID"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable1);

        jButton1.setBackground(new java.awt.Color(36, 103, 155));
        jButton1.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 24)); // NOI18N
        jButton1.setText("Order by least orders per date");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(36, 103, 155));
        jButton2.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 24)); // NOI18N
        jButton2.setText("Order by most orders per date");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "Generate Report", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Berlin Sans FB Demi", 1, 18), new java.awt.Color(0, 0, 0))); // NOI18N

        txt_from.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txt_from.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_fromActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Helvetica Neue", 1, 24)); // NOI18N
        jLabel6.setText("Date");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(txt_from, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(54, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txt_from, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        txt_Search.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txt_Search.setText("Search an employee");
        txt_Search.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_SearchFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_SearchFocusLost(evt);
            }
        });
        txt_Search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_SearchKeyReleased(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(36, 103, 155));
        jButton3.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 24)); // NOI18N
        jButton3.setText("Print");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(252, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(358, 358, 358))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)
                        .addGap(285, 285, 285))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 834, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_Search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(64, 64, 64)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addComponent(txt_Search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(117, 117, 117)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txt_fromActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_fromActionPerformed
        // TODO add your handling code here:
        String dateString = txt_from.getText();

        // Create a SimpleDateFormat to parse the date
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        try {
            // Parse the string into a Date object
            Date date = dateFormat.parse(dateString);

            // Format the parsed date back to the desired format (optional)
            String formattedDate = dateFormat.format(date);

            // Now you can use the formattedDate as needed
            System.out.println("Formatted Date: " + formattedDate);
        } catch (ParseException ex) {
            // Handle parsing exception
            System.err.println("Error parsing date: " + ex.getMessage());
        }
    }//GEN-LAST:event_txt_fromActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        try (PreparedStatement pst = con.prepareStatement("SELECT * FROM Sales_Report ORDER BY Total_Orders ASC");
         ResultSet rs = pst.executeQuery()) {

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Sales_Id");
        model.addColumn("MO_Item");
        model.addColumn("LO_Item");
        model.addColumn("Total_Orders");
        model.addColumn("Report_Date");
        model.addColumn("E_Id");

        while (rs.next()) {
            int salesID = rs.getInt("Sales_Id");
            String mo_item = rs.getString("MO_Item");
            String lo_item = rs.getString("LO_Item");
            int total_orders = rs.getInt("Total_Orders");
            String date1 = rs.getString("Report_Date");
            int e_id = rs.getInt("E_Id");

            model.addRow(new Object[]{salesID, mo_item, lo_item, total_orders, date1, e_id});
        }

        jTable1.setModel(model);

    } catch (SQLException ex) {
        ex.printStackTrace(); // Print stack trace to see what's causing the issue
        JOptionPane.showMessageDialog(this, "Error fetching data from the database", "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        try (PreparedStatement pst = con.prepareStatement("SELECT * FROM Sales_Report ORDER BY Total_Orders DESC");
         ResultSet rs = pst.executeQuery()) {

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Sales_Id");
        model.addColumn("MO_Item");
        model.addColumn("LO_Item");
        model.addColumn("Total_Orders");
        model.addColumn("Report_Date");
        model.addColumn("E_Id");

        while (rs.next()) {
            int salesID = rs.getInt("Sales_Id");
            String mo_item = rs.getString("MO_Item");
            String lo_item = rs.getString("LO_Item");
            int total_orders = rs.getInt("Total_Orders");
            String date1 = rs.getString("Report_Date");
            int e_id = rs.getInt("E_Id");

            model.addRow(new Object[]{salesID, mo_item, lo_item, total_orders, date1, e_id});
        }

        jTable1.setModel(model);

    } catch (SQLException ex) {
        ex.printStackTrace(); // Print stack trace to see what's causing the issue
        JOptionPane.showMessageDialog(this, "Error fetching data from the database", "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txt_SearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_SearchKeyReleased
        // TODO add your handling code here:
         DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        TableRowSorter<DefaultTableModel> model_1 = new TableRowSorter<>(model);

        jTable1.setRowSorter(model_1);
        model_1.setRowFilter(RowFilter.regexFilter(txt_Search.getText()));

    }//GEN-LAST:event_txt_SearchKeyReleased

    private void txt_SearchFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_SearchFocusGained
        // TODO add your handling code here:
          if (txt_Search.getText().equals("Search an employee")) {
            txt_Search.setText("");
        }
      
    }//GEN-LAST:event_txt_SearchFocusGained

    private void txt_SearchFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_SearchFocusLost
        // TODO add your handling code here:
            if (txt_Search.getText().equals("")) {
            txt_Search.setText("Search an employee");
        }
    }//GEN-LAST:event_txt_SearchFocusLost

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            // TODO add your handling code here:

            jTable1.print();
        } catch (PrinterException ex) {
            Logger.getLogger(FormCustomerViews.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton3ActionPerformed

  
                                      

  
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txt_Search;
    private javax.swing.JTextField txt_from;
    // End of variables declaration//GEN-END:variables
}
