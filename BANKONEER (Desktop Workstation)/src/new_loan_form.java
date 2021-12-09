
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
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
public class new_loan_form extends javax.swing.JFrame {
        String title,maritial,gender,lblhwnamee;
DefaultTableModel dm;
String filename=null , filename1=null;//location
byte[] image, signature=null,citizenshipimage=null,documentimage=null; //image
    /**
     * Creates new form new_loan_form
     */
    public new_loan_form() {
        Toolkit tk = getToolkit();
 int xsize=(int) tk.getScreenSize().getWidth();
  int ysize=(int) tk.getScreenSize().getHeight();
   this.setSize(xsize,ysize);
        initComponents();
        showall_user();
        this.image=null;
   this.signature=null;
   this.citizenshipimage=null;
   this.documentimage=null;
    }
public ArrayList<view_customers_details> userList(){
    ArrayList<view_customers_details> userList= new ArrayList<>();//create object named arraylist
    //select data from the database
    try{
     Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  // load the driver
           String url = "jdbc:sqlserver://localhost:1433;databaseName=bankoneer_db;user=sa;password=bishal";
           Connection con = DriverManager.getConnection(url);
           String query1 = "Select * from newmemberregistration";
           Statement st = con.createStatement();
      ResultSet rs = st.executeQuery(query1);
      //create object for user
      view_customers_details user;
      while(rs.next()){ 
          user= new view_customers_details(rs.getInt("sno"),rs.getString("branch"),
        rs.getString("date"),rs.getString("accountype"),rs.getString("individual"),rs.getString("accountnumber"),
         rs.getString("title"),rs.getString("name"),rs.getString("gender"),rs.getString("maritial"),
        rs.getString("dob"),rs.getString("father"),rs.getString("mother"),rs.getString("gfather"),
        rs.getString("gmother"),rs.getString("hw"),rs.getString("nationality"),rs.getString("paddress"),
        rs.getString("taddress"),rs.getString("occupation"),rs.getString("education"),rs.getString("oname"),
        rs.getString("oaddress"),rs.getString("oemail"),rs.getString("mno"),rs.getString("mnoo"),
        rs.getString("landline"),rs.getString("email"),
        rs.getString("citizenship"),rs.getString("documentno"),rs.getBytes("image"), rs.getBytes("signature"),
                rs.getBytes("citizenshipimage"), rs.getBytes("documentimage"),
        rs.getString("username"),rs.getString("password"),rs.getString("transaction_password"));

      userList.add(user);
                  
                  }
    }
     catch(Exception e){
    JOptionPane.showMessageDialog(null, e);
            }
      return userList;
      }
public void showall_user(){
    ArrayList<view_customers_details> list = userList();
    DefaultTableModel model = (DefaultTableModel)jTable1.getModel();//typecast with default table model
    //create a array which stores the rows of the data
  // adjust table size  jTable1.getColumnModel().getColumn(0).setPreferredWidth(30);
jTable1.getColumnModel().getColumn(7).setPreferredWidth(400);
  jTable1.getColumnModel().getColumn(1).setPreferredWidth(40);
    jTable1.getColumnModel().getColumn(5).setPreferredWidth(300);
    jTable1.getColumnModel().getColumn(12).setPreferredWidth(30);
    jTable1.getColumnModel().getColumn(13).setPreferredWidth(30);  
     /*   jTable1.getColumnModel().getColumn(3).setPreferredWidth(40);*/
    //jTable1.getColumnModel().getColumn(5).setPreferredWidth(30); 
    Object[] row = new Object[33];
    for(int i=0; i<list.size();i++){
        row[0]=list.get(i).getsno();
        row[1]=list.get(i).getbranch();
        row[2]=list.get(i).getdate();
        row[3]=list.get(i).getaccounttype();
        row[4]=list.get(i).getindividual();
        row[5]=list.get(i).getaccountnumber();
        row[6]=list.get(i).gettitle();
        row[7]=list.get(i).getname();
        row[8]=list.get(i).getgender();
        row[9]=list.get(i).getmaritial();
         row[10]=list.get(i).getdob();       
        row[11]=list.get(i).getfather();
        row[12]=list.get(i).getmother();
        row[13]=list.get(i).getgfather();
        row[14]=list.get(i).getgmother();
        row[15]=list.get(i).gethw();
        row[16]=list.get(i).getnationality();
        row[17]=list.get(i).getpaddress();
        row[18]=list.get(i).gettaddress();
        row[19]=list.get(i).getoccupation();
        row[20]=list.get(i).geteducation();
        row[21]=list.get(i).getoname();
        row[22]=list.get(i).getoaddress();
        row[23]=list.get(i).getoemail();
        row[24]=list.get(i).getmno();
        row[25]=list.get(i).getmnoo();
        row[26]=list.get(i).getlandline();
row[27]=list.get(i).getemail();
        row[28]=list.get(i).getcitizenship();
        row[29]=list.get(i).getdocumentno();
         row[30]=list.get(i).getusername();
        row[31]=list.get(i).getpassword();
        row[32]=list.get(i).gettransaction_password();
        //add the row in the model
        model.addRow(row);
        
    }
}
private void filter(String query){
     dm=(DefaultTableModel) jTable1.getModel();
     TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(dm);
     jTable1.setRowSorter(tr);
     tr.setRowFilter(RowFilter.regexFilter(query));
 }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        lblsearch1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        lblsearch = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblacc = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        lblname = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        lbldate = new com.toedter.calendar.JDateChooser();
        lblcitizenship = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        lblpassport = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        lblgfather = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        lblusername = new javax.swing.JTextField();
        lblgmother = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        rsingle = new javax.swing.JRadioButton();
        rmarried = new javax.swing.JRadioButton();
        jLabel18 = new javax.swing.JLabel();
        lblhw = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lblnationality = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        lblpaddress = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lbltaddress = new javax.swing.JTextField();
        rmr = new javax.swing.JRadioButton();
        jLabel23 = new javax.swing.JLabel();
        rms = new javax.swing.JRadioButton();
        jLabel25 = new javax.swing.JLabel();
        rmrs = new javax.swing.JRadioButton();
        lbloccupation = new javax.swing.JTextField();
        jLabel41 = new javax.swing.JLabel();
        lbleducation = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        lbloname = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        lbloaddress = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        lbloemail = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        lblmo1 = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        lblmo2 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        lbllandline = new javax.swing.JTextField();
        rmale = new javax.swing.JRadioButton();
        jLabel33 = new javax.swing.JLabel();
        rfemale = new javax.swing.JRadioButton();
        jLabel34 = new javax.swing.JLabel();
        rother2 = new javax.swing.JRadioButton();
        lblemail = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        lblad = new com.toedter.calendar.JDateChooser();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        lblfather = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        lblmother = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lbl_morgage1 = new javax.swing.JTextField();
        jLabel40 = new javax.swing.JLabel();
        lbl_loan_amount = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        lbl_loan_interest = new javax.swing.JTextField();
        jLabel43 = new javax.swing.JLabel();
        lbl_time_period = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        lbl_morgage = new javax.swing.JComboBox<>();
        lblbranch = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setText("Register Loan Form");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Sno", "Branch", "Date", "Account Type", "Individual", "Account Number", "Title", "Name", "Gender", "Maritial", "DOB", "Father", "Mother", "G Father", "G Mother", "Spouse", "Nationality", "P Address", "T Address", "Occupation", "Education", "O Name", "O Address", "O Email", "Mobile", "Office Number", "Landline", "Email ID", "Citizenship", "Document ", "Username ", "Password", "Transaction_Password"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

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

