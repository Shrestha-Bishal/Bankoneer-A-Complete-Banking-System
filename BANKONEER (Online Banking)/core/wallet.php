<?php
include ('../header.php');
include('../registration/server.php');
$username=$_SESSION['username'];
$acco=$_SESSION['account_no'];
//echo $username;
//echo $acco;
?>
<p><a href="user.php"><img src="../images/iconb.png" alt="Bankoneer" style="width="100" height="50"></a> Bankoneer: Co-Operative Banking Pioneer Software </p>
<p>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			Welcome: <strong><?php echo $_SESSION["username"]; ?></strong>
			<a href="../registration/login.php?logout='1'" style="color: red;"><button style="color: Red">Logout</button></a>
		</p>
		<p style="padding-left: 20cm">| Acccount Balance .: 
			<?php $user=$_SESSION['username'];
		$sql = "SELECT total_balance FROM customer_account WHERE username='$user'";
$result = odbc_exec($connection, $sql);
$row = odbc_fetch_array($result);echo $row['total_balance'];?>

			| Wallet Balance:<img src="../images/wallet.jpg"  title="Your Wallet" alt="Your Wallet" height="32" width="42">NRS.: <?php
		$user=$_SESSION['username'];
		$sql = "SELECT wallet_balance FROM customer_account WHERE username='$user'";
$result = odbc_exec($connection, $sql);
$row = odbc_fetch_array($result);
echo $row['wallet_balance'];?>
|
</p>
		<br>




<!--load wallet codes-->
<br>
<p><marquee>Load balance to and from you account/wallet and also send to another BANKONEER Account.</marquee></p>
<?php
 $random_hash ="";
 $userid= "";
$cash= "";
$bankoneeracc="";
 $password_1 = "";
 $password_2 = "";
 $diffrernce ="";
 $errors = array();
$connection=odbc_connect('SQLServerr', 'sa', 'bishal');


 if (isset($_POST['loadacc'])) {
    $cash = addslashes($_POST['cash']); 
 	$password_1 = addslashes($_POST['password_1']);
 	$password_2 = addslashes($_POST['password_2']);

 	if(empty($cash)) {
 		array_push($errors, "Transfer Amount is required");
 	}
 	 	if(empty($password_1)) {
 		array_push($errors, "Transaction Password is required");
 	}

 	if ($password_1 != $password_2) {
 		array_push($errors, "The two password donot match"); 
 	}
 	if (count($errors) == 0) {
 	$query2="SELECT * FROM newmemberregistration WHERE username='$username' AND accountnumber='$acco' AND transaction_password='$password_1'";
$ras=odbc_exec($connection, $query2);
if(odbc_fetch_row($ras)==1){	
$query = "SELECT * FROM  customer_account WHERE username='$username' AND account_no='$acco' ";
 		$rs=odbc_exec($connection, $query);	
 			$ress=odbc_num_rows($rs);
 		 			$row = odbc_fetch_array($rs);	
 		 			if ($row['wallet_balance']>0 & $cash>0 & $cash<=$row['wallet_balance']){  //
 			$la=$row['total_balance']+$cash;
 			$lw=$row['wallet_balance']-$cash;
 			$sqla = "UPDATE customer_account SET total_balance='$la', wallet_balance='$lw' WHERE username='$username' AND account_no='$acco' ";
  $resulta = odbc_exec($connection, $sqla); 
  
  //insert to transaction history database
$date = date('Y-m-d '); 
date_default_timezone_set("Asia/Kathmandu");
$time = date('H:i:s');
 $day_time=date("D F j h:i:s A Y");
 //echo $day_time;
$status="A & W : LOADED To Account Balance";
$type="E-Banking";
      $query3="INSERT INTO transaction_history (date_time,account_no,status,amount,total_balance,wallet_balance,type) values ('$day_time','$acco','$status','$cash','$la','$lw','$type')";
        $resulta = odbc_exec($connection, $query3); 
  $userid="";
  $cash="";
  $password_1="";
  $password_2="";
 

   array_push($errors, "Amount Transfer Complete");	 	
     echo "<script>setTimeout(\"location.href= '../core/user.php';\",2000);</script>";	
}

else{ array_push($errors, "Insufficient amount"); }

}

else{
	array_push($errors, "Invalid Transaction Password");
}

}
 	}

