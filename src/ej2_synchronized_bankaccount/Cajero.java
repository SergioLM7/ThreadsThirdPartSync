package ej2_synchronized_bankaccount;

public class Cajero implements Runnable{
    private Cuentabancaria cuentabancaria;

    public Cajero(Cuentabancaria cuentabancaria) {
        this.cuentabancaria = cuentabancaria;
    }

    @Override
    public void run() {

        for (int i = 0; i < 5; i++) {
            int cantidad = (int) (Math.random() * 401) + 100; //número aleatorio entre 100 y 500
            cuentabancaria.retirar(cantidad);

            int sleepTime = (int) (Math.random() * 501) + 300; //número aleatorio entre 300 y 500

            try {
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }


    }
}
