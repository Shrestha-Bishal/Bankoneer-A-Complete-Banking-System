<br><title>
	B-Payment/Nepal's Online Payment Portal

</title>
  <p><a href="../core/user.php"><img src="../images/iconb.png" alt="Bankoneer" style="width="100" height="40"></a>Bankoneer: Co-Operative Banking Pioneer Software </p> 
<p><marquee>Transfer B-Payment Balance to your BANKONEER Wallet</marquee></p>
<?php
// session_start();
 $random_hash ="";
 $userid= "";
$cash= "";
 $password_1 = "";
 $password_2 = "";
 $diffrernce ="";
 $errors = array();
 include('../registration/server.php');
 $acco=$_SESSION['account_no'];
$connection=odbc_connect('SQLServerr', 'sa', 'bishal');


 if (isset($_POST['register'])) {
 	$userid = addslashes($_POST['userid']);
    $cash = addslashes($_POST['cash']); 
 	$password_1 = addslashes($_POST['password_1']);
 	$password_2 = addslashes($_POST['password_2']);
 	if(empty($userid)) {
 		array_push($errors, "Bankoneer Username is required");
 	}
 	if(empty($cash)) {
 		array_push($errors, "Transfer Amount is required");
 	}
 	 	if(empty($password_1)) {
 		array_push($errors, "Password is required");
 	}

 	if ($password_1 != $password_2) {
 		array_push($errors, "The two password donot match"); 
 	}
 	if (count($errors) == 0) {
$query = "SELECT * FROM  customer_account WHERE username='$userid' ";
 		$rs=odbc_exec($connection, $query);
 		if(odbc_fetch_row($rs)==1){
//if user is found give usear a token and decrease the amount from his wallet
 /* $random_hash = substr(md5(uniqid(rand(), true)), 16, 16);
  $ecash_status="Paid";
  $airtras="Not_Received";
     $date = date('Y-m-d '); 
date_default_timezone_set("Asia/Kathmandu");
$time = date('H:i:s');
$reserved = "Booked";
 $sql = "INSERT INTO ecash_confirmation (userid, amount, paymentid,ecash_status,datee,timee, airtra_status) VALUES ('$userid', '$cash', '$random_hash', '$ecash_status', '$date', '$time', '$airtras')";
 		mysqli_query($db, $sql);
 echo("Please Copy the Confirmation Code and paste in the booking section for confirmation validation: &nbsp;" );
echo "$random_hash";*/
/////////////////////////////
$query2="SELECT * FROM B_Payment_database WHERE password='$password_1'";
$ras=odbc_exec($connection, $query2);
if(odbc_fetch_row($ras)==1){
$_SESSION['username'] = $userid;

//update balance to ecash
//$query = "SELECT *FROM B_Payment_database WHERE userid='$userid'";
//$result = odbc_exec($connection, $query);
//$ress=odbc_num_rows($result);
//$row = odbc_fetch_array($result);
// $diduct = $row['balance'] - $cash;
 //  $sql = "UPDATE B_Payment_database SET balance='$diduct' WHERE userid='$userid' ";
 // $result = odbc_exec($connection, $sql);

  $query1 = "SELECT *FROM customer_account WHERE userid='$userid'";
  $result = odbc_exec($connection, $query);
  $ress=odbc_num_rows($result);
$row = odbc_fetch_array($result);
  $add=$row['wallet_balance']+$cash;
    $sqla = "UPDATE customer_account SET wallet_balance='$add' WHERE username='$userid' ";
  $resulta = odbc_exec($connection, $sqla); 
  //insert to transaction history database
$date = date('Y-m-d '); 
date_default_timezone_set("Asia/Kathmandu");
$time = date('H:i:s');
 $day_time=date("D F j h:i:s A Y");
 //echo $day_time;
$status="TRANSFERRED FROM B-PAYMENT";
$type="E-Banking";
      $query3="INSERT INTO transaction_history (date_time,account_no,status,amount,wallet_balance,type) values ('$day_time','$acco','$status','$cash','$add','$type')";
        $resulta = odbc_exec($connection, $query3); 
  $userid="";
  $cash="";
  $password_1="";
  $password_2="";
  array_push($errors, "Amount Transfer Complete");
  echo "<script>setTimeout(\"location.href= '../core/user.php';\",2000);</script>";


   }
 		 		else{
 			array_push($errors, "wrong user id/password combination");
 		} 
 	}
 	else{
 			array_push($errors, "BANKONEER UserID Not found!");
 		} 
}
 	}
 ?>



<!DOCTYPE html>
<html>
<head>

    <link rel="stylesheet" type="text/css" href="../css/style.css">
</head>
<body>
	<div class="header">
		<h2>B-Payment</h2>
	</div>

	<form method="post" action="Bpayment.php">
		<!-- display validation errors here -->
		<?php include('../registration/errors.php'); ?>
		<div class="input-group">
			<input type="text" name="userid" placeholder="Bankoneer Username" style="height:35px" size="36" value="<?php echo $userid; ?>">
		</div>
				<div class="input-group">
			
			<input type="Number" name="cash" placeholder="Transfer Amount" style="height:35px" size="36" value="<?php echo $cash; ?>">
		</div>
						<div class="input-group">
			
			<input type="password" name="password_1" placeholder="B-Payment Password">
		</div>
		<div class="input-group">
			
			<input type="password" name="password_2" placeholder="Confirm Password">
		</div>
		<div class="input-group">
			<button type="submit" name="register" class="btn">Transfer</button>
		</div>

	</form>

</body>
</html>

<style>
 body{
    background-image: url("../images/ecash.jpg");

      background-size: 450px 400px;
    background-repeat: repeat;

    }
</style>

<style>p.sspace{ padding-left:15cm}
  img.sspace{ padding-left:16cm} </style>
  <p>------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------</p>
  <p class="sspace">Our Online Payment Partners:</p>
<img class="sspace" src="../images/logo.png"/ width="150" height="100" alt="Bankoneer" title="Bankoneer: Co-Operative Banking System Software with Online Banking"><br> 


<footer>B-Payment/Nepal's Online Payment Portal<p>Copyright: 2018</p></footer>



