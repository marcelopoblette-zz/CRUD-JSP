package modelo;

import java.util.List;

public interface Funciones {
    public String insertar(Object obj);
    public List<?> consultar();
    public List<?> consultarP(String parametro, String busqueda);
}
