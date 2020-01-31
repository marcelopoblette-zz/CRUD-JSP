package dao;

public class Producto {
    private int prod_codigo, prod_precio, prod_cod_categoria;
    private String prod_nombre;
    
    public Producto (){
    }

    public Producto(int prod_codigo, int prod_precio, int prod_cod_categoria, String prod_nombre) {
        this.prod_codigo = prod_codigo;
        this.prod_precio = prod_precio;
        this.prod_cod_categoria = prod_cod_categoria;
        this.prod_nombre = prod_nombre;
    }

    public int getProd_codigo() {
        return prod_codigo;
    }

    public void setProd_codigo(int prod_codigo) {
        this.prod_codigo = prod_codigo;
    }

    public int getProd_precio() {
        return prod_precio;
    }

    public void setProd_precio(int prod_precio) {
        this.prod_precio = prod_precio;
    }

    public int getProd_cod_categoria() {
        return prod_cod_categoria;
    }

    public void setProd_cod_categoria(int prod_cod_categoria) {
        this.prod_cod_categoria = prod_cod_categoria;
    }

    public String getProd_nombre() {
        return prod_nombre;
    }

    public void setProd_nombre(String prod_nombre) {
        this.prod_nombre = prod_nombre;
    }

    
}
