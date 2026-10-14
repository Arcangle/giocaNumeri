package GiocaNumeri2;

public class GiocaNumeri2 {

    public static void main(String[] args) {
        long startTimeMain = System.currentTimeMillis();
        System.out.println("--- Inizio programma Main ---");

        Giocatore g1 = new Giocatore("Mario");
        Giocatore g2 = new Giocatore("Luigi");

        Thread t1 = new Thread(g1, g1.getNome());
        Thread t2 = new Thread(g2, g2.getNome());

        t1.start();

        try {
            System.out.println("Main in attesa per 5 secondi...");
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            System.err.println("Errore nell'attesa del thread main: " + e.getMessage());
            e.printStackTrace();
        }

        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            System.err.println("Errore nell'attesa della terminazione dei thread: " + e.getMessage());
            e.printStackTrace();
        }

        long elapsedTimeMain = System.currentTimeMillis() - startTimeMain;
        System.out.println("--- Fine programma Main (Tempo totale: " + elapsedTimeMain + " ms) ---");
    }
}