<?php
//ODBC Connection
echo " Create the connection...<br /><br />";
$connection=odbc_connect('BankoneerServer','sa','bishal');
echo "Test the connection...<br />";
if ($connection) {
	echo "Yep, we are connected...";
	# code...
}
$query = <<<EOF
SELECT TOP 50 [sno]
,[name]
,[gender]
 FROM [bankapplicantregistration]
 where [sno]>= 1

EOF;

$rs=odbc_exec($connection, $query);
odbc_result_all($rs,"cellpadding='3'
	background-color='d3d3d3'");

//odbc_result_all($rs, "cellpadding='3'
//background-color='d3d3d3'");

?>