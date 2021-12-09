<?php
include ('../header.php');
include('../registration/server.php');
?>
 <p><a href="user.php"><img src="../images/iconb.png" alt="Bankoneer" style="width="100" height="70"></a>Bankoneer: Co-Operative Banking Pioneer Software </p>
<p>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			Welcome: <strong><?php echo $_SESSION["username"]; ?></strong>
			<a href="../registration/login.php?logout='1'" style="color: red;"><button style="color: Red">Logout</button></a>
		</p>
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
		<!--button css-->
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
		<br>
		<p><strong>1. Transfer your BANKONEER Wallet Fund To B-Payment/ Nepal's Online Payment Portal : </strong> 
<a style="padding-left: 29cm" href="../payment/load_Bpayment.php" title="B-Payment"><button class="button">B-Payment</button></a></p>
		<p><strong>2. Transfer Fund From B-Payment/ Nepal's Online Payment Portal to your BANKONEER Wallet: </strong> 
<a style="padding-left: 29cm" href="../payment/Bpayment.php" title="Redirect to B-Payment"><button class="button">Redirect to B-Payment</button></a></p>



<p><strong>What is Third Party Transfer?</strong>
<br>BANKONEER Third Party Transfer that can be used for the following terms: <br>
1. Third Party Transfer: To and From amount transfer from our partnered Banks, Co-Operative Banks & Online Payment Partners.<br>
2. You can load your Wallet Money through Third Party Transfer.<br>
<!--3. Number of Transactions Per Day: 10<br>
4. Maximum Amount Per Transactions: NRS 20,000<br>
5. Daily Transaction Limit: NRS 60,000<br>-->
</p>
<?php
include ('../footer.php');
?>