package ej2_synchronized_bankaccount;

public class Cuentabancaria {
    private int saldo;

    public Cuentabancaria(int saldo) {
        this.saldo = saldo;
    }

    public synchronized void retirar(int valor) {
        String hilo = Thread.currentThread().getName();
        if (valor > saldo) {
            System.out.println("Saldo insuficiente: " + saldo + "€. No se puede realizar la operación solicitada con valor " + valor + "€.");
        } else {
            System.out.println(hilo + " va a retirar " + valor + "€");
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            saldo -= valor;
            System.out.println(hilo + " ha retirado " + valor + "€. Saldo restante = " + saldo + "€");
        }
    }
}
