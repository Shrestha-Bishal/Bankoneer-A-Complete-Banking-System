/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Bishal Shrestha
 */
public class view_customers_details {
    private int sno;
    private String branch, date,department,accounttype,individual,accountnumber, name, dob, father, mother, taddress, mno, email, citizenship, username, password ;
    private String title,gender,maritial,nationality,gfather,gmother,hw,paddress,occupation,education,oname,oaddress;
    private String oemail,mnoo,landline,documentno,transaction_password;
    private byte[] image,signature,citizenshipimage,documentimage; 
     public view_customers_details(int sno, String branch, String date, String accounttype,String individual,
             String accountnumber,String title, String name,String gender,String maritial,
              String dob, String father,String mother,String gfather,String gmother,
              String hw,String nationality,String paddress,String taddress,
              String occupation, String education,String oname, String oaddress, String oemail,
              String mno,String mnoo, String landline, String email, String citizenship,String documentno,
                byte[] image, byte[] signature,byte[] citizenshipimage,byte[] documentimage,String username, String password, 
                String transaction_password){
   this.sno= sno;
   this.branch=branch;
    this.date=date;
    this.accounttype=accounttype;
    this.individual=individual;
    this.accountnumber=accountnumber;
   this.title=title;this.name=name;
             this.gender=gender;this.maritial=maritial;this.dob=dob;this.father=father;this.mother=mother;
             this.gfather=gfather;this.gmother=gmother;this.hw=hw;this.nationality=nationality;
                 this.paddress=paddress;this.taddress=taddress; this.occupation=occupation;this.education=education;   
                   this.oname=oname;this.oaddress=oaddress;this.oemail=oemail;
                     this.mno=mno;this.mnoo=mnoo; this.landline=landline;this.email=email; this.citizenship=citizenship; 
                        this.documentno=documentno; this.image=image;this.signature=signature;this.citizenshipimage=citizenshipimage;
                        this.documentimage=documentimage;this.username=username;this.password =password;this.transaction_password =transaction_password;
     }
         public int getsno(){
        return sno;
    }        public String getbranch(){
        return branch;
    }        public String getdate(){
        return date;
    }
         public String getaccounttype(){
        return accounttype;
    }     public String getindividual(){
        return individual;
    }   public String getaccountnumber(){
        return accountnumber;
    }     public String gettitle(){
        return title;
    }                        public String getname(){
        return name;
    }                    public String getgender(){
        return gender;
    }   
        public String getmaritial(){
        return maritial;
    }                        public String getdob(){
        return dob;
    }public String getgfather(){
        return gfather;
    } 
                                    public String getgmother(){
        return gmother;
    } public String getfather(){
        return father;
    }        public String getmother(){
        return mother;
    }                                            public String gethw(){
        return hw;
    }            public String getnationality(){
        return nationality;
    }        public String getpaddress(){
        return paddress;
    }        public String gettaddress(){
        return taddress;
    }                    public String getoccupation(){
        return occupation;
    }                    public String geteducation(){
        return education;
    }                    public String getoname(){
        return oname;
    }public String getoaddress(){
        return oaddress;
    }public String getoemail(){
        return oemail;
    }                          public String getmno(){
        return mno;
    }              public String getmnoo(){
        return mnoo;
    }public String getlandline(){
        return landline;
    }       public String getemail(){
        return email;
    }public String getcitizenship(){
        return citizenship;
    }public String getdocumentno(){
        return documentno;
    }
    public byte[] getimage(){
            return image;
        }
    public byte[] getsignature(){
            return signature;
        } public byte[] getcitizenshipimage(){
            return citizenshipimage;
        }
         public byte[] getdocumentimage(){
            return documentimage;
        }                        public String getusername(){
        return username;
    }        public String getpassword(){
        return password;
    }public String gettransaction_password(){
        return transaction_password;
    }
              
  
}
