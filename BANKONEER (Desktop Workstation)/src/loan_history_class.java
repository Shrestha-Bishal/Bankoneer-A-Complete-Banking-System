/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Bishal Shrestha
 */
public class loan_history_class {
      private int sno;
   private String name,accountnumber, date,username,loan_amount,interest_rate,time_period,
           monthly_amount,remaining_loan,interest_amount,installment,installment_date,next_installment_date,status,deposited;
   private String fine;
   public loan_history_class(String name,String accountnumber,String date,String loan_amount,String interest_rate,
           String time_period,
           String monthly_amount,String remaining_loan,String interest_amount,String installment,String fine,String installment_date,String next_installment_date,String status, String deposited){
       this.sno=sno;
               this.name=name;
               this.accountnumber=accountnumber;
               this.date=date;
              // this.username=username;
               this.loan_amount=loan_amount;
               this.interest_rate=interest_rate;
               this.time_period=time_period;
               this. monthly_amount= monthly_amount;
               this.remaining_loan=remaining_loan;
               this.interest_amount=interest_amount;
               this.installment=installment;
               this.fine=fine;  
               this.installment_date=installment_date;
               this.next_installment_date=next_installment_date;
               this.status=status;
               this.deposited=deposited;
   }
   public int getsno(){
        return sno;
    } 
   public String getname(){
    return name;
     }
   public String getaccountnumber(){
    return accountnumber;
     }
   public String getdate(){
    return date;
     }
   public String getusername(){
    return username;
     }
   public String getloan_amount(){
    return loan_amount;
     }
   public String getinterest_rate(){
    return interest_rate;
     }
   public String gettime_period(){
    return time_period;
     }
      public String getmonthly_amount(){
    return monthly_amount;
     }
         public String getremaining_loan(){
    return remaining_loan;
     }
            public String getinterest_amount(){
    return interest_amount;
     }
                        public String getinstallment(){
    return installment;
     }
                                               public String getfine(){
    return fine;
     }
                                    public String getinstallment_date(){
    return installment_date;
     }
                                                           public String getnext_installment_date(){
    return next_installment_date;
     }
                                                           public String getstatus(){
                                                               return status;
                                                               
                                                           }
                                                           public String getdeposited(){
                                                               return deposited;
                                                           }
}