//account to wallet

 if (isset($_POST['loadwall'])) {
    $cash = addslashes($_POST['cash']); 
 	$password_1 = addslashes($_POST['password_1']);
 	$password_2 = addslashes($_POST['password_2']);

 	if(empty($cash)) {
 		array_push($errors, "Transfer Amount is required");
 	}
 	 	if(empty($password_1)) {
 		array_push($errors, "Transaction Password is required");
 	}

 	if ($password_1 != $password_2) {
 		array_push($errors, "The two password donot match"); 
 	}
 	if (count($errors) == 0) {
 	$query2="SELECT * FROM newmemberregistration WHERE username='$username' AND accountnumber='$acco' AND transaction_password='$password_1'";
$ras=odbc_exec($connection, $query2);
if(odbc_fetch_row($ras)==1){	
$query = "SELECT * FROM  customer_account WHERE username='$username' AND account_no='$acco' ";
 		$rs=odbc_exec($connection, $query);	
 			$ress=odbc_num_rows($rs);
 		 			$row = odbc_fetch_array($rs);	
 		 			if ($row['total_balance']>0 & $cash>0 & $cash<=$row['total_balance']){  //
 			$la=$row['total_balance']-$cash;
 			$lw=$row['wallet_balance']+$cash;
 			$sqla = "UPDATE customer_account SET total_balance='$la', wallet_balance='$lw' WHERE username='$username' AND account_no='$acco' ";
  $resulta = odbc_exec($connection, $sqla); 
  
  //insert to transaction history database
$date = date('Y-m-d '); 
date_default_timezone_set("Asia/Kathmandu");
$time = date('H:i:s');
 $day_time=date("D F j h:i:s A Y");
 //echo $day_time;
$status="A & W : LOADED To Wallet Balance";
$type="E-Banking";
      $query3="INSERT INTO transaction_history (date_time,account_no,status,amount,total_balance,wallet_balance,type) values ('$day_time','$acco','$status','$cash','$la','$lw','$type')";
        $resulta = odbc_exec($connection, $query3); 
  $userid="";
  $cash="";
  $password_1="";
  $password_2="";
 

   array_push($errors, "Amount Transfer Complete");	 	
     echo "<script>setTimeout(\"location.href= '../core/user.php';\",2000);</script>";	
}//

else{ array_push($errors, "Insufficient amount"); }

}


else{
	array_push($errors, "Invalid Transaction Password");
}

}
 	}