        jLabel5.setText("Branch:");

        jLabel6.setText("Account Number:");

        lblacc.setEditable(false);

        jLabel8.setText("Full Name:");

        lblname.setEditable(false);

        jLabel7.setText("Date:");

        lbldate.setDateFormatString("yyyy-MM-dd");

        lblcitizenship.setEditable(false);

        jLabel36.setText("Document No.");

        lblpassport.setEditable(false);

        jLabel37.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel37.setText("Online Banking:");

        jLabel15.setText("Grand Father's Name:");

        jLabel16.setText("Username:");

        lblgfather.setEditable(false);

        jLabel17.setText("Grand Mother's Name:");

        lblusername.setEditable(false);

        lblgmother.setEditable(false);

        jLabel24.setText("Maritial:");

        buttonGroup3.add(rsingle);
        rsingle.setText("Single");

        buttonGroup3.add(rmarried);
        rmarried.setText("Married");

        jLabel18.setText("Spouse's Name:");

        lblhw.setEditable(false);

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel20.setText("Address Particulars:");

        jLabel10.setText("Nationality:");

        lblnationality.setEditable(false);

        jLabel19.setText("Permanent Address:");

        lblpaddress.setEditable(false);

        jLabel21.setText("Temporary Address:");

        jLabel9.setText("Title:");

