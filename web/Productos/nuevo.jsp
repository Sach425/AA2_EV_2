
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="diseño.css">
      
    </head>
    <body>
        <h1>Nuevo registro</h1>

        <form action="ProductosController?accion=insertar" method="POST" autocomplete="off">
            <p>
                Apellido: <input type="text" id="apellido" name="apellido" required autofocus="true" />
            </p>

            <p>
                Nombre: <input type="text" id="nombre" name="nombre" required />
            </p>

            <p>
                Correo: <input type="text" id="correo" name="correo" required />
            </p>

            <p>
                Cedula: <input type="text" id="cedula" name="cedula" required />
            </p>

            <button id="guardar" name="guardar" type="submit">Guardar</button>
        </form>
   
        
    </body>
</html>
