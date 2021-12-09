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
			<p style="color: PURPLE">Loan Details: Please Check LOAN HISTORY for all loan details.</p>
			<th>Loan Amount&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp; </th>
		<th> Interest Rate  &nbsp; &nbsp;&nbsp; &nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;</th> 
		<th>Time Period&nbsp;&nbsp;&nbsp;&nbsp;</th>
		<th>Monthly Amount&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
		<th>Remaining Loan&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
		<th>Interest Amount&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
		<th>Installment&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
		<th>Fine&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
		<th>Installment Date&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
		<?php 
			$username=$_SESSION['username'];
	//echo $username;

			$query = "SELECT * FROM  loan_account WHERE username='$username' AND accountnumber='$accc'  ";
		$rs=odbc_exec($connection, $query);
		if(odbc_fetch_row($rs)==1){
		// Create connection
		$conn = odbc_connect('SQLServerr', 'sa', 'bishal');
		$user=$_SESSION['username'];

        
$accc=$_SESSION['account_no'];
	//echo $_SESSION['account_no'];
$sql = "SELECT  loan_amount, interest_rate, time_period,monthly_amount, remaining_loan,interest_amount, installment,fine,installment_date FROM loan_account  WHERE accountnumber='$accc' ORDER BY sno DESC";
$result = odbc_exec($connection, $sql);
$ress=odbc_num_rows($result);
if ($ress) {
	//for ($j=0; $j=$row = odbc_fetch_array($result); $j++ ){
	while ($row = odbc_fetch_array($result)){
	echo "<tr><td>".$row["loan_amount"]."</td><td>".$row["interest_rate"]."</td><td>".$row["time_period"]."</td><td>".$row["monthly_amount"]."</td><td>".$row["remaining_loan"]."</td><td>".$row["interest_amount"]."</td><td>".$row["installment"]."</td><td>".$row["fine"]."</td><td>".$row["installment_date"]."</td><td>";


}

	

}


}
else {
    echo "No Loans Initiated!";
}
	


		
?>
		
</tr>
	</table>
