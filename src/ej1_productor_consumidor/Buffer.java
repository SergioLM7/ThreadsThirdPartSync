package ej1_productor_consumidor;

public class Buffer {
    private Integer data = null;

    public synchronized void produce(int value) {

        while(data != null) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        data = value;
        System.out.println("Productor produce -> " + value);
        notifyAll();
    }

    public synchronized int consume() {
        while(data == null) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        int value = data;
        data = null;

        System.out.println("Consumidor consume -> " + value);

        notifyAll();

        return value;
    }
}
