package ej2_synchronized_bankaccount;

public class Main {
    public static void main(String[] args) {
        /*
            Una cuenta bancaria tiene un saldo inicial de 1.000€
            Tres hilos representan cajeros automáticos donde diferentes
            usuarios intentan sacar dinero
            Cada hilo realizará 5 intentos de retirada con cantidades aleatorias
            entre 100 y 500€

            Requisitos:
            1.Crea una clase Cuentabancaria con:
            -atributo private int saldo
            -constructor con saldo inicial
            -método retirar()
                -si hay saldo suficient, retirar
                -si no, mostrar mensaje de saldo insuficiente
            2.Clase cajero:
              -Implementa Runnable
              -Recibe una referencia a la misma cuenta bancaria
              -en su run() tiene que hacer 5 retiradas
                    -generar una cantidad aleatoria entre 100 y 500
                    -llamar a retirar()
                    -dormir el hilo entre 300 y 400ms
            3. Main
                -Crear una sola cuenta con saldo 1000€
                -Crear tres hilos cajeros
                -Lanzarlos simultáneamente
         */

        Cuentabancaria cuenta = new Cuentabancaria(1000);
        Thread t1 = new Thread(new Cajero(cuenta), "Cajero-1");
        Thread t2 = new Thread(new Cajero(cuenta), "Cajero-2");
        Thread t3 = new Thread(new Cajero(cuenta), "Cajero-3");

        t1.start();
        t2.start();
        t3.start();



    }
}
