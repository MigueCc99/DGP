<?php

include 'conexion.php'

$id=$_GET['id'];
$consulta = "select * from socios where id = '$id'";
$resultado = $conexion -> query($consulta);

while($fila=$resultado -> fetch_array()){
	$socio[] = array_map('utf8_encode', $fila);
}
	
echo json_encode($socio);
$resultado -> close();

?>