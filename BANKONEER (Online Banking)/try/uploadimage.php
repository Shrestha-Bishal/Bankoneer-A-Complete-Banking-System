<?php
$msg = "";
//if upload button is pressed
if (isset($_POST['upload'])){
	// the path to store the upload image
	$target = "../images/".basename($_FILES['image']['name']);

	//connect to the database
 $db = mysqli_connect('localhost', 'root','','bankoneer');

	//get all the submitted data from the form
	$image=$_FILES['image']['name'];
	$text=$_POST['text'];

	$sql = "INSERT INTO images (image,texta) VALUES ('$image','$text')";
	mysqli_query($db,$sql); //stores the submitted data into the database table: images

	//Now let's move the upload image into the folder: images
	if(move_uploaded_file($_FILES['image']['tmp_name'], $target)){
		echo "Image is uploaded successfully";
	}else{
		echo "There was a ploblem uploading image";
	}
}
?>
<!DOCTYPE html>
<html>
<head>
	<title>Image Upload</title>
	<link rel="stylesheet" type="text/css" href="uploadimage.css">
</head>
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

		<form method="post" action="uploadimage.php" enctype="multipart/form-data">
			<input type="hidden" name="size" value="1000000">
			<div>
				<input type="file" name="image">
			</div>
			<div>
				<textarea name="text" cols="40" placeholder="Say something about this image..."></textarea>
			</div>
			<div>
				<input type="submit" name="upload" value="Upload Image">
			</div>
		</form>
	</div>

</body>
</html>