package productor_consumidor;

//Recurso compartido por Consumidores y Productores
public class Buffer {
    private char[] buffer;
    private int next; //Va a indicar cuántos elementos hay en el buffer y me va a indicar el siguiente hueco libre.

    private boolean isFull; // Si es true, no se puede producir más porque el buffer está lleno
    private boolean isEmpty; //Si es true, no se puede consumir más porque el buffer está vacío

    public Buffer(int size) {
        buffer = new char[size];
        next = 0;
        isFull = false;
        isEmpty = true;
    }

    public synchronized char consume() {
        while(isEmpty) {
            try {
                wait(); //Dado que está vacío, no se puede consumir
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        next--;

        if(next == 0) {
            isEmpty = true;
        }

        isFull = false;
        notifyAll();

        return buffer[next];
    }

    public synchronized void produce(char c) {

        while(isFull) {
            try {
                wait(); //Dado que está lleno, no se puede producir
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        buffer[next] = c;
        next++; //Avanzamos el índice para marcar el nuevo hueco disponible

        if(next == this.buffer.length) {
            isFull = true;
        }

        isEmpty = false;

        notifyAll(); //Despertamos a todos los hilos bloqueados
    }


}
