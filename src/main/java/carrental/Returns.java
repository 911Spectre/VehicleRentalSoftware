package carrental;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;
import java.sql.Date;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

public class Returns extends javax.swing.JFrame {

    
    public Returns() {
        initComponents();
        Connect();
        DisplayRents();
        GetCustomers();
        DisplayReturnedCars();
        UpdateCar();
        ExportRentedCars();
        ExportReturnedCars();
        
        CustCb.setEditable(false);
        StateNumTb.setEditable(false);
        DelayTb.setEditable(false);
        FineTb.setEditable(false);
    }
    
    Connection Con;
    Statement St;
    ResultSet Rs;

    public void Connect() {
    try {
            Class.forName("org.postgresql.Driver");
            
            Con = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/vehicledb", 
                "sopakunovarslan",  
                "911Spectre"        
            );
            
            System.out.println("Connected to the database successfully!");

        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            System.out.print("PostgreSQL JDBC Driver not found!");
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.print("Database connection failed!");
        }
    }
    
    private void Reset(){
        StateNumTb.setText("");
        CustCb.setSelectedIndex(-1);
        ReturnDate.setDate(null);
        DelayTb.setText("");
        FineTb.setText("");
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
        
    private void UpdateRentStatus(){
                
        String Query = "DELETE FROM renttable WHERE \"CarStateNum\" = '" + StateNumTb.getText().toString() + "'";
        
        try {
                Statement St = Con.createStatement();
                int k = St.executeUpdate(Query);

                if (k == 1) {
                    JOptionPane.showMessageDialog(this, "The Car Has Been Successfully Returned!");
                    DisplayReturnedCars();
                } else {
                    JOptionPane.showMessageDialog(this, "The Car with this ID does not exist!");
                    Reset();
                }
                
            } catch (SQLException e) {
                e.printStackTrace(); // Print SQL errors
            }    
    }
    
    private void UpdateCar(){
    String StateNum = StateNumTb.getText().trim();
    String CarStatus = "Available";
    
    String sql = "UPDATE cartable SET \"Status\" = ? WHERE \"StateNumber\" = ?";

    try {
        PreparedStatement pst = Con.prepareStatement(sql);
        pst.setString(1, CarStatus);
        pst.setString(2, StateNum);

        int k = pst.executeUpdate();

        if (k > 0) {
            System.out.println("Car status updated to 'Available' for StateNumber: " + StateNum);
        } else {
            
        }

        Reset();
    } catch (SQLException e) {
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
    
    
    private void DisplayReturnedCars(){
        try{
            St = Con.createStatement();
            Rs = St.executeQuery("SELECT * FROM returntable");
            ReturnsTable.setModel(DbUtils.resultSetToTableModel(Rs));
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
        CustomerBTN = new javax.swing.JLabel();
        RentBTN = new javax.swing.JLabel();
        CarsBTN = new javax.swing.JLabel();
        LogoutBTN = new javax.swing.JLabel();
        lol = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        ExitBtn = new javax.swing.JLabel();
        StateNumTb = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        ReturnDate = new com.toedter.calendar.JDateChooser();
        jLabel20 = new javax.swing.JLabel();
        DelayTb = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        FineTb = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        ReturnBtn = new javax.swing.JButton();
        ExportBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        RentsTable = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        ReturnsTable = new javax.swing.JTable();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        GenerateBtn = new javax.swing.JButton();
        CustCb = new javax.swing.JComboBox<>();
        jLabel18 = new javax.swing.JLabel();
        ResetBtn = new javax.swing.JButton();

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
        CustomerBTN.setText("Customers");
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

        CarsBTN.setBackground(new java.awt.Color(255, 255, 255));
        CarsBTN.setFont(new java.awt.Font("Skia", 1, 24)); // NOI18N
        CarsBTN.setForeground(new java.awt.Color(255, 255, 255));
        CarsBTN.setText("Cars");
        CarsBTN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CarsBTNMouseClicked(evt);
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
        lol.setText("Return Car>");
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
                    .addComponent(CarsBTN))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(250, 250, 250)
                .addComponent(CarsBTN)
                .addGap(30, 30, 30)
                .addComponent(CustomerBTN)
                .addGap(30, 30, 30)
                .addComponent(RentBTN)
                .addGap(30, 30, 30)
                .addComponent(lol)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 368, Short.MAX_VALUE)
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
                .addContainerGap(1103, Short.MAX_VALUE)
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

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setFont(new java.awt.Font("Skia", 0, 16)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 102, 102));
        jLabel12.setText("State Number");

        ReturnDate.setFont(new java.awt.Font("Apple LiGothic", 1, 14)); // NOI18N

        jLabel20.setBackground(new java.awt.Color(255, 255, 255));
        jLabel20.setFont(new java.awt.Font("Skia", 0, 16)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 102, 102));
        jLabel20.setText("Customer");

        DelayTb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DelayTbActionPerformed(evt);
            }
        });

        jLabel13.setBackground(new java.awt.Color(255, 255, 255));
        jLabel13.setFont(new java.awt.Font("Skia", 0, 16)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 102, 102));
        jLabel13.setText("Return Date");

        jLabel14.setBackground(new java.awt.Color(255, 255, 255));
        jLabel14.setFont(new java.awt.Font("Skia", 0, 16)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 102, 102));
        jLabel14.setText("Fine");

        ReturnBtn.setFont(new java.awt.Font("Skia", 1, 18)); // NOI18N
        ReturnBtn.setForeground(new java.awt.Color(0, 102, 102));
        ReturnBtn.setText("Return");
        ReturnBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReturnBtnActionPerformed(evt);
            }
        });

        ExportBtn.setFont(new java.awt.Font("Skia", 1, 18)); // NOI18N
        ExportBtn.setForeground(new java.awt.Color(0, 102, 102));
        ExportBtn.setText("Export");
        ExportBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExportBtnActionPerformed(evt);
            }
        });

        RentsTable.setBackground(new java.awt.Color(0, 102, 102));
        RentsTable.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        RentsTable.setForeground(new java.awt.Color(255, 255, 255));
        RentsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "State Number", "Customer", "Rent Date", "Return Date", "Fee"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        RentsTable.setRowHeight(25);
        RentsTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RentsTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(RentsTable);
        if (RentsTable.getColumnModel().getColumnCount() > 0) {
            RentsTable.getColumnModel().getColumn(0).setResizable(false);
            RentsTable.getColumnModel().getColumn(1).setResizable(false);
            RentsTable.getColumnModel().getColumn(2).setResizable(false);
            RentsTable.getColumnModel().getColumn(3).setResizable(false);
            RentsTable.getColumnModel().getColumn(4).setResizable(false);
        }

        ReturnsTable.setBackground(new java.awt.Color(0, 102, 102));
        ReturnsTable.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        ReturnsTable.setForeground(new java.awt.Color(255, 255, 255));
        ReturnsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "State Number", "Customer", "Return Date", "Delay", "Fine"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        ReturnsTable.setRowHeight(25);
        ReturnsTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ReturnsTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(ReturnsTable);
        if (ReturnsTable.getColumnModel().getColumnCount() > 0) {
            ReturnsTable.getColumnModel().getColumn(0).setResizable(false);
            ReturnsTable.getColumnModel().getColumn(2).setResizable(false);
            ReturnsTable.getColumnModel().getColumn(3).setResizable(false);
            ReturnsTable.getColumnModel().getColumn(4).setResizable(false);
        }

        jLabel16.setBackground(new java.awt.Color(255, 255, 255));
        jLabel16.setFont(new java.awt.Font("Skia", 1, 24)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 102, 102));
        jLabel16.setText("Cars on Rent");

        jLabel17.setBackground(new java.awt.Color(255, 255, 255));
        jLabel17.setFont(new java.awt.Font("Skia", 1, 24)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 102, 102));
        jLabel17.setText("Returned Cars");

        jLabel19.setBackground(new java.awt.Color(255, 255, 255));
        jLabel19.setFont(new java.awt.Font("Skia", 0, 16)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 102, 102));
        jLabel19.setText("Delay");

        GenerateBtn.setBackground(new java.awt.Color(0, 102, 102));
        GenerateBtn.setFont(new java.awt.Font("Webdings", 1, 13)); // NOI18N
        GenerateBtn.setForeground(new java.awt.Color(0, 102, 102));
        GenerateBtn.setText("k");
        GenerateBtn.setSize(new java.awt.Dimension(40, 40));
        GenerateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GenerateBtnActionPerformed(evt);
            }
        });

        CustCb.setBackground(new java.awt.Color(255, 255, 255));
        CustCb.setFont(new java.awt.Font("Apple LiGothic", 0, 18)); // NOI18N
        CustCb.setForeground(new java.awt.Color(0, 102, 102));
        CustCb.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));
        CustCb.setPreferredSize(new java.awt.Dimension(96, 26));

        jLabel18.setBackground(new java.awt.Color(255, 255, 255));
        jLabel18.setFont(new java.awt.Font("Skia", 0, 16)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 102, 102));
        jLabel18.setText("count");

        ResetBtn.setFont(new java.awt.Font("Skia", 1, 18)); // NOI18N
        ResetBtn.setForeground(new java.awt.Color(0, 102, 102));
        ResetBtn.setText("Reset");
        ResetBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResetBtnActionPerformed(evt);
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
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(ReturnBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(StateNumTb)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel20)
                                    .addComponent(jLabel14)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel19)
                                    .addComponent(ReturnDate, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(DelayTb, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CustCb, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(FineTb, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel18)
                                    .addComponent(GenerateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(ResetBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(2, 2, 2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 756, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 756, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(57, 57, 57))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(350, 350, 350)
                                .addComponent(jLabel17)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(ExportBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(375, 375, 375))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel16)
                        .addGap(379, 379, 379))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61)
                .addComponent(jLabel16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel17)
                        .addGap(12, 12, 12)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(jLabel12)
                        .addGap(6, 6, 6)
                        .addComponent(StateNumTb, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(jLabel20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CustCb, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(jLabel13)
                        .addGap(6, 6, 6)
                        .addComponent(ReturnDate, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(DelayTb, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(jLabel18))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(FineTb, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(25, 25, 25)
                                .addComponent(ReturnBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(GenerateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addComponent(ResetBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ExportBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    java.util.Date RetDat;
    java.sql.Date MyRetDat;
    private void ReturnBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReturnBtnActionPerformed
        try {
            String StateNumber = StateNumTb.getText().toString();
            PreparedStatement pst = Con.prepareStatement("SELECT \"CarStateNum\" FROM renttable WHERE \"CarStateNum\" = ?");
            pst.setString(1, StateNumber);
            ResultSet rs = pst.executeQuery();

            if (!rs.next()) {
                JOptionPane.showMessageDialog(this, "The Rent with this State number does not exist!", "Input Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (
                StateNumTb.getText().isEmpty()
                || ReturnDate.getDate() == null || DelayTb.getText().isEmpty()
                || FineTb.getText().isEmpty() || CustCb.getSelectedIndex() == -1) {

                JOptionPane.showMessageDialog(this, "Please fill in all fields!", "Input Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            RetDat = ReturnDate.getDate(); 
            MyRetDat = new java.sql.Date(RetDat.getTime());

            PreparedStatement add = Con.prepareStatement(
                "INSERT INTO returntable (\"CarStateNum\", \"CustName\", \"RetDate\", \"Delay\", \"Fine\") VALUES (?, ?, ?, ?, ?)");

            add.setString(1, StateNumTb.getText());
            add.setString(2, CustCb.getSelectedItem().toString());
            add.setDate(3, MyRetDat);
            add.setInt(4, Integer.parseInt(DelayTb.getText()));
            add.setInt(5, Integer.parseInt(FineTb.getText()));

            int k = add.executeUpdate();
            

            UpdateRentStatus();
            DisplayReturnedCars();
            DisplayRents();
            UpdateCar();
            
            add.close();

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "ID, Delay, and Fine must be valid numbers!", "Input Error", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Failed to interact with database!");
            ex.printStackTrace();
        } catch (Exception e){
            JOptionPane.showMessageDialog(this, "Failed To Record!");
            e.printStackTrace();
        }
    }//GEN-LAST:event_ReturnBtnActionPerformed

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
                fout.append("\n");
            }
            fout.flush();
            fout.close();
            
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    
    private void ExportReturnedCars(){
        String filename = System.getProperty("user.home") + "/Desktop/ReturnedCars.csv";
        
        try {
            FileWriter fout = new FileWriter(filename);
            pst = Con.prepareStatement("SELECT * FROM returntable");
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
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    private void ExportBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExportBtnActionPerformed
        ExportRentedCars();
        ExportReturnedCars();
        JOptionPane.showMessageDialog(this, "CSV files exported successfully");
    }//GEN-LAST:event_ExportBtnActionPerformed

    private void RentsTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RentsTableMouseClicked
        Reset();
        DefaultTableModel model = (DefaultTableModel)RentsTable.getModel();
        int MyIndex = RentsTable.getSelectedRow();
        StateNumTb.setText(model.getValueAt(MyIndex, 0).toString());
        CustCb.setSelectedItem(model.getValueAt(MyIndex, 1).toString());
    }//GEN-LAST:event_RentsTableMouseClicked

    private void ReturnsTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ReturnsTableMouseClicked
        Reset();
        DefaultTableModel model = (DefaultTableModel)ReturnsTable.getModel();
        int MyIndex = ReturnsTable.getSelectedRow();
        StateNumTb.setText(model.getValueAt(MyIndex, 0).toString());
        CustCb.setSelectedItem(model.getValueAt(MyIndex, 1).toString());
        ReturnDate.setDate((java.util.Date) model.getValueAt(MyIndex, 2));
        DelayTb.setText(model.getValueAt(MyIndex, 3).toString());
        FineTb.setText(model.getValueAt(MyIndex, 4).toString());
    }//GEN-LAST:event_ReturnsTableMouseClicked

    
    private void GenerateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GenerateBtnActionPerformed
       
        try {
        String StateNumber = StateNumTb.getText().toString();
        
        // 1. Request to get ReturnDate from renttable
        String sql1 = "SELECT \"ReturnDate\" FROM renttable WHERE \"CarStateNum\" = ?";
        PreparedStatement ps1 = Con.prepareStatement(sql1);
        ps1.setString(1, StateNumber);  // Используем параметризацию запроса

        ResultSet rs1 = ps1.executeQuery(); 
        
        if (rs1.next()) {
            // Getting Return Date from db
            Date dbReturnDate = rs1.getDate("ReturnDate");

            // Getting Return date from DateChooser
            java.util.Date utilReturnDate = ReturnDate.getDate();
            java.sql.Date returnDate = new java.sql.Date(utilReturnDate.getTime());

            // Counting difference
            long diffInDays = (returnDate.getTime() - dbReturnDate.getTime()) / (1000 * 60 * 60 * 24);
            int delayDays = (int) diffInDays;  // Parsing into Int

            String delayDaysString = String.valueOf(delayDays);
            if (delayDays <= 0) {
                DelayTb.setText("0");
            } else {
                DelayTb.setText(delayDaysString);
            }
            
            // Request to get price from cartable
            String sql2 = "SELECT \"Price\" FROM cartable WHERE \"StateNumber\" = ?";
            PreparedStatement ps2 = Con.prepareStatement(sql2);
            ps2.setString(1, StateNumber);

            ResultSet rs2 = ps2.executeQuery();
            int price = 0;
            if (rs2.next()) {
                price = rs2.getInt("Price");
            } else {
                JOptionPane.showMessageDialog(this, "No price found for the given StateNumber.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Request to get fees from renttable
            String sql3 = "SELECT \"RentFees\" FROM renttable WHERE \"CarStateNum\" = ?";
            PreparedStatement ps3 = Con.prepareStatement(sql3);
            ps3.setString(1, StateNumber);  

            ResultSet rs3 = ps3.executeQuery();
            int fees = 0;
            if (rs3.next()) {
                fees = rs3.getInt("RentFees");
            } else {
                JOptionPane.showMessageDialog(this, "No fees found for the given StateNumber.", "Error", JOptionPane.ERROR_MESSAGE);
                return; 
            }
            
            // If difference is less than 1 delay is 1
            if (delayDays <= 0) {
                delayDays = 0;
            }
            
            // Counting fine 
            int fine;
            if(delayDays <= 0){
                fine = fees;
            }else{
                fine = fees + (delayDays * price);
            }
           
            FineTb.setText(String.valueOf(fine));

            } else {
                JOptionPane.showMessageDialog(this, "No record found with that StateNumber.", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (Exception e) {
            e.printStackTrace();
        JOptionPane.showMessageDialog(this, "An error occurred.", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_GenerateBtnActionPerformed

    private void DelayTbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DelayTbActionPerformed
        
    }//GEN-LAST:event_DelayTbActionPerformed

    private void CustomerBTNMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CustomerBTNMouseClicked
        new Customers().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_CustomerBTNMouseClicked

    private void RentBTNMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RentBTNMouseClicked
        new Rents().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_RentBTNMouseClicked

    private void CarsBTNMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CarsBTNMouseClicked
        new Cars().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_CarsBTNMouseClicked

    private void LogoutBTNMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LogoutBTNMouseClicked
        new Login().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_LogoutBTNMouseClicked

    private void ExitBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ExitBtnMouseClicked
        System.exit(0);
    }//GEN-LAST:event_ExitBtnMouseClicked

    private void lolMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lolMouseClicked
        
    }//GEN-LAST:event_lolMouseClicked

    private void ResetBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResetBtnActionPerformed
        StateNumTb.setText("");
        CustCb.setSelectedIndex(-1);
        ReturnDate.setDate(null);
        DelayTb.setText("");
        FineTb.setText("");
    }//GEN-LAST:event_ResetBtnActionPerformed

    
    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Returns().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CarsBTN;
    private javax.swing.JComboBox<String> CustCb;
    private javax.swing.JLabel CustomerBTN;
    private javax.swing.JTextField DelayTb;
    private javax.swing.JLabel ExitBtn;
    private javax.swing.JButton ExportBtn;
    private javax.swing.JTextField FineTb;
    private javax.swing.JButton GenerateBtn;
    private javax.swing.JLabel LogoutBTN;
    private javax.swing.JLabel RentBTN;
    private javax.swing.JTable RentsTable;
    private javax.swing.JButton ResetBtn;
    private javax.swing.JButton ReturnBtn;
    private com.toedter.calendar.JDateChooser ReturnDate;
    private javax.swing.JTable ReturnsTable;
    private javax.swing.JTextField StateNumTb;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
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
