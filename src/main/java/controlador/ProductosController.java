package controlador;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Productos;
import modelo.ProductosDAO;

@WebServlet(name = "ProductosController", urlPatterns = { "/ProductosController"})
public class ProductosController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ProductosDAO productosDAO = new ProductosDAO();
        String accion;
        RequestDispatcher requestDispatcher = null;

        accion = req.getParameter("accion");

        if (accion == null || accion.isEmpty()) {
            requestDispatcher = req.getRequestDispatcher("/index.jsp");

        } else if (accion.equals("nuevo")) {
            requestDispatcher = req.getRequestDispatcher("/productos/nuevo.jsp");

        } else if (accion.equals("insertar")) {

            String codigo = req.getParameter("codigo");
            String nombre = req.getParameter("nombre");
            float precio = Float.valueOf(req.getParameter("precio"));
            int existencia = Integer.valueOf(req.getParameter("existencia"));

            Productos producto = new Productos(codigo, nombre, precio, existencia);
            productosDAO.agregarProducto(producto);

            requestDispatcher = req.getRequestDispatcher("/index.jsp");

        } else if (accion.equals("modificar")) {
            requestDispatcher = req.getRequestDispatcher("productos/modificar.jsp");

            int id = Integer.valueOf(req.getParameter("id"));
            Productos producto = productosDAO.buscarProducto(id);

            req.setAttribute("producto", producto);

        } else if (accion.equals("actualizar")) {

            int id = Integer.valueOf(req.getParameter("id"));
            String codigo = req.getParameter("codigo");
            String nombre = req.getParameter("nombre");
            float precio = Float.valueOf(req.getParameter("precio"));
            int existencia = Integer.valueOf(req.getParameter("existencia"));

            Productos producto = new Productos(id, codigo, nombre, precio, existencia);
            productosDAO.actualizarProducto(producto);

            requestDispatcher = req.getRequestDispatcher("/index.jsp");

        } else if (accion.equals("eliminar")) {
            int id = Integer.valueOf(req.getParameter("id"));
            productosDAO.eliminarProducto(id);

            requestDispatcher = req.getRequestDispatcher("/index.jsp");

        } else {
            requestDispatcher = req.getRequestDispatcher("/index.jsp");
        }

        requestDispatcher.forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

}
