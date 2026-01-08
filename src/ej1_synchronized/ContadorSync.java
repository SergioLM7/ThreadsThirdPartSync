package ej1_synchronized;

public class ContadorSync implements Runnable {
    private int contador = 0;

    @Override
    public void run() {
        for(int i = 0; i < 5; i++) {
            incrementar();
        }
    }

    public synchronized void incrementar() {
        int c = contador;
        System.out.println(Thread.currentThread().getName() + " leyendo: " + c);
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        contador = c + 1;
        System.out.println(Thread.currentThread().getName() + " escribiendo: " + contador);
    }

    public int getContador() {
        return contador;
    }
}
