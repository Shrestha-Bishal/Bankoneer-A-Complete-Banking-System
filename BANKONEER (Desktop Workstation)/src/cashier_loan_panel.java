
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
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
import java.util.Calendar;
import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.ZoneId;
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
 * @author Bishal Shrestha
 */
public class cashier_loan_panel extends javax.swing.JFrame {
    DefaultTableModel dm;
    /**
     * Creates new form cashier_loan_panel
     */
    public cashier_loan_panel() {
        initComponents();
        Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation(size.width/2-getWidth()/2, size.height/2-getHeight()/2);
        showDate();
        showTime();
        showindividual_user();
    }
     public ArrayList<loan_account> userList(){
    ArrayList<loan_account> userList= new ArrayList<>();//create object named arraylist
    //select data from the database
    try{
     Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  // load the driver
           String url = "jdbc:sqlserver://localhost:1433;databaseName=bankoneer_db;user=sa;password=bishal";
           Connection con = DriverManager.getConnection(url);
           String query1 = "Select * from loan_account";
           Statement st = con.createStatement();
      ResultSet rs = st.executeQuery(query1);
      //create object for user
      loan_account user;
      while(rs.next()){ 
user= new loan_account(rs.getInt("sno"),rs.getString("name"),rs.getString("accountnumber"),rs.getString("date"),rs.getString("username"),rs.getString("loan_amount"),rs.getString("interest_rate"),rs.getString("time_period"),rs.getString("monthly_amount"),rs.getString("remaining_loan"),rs.getString("interest_amount"),rs.getString("installment"),rs.getFloat("fine"),rs.getString("installment_date"));
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
               }
               }).start();
            }
       public void showindividual_user(){
    ArrayList<loan_account> list = userList();
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
    Object[] row = new Object[14];
    for(int i=0; i<list.size();i++){
        row[0]=list.get(i).getsno();
        row[1]=list.get(i).getname();
        row[2]=list.get(i).getaccountnumber(); 
        row[3]=list.get(i).getdate(); 
        row[4]=list.get(i).getusername(); 
                //row[4]=list.get(i).getsno();
        row[5]=list.get(i).getloan_amount();
        row[6]=list.get(i).getinterest_rate(); 
        
        row[7]=list.get(i).gettime_period(); 
        row[8]=list.get(i).getmonthly_amount();
        
                row[9]=list.get(i).getremaining_loan();
        row[10]=list.get(i).getinterest_amount();
        row[11]=list.get(i).getinstallment(); 
        row[12]=list.get(i).getfine(); 
        row[13]=list.get(i).getinstallment_date();
        //row[14]=list.get(i).getnext_installment_date();
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

        jLabel4 = new javax.swing.JLabel();
        lblsearch1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        lblsearch = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        dateLab = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        timeLab = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        receipt = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        lblacc = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        lblnamee = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        lbl_loan = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        lbl_monthly = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        lbl_remaining = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        lbl_interest_amount = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        lbl_time_period = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        lbl_insno = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        lbl_fine = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        btn_deposit = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        lbl_ins_date = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        lbl_next_ins_date = new javax.swing.JTextField();
        lblcash = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        lbl_interest_rate = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        label_due_amount = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel4.setText("Search.:");

        lblsearch1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblsearch1MouseClicked(evt);
            }
        });
        lblsearch1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lblsearch1ActionPerformed(evt);
            }
        });
        lblsearch1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                lblsearch1KeyReleased(evt);
            }
        });

        jLabel3.setText("Search via Acc. No.:");

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

        jLabel1.setText("Cashier Loan Department");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Sno", "Name", "Account Number", "date", "username", "Loan Amount", "Interest Rate", "Time Period", "Monthly Amount", "Remaining Loan", "Interest Amount", "Installment", "Fine", "Installment date"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel2.setText("Date:");

        dateLab.setText("Date");

        jLabel5.setText("Time:");

        timeLab.setText("Time");

        receipt.setColumns(20);
        receipt.setRows(5);
        jScrollPane2.setViewportView(receipt);

        jLabel7.setText("Account Number:");

        lblacc.setEditable(false);

        jLabel8.setText("Name:");

        lblnamee.setEditable(false);
        lblnamee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lblnameeActionPerformed(evt);
            }
        });

        jLabel9.setText("Loan Amount: ");

        lbl_loan.setEditable(false);
        lbl_loan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lbl_loanActionPerformed(evt);
            }
        });

        jLabel10.setText("Monthly Amount:");

        lbl_monthly.setEditable(false);
        lbl_monthly.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lbl_monthlyActionPerformed(evt);
            }
        });

        jLabel11.setText("Remaining Loan: ");

        lbl_remaining.setEditable(false);
        lbl_remaining.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lbl_remainingActionPerformed(evt);
            }
        });

        jLabel12.setText("Interest Amount:");

        lbl_interest_amount.setEditable(false);
        lbl_interest_amount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lbl_interest_amountActionPerformed(evt);
            }
        });

        jLabel13.setText("Installment Time Period:");

        lbl_time_period.setEditable(false);
        lbl_time_period.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lbl_time_periodActionPerformed(evt);
            }
        });

        jLabel14.setText("Installment  Period Number:");

        lbl_insno.setEditable(false);
        lbl_insno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lbl_insnoActionPerformed(evt);
            }
        });

        jLabel15.setText("Fine:");

        lbl_fine.setEditable(false);
        lbl_fine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lbl_fineActionPerformed(evt);
            }
        });

        jLabel6.setText("Cash Denominations:");

        btn_deposit.setText("Deposit");
        btn_deposit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_depositMouseClicked(evt);
            }
        });
        btn_deposit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_depositActionPerformed(evt);
            }
        });

        jLabel16.setText("Installment Date:");

        lbl_ins_date.setEditable(false);

        jLabel17.setText("Next Installment Date");

        lbl_next_ins_date.setEditable(false);

        jLabel18.setText("Interest Rate:");

        lbl_interest_rate.setEditable(false);
        lbl_interest_rate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lbl_interest_rateActionPerformed(evt);
            }
        });

        jLabel19.setText("%");

        jLabel20.setText("Total Due Amount:");

        label_due_amount.setEditable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dateLab)
                .addGap(38, 38, 38)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(timeLab)
                .addContainerGap())
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addGap(309, 309, 309)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblsearch1, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblsearch, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 547, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel20))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(52, 52, 52)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblcash, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(label_due_amount, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbl_remaining, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(251, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_deposit)
                        .addGap(48, 48, 48))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbl_loan, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(lblacc)
                                        .addComponent(lblnamee, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(31, 31, 31)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lbl_ins_date, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel16))
                                    .addGap(34, 34, 34)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel17)
                                        .addComponent(lbl_next_ins_date, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 6, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(41, 41, 41)
                                    .addComponent(jLabel10)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(lbl_monthly, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jLabel13)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(lbl_time_period, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jLabel14)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(lbl_insno, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(lbl_fine)
                                            .addComponent(lbl_interest_amount, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(59, 59, 59)
                                        .addComponent(jLabel18)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lbl_interest_rate, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel19)))))
                        .addGap(0, 43, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(timeLab)
                            .addComponent(jLabel5)
                            .addComponent(dateLab)
                            .addComponent(jLabel2))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblsearch1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(lblsearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel13)
                                    .addComponent(lbl_time_period))
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel14)
                                    .addComponent(lbl_insno)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7)
                                    .addComponent(lblacc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8)
                                    .addComponent(lblnamee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(lbl_loan, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)
                            .addComponent(lbl_monthly, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel12)
                                    .addComponent(lbl_interest_amount, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel15)
                                    .addComponent(lbl_fine, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lbl_remaining, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel11)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lbl_interest_rate, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel19))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel20)
                                .addComponent(label_due_amount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(lblcash, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btn_deposit)
                                .addGap(42, 42, 42))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel17)
                                    .addComponent(jLabel16))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lbl_ins_date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbl_next_ins_date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(26, 26, 26))))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblsearch1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblsearch1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lblsearch1MouseClicked

    private void lblsearch1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lblsearch1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lblsearch1ActionPerformed
