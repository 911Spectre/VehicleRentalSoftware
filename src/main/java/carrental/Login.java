package carrental;

import java.sql.Connection; // Library to connect sql
import java.sql.DriverManager; // To connect data base
import java.sql.PreparedStatement; // To prepare secure request
import java.sql.ResultSet; // Keeps result of request SELECT (Table with data)
import java.sql.SQLException; // Data Base error handling
import javax.swing.JOptionPane; // Shows pop-up windows
import net.proteanit.sql.DbUtils;  // Simplifies loading data from a ResultSet into a JTable

public class Login extends javax.swing.JFrame {

    public Login() {
        initComponents();
        Reset();
        Connect();
        setLocationRelativeTo(null);
    }
    
    // Function to clean unput boxes
    private void Reset(){
        UsernameTb.setText("");
        PasswordTb.setText("");
    }
    
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    
    public void Connect() {
    try {
            // Загружаем драйвер PostgreSQL
            Class.forName("org.postgresql.Driver");
            
            // Connecting to db
            con = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/vehicledb",  // URL 
                "sopakunovarslan",  // username 
                "911Spectre"        // password
            );
            
            System.out.println("Connected to the database successfully!");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        ResetBtn = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        LoginBtn = new javax.swing.JButton();
        ExitBtn = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        UsernameTb = new javax.swing.JTextField();
        PasswordTb = new javax.swing.JPasswordField();
        jPanel3 = new javax.swing.JPanel();
        CreateBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 51, 153));
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(0, 51, 153));

        jLabel7.setBackground(new java.awt.Color(0, 51, 153));
        jLabel7.setFont(new java.awt.Font("Skia", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 51, 153));
        jLabel7.setText("Amazing Service");

        jLabel8.setBackground(new java.awt.Color(0, 51, 153));
        jLabel8.setFont(new java.awt.Font("Skia", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 51, 153));
        jLabel8.setText("Security");

        jLabel9.setBackground(new java.awt.Color(0, 51, 153));
        jLabel9.setFont(new java.awt.Font("Skia", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 51, 153));
        jLabel9.setText("Responsivness");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(10, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel9)
                            .addGap(9, 9, 9))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(37, 37, 37)
                            .addComponent(jLabel8)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel2))
                .addGap(15, 15, 15))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(92, 92, 92)
                .addComponent(jLabel7)
                .addGap(30, 30, 30)
                .addComponent(jLabel8)
                .addGap(29, 29, 29)
                .addComponent(jLabel9)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(0, 51, 153));
        jPanel2.setForeground(new java.awt.Color(0, 51, 153));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Skia", 1, 28)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Car Rental Software");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, 299, -1));

        ResetBtn.setFont(new java.awt.Font("Skia", 1, 14)); // NOI18N
        ResetBtn.setForeground(new java.awt.Color(255, 255, 255));
        ResetBtn.setText("Reset");
        ResetBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ResetBtnMouseClicked(evt);
            }
        });
        jPanel2.add(ResetBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 270, -1, -1));

        jLabel5.setFont(new java.awt.Font("Skia", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Password");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, -1, -1));

        LoginBtn.setFont(new java.awt.Font("Skia", 1, 12)); // NOI18N
        LoginBtn.setForeground(new java.awt.Color(0, 51, 153));
        LoginBtn.setText("Login");
        LoginBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LoginBtnMouseClicked(evt);
            }
        });
        LoginBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginBtnActionPerformed(evt);
            }
        });
        jPanel2.add(LoginBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 240, -1, -1));

        ExitBtn.setFont(new java.awt.Font("Monospaced", 1, 24)); // NOI18N
        ExitBtn.setForeground(new java.awt.Color(255, 255, 255));
        ExitBtn.setText("x");
        ExitBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ExitBtnMouseClicked(evt);
            }
        });
        jPanel2.add(ExitBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 0, -1, -1));

        jLabel6.setFont(new java.awt.Font("Skia", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Username");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, -1, -1));

        UsernameTb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UsernameTbActionPerformed(evt);
            }
        });
        jPanel2.add(UsernameTb, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 150, 160, 35));
        jPanel2.add(PasswordTb, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 200, 160, 35));

        jPanel3.setBackground(new java.awt.Color(0, 51, 153));
        jPanel3.setForeground(new java.awt.Color(0, 51, 153));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 70, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 50, 20, 70));

        CreateBtn.setFont(new java.awt.Font("Skia", 1, 12)); // NOI18N
        CreateBtn.setForeground(new java.awt.Color(0, 51, 153));
        CreateBtn.setText("Create");
        CreateBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CreateBtnMouseClicked(evt);
            }
        });
        CreateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreateBtnActionPerformed(evt);
            }
        });
        jPanel2.add(CreateBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 240, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 322, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void LoginBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LoginBtnMouseClicked
       
    }//GEN-LAST:event_LoginBtnMouseClicked

    private void ResetBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ResetBtnMouseClicked
        Reset();
    }//GEN-LAST:event_ResetBtnMouseClicked

    private void LoginBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginBtnActionPerformed
       
        if(UsernameTb.getText().isEmpty() || PasswordTb.getPassword().length == 0){
            JOptionPane.showMessageDialog(this, "Please fill in all fields ! ");
        }else if (PasswordTb.getPassword().length < 5){
            JOptionPane.showMessageDialog(this, "Password must have minimum 5 symbols! ");
            return;
        }else if(UsernameTb.getText().length() < 5){
            JOptionPane.showMessageDialog(this, "Username must have minimum 5 symbols! ");
            return;
        }else {
            String user =  UsernameTb.getText();
            String pwd = new String(PasswordTb.getPassword());

            try {
                String sql = "SELECT * FROM users"; 
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();

                boolean found = false;

                while (rs.next()) {
                    String uname = rs.getString("username");
                    String password = rs.getString("password");

                    if (user.equals(uname) && pwd.equals(password)) {
                        found = true;
                        break;
                    }
                }

                // if user exists and password is correct it gives access to the program
                if (found) {
                    new Cars().setVisible(true);
                    this.dispose();
                } else {
                    Reset();
                    JOptionPane.showMessageDialog(this, "Username or Password is incorrect!");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }     
        
    }//GEN-LAST:event_LoginBtnActionPerformed

    private void UsernameTbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UsernameTbActionPerformed

    }//GEN-LAST:event_UsernameTbActionPerformed

    private void ExitBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ExitBtnMouseClicked
        System.exit(0);
    }//GEN-LAST:event_ExitBtnMouseClicked

    private void CreateBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CreateBtnMouseClicked

    }//GEN-LAST:event_CreateBtnMouseClicked

    // Function to create new user. (Only for administrators)
    private void CreateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreateBtnActionPerformed
        
        if(UsernameTb.getText().isEmpty() || PasswordTb.getPassword().length == 0){
            
        JOptionPane.showMessageDialog(this, "Please fill in all fields ! ");
        
        } else {
            String user =  UsernameTb.getText();
            String pwd = new String(PasswordTb.getPassword());

            if (user.equals("admin") && pwd.equals("admin")) {                
                new CreateUser().setVisible(true);
                this.dispose();
            } else {
                Reset();
                JOptionPane.showMessageDialog(this, "Only Administrator can create a new user!");
              }
          }
    }//GEN-LAST:event_CreateBtnActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CreateBtn;
    private javax.swing.JLabel ExitBtn;
    private javax.swing.JButton LoginBtn;
    private javax.swing.JPasswordField PasswordTb;
    private javax.swing.JLabel ResetBtn;
    private javax.swing.JTextField UsernameTb;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables

}
