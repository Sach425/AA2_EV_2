package controlador;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Productos;
import modelo.ProductosDAO;


@WebServlet(name = "ProductosController", urlPatterns = {"/ProductosController"})
public class ProductosController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ProductosDAO productosDAO = new ProductosDAO();
        String accion;
        RequestDispatcher dispatcher = null;

        accion = request.getParameter("accion");

        if (accion == null || accion.isEmpty()) {
            dispatcher = request.getRequestDispatcher("Productos/index.jsp");
            List<Productos> listaProductos = productosDAO.listarProductos();
             request.setAttribute("lista", listaProductos);
            
        } else if (accion.equals("nuevo")) {
            dispatcher = request.getRequestDispatcher("Productos/nuevo.jsp");
            
        } else if (accion.equals("insertar")) {
            String apellido = request.getParameter("apellido");
            String nombre = request.getParameter("nombre");
            String correo = request.getParameter("correo");
            int cedula = Integer.parseInt(request.getParameter("cedula"));
            Productos producto = new Productos(0, apellido, nombre, correo, cedula);
            productosDAO.insertar(producto);

            dispatcher = request.getRequestDispatcher("Productos/index.jsp");
            List<Productos> listaProductos = productosDAO.listarProductos();
      
            request.setAttribute("lista", listaProductos);
            
        } else if (accion.equals("modificar")) {
            dispatcher = request.getRequestDispatcher("Productos/modificar.jsp");
            int id = Integer.parseInt(request.getParameter("id"));
            Productos producto = productosDAO.mostarProducto(id);
            request.setAttribute("producto", producto);
            
        } else if (accion.equals("actualizar")) {

            int id = Integer.parseInt(request.getParameter("id"));
            String apellido = request.getParameter("apellido");
            String nombre = request.getParameter("nombre");
            String correo = request.getParameter("correo");
            int cedula = Integer.parseInt(request.getParameter("cedula"));
            Productos producto = new Productos(id, apellido, nombre, correo, cedula);
            productosDAO.actualizar(producto);

            dispatcher = request.getRequestDispatcher("Productos/index.jsp");
            List<Productos> listaProductos = productosDAO.listarProductos();
            request.setAttribute("lista", listaProductos);
            
        } else if (accion.equals("eliminar")) {

            int id = Integer.parseInt(request.getParameter("id"));

            productosDAO.eliminar(id);
            dispatcher = request.getRequestDispatcher("Productos/index.jsp");
            List<Productos> listaProductos = productosDAO.listarProductos();
            request.setAttribute("lista", listaProductos);
        } else {
            dispatcher = request.getRequestDispatcher("Productos/index.jsp");
            List<Productos> listaProductos = productosDAO.listarProductos();
            request.setAttribute("lista", listaProductos);
        }

        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
