<?php
include ('../header.php');
include('../registration/server.php');

//if user is not logged in they cannot access this page
if (empty($_SESSION['username'])) { ////ekdam important for security turn it on after finished
	header('location: ../registration/login.php');
}
?>
<p><a href="user.php"><img src="../images/iconb.png" alt="Bankoneer" style="width="100" height="70"></a> Bankoneer: Co-Operative Banking Pioneer Software </p>
<div class="content">
	<?php if (isset($_SESSION['success'])): ?> 
	<div class="error success">
		<h2>
			<?php 
			echo $_SESSION['success'];
			unset($_SESSION['success']);
			?>
		</h2>
	</div>
	<?php endif ?>
	<?php if (isset($_SESSION["username"])): ?>
		<p>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
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
<p style="padding-left: 23cm">| Acccount Balance .: 
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
<a style="padding-left: 24cm" href="third_party_transfer.php" title="Third Party Transfer"><button class="button">Third Party Transfer</button></a>
<a href="transaction_history.php" title="Transaction History"><button class="button">Transaction History</button></a>
<a href="loan_history.php" title="Loan History"><button class="button">Loan History</button></a>
<a href="wallet.php" title="Bankoneer Wallet"><button class="button">Wallet</button></a>
	<?php endif ?>

<body>
	<style type="text/css">
	table{
		border-collapse: collapse;
		width: 10%
		color: #588c7e
		font-family: monospace;
		font-size:20px;
		text-align: left;
	}
	th{
		background-color: #588c7e;
		color: white;

	}
	</style>
	<table>
		<tr><br><br>
			<p>Account Details: </p>
			<th>Joined Date&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;</th>
		<th>Account Number  &nbsp; &nbsp;&nbsp; </th> 
		<th>Saving Type&nbsp;&nbsp;&nbsp;&nbsp;</th>
		<th>Name&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
		<th>Username&nbsp;&nbsp;&nbsp;</th>
		<th>Total Balance&nbsp;&nbsp;&nbsp;&nbsp;</th>
		<th>Wallet Balance</th>
		<?php 
		// Create connection
		$conn = odbc_connect('SQLServerr', 'sa', 'bishal');
		$user=$_SESSION['username'];

        

$sql = "SELECT datee,account_no, type, name, username,total_balance,wallet_balance FROM customer_account WHERE username='$user'";
$result = odbc_exec($connection, $sql);
$ress=odbc_num_rows($result);

if ($ress) {
	//for ($j=0; $j=$row = odbc_fetch_array($result); $j++ ){
	$row = odbc_fetch_array($result);
	/*echo "<tr><td>".$row["account_no"]."</td></tr>";
	echo "<tr><td>".$row["type"]."</td></tr>";
	echo "<tr><td>".$row["name"]."</td></tr>";
	echo "<tr><td>".$row["username"]."</td></tr>";
	echo "<tr><td>".$row["total_balance"]."</td></tr>";*/
	echo "<tr><td>".$row["datee"]."</td><td>".$row["account_no"]."</td><td>".$row["type"]."</td><td>".$row["name"]."</td><td>".$row["username"]."</td><td>".$row["total_balance"]."</td><td>".$row["wallet_balance"]."</td><td>";
	$_SESSION['account_no']=$row["account_no"];
	$accc="";
	$accc=$_SESSION['account_no'];
	//echo $_SESSION['account_no'];




	

}

/*
if (odbc_fetch_array($result)==1) {//odbc_num_rows
    // output data of each row
    while($row = odbc_fetch_row($result)) {
    	echo "<tr>";
    	echo "<tr><td>".$row["account_no"]."</td></tr>";
        echo "id: " . $row["account_no"]. " - Name: " . $row["firstname"]. " " . $row["lastname"]. "<br>";
    }
    echo "</tr>";
    echo "</table>";
} */
else {
    echo "0 results";
}

		
?>
		</tr>
	</table>
</body>
<?php include('loan_details.php'); ?>
</div>
<?php 
include ('../footer.php'); ?>