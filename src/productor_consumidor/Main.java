package productor_consumidor;

public class Main {
    public static void main(String[] args) {

        Buffer buffer = new Buffer(10);

        //No son hilos por sí mismos
        Productor productor = new Productor(buffer);
        Consumidor consumidor = new Consumidor(buffer);

        Thread hiloProductor =  new Thread(productor);
        Thread hiloConsumidor =  new Thread(consumidor);

        //Arrancamos los hilos
        hiloProductor.start();
        hiloConsumidor.start();



    }
}
