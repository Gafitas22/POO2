package cookmaster.builder;

import cookmaster.model.*;

public class PostreBuilder extends RecetaBuilder {

    @Override
    public void crearReceta(String nombre) {
        receta = new RecetaPostre(nombre);
    }

    @Override
    public void agregarIngrediente(String nombre, String cantidad) {
        receta.agregarIngrediente(new Ingrediente(nombre, cantidad));
    }

    @Override
    public void agregarPaso(String descripcion) {
        receta.agregarPaso(new Paso(descripcion));
    }
}
