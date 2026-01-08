package ej3_synchronized_harrypotter;

public class Alumno implements Runnable {
    private String nombre;
    private Caldero caldero;

    public Alumno(String nombre, Caldero caldero) {
        this.nombre = nombre;
        this.caldero = caldero;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            caldero.aniadirIngrediente(nombre);
        }
    }
}
