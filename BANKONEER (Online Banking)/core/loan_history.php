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
<body>

	<div id="frm">
 	<form method="post" action="loan_history.php"> 
 		<!-- display validation here -->
 		<?php include('errors.php');?>

 	<p><br>
 	  	<label>Please enter your password to view Loan history</label> <br><br>
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
			<p>Loan History ORDERED with the MOST RECENT transactions:</p>
			<th>Date&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;</th>
			<th>Loan Amount&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp; </th>
		<th> Interest Rate  &nbsp; &nbsp;&nbsp; &nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;</th> 
		<th>Time Period&nbsp;&nbsp;&nbsp;&nbsp;</th>
		<th>Monthly Amount&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
		<th>Deposited&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
		<th>Status&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
		<th>Remaining Loan&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
		<th>Interest Amount&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
		<th>Installment&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
		<th>Fine&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
		<th>Installment Date&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
		<th>Next Installment Date&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
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
$sql = "SELECT datee, loan_amount, interest_rate, time_period,monthly_amount, deposited,status,remaining_loan,interest_amount,installment,fine,installment_date,next_installment_date FROM loan_history  WHERE account_number='$accc' ORDER BY sno DESC";
$result = odbc_exec($connection, $sql);
$ress=odbc_num_rows($result);
if ($ress) {
	//for ($j=0; $j=$row = odbc_fetch_array($result); $j++ ){
	while ($row = odbc_fetch_array($result)){
	echo "<tr><td>".$row["datee"]."</td><td>".$row["loan_amount"]."</td><td>".$row["interest_rate"]."</td><td>".$row["time_period"]."</td><td>".$row["monthly_amount"]."</td><td>".$row["deposited"]."</td><td>".$row["status"]."</td><td>".$row["remaining_loan"]."</td><td>".$row["interest_amount"]."</td><td>".$row["installment"]."</td><td>".$row["fine"]."</td><td>".$row["installment_date"]."</td><td>".$row["next_installment_date"]."</td><td>";


}

	

}

else {
    echo "No Loans yet!";
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