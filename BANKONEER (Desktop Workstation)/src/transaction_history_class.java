/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Bishal Shrestha
 */
public class transaction_history_class {
    private int sno;
    private String date_time,status,type,amount,account_no,total_balance,wallet_balance;

    

public transaction_history_class(int sno, String date_time, String account_no, String status, String type, String amount,String total_balance,String wallet_balance){
this.sno=sno;
this.account_no=account_no;
this.status=status;
this.date_time=date_time;
        this.type=type;
        this.amount=amount;
        this.total_balance=total_balance;
        this.wallet_balance=wallet_balance;

}
public int getsno(){
    return sno;
} 
public String getaccount_no(){
    return account_no;
} 
public String getdate_time(){
    return date_time;
}
public String getstatus(){
    return status;
} 
public String gettype(){
    return type;
} 
public String getamount(){
    return amount;
} 
public String gettotal_balance(){
    return total_balance;
}
public String getwallet_balance(){
    return wallet_balance;
}

}