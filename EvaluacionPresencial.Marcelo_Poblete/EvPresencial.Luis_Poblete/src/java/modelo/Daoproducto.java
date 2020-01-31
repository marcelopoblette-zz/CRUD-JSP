package modelo;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import dao.Producto;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Daoproducto implements Funciones {

    Dbconexion db = new Dbconexion();

    @Override
    public List<?> consultar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String insertar(Object obj) {
        String msj = "";
        Producto p = (Producto) obj;

        Connection con;
        PreparedStatement pst;
        String query = "INSERT INTO tbl_producto VALUES (?,?,?,?)";

        try {
            Class.forName(db.getDriver());
            con = (Connection) DriverManager.getConnection(db.getUrl(), db.getUsuario(), db.getClave());
            pst = (PreparedStatement) con.prepareStatement(query);

            pst.setInt(1, p.getProd_codigo());
            pst.setString(2, p.getProd_nombre());
            pst.setInt(3, p.getProd_precio());
            pst.setInt(4, p.getProd_cod_categoria());

            int nfilas = pst.executeUpdate();
            con.close();

            if (nfilas > 0) {
                msj = "Producto ingresado exitosamente";
            } else {
                msj = "Error no se ha podido registrar el producto";
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.getMessage();
            msj = "Error no se ha podido registrar el producto";
        }
        return msj;
    }

    @Override
    public List<?> consultarP(String parametro, String busqueda) {
        String query="";
        
        switch (busqueda){
            case "1":
                int parametro2 = Integer.parseInt(parametro);
                query = "SELECT * FROM tbl_producto WHERE prod_codigo=" + parametro2;
                break;
            case "2":
                query = "SELECT * FROM tbl_producto WHERE prod_nombre LIKE '%" + parametro + "%'";
                break;
        }
        List<Producto> datos = new ArrayList<>();
        Connection con;
        PreparedStatement pst;
        ResultSet rs;
        
        try {
            Class.forName(db.getDriver());
            con = (Connection) DriverManager.getConnection(db.getUrl(), db.getUsuario(), db.getClave());
            pst = (PreparedStatement) con.prepareStatement(query);
            rs = pst.executeQuery();
            while (rs.next()) {
                datos.add(new Producto(rs.getInt("prod_codigo"), rs.getInt("prod_precio"), rs.getInt("prod_cod_categoria"), rs.getString("prod_nombre")));
            }
        } catch (ClassNotFoundException | SQLException e) {
        }
        return datos;
    }

}
