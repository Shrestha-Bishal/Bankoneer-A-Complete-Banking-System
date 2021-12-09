<?php include('../accountopening/server.php'); 

?>
 <p> <a href="../index.php"><img src="../images/iconb.png" alt="Bankoneer" style="width="100" height="70"></a> Bankoneer: Co-Operative Banking Pioneer Software </p>
<title>Bankoneer |Core Banking System Software| </title>
<style>p.space{padding-left: 14cm}</style>
<style>p.sspace{padding-left: 1cm}</style>
<head>
<!--<link rel="stylesheet" type="text/css" href="../accountopening/style.css">-->
</head>
<body style="background-color: #F2F3F4 ">
<br>
<p class="space"><strong>ACCOUNT OPENING FORM (INDIVIDUAL)</strong></p><br>
<p>Please complete all the details in CAPITAL letter and strike out the non applicable fields/boxes</p><br>
<form method="post" action="individual.php">
	<label>Select Branch:
       <select name="SelectBranch" class="form-control" placeholder="SelectBranch" required>
       	<option value="internet">Internet Banking</option>
       	<option value="balaju">Balaju Branch</option>
       	<option value="durbarmarg">DurbarMarg Branch</option>
       </select>
	</label>

<p class="sspace" style="color: #34495E"><strong>Please  open my account with your bank as follows</strong></p>
	<div class="input-group">
		<p><strong>Your Required Account Type: </strong> 
		<label class="radio-inline"><input type="radio" name="optradio" value="saving">Saving</label>
	<!--	<label class="radio-inline"><input type="radio" name="optradio" value="current">Current</label>-->
		<label style="padding-left: 7cm">Currency:
        <select name="currency" class="form-control" placeholder="Currency" required>
        	<option value="NRP">Nepalese Rupees (NRP)</option>
        	<option value="USD">American Dollar (USD)</option>
        </select></label></p>
<p class="sspace" style="color: #34495E"><strong>Sole Applicant</strong></p>
<p><strong>Your Information:</strong><br>
	&nbsp;&nbsp;<label style="padding-left: 30px">Title
		<select name="title" class="form-control" placeholder="title">
			<option value="mr">Mr.</option>
			<option value=mrs>Mrs.</option>
			<option value="ms">Ms.</option>
			</select>
	&nbsp;&nbsp;<label style="padding-left: 150px">Full Name:
		<input type="text" name="fullname" placeholder="    First Name             Middle Name            Last Name" style="height: 25px" size="50" value="<?php echo$fullname;?>"></label>
		<label style="padding-left: 40px">Gender:
			<select name="gender" class="form-control" placeholder="Gender" required>
				<option value="male">Male</option>
				<option value="female">Female</option>
				<option value="other">Other</option>
			</select>
		</label> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		Date of Birth (AD): <input type="Date" name="dob" style="height: 20px">
	</label>
	<p><strong>Family Information:</strong><br></p>
	<label>Father's Name:
		<input type="text" name="fname" placeholder="First Name      Middle Name     Last Name" style="height: 25px" size="40" value="<?php echo$fname;?>">
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
Mother's Name:
<input type="text" name="mname" placeholder="First Name      Middle Name     Last Name" style="height: 25px" size="40" value="<?php echo$mname;?>"> <br><br>

		  GrandFather's Name: 
<input type="text" name="gfname" placeholder="First Name      Middle Name     Last Name" style="height: 25px" size="40" value="<?php echo$gfname;?>">
&nbsp;&nbsp;&nbsp;&nbsp;
  Grand Mother's Name:
<input type="text" name="gmname" placeholder="First Name      Middle Name     Last Name" style="height: 25px" size="35" value="<?php echo$gmname;?>"><br><br>
		Maritial Status:		
		<label class="radio-inline"><input type="radio" name="optradioo" value="single">Single</label>
		<label class="radio-inline"><input type="radio" name="optradioo" value="married">Married</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
Spouse's Name:
<input type="text" name="sname" placeholder="First Name      Middle Name     Last Name" style="height: 25px" size="35" value="<?php echo$sname;?>">
<p><strong>Personal Details:</strong><br></p>
<label>Nationality
	<select name="nationality" class="form-control" placeholder="Nationality" required>
		<option value="nepal">Nepal</option> 
	</select>
		&nbsp;&nbsp;&nbsp;&nbsp; Education: 
		<input type="text" name="education" placeholder="Education" value="<?php echo$education;?>">
		&nbsp;&nbsp;&nbsp;&nbsp;Occupation: 
		<input type="text" name="occupation" placeholder="Occupation" value="<?php echo$occupation;?>"><br><br>
		&nbsp;
	Citizenship No: 
		<input type="text" name="citizenship" placeholder="Citizenship Number" size="35" value="<?php echo$citizenship;?>">
				&nbsp;		&nbsp;		&nbsp;		&nbsp;
		Other Documents no(Passport/Driving Licence): 
		<input type="text" name="document" placeholder="Document Number" size="35" value="<?php echo$document;?>">
</label>
</p>

	<p>
		<STRONG>Contact Information:</STRONG><br><br>
		<input type="text" name="mobile" placeholder="Mobile Number" size="35" value="<?php echo $mobile ?>">
		<input type="text" name="landline" placeholder="Landline Number" size="35" value="<?php echo $landline ?>">
	 &nbsp;   <input type="email" name="email" placeholder="bankoneer@gmail.com" size="35" value="<?php echo $email ?>"><br><br>
	 <input type="text" name="paddress" placeholder="Permanent Address (House No./Tole/Ward No./City/Country)" size="50" value="<?php echo $paddress ?>">&nbsp;&nbsp;&nbsp;&nbsp;
	 <input type="text" name="taddress" placeholder="Temporary Address (House No./Tole/Ward No./City/Country)" size="50" value="<?php echo $taddress ?>">
	</p>
	<p><STRONG>Basic Informations:</STRONG><br><br>
		<input type="text" name="oname" placeholder="Office Name" size="35" value="<?php echo $oname?>">
		<input type="text" name="oaddress" placeholder="Office Address" size="35" value="<?php echo $oaddress?>">
		<input type="email" name="oemail" placeholder="Office Email" size="35" value="<?php echo $oemail?>">
		<input type="text" name="mnoo" placeholder="Office Number" size="35" value="<?php echo $mnoo?>">
	</p>

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<button style="color: Green" type="submitt" name="submitt" class="btn" >Form Filled and Upload images</button>


	</div>

</form>
</body>





</html>


			