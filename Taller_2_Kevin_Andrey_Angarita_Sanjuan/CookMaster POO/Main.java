package cookmaster;

import cookmaster.model.*;
import cookmaster.singleton.LibroDeRecetas;
import cookmaster.builder.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("=== CookMaster – Sistema de Recetas ===\n");

        LibroDeRecetas libro = LibroDeRecetas.getInstance();

        System.out.println("Creando receta de tipo: POSTRE");

        RecetaBuilder builderPostre = new PostreBuilder();
        DirectorRecetas director = new DirectorRecetas(builderPostre);

        director.construirReceta("Tiramisú");
        builderPostre.agregarIngrediente("Café", "200 ml");
        builderPostre.agregarIngrediente("Mascarpone", "250 g");
        builderPostre.agregarIngrediente("Huevos", "3 unidades");
        builderPostre.agregarIngrediente("Azúcar", "80 g");

        builderPostre.agregarPaso("Preparar el café fuerte y dejar enfriar.");
        builderPostre.agregarPaso("Separar yemas y claras. Batir yemas con azúcar.");
        builderPostre.agregarPaso("Mezclar queso mascarpone con las yemas.");
        builderPostre.agregarPaso("Humedecer bizcochos en café y formar capas.");
        builderPostre.agregarPaso("Refrigerar mínimo 3 horas y espolvorear cacao.");

        builderPostre.setTiempo(40);
        builderPostre.agregarAtributo("Nivel de dulce", "Medio");
        builderPostre.agregarAtributo("Vegetariano", "Sí");

        Receta tiramisu = builderPostre.getReceta();
        libro.agregarReceta(tiramisu);

        System.out.println("→ Receta creada: " + tiramisu.getNombre());
        System.out.println("→ Ingredientes añadidos: " + tiramisu.getIngredientes().size());
        System.out.println("→ Pasos añadidos: " + tiramisu.getPasos().size());
        System.out.println("Receta guardada en el Libro de Recetas.\n");

        System.out.println("Creando receta de tipo: BEBIDA");

        RecetaBuilder builderBebida = new RecetaBuilder() {
            @Override
            public void crearReceta(String nombre) {
                receta = new Receta(nombre) {
                    { setTipo("Bebida"); }
                };
            }

            @Override
            public void agregarIngrediente(String nombre, String cantidad) {
                receta.agregarIngrediente(new Ingrediente(nombre, cantidad));
            }

            @Override
            public void agregarPaso(String descripcion) {
                receta.agregarPaso(new Paso(descripcion));
            }
        };

        DirectorRecetas director2 = new DirectorRecetas(builderBebida);
        director2.construirReceta("Limonada Natural");

        builderBebida.agregarIngrediente("Agua", "500 ml");
        builderBebida.agregarIngrediente("Limón", "3 unidades");
        builderBebida.agregarPaso("Exprimir los limones.");
        builderBebida.agregarPaso("Mezclar con agua y azúcar al gusto.");

        builderBebida.setTiempo(10);
        builderBebida.agregarAtributo("Tipo", "Bebida refrescante");

        Receta limonada = builderBebida.getReceta();
        libro.agregarReceta(limonada);

        System.out.println("→ Receta creada: " + limonada.getNombre());
        System.out.println("→ Ingredientes añadidos: " + limonada.getIngredientes().size());
        System.out.println("→ Pasos añadidos: " + limonada.getPasos().size());
        System.out.println("Receta guardada en el Libro de Recetas.\n");

        System.out.println("----------------------------------------");
        System.out.println("Listado de recetas registradas:");

        int index = 1;
        for (Receta r : libro.getRecetas()) {
            System.out.println(index++ + ". " + r.getNombre() + " (" + r.getTipo() + ") – Tiempo: " + r.getTiempoPreparacion() + " min");
        }

        System.out.println("----------------------------------------");
        System.out.println("Detalles del Libro de Recetas:");
        System.out.println("Total recetas almacenadas: " + libro.getRecetas().size());
        System.out.println("Instancia del libro: OK (Singleton activo)\n");

        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("\n=== Detalle de Receta ===");
            System.out.print("Ingrese número de receta a mostrar (0 para salir): ");
            int num = sc.nextInt();
            sc.nextLine();

            if (num == 0) break;

            if (num < 1 || num > libro.getRecetas().size()) {
                System.out.println("Número inválido.");
                continue;
            }

            Receta r = libro.getRecetas().get(num - 1);

            System.out.println("\nNombre: " + r.getNombre());
            System.out.println("Tipo: " + r.getTipo());
            System.out.println("Tiempo de preparación: " + r.getTiempoPreparacion() + " min");

            System.out.println("Ingredientes:");
            for (Ingrediente ing : r.getIngredientes()) {
                System.out.println(" - " + ing.getNombre() + ": " + ing.getCantidad());
            }

            System.out.println("Pasos:");
            for (Paso p : r.getPasos()) {
                System.out.println(" - " + p.getDescripcion());
            }

            System.out.println("Atributos extras:");
            for (String key : r.getAtributosExtra().keySet()) {
                System.out.println(" - " + key + ": " + r.getAtributosExtra().get(key));
            }

        } while (true);

        sc.close();
        System.out.println("Programa finalizado.");
    }
}
