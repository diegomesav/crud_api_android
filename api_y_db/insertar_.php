<?php 

include 'conexion.php';

$nombre =$_POST['nombre'];
$correo =$_POST['correo'];
$direccion =$_POST['direccion'];
$parentezco =$_POST['parentezco'];


// aqui escribimos codigo sql
$query ="INSERT INTO user(nombre,correo,direccion,parentezco) values('$nombre' ,'$correo', '$direccion','$parentezco') ";
$resultado =mysqli_query($conexion,$query);

if($resultado){
    echo "datas insertados";
}else{
    echo "datas error";
}
mysqli_close($conexion);

?>