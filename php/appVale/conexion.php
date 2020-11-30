<?php

$hostname='localhost';
$database='appvale';
$username='root';
$password='';

$conexion = new mysqli($hostname, $username, $password, $database);
if($conexion->connect_errno){
	echo "Ha ocurrido un error al conectarse a la BD";
}else{
	echo "Nos hemos conectado a la BD correctamente!";	
}

?>