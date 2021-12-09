
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Bishal
 */
public class cashierindividualform extends javax.swing.JFrame {
    DefaultTableModel dm;
String filename=null , filename1=null;//location
byte[] image, sign=null; //image
    /**
     * Creates new form cashierindividualform
     */
    public cashierindividualform() {
        initComponents();
        Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation(size.width/2-getWidth()/2, size.height/2-getHeight()/2);
        showDate();
        showTime();
        showindividual_user();
      this.image=null;
   this.sign=null;
   lblacc.setEditable(false);
   lblcurrencyy.setEditable(false);
   lblnamee.setEditable(false);
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
    /*  String currentTime = new SimpleDateFormat("HH:mm").format(new Date());
      String timeToCompare="13:34";
      boolean x= currentTime.equals(timeToCompare);
     if(x ){
         System.out.println("yahoo bitch");
                   JOptionPane.showMessageDialog(null,"Yahoo");
               }

      if (s.equals("09:52:00")){
          JOptionPane.showMessageDialog(null,"Yahoo");
      }  //
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
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        dateLab = new javax.swing.JLabel();
        timeLab = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        lblsearch = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblcash = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        lblacc = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        lblnamee = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        lblcurrencyy = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        btnprintreceipt = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        receipt = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        dateLab.setText("Date");

        timeLab.setText("Time");

        jLabel1.setText("Date:");

        jLabel2.setText("Time:");

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

        lblsearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblsearchMouseClicked(evt);
            }
        });
        lblsearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lblsearchActionPerformed(evt);
            }
        });
        lblsearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                lblsearchKeyReleased(evt);
            }
        });

        jLabel3.setText("Search via Acc. No.:");

        jLabel6.setText("Cash Denominations:");

        jButton1.setText("Deposit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel7.setText("Account Number:");

        lblacc.setEditable(false);

        jLabel8.setText("Name:");

        lblnamee.setEditable(false);
        lblnamee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lblnameeActionPerformed(evt);
            }
        });

        jLabel9.setText("Currency:");

        lblcurrencyy.setEditable(false);

        jLabel10.setText("+");

        btnprintreceipt.setText("Print Receipt");
        btnprintreceipt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnprintreceiptActionPerformed(evt);
            }
        });

        jButton2.setForeground(new java.awt.Color(255, 51, 0));
        jButton2.setText("Withdrawl");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("View All Details");

        receipt.setColumns(20);
        receipt.setRows(5);
        jScrollPane2.setViewportView(receipt);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jButton3)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 706, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dateLab)
                                .addGap(38, 38, 38)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(timeLab)
                                .addGap(77, 77, 77))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblsearch, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(39, 39, 39))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(169, 169, 169)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel9)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(lblcurrencyy, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(lblacc)
                                                .addComponent(lblnamee, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(52, 52, 52)
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                    .addComponent(jButton1)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(jButton2))
                                                .addComponent(lblcash, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnprintreceipt)))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1361, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dateLab)
                    .addComponent(timeLab)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(47, 47, 47)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblsearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton3)
                        .addGap(73, 73, 73)
                        .addComponent(jScrollPane2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(lblacc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(lblnamee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblcurrencyy, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblcash, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1)
                            .addComponent(jButton2))
                        .addGap(0, 35, Short.MAX_VALUE))
                    .addComponent(btnprintreceipt)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
 float bb= Float.parseFloat(lblcash.getText());
        if(bb>0){
        int opt= JOptionPane.showConfirmDialog(null, "Sure to Deposit to Account", "Deposit?", JOptionPane.YES_NO_OPTION);
        if(opt==0){ //value of yes = 0
            try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  // load the driver
           String url = "jdbc:sqlserver://localhost:1433;databaseName=bankoneer_db;user=sa;password=bishal";
           Connection con = DriverManager.getConnection(url);
           int row= jTable1.getSelectedRow();
           String value=(jTable1.getModel().getValueAt(row, 0).toString());
                     //  int a= Integer.valueOf(lblcurrencyy.getText());
                       float a= Float.parseFloat(lblcurrencyy.getText());
                       
           // int b= Integer.valueOf(lblcash.getText());
           float b= Float.parseFloat(lblcash.getText());
            float cc= a+b;
            String ccc=  Float.toString(cc);
           String query1 = "UPDATE customer_account SET total_balance=? where sno="+value;
                       PreparedStatement pst= con.prepareStatement(query1);
                        pst.setString(1, ccc);
                        pst.executeUpdate();
                        JOptionPane.showMessageDialog(null, "Deposited Successfully!");
                      
      DefaultTableModel model=(DefaultTableModel)jTable1.getModel();
      model.setRowCount(0);
      showindividual_user();

//insert to transaction history database
      Date obj= new Date();
String dateee=obj.toString();
      String query="insert into transaction_history(date_time,account_no,status,amount,total_balance,type) values (?,?,?,?,?,?)";
            PreparedStatement psta= con.prepareStatement(query);
            psta.setString(1,dateee);
            psta.setString(2,lblacc.getText());
            String status="DEPOSITED TO ACCOUNT";
            psta.setString(3, status);
             psta.setString(4, lblcash.getText());
             float aa= Float.parseFloat(lblcurrencyy.getText())+Float.parseFloat(lblcash.getText());
             String aaa=Float.toString(aa);
              psta.setString(5, aaa);
              String type="Banking";
              psta.setString(6,type);
              psta.executeUpdate();
                    deposit_receipt(); 
 
            

            
            
            
            }
             catch(Exception e){
    JOptionPane.showMessageDialog(null, e);
            }
        }
        }//if
        else{
            JOptionPane.showMessageDialog(null,"Invalid Amount Denominations");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void lblnameeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lblnameeActionPerformed
      
    }//GEN-LAST:event_lblnameeActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
               float bb= Float.parseFloat(lblcash.getText());
               if(bb>0){
        int opt= JOptionPane.showConfirmDialog(null, "Sure to Withdraw from Account", "Withdraw?", JOptionPane.YES_NO_OPTION);
        if(opt==0){ //value of yes = 0
            try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  // load the driver
           String url = "jdbc:sqlserver://localhost:1433;databaseName=bankoneer_db;user=sa;password=bishal";
           Connection con = DriverManager.getConnection(url);
           int row= jTable1.getSelectedRow();
           String value=(jTable1.getModel().getValueAt(row, 0).toString());
                       float a= Float.parseFloat(lblcurrencyy.getText());                      
           float b= Float.parseFloat(lblcash.getText());
           if(a>=b){
            float cc= a-b;
            String ccc=  Float.toString(cc);
           String query1 = "UPDATE customer_account SET total_balance=? where sno="+value;
                       PreparedStatement pst= con.prepareStatement(query1);
                        pst.setString(1, ccc);
                        pst.executeUpdate();
                        JOptionPane.showMessageDialog(null, "Amount Withdrawed Successfully!");
                      
      DefaultTableModel model=(DefaultTableModel)jTable1.getModel();
      model.setRowCount(0);
      showindividual_user();

//insert to transaction history database
      Date obj= new Date();
String dateee=obj.toString();
      String query="insert into transaction_history(date_time,account_no,status,amount,total_balance,type) values (?,?,?,?,?,?)";
            PreparedStatement psta= con.prepareStatement(query);
            psta.setString(1,dateee);
            psta.setString(2,lblacc.getText());
            String status="WITHDRAWED FROM ACCOUNT";
            psta.setString(3, status);
             psta.setString(4, lblcash.getText());
             float aa= Float.parseFloat(lblcurrencyy.getText())-Float.parseFloat(lblcash.getText());
             String aaa=Float.toString(aa);
              psta.setString(5, aaa);
              String type="Banking";
              psta.setString(6,type);
              psta.executeUpdate();
                    withdraw_receipt(); 
 
            

            
            
           }
           else{
               JOptionPane.showMessageDialog(null,"Insufficient Amount in the account!");
           }
            }
             catch(Exception e){
    JOptionPane.showMessageDialog(null, e);
            }
        }


        
        /*int opt= JOptionPane.showConfirmDialog(null, "Sure to Withdraw from Account", "Withdraw?", JOptionPane.YES_NO_OPTION);
        if(opt==0){ //value of yes = 0
            try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  // load the driver
           String url = "jdbc:sqlserver://localhost:1433;databaseName=bankoneer_db;user=sa;password=bishal";
           Connection con = DriverManager.getConnection(url);
           int row1= jTable1.getSelectedRow();
           String value1=(jTable1.getModel().getValueAt(row1, 0).toString());
           String queryab="Select total_balance from customer_account where sno="+value1;
                      Statement sto = con.createStatement();
           ResultSet rso = sto.executeQuery(queryab);
            String compare= rso.getString("total_balance");
            float comparefloat=Float.parseFloat(compare);
            while(rso.next()){              
           int row= jTable1.getSelectedRow();
           String value=(jTable1.getModel().getValueAt(row, 0).toString());
                       float a= Float.parseFloat(lblcurrencyy.getText());
               //        if (a<=0){ 
               if(comparefloat<a){
                           JOptionPane.showMessageDialog(null,"Insufficient Amount");
                       }
                       else{         
                                
                       float aa= Float.parseFloat(lblcurrencyy.getText());
                       
           // int b= Integer.valueOf(lblcash.getText());
           float bb= Float.parseFloat(lblcash.getText());
            float ccc= aa-bb;
            String cccc=  Float.toString(ccc);
           String query1 = "UPDATE customer_account SET total_balance=? where sno="+value;
                       PreparedStatement pst= con.prepareStatement(query1);
                        pst.setString(1, cccc);
                        pst.executeUpdate();
                        JOptionPane.showMessageDialog(null, "Withdrawed Successfully!");
                        
                       }
      DefaultTableModel model=(DefaultTableModel)jTable1.getModel();
      model.setRowCount(0);
      showindividual_user();
            }
            }
             catch(Exception e){
    JOptionPane.showMessageDialog(null, e);
            }
            
        }*/
        }//if
        else{
            JOptionPane.showMessageDialog(null,"Invalid Amount Denominations");
        }
    }//GEN-LAST:event_jButton2ActionPerformed
 private void filter(String query){
     dm=(DefaultTableModel) jTable1.getModel();
     TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(dm);
     jTable1.setRowSorter(tr);
     tr.setRowFilter(RowFilter.regexFilter(query));
 }
    
    private void lblsearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lblsearchKeyReleased
