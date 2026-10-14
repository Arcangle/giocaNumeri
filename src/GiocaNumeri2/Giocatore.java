package GiocaNumeri2;

public class Giocatore implements Runnable {
    private String nome;
    private String parola;
    private int punteggio;

    public Giocatore(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public String getParola() {
        return parola;
    }

    public void setParola(String parola) {
        this.parola = parola;
    }

    public int getPunteggio() {
        return punteggio;
    }

    public void setPunteggio(int punteggio) {
        this.punteggio = punteggio;
    }

    public void gioca() {
        long startTime = System.currentTimeMillis();

        Thread tCorrente = Thread.currentThread();
        System.out.println("ID Thread: " + tCorrente.getId());
        System.out.println("Stato Thread: " + tCorrente.getState());
        System.out.println("Priorita Thread: " + tCorrente.getPriority());
        System.out.println("Nome Thread: " + tCorrente.getName());

        int numero = 19;
        String parola = "Divertti";
        setParola(parola);

        for (int i = 0; i < numero; i++) {
            System.out.println("Giocatore : " + nome + " i: " + i);

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.err.println("Errore: il thread " + nome + " e' stato interrotto: " + e.getMessage());
                e.printStackTrace();
            }
        }

        setPunteggio(100);

        long elapsedTime = System.currentTimeMillis() - startTime;
        System.out.println("Giocatore : " + nome + " parola: " + getParola() + " punteggio: " + getPunteggio() + " | Tempo: " + elapsedTime + " ms");
    }

    public void comunica() {
    }

    @Override
    public void run() {
        gioca();
    }
}