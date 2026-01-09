package productor_consumidor;

public class Productor implements Runnable {
    private Buffer buffer;
    private final String letras = "abcdefghijklmnsopqrstuvwxyz";

    public Productor(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        while (true) {
            //Cogemos una letra aleatoria y la asignamos a c
            char c = letras.charAt((int) (Math.random() * letras.length()));

            buffer.produce(c);
            System.out.println("Depositando el caracter " + c + " en el buffer.");

            try {
                Thread.sleep((int) (Math.random() * 4000));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
