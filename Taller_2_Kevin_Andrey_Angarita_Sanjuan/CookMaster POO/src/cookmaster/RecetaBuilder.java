package cookmaster.builder;

import cookmaster.model.*;

public abstract class RecetaBuilder {
    protected Receta receta;

    public Receta getReceta() { return receta; }

    public abstract void crearReceta(String nombre);

    public abstract void agregarIngrediente(String nombre, String cantidad);

    public abstract void agregarPaso(String descripcion);

    public void setTiempo(int minutos) {
        receta.setTiempoPreparacion(minutos);
    }

    public void agregarAtributo(String clave, String valor) {
        receta.agregarAtributo(clave, valor);
    }
}