/*if(lblsearch.getText().equals("")){
    lblacc.setText("");
    lblnamee.setText("");
    lblcurrencyy.setText("");
}
else{ */
        String query=lblsearch.getText().toLowerCase();
        filter(query);
    
     /*    int i = jTable1.getSelectedRow();
       TableModel model= jTable1.getModel();    
       lblacc.setText(model.getValueAt(i,1).toString());
         lblnamee.setText(model.getValueAt(i,3).toString());
         lblcurrencyy.setText(model.getValueAt(i,4).toString());  */


    }//GEN-LAST:event_lblsearchKeyReleased
void deposit_receipt(){
                //print receipt
            receipt.setText("***************************************************************************************************************************************\n");       
receipt.setText(receipt.getText()+"*************************************BANKONEER********************************************************************\n");
            receipt.setText(receipt.getText()+"*                                              *Deposit Receipt*                                                           *\n");
receipt.setText(receipt.getText()+"***************************************************************************************************************************************\n");

Date obj= new Date();
String date=obj.toString();
receipt.setText(receipt.getText()+"\n"+date+"\n");
receipt.setText(receipt.getText()+"\n");
receipt.setText(receipt.getText()+"Account Type: Daily Savings \n");
receipt.setText(receipt.getText()+"Account Number: "+lblacc.getText()+"\n");
receipt.setText(receipt.getText()+"Account Holder's Name: "+lblnamee.getText()+"\n");
receipt.setText(receipt.getText()+"Account Balance (In Figures) "
        + "NRS: "+lblcurrencyy.getText()+"\n");
receipt.setText(receipt.getText()+"************                                    +"+"\n");
receipt.setText(receipt.getText()+"Amount Deposited (In Figures) NRS: "+lblcash.getText()+"\n");
float a= Float.parseFloat(lblcurrencyy.getText())+Float.parseFloat(lblcash.getText());
receipt.setText(receipt.getText()+"Total Accont Balance (In Figures) NRS: "+a+"\n");
receipt.setText(receipt.getText()+"***************************************************************************************************************************************\n");
receipt.setText(receipt.getText()+"***************************************************************************************************************************************\n");
try{
    receipt.print();
}
catch(Exception e){
    
}
}
void withdraw_receipt(){
                    //print receipt
            receipt.setText("***************************************************************************************************************************************\n");       
receipt.setText(receipt.getText()+"*************************************BANKONEER********************************************************************\n");
            receipt.setText(receipt.getText()+"*                                              *Withdrawal Receipt*                                                           *\n");
receipt.setText(receipt.getText()+"***************************************************************************************************************************************\n");

Date obj= new Date();
String date=obj.toString();
receipt.setText(receipt.getText()+"\n"+date+"\n");
receipt.setText(receipt.getText()+"\n");
receipt.setText(receipt.getText()+"Account Type: Daily Savings \n");
receipt.setText(receipt.getText()+"Account Number: "+lblacc.getText()+"\n");
receipt.setText(receipt.getText()+"Account Holder's Name: "+lblnamee.getText()+"\n");
receipt.setText(receipt.getText()+"Account Balance (In Figures) "
        + "NRS: "+lblcurrencyy.getText()+"\n");
receipt.setText(receipt.getText()+"************                                    -"+"\n");
receipt.setText(receipt.getText()+"Amount Deposited (In Figures) NRS: "+lblcash.getText()+"\n");
float a= Float.parseFloat(lblcurrencyy.getText())-Float.parseFloat(lblcash.getText());
receipt.setText(receipt.getText()+"Total Accont Balance (In Figures) NRS: "+a+"\n");
receipt.setText(receipt.getText()+"***************************************************************************************************************************************\n");
receipt.setText(receipt.getText()+"***************************************************************************************************************************************\n");
receipt.setText(receipt.getText()+"*************************************BANKONEER********************************************************************\n");

try{
    receipt.print();
}
catch(Exception e){
    
}
}
    private void lblsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lblsearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lblsearchActionPerformed

    private void lblsearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblsearchMouseClicked
       
    }//GEN-LAST:event_lblsearchMouseClicked

    private void btnprintreceiptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnprintreceiptActionPerformed
