<?php
$serverName = "DESKTOP-MDJU23T"; //serverName\instanceName\\MSSQLSERVER
$connectionInfo = array( "Database"=>"bankoneer_db", "UID"=>"sa", "PWD"=>"bishal");
$conn = sqlsrv_connect($serverName,$connectionInfo);

if( $conn ) {
     echo "Connection established.<br/>";
}else{
     echo "Connection could not be established.<br/>";
     die( print_r(sqlsrv_errors(),true));
}
?>
<a href="../bankoneer/registration/login.php"><button class="button"><b>Login</b></button></a> 