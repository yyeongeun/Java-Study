package sub2;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Count {
    private int count = 0;
    private Lock lock = new ReentrantLock();

    // Lock 객체를 이용한 동기화
    public void increment() {
        lock.lock();

        count ++;
        System.out.println(Thread.currentThread().getName() + ": " + count);

        lock.unlock();
    }

    public int getCount() {
        return count;
    }
}

public class LockTest {
    public static void main(String[] args) throws InterruptedException {
        Count count = new Count();
        Runnable task = () -> {
            for (int i = 0; i < 1000; i++) {
                count.increment();
            }
        };

        Thread t1 = new Thread(task,"t1");
        Thread t2 = new Thread(task,"t2");

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(count.getCount());
    }
}