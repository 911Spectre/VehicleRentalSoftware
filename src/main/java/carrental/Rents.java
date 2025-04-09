package carrental;

import java.awt.print.PrinterException;
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
import java.sql.Date;




public class Rents extends javax.swing.JFrame {

    
    public Rents() {
        initComponents();
        Connect();
        DisplayCars();
        Reset();
        GetCustomers();
        DisplayRents();
        UpdateCar();
        ExportAvailableCars();
        ExportRentedCars();
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
        RentIdTb.setText("");
        StateNumTb.setText("");
        CustCb.setSelectedIndex(-1);
        RentDate.setDate(null);
        ReturnDate.setDate(null);
        FeesTb.setText("");
    }
            
    private void DisplayCars(){
        String CarStatus = "Available";
        String Query = "SELECT * FROM cartable WHERE \"Status\"='" + CarStatus + "' ";
        try{
            St = Con.createStatement();
            Rs = St.executeQuery(Query);
            CarsTable.setModel(DbUtils.resultSetToTableModel(Rs));
        }catch(SQLException e){
           e.printStackTrace(); 
        }
    }
    
    private void DisplayRents(){
        try{
            St = Con.createStatement();
            Rs = St.executeQuery("SELECT * FROM renttable");
            RentsTable.setModel(DbUtils.resultSetToTableModel(Rs));
        }catch(SQLException e){
           e.printStackTrace(); 
        }
    }
    
    private void GetCustomers(){
        try {
            St = Con.createStatement();
            Rs = St.executeQuery("SELECT * FROM customertable");
            while(Rs.next()){
                String Customer = Rs.getString("CustName");
                CustCb.addItem(Customer);
            }
            
        } catch(Exception e){
            e.printStackTrace();
        }
    }
    
