package cookmaster.builder;

public class DirectorRecetas {
    private RecetaBuilder builder;

    public DirectorRecetas(RecetaBuilder builder) {
        this.builder = builder;
    }

    public void construirReceta(String nombre) {
        builder.crearReceta(nombre);
    }

    public RecetaBuilder getBuilder() {
        return builder;
    }
}
