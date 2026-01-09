package ej4_synchronized_personalized_lock;

public class Main {
    public static void main(String[] args) {
        /* Venta de 20 tickets con 5 clientes (hilos)

            Hay 20 entradas para un concierto.
            Cada cliente intentará comprar 1 entrada por turno, hasta que ya no queden.
            El recurso compartido es la cantidad de tickets.
            Se debe usar un lock personalizado para controlar el acceso.
        */

        TicketSystem system = new TicketSystem();

        Client cliente1 = new Client(system, "Cliente 1");
        Client cliente2 = new Client(system, "Cliente 2");
        Client cliente3 = new Client(system, "Cliente 3");
        Client cliente4 = new Client(system, "Cliente 4");
        Client cliente5 = new Client(system, "Cliente 5");

        Thread t1 = new Thread(cliente1);
        Thread t2 = new Thread(cliente2);
        Thread t3 = new Thread(cliente3);
        Thread t4 = new Thread(cliente4);
        Thread t5 = new Thread(cliente5);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();




    }
}