receipt.setText("***************************************************************************************************************************************\n");       
receipt.setText(receipt.getText()+"*                                              *Deposit Receipt*                                                           *\n");
receipt.setText(receipt.getText()+"***************************************************************************************************************************************\n");

Date obj= new Date();
String date=obj.toString();
receipt.setText(receipt.getText()+"\n"+date+"\n");
receipt.setText(receipt.getText()+"\n");
receipt.setText(receipt.getText()+"Account Type: Daily Savings \n");
receipt.setText(receipt.getText()+"Account Number: "+lblacc.getText()+"\n");
receipt.setText(receipt.getText()+"Account Holder's Name: "+lblnamee.getText()+"\n");
receipt.setText(receipt.getText()+"Account Balance(In Figures) "
        + "NRS: "+lblcurrencyy.getText()+"\n");
receipt.setText(receipt.getText()+"************                                    -"+"\n");
receipt.setText(receipt.getText()+"Amount Deposited(In Figures) NRS:: "+lblcash.getText()+"\n");
try{
    receipt.print();
}
catch(Exception e){
    
}

    }//GEN-LAST:event_btnprintreceiptActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int i = jTable1.getSelectedRow();
        TableModel model= jTable1.getModel();
        //  byte[] image =(userList().get(i).getimage());
        //  ImageIcon imageIcon = new ImageIcon(new ImageIcon(image).getImage().getScaledInstance(lblimage.getWidth(),lblimage.getHeight(),Image.SCALE_SMOOTH));
        //lblimage.setIcon(imageIcon);
        //     byte[] sign=(userList().get(i).getsign());
        //          ImageIcon imageIconn = new ImageIcon(new ImageIcon(sign).getImage().getScaledInstance(lblsign.getWidth(),lblsign.getHeight(),Image.SCALE_SMOOTH));
        //lblsign.setIcon(imageIconn);

        lblacc.setText(model.getValueAt(i,1).toString());
        lblnamee.setText(model.getValueAt(i,3).toString());
        lblcurrencyy.setText(model.getValueAt(i,4).toString());
        //lblsearch.setText(model.getValueAt(i,1).toString());
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
            java.util.logging.Logger.getLogger(cashierindividualform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(cashierindividualform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(cashierindividualform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(cashierindividualform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new cashierindividualform().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnprintreceipt;
    private javax.swing.JLabel dateLab;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField lblacc;
    private javax.swing.JTextField lblcash;
    private javax.swing.JTextField lblcurrencyy;
    private javax.swing.JTextField lblnamee;
    private javax.swing.JTextField lblsearch;
    private javax.swing.JTextArea receipt;
    private javax.swing.JLabel timeLab;
    // End of variables declaration//GEN-END:variables
}
