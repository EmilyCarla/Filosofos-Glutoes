import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Garfo {
    private final Lock lock = new ReentrantLock();

    public boolean pegar() {
        return lock.tryLock();  // Retorna true se conseguiu pegar o garfo, false se não conseguiu
    }

    public void soltar() {
        lock.unlock();
    }
}