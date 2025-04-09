package carrental;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;


public class Customers extends javax.swing.JFrame {

    public Customers() {
        initComponents();
        Connect();
        DisplayCustomers();
        Reset();
    }

    Connection Con;
    Statement St;
    ResultSet Rs;
    
    public void Connect() {
    try {
            // Загружаем драйвер PostgreSQL
            Class.forName("org.postgresql.Driver");
            
            // Подключаемся к базе данных
            Con = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/vehicledb",  // URL подключения
                "sopakunovarslan",  // Имя пользователя базы данных
                "911Spectre"        // Пароль
            );
            
            
            // Сообщаем об успешном подключении
            System.out.println("Connected to the database successfully!");

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Cars.class.getName()).log(Level.SEVERE, "PostgreSQL JDBC Driver not found!", ex);
        } catch (SQLException ex) {
            Logger.getLogger(Cars.class.getName()).log(Level.SEVERE, "Database connection failed!", ex);
        }
    }
    
    private void Reset(){
        CustIdTb.setText("");
        CustNameTb.setText("");
        CustAddressTb.setText("");
        CustPhoneTb.setText("");
    }
            
    private void DisplayCustomers(){
        try{
            St = Con.createStatement();
            Rs = St.executeQuery("SELECT * FROM customertable ");
            CustomersTable.setModel(DbUtils.resultSetToTableModel(Rs));
        }catch(SQLException e){
           e.printStackTrace(); 
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField5 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        CarsBTN = new javax.swing.JLabel();
        RentBTN = new javax.swing.JLabel();
        LogoutBTN = new javax.swing.JLabel();
        ReturnBTN = new javax.swing.JLabel();
        lol = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        ExitBtn = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        CustIdTb = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        CustNameTb = new javax.swing.JTextField();
        CustAddressTb = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        CustPhoneTb = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        UpdateBtn = new javax.swing.JButton();
        DeleteBtn = new javax.swing.JButton();
        ResetBtn = new javax.swing.JButton();
        SaveBtn = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        CustomersTable = new javax.swing.JTable();
        ExportBtn = new javax.swing.JButton();

        jLabel15.setBackground(new java.awt.Color(255, 255, 255));
        jLabel15.setFont(new java.awt.Font("Skia", 0, 16)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 102, 102));
        jLabel15.setText("Registration Number");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));
        jPanel1.setForeground(new java.awt.Color(0, 102, 102));

        CarsBTN.setBackground(new java.awt.Color(255, 255, 255));
        CarsBTN.setFont(new java.awt.Font("Skia", 1, 24)); // NOI18N
        CarsBTN.setForeground(new java.awt.Color(255, 255, 255));
        CarsBTN.setText("Cars");
        CarsBTN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CarsBTNMouseClicked(evt);
            }
        });

        RentBTN.setBackground(new java.awt.Color(255, 255, 255));
        RentBTN.setFont(new java.awt.Font("Skia", 1, 24)); // NOI18N
        RentBTN.setForeground(new java.awt.Color(255, 255, 255));
        RentBTN.setText("Rent Car");
        RentBTN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RentBTNMouseClicked(evt);
            }
        });

        LogoutBTN.setBackground(new java.awt.Color(255, 255, 255));
        LogoutBTN.setFont(new java.awt.Font("Skia", 1, 24)); // NOI18N
        LogoutBTN.setForeground(new java.awt.Color(255, 255, 255));
        LogoutBTN.setText("Logout");
        LogoutBTN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LogoutBTNMouseClicked(evt);
            }
        });

        ReturnBTN.setBackground(new java.awt.Color(255, 255, 255));
        ReturnBTN.setFont(new java.awt.Font("Skia", 1, 24)); // NOI18N
        ReturnBTN.setForeground(new java.awt.Color(255, 255, 255));
        ReturnBTN.setText("Return Car");
        ReturnBTN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ReturnBTNMouseClicked(evt);
            }
        });

        lol.setBackground(new java.awt.Color(255, 255, 255));
        lol.setFont(new java.awt.Font("Skia", 1, 24)); // NOI18N
        lol.setForeground(new java.awt.Color(255, 255, 255));
        lol.setText("Customers>");
        lol.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lolMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lol)
                    .addComponent(ReturnBTN)
                    .addComponent(LogoutBTN)
                    .addComponent(CarsBTN)
                    .addComponent(RentBTN))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(200, 200, 200)
                .addComponent(CarsBTN)
                .addGap(30, 30, 30)
                .addComponent(lol)
                .addGap(30, 30, 30)
                .addComponent(RentBTN)
                .addGap(30, 30, 30)
                .addComponent(ReturnBTN)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 332, Short.MAX_VALUE)
                .addComponent(LogoutBTN)
                .addGap(35, 35, 35))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        ExitBtn.setFont(new java.awt.Font("Monospaced", 1, 24)); // NOI18N
        ExitBtn.setForeground(new java.awt.Color(0, 102, 102));
        ExitBtn.setText("x");
        ExitBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ExitBtnMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(ExitBtn)
                .addGap(14, 14, 14))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ExitBtn)
                .addContainerGap())
        );

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Skia", 1, 28)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 102, 102));
        jLabel10.setText("Customers list");

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("Skia", 0, 16)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 102, 102));
        jLabel11.setText("Passport ID");

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setFont(new java.awt.Font("Skia", 0, 16)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 102, 102));
        jLabel12.setText("Name");

        jLabel13.setBackground(new java.awt.Color(255, 255, 255));
        jLabel13.setFont(new java.awt.Font("Skia", 0, 16)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 102, 102));
        jLabel13.setText("Address");

        jLabel16.setBackground(new java.awt.Color(255, 255, 255));
        jLabel16.setFont(new java.awt.Font("Skia", 0, 16)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 102, 102));
        jLabel16.setText("Phone Number");

        UpdateBtn.setFont(new java.awt.Font("Skia", 1, 18)); // NOI18N
        UpdateBtn.setForeground(new java.awt.Color(0, 102, 102));
        UpdateBtn.setText("Update");
        UpdateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateBtnActionPerformed(evt);
            }
        });

        DeleteBtn.setFont(new java.awt.Font("Skia", 1, 18)); // NOI18N
        DeleteBtn.setForeground(new java.awt.Color(0, 102, 102));
        DeleteBtn.setText("Delete");
        DeleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteBtnActionPerformed(evt);
            }
        });

        ResetBtn.setFont(new java.awt.Font("Skia", 1, 18)); // NOI18N
        ResetBtn.setForeground(new java.awt.Color(0, 102, 102));
        ResetBtn.setText("Reset");
        ResetBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResetBtnActionPerformed(evt);
            }
        });

        SaveBtn.setFont(new java.awt.Font("Skia", 1, 18)); // NOI18N
        SaveBtn.setForeground(new java.awt.Color(0, 102, 102));
        SaveBtn.setText("Save");
        SaveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveBtnActionPerformed(evt);
            }
        });

        jLabel17.setBackground(new java.awt.Color(255, 255, 255));
        jLabel17.setFont(new java.awt.Font("Skia", 1, 36)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 102, 102));
        jLabel17.setText("Manage Customers");

        CustomersTable.setBackground(new java.awt.Color(0, 102, 102));
        CustomersTable.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        CustomersTable.setForeground(new java.awt.Color(255, 255, 255));
        CustomersTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Customer ID", "Customer Name", "Address", "Phone Number"
            }
        ));
        CustomersTable.setRowHeight(25);
        CustomersTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CustomersTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(CustomersTable);

        ExportBtn.setFont(new java.awt.Font("Skia", 1, 18)); // NOI18N
        ExportBtn.setForeground(new java.awt.Color(0, 102, 102));
        ExportBtn.setText("Export");
        ExportBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExportBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(70, 70, 70)
                                .addComponent(CustIdTb, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(78, 78, 78)
                                .addComponent(jLabel11)))
                        .addGap(49, 49, 49)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CustNameTb, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(jLabel12)))
                        .addGap(53, 53, 53)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 199, Short.MAX_VALUE))
                            .addComponent(CustAddressTb))
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addGap(137, 137, 137))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(ExportBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(CustPhoneTb, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(64, 64, 64))))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel10)
                        .addGap(459, 459, 459))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(393, 393, 393)
                        .addComponent(jLabel17)
                        .addContainerGap())
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(SaveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(100, 100, 100)
                        .addComponent(UpdateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(100, 100, 100)
                        .addComponent(DeleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(67, 67, 67)
                        .addComponent(ResetBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel17)
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CustIdTb, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CustNameTb, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CustAddressTb, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CustPhoneTb, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(UpdateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DeleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ResetBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SaveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ExportBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel10)
                .addGap(24, 24, 24)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 20, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void UpdateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateBtnActionPerformed
        if (CustIdTb.getText().isEmpty() || CustNameTb.getText().isEmpty() || 
        CustAddressTb.getText().isEmpty() || 
        CustPhoneTb.getText().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Please Select The Customer To Be Updated!", "Input Error", JOptionPane.ERROR_MESSAGE);
        return;
    }
    
    // Validating Price as an integer
    int id;
    try {
        id = Integer.parseInt(CustIdTb.getText());
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Id must be a valid number!", "Input Error", JOptionPane.ERROR_MESSAGE);
        return;
    }
    
    String Name = CustNameTb.getText();
    String Address = CustAddressTb.getText();
    String Phone = CustPhoneTb.getText();
    
    try {
        Statement St = Con.createStatement();
        
        // Сначала проверяем, существует ли запись с таким ID
        String checkQuery = "SELECT COUNT(*) FROM customertable WHERE \"CustId\" = '" + id + "'";
        ResultSet rs = St.executeQuery(checkQuery);
        rs.next();
        int count = rs.getInt(1);
        
        if (count == 0) {
            JOptionPane.showMessageDialog(this, "Customer with this ID does not exist!", "Error", JOptionPane.ERROR_MESSAGE);
            CustIdTb.setText("");
            return;
        }
        
        // Если запись существует, выполняем обновление
        String Query = "UPDATE customertable SET \"CustName\" = '" + Name + 
               "', \"CustAddress\" = '" + Address + 
               "', \"CustPhone\" = '" + Phone + 
               "' WHERE \"CustId\" = '" + id + "'";
        
        int k = St.executeUpdate(Query);

        if(k == 1) {
            JOptionPane.showMessageDialog(this, "The Customer Has Been Successfully Updated!");
            Reset();
            DisplayCustomers();
        } else {
            JOptionPane.showMessageDialog(this, "Record Failed To Update!");
            Reset();
        }
        } catch (SQLException e) {
        e.printStackTrace(); // Print SQL errors
        }
    }//GEN-LAST:event_UpdateBtnActionPerformed

    private void ResetBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResetBtnActionPerformed
        Reset();
    }//GEN-LAST:event_ResetBtnActionPerformed

    private void SaveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveBtnActionPerformed
        if (CustIdTb.getText().isEmpty() || CustNameTb.getText().isEmpty() || 
        CustAddressTb.getText().isEmpty() || 
        CustPhoneTb.getText().isEmpty() ){

        JOptionPane.showMessageDialog(this, "Please fill in all fields!", "Input Error", JOptionPane.ERROR_MESSAGE);
        return;
        }

        // Validating Price as an integer
        int id;
        try {
            id = Integer.parseInt(CustIdTb.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Id must be a valid number!", "Input Error", JOptionPane.ERROR_MESSAGE);
            CustIdTb.setText("");
            return;
        }

        try {
            PreparedStatement add = Con.prepareStatement("INSERT INTO customertable VALUES(?,?,?,?)");
            add.setInt(1, id);
            add.setString(2, CustNameTb.getText());
            add.setString(3, CustAddressTb.getText());
            add.setString(4, CustPhoneTb.getText());            

            int k = add.executeUpdate();
            JOptionPane.showMessageDialog(this, "Customer Added Successfully!");
            
            DisplayCustomers();
            Reset();
            
            add.close(); // Closing the statement to free resources
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Customer with this Passport ID already exists");
            Reset();
            e.printStackTrace();
        }
    }//GEN-LAST:event_SaveBtnActionPerformed

    private void CustomersTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CustomersTableMouseClicked
        DefaultTableModel model = (DefaultTableModel)CustomersTable.getModel();
        int MyIndex = CustomersTable.getSelectedRow();
        CustIdTb.setText(model.getValueAt(MyIndex, 0).toString());
        CustNameTb.setText(model.getValueAt(MyIndex, 1).toString());
        CustAddressTb.setText(model.getValueAt(MyIndex, 2).toString());
        CustPhoneTb.setText(model.getValueAt(MyIndex, 3).toString());
    }//GEN-LAST:event_CustomersTableMouseClicked

    private void DeleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteBtnActionPerformed
        if (CustIdTb.getText().isEmpty() || CustNameTb.getText().isEmpty() || 
        CustAddressTb.getText().isEmpty() || 
        CustPhoneTb.getText().isEmpty() ){

        JOptionPane.showMessageDialog(this, "Please Select The Customer To Be Deleted!", "Input Error", JOptionPane.ERROR_MESSAGE);
        return;
        }
        
        // Validating Price as an integer
        int id;
        try {
            id = Integer.parseInt(CustIdTb.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Id must be a valid number!", "Input Error", JOptionPane.ERROR_MESSAGE);
            CustIdTb.setText("");
            return;
        }
 
        String Query = "DELETE FROM customertable WHERE \"CustId\" = '" + id + "'";
        
        try {
                Statement St = Con.createStatement();
                int k = St.executeUpdate(Query);

                if (k == 1) {
                    JOptionPane.showMessageDialog(this, "The Customer Has Been Successfully Deleted!");
                    DisplayCustomers();
                    Reset();
                } else {
                    JOptionPane.showMessageDialog(this, "The Customer with this ID does not exist!");
                    Reset();
                }
                
            } catch (SQLException e) {
                e.printStackTrace(); // Print SQL errors
            }
    }//GEN-LAST:event_DeleteBtnActionPerformed

    private void CarsBTNMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CarsBTNMouseClicked
        new Cars().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_CarsBTNMouseClicked

    private void RentBTNMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RentBTNMouseClicked
        new Rents().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_RentBTNMouseClicked

    private void ReturnBTNMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ReturnBTNMouseClicked
        new Returns().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_ReturnBTNMouseClicked

    private void LogoutBTNMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LogoutBTNMouseClicked
        new Login().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_LogoutBTNMouseClicked

    private void ExitBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ExitBtnMouseClicked
        System.exit(0);
    }//GEN-LAST:event_ExitBtnMouseClicked

    private void lolMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lolMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lolMouseClicked

    private void ExportBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExportBtnActionPerformed
      
        String filename = System.getProperty("user.home")+"/Desktop/Customers.csv";
        
        PreparedStatement pst;
        try {
            FileWriter fout = new FileWriter(filename);
            pst = Con.prepareStatement("SELECT * FROM customertable");
            Rs = pst.executeQuery();

            while(Rs.next()){
                fout.append(Rs.getString(1));
                fout.append(",");
                fout.append(Rs.getString(2));
                fout.append(",");
                fout.append(Rs.getString(3));
                fout.append(",");
                fout.append(Rs.getString(4));
                fout.append("\n");
            }
            JOptionPane.showMessageDialog(this, "CSV file exported successfully");
            fout.flush();
            fout.close();
            
        } catch (IOException ex) {
            Logger.getLogger(Cars.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Cars.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ExportBtnActionPerformed

    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Customers().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CarsBTN;
    private javax.swing.JTextField CustAddressTb;
    private javax.swing.JTextField CustIdTb;
    private javax.swing.JTextField CustNameTb;
    private javax.swing.JTextField CustPhoneTb;
    private javax.swing.JTable CustomersTable;
    private javax.swing.JButton DeleteBtn;
    private javax.swing.JLabel ExitBtn;
    private javax.swing.JButton ExportBtn;
    private javax.swing.JLabel LogoutBTN;
    private javax.swing.JLabel RentBTN;
    private javax.swing.JButton ResetBtn;
    private javax.swing.JLabel ReturnBTN;
    private javax.swing.JButton SaveBtn;
    private javax.swing.JButton UpdateBtn;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JLabel lol;
    // End of variables declaration//GEN-END:variables
}
