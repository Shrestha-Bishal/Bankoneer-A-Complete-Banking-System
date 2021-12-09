<?php
session_start();

$branch="";
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
$oname="";
$oaddress="";
$oemail="";
$mnoo="";
$landline="";
$document="";
$date="";
$signimage="";
$image="";
$msg = "";
$hash="";
$errors=array();
$connection=odbc_connect('BankoneerServer', 'sa', 'bishal');


if (isset($_POST["submitt"])) {
	$branch=$_POST['SelectBranch'];
	$date= date('Y-m-d', strtotime($date));
	$saving=$_POST['optradio'];
	$title=$_POST['title'];
	$name=addslashes($_POST['fullname']);
	$gender=$_POST['gender'];
	$dob=$_POST['dob'];
    $fname=addslashes($_POST['fname']);
    $mname=addslashes($_POST['mname']);
    $gfname=addslashes($_POST['gfname']);
    $gmnamee=addslashes($_POST['gmname']);
    $maritial=$_POST['optradioo'];
    $sname=addslashes($_POST['sname']);
	$nationality=$_POST['nationality'];
    $paddress=addslashes($_POST['paddress']);
    $taddress=addslashes($_POST['taddress']);
    $occupation=addslashes($_POST['occupation']);
    $education=addslashes($_POST['education']);
    $oname=addslashes($_POST['oname']);
    $oaddress=addslashes($_POST['oaddress']);
    $oemail=addslashes($_POST['oemail']);
    $mobile=addslashes($_POST['mobile']);
    $mnoo=addslashes($_POST['mnoo']);
    $landline=addslashes($_POST['landline']);
    $email=addslashes($_POST['email']);
    $citizenship=addslashes($_POST['citizenship']);
    $_SESSION['hash']= $citizenship;
    echo $_SESSION['hash'];
    $document=addslashes($_POST['document']);
    $_FILES['picimage']['name']="";
    $_FILES['image']['name']="";
    $_FILES['dimage']['name']="";
    $_FILES['signimage']['name']="";
// the path to store the upload image
	$ta="../images/".basename($_FILES['picimage']['name']);//pp pic
	$target = "../images/".basename($_FILES['image']['name']);//citizeship
	$taa="../images/".basename($_FILES['dimage']['name']);//document
	$taaa="../images/".basename($_FILES['signimage']['name']);//sign
		//get all the submitted data from the form
	$images=$_FILES['picimage']['name'];
	$image=$_FILES['image']['name'];
	$imagess=$_FILES['dimage']['name'];
    $imagesss=$_FILES['signimage']['name'];


if (count($errors)==0) {

$query = "INSERT INTO internet_banking_newform_registration (branch,datee,accounttype,title,name,gender,maritial,dob,father,mother,gfather
,gmother,hw,nationality,paddress,taddress,occupation,education,oname,oaddress,oemail,mno,mnoo,landline,email,citizenshipno,documentno)
VALUES ('$branch','$date','$saving','$title','$name','$gender','$maritial','$dob','$fname','$mname','$gfname','$gmnamee','$sname','$nationality','$paddress','$taddress','$occupation','$education','$oname','$oaddress','$oemail','$mobile','$mnoo','$landline','$email','$citizenship','$document')"; //'$ta','$taaa','$target','$taa
$rs=odbc_exec($connection, $query);
$branch="";
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
$oname="";
$oaddress="";
$oemail="";
$mnoo="";
$landline="";
$document="";
$date="";
$signimage="";
$image="";
$msg = "";

header("location: image_upload.php");
//header("location: new_account_opening_success_message.php");
}
		else{
		array_push($errors, "Oho");
	    }

	//Now let's move the upload image into the folder: images
	//if(move_uploaded_file($_FILES['image']['tmp_name'], $target)){
//		echo "Image is uploaded successfully";
//	}
//	else{
//		echo "There was a problem uploading image";
//	}



}



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

if (isset($_POST['login'])){
	$username=addslashes($_POST['username']);
	$password=addslashes($_POST['password']);
	if(empty($username)){
		array_push($errors, "Username field is empty");
	}
	if (empty($password)) {
		
		array_push($errors, "Password field is empty");
	}
	*/

	/*
	if (count($errors)==0) {
		$query = "SELECT * FROM  bankapplicantregistration WHERE username='$username' AND password='$password' ";
		$rs=odbc_exec($connection, $query);
		if(odbc_fetch_row($rs)==1){
			//header('location: user.php');
			array_push($errors, "milyo")
		}
		//if (odbc_result($rs)==1) {
		//	header('location: user.php');
		//}
			else{
		array_push($errors, "BIgryo");
	              }
	

}}*/

//image upload


//if upload button is pressed
if (isset($_POST['submit'])){
	$cpp=$_SESSION['hash'];
	$abc = "SELECT * FROM internet_banking_newform_registration WHERE citizenshipno= '$cpp'";
	$ras=odbc_exec($connection, $abc);
if(odbc_fetch_row($ras)==1){

	//echo $cpp;

	// the path to store the upload image
	$ta="../images/".basename($_FILES['picimage']['name']);
	$target = "../images/".basename($_FILES['image']['name']);
	$taa="../images/".basename($_FILES['dimage']['name']);
	$taaa="../images/".basename($_FILES['signimage']['name']);

	//connect to the database
 //$db = mysqli_connect('localhost', 'root','','bankoneer');

	//get all the submitted data from the form
	$image=$_FILES['image']['name'];
	$images=$_FILES['picimage']['name'];
	$imagess=$_FILES['image']['name'];
	$imagesss=$_FILES['signimage']['name'];

	//$sql = "INSERT INTO imagess (image,images,imagess,imagesss) VALUES ('$image','$images','$imagess','$imagesss') WHERE citizenshipno= '$cpp' ";
	//	$sql = "INSERT INTO internet_banking_newform_registration (image,signature,citizenshipimage,documentimage) VALUES ('$image','$images','$imagess','$imagesss')  WHERE citizenshipno= '$cpp' ";
		$sql = "UPDATE internet_banking_newform_registration SET image='$image',signature='$images',citizenshipimage='$imagess',documentimage='$imagesss' WHERE citizenshipno= '$cpp'";
	
	//mysqli_query($db,$sql); //stores the submitted data into the database table: images
		$raas=odbc_exec($connection, $sql);

	//Now let's move the upload image into the folder: images
	if(move_uploaded_file($_FILES['image']['tmp_name'], $target)){
		echo "Image is uploaded successfully"; 
		header("location: new_account_opening_success_message.php");
	}
	else{
		echo "There was a problem uploading image"; 

	}

}

}
else{
	
}
?>