    private void UpdateCar(){
        
        String StateNum = StateNumTb.getText();
        String  CarStatus = "Booked";
        String Query = "UPDATE cartable SET \"Status\" = '" + CarStatus +  
               "' WHERE \"StateNumber\" = '" + StateNum + "'";


            try {
                Statement St = Con.createStatement();
                int k = St.executeUpdate(Query);

                if(k == 1){
                    Reset();
                    DisplayCars();
                }else{
                    Reset();
                } 
            } catch (SQLException e) {
                e.printStackTrace(); // Print SQL errors
            }
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField5 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        CustomersBTN = new javax.swing.JLabel();
        CarsBTN = new javax.swing.JLabel();
        ReturnBTN = new javax.swing.JLabel();
        LogoutBTN = new javax.swing.JLabel();
        lol = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        ExitBtn = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        RentIdTb = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        StateNumTb = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        CustCb = new javax.swing.JComboBox<>();
        UpdateBtn = new javax.swing.JButton();
        ResetBtn = new javax.swing.JButton();
        SaveBtn = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        RentsTable = new javax.swing.JTable();
        RentDate = new com.toedter.calendar.JDateChooser();
        ReturnDate = new com.toedter.calendar.JDateChooser();
        jLabel16 = new javax.swing.JLabel();
        FeesTb = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        CarsTable = new javax.swing.JTable();
        jLabel19 = new javax.swing.JLabel();
        PrintBtn = new javax.swing.JButton();

        jLabel15.setBackground(new java.awt.Color(255, 255, 255));
        jLabel15.setFont(new java.awt.Font("Skia", 0, 16)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 102, 102));
        jLabel15.setText("Registration Number");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));
        jPanel1.setForeground(new java.awt.Color(0, 102, 102));

        CustomersBTN.setBackground(new java.awt.Color(255, 255, 255));
        CustomersBTN.setFont(new java.awt.Font("Skia", 1, 24)); // NOI18N
        CustomersBTN.setForeground(new java.awt.Color(255, 255, 255));
        CustomersBTN.setText("Customers");
        CustomersBTN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CustomersBTNMouseClicked(evt);
            }
        });

        CarsBTN.setBackground(new java.awt.Color(255, 255, 255));
        CarsBTN.setFont(new java.awt.Font("Skia", 1, 24)); // NOI18N
        CarsBTN.setForeground(new java.awt.Color(255, 255, 255));
        CarsBTN.setText("Cars");
        CarsBTN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CarsBTNMouseClicked(evt);
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
        lol.setText("Rent Car>");
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
                    .addComponent(CustomersBTN)
                    .addComponent(CarsBTN)
                    .addComponent(ReturnBTN))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(250, 250, 250)
                .addComponent(CarsBTN)
                .addGap(30, 30, 30)
                .addComponent(CustomersBTN)
                .addGap(30, 30, 30)
                .addComponent(lol)
                .addGap(30, 30, 30)
                .addComponent(ReturnBTN)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addContainerGap(1136, Short.MAX_VALUE)
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
        jLabel10.setText("Cars on Rent");

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("Skia", 0, 16)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 102, 102));
        jLabel11.setText("Rent ID");

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setFont(new java.awt.Font("Skia", 0, 16)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 102, 102));
        jLabel12.setText("State Number");

        jLabel13.setBackground(new java.awt.Color(255, 255, 255));
        jLabel13.setFont(new java.awt.Font("Skia", 0, 16)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 102, 102));
        jLabel13.setText("Rent Date");

        jLabel14.setBackground(new java.awt.Color(255, 255, 255));
        jLabel14.setFont(new java.awt.Font("Skia", 0, 16)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 102, 102));
        jLabel14.setText("Customer Name");

        CustCb.setBackground(new java.awt.Color(255, 255, 255));
        CustCb.setFont(new java.awt.Font("Apple LiGothic", 0, 18)); // NOI18N
        CustCb.setForeground(new java.awt.Color(0, 102, 102));
        CustCb.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));
        CustCb.setPreferredSize(new java.awt.Dimension(96, 26));
        CustCb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CustCbActionPerformed(evt);
            }
        });

        UpdateBtn.setFont(new java.awt.Font("Skia", 1, 18)); // NOI18N
        UpdateBtn.setForeground(new java.awt.Color(0, 102, 102));
        UpdateBtn.setText("Update");
        UpdateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateBtnActionPerformed(evt);
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
        jLabel17.setText("Cars Rental");

        RentsTable.setBackground(new java.awt.Color(0, 102, 102));
        RentsTable.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        RentsTable.setForeground(new java.awt.Color(255, 255, 255));
        RentsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Rent ID", "State Number", "Customer", "Rent Date", "Return Date", "Fees"
            }
        ));
        RentsTable.setRowHeight(25);
        RentsTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RentsTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(RentsTable);

        RentDate.setFont(new java.awt.Font("Apple LiGothic", 1, 14)); // NOI18N

        ReturnDate.setFont(new java.awt.Font("Apple LiGothic", 1, 14)); // NOI18N

        jLabel16.setBackground(new java.awt.Color(255, 255, 255));
        jLabel16.setFont(new java.awt.Font("Skia", 0, 16)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 102, 102));
        jLabel16.setText("Fees");

        jLabel20.setBackground(new java.awt.Color(255, 255, 255));
        jLabel20.setFont(new java.awt.Font("Skia", 0, 16)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 102, 102));
        jLabel20.setText("Return Date");

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
        jScrollPane2.setViewportView(CarsTable);

        jLabel19.setBackground(new java.awt.Color(255, 255, 255));
        jLabel19.setFont(new java.awt.Font("Skia", 1, 28)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 102, 102));
        jLabel19.setText("Available Cars");

        PrintBtn.setFont(new java.awt.Font("Skia", 1, 18)); // NOI18N
        PrintBtn.setForeground(new java.awt.Color(0, 102, 102));
        PrintBtn.setText("Print");
        PrintBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PrintBtnActionPerformed(evt);
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
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(RentIdTb, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(jLabel11)))
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(StateNumTb, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(jLabel12)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CustCb, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(RentDate, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(jLabel13)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ReturnDate, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel20)
                                .addGap(84, 84, 84)))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(FeesTb, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addGap(79, 79, 79)))
                        .addGap(25, 25, 25))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(418, 418, 418)
                                .addComponent(PrintBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 989, Short.MAX_VALUE)
                            .addComponent(jScrollPane1))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addGap(476, 476, 476))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(SaveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(57, 57, 57)
                                .addComponent(UpdateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(60, 60, 60)
                                .addComponent(ResetBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(322, 322, 322))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel19)
                                .addGap(473, 473, 473))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(495, 495, 495))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel17)
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel11)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(RentIdTb, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel13)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(RentDate, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel14)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(CustCb, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel20)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(ReturnDate, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel16)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(FeesTb, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(StateNumTb, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(UpdateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ResetBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SaveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel10)
                .addGap(12, 12, 12)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(PrintBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 22, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    
    
    private void UpdateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateBtnActionPerformed
        if( 
        RentIdTb.getText().isEmpty() || StateNumTb.getText().isEmpty() 
        || CustCb.getSelectedIndex() == -1 || FeesTb.getText().isEmpty() 
        || RentDate.getDate() == null || ReturnDate.getDate() == null ){
            
        JOptionPane.showMessageDialog(this, "Please Select The Rent To Be Updated and fill in all fields!", "Input Error", JOptionPane.ERROR_MESSAGE);
        return;
        }
        
        // Validating Price as an integer
        int id;
        try {
            id = Integer.parseInt(RentIdTb.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Id must be a valid number!", "Input Error", JOptionPane.ERROR_MESSAGE);
            RentIdTb.setText("");
            return;
        }
        
        try{
            Statement St = Con.createStatement();
            
            String checkQuery = "SELECT COUNT(*) FROM renttable WHERE \"RentId\" = '" + id + "'";
            ResultSet rs = St.executeQuery(checkQuery);
            rs.next();
            int count = rs.getInt(1);
            
            if(count == 0){
                JOptionPane.showMessageDialog(this,"Rent with this ID does not exists!");
                return;
            }
            
            
            RentDat = RentDate.getDate(); // java.util.Date
            RetDat = ReturnDate.getDate(); // java.util.Date
            
            // Преобразование в java.sql.Date
            MyRentDat = new java.sql.Date(RentDat.getTime());
            MyRetDat = new java.sql.Date(RetDat.getTime());
            
             // Если запись существует, выполняем обновление
            String Query = "UPDATE renttable SET \"CustName\" = '" + CustCb.getSelectedItem().toString() + 
               "', \"RentDate\" = '" + MyRentDat +
               "', \"ReturnDate\" = '" + MyRetDat +
               "', \"RentFee\" = '" + FeesTb.getText().toString() +     
               "' WHERE \"RentId\" = '" + id + "'";
            
            int k = St.executeUpdate(Query);

            if(k == 1) {
                JOptionPane.showMessageDialog(this, "The Rent Has Been Successfully Updated!");
                
                Reset();
                DisplayCars();
                DisplayRents();
            } else {
                JOptionPane.showMessageDialog(this, "Record Failed To Update!");
                Reset();
            }
            } catch (SQLException e) {
            e.printStackTrace(); // Print SQL errors
            } 
    }//GEN-LAST:event_UpdateBtnActionPerformed

    private void RentsTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RentsTableMouseClicked
        DefaultTableModel model = (DefaultTableModel)RentsTable.getModel();
        int MyIndex = RentsTable.getSelectedRow();
        RentIdTb.setText(model.getValueAt(MyIndex, 0).toString());
        StateNumTb.setText(model.getValueAt(MyIndex, 1).toString());
        CustCb.setSelectedItem(model.getValueAt(MyIndex, 2).toString());
        RentDate.setDate((java.util.Date) model.getValueAt(MyIndex, 3));
        ReturnDate.setDate((java.util.Date) model.getValueAt(MyIndex, 4));
        FeesTb.setText(model.getValueAt(MyIndex, 5).toString());
    }//GEN-LAST:event_RentsTableMouseClicked

    private void CarsTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CarsTableMouseClicked
        DefaultTableModel model = (DefaultTableModel)CarsTable.getModel();
        int MyIndex = CarsTable.getSelectedRow();
        StateNumTb.setText(model.getValueAt(MyIndex, 0).toString());
    }//GEN-LAST:event_CarsTableMouseClicked

    PreparedStatement pst;
    
    private void ExportRentedCars(){
        String filename = System.getProperty("user.home") + "/Desktop/RentedCars.csv";
        
        try {
            FileWriter fout = new FileWriter(filename);
            pst = Con.prepareStatement("SELECT * FROM renttable");
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
                fout.append(",");
                fout.append(Rs.getString(6));
                fout.append("\n");
            }
            fout.flush();
            fout.close();
            
        } catch (IOException ex) {
            Logger.getLogger(Rents.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Rents.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void ExportAvailableCars(){
        String filename = System.getProperty("user.home") + "/Desktop/AvailableCars.csv";
        
        try {
            FileWriter fout = new FileWriter(filename);
            pst = Con.prepareStatement("SELECT * FROM cartable WHERE \"Status\" = 'Available'");
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
            fout.flush();
            fout.close();
            
        } catch (IOException ex) {
            Logger.getLogger(Rents.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Rents.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void PrintBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PrintBtnActionPerformed
        ExportAvailableCars();
        ExportRentedCars();
        JOptionPane.showMessageDialog(this, "CSV files exported successfully");
    }//GEN-LAST:event_PrintBtnActionPerformed

    
    java.util.Date RentDat,RetDat;
    java.sql.Date MyRentDat, MyRetDat;
    private void SaveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveBtnActionPerformed
        if( 
        RentIdTb.getText().isEmpty() || StateNumTb.getText().isEmpty() 
        || CustCb.getSelectedIndex() == -1 || FeesTb.getText().isEmpty() 
        || RentDate.getDate() == null || ReturnDate.getDate() == null ){
            
        JOptionPane.showMessageDialog(this, "Please fill in all fields!", "Input Error", JOptionPane.ERROR_MESSAGE);
        return;
        }
        
        // Validating Price as an integer
        int id;
        try {
            id = Integer.parseInt(RentIdTb.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Id must be a valid number!", "Input Error", JOptionPane.ERROR_MESSAGE);
            RentIdTb.setText("");
            return;
        }

        try {
            // Преобразование в java.sql.Date
            RentDat = RentDate.getDate(); // Получаем java.util.Date из RentDate
            RetDat = ReturnDate.getDate(); // Получаем java.util.Date из ReturnDate
            
            // Преобразование в java.sql.Date с использованием полей класса
            MyRentDat = new java.sql.Date(RentDat.getTime());
            MyRetDat = new java.sql.Date(RetDat.getTime());
            
            PreparedStatement add = Con.prepareStatement("INSERT INTO renttable VALUES(?,?,?,?,?,?)");
            add.setInt(1, id);
            add.setString(2, StateNumTb.getText());
            add.setString(3, CustCb.getSelectedItem().toString());
            add.setDate(4, MyRentDat);            
            add.setDate(5, MyRetDat);
            add.setInt(6, Integer.valueOf(FeesTb.getText()));
            int k = add.executeUpdate();
            JOptionPane.showMessageDialog(this, "Car Rented Successfully!");
            
            DisplayCars();
            DisplayRents();
            UpdateCar();
            Reset();
            
            add.close(); // Closing the statement to free resources
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Failed To Record!");
            RentIdTb.setText("");
            e.printStackTrace();
        }
    }//GEN-LAST:event_SaveBtnActionPerformed

    private void ResetBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResetBtnActionPerformed
        Reset();
    }//GEN-LAST:event_ResetBtnActionPerformed

    private void CustCbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CustCbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CustCbActionPerformed

    private void CustomersBTNMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CustomersBTNMouseClicked
        new Customers().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_CustomersBTNMouseClicked

    private void CarsBTNMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CarsBTNMouseClicked
        new Cars().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_CarsBTNMouseClicked

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

    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Rents().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CarsBTN;
    private javax.swing.JTable CarsTable;
    private javax.swing.JComboBox<String> CustCb;
    private javax.swing.JLabel CustomersBTN;
    private javax.swing.JLabel ExitBtn;
    private javax.swing.JTextField FeesTb;
    private javax.swing.JLabel LogoutBTN;
    private javax.swing.JButton PrintBtn;
    private com.toedter.calendar.JDateChooser RentDate;
    private javax.swing.JTextField RentIdTb;
    private javax.swing.JTable RentsTable;
    private javax.swing.JButton ResetBtn;
    private javax.swing.JLabel ReturnBTN;
    private com.toedter.calendar.JDateChooser ReturnDate;
    private javax.swing.JButton SaveBtn;
    private javax.swing.JTextField StateNumTb;
    private javax.swing.JButton UpdateBtn;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JLabel lol;
    // End of variables declaration//GEN-END:variables
}
