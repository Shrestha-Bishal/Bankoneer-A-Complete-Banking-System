<?php
session_start();
$fullname="";
$fname="";
$mname="";
$gfname="";
$gmname="";
$sname="";
$citizenship="";
$education="";
$occupation="";
$mobile="";
$email="";
$paddress="";
$taddress="";
$accc="";

$errors=array();
$connection=odbc_connect('SQLServerr', 'sa', 'bishal');
//$conn=odbc_connect("DRIVER={MySQL ODBC 5.1 Driver}; Server=DESKTOP-MDJU23T; Database=bankoneer_db", "sa", "bishal");
/*
if(isset($_POST['submit'])){
	$fullname=addslashes($_POST['fullname']);
$fname=addslashes($_POST['fname']);
$mname=addslashes($_POST['mname']);
$gfname=addslashes($_POST['gfname']);
$gmname=addslashes($_POST['gmname']);
$sname=addslashes($_POST['sname']);
$citizenship=addslashes($_POST['citizenship']);
$education=addslashes($_POST['education']);
$occupation=addslashes($_POST['occupation']);
$mobile=addslashes($_POST['mobile']);
$email=addslashes($_POST['email']);
$paddress=addslashes($_POST['paddress']);
$taddress=addslashes($_POST['taddress']);
if (count($errors)==0){
	$sql="INSERT INTO bankapplicantregistration("
}
}
*/
if (isset($_POST['login'])){
	$username=addslashes($_POST['username']);
	$password=addslashes($_POST['password']);
	if(empty($username)){
		array_push($errors, "Username field is empty");
	}
	if (empty($password)) {
		array_push($errors, "Password field is empty");
	}
	
	if (count($errors)==0) {
		$query = "SELECT * FROM  newmemberregistration WHERE username='$username' AND password='$password' ";
		$rs=odbc_exec($connection, $query);
		if(odbc_fetch_row($rs)==1){
			//log user in
			$_SESSION['username']=$username;
			$_SESSION['success']="You are now logged in";
			header('location: ../core/user.php');  //redirect to home page
			
		}
		//if (odbc_result($rs)==1) {
		//	header('location: user.php');
		//}
		else{
		array_push($errors, "Worng Username/Password combination");
	    }
	}

//logout
	if (isset($_GET['logout'])){
		session_destroy();
		unset($_SESSION['username']);
		header('location: login.php');
	}
}
?>