private void filter(String query){
     dm=(DefaultTableModel) jTable1.getModel();
     TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(dm);
     jTable1.setRowSorter(tr);
     tr.setRowFilter(RowFilter.regexFilter(query));
 }
    private void lblsearch1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lblsearch1KeyReleased
        String query=lblsearch1.getText();
        filter(query);
    }//GEN-LAST:event_lblsearch1KeyReleased

    private void lblsearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblsearchMouseClicked

    }//GEN-LAST:event_lblsearchMouseClicked

    private void lblsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lblsearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lblsearchActionPerformed

    private void lblsearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lblsearchKeyReleased

        String query=lblsearch.getText().toLowerCase();
        filter(query);
    }//GEN-LAST:event_lblsearchKeyReleased

    private void lblnameeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lblnameeActionPerformed

    }//GEN-LAST:event_lblnameeActionPerformed

    private void lbl_loanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lbl_loanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lbl_loanActionPerformed

    private void lbl_monthlyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lbl_monthlyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lbl_monthlyActionPerformed

    private void lbl_remainingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lbl_remainingActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lbl_remainingActionPerformed

    private void lbl_interest_amountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lbl_interest_amountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lbl_interest_amountActionPerformed

    private void lbl_time_periodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lbl_time_periodActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lbl_time_periodActionPerformed

    private void lbl_insnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lbl_insnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lbl_insnoActionPerformed

    private void lbl_fineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lbl_fineActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lbl_fineActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int i = jTable1.getSelectedRow();
        TableModel model= jTable1.getModel();
        
        lblacc.setText(model.getValueAt(i,2).toString());
                lblnamee.setText(model.getValueAt(i,1).toString());
                lbl_loan.setText(model.getValueAt(i,5).toString());
                lbl_interest_rate.setText(model.getValueAt(i,6).toString());
                        lbl_remaining.setText(model.getValueAt(i,9).toString());
                        lbl_time_period.setText(model.getValueAt(i,7).toString());
                        String abc=model.getValueAt(i,11).toString();
                        Integer nos=Integer.parseInt(abc)+1;
                        String noss=Integer.toString(nos);
                                lbl_insno.setText(noss);
                                lbl_monthly.setText(model.getValueAt(i,8).toString());
                                        lbl_interest_amount.setText(model.getValueAt(i,10).toString());
                                        lbl_fine.setText(model.getValueAt(i,12).toString());
                                        lbl_ins_date.setText(model.getValueAt(i,13).toString());
                                       float add= Float.parseFloat(model.getValueAt(i,9).toString())+Float.parseFloat(model.getValueAt(i,10).toString())+Float.parseFloat(model.getValueAt(i,12).toString());
                                        //lbl_next_ins_date.setText(model.getValueAt(i,14).toString());
                                        String addString= Float.toString(add);
                                        label_due_amount.setText(addString);
                                        
                                        
         //**//                               
                                //float totala=Float.parseFloat(lblcash.getText());
        //  String totaltostring=Float.toString(totala);
        //  String total1=model.getValueAt(i,9).toString();
        
      
          
          
          
                                        
                                  /*      Calender c= Calender.getInstance();
                                        c.add(Calender.Date,30);
                                        Date d=c.getTime(); 
                                   Date d = new Date();
  
        d.setTime(d.getTime() + 30L * 24 * 60 * 60 * 1000);
        System.out.println("30 days after today is: " + d);  
                                  Date d= new Date();
                                  d.add(Date,30);
      SimpleDateFormat s= new SimpleDateFormat("hh:mm:ss a");
      lbl_next_ins_date.setText(s.format(d));
        SimpleDateFormat datefmt = new SimpleDateFormat("MM/dd/yyyy"); // Or format you're using
        
        
        String dates =((lbl_next_ins_date)date.getDateEditor().getUiComponent()).getText();
Date date = datefmt.parse(dates);

Calendar cal = Calendar.getInstance();
cal.setTime(date);
cal.add(Calendar.DAY_OF_MONTH, 30); // Add 30 days
Date futureDate = cal.getTime();*/
                               /*    private static final String DATE_FORMAT = "yyyy/MM/dd HH:mm:ss";
    private static final DateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
    private static final DateTimeFormatter dateFormat8 = DateTimeFormatter.ofPattern(DATE_FORMAT);

    public static void main(String[] args) {

		// Get current date
        Date currentDate = new Date();
        System.out.println("date : " + dateFormat.format(currentDate));

        // convert date to localdatetime
        LocalDateTime localDateTime = currentDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        System.out.println("localDateTime : " + dateFormat8.format(localDateTime));

        // plus one
        localDateTime = localDateTime.plusYears(1).plusMonths(1).plusDays(1);
        localDateTime = localDateTime.plusHours(1).plusMinutes(2).minusMinutes(1).plusSeconds(1);

        // convert LocalDateTime to date
        Date currentDatePlusOneDay = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());

        System.out.println("\nOutput : " + dateFormat.format(currentDatePlusOneDay));  */
                       /*        String oldDate=lbl_ins_date.getText();
                               SimpleDateFormat sdfu=new SimpleDateFormat("yyyy-MM-dd");
                               Calendar c = Calendar.getInstance();
                               try{
                                   c.setTime(sdfu.parse(oldDate));
                               }
                               catch(ParseException e){
                                   e.printStackTrace();
                                  
                               }
                               c.add(Calendar.DAY_OF_MONTH, 30);  
                               String newDate = sdfu.format(c.getTime());  
                               lbl_next_ins_date.setText(newDate); */
                                        
    }//GEN-LAST:event_jTable1MouseClicked

    private void btn_depositActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_depositActionPerformed
          float bb= Float.parseFloat(lblcash.getText());
