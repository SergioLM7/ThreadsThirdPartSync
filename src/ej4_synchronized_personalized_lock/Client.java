package ej4_synchronized_personalized_lock;

public class Client implements Runnable {
    private TicketSystem system;
    private String name;

    public Client(TicketSystem system, String name) {
        this.system = system;
        this.name = name;
    }

    @Override
    public void run() {
        boolean comprado = true;
        while(comprado) {
            comprado = system.comprarTickets(name);

            if(!comprado) {
                System.out.println(name + " -> No quedan tickets disponibles.");
            }

            try {
                Thread.sleep((int) (Math.random() * 200) + 100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

}
