/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Bishal
 */
public class IndividualUser {
   private int sno;
    private String branch, total_balance, account_type, accountnumber, name, father, mother, taddress,paddress, mno,citizenship, currency;
    private byte[] image,sign; 
    //constructor
    public IndividualUser(int sno,  String accountnumber, String account_type, String name, String total_balance){
        this.sno= sno;
        this.branch=branch;
        this.accountnumber=accountnumber;
        this.name=name;
        this.account_type=account_type;
                this.taddress=taddress;
                        this.paddress=paddress;
                        this.total_balance=total_balance;
        this.father=father;
        this.mother=mother;
        this.mno=mno;
        this.citizenship=citizenship; 
        this.image=image;
        this.sign=sign;
        this.currency=currency;
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
                        public String getaccount_type(){
                            return account_type;
                        }
                        
                        public String gettotal_balance(){
                            return total_balance;
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
        public String getcurrency(){
            return currency;
        }
 
}
