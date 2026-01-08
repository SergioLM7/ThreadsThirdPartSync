package ej3_synchronized_harrypotter;

public class Caldero {
    private int nivelIngredientes = 0;

    public synchronized void aniadirIngrediente(String alumno) {
        System.out.println(alumno + " añade un ingrediente.");

        try {
            Thread.sleep((int) (Math.random() * 701) + 300);
            nivelIngredientes++;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Nivel actual del caldero: " + nivelIngredientes);
    }

    public int getNivelIngredientes() {
        return nivelIngredientes;
    }
}
