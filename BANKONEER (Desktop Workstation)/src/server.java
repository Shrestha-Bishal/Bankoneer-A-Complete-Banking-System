
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import static jdk.internal.org.objectweb.asm.commons.GeneratorAdapter.AND;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Bishal Shrestha
 */

public class server extends javax.swing.JFrame {

    /**
     * Creates new form server
     */
    public server() {

        initComponents(); 
        
                  new Timer(0, new ActionListener(){
              @Override
                       public void actionPerformed(ActionEvent e){
                                Date d= new Date();
      SimpleDateFormat s= new SimpleDateFormat("hh:mm:ss a");
      timeLab.setText(s.format(d));
                       
      }}).start(); 
        String currentTime = new SimpleDateFormat("HH:mm").format(new Date()); 
       // System.out.println(currentTime);
              String timeToCompare="17:51";
             // String flag = "set";
              boolean x= currentTime.equals(timeToCompare);
       //  if(x){          
        try{
          
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  // load the driver
           String url = "jdbc:sqlserver://localhost:1433;databaseName=bankoneer_db;user=sa;password=bishal";
           Connection con = DriverManager.getConnection(url);  
         /*             PreparedStatement psaaa=con.prepareStatement("Select * from customer_account");
              ResultSet abcd=psaaa.getGeneratedKeys();
              if(abcd.next()){
                  int id=0;
                  id= abcd.getInt(1);
                  System.out.println(id);
                  
              }*/
           String sql = "Select sno, account_no, name, total_balance from customer_account";
           Statement st = con.createStatement();
           ResultSet rs = st.executeQuery(sql);
           //PreparedStatement pskeys=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
           
//rs=st.executeQuery("select MAX(sno) AS sno from customer_account");
//rs=st.executeQuery("select lastInsertID() from customer_account");          
      //int rowCount=rs.getInt(1);
      while(rs.next()){ 
          int sno=rs.getInt("sno");
     Statement saa = con.createStatement();
ResultSet r = saa.executeQuery("SELECT COUNT(*) AS sno FROM customer_account");
r.next();
int count = r.getInt("sno") ;
r.close() ;
System.out.println("MyTable has " + count + " row(s).");    
         
//for(int itt=1;itt<=count-1;itt++){
          System.out.println("a");

      //    DefaultTableModel dt= (DefaultTableModel) jTable1.getModel();
        //  Vector v = new Vector();
          int z=0;
 //  for(int y=0;y<jTable1.getRowCount();y++){
            // z=Integer.parseInt(jTable1.getValueAt(y,0).toString());
             System.out.println(z);
                     int b=z;
    String aa=Integer.toString(b);
   //jLabel4.setText(aa);
 // get database value into variable
 //  for(int i=0;i<z;i++){

 // for(int i=0;i<jTable1.getRowCount()-1;i++){
 Date obj=new Date();
 String date=obj.toString();
 
 String acc=rs.getString("account_no");
 //Float acctemp=Float.parseFloat(acc);
   String name=rs.getString("name");
  // float total_balance=Float.parseFloat(rs.getString("total_balance"));
 String saving=rs.getString("total_balance");
  Float savingtemp=Float.parseFloat(saving); //total balance in float
  float days = (float) 1/365;
  float interest = (float) (savingtemp*(10*0.01)*days);  //interest in float
  String inte = Float.toString(interest);
  float tax=(float) (interest*(5*0.01)); //tax in float
  String taxe =Float.toString(tax);
  float remaining_interest=interest-tax;  //remaining interest in float
  String remaining_inte=Float.toString(remaining_interest);
  float remaining_saving=savingtemp+remaining_interest; 
  String total_balance_update=Float.toString(remaining_saving);
  //int total_balance_update= Math.round(remaining_saving);
  System.out.println("ABCD is" +total_balance_update);
  //String total=Integer.toString(total_balance_update);
System.out.println(name + "   " );
//System.out.println(total_balance+"  ");
System.out.println("yeah" );
try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  // load the driver
           String urla = "jdbc:sqlserver://localhost:1433;databaseName=bankoneer_db;user=sa;password=bishal";
           Connection cono = DriverManager.getConnection(urla);
String sqlkobau= "insert into daily_saving_account(datee,timee,account_number,name,saving_amount,interest_amount,tax_amount,remaining_interest,remaining_saving) values (?,?,?,?,?,?,?,?,?)";
        //+ "VALUE //('"+name+"','"+total_balance+"');";
PreparedStatement pstkobau=cono.prepareStatement(sqlkobau);
pstkobau.setString(1, date);
pstkobau.setString(2, date);
pstkobau.setString(3, acc);
pstkobau.setString(4, name);
pstkobau.setString(5, saving);
pstkobau.setString(6, inte);
pstkobau.setString(7, taxe);
pstkobau.setString(8, remaining_inte);
pstkobau.setString(9, total_balance_update);
//String temp=Float.toString(total_balance);
//pstkobau.setString(3,temp);
           pstkobau.executeUpdate();
           
try{
String sqlkoama="UPDATE customer_account SET total_balance=? WHERE account_no="+acc;
PreparedStatement pstkoama=cono.prepareStatement(sqlkoama);
pstkoama.setString(1, total_balance_update);
       pstkoama.executeUpdate();
    // sleep(60000);  
       
}
catch(Exception eeee){
    JOptionPane.showMessageDialog(null,eeee);
}

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
      
          
     // }//for loop abcd
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
      }  //for
           
      }
      catch(Exception ee){
    JOptionPane.showMessageDialog(null, ee);
            }
    //    }
                     //    }
                      // }
                //}).start();
    }
public static void sleep(int time){
try{
Thread.sleep(time);
}
catch (Exception e){

}
}
public static void time(){

}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        timeLab = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setText("Time:");

        timeLab.setText("Time");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(320, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(timeLab)
                .addGap(26, 26, 26))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(timeLab)
                    .addComponent(jLabel2))
                .addContainerGap(275, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(server.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(server.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(server.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(server.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new server().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel timeLab;
    // End of variables declaration//GEN-END:variables
}
