package problema_sincronizacion_hilos;

public class Contador implements Runnable {
    public int contador = 0;

    @Override
    public void run() {

        for(int i = 0; i < 100000; i++) {
            contador++;
        }

    }
}
