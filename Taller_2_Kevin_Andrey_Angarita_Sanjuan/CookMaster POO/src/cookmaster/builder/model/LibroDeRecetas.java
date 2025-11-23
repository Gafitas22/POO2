package cookmaster.singleton;

import cookmaster.model.Receta;
import java.util.ArrayList;
import java.util.List;

public class LibroDeRecetas {
    private static LibroDeRecetas instancia;
    private List<Receta> recetas = new ArrayList<>();

    private LibroDeRecetas() {}

    public static LibroDeRecetas getInstance() {
        if (instancia == null) {
            instancia = new LibroDeRecetas();
        }
        return instancia;
    }

    public void agregarReceta(Receta receta) {
        recetas.add(receta);
    }

    public List<Receta> getRecetas() {
        return recetas;
    }
}
