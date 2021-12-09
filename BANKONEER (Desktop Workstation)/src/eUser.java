/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Bishal Shrestha
 */
class eUser {
    private int sno;
    private String  branch, date, name, accounttype,title
            ,gender,maritial,dob,father, mother, gfather,gmother,hw,nationality,paddress,
taddress,
occupation,
education,
oname,
oaddress,
oemail,
mno,
mnoo,
landline,
email,
citizenshipno,
documentno;    
private byte[] image,signature,citizenshipimage,documentimage;    
    //,sign,citizenshipimage; 
    //constructor
    public eUser(int sno, String branch, String date, String accounttype, String title, String name,String gender,
     String maritial,String dob,String father,String mother,String gfather,String gmother,String hw,String nationality,String paddress,String taddress,String occupation,String education,String oname,String oaddress,
             String oemail, String mno,String mnoo,String landline,String email,String citizenshipno,String documentno, 
             byte[] image,byte[] signature, byte[] citizenshipimage, byte[] documentimage){
        this.sno= sno;
       this.branch=branch;
        this.date=date;
        this.accounttype=accounttype;
        this.title=title;
        this.name=name;
        this.gender=gender;
       this.maritial=maritial;this.dob=dob;
this.father=father;
this.mother=mother;
this.gfather=gfather;
this.gmother=gmother;
this.hw=hw;this.nationality= nationality;this.paddress=paddress;
            this.taddress=taddress;this.occupation=occupation;this.education=education;this.oname=oname;
this.oaddress=oaddress;this.oemail=oemail;
this.mno=mno;this.mnoo=mnoo;this.landline=landline;this.email=email;
this.citizenshipno=citizenshipno;this.documentno=documentno;
this.image=image;         
        this.signature=signature;
        this.citizenshipimage=citizenshipimage;
        this.documentimage=documentimage;
        
            }
    public int getsno(){
        return sno;
    }    public String getbranch(){
    return branch;
     }        public String getdate(){
        return date;
    }        public String getaccounttype(){
            return accounttype;
        }         public String gettitle(){
            return title;
        }
        public String getname(){
            return  name;
        }public String getgender(){
            return gender;
        }public String getmaritial(){
            return maritial;
        }public String getdob(){
            return dob;
        }            public String getfather(){
        return father;
    }        public String getmother(){
        return mother;
    }            public String getgfather(){
        return gfather;
    }        public String getgmother(){
        return gmother;
    }        public String gethw(){
        return hw;
    }  public String getnationality(){
            return nationality;
        }  public String getpaddress(){
            return paddress;
        }public String gettaddress(){
            return taddress;
        }public String getoccupation(){
            return occupation;
        }public String geteducation(){
            return education;
        }public String getoname(){
            return oname;
        }public String getoaddress(){
            return oaddress;
        }public String getoemail(){
            return oemail;
        }public String getmno(){
            return mno;
        }public String getmnoo(){
            return mnoo;
        }public String getlandline(){
            return landline;}
        public String getemail(){
            return email;}
        public String getcitizenshipno(){
            return citizenshipno;}
        public String getdocumentno(){
            return documentno;
        }
        public byte[] getimage(){
            return image;
        }

        public byte[] getsignature(){
            return signature;
        }       
                public byte[] getcitizenshipimage(){
            return citizenshipimage;
        }
                            public byte[] getdocumentimage(){
            return documentimage;
        }    

}
