<?php

include 'conexion.php'

$nombre= ( empty($_POST['nombre']) ) ? NULL : $_POST['nombre'];
$apellidos= ( empty($_POST['apellidos']) ) ? NULL : $_POST['apellidos'];
$fecha=  empty($_POST['fecha']) ) ? NULL : $_POST['fecha'];
$id= empty($_POST['id']) ) ? NULL : $_POST['id'];

$consulta= "INSERT INTO socios values('".$nombre."','".$apellidos."','".$fecha."','".$id."')";
mysqli_query($conexion,$consulta) or die (mysqli_error());
mysqli_close($conexion);
?>