//transfer balance to another bankoneer wallet
 	 if (isset($_POST['transferblc'])) {
    $cash = addslashes($_POST['cash']); 
 	$password_1 = addslashes($_POST['password_1']);
 	$password_2 = addslashes($_POST['password_2']);
 	$bankoneeracc=addslashes($_POST['bankoneeracc']);

 	if(empty($cash)) {
 		array_push($errors, "Transfer Amount is required");
 	}
 	 	if(empty($password_1)) {
 		array_push($errors, "Transaction Password is required");
 	}
 	 	 	if(empty($bankoneeracc)) {
 		array_push($errors, "Bankoneer ID is required");
 	}

 	if ($password_1 != $password_2) {
 		array_push($errors, "The two password donot match"); 
 	}
 	if (count($errors) == 0) {/////////
 	$query2="SELECT * FROM newmemberregistration WHERE username='$username' AND accountnumber='$acco' AND transaction_password='$password_1'";
$ras=odbc_exec($connection, $query2);
if(odbc_fetch_row($ras)==1){
$query3="SELECT * FROM newmemberregistration WHERE username='$bankoneeracc'";
$rast=odbc_exec($connection, $query3);
if(odbc_fetch_row($rast)==1){

//echo "done";
// code start form here
$query = "SELECT * FROM  customer_account WHERE username='$username' AND account_no='$acco' ";
$rs=odbc_exec($connection, $query);
$ress=odbc_num_rows($rs);
$row = odbc_fetch_array($rs);	
if ($row['wallet_balance']>0 & $cash>0 & $cash<=$row['wallet_balance']){
	if($username!=$bankoneeracc){
$las=$row['wallet_balance']-$cash;
$sqla = "UPDATE customer_account SET  wallet_balance='$las' WHERE username='$username' AND account_no='$acco' ";
$resulta = odbc_exec($connection, $sqla);

$queryrr = "SELECT wallet_balance FROM customer_account WHERE username='$bankoneeracc' ";
$rsss=odbc_exec($connection, $queryrr);
$reses=odbc_num_rows($rsss);
$rowss = odbc_fetch_array($rsss);
//if(odbc_fetch_row($rsss)==1){
$lassup=$rowss['wallet_balance']+$cash;
$sqlrss="UPDATE customer_account SET wallet_balance='$lassup' WHERE username='$bankoneeracc'";
$resultttt=odbc_exec($connection, $sqlrss);

//insert to transaction history database
$date = date('Y-m-d '); 
date_default_timezone_set("Asia/Kathmandu");
$time = date('H:i:s');
 $day_time=date("D F j h:i:s A Y");
 //echo $day_time;
$status="TRANSFERRED BALANCE TO |".$bankoneeracc."|";
$type="E-Banking";
      $query3="INSERT INTO transaction_history (date_time,account_no,status,amount,wallet_balance,type) values ('$day_time','$acco','$status','$cash','$las','$type')";
        $resulta = odbc_exec($connection, $query3); 

$statusss="TRANSFERRED BALANCE BY |".$username."|";
         $query4="INSERT INTO transaction_history (date_time,status,amount,wallet_balance,type,too) values ('$day_time','$statusss','$cash','$lassup','$type','$bankoneeracc')";
        $resultass = odbc_exec($connection, $query4); 
  $userid="";
  $cash="";
  $password_1="";
  $password_2="";



   array_push($errors, "Amount Transfer Complete");	 	
     echo "<script>setTimeout(\"location.href= '../core/user.php';\",2000);</script>";	
//}
//else{
//	array_push($errors, "Cannot Transfer Balance");
//}
}
else{
	array_push($errors, "Transfer Amount cannot be initiated to OWN ACCOUNT!");
}
}
else{
	array_push($errors," Invalid Amount Denominations");
}

//////code upto here
}
   else{
   	array_push($errors, "Invalid Bankoneer ID");
   }

}


else{
	array_push($errors, "Invalid Transaction Password");
}

}//////////
 	}

 ?>



<!DOCTYPE html>
<html>
<head>

    <link rel="stylesheet" type="text/css" href="../css/style.css">
</head>
<body>
	<div class="header">
		<h2>A & W</h2>
	</div>

	<form method="post" action="wallet.php">
		<!-- display validation errors here -->
		<?php include('../registration/errors.php'); ?>
						<div class="input-group">
			
			<input type="Number" name="cash" placeholder="Transfer Amount" style="height:35px" size="36" value="<?php echo $cash; ?>">
		</div>
						<div class="input-group">
			
			<input type="password" name="password_1" placeholder="Transaction Password">
		</div>
		<div class="input-group">
			
			<input type="password" name="password_2" placeholder="Confirm Password">
		</div>
		<div class="input-group">
			<button type="submit" name="loadacc" class="btn">Load Wallet Balance to Account Balance</button>
			
		</div>
		<div class="input-group">
		<button type="submit" name="loadwall" class="btn">Load Account Balance to Wallet</button>
</div>
<div class="input-group">
			
			<input type="text" name="bankoneeracc" placeholder="Bankoneer ID" style="height:35px" size="36" value="<?php echo $bankoneeracc; ?>">
		</div>
		<div class="input-group">
		<button type="submit" name="transferblc" class="btn">Transfer Balance</button>
</div>
	</form>

</body>
</html>


<p><strong>What is Bankoneer Wallet?</strong>
<br>BANKONEER Wallet is a static amount of money that can be used for the following terms: <br>
A & W refers to ACCOUNT to WALLET or WALLET to ACCOUNT <br>
1. Third Party Transfer: To and From amount transfer from our partnered Banks, Co-Operative Banks & Online Payment Partners.<br>
2. You can load your Wallet Money to your account and also can load to wallet from your account. (A & W)<br>
3. Send money to another BANKONEER Account using Bankoneer ID.<br>
4. Deposit to your savings online.<br>
5. Pay Loan amount and many other services provided online.<br>
6. Safe and ready in need. <br>
</p>
<?php
include ('../footer.php');
?>