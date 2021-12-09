
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Bishal Shrestha
 */
public class daily_saving_account extends javax.swing.JFrame {

    /**
     * Creates new form daily_saving_account
     */
    public daily_saving_account() {
        initComponents();
        Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation(size.width/2-getWidth()/2, size.height/2-getHeight()/2);
        showDate();
        showTime();
         showindividual_user();
    }
    public ArrayList<IndividualUser> userList(){
    ArrayList<IndividualUser> userList= new ArrayList<>();//create object named arraylist
    //select data from the database
    try{
     Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  // load the driver
           String url = "jdbc:sqlserver://localhost:1433;databaseName=bankoneer_db;user=sa;password=bishal";
           Connection con = DriverManager.getConnection(url);
           String query1 = "Select * from customer_account";
           Statement st = con.createStatement();
      ResultSet rs = st.executeQuery(query1);
      //create object for user
      IndividualUser user;
      while(rs.next()){ 
          //provide data in user object
          user= new IndividualUser(rs.getInt("sno"),rs.getString("account_no"),rs.getString("type"),rs.getString("name"),rs.getString("total_balance"));
      //add user to the user list
      userList.add(user);
                  
                  }
    }
    catch(Exception e){
    JOptionPane.showMessageDialog(null, e);
            }
      return userList;
}
    public void showindividual_user(){
    ArrayList<IndividualUser> list = userList();
    DefaultTableModel model = (DefaultTableModel)jTable1.getModel();//typecast with default table model
    //create a array which stores the rows of the data
  // adjust table size  jTable1.getColumnModel().getColumn(0).setPreferredWidth(30);
/*jTable1.getColumnModel().getColumn(0).setPreferredWidth(10);
  jTable1.getColumnModel().getColumn(1).setPreferredWidth(40);
    jTable1.getColumnModel().getColumn(3).setPreferredWidth(30);
    jTable1.getColumnModel().getColumn(12).setPreferredWidth(30);
    jTable1.getColumnModel().getColumn(13).setPreferredWidth(30);
     /*   jTable1.getColumnModel().getColumn(3).setPreferredWidth(40);
    jTable1.getColumnModel().getColumn(5).setPreferredWidth(30); */
    Object[] row = new Object[5];
    for(int i=0; i<list.size();i++){
        row[0]=list.get(i).getsno();
       // row[1]=list.get(i).getbranch();
        row[1]=list.get(i).getacc();
        row[2]=list.get(i).getaccount_type(); 
        row[3]=list.get(i).getname(); 
        row[4]=list.get(i).gettotal_balance(); 
//        row[9]=list.get(i).getcitizenship();
  //      row[10]=list.get(i).getcurrency();
        
        //add the row in the model
        model.addRow(row);
        
    }
}
    void showDate(){
      Date d= new Date();
      SimpleDateFormat s= new SimpleDateFormat("yyyy-MM-dd");
      dateLab.setText(s.format(d));
    }
           void showTime(){
           new Timer(0, new ActionListener(){
               @Override
               public void actionPerformed(ActionEvent e){
                         Date d= new Date();
      SimpleDateFormat s= new SimpleDateFormat("hh:mm:ss a");
      timeLab.setText(s.format(d));
      try{
          
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  // load the driver
           String url = "jdbc:sqlserver://localhost:1433;databaseName=bankoneer_db;user=sa;password=bishal";
           Connection con = DriverManager.getConnection(url);        
           String sql = "Select name, total_balance from customer_account";
           Statement st = con.createStatement();
           ResultSet rs = st.executeQuery(sql);
           
           
      //int rowCount=rs.getInt(1);
      while(rs.next()){ 

          System.out.println("a");
      //    DefaultTableModel dt= (DefaultTableModel) jTable1.getModel();
        //  Vector v = new Vector();
          int z=0;
 //  for(int y=0;y<jTable1.getRowCount();y++){
            // z=Integer.parseInt(jTable1.getValueAt(y,0).toString());
             System.out.println(z);
                     int b=z;
    String aa=Integer.toString(b);
   jLabel4.setText(aa);
 // get database value into variable
 //  for(int i=0;i<z;i++){

 // for(int i=0;i<jTable1.getRowCount()-1;i++){
   String name=rs.getString("name");
   float total_balance=Float.parseFloat(rs.getString("total_balance"));
System.out.println(name + "   " );
System.out.println(total_balance+"  ");
System.out.println(" yeah" );
try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  // load the driver
           String urla = "jdbc:sqlserver://localhost:1433;databaseName=bankoneer_db;user=sa;password=bishal";
           Connection cono = DriverManager.getConnection(urla);
String sqlkobau= "insert into daily_saving_account(datee,timee,account_number,name,saving_amount,interest_amount,tax_amount,remaining_interest,remaining_saving) values (?,?,?,?,?,?,?,?,?)";
        //+ "VALUE //('"+name+"','"+total_balance+"');";
PreparedStatement pstkobau=cono.prepareStatement(sqlkobau);
pstkobau.setString(1, name);
pstkobau.setString(2, name);
pstkobau.setString(3, name);
pstkobau.setString(4, name);
pstkobau.setString(5, name);
pstkobau.setString(6, name);
pstkobau.setString(7, name);
pstkobau.setString(8, name);
pstkobau.setString(9, name);
//String temp=Float.toString(total_balance);
//pstkobau.setString(3,temp);
//pstkobau.executeUpdate();

}
      catch(Exception eee){
    JOptionPane.showMessageDialog(null, eee);
            }

     
   
     
         
         
         
         
         
       /*       String currentTime = new SimpleDateFormat("HH:mm").format(new Date());
              String timeToCompare="13:44";
              boolean x= currentTime.equals(timeToCompare);
         // hataune  if(x ){ */
              
      //     for (int i=0; i<z;i++){
        /*      String a= "SELECT account_no, total_balance FROM customer_account";
              PreparedStatement psa= con.prepareStatement(a);
              ResultSet rsa=psa.executeQuery();
              int b;
              b=Integer.valueOf(rsa.getString("account_no"));*/
         //     Statement stop=  con.createStatement();
              
           // PreparedStatement ab= con.prepareStatement(a);
             // ResultSet saa= psa.executeQuery(a);
           /*   while(rsa.next()){
                  
                  
           //     psa.setString(1,b); 
                String de= "INSERT INTO daily_saving_account(account_number) values (?)";
                PreparedStatement ps= con.prepareStatement(de);               
                ps.setInt(4, b);
                ps.executeQuery(); */
               // stop.setString(1, b);
                //String c= saa.getString("name");
             //   String de= "INSERT INTO daily_saving_account(account_number,name) SELECT account_no,name FROM customer_account";
               // 
               // 
               // ps.setString(5,c);
                //;
            //  }
              
        //   }
              //}
                   
                 //  this one
              
         // }
                   
                   
                   
                   
        //  int b=z;
        //  String aa=Integer.toString(b);
         // jLabel4.setText(aa);
      //    String currentTime = new SimpleDateFormat("HH:mm").format(new Date());
  //    String timeToCompare="14:33";
  //    boolean x= currentTime.equals(timeToCompare);
//     if(x ){
                 //  System.out.println("yahoo bitch");
                 //  JOptionPane.showMessageDialog(null,"System is refreshing");
                //   String sqla = "Select * from customer_account";
                //   Statement sta = con.createStatement();
                 //  ResultSet rsa = sta.executeQuery(sqla);
                 //  int abc = rsa.getInt(0);
                 //  int abc = rsa.getInt(0);
                //   while(rsa.next()){
                     //  DefaultTableModel dm= new DefaultTableModel();
                     // int rowCount=dm.getRowCount();
                   //  String a= rs.getString("sum(sno)");
                   //  int b=Integer.parseInt(a);
                   //  jLabel4.setText(a);
                    // for (int i=b-1;i>=0;i--){
                      //   jLabel4.setText(a);
                    // }
                //    for(int i = rowCount-1;i>=0;i--){
                     //  for(int i = abc-1;i>=0;i--){
                     //  int abca = rsa.getInt(1);
                     
                 //      System.out.println("abca");
                   //    }
       //            }
                   
                   
            //   }

   //   if (s.equals("09:52:00")){
     //     JOptionPane.showMessageDialog(null,"Yahoo");
     // } 
      
          
      }
//  String sql = "Select * from customer_account where username=? and password=? and department=?";
           //PreparedStatement pst = con.prepareStatement(sql);
           
           // ResultSet rs = pst.executeQuery();
       //    String a = rs.getString("account_no");
          //     jLabel3.setText(a);
           //   System.out.println(a);
         //  DefaultTableModel model= (DefaultTableModel)this.getModel();
          // DefaultTableModel model = (DefaultTableModel)this.getModel(); 
          //DefaultTableModel dm= new DefaultTableModel();
        //   int rowCount=dm.getRowCount();
         //  for(int i = rowCount-1;i>=0;i--){
               
         
             //  JOptionPane.showMessageDialog(null, "sno");
               
               
         //  }
           
      }
      catch(Exception ee){
    JOptionPane.showMessageDialog(null, ee);
            }

      
    /*   //
float total_balance=1000;
float saving=total_balance;
float a=                   (float) 1/365;
float interest=            (float) (saving * (10*0.01) *a) ;
float tax=               (float) (interest*(5*0.01));
float remaining_interest= interest-tax;
float remaining_saving = saving + remaining_interest;
total_balance=remaining_saving;

System.out.println("The total balance "+total_balance);
System.out.println("The Currnet Saving "+saving);
System.out.println("The interest rate 10%per annum to per day: "+interest);
System.out.println("The tax(5%) "+tax);
System.out.println("The remaining interest balance "+remaining_interest);
System.out.println("The remaining saving balance: "+remaining_saving);
System.out.println("The final total value balance: "+total_balance);

*/

               }
           }).start();
       }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        dateLab = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        timeLab = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Date:");

        dateLab.setText("Date");

        jLabel2.setText("Time:");

        timeLab.setText("Time");

        jLabel3.setText("jLabel3");

        jLabel4.setText("jLabel4");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Sno", "Account Number", "Account Type", "Name", "Balance"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addGap(65, 65, 65))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 537, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dateLab)
                        .addGap(38, 38, 38)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(timeLab)
                        .addGap(21, 21, 21))))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 716, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dateLab)
                    .addComponent(timeLab)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 183, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(69, 69, 69))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
public class tablenumber{

}
    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
       
    }//GEN-LAST:event_jTable1MouseClicked

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
            java.util.logging.Logger.getLogger(daily_saving_account.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(daily_saving_account.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(daily_saving_account.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(daily_saving_account.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new daily_saving_account().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel dateLab;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel timeLab;
    // End of variables declaration//GEN-END:variables
}
