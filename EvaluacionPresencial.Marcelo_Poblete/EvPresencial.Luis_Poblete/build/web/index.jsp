<%@page import="dao.Categoria"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="modelo.Daocategoria"%>
<!DOCTYPE html>
<% Daocategoria daocategoria = new Daocategoria();
    List<Categoria> categoria = new ArrayList();
    categoria = (List<Categoria>) daocategoria.consultar();
%>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Tienda</title>

        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous" />

        <script type="text/javascript" src="Validaciones.js"></script>
    </head>
    <body>
        <div>Evaluacion Presencial Marcelo Poblete</div>
    <center>
        <div class="container">
            <br>
            <div class="row">

                <div class="col-sm-11">    
                    <h1>Mantenedor de Productos</h1> 
                </div>
            </div>
            <form onsubmit="return validarCampos()" method="POST" action="Servlet">
                <br>
                <div class="form-group">
                    <div class="col-sm-3">

                        <select class="custom-select" name="accion" id="accion1" onchange="mostrar()">
                            <option value="">Elija una opcion</option>
                            <option value="Ingresar">Ingresar Productos</option>
                            <option value="Buscar">Buscar Productos</option>
                        </select>
                    </div>
                </div>
                <div id="div0" style="display: none">
                    <table>
                        <tr>
                            <td><b> <label class="radio-inline">Búsqueda por ID</label>  </b></td>
                            <td><input type="radio" id="rd1" name="rd" value="1" onclick="mostrar1(this.value)" />  </td>
                        </tr>
                        <tr>
                            <td><b><label class="radio-inline">Búsqueda por Palabra</label> </b></td>
                            <td><input type="radio" id="rd2" name="rd" value="2" onclick="mostrar1(this.value)" /> </td>
                        </tr>


                    </table>
                </div>
                <div id="div1" style="display: none">
                    <br>
                    <div class="form-group">
                        <label for="id1" class="col-lg-2 control-label">ID Producto</label>
                        <div class="col-lg-6">
                            <input type="text" class="form-control" name="id" id="id1" placeholder="ID Producto" />
                        </div>
                    </div>
                </div>
                <div id="div2" style="display: none">
                    <br>
                    <div class="form-group">
                        <label for="prod1" class="col-lg-2 control-label">Nombre Producto</label>
                        <div class="col-lg-6">
                            <input type="text" class="form-control" name="prod" id="prod1" placeholder="Nombre Producto" />
                        </div>
                    </div>
                </div>
                <div id="div3" style="display: none">
                    <div class="form-group">
                        <label for="precio1" class="col-lg-2 control-label">Precio</label>
                        <div class="col-lg-6">
                            <input type="text" class="form-control" name="precio" id="precio1" placeholder="Precio" />
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-lg-6 control-label">Categoría</label>
                        <div class="col-sm-6">
                            <select class="custom-select" name="cat" id="cat1" >
                                <option value="0">Selecione categoría</option>
                                <% for (Categoria c : categoria) {%>


                                <option value="<%= c.getCat_cod_categoria()%>"><%= c.getCat_nom_categoria()%></option>
                                <%}%>
                            </select>
                            <br>
                        </div> 
                    </div>

                    <input class="btn btn-success" type="submit" value="Guardar">
                </div>
                <input type="hidden" id="opc" name="opc1" value="0" />
                <div id="div4" style="display: none">
                    <br>

                    <input class="btn btn-success" type="submit" value="Buscar">
                </div>
                <br><br>
            </form>
        </div>
    </center>
</body>
</html>
