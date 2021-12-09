
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
public class edit_customers_details extends javax.swing.JFrame {
 DefaultTableModel dm;
    /**
     * Creates new form edit_customers_details
     */
    public edit_customers_details() {
        initComponents();
         showall_user();
       // this.image=null;
  // this.signature=null;
  // this.citizenshipimage=null;
  // this.documentimage=null;
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        lblsearch1 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        lblbranch = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        lblacc = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        lblname = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        lbldate = new com.toedter.calendar.JDateChooser();
        lblhw = new javax.swing.JTextField();
        lblgmother = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        rmarried = new javax.swing.JRadioButton();
        lblgfather = new javax.swing.JTextField();
        rsingle = new javax.swing.JRadioButton();
        jLabel24 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        lblad = new com.toedter.calendar.JDateChooser();
        lblmother = new javax.swing.JTextField();
        lbltaddress = new javax.swing.JTextField();
        lbloemail = new javax.swing.JTextField();
        lbloaddress = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        lblemail = new javax.swing.JTextField();
        lbllandline = new javax.swing.JTextField();
        lblpassport = new javax.swing.JTextField();
        lbltrans = new javax.swing.JTextField();
        lblmo2 = new javax.swing.JTextField();
        lbloname = new javax.swing.JTextField();
        lblpassword1 = new javax.swing.JTextField();
        lblusername = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        lblcitizenship = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        lblmo1 = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        lbleducation = new javax.swing.JTextField();
        jLabel41 = new javax.swing.JLabel();
        lbloccupation = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        lblnationality = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        lblpaddress = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        rother2 = new javax.swing.JRadioButton();
        rfemale = new javax.swing.JRadioButton();
        rmale = new javax.swing.JRadioButton();
        jLabel9 = new javax.swing.JLabel();
        lblfather = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        rmr = new javax.swing.JRadioButton();
        rms = new javax.swing.JRadioButton();
        rmrs = new javax.swing.JRadioButton();
        btnupdate = new javax.swing.JButton();
        btndelete = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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

        jLabel5.setText("Branch:");

        jLabel6.setText("Account Number:");

        jLabel8.setText("Full Name:");

        jLabel2.setText("Date:");

        lbldate.setDateFormatString("yyyy-MM-dd");

        jLabel17.setText("Grand Mother's Name:");

        buttonGroup3.add(rmarried);
        rmarried.setText("Married");

        buttonGroup3.add(rsingle);
        rsingle.setText("Single");

        jLabel24.setText("Maritial:");

        jLabel15.setText("Grand Father's Name:");

        jLabel23.setText("(House No./Tole/Ward No./City/Country)");

        lbloname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lblonameActionPerformed(evt);
            }
        });

        jLabel37.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel37.setText("Online Banking:");

        jLabel16.setText("Username:");

        jLabel22.setText("Password:");

        jLabel27.setText("Transaction Password:");

        jLabel36.setText("Document No.");

        jLabel11.setText("Citizenship No.");

        jLabel35.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel35.setText("Identification Document:");

        jLabel32.setText("Office Number:");

        jLabel33.setText("Landline:");

        jLabel28.setText("Address:");

        jLabel21.setText("Temporary Address:");

        jLabel26.setText("Office Name");

        jLabel41.setText("Education:");

        jLabel25.setText("Occupation:");

        jLabel31.setText("Mobile No. 1");

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel30.setText("Contact Information:");

        jLabel10.setText("Nationality:");

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel20.setText("Address Particulars:");

        jLabel19.setText("Permanent Address:");

        jLabel14.setText("Mother's Name:");

        jLabel12.setText("D.O.B.(A.D.)");

        buttonGroup2.add(rother2);
        rother2.setText("Other");

        buttonGroup2.add(rfemale);
        rfemale.setText("Female");

        buttonGroup2.add(rmale);
        rmale.setText("Male");

        jLabel9.setText("Gender:");

        jLabel13.setText("Father's Name:");

        jLabel7.setText("Title:");

        buttonGroup1.add(rmr);
        rmr.setText("Mr.");

        buttonGroup1.add(rms);
        rms.setText("Ms.");

        buttonGroup1.add(rmrs);
        rmrs.setText("Mrs.");

        btnupdate.setText("Update");
        btnupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnupdateActionPerformed(evt);
            }
        });

        btndelete.setForeground(new java.awt.Color(255, 0, 51));
        btndelete.setText("Delete");
        btndelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblbranch, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblacc, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblname, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(169, 169, 169)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbldate, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rmr)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rms)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rmrs)
                        .addGap(75, 75, 75)
                        .addComponent(jLabel9)
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
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblfather, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel14)
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
                .addGap(84, 84, 84)
                .addComponent(lblhw, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
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
                .addGap(80, 80, 80)
                .addComponent(lblemail))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblusername, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel22)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblpassword1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel27)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbltrans, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnupdate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btndelete))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblcitizenship, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(66, 66, 66)
                                .addComponent(jLabel36)
                                .addGap(163, 163, 163)
                                .addComponent(lblpassport, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(557, 557, 557)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblsearch1, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                        .addGap(72, 72, 72)
                        .addComponent(lbloemail, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblsearch1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(lblbranch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6)
                        .addComponent(lblacc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8)
                        .addComponent(lblname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(lbldate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9)
                        .addComponent(rmale)
                        .addComponent(rfemale)
                        .addComponent(rother2)
                        .addComponent(jLabel12)
                        .addComponent(jLabel7)
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
                    .addComponent(jLabel13)
                    .addComponent(lblfather, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(lblmother, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(lblgfather, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17)
                    .addComponent(lblgmother, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    .addComponent(lblemail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel35)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel11)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblcitizenship, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel36)
                                .addComponent(lblpassport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel37)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(jLabel22)
                            .addComponent(jLabel27)
                            .addComponent(lblusername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbltrans, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblpassword1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 22, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnupdate)
                            .addComponent(btndelete))
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int i = jTable1.getSelectedRow();
        TableModel model= jTable1.getModel();
        lblbranch.setText(model.getValueAt(i,1).toString());
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
        lblpassword1.setText(model.getValueAt(i,31).toString());
        lbltrans.setText(model.getValueAt(i,32).toString());

    }//GEN-LAST:event_jTable1MouseClicked

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

    private void lblonameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lblonameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lblonameActionPerformed

    private void btnupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnupdateActionPerformed
 /*       try{
            int opt= JOptionPane.showConfirmDialog(null, "Update Credentials", "Sure to Update?", JOptionPane.YES_NO_OPTION);
            if(opt==0){ //value of yes = 0
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  // load the driver
                String url = "jdbc:sqlserver://localhost:1433;databaseName=bankoneer_db;user=sa;password=bishal";
                Connection con = DriverManager.getConnection(url);
                int row= jTable1.getSelectedRow();
                String value=(jTable1.getModel().getValueAt(row, 5).toString());
                String query1 = "UPDATE newmemberregistration SET branch=?,date=?,accountype=?,individual=?,accountnumber=?,title=?,name=?,gender=?,maritial=?,dob=?,father=?,mother=?,gfather=?,gmother=?,hw=?,nationality=?,paddress=?,taddress=?,occupation=?,education=?,oname=?,oaddress=?,oemail=?,mno=?,mnoo=?,landline=?,email=?,citizenship=?,documentno=?,username=?,password=?,transaction_password=? where sno="+value;//image,signature,citizenshipimage,
                     //   + "branch=?,department=?,name=?,dobad=?,father=?,mother=?,taddress=?,mno=?,email=?,citizenship=?,username=?,password=?,image=?, signature=? where sno="+value;
                PreparedStatement pst= con.prepareStatement(query1);
                pst.setString(1, lblbranch.getText());
                String department;
               // department= codepartment.getSelectedItem().toString();
              //  pst.setString(2, department);
                pst.setString(3, lblname.getText());
                SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
                String date=sdf.format(lblad.getDate());
                pst.setString(4,date);
                pst.setString(5, lblfather.getText());
                pst.setString(6, lblmother.getText());
                pst.setString(7, lbltaddress.getText());
              //  pst.setString(8, lblmno.getText());
                pst.setString(9, lblemail.getText());
                pst.setString(10, lblcitizenship.getText());
                pst.setString(11, lblusername.getText());
             //   pst.setString(12, lblpassword.getText());
                // image=null; sign=null;
                pst.setBytes(13, image);
                pst.setBytes(14, sign);
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "Updated Successfully!");
                DefaultTableModel model=(DefaultTableModel)jTable1.getModel();
                model.setRowCount(0);
                show_user();
            }

        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
*/
    }//GEN-LAST:event_btnupdateActionPerformed

    private void btndeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeleteActionPerformed
        try{
            int opt= JOptionPane.showConfirmDialog(null, "Delete?", "Sure to Delete", JOptionPane.YES_NO_OPTION);
            if(opt==0){ //value of yes = 0
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  // load the driver
                String url = "jdbc:sqlserver://localhost:1433;databaseName=bankoneer_db;user=sa;password=bishal";
                Connection con = DriverManager.getConnection(url);
                int row= jTable1.getSelectedRow();
                String value=(jTable1.getModel().getValueAt(row, 5).toString());
                String query3 = "DELETE from newmemberregistration where accountnumber="+value;
                PreparedStatement staa = con.prepareStatement(query3);
                staa.executeUpdate();
                String query1 = "DELETE from customer_account where account_no="+value;
                PreparedStatement st = con.prepareStatement(query1);
                st.executeUpdate();
                DefaultTableModel model=(DefaultTableModel)jTable1.getModel();
                model.setRowCount(0);
                
                            JOptionPane.showMessageDialog(null, "Account Deleted Successfully");
            
            lblbranch.setText("");
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
//imageapplicant.setText("");
//imagesignature.setText("");
//imagecitizenship.setText("");
lblusername.setText("");
lblpassword1.setText("");
lbltrans.setText("");
                
                
                showall_user();
            }

        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_btndeleteActionPerformed

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
            java.util.logging.Logger.getLogger(edit_customers_details.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(edit_customers_details.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(edit_customers_details.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(edit_customers_details.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new edit_customers_details().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btndelete;
    private javax.swing.JButton btnupdate;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
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
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField lblacc;
    private com.toedter.calendar.JDateChooser lblad;
    private javax.swing.JTextField lblbranch;
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
    private javax.swing.JTextField lblpassword1;
    private javax.swing.JTextField lblsearch1;
    private javax.swing.JTextField lbltaddress;
    private javax.swing.JTextField lbltrans;
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
