<%@page import="dao.Categoria"%>
<%@page import="modelo.Daocategoria"%>
<%@page import="dao.Producto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="modelo.Daoproducto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Resultado </title>
        
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous" />
        
    </head>
    <body>
        <div>Evaluacion Presencial Marcelo Poblete</div>
        <div class="container">
            <br>
            <% String accion = (String) request.getAttribute("accion");
                if ("Ingresar".equals(accion)) {%>

            <h4>${msj}</h4>

            <% } else if ("Buscar".equals(accion)) {
                Daoproducto daoproducto = new Daoproducto();
                Daocategoria daocategoria = new Daocategoria();

                List<Producto> datos = new ArrayList();
                List<Categoria> categoria = new ArrayList();
                String parametro;

                if (((List<Producto>) request.getSession().getAttribute("datos")).isEmpty()) {
            %>
            <h4>Producto no se encuentra</h4>
            <%} else {
                datos = (List<Producto>) request.getSession().getAttribute("datos");%>
            <h4>Detalle Producto:</h4>

            <%for (Producto p : datos) {
                    parametro = Integer.toString(p.getProd_cod_categoria());
                    categoria = (List<Categoria>) daocategoria.consultarP(parametro, null);

            %>
            <table>
                <tr>
                    <td><b> ID Producto</b></td>
                    <td><%= p.getProd_codigo()%> </td>
                </tr>
                <tr>
                    <td><b> Nombre Producto</b></td>
                    <td> <%= p.getProd_nombre()%></td>
                </tr>
                <tr>
                    <td><b> Precio</b></td>
                    <td> <%= p.getProd_precio()%></td>
                </tr>
                <tr>
                    <% for (Categoria c : categoria) {%>
                    <td><b> Categoria:</b></td>
                    <td> <%= c.getCat_nom_categoria()%></td>
                    
                </tr>

                
            </table>
            
            <%}
                        }
                    }
                }%>  
                 <form action="index.jsp" method="post">
                        <br><input type="submit" value="Volver">
                    </form>
           
        </div>
    </body>
</html>
