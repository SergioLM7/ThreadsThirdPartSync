package ej4_synchronized_personalized_lock;

public class MyLock {
    private boolean bloqueado = false;

    public synchronized void lock() throws InterruptedException {
        while (bloqueado) {
            wait();
        }
        bloqueado = true;
    }

    public synchronized void unlock() {
        bloqueado = false;
        notifyAll();
    }
}
