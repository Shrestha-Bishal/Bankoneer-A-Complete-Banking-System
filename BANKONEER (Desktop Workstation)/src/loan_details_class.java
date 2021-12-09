/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Bishal Shrestha
 */
public class loan_details_class {
          private int sno;
   private String branch,date,accountnumber,name,
           morgage_type,morgage_number,loan_amount,loan_interest,time_period,citizenship,documentno,
   dob,father,mother,hw,paddress,taddress,mno;
           
   public loan_details_class(String branch,String date,String accountnumber,String name,String dob,
           String father,String mother,String hw,String paddress,String taddress,String mno,String citizenship,String documentno,
           String morgage_type,String morgage_number,String loan_amount,String loan_interest,String time_period){
       this.sno=sno;
       this.branch=branch;
       this.date=date;
                    this.accountnumber=accountnumber;
               this.name=name;
this.dob=dob;
this.father=father;this.mother=mother;this.hw=hw;
this.paddress=paddress;this.taddress=taddress;this.mno=mno;this.citizenship=citizenship;this.documentno=documentno;
              // this.username=username;
              this.morgage_type=morgage_type;
              this.morgage_number=morgage_number;
              this.loan_interest=loan_interest;
               this.loan_amount=loan_amount;
               this.time_period=time_period;

   }
   public int getsno(){
        return sno;
    } 
      public String getbranch(){
    return branch;
     }   public String getdate(){
    return date;
     }   public String getname(){
    return name;
     }    public String getdob(){
    return dob;
     }   public String getfather(){
    return father;
     }   public String getmother(){
    return mother;
     }
   public String gethw(){
    return hw;
     }
   public String getaccountnumber(){
    return accountnumber;
     }
   public String getpaddress(){
    return paddress;
     }
   public String gettaddress(){
    return taddress;
     }
   public String getloan_amount(){
    return loan_amount;
     }
   public String getmno(){
    return mno;
     }
   public String gettime_period(){
    return time_period;
     }
      public String getcitizenship(){
    return citizenship;
     }
         public String getdocumentno(){
    return documentno;
     }
            public String getmorgage_type(){
    return morgage_type;
     }
                        public String getmorgage_number(){
    return morgage_number;
     }
                                              public String getloan_interest(){
    return loan_interest;
     }
                                    
}
