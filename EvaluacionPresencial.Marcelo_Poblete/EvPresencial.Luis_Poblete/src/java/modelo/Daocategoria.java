package modelo;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import dao.Categoria;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Daocategoria implements Funciones {
    Dbconexion db = new Dbconexion();
    
    @Override
    public List<?> consultar() {
        List<Categoria> datos = new ArrayList<>();
        Connection con;
        PreparedStatement pst;
        ResultSet rs;
        String query = "SELECT * FROM tbl_categoria";
        try {
            Class.forName(db.getDriver());
            con = (Connection) DriverManager.getConnection(db.getUrl(), db.getUsuario(), db.getClave());
            pst = (PreparedStatement) con.prepareStatement(query);
            rs = pst.executeQuery();
            while(rs.next()){
            datos.add(new Categoria(rs.getInt("cat_cod_categoria"), rs.getString("cat_nom_categoria")));
            }
        } catch (ClassNotFoundException | SQLException e) {
        }  
        return datos;        
    }

    @Override
    public String insertar(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<?> consultarP(String parametro, String busqueda) {
        int parametro2 = Integer.parseInt(parametro);
        List<Categoria> datos = new ArrayList<>();
        Connection con;
        PreparedStatement pst;
        ResultSet rs;
        String query = "SELECT * FROM tbl_categoria WHERE cat_cod_categoria=" + parametro2;
        try {
            Class.forName(db.getDriver());
            con = (Connection) DriverManager.getConnection(db.getUrl(), db.getUsuario(), db.getClave());
            pst = (PreparedStatement) con.prepareStatement(query);
            rs = pst.executeQuery();
            while (rs.next()) {
                datos.add(new Categoria(rs.getInt("cat_cod_categoria"), rs.getString("cat_nom_categoria")));
            }
        } catch (ClassNotFoundException | SQLException e) {
        }
        return datos;
    }

}
