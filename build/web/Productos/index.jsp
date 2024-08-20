
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="diseño.css">
        
        <title>Usuarios</title>
        
    </head>
    <body>
         <div class="container">
        <aside class="sidebar">
            <h2>Gestión de Usuario</h2>
            <nav>
                <ul>
                    <li><a href="index.html">Inicio</a></li>
                    <li><a href="ProductosController">Registro</a></li>
                </ul>
            </nav>
        </aside>
             <main class="content">
        <h1>Usuarios</h1>

        <p><a href="ProductosController?accion=nuevo">Nuevo Registro</a></p>

        <table border="1" width="80%">
            <thead>
            <tr>   
            <th>Cédula</th>
            <th>Nombre</th>
            <th>Apellido</th>
            <th>Correo</th>
            <th></th>
            <th></th>
            </tr>
        </thead>

        <tbody>
            <c:forEach var="producto" items="${lista}">
                <tr>
                    <td><c:out value="${producto.cedula}" /></td>
                    <td><c:out value="${producto.nombre}" /></td>
                    <td><c:out value="${producto.apellido}" /></td>
                    <td><c:out value="${producto.correo}" /></td>
                    <td><a href="ProductosController?accion=modificar&id=<c:out value="${producto.id}" />">Modificar</a></td>
                    <td><a href="ProductosController?accion=eliminar&id=<c:out value="${producto.id}" />">Eliminar</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    
    </main>
    </div>
</body>
</html>
