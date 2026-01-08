package problema_sincronizacion_hilos;

public class Main {
    public static void main(String[] args) {
        Contador c =  new Contador();
        Thread hilo1 = new Thread(c);
        Thread hilo2 = new Thread(c);

        hilo1.start();
        hilo2.start();

        try {
            hilo1.join();
            hilo2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Valor final de contador = " + c.contador);
    }
}
