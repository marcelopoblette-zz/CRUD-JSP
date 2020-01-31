package controlador;

import dao.Producto;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Daoproducto;

public class Servlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        Producto p = new Producto();
        Daoproducto daoproducto = new Daoproducto();

        String nom, accion, busqueda, msj = "", parametro;
        int id, precio, cat;
        RequestDispatcher rd;

        accion = request.getParameter("accion");
        List<Producto> datos = new ArrayList<>();

        switch (accion) {
            case "Ingresar":
                if (request.getParameter("prod").trim().equalsIgnoreCase("")) {
                    msj = "Error, campo nombre vacío. Favor ingresar un nombre de producto.";
                } else {
                    id = Integer.parseInt(request.getParameter("id"));
                    nom = request.getParameter("prod");
                    precio = Integer.parseInt(request.getParameter("precio"));
                    cat = Integer.parseInt(request.getParameter("cat"));

                    parametro = Integer.toString(id);
                    datos = (List<Producto>) daoproducto.consultarP(parametro, "1");
                    if (datos.isEmpty()) {
                        p.setProd_codigo(id);
                        p.setProd_nombre(nom);
                        p.setProd_precio(precio);
                        p.setProd_cod_categoria(cat);

                        msj = daoproducto.insertar(p);
                    } else {
                        msj = "Error al insertar. ID ya existe en la tabla.";
                    }
                }
                request.setAttribute("accion", accion);
                request.setAttribute("msj", msj);
                request.getSession().setAttribute("datos", datos);
                rd = request.getRequestDispatcher("vistaResultados.jsp");
                rd.forward(request, response);
                break;
            case "Buscar":
                busqueda = request.getParameter("rd");
                if ("1".equals(busqueda)) {
                    id = Integer.parseInt(request.getParameter("id"));
                    parametro = Integer.toString(id);
                    datos = (List<Producto>) daoproducto.consultarP(parametro, busqueda);
                } else if ("2".equals(busqueda)) {
                    nom = request.getParameter("prod");
                    datos = (List<Producto>) daoproducto.consultarP(nom, busqueda);
                }
                request.setAttribute("accion", accion);
                request.getSession().setAttribute("datos", datos);
                rd = request.getRequestDispatcher("vistaResultados.jsp");
                rd.forward(request, response);
                break;
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
