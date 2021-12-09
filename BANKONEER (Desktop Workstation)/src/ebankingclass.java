/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Bishal
 */
public class ebankingclass {
  private int sno;
    private String branch, accountnumber, name, father, mother, taddress,paddress, mno,citizenship, username,password;
    private byte[] image,sign; 
    //constructor
    public ebankingclass(int sno, String branch, String accountnumber, String name,String taddress,String paddress,String father,String mother, String mno,String citizenship, byte[] image, byte[] sign, String username, String password){
        this.sno= sno;
        this.branch=branch;
        this.accountnumber=accountnumber;
        this.name=name;
                this.taddress=taddress;
                        this.paddress=paddress;
        this.father=father;
        this.mother=mother;
        this.mno=mno;
        this.citizenship=citizenship; 
        this.image=image;
        this.sign=sign;
        this.username=username;
        this.password=password;
            }
    public int getsno(){
        return sno;
    }    
        public String getbranch(){
        return branch;
    }
        public String getacc(){
        return accountnumber;
    }
                        public String getname(){
        return name;
    }       
        public String gettaddress(){
        return taddress;
    }
                public String getpaddress(){
        return paddress;
    }
            public String getfather(){
        return father;
    }        public String getmother(){
        return mother;
    }

                        public String getmno(){
        return mno;
    }
                        public String getcitizenship(){
        return citizenship;
    }
        public byte[] getimage(){
            return image;
        }
        public byte[] getsign(){
            return sign;
        }     
        public String getusername(){
            return username;
        }  
                public String getpassword(){
            return password;
        }  
}