        lbltaddress.setEditable(false);

        buttonGroup1.add(rmr);
        rmr.setText("Mr.");

        jLabel23.setText("(House No./Tole/Ward No./City/Country)");

        buttonGroup1.add(rms);
        rms.setText("Ms.");

        jLabel25.setText("Occupation:");

        buttonGroup1.add(rmrs);
        rmrs.setText("Mrs.");

        lbloccupation.setEditable(false);

        jLabel41.setText("Education:");

        lbleducation.setEditable(false);

        jLabel26.setText("Office Name");

        lbloname.setEditable(false);
        lbloname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lblonameActionPerformed(evt);
            }
        });

        jLabel28.setText("Address:");

        lbloaddress.setEditable(false);

        jLabel29.setText("Email:");

        lbloemail.setEditable(false);

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel30.setText("Contact Information:");

        jLabel31.setText("Mobile No. 1");

        lblmo1.setEditable(false);

        jLabel32.setText("Office Number:");

        lblmo2.setEditable(false);

        jLabel11.setText("Gender:");

        lbllandline.setEditable(false);

        buttonGroup2.add(rmale);
        rmale.setText("Male");

        jLabel33.setText("Landline:");

        buttonGroup2.add(rfemale);
        rfemale.setText("Female");

        jLabel34.setText("Email:");

        buttonGroup2.add(rother2);
        rother2.setText("Other");

        lblemail.setEditable(false);

        jLabel12.setText("D.O.B.(A.D.)");

        jLabel35.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel35.setText("Identification Document:");

        jLabel13.setText("Citizenship No.");

        jLabel14.setText("Father's Name:");

        lblfather.setEditable(false);

        jLabel38.setText("Mother's Name:");

        lblmother.setEditable(false);

        jLabel39.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel39.setText("Loan Credentials:");

        jLabel1.setText("Morgage Type:");

        jLabel40.setText("Morgage Number:");

        jLabel42.setText("Loan Amount:");

        jLabel22.setText("Loan Interest Rate:");

        jLabel43.setText("Time Period:");

        jLabel27.setText("/month");

        jButton1.setForeground(new java.awt.Color(255, 0, 0));
        jButton1.setText("Register to LOAN ACCOUNT");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        lbl_morgage.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Land and Home Ownerhip Document", "Jwelery/Ornament", "Vehicle", "Certificate(Citizenship/Documents/Academic Certificate)", " " }));

        lblbranch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Balaju\t", "DurbarMarg", "Putalisadak", "Kalanki", " " }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblsearch1, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblsearch, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rmr)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rms)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rmrs)
                                .addGap(75, 75, 75)
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rmale)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rfemale)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rother2)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(jLabel24)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rsingle)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rmarried))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblfather, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel38)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblmother, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblgfather, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblgmother)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel18))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(156, 156, 156)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblacc, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblname, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblhw, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel25)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbloccupation, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel41)
                                .addGap(136, 136, 136))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(70, 70, 70)
                                .addComponent(lbleducation, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel26)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbloname, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel28)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbloaddress, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(jLabel29)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbloemail, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel20)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblnationality, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblpaddress, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbltaddress, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel23))
                    .addComponent(jLabel30)
                    .addComponent(jLabel35)
                    .addComponent(jLabel37)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblcitizenship, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(66, 66, 66)
                        .addComponent(jLabel36)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblpassport, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblusername, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel39)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbl_morgage, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel40)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lbl_morgage1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblbranch, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbldate, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(237, 237, 237)))
                .addGap(0, 100, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel31)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblmo1)
                .addGap(18, 18, 18)
                .addComponent(jLabel32)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblmo2, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel33)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbllandline, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(jLabel34)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblemail))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel42)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_loan_amount, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_loan_interest, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel43)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_time_period, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel27)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lblsearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(lblsearch1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(lblacc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(lblname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel11)
                        .addComponent(rmale)
                        .addComponent(rfemale)
                        .addComponent(rother2)
                        .addComponent(jLabel12)
                        .addComponent(jLabel9)
                        .addComponent(rmr)
                        .addComponent(rms)
                        .addComponent(rmrs))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel24)
                            .addComponent(rsingle)
                            .addComponent(rmarried))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(lblfather, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel38)
                    .addComponent(lblmother, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(lblgfather, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17)
                    .addComponent(lblgmother, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18)
                    .addComponent(lblhw, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(lblnationality, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19)
                    .addComponent(lblpaddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21)
                    .addComponent(lbltaddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(lbloccupation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbleducation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel41)
                    .addComponent(jLabel26)
                    .addComponent(lbloname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel28)
                    .addComponent(lbloaddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel29)
                    .addComponent(lbloemail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31)
                    .addComponent(lblmo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel32)
                    .addComponent(lblmo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel33)
                    .addComponent(lbllandline, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel34)
                    .addComponent(lblemail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel35)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel13)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblcitizenship, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel36)
                        .addComponent(lblpassport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel37)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(lblusername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel39)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jLabel40)
                        .addComponent(lbl_morgage1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5)
                        .addComponent(jLabel7)
                        .addComponent(lbl_morgage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblbranch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lbldate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel42)
                    .addComponent(lbl_loan_amount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22)
                    .addComponent(lbl_loan_interest, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel43)
                    .addComponent(lbl_time_period, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27)
                    .addComponent(jButton1))
                .addGap(0, 8, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int i = jTable1.getSelectedRow();
        TableModel model= jTable1.getModel();
     //   lblbranch.setText(model.getValueAt(i,1).toString());
        lblacc.setText(model.getValueAt(i,5).toString());
        lblname.setText(model.getValueAt(i,7).toString());
        String title =model.getValueAt(i,6).toString();
        if(title.equals("Mr")){
            rmr.setSelected(true);
            rms.setSelected(false);
            rmrs.setSelected(false);
        }
        if(title.equals("Mrs")){
            rmrs.setSelected(true);
            rms.setSelected(false);
            rmr.setSelected(false);
        }
        if(title.equals("Ms")){
            rms.setSelected(true);
            rmrs.setSelected(false);
            rmr.setSelected(false);
        }

        String gender=model.getValueAt(i,8).toString();
        if(gender.equals("Male")){
            rmale.setSelected(true);
            rfemale.setSelected(false);
        }
        if(gender.equals("Female")){
            rmale.setSelected(false);
            rfemale.setSelected(true);
        }
        if(gender.equals("other")){
            rother2.setSelected(true);
        }
        try{
            Date datee= new SimpleDateFormat("yyyy-MM-dd").parse((String)model.getValueAt(i,10));
            lblad.setDate(datee);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        String maritial=model.getValueAt(i,9).toString();
        if(maritial.equals("Single")){
            rsingle.setSelected(true);
            rmarried.setSelected(false);
        }
        if(maritial.equals("Married")){
            rmarried.setSelected(true);
            rsingle.setSelected(false);
        }
        lblfather.setText(model.getValueAt(i,11).toString());
        lblmother.setText(model.getValueAt(i,12).toString());
        lblgfather.setText(model.getValueAt(i,13).toString());
        lblgmother.setText(model.getValueAt(i,14).toString());
        lblhw.setText(model.getValueAt(i,15).toString());
        lblnationality.setText(model.getValueAt(i,16).toString());
        lblpaddress.setText(model.getValueAt(i,17).toString());
        lbltaddress.setText(model.getValueAt(i,18).toString());
        lbloccupation.setText(model.getValueAt(i,19).toString());
        lbleducation.setText(model.getValueAt(i,20).toString());
        lbloname.setText(model.getValueAt(i,21).toString());
        lbloaddress.setText(model.getValueAt(i,22).toString());
        lbloemail.setText(model.getValueAt(i,23).toString());
        lblmo1.setText(model.getValueAt(i,24).toString());
        lblmo2.setText(model.getValueAt(i,25).toString());
        lbllandline.setText(model.getValueAt(i,26).toString());
        lblemail.setText(model.getValueAt(i,27).toString());
        lblcitizenship.setText(model.getValueAt(i,28).toString());
        lblpassport.setText(model.getValueAt(i,29).toString());
        lblusername.setText(model.getValueAt(i,30).toString());
     //   lblpassword1.setText(model.getValueAt(i,31).toString());
       // lbltrans.setText(model.getValueAt(i,32).toString());

    }//GEN-LAST:event_jTable1MouseClicked

    private void lblsearch1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblsearch1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lblsearch1MouseClicked

    private void lblsearch1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lblsearch1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lblsearch1ActionPerformed

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

    private void lblonameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lblonameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lblonameActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName=bankoneer_db;user=sa;password=bishal";
            Connection con = DriverManager.getConnection(url);
            String query1="SELECT *FROM loan_customer_database WHERE accountnumber=? ";
            PreparedStatement psta= con.prepareStatement(query1);
            psta.setString(1,lblacc.getText());
            ResultSet rs=psta.executeQuery();
            if(rs.next()){
                JOptionPane.showMessageDialog(null,"Account Already in Loan Account!!!");
            }
            else{
        
        try{
           
            String query="insert into loan_customer_database(branch,date,accountnumber,title,name,gender,maritial,dob,father,mother,gfather,gmother,hw,paddress,taddress,occupation,mno,email,citizenship,documentno,username,morgage_type,morgage_number,loan_amount,loan_interest,time_period) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement pst= con.prepareStatement(query);
            String brans;
            brans= lblbranch.getSelectedItem().toString();
            pst.setString(1, brans);
            SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
    String date=sdf.format(lbldate.getDate());
    pst.setString(2,date);
    pst.setString(3, lblacc.getText());

    if(rmr.isSelected()){
                title="Mr";
            }

            if(rms.isSelected()){
                title="Ms";
            }
                        if(rmrs.isSelected()){
                title="Mrs";
            }           
             pst.setString(4, title);  
             pst.setString(5, lblname.getText());
             if(rmale.isSelected()){
                gender="Male";
            }
            if(rfemale.isSelected()){
                gender="Female";
            }
            if(rother2.isSelected()){
                gender="Other";
            }
             pst.setString(6, gender);
            if(rsingle.isSelected()){
                maritial="Single";
                             lblhwnamee="Not Married";
            }
            if(rmarried.isSelected()){
                maritial="Married";
            }
            pst.setString(7, maritial);
                        SimpleDateFormat sdfa= new SimpleDateFormat("yyyy-MM-dd");
            String date2=sdfa.format(lblad.getDate());
  pst.setString(8,date2);
   pst.setString(9, lblfather.getText());
            pst.setString(10, lblmother.getText());
            pst.setString(11, lblgfather.getText());
            pst.setString(12, lblgmother.getText());
            pst.setString(13, lblhw.getText());   
            pst.setString(14, lblpaddress.getText());
            pst.setString(15, lbltaddress.getText());       
             pst.setString(16, lbloccupation.getText());
   pst.setString(17, lblmo1.getText());
  pst.setString(18, lblemail.getText());
  pst.setString(19, lblcitizenship.getText());
    pst.setString(20, lblpassport.getText());
    pst.setString(21, lblusername.getText());
    String morgage;
            morgage= lbl_morgage.getSelectedItem().toString();
            pst.setString(22, morgage);
    pst.setString(23, lbl_morgage1.getText());
    pst.setString(24, lbl_loan_amount.getText());
    pst.setString(25, lbl_loan_interest.getText());
    pst.setString(26, lbl_time_period.getText());
    pst.executeUpdate();
    
    //insert into loan account database
    String queryy="insert into loan_account(name,accountnumber,date,username,loan_amount,interest_rate,time_period,monthly_amount,remaining_loan,interest_amount,installment,fine,installment_date) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
     PreparedStatement psto= con.prepareStatement(queryy);
    psto.setString(1, lblname.getText());
     psto.setString(2, lblacc.getText());
     SimpleDateFormat sdfaa= new SimpleDateFormat("yyyy-MM-dd");
    String datee=sdfaa.format(lbldate.getDate());
     psto.setString(3,datee);
    psto.setString(4, lblusername.getText());
    psto.setString(5, lbl_loan_amount.getText());
    psto.setString(6, lbl_loan_interest.getText());
    psto.setString(7, lbl_time_period.getText());
float abcd= Float.parseFloat(lbl_loan_amount.getText())/Float.parseFloat(lbl_time_period.getText());
String monthly= Float.toString(abcd);
psto.setString(8, monthly); 
    psto.setString(9, lbl_loan_amount.getText());
    float in=Float.parseFloat(lbl_loan_interest.getText())/100;
    float abc= in/12;
    float month= Float.parseFloat(lbl_loan_amount.getText())*abc;
    String monthh=Float.toString(month);
    psto.setString(10, monthh); 
    psto.setString(11, "0");
    psto.setFloat(12,0);
                               String oldDate=datee;
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
                                psto.setString(13, newDate);
                             //  lbl_next_ins_date.setText(newDate);
   
                             
    
     psto.executeUpdate();
     
   //insert into loan server
      String queryyy="insert into loan_server(name,account_number,date,initial_amount,installment_amount,interest_amount,installment_number,fine,remaining_amount) VALUES (?,?,?,?,?,?,?,?,?)";
          PreparedStatement pstoo= con.prepareStatement(queryyy); 
          pstoo.setString(1, lblname.getText());
          pstoo.setString(2, lblacc.getText());
     SimpleDateFormat sdfaaa= new SimpleDateFormat("yyyy-MM-dd");
    String dateee=sdfaaa.format(lbldate.getDate());
     pstoo.setString(3,dateee);
     pstoo.setString(4, lbl_loan_amount.getText());
     float a=0;
     pstoo.setFloat(5,a);
     float b=0;
     pstoo.setFloat(6,b);
    int innum=0;
     pstoo.setInt(7,innum);
     float fine=0;
     pstoo.setFloat(8,fine);
     pstoo.setString(9,lbl_loan_amount.getText());
     pstoo.executeUpdate();
     
     //insert into loan history
    String queryyyy="insert into loan_history(name,account_number,datee,username,loan_amount,interest_rate,time_period,monthly_amount,remaining_loan,interest_amount,installment,fine,installment_date,next_installment_date,status,deposited) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
     PreparedStatement pstooa= con.prepareStatement(queryyyy);
    pstooa.setString(1, lblname.getText());
     pstooa.setString(2, lblacc.getText());
     SimpleDateFormat sdfaaaa= new SimpleDateFormat("yyyy-MM-dd");
    String dateeee=sdfaaaa.format(lbldate.getDate());
     pstooa.setString(3,dateeee);
    pstooa.setString(4, lblusername.getText());
    pstooa.setString(5, lbl_loan_amount.getText());
    pstooa.setString(6, lbl_loan_interest.getText());
    pstooa.setString(7, lbl_time_period.getText());
float abcde= Float.parseFloat(lbl_loan_amount.getText())/Float.parseFloat(lbl_time_period.getText());
String monthlyy= Float.toString(abcde);
pstooa.setString(8, monthlyy); 
    pstooa.setString(9, lbl_loan_amount.getText());
    float ina=Float.parseFloat(lbl_loan_interest.getText())/100;
    float abdc= ina/12;
    float montho= Float.parseFloat(lbl_loan_amount.getText())*abdc;
    String monthha=Float.toString(montho);
    pstooa.setString(10, monthha); 
    pstooa.setString(11, "0");
    pstooa.setFloat(12,0);
     String oldDatea=datee;
                               SimpleDateFormat sdfua=new SimpleDateFormat("yyyy-MM-dd");
                               Calendar cc = Calendar.getInstance();
                               try{
                                   cc.setTime(sdfua.parse(oldDatea));
                               }
                               catch(ParseException e){
                                   e.printStackTrace();
                                  
                               }
                               cc.add(Calendar.DAY_OF_MONTH, 30);  
                               String newDatea = sdfua.format(cc.getTime());  
                                pstooa.setString(13, newDatea);
                             //  lbl_next_ins_date.setText(newDate);
                             pstooa.setString(14,"initial");
                             pstooa.setString(15,"LOAN WITHDRAWAL");
                             pstooa.setString(16,"LOAN WITHDRAWAL");
    
     pstooa.executeUpdate();
     
     
     
            JOptionPane.showMessageDialog(null, "Registered To Loan Account Successfully");
    lblbranch.setSelectedItem(0);
 lbldate.setDate(null);
                 buttonGroup1.clearSelection();
                 buttonGroup2.clearSelection();
                 buttonGroup3.clearSelection();    
                 lblacc.setText("");
lblname.setText("");
lblad.setDate(null);
lblfather.setText("");
 lblmother.setText("");
lblgfather.setText("");
lblgmother.setText("");
lblhw.setText("");
lblnationality.setText("");
lblpaddress.setText("");
lbltaddress.setText("");
lbloccupation.setText("");
lbleducation.setText("");
lbloname.setText("");
lbloaddress.setText("");
lbloemail.setText("");
lblmo1.setText("");
lblmo2.setText("");
lbllandline.setText("");
lblemail.setText("");
lblcitizenship.setText("");
lblpassport.setText("");
lblusername.setText("");
lbl_morgage.setSelectedItem(0);lbl_morgage1.setText("");lbl_loan_amount.setText("");lbl_loan_interest.setText("");lbl_time_period.setText("");
      }
      
     catch(Exception e){
            JOptionPane.showMessageDialog(null, "Credentials not Filled!");
        } 
            }
}
             catch(Exception ee){
            JOptionPane.showMessageDialog(null, ee);
                     }
            
        
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
            java.util.logging.Logger.getLogger(new_loan_form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(new_loan_form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(new_loan_form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(new_loan_form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new new_loan_form().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JButton jButton1;
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
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField lbl_loan_amount;
    private javax.swing.JTextField lbl_loan_interest;
    private javax.swing.JComboBox<String> lbl_morgage;
    private javax.swing.JTextField lbl_morgage1;
    private javax.swing.JTextField lbl_time_period;
    private javax.swing.JTextField lblacc;
    private com.toedter.calendar.JDateChooser lblad;
    private javax.swing.JComboBox<String> lblbranch;
    private javax.swing.JTextField lblcitizenship;
    private com.toedter.calendar.JDateChooser lbldate;
    private javax.swing.JTextField lbleducation;
    private javax.swing.JTextField lblemail;
    private javax.swing.JTextField lblfather;
    private javax.swing.JTextField lblgfather;
    private javax.swing.JTextField lblgmother;
    private javax.swing.JTextField lblhw;
    private javax.swing.JTextField lbllandline;
    private javax.swing.JTextField lblmo1;
    private javax.swing.JTextField lblmo2;
    private javax.swing.JTextField lblmother;
    private javax.swing.JTextField lblname;
    private javax.swing.JTextField lblnationality;
    private javax.swing.JTextField lbloaddress;
    private javax.swing.JTextField lbloccupation;
    private javax.swing.JTextField lbloemail;
    private javax.swing.JTextField lbloname;
    private javax.swing.JTextField lblpaddress;
    private javax.swing.JTextField lblpassport;
    private javax.swing.JTextField lblsearch;
    private javax.swing.JTextField lblsearch1;
    private javax.swing.JTextField lbltaddress;
    private javax.swing.JTextField lblusername;
    private javax.swing.JRadioButton rfemale;
    private javax.swing.JRadioButton rmale;
    private javax.swing.JRadioButton rmarried;
    private javax.swing.JRadioButton rmr;
    private javax.swing.JRadioButton rmrs;
    private javax.swing.JRadioButton rms;
    private javax.swing.JRadioButton rother2;
    private javax.swing.JRadioButton rsingle;
    // End of variables declaration//GEN-END:variables
}
