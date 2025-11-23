package cookmaster.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Receta {
    protected String nombre;
    protected String tipo;
    protected int tiempoPreparacion;

    protected List<Ingrediente> ingredientes = new ArrayList<>();
    protected List<Paso> pasos = new ArrayList<>();
    protected Map<String, String> atributosExtra = new HashMap<>();

    public Receta(String nombre) {
        this.nombre = nombre;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setTiempoPreparacion(int tiempo) {
        this.tiempoPreparacion = tiempo;
    }

    public void agregarAtributo(String clave, String valor) {
        atributosExtra.put(clave, valor);
    }

    public void agregarIngrediente(Ingrediente ing) {
        ingredientes.add(ing);
    }

    public void agregarPaso(Paso paso) {
        pasos.add(paso);
    }

    public String getNombre() { return nombre; }

    public String getTipo() { return tipo; }

    public int getTiempoPreparacion() { return tiempoPreparacion; }

    public List<Ingrediente> getIngredientes() { return ingredientes; }

    public List<Paso> getPasos() { return pasos; }

    public Map<String, String> getAtributosExtra() { return atributosExtra; }
}
