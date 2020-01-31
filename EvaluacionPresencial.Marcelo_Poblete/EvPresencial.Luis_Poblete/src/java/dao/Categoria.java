package dao;

public class Categoria {
    private int cat_cod_categoria;
    private String cat_nom_categoria;

    public Categoria(int cat_cod_categoria, String cat_nom_categoria) {
        this.cat_cod_categoria = cat_cod_categoria;
        this.cat_nom_categoria = cat_nom_categoria;
    }

    public int getCat_cod_categoria() {
        return cat_cod_categoria;
    }

    public void setCat_cod_categoria(int cat_cod_categoria) {
        this.cat_cod_categoria = cat_cod_categoria;
    }

    public String getCat_nom_categoria() {
        return cat_nom_categoria;
    }

    public void setCat_nom_categoria(String cat_nom_categoria) {
        this.cat_nom_categoria = cat_nom_categoria;
    }
    
}
