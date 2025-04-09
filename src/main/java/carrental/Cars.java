package carrental;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;




public class Cars extends javax.swing.JFrame {

    
    public Cars() {
        initComponents();
        Connect();
        DisplayCars();
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
    
    
    @SuppressWarnings("unchecked")
    
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField5 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        CustomerBTN = new javax.swing.JLabel();
        RentBTN = new javax.swing.JLabel();
        ReturnBTN = new javax.swing.JLabel();
        LogoutBTN = new javax.swing.JLabel();
        lol = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        ExitBtn = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        StateNumTb = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        BrandTb = new javax.swing.JTextField();
        ModelTb = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        PriceTb = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        StatusCb = new javax.swing.JComboBox<>();
        UpdateBtn = new javax.swing.JButton();
        DeleteBtn = new javax.swing.JButton();
        ResetBtn = new javax.swing.JButton();
        SaveBtn = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        CarsTable = new javax.swing.JTable();
        ExportBtn = new javax.swing.JButton();

        jLabel15.setBackground(new java.awt.Color(255, 255, 255));
        jLabel15.setFont(new java.awt.Font("Skia", 0, 16)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 102, 102));
        jLabel15.setText("Registration Number");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));
        jPanel1.setForeground(new java.awt.Color(0, 102, 102));

        CustomerBTN.setBackground(new java.awt.Color(255, 255, 255));
        CustomerBTN.setFont(new java.awt.Font("Skia", 1, 24)); // NOI18N
        CustomerBTN.setForeground(new java.awt.Color(255, 255, 255));
        CustomerBTN.setText("Customer");
        CustomerBTN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CustomerBTNMouseClicked(evt);
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

        ReturnBTN.setBackground(new java.awt.Color(255, 255, 255));
        ReturnBTN.setFont(new java.awt.Font("Skia", 1, 24)); // NOI18N
        ReturnBTN.setForeground(new java.awt.Color(255, 255, 255));
        ReturnBTN.setText("Return Car");
        ReturnBTN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ReturnBTNMouseClicked(evt);
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

        lol.setBackground(new java.awt.Color(255, 255, 255));
        lol.setFont(new java.awt.Font("Skia", 1, 24)); // NOI18N
        lol.setForeground(new java.awt.Color(255, 255, 255));
        lol.setText("Cars>");
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
                    .addComponent(LogoutBTN)
                    .addComponent(CustomerBTN)
                    .addComponent(RentBTN)
                    .addComponent(ReturnBTN))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(200, 200, 200)
                .addComponent(lol)
                .addGap(30, 30, 30)
                .addComponent(CustomerBTN)
                .addGap(30, 30, 30)
                .addComponent(RentBTN)
                .addGap(30, 30, 30)
                .addComponent(ReturnBTN)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 339, Short.MAX_VALUE)
                .addComponent(LogoutBTN)
                .addGap(39, 39, 39))
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
                .addContainerGap(1095, Short.MAX_VALUE)
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
        jLabel10.setText("Car list");

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("Skia", 0, 16)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 102, 102));
        jLabel11.setText("State Number ");

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setFont(new java.awt.Font("Skia", 0, 16)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 102, 102));
        jLabel12.setText("Brand");

        ModelTb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModelTbActionPerformed(evt);
            }
        });

        jLabel13.setBackground(new java.awt.Color(255, 255, 255));
        jLabel13.setFont(new java.awt.Font("Skia", 0, 16)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 102, 102));
        jLabel13.setText("Model");

        jLabel14.setBackground(new java.awt.Color(255, 255, 255));
        jLabel14.setFont(new java.awt.Font("Skia", 0, 16)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 102, 102));
        jLabel14.setText("Status");

        jLabel16.setBackground(new java.awt.Color(255, 255, 255));
        jLabel16.setFont(new java.awt.Font("Skia", 0, 16)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 102, 102));
        jLabel16.setText("Price");

        StatusCb.setBackground(new java.awt.Color(255, 255, 255));
        StatusCb.setFont(new java.awt.Font("Apple LiGothic", 0, 18)); // NOI18N
        StatusCb.setForeground(new java.awt.Color(0, 102, 102));
        StatusCb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Booked", "Available" }));
        StatusCb.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));
        StatusCb.setPreferredSize(new java.awt.Dimension(96, 26));

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
        jLabel17.setText("Manage Cars");

        CarsTable.setBackground(new java.awt.Color(0, 102, 102));
        CarsTable.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        CarsTable.setForeground(new java.awt.Color(255, 255, 255));
        CarsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "State Number", "Brand", "Model", "Status", "Pricel"
            }
        ));
        CarsTable.setRowHeight(25);
        CarsTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CarsTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(CarsTable);

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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(StateNumTb, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(jLabel11)))
                                .addGap(40, 40, 40)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(BrandTb, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(8, 8, 8)
                                        .addComponent(jLabel12)))
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ModelTb, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel13)
                                        .addGap(134, 134, 134)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(StatusCb, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel14))
                                .addGap(48, 48, 48)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(PriceTb, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(jLabel16)))))
                        .addGap(12, 12, 12))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(525, 525, 525)
                                .addComponent(jLabel10))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(468, 468, 468)
                                .addComponent(jLabel17))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(120, 120, 120)
                                .addComponent(SaveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(60, 60, 60)
                                .addComponent(UpdateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(60, 60, 60)
                                .addComponent(DeleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(60, 60, 60)
                                .addComponent(ResetBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(64, 64, 64)
                                .addComponent(ExportBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel17)
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(StateNumTb, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BrandTb, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ModelTb, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel16)
                            .addComponent(jLabel14))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(StatusCb, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PriceTb, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(UpdateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DeleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ResetBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SaveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ExportBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel10)
                .addGap(28, 28, 28)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 20, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void Reset(){
        StateNumTb.setText("");
        BrandTb.setText("");
        ModelTb.setText("");
        StatusCb.setSelectedIndex(-1);
        PriceTb.setText("");
        StateNumTb.requestFocus();
    }
            
    private void DisplayCars(){
        try{
            St = Con.createStatement();
            Rs = St.executeQuery("SELECT * FROM cartable");
            CarsTable.setModel(DbUtils.resultSetToTableModel(Rs));
        }catch(SQLException e){
           e.printStackTrace(); 
        }
    }
    
    
    
    private void UpdateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateBtnActionPerformed
        if (StateNumTb.getText().isEmpty() || 
        BrandTb.getText().isEmpty() || 
        ModelTb.getText().isEmpty() || 
        StatusCb.getSelectedIndex() == -1 || 
        PriceTb.getText().isEmpty()) {

        JOptionPane.showMessageDialog(this, "Please Select The Car To Be Updated!", "Input Error", JOptionPane.ERROR_MESSAGE);
        return;
        }
        
        int price;
        try {
            price = Integer.parseInt(PriceTb.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Price must be a valid number!", "Input Error", JOptionPane.ERROR_MESSAGE);
            PriceTb.setText("");
            return;
        }
        
        String Num = StateNumTb.getText();
        String Brand = BrandTb.getText();
        String Model = ModelTb.getText();
        String Status = StatusCb.getSelectedItem().toString();
        
        String Query = "UPDATE cartable SET \"Brand\" = '" + Brand + 
               "', \"Model\" = '" + Model + 
               "', \"Status\" = '" + Status + 
               "', \"Price\" = " + price + 
               " WHERE \"StateNumber\" = '" + Num + "'";

            try {
                Statement St = Con.createStatement();
                int k = St.executeUpdate(Query);

                if(k == 1){
                    JOptionPane.showMessageDialog(this, "The Car Has Been Successfully Updated!");
                    Reset();
                    DisplayCars();
                }else{
                    JOptionPane.showMessageDialog(this, "Record Failed To Update!");
                    Reset();
                } 
            } catch (SQLException e) {
                e.printStackTrace(); // Print SQL errors
            }
    }//GEN-LAST:event_UpdateBtnActionPerformed

    private void SaveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveBtnActionPerformed
        
        if (StateNumTb.getText().isEmpty() || 
        BrandTb.getText().isEmpty() || 
        ModelTb.getText().isEmpty() || 
        StatusCb.getSelectedIndex() == -1 || 
        PriceTb.getText().isEmpty()) {

        JOptionPane.showMessageDialog(this, "Please fill in all fields!", "Input Error", JOptionPane.ERROR_MESSAGE);
        return;
        }

        // Validating Price as an integer
        int price;
        try {
            price = Integer.parseInt(PriceTb.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Price must be a valid number!", "Input Error", JOptionPane.ERROR_MESSAGE);
            PriceTb.setText("");
            return;
        }

        try {
            PreparedStatement add = Con.prepareStatement("INSERT INTO cartable VALUES(?,?,?,?,?)");
            add.setString(1, StateNumTb.getText());
            add.setString(2, BrandTb.getText());
            add.setString(3, ModelTb.getText());
            add.setString(4, StatusCb.getSelectedItem().toString());
            add.setInt(5, price);

            int k = add.executeUpdate();
            
            JOptionPane.showMessageDialog(this, "Car Added Successfully!");
            DisplayCars();
            Reset();
            
            
            add.close(); // Closing the statement to free resources
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Car with this State Number already exists!");
            e.printStackTrace();
        }
    }//GEN-LAST:event_SaveBtnActionPerformed

    private void ModelTbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModelTbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ModelTbActionPerformed

    private void DeleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteBtnActionPerformed
        String Num = StateNumTb.getText();
            String Query = "DELETE FROM cartable WHERE \"StateNumber\" = '" + Num + "'";

            try {
                Statement St = Con.createStatement();
                int k = St.executeUpdate(Query);

                if (k == 1) {
                    JOptionPane.showMessageDialog(this, "The Car Has Been Successfully Deleted!");
                    Reset();
                } else {
                    JOptionPane.showMessageDialog(this, "Please Select The Car to Be Deleted!");
                }

                DisplayCars(); 
            } catch (SQLException e) {
                e.printStackTrace(); // Print SQL errors
            }
    }//GEN-LAST:event_DeleteBtnActionPerformed

    private void CarsTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CarsTableMouseClicked
        DefaultTableModel model = (DefaultTableModel)CarsTable.getModel();
        int MyIndex = CarsTable.getSelectedRow();
        StateNumTb.setText(model.getValueAt(MyIndex, 0).toString());
        BrandTb.setText(model.getValueAt(MyIndex, 1).toString());
        ModelTb.setText(model.getValueAt(MyIndex, 2).toString());
        StatusCb.setSelectedItem(model.getValueAt(MyIndex, 3).toString());
        PriceTb.setText(model.getValueAt(MyIndex, 4).toString());
    }//GEN-LAST:event_CarsTableMouseClicked

    private void ResetBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResetBtnActionPerformed
        Reset();
    }//GEN-LAST:event_ResetBtnActionPerformed

    private void CustomerBTNMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CustomerBTNMouseClicked
        new Customers().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_CustomerBTNMouseClicked

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
        String filename = System.getProperty("user.home") + "/Desktop/Cars.csv";
        PreparedStatement pst;
        try {
            FileWriter fout = new FileWriter(filename);
            pst = Con.prepareStatement("SELECT * FROM cartable");
            Rs = pst.executeQuery();

            while(Rs.next()){
                fout.append(Rs.getString(1));
                fout.append(",");
                fout.append(Rs.getString(2));
                fout.append(",");
                fout.append(Rs.getString(3));
                fout.append(",");
                fout.append(Rs.getString(4));
                fout.append(",");
                fout.append(Rs.getString(5));
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
                new Cars().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField BrandTb;
    private javax.swing.JTable CarsTable;
    private javax.swing.JLabel CustomerBTN;
    private javax.swing.JButton DeleteBtn;
    private javax.swing.JLabel ExitBtn;
    private javax.swing.JButton ExportBtn;
    private javax.swing.JLabel LogoutBTN;
    private javax.swing.JTextField ModelTb;
    private javax.swing.JTextField PriceTb;
    private javax.swing.JLabel RentBTN;
    private javax.swing.JButton ResetBtn;
    private javax.swing.JLabel ReturnBTN;
    private javax.swing.JButton SaveBtn;
    private javax.swing.JTextField StateNumTb;
    private javax.swing.JComboBox<String> StatusCb;
    private javax.swing.JButton UpdateBtn;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
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
