
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import static java.util.Collections.list;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Bishal
 */
public class staffapplicantview extends javax.swing.JFrame {
   String filename=null , filename1=null;//location
byte[] image, sign=null; //image
    /**
     * Creates new form staffapplicantview
     */
    public staffapplicantview() {
        initComponents();
              Toolkit tk = getToolkit();
 int xsize=(int) tk.getScreenSize().getWidth();
  int ysize=(int) tk.getScreenSize().getHeight();
   this.setSize(xsize,ysize); 
   show_user();
      this.image=null;
   this.sign=null;

    }
public ArrayList<User> userList(){
    ArrayList<User> userList= new ArrayList<>();//create object named arraylist
    //select data from the database
    try{
     Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  // load the driver
           String url = "jdbc:sqlserver://localhost:1433;databaseName=bankoneer_db;user=sa;password=bishal";
           Connection con = DriverManager.getConnection(url);
           String query1 = "Select * from bankapplicantregistration";
           Statement st = con.createStatement();
      ResultSet rs = st.executeQuery(query1);
      //create object for user
      User user;
      while(rs.next()){ 
          //provide data in user object
          user= new User(rs.getInt("sno"),rs.getString("branch"),rs.getString("date"),rs.getString("department"),rs.getString("name"),rs.getString("dobad"),rs.getString("father"),rs.getString("mother"),rs.getString("taddress"),rs.getString("mno"),rs.getString("email"),rs.getString("citizenship"),rs.getString("username"),rs.getString("password"), rs.getBytes("image"), rs.getBytes("signature"));
      //add user to the user list
      userList.add(user);
                  
                  }
    }
    catch(Exception e){
    JOptionPane.showMessageDialog(null, e);
            }
      return userList;
}
//dis[lay in jtable
//use default table model
public void show_user(){
    ArrayList<User> list = userList();
    DefaultTableModel model = (DefaultTableModel)jTable1.getModel();//typecast with default table model
    //create a array which stores the rows of the data
  // adjust table size  jTable1.getColumnModel().getColumn(0).setPreferredWidth(30);
jTable1.getColumnModel().getColumn(0).setPreferredWidth(10);
  jTable1.getColumnModel().getColumn(1).setPreferredWidth(40);
    jTable1.getColumnModel().getColumn(3).setPreferredWidth(30);
    jTable1.getColumnModel().getColumn(12).setPreferredWidth(30);
    jTable1.getColumnModel().getColumn(13).setPreferredWidth(30);
     /*   jTable1.getColumnModel().getColumn(3).setPreferredWidth(40);
    jTable1.getColumnModel().getColumn(5).setPreferredWidth(30); */
    Object[] row = new Object[14];
    for(int i=0; i<list.size();i++){
        row[0]=list.get(i).getsno();
        row[1]=list.get(i).getbranch();
        row[2]=list.get(i).getdate();
        row[3]=list.get(i).getdepartment();
        row[4]=list.get(i).getname();
        row[5]=list.get(i).getdob();
        row[6]=list.get(i).getfather();
        row[7]=list.get(i).getmother();
        row[8]=list.get(i).gettaddress();
        //row[9]=list.get(i).getpaddress();
        row[9]=list.get(i).getmno();
        row[10]=list.get(i).getemail();
        row[11]=list.get(i).getcitizenship();
        row[12]=list.get(i).getusername();
        row[13]=list.get(i).getpassword();
        
        //add the row in the model
        model.addRow(row);
        
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

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btnSearch = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        lblimage = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblsign = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        lblsearch = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Sno", "Branch", "Date", "Department", "Name", "D.O.B(A.D)", "Father", "Mother", "Temporary Address", "Mobile Number", "Email ID", "Citizenship No.", "Username", "Password"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setText("Search via name:");

        btnSearch.setText("Search");

        jLabel2.setText("image:");

        lblimage.setText("image");

        jLabel4.setText("Signature:");

        lblsign.setText("Signature");

        jButton1.setText("View All");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblsearch, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSearch))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblimage, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblsign, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 109, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(21, 21, 21))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(btnSearch)
                    .addComponent(lblsearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 455, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblimage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 45, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblsign, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING)))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
       int i = jTable1.getSelectedRow();
       TableModel model= jTable1.getModel();
       byte[] image =(userList().get(i).getimage());
       ImageIcon imageIcon = new ImageIcon(new ImageIcon(image).getImage().getScaledInstance(lblimage.getWidth(),lblimage.getHeight(),Image.SCALE_SMOOTH));
lblimage.setIcon(imageIcon);
       byte[] sign=(userList().get(i).getsign());
              ImageIcon imageIconn = new ImageIcon(new ImageIcon(sign).getImage().getScaledInstance(lblsign.getWidth(),lblsign.getHeight(),Image.SCALE_SMOOTH));
lblsign.setIcon(imageIconn);
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
viewallstaffapplicantview a = new viewallstaffapplicantview();
a.setDefaultCloseOperation(viewallstaffapplicantview.DISPOSE_ON_CLOSE);
a.setVisible(true);
setVisible(false); 
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(staffapplicantview.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(staffapplicantview.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(staffapplicantview.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(staffapplicantview.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new staffapplicantview().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblimage;
    private javax.swing.JTextField lblsearch;
    private javax.swing.JLabel lblsign;
    // End of variables declaration//GEN-END:variables
}