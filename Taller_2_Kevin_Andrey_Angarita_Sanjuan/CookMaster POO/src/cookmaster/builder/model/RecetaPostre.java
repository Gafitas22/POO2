package cookmaster.model;

public class RecetaPostre extends Receta {
    public RecetaPostre(String nombre) {
        super(nombre);
        this.setTipo("Postre");
    }
}
