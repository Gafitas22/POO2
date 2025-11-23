package cookmaster.model;

public class Ingrediente {
    private String nombre;
    private String cantidad;

    public Ingrediente(String nombre, String cantidad) {
        this.nombre = nombre;
        this.cantidad = cantidad;
    }

    public String getNombre() { return nombre; }
    public String getCantidad() { return cantidad; }
}
