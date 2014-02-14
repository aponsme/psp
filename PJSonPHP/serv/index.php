<?php
    //Decodificamos los datos
    $se=json_decode(stripslashes($_POST["key"]));
    //Mostramos los datos
    echo"Soy el servidor , te envio los siguientes datos:\n";
    echo "id: ".$se->id."\n";
    $id=$se->id;
    if ($id == "") 
    {
	    //No se ha enviado el id de la visita
	    echo "<h3 align=\"center\"> Error en el acceso</h2>";
	} 
	else 
	{
	    //Tratamos de conectar con la BD
	    $con = @mysql_connect("localhost", "root", "root");
	    if (!$con || !mysql_select_db("curso_php", $con)) 
	    {
	        echo "<h3 align=\"center\"> Error en el acceso a la base de datos. Error : \" " . mysql_error() . "\"</h2>";
	    }
	    else
	    {
	            //Generamos la sentencia SQL de insercion en una variable
	            $sql ="SELECT * FROM persona WHERE id = $id";
	            //Lanzamos la sentencia SQL de inserci—n en la BD
	            //echo $sql;
	            $res = mysql_query($sql, $con);
	            //echo "Valor mysql_affected_rows($res) : " . mysql_affected_rows($con) . " valor";
	            $res = mysql_query($sql);
	            while ($linea = mysql_fetch_array($res)) 
	            {
					echo "Nombre:{$linea['nombre']}\n";
					echo "Apellidos:{$linea['apellido']}";	
				}
	    }
	} 
?>