/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Bishal Shrestha
 */
public class minute_setting_class {
   private int sno,daily_interest,loan_interest; 
   private String date,service_charge,penalty;
   
   public minute_setting_class(int sno,String date,int daily_interest,String service_charge,int loan_interest,String penalty) {
    this.sno=sno;
    this.date=date;
            this.daily_interest=daily_interest;
            this.service_charge=service_charge;
            this.loan_interest=loan_interest;
            this.penalty=penalty;
            
}
 public int getsno(){
    return sno;
}
 public String getdate(){
    return date;
} 
 public int getdaily_interest(){
    return daily_interest;
} 
 public String getservice_charge(){
    return service_charge;
} 
 public int getloan_interest(){
    return loan_interest;
} 
 public String getpenalty(){
    return penalty;
} 
 
}
