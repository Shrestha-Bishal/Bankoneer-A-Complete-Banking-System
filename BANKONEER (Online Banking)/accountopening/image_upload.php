<?php 
include('../header.php');
include('../accountopening/server.php'); 
echo "Citizenship Number: ";
echo $_SESSION['hash']; 

?>
  <a href="../index.php"><img src="../images/iconb.png" alt="Bankoneer" style="width="100" height="70"></a> <p>Bankoneer: Co-Operative Banking Pioneer Software </p>
		<!--image upload-->

<body>
	<div id="content">
		<?php 


		/*
 $db = mysqli_connect('localhost', 'root','','bankoneer');
 $sql ="SELECT * FROM images ORDER BY id DESC LIMIT 1;";
 $result=mysqli_query($db, $sql);
 while ($row = mysqli_fetch_array($result)){
 	echo "<div id='img_div'>";
 	echo "<img src='../images/".$row['image']."'>";
 	echo "<p>".$row['texta']."</p>";
 	echo "</div>"; 
 } */
		?>

		<form method="post" enctype="multipart/form-data">
			<input type="hidden" name="size" value="1000000"><br>
			<div><p><STRONG> Upload scanned image of:   </STRONG> <br><br><br>
				<br>Passport Sized Photo:
				<input type="file" name="picimage">
				Signature:
				<input type="file" name="signimage"><br><br>
			<br>Citizenship: 
				<input type="file" name="image">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			Other Documents: (Passport/Driving Licence)
			<input type="file" name="dimage">

			</div>
			<div class="input-group"><br>
					<p >Please read the following <a style="color: Blue" href="">Terms and Conditions</a> and click the Submit</p>
				<button style="color: Green" type="submit" name="submit" class="btn">I Agree and Submit</button>
			</div>
		</form>
	</div>

</body>
<?php include('../footer.php');?>