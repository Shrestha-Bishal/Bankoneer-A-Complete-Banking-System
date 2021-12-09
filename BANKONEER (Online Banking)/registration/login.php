  <p><a href="../index.php"><img src="../images/iconb.png" alt="Bankoneer" style="width="100" height="70"></a> Bankoneer: Co-Operative Banking Pioneer Software </p>
<?php include('../registration/server.php'); 
$username="";
$password="";?>
<!DOCTYPE html>
<html>
<head>
	<title>Bankoneer |Core Banking System Software| </title>
	<link rel="stylesheet" type="text/css" href="loginstyle.css">
</head>
<body>
	<div id="frm">
 	<form method="post" action="../registration/login.php"> 
 		<!-- display validation here -->
 		<?php include('errors.php'); ?>

 	<p>
 		<label>Username:</label>
 		<input type="text" id="user" name="username" placeholder="Case Sensitive Username" />
 	</p>
 	<p>
 		<label>Password:</label>
 		<input type="password" id="pass" name="password" placeholder="Case Sensitive Password" />
 	</p>
 	<p>
 		<button type="submit" name="login" class="btn">Login <a href="register.php"> </a> </button> <br><br><a href="" >Forgot Password?</a>
 	</p>
 	</form>
 </div>

  <style>
 body{
    background-image: url("../images/online.jpg");
    background-size: 1400px 500px;
    background-repeat: no-repeat;

    }
    
</style>
</body>
</html>

<?php 
include ('../footer.php'); ?>