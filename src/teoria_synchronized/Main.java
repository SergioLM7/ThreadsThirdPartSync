package teoria_synchronized;

public class Main {
    public static void main(String[] args) {
        Cuenta cuenta1 =  new Cuenta();
        Cuenta cuenta2 = new Cuenta();
    }

    //Método sincronizado
    public synchronized void incrementar() {
        int contador = 0;
        contador++;
    }

    //Bloque sincronizado
    public void incrementar2() {
        int contador = 0;
        synchronized (this) {
            contador++;
        }
    }

    //Método estático sincronizado
    public static synchronized void log(String mensaje) {
        System.out.println(mensaje);
    }
}
