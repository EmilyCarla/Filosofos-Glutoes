import java.util.Random;

class Filosofo extends Thread {
    private final int id;
    private final Garfo esquerdo, direito;
    private final Random random = new Random();

    public Filosofo(int id, Garfo esquerdo, Garfo direito) {
        this.id = id;
        this.esquerdo = esquerdo;
        this.direito = direito;
    }

    private void pensar() throws InterruptedException {
        System.out.println("Filósofo " + id + " está pensando...");
        Thread.sleep(random.nextInt(1000));  // Tempo aleatório para evitar padrão fixo
    }

    private void comer() throws InterruptedException {
        System.out.println("Filósofo " + id + " está comendo...");
        Thread.sleep(random.nextInt(1000));
    }

    @Override
    public void run() {
        try {
            while (true) {
                pensar();
                
                // Para evitar impasse, o último filósofo pega os garfos na ordem inversa
                boolean pegouEsquerdo = id == 4 ? direito.pegar() : esquerdo.pegar();
                if (!pegouEsquerdo) continue;

                boolean pegouDireito = id == 4 ? esquerdo.pegar() : direito.pegar();
                if (!pegouDireito) {
                    (id == 4 ? direito : esquerdo).soltar(); // Solta o garfo já pego
                    continue;
                }

                comer();
                
                // Libera os garfos após comer
                esquerdo.soltar();
                direito.soltar();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
