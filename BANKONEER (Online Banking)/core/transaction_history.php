<?php
include ('../header.php');
include('server.php');
?>
   <p><a href="user.php"><img src="../images/iconb.png" alt="Bankoneer" style="width="100" height="70"></a>Bankoneer: Co-Operative Banking Pioneer Software </p>
<p>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			Welcome: <strong><?php echo $_SESSION["username"]; ?></strong>
			<a href="../registration/login.php?logout='1'" style="color: red;"><button style="color: Red">Logout</button></a>
		</p>
		<!--
		<p style="padding-left: 29cm">Wallet Balance:<img src="../images/wallet.jpg"  title="Your Wallet" alt="Your Wallet" height="32" width="42">NRS.: <?php
	//	$user=$_SESSION['username'];
	//	$sql = "SELECT wallet_balance FROM customer_account WHERE username='$user'";
//$result = odbc_exec($connection, $sql);
//$row = odbc_fetch_array($result);
//echo $row['wallet_balance'];?></p>
		<br>
-->
<body>

	<div id="frm">
 	<form method="post" action="transaction_history.php"> 
 		<!-- display validation here -->
 		<?php include('errors.php');?>

 	<p><br>
 	  	<label>Please enter your password to view Transaction history</label> <br><br>
 		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
 <!--	<label>Email id:&nbsp;&nbsp;</label>

 		<input type="Email" id="user" name="username" placeholder="airtra@gmail.com"/> -->

 		<label>Password:</label>
 		<input type="password" id="pass" name="password" placeholder="password"/>

 		<button type="submit" name="history" class="btn">View History</button>   

<!--      //include ('../airport/searchflightviaid.php'); -->

 	</p>


 	</form>
 </div>
</body>
<body>
	<style type="text/css">
	table{
		border-collapse: collapse;
		width: 10%
		color: #588c7e
		font-family: monospace;
		font-size:20px;
		text-align: left;
		border-right: 1px solid #eeeeef;
	}
	th{
		background-color: #588c7e;
		color: white;
		border-right: 1px solid #eeeeef;

	}
	tr, td{
		border-right: 1px solid #000408;
	}

	</style>

<table>
		<tr><br><br>
			<p>Transaction History ORDERED with the MOST RECENT transactions:</p>
			<th>Time and Date&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;</th>
			<th>Transaction Method&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp; </th>
		<th>Transaction Status  &nbsp; &nbsp;&nbsp; &nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;</th> 
		<th>Transaction Amount&nbsp;&nbsp;&nbsp;&nbsp;</th>
		<th>Total Balance&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
		<th>Wallet Balance&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
		<?php 
		if (isset($_POST['history'])){
			$username=$_SESSION['username'];
	//echo $username;
	$password=addslashes($_POST['password']);
	if (empty($password)) {
		array_push($errors, "Password field is empty");
	}
		if (count($errors)==0) {
			$query = "SELECT * FROM  newmemberregistration WHERE username='$username' AND password='$password' ";
		$rs=odbc_exec($connection, $query);
		if(odbc_fetch_row($rs)==1){
		// Create connection
		$conn = odbc_connect('SQLServerr', 'sa', 'bishal');
		$user=$_SESSION['username'];

        
$accc=$_SESSION['account_no'];
	//echo $_SESSION['account_no'];
$sql = "SELECT date_time, type, status, amount, total_balance,wallet_balance FROM transaction_history  WHERE account_no='$accc' OR too=
'$username' ORDER BY sno DESC";
$result = odbc_exec($connection, $sql);
$ress=odbc_num_rows($result);
if ($ress) {
	//for ($j=0; $j=$row = odbc_fetch_array($result); $j++ ){
	while ($row = odbc_fetch_array($result)){
	echo "<tr><td>".$row["date_time"]."</td><td>".$row["type"]."</td><td>".$row["status"]."</td><td>".$row["amount"]."</td><td>".$row["total_balance"]."</td><td>".$row["wallet_balance"]."</td><td>";


}

	

}

else {
    echo "No Transactions yet!";
}
}
else{
		array_push($errors, "Invalid Password");
	    }
	}
}

		
?>
		
</tr>
	</table>

<?php
include ('../footer.php');
?>