float bbc=Float.parseFloat(label_due_amount.getText());
         if(bb>0){
             if(bb<=bbc){
            int opt= JOptionPane.showConfirmDialog(null, "Sure to Deposit to Account", "Deposit?", JOptionPane.YES_NO_OPTION);
         if(opt==0){//value of yes = 0
             float nextinsp=Float.parseFloat(lbl_insno.getText());
             float insp=Float.parseFloat(lbl_time_period.getText());
          //   if(nextinsp<=insp){
             try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  // load the driver
           String url = "jdbc:sqlserver://localhost:1433;databaseName=bankoneer_db;user=sa;password=bishal";
           Connection con = DriverManager.getConnection(url);
           int row= jTable1.getSelectedRow();
           String value=(jTable1.getModel().getValueAt(row, 2).toString());
         //  int installment_numberrr=Integer.parseInt(lbl_insno.getText())+1;
         //  lbl_insno.setText(Integer.toString(installment_numberrr));
           float loan_minus= Float.parseFloat(lblcash.getText())-Float.parseFloat(lbl_interest_amount.getText());
           float loan_plus= Float.parseFloat(lbl_remaining.getText())+Float.parseFloat(lbl_interest_amount.getText());
           float loan_plus_x=Float.parseFloat(lbl_remaining.getText())+Float.parseFloat(lbl_interest_amount.getText())+Float.parseFloat(lbl_fine.getText());
           float remaining = Float.parseFloat(lbl_remaining.getText())-loan_minus;
           String remainingg=Float.toString(remaining);
           float ina=Float.parseFloat(lbl_interest_rate.getText())/100;
    float abdc= ina/12;
    float montho= remaining*abdc;
    String interest_amount=Float.toString(montho);
    
    float finer= (float) 2/100;
    float finer_r= (float) finer/12;
    float finer_month=remaining*finer_r;
    String finer_monthh=Float.toString(finer_month);
    float remains=remaining+finer_month;
    String remainss=Float.toString(remains); 
   /* if(remaining>0 & nextinsp>=insp){
        
    String query1 = "UPDATE loan_account SET remaining_loan=? , interest_amount=?, installment=? , fine=?,installment_date=? where accountnumber="+value;
                       PreparedStatement pst= con.prepareStatement(query1);
                       pst.setString(1, remainingg);
                       pst.setString(2, interest_amount);
                       pst.setString(3, lbl_insno.getText());
                      // float flo=Float.parseFloat(lbl_fine.getText());                       
                       pst.setString(4,remainss);
                       SimpleDateFormat sdfaa= new SimpleDateFormat("yyyy-MM-dd");
    
                       String oldDate=lbl_ins_date.getText();
                               SimpleDateFormat sdfu=new SimpleDateFormat("yyyy-MM-dd");
                               Calendar c = Calendar.getInstance();
                               try{
                                   c.setTime(sdfu.parse(oldDate));
                               }
                               catch(ParseException e){
                                   e.printStackTrace();
                                  
                               }
                               c.add(Calendar.DAY_OF_MONTH, 30);  
                               String newDate = sdfu.format(c.getTime()); 
                               lbl_next_ins_date.setText(newDate);
                                pst.setString(5, newDate);
                             //  lbl_next_ins_date.setText(newDate);
                            // pst.setString(14,"initial");
                       
                       pst.executeUpdate();
                       
                       //insert to loan history
                           String queryyyy="insert into loan_history(name,account_number,datee,loan_amount,interest_rate,time_period,monthly_amount,remaining_loan,interest_amount,installment,fine,installment_date,next_installment_date,status,deposited) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
     PreparedStatement pstooa= con.prepareStatement(queryyyy);
    pstooa.setString(1, lblnamee.getText());
     pstooa.setString(2, lblacc.getText());
      Date obj= new Date();
String dateee=obj.toString();
    pstooa.setString(3,dateee);
    pstooa.setString(4, lbl_loan.getText());
    pstooa.setString(5, lbl_interest_rate.getText());
    pstooa.setString(6, lbl_time_period.getText());
    pstooa.setString(7, lbl_monthly.getText());
    pstooa.setString(8, lbl_remaining.getText());
    pstooa.setString(9, lbl_interest_amount.getText());
    pstooa.setString(10, lbl_insno.getText());
    pstooa.setString(11, lbl_fine.getText());
    pstooa.setString(12, lbl_ins_date.getText());
    pstooa.setString(13, lbl_next_ins_date.getText());
    pstooa.setString(14,"DEPOSITED");
    pstooa.setString(15, lblcash.getText());
     pstooa.executeUpdate();  
                       
   
*/
   // int installment_number=Integer.parseInt(lbl_insno.getText())+1;
    //String installment_numberr=Integer.toString(installment_number);
     float nextinspa=Float.parseFloat(lbl_insno.getText());
             float inspa=Float.parseFloat(lbl_time_period.getText());
             //clear calculation
             float comp=Float.parseFloat(lbl_remaining.getText());
    float compa=Float.parseFloat(lblcash.getText());
   // float compare=comp+compa;
   // ---------
    
    if(nextinspa<=inspa){  //eta dekhi   
        if(nextinspa==inspa && loan_plus==compa ){   //...
        String query1 = "UPDATE loan_account SET remaining_loan=? , interest_amount=?, installment=? , fine=?,installment_date=? where accountnumber="+value;
                       PreparedStatement pst= con.prepareStatement(query1);
                       pst.setString(1, "CLEARED");
                       pst.setString(2, "CLEARED");
                       pst.setString(3, lbl_insno.getText());
                       float flo=Float.parseFloat(lbl_fine.getText());                       
                       pst.setFloat(4,flo);
                      //pst.setString(4,finer_monthh);
                       SimpleDateFormat sdfaa= new SimpleDateFormat("yyyy-MM-dd");
    
                       String oldDate=lbl_ins_date.getText();
                               SimpleDateFormat sdfu=new SimpleDateFormat("yyyy-MM-dd");
                               Calendar c = Calendar.getInstance();
                               try{
                                   c.setTime(sdfu.parse(oldDate));
                               }
                               catch(ParseException e){
                                   e.printStackTrace();
                                  
                               }
                               c.add(Calendar.DAY_OF_MONTH, 30);  
                               String newDate = sdfu.format(c.getTime()); 
                               lbl_next_ins_date.setText(newDate);
                                pst.setString(5, "CLEARED");
                             //  lbl_next_ins_date.setText(newDate);
                            // pst.setString(14,"initial");
                       
                       pst.executeUpdate();
                       
                       String queryyyy="insert into loan_history(name,account_number,datee,loan_amount,interest_rate,time_period,monthly_amount,remaining_loan,interest_amount,installment,fine,installment_date,next_installment_date,status,deposited) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
     PreparedStatement pstooa= con.prepareStatement(queryyyy);
    pstooa.setString(1, lblnamee.getText());
     pstooa.setString(2, lblacc.getText());
      Date obj= new Date();
String dateee=obj.toString();
    pstooa.setString(3,dateee);
    pstooa.setString(4, lbl_loan.getText());
    pstooa.setString(5, lbl_interest_rate.getText());
    pstooa.setString(6, lbl_time_period.getText());
    pstooa.setString(7, lbl_monthly.getText());
    pstooa.setString(8, "CLEARED");
    pstooa.setString(9, "CLEARED");
    pstooa.setString(10, lbl_insno.getText());
    pstooa.setString(11, lbl_fine.getText());
    pstooa.setString(12, lbl_ins_date.getText());
    pstooa.setString(13, "CLEARED");
    pstooa.setString(14,"DEPOSITED");
    pstooa.setString(15, lblcash.getText());
     pstooa.executeUpdate();  
                       
                      String query11 = "DELETE from loan_account where accountnumber="+value;
           PreparedStatement stop = con.prepareStatement(query11);
           stop.executeUpdate(); 
                       
                       
    }
        else{  //////
String query1 = "UPDATE loan_account SET remaining_loan=? , interest_amount=?, installment=? , fine=?,installment_date=? where accountnumber="+value;
                       PreparedStatement pst= con.prepareStatement(query1);
                       pst.setString(1, remainingg);
                       pst.setString(2, interest_amount);
                       pst.setString(3, lbl_insno.getText());
                       float flo=Float.parseFloat(lbl_fine.getText());                       
                       pst.setFloat(4,flo);
                      //pst.setString(4,finer_monthh);
                       SimpleDateFormat sdfaa= new SimpleDateFormat("yyyy-MM-dd");
    
                       String oldDate=lbl_ins_date.getText();
                               SimpleDateFormat sdfu=new SimpleDateFormat("yyyy-MM-dd");
                               Calendar c = Calendar.getInstance();
                               try{
                                   c.setTime(sdfu.parse(oldDate));
                               }
                               catch(ParseException e){
                                   e.printStackTrace();
                                  
                               }
                               c.add(Calendar.DAY_OF_MONTH, 30);  
                               String newDate = sdfu.format(c.getTime()); 
                               lbl_next_ins_date.setText(newDate);
                                pst.setString(5, newDate);
                             //  lbl_next_ins_date.setText(newDate);
                            // pst.setString(14,"initial");
                       
                       pst.executeUpdate();
                      
                       //insert to loan history
                           String queryyyy="insert into loan_history(name,account_number,datee,loan_amount,interest_rate,time_period,monthly_amount,remaining_loan,interest_amount,installment,fine,installment_date,next_installment_date,status,deposited) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
     PreparedStatement pstooa= con.prepareStatement(queryyyy);
    pstooa.setString(1, lblnamee.getText());
     pstooa.setString(2, lblacc.getText());
      Date obj= new Date();
String dateee=obj.toString();
    pstooa.setString(3,dateee);
    pstooa.setString(4, lbl_loan.getText());
    pstooa.setString(5, lbl_interest_rate.getText());
    pstooa.setString(6, lbl_time_period.getText());
    pstooa.setString(7, lbl_monthly.getText());
    pstooa.setString(8, lbl_remaining.getText());
    pstooa.setString(9, lbl_interest_amount.getText());
    pstooa.setString(10, lbl_insno.getText());
    pstooa.setString(11, lbl_fine.getText());
    pstooa.setString(12, lbl_ins_date.getText());
    pstooa.setString(13, lbl_next_ins_date.getText());
    pstooa.setString(14,"DEPOSITED");
    pstooa.setString(15, lblcash.getText());
     pstooa.executeUpdate(); 
     } 
    } //if  
    
    
    
    
    
    
    else{
        
        if(nextinspa>inspa && loan_plus_x==compa ){
        
                    String query1 = "UPDATE loan_account SET remaining_loan=? , interest_amount=?, installment=? , fine=?,installment_date=? where accountnumber="+value;
                       PreparedStatement pst= con.prepareStatement(query1);
                       pst.setString(1, "CLEARED");
                       pst.setString(2, "CLEARED");
                       pst.setString(3, lbl_insno.getText());
                       float flo=Float.parseFloat(lbl_fine.getText());                       
                       pst.setFloat(4,flo);
                      //pst.setString(4,finer_monthh);
                       SimpleDateFormat sdfaa= new SimpleDateFormat("yyyy-MM-dd");
    
                       String oldDate=lbl_ins_date.getText();
                               SimpleDateFormat sdfu=new SimpleDateFormat("yyyy-MM-dd");
                               Calendar c = Calendar.getInstance();
                               try{
                                   c.setTime(sdfu.parse(oldDate));
                               }
                               catch(ParseException e){
                                   e.printStackTrace();
                                  
                               }
                               c.add(Calendar.DAY_OF_MONTH, 30);  
                               String newDate = sdfu.format(c.getTime()); 
                               lbl_next_ins_date.setText(newDate);
                                pst.setString(5, "CLEARED");
                             //  lbl_next_ins_date.setText(newDate);
                            // pst.setString(14,"initial");
                       
                       pst.executeUpdate();
                       
                       String queryyyy="insert into loan_history(name,account_number,datee,loan_amount,interest_rate,time_period,monthly_amount,remaining_loan,interest_amount,installment,fine,installment_date,next_installment_date,status,deposited) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
     PreparedStatement pstooa= con.prepareStatement(queryyyy);
    pstooa.setString(1, lblnamee.getText());
     pstooa.setString(2, lblacc.getText());
      Date obj= new Date();
String dateee=obj.toString();
    pstooa.setString(3,dateee);
    pstooa.setString(4, lbl_loan.getText());
    pstooa.setString(5, lbl_interest_rate.getText());
    pstooa.setString(6, lbl_time_period.getText());
    pstooa.setString(7, lbl_monthly.getText());
    pstooa.setString(8, "CLEARED");
    pstooa.setString(9, "CLEARED");
    pstooa.setString(10, lbl_insno.getText());
    pstooa.setString(11, lbl_fine.getText());
    pstooa.setString(12, lbl_ins_date.getText());
    pstooa.setString(13, "CLEARED");
    pstooa.setString(14,"DEPOSITED");
    pstooa.setString(15, lblcash.getText());
     pstooa.executeUpdate();  
                       
                      String query11 = "DELETE from loan_account where accountnumber="+value;
           PreparedStatement stop = con.prepareStatement(query11);
           stop.executeUpdate();
                                 String query111 = "DELETE from loan_customer_database where accountnumber="+value;
           PreparedStatement stopp = con.prepareStatement(query111);
           stopp.executeUpdate();
            
            
        }
        else{
     String query11 = "UPDATE loan_account SET remaining_loan=? , interest_amount=?, installment=? , fine=?,installment_date=? where accountnumber="+value;
                       PreparedStatement psot= con.prepareStatement(query11);
                       psot.setString(1, remainss);
                       psot.setString(2, interest_amount);
                       psot.setString(3, lbl_insno.getText());
                      // float flo=Float.parseFloat(lbl_fine.getText());                       
                       psot.setString(4,finer_monthh);
                       SimpleDateFormat sdfaa= new SimpleDateFormat("yyyy-MM-dd");
    
                       String oldDate=lbl_ins_date.getText();
                               SimpleDateFormat sdfu=new SimpleDateFormat("yyyy-MM-dd");
                               Calendar c = Calendar.getInstance();
                               try{
                                   c.setTime(sdfu.parse(oldDate));
                               }
                               catch(ParseException e){
                                   e.printStackTrace();
                                  
                               }
                               c.add(Calendar.DAY_OF_MONTH, 30);  
                               String newDate = sdfu.format(c.getTime()); 
                               lbl_next_ins_date.setText(newDate);
                                psot.setString(5, newDate);
                             //  lbl_next_ins_date.setText(newDate);
                            // pst.setString(14,"initial");
                       
                       psot.executeUpdate();
                       
                       //insert to loan history
                           String queryyyy="insert into loan_history(name,account_number,datee,loan_amount,interest_rate,time_period,monthly_amount,remaining_loan,interest_amount,installment,fine,installment_date,next_installment_date,status,deposited) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
     PreparedStatement pstooa= con.prepareStatement(queryyyy);
    pstooa.setString(1, lblnamee.getText());
     pstooa.setString(2, lblacc.getText());
      Date obj= new Date();
String dateee=obj.toString();
    pstooa.setString(3,dateee);
    pstooa.setString(4, lbl_loan.getText());
    pstooa.setString(5, lbl_interest_rate.getText());
    pstooa.setString(6, lbl_time_period.getText());
    pstooa.setString(7, lbl_monthly.getText());
    pstooa.setString(8, remainss);
    pstooa.setString(9, lbl_interest_amount.getText());
    pstooa.setString(10, lbl_insno.getText());
    pstooa.setString(11,finer_monthh );
    pstooa.setString(12, lbl_ins_date.getText());
    pstooa.setString(13, lbl_next_ins_date.getText());
    pstooa.setString(14,"DEPOSITED");
    pstooa.setString(15, lblcash.getText());
     pstooa.executeUpdate();
     
        }
     
    }
    
    
    
    
        
     
     
     
     
                       deposit_receipt();
                       DefaultTableModel model=(DefaultTableModel)jTable1.getModel();
      model.setRowCount(0);
      showindividual_user();
                        JOptionPane.showMessageDialog(null, "Deposited Successfully!");
            lblacc.setText("");
                    lblnamee.setText("");
                    lbl_loan.setText("");
                            lbl_remaining.setText("");
                            lblcash.setText("");
                                    lbl_ins_date.setText("");
                                    lbl_next_ins_date.setText("");
                                            lbl_time_period.setText("");
                                            lbl_insno.setText("");
                                                    lbl_monthly.setText("");
                                                    lbl_interest_amount.setText("");
                                                            lbl_fine.setText("");
                                                            lbl_interest_rate.setText("");
                                                            label_due_amount.setText("");
           
           String a=Float.toString(loan_minus);
           String b=Float.toString(remaining);
           System.out.println(a);
           System.out.println(b);
           System.out.println(interest_amount);
          // System.out.println(installment_numberr);
           // System.out.println(newDate);
            
            
            
            
            
            
            
            
             }
             catch(Exception e){
    JOptionPane.showMessageDialog(null, e);
             }
         }
        // } //if
       /*  else{
                          try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  // load the driver
           String url = "jdbc:sqlserver://localhost:1433;databaseName=bankoneer_db;user=sa;password=bishal";
           Connection con = DriverManager.getConnection(url);
           int row= jTable1.getSelectedRow();
           String value=(jTable1.getModel().getValueAt(row, 2).toString());
         //  int installment_numberrr=Integer.parseInt(lbl_insno.getText())+1;
         //  lbl_insno.setText(Integer.toString(installment_numberrr));
           float loan_minus= Float.parseFloat(lblcash.getText())-Float.parseFloat(lbl_interest_amount.getText());
           float remaining = Float.parseFloat(lbl_remaining.getText())-loan_minus;
           String remainingg=Float.toString(remaining);
           float ina=Float.parseFloat(lbl_interest_rate.getText())/100;
    float abdc= ina/12;
    float montho= remaining*abdc;
    String interest_amount=Float.toString(montho);

   // lbl_fine.setText(remainss);
    
   // int installment_number=Integer.parseInt(lbl_insno.getText())+1;
    //String installment_numberr=Integer.toString(installment_number);
String query1 = "UPDATE loan_account SET remaining_loan=? , interest_amount=?, installment=? , fine=?,installment_date=? where accountnumber="+value;
                       PreparedStatement pst= con.prepareStatement(query1);
                       pst.setString(1, remainingg);
                       pst.setString(2, interest_amount);
                       pst.setString(3, lbl_insno.getText());
                       float flo=Float.parseFloat(lbl_fine.getText());                       
                       pst.setFloat(4,flo);
                       SimpleDateFormat sdfaa= new SimpleDateFormat("yyyy-MM-dd");
    
                       String oldDate=lbl_ins_date.getText();
                               SimpleDateFormat sdfu=new SimpleDateFormat("yyyy-MM-dd");
                               Calendar c = Calendar.getInstance();
                               try{
                                   c.setTime(sdfu.parse(oldDate));
                               }
                               catch(ParseException e){
                                   e.printStackTrace();
                                  
                               }
                               c.add(Calendar.DAY_OF_MONTH, 30);  
                               String newDate = sdfu.format(c.getTime()); 
                               lbl_next_ins_date.setText(newDate);
                                pst.setString(5, newDate);
                             //  lbl_next_ins_date.setText(newDate);
                            // pst.setString(14,"initial");
                       
                       pst.executeUpdate();
                       
                       //insert to loan history
                           String queryyyy="insert into loan_history(name,account_number,datee,loan_amount,interest_rate,time_period,monthly_amount,remaining_loan,interest_amount,installment,fine,installment_date,next_installment_date,status,deposited) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
     PreparedStatement pstooa= con.prepareStatement(queryyyy);
    pstooa.setString(1, lblnamee.getText());
     pstooa.setString(2, lblacc.getText());
      Date obj= new Date();
String dateee=obj.toString();
    pstooa.setString(3,dateee);
    pstooa.setString(4, lbl_loan.getText());
    pstooa.setString(5, lbl_interest_rate.getText());
    pstooa.setString(6, lbl_time_period.getText());
    pstooa.setString(7, lbl_monthly.getText());
    pstooa.setString(8, lbl_remaining.getText());
    pstooa.setString(9, lbl_interest_amount.getText());
    pstooa.setString(10, lbl_insno.getText());
    pstooa.setString(11, lbl_fine.getText());
    pstooa.setString(12, lbl_ins_date.getText());
    pstooa.setString(13, lbl_next_ins_date.getText());
    pstooa.setString(14,"DEPOSITED/FINE");
    pstooa.setString(15, lblcash.getText());
     pstooa.executeUpdate();  
                       
                       deposit_receipt();
                       DefaultTableModel model=(DefaultTableModel)jTable1.getModel();
      model.setRowCount(0);
      showindividual_user();
                        JOptionPane.showMessageDialog(null, "Deposited Successfully!");
            lblacc.setText("");
                    lblnamee.setText("");
                    lbl_loan.setText("");
                            lbl_remaining.setText("");
                            lblcash.setText("");
                                    lbl_ins_date.setText("");
                                    lbl_next_ins_date.setText("");
                                            lbl_time_period.setText("");
                                            lbl_insno.setText("");
                                                    lbl_monthly.setText("");
                                                    lbl_interest_amount.setText("");
                                                            lbl_fine.setText("");
                                                            lbl_interest_rate.setText("");
           
           String a=Float.toString(loan_minus);
           String b=Float.toString(remaining);
           System.out.println(a);
           System.out.println(b);
           System.out.println(interest_amount);
          // System.out.println(installment_numberr);
            System.out.println(newDate);
            
            
            
            
            
            
            
            
             }
             catch(Exception e){
    JOptionPane.showMessageDialog(null, e);
             }
         } */
         
         }
         else{
         JOptionPane.showMessageDialog(null,"The Input Amount is greater than loan Amount!");
         }
         
         }
         else{
             JOptionPane.showMessageDialog(null, "Invalid amount Denominations");
         }
    }//GEN-LAST:event_btn_depositActionPerformed

    void deposit_receipt(){
                //print receipt
            receipt.setText("***************************************************************************************************************************************\n");       
receipt.setText(receipt.getText()+"*************************************BANKONEER********************************************************************\n");
            receipt.setText(receipt.getText()+"*                                              *Loan Deposit Receipt*                                                           *\n");
receipt.setText(receipt.getText()+"***************************************************************************************************************************************\n");

Date obj= new Date();
String date=obj.toString();
receipt.setText(receipt.getText()+"\n"+date+"\n");
receipt.setText(receipt.getText()+"\n");
receipt.setText(receipt.getText()+"Account Type: Daily Savings \n");
receipt.setText(receipt.getText()+"Account Holder's Name: "+lblnamee.getText()+"\n");
receipt.setText(receipt.getText()+"Account Number: "+lblacc.getText()+"\n");
receipt.setText(receipt.getText()+"Loan Amount(In Figures): "
        + "NRS: "+lbl_loan.getText()+"\n");
receipt.setText(receipt.getText()+"Interest Rate(%): "
        +lbl_interest_rate.getText()+"%\n");
receipt.setText(receipt.getText()+"Installment Time Period (in months):"
        +lbl_time_period.getText()+"\n");
receipt.setText(receipt.getText()+"Monthly Amount to be deposited:"
        + "NRS: "+lbl_monthly.getText()+"\n");
receipt.setText(receipt.getText()+"Installment Period Number (in months):"
        +lbl_insno.getText()+"\n");
receipt.setText(receipt.getText()+"Remaining Loan Amount:"
        + "NRS: "+lbl_remaining.getText()+"\n");
receipt.setText(receipt.getText()+"Interest Amount:"
        + "NRS: "+lbl_interest_amount.getText()+"\n");
float loan_minus= Float.parseFloat(lblcash.getText())-Float.parseFloat(lbl_interest_amount.getText());
           float loan_plus= Float.parseFloat(lbl_remaining.getText())+Float.parseFloat(lbl_interest_amount.getText());
           float loan_plus_x=Float.parseFloat(lbl_remaining.getText())+Float.parseFloat(lbl_interest_amount.getText())+Float.parseFloat(lbl_fine.getText());
           float remaining = Float.parseFloat(lbl_remaining.getText())-loan_minus;
           String remainingg=Float.toString(remaining);
           float ina=Float.parseFloat(lbl_interest_rate.getText())/100;
    float abdc= ina/12;
    float montho= remaining*abdc;
    String interest_amount=Float.toString(montho);
    
    float finer= (float) 2/100;
    float finer_r= (float) finer/12;
    float finer_month=remaining*finer_r;
    String finer_monthh=Float.toString(finer_month);
    float remains=remaining+finer_month;
    String remainss=Float.toString(remains); 

receipt.setText(receipt.getText()+"Fine:"
        + "NRS: "+finer_monthh+"\n");
receipt.setText(receipt.getText()+"Total Due Amount:"
        + "NRS: "+label_due_amount.getText()+"\n");
receipt.setText(receipt.getText()+"Cash Denominations (Deposited):"
        + "NRS: "+lblcash.getText()+"\n");
float a= Float.parseFloat(lbl_remaining.getText())+Float.parseFloat(lbl_interest_amount.getText())+finer_month-Float.parseFloat(lblcash.getText());
receipt.setText(receipt.getText()+"Remaining Cash Denominations*: "+"NRS: "
        +a+"\n");
receipt.setText(receipt.getText()+"Installment Date:"
        +lbl_ins_date.getText()+"\n");
receipt.setText(receipt.getText()+"Next Installment Date:"
        +lbl_next_ins_date.getText()+"\n");
receipt.setText(receipt.getText()+"*************************************BANKONEER********************************************************************\n");


/*receipt.setText(receipt.getText()+"************                                    +"+"\n");
receipt.setText(receipt.getText()+"Amount Deposited (In Figures) NRS: "+lblcash.getText()+"\n");
float a= Float.parseFloat(lblcurrencyy.getText())+Float.parseFloat(lblcash.getText());
receipt.setText(receipt.getText()+"Total Accont Balance (In Figures) NRS: "+a+"\n");
receipt.setText(receipt.getText()+"***************************************************************************************************************************************\n");
receipt.setText(receipt.getText()+"***************************************************************************************************************************************\n");
*/
try{
    receipt.print();
}
catch(Exception e){
    
}
}
    
    
    
    private void btn_depositMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_depositMouseClicked
       
    }//GEN-LAST:event_btn_depositMouseClicked

    private void lbl_interest_rateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lbl_interest_rateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lbl_interest_rateActionPerformed

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
            java.util.logging.Logger.getLogger(cashier_loan_panel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(cashier_loan_panel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(cashier_loan_panel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(cashier_loan_panel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new cashier_loan_panel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_deposit;
    private javax.swing.JLabel dateLab;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField label_due_amount;
    private javax.swing.JTextField lbl_fine;
    private javax.swing.JTextField lbl_ins_date;
    private javax.swing.JTextField lbl_insno;
    private javax.swing.JTextField lbl_interest_amount;
    private javax.swing.JTextField lbl_interest_rate;
    private javax.swing.JTextField lbl_loan;
    private javax.swing.JTextField lbl_monthly;
    private javax.swing.JTextField lbl_next_ins_date;
    private javax.swing.JTextField lbl_remaining;
    private javax.swing.JTextField lbl_time_period;
    private javax.swing.JTextField lblacc;
    private javax.swing.JTextField lblcash;
    private javax.swing.JTextField lblnamee;
    private javax.swing.JTextField lblsearch;
    private javax.swing.JTextField lblsearch1;
    private javax.swing.JTextArea receipt;
    private javax.swing.JLabel timeLab;
    // End of variables declaration//GEN-END:variables
}
