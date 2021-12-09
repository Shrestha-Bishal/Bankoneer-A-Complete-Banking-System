<?php include('../registration/server.php'); ?>
<br><title>
	B-Payment/Nepal's Online Payment Portal
</title>
  <p><a href="../core/user.php"><img src="../images/iconb.png" alt="Bankoneer" style="width="100" height="40"></a> Bankoneer: Co-Operative Banking Pioneer Software </p>
  <p>
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      Welcome: <strong><?php echo $_SESSION["username"]; ?></strong>
      <a href="../registration/login.php?logout='1'" style="color: red;"><button style="color: Red">Logout</button></a>
    </p>
    <style>
      .button{
            background-color: #036C83; /* Green */
    border: none;
    color: white;
    padding: 8px 18px;
    text-align: center;
    text-decoration: bold;
    display: inline-block;
    font-color: white;
    font-size: 9px;
    margin: 4px 2px;
    cursor: pointer;
      }
    </style>
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
<p><marquee>Transfer BANKONEER Wallet Balance to your B-Payment Account</marquee></p>
<?php
$errors=array();
include('../registration/errors.php');
//include('../registration/server.php');
$username=$_SESSION['username'];
$acco=$_SESSION['account_no'];
//echo $acco;
//echo $username;

 $random_hash ="";
 $userid= "";
$cash= "";
 $password_1 = "";
 $password_2 = "";
 $diffrernce ="";
 $date_time="";
 $errors = array();


//$date_time= $date.$time;
//echo $date_time; 
$connection=odbc_connect('SQLServerr', 'sa', 'bishal');


 if (isset($_POST['register'])) {
 	$userid = addslashes($_POST['userid']);
 	//echo $userid;
    $cash = addslashes($_POST['cash']); 
 	$password_1 = addslashes($_POST['password_1']);
 	$password_2 = addslashes($_POST['password_2']);
 	if(empty($userid)) {
 		array_push($errors, "B-Payment Username is required");
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
$query = "SELECT * FROM  B_Payment_database WHERE userid='$userid' ";
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
/////////////////////////////]
//$_SESSION['username'] =$userid;
//echo $username;

$query2="SELECT * FROM newmemberregistration WHERE username='$username' AND transaction_password='$password_1'";//.username='$username' AND
$ras=odbc_exec($connection, $query2);
if(odbc_fetch_row($ras)==1){



//update balance to ecash
//$query = "SELECT *FROM B_Payment_database WHERE userid='$userid'";
//$result = odbc_exec($connection, $query);
//$ress=odbc_num_rows($result);
//$row = odbc_fetch_array($result);
// $diduct = $row['balance'] - $cash;
 //  $sql = "UPDATE B_Payment_database SET balance='$diduct' WHERE userid='$userid' ";
 // $result = odbc_exec($connection, $sql);
if($row['wallet_balance']>0 AND $cash<=$row['wallet_balance']){
  $query1 = "SELECT *FROM customer_account WHERE username='$username'";
  $result = odbc_exec($connection, $query1);
$ress=odbc_num_rows($result);
$row = odbc_fetch_array($result);
  $diduct=$row['wallet_balance']-$cash;
    $sqla = "UPDATE customer_account SET wallet_balance='$diduct' WHERE username='$username' "; 
  $resulta = odbc_exec($connection, $sqla); 
  //insert to transaction history database
$date = date('Y-m-d '); 
date_default_timezone_set("Asia/Kathmandu");
$time = date('H:i:s');
 $day_time=date("D F j h:i:s A Y");
 //echo $day_time;
$status="TRANSFERRED TO B-PAYMENT";
$type="E-Banking";
      $query3="INSERT INTO transaction_history (date_time,account_no,status,amount,wallet_balance,type) values ('$day_time','$acco','$status','$cash','$diduct','$type')";
        $resulta = odbc_exec($connection, $query3); 

  $userid="";
  $cash="";
  $password_1="";
  $password_2="";
  array_push($errors, "Amount Transfer Complete");
  echo "<script>setTimeout(\"location.href= '../core/user.php';\",2000);</script>";
}
else { array_push($errors, "Insufficient Amount");}

   }/////
 		 		else{
 			array_push($errors, "wrong user id/password combination");
 		} 
 	}
 	else{
 			array_push($errors, "B-Payment UserID Not found!");
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
		<h2>Load Fund to B-Payment</h2>
	</div>

	<form method="post" action="load_Bpayment.php">
		<!-- display validation errors here -->
		<?php include('../registration/errors.php'); ?>
		<div class="input-group">
			<input type="text" name="userid" placeholder="B-Payment UserID" style="height:35px" size="36" value="<?php echo $userid; ?>">
		</div>
				<div class="input-group">
			
			<input type="Number" name="cash" placeholder="Transfer Amount" style="height:35px" size="36" value="<?php echo $cash; ?>">
		</div>
						<div class="input-group">
			
			<input type="password" name="password_1" placeholder="Bankoneer Transaction Password">
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
<img class="sspace" src="../images/b_payment.png"/ width="150" height="100" alt="b-payment" title="b-Payment: Nepal's Online Payment Portal"><br> 


<footer>B-Payment/Nepal's Online Payment Portal<p>Copyright: 2018</p></footer>



