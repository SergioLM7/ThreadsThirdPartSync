package ej1_synchronized;

public class Main {
    public static void main(String[] args) {
        ContadorSync contador = new ContadorSync();
        Thread hilo1 =  new Thread(contador, "Hilo-1");
        Thread hilo2 = new Thread(contador, "Hilo-2");

        hilo1.start();
        hilo2.start();

        try {
            hilo1.join();
            hilo2.join();
        } catch (InterruptedException e) {
            System.out.println("Error: " + e);
        }

        System.out.println("Valor final = " + contador.getContador());
    }
}
