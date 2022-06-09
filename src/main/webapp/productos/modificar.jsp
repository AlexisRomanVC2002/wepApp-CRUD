<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <!DOCTYPE html>
    <html>

    <head>
        <meta charset="UTF-8">
        <title>Almacen - Modificar Registro</title>
        <link rel="stylesheet" href="css/styles_nuevo.css">
    </head>

    <body>
        <header>
            <h1 class="title">Modificar Registro</h1>
        </header>

        <main>

            <form action="ProductosController?accion=actualizar" method="POST" autocomplete="off">

                <input id="id" name="id" type="hidden" value="<c:out value="${producto.getId()}" />" />

                <div class="content-element">
                    <div class="content-tag">
                        <h2>Codigo:</h2>
                    </div>
                    <div class="content-input">
                        <input id="codigo" name="codigo" type="text" value="<c:out value="${producto.getCodigo()}" />" />
                    </div>
                </div>

                <div class="content-element">
                    <div class="content-tag">
                        <h2>Nombre:</h2>
                    </div>
                    <div class="content-input">
                        <input id="nombre" name="nombre" type="text" value="<c:out value="${producto.getNombre()}" />" />
                    </div>
                </div>

                <div class="content-element">
                    <div class="content-tag">
                        <h2>Precio:</h2>
                    </div>
                    <div class="content-input">
                        <input id="precio" name="precio" type="text" value="<c:out value="${producto.getPrecio()}" />" />
                    </div>
                </div>

                <div class="content-element">
                    <div class="content-tag">
                        <h2>Existencia:</h2>
                    </div>
                    <div class="content-input">
                        <input id="existencia" name="existencia" type="text" value="<c:out value="${producto.getExistencia()}" />" />
                    </div>
                </div>

                <div class="content-button">
                    <button id="guardar" name="guardar" type="submit">Guardar</button>
                </div>
            </form>

        </main>
    </body>

    </html>