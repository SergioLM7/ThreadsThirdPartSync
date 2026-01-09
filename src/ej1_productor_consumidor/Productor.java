package ej1_productor_consumidor;

public class Productor implements Runnable{
    private Buffer buffer;

    public Productor(Buffer buffer){
        this.buffer = buffer;
    }

    @Override
    public void run() {
        for(int i = 1; i <= 20; i++){
            buffer.produce(i);
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
