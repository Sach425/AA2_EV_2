
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modificar producto</title>
    </head>
    <body>
        <h1>Modificar registro</h1>

        <form action="ProductosController?accion=actualizar" method="POST" autocomplete="off">

            <input type="hidden" id="id" name="id" value="<c:out value="${producto.id}" />" />

            <p>
                Apellido: <input type="text" id="apellido" name="apellido" value="<c:out value="${producto.apellido}" />" required />
            </p>

            <p>
                Nombre: <input type="text" id="nombre" name="nombre" value="<c:out value="${producto.nombre}" />" required />
            </p>

            <p>
                Correo: <input type="text" id="correo" name="correo" value="<c:out value="${producto.correo}" />" required />
            </p>

            <p>
                Cedula: <input type="text" id="cedula" name="cedula" value="<c:out value="${producto.cedula}" />" required />
            </p>

            <button id="guardar" name="guardar" type="submit">Guardar</button>
        </form>
    </body>
</html>
