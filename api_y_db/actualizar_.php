<?php 

include 'conexion.php';

$id =$_POST['id'];
$nombre =$_POST['nombre'];
$correo =$_POST['correo'];
$direccion =$_POST['direccion'];
$parentezco =$_POST['parentezco'];


$query ="UPDATE user SET nombre ='$nombre' ,correo ='$correo', direccion ='$direccion', parentezco='$parentezco'  WHERE id ='$id'";

$resultado =mysqli_query($conexion,$query);

if($resultado){
    echo "datos actualizados";
}else{
    echo "error en actualizacion";
}


mysqli_close($conexion);

?>