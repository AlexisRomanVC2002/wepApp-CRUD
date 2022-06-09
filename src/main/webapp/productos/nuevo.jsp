<%@ page contentType="text/html" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html>

    <head>
        <meta charset="UTF-8">
        <title>Almacen - Nuevo Registro</title>
        <link rel="stylesheet" href="css/styles_nuevo.css">
    </head>

    <body>
        <header>
            <h1 class="title">Nuevo Registro</h1>
        </header>

        <main>

            <form action="ProductosController?accion=insertar" method="POST" autocomplete="off">

                <div class="content-element">
                    <div class="content-tag">
                        <h2>Codigo:</h2>
                    </div>
                    <div class="content-input">
                        <input id="codigo" name="codigo" type="text">
                    </div>
                </div>

                <div class="content-element">
                    <div class="content-tag">
                        <h2>Nombre:</h2>
                    </div>
                    <div class="content-input">
                        <input id="nombre" name="nombre" type="text">
                    </div>
                </div>

                <div class="content-element">
                    <div class="content-tag">
                        <h2>Precio:</h2>
                    </div>
                    <div class="content-input">
                        <input id="precio" name="precio" type="text">
                    </div>
                </div>

                <div class="content-element">
                    <div class="content-tag">
                        <h2>Existencia:</h2>
                    </div>
                    <div class="content-input">
                        <input id="existencia" name="existencia" type="text">
                    </div>
                </div>

                <div class="content-button">
                    <button id="guardar" name="guardar" type="submit">Guardar</button>
                </div>
            </form>

        </main>
    </body>

    </html>