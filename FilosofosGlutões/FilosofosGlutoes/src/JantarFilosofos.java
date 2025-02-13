public class JantarFilosofos {
    public static void main(String[] args) {
        int N = 5;
        Garfo[] garfos = new Garfo[N];
        Filosofo[] filosofos = new Filosofo[N];

        for (int i = 0; i < N; i++) {
            garfos[i] = new Garfo();
        }

        for (int i = 0; i < N; i++) {
            filosofos[i] = new Filosofo(i, garfos[i], garfos[(i + 1) % N]);
            filosofos[i].start();
        }
    }
}
