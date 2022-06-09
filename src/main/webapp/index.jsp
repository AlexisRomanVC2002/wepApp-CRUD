<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import = "modelo.Productos, modelo.ProductosDAO, java.util.*" %>
<%
    ProductosDAO productosDAO = new ProductosDAO();
    List<Productos> productos = productosDAO.listarProductos();
    request.setAttribute("lista", productos);
%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Almacen</title>
    <link rel="stylesheet" href="css/styles_index.css">
</head>

<body>
    <header class="header">
        <div class="content-title">
            <h1 class="title">Productos</h1>
        </div>
    </header>
    <main>
        <div class="table-data">
            <div class="content-actions">
                <a href="ProductosController?accion=nuevo">Nuevo Registro</a>
            </div>
            <table class="table">
                <thead>
                    <tr>
                        <th>Codigo</th>
                        <th>Nombre</th>
                        <th>Precio</th>
                        <th>Existencia</th>
                        <th></th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="producto" items="${lista}">
                        <tr>
                            <td><c:out value="${producto.getCodigo()}" /></td>
                            <td><c:out value="${producto.getNombre()}" /></td>
                            <td><c:out value="${producto.getPrecio()}" /></td>
                            <td><c:out value="${producto.getExistencia()}" /></td>
                            <td><a href="ProductosController?accion=modificar&id=<c:out value="${producto.getId()}" />">Modificar</a></td>
                            <td><a href="ProductosController?accion=eliminar&id=<c:out value="${producto.getId()}" />">Eliminar</a></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </main>
</body>

</html>