package sub2;

import java.util.concurrent.atomic.AtomicInteger;

class AtomicCounter {
    private AtomicInteger count = new AtomicInteger();

    public void increment1() {
        count.incrementAndGet();
    }
    public int getCount() {
        return count.get();
    }
}


public class AtomicTest {
    public static void main(String[] args) throws InterruptedException {

        AtomicCounter counter = new AtomicCounter();
        Thread[] threads = new Thread[5];

        for (int i = 0; i < 5; i++) {
//            threads[i] = new Thread(() -> {
//                for (int j = 0; j < 1000; j++) {
//                    counter.increment1();
//                }
//            });
//            threads[i].start();
        }

        for (int i = 0; i < 5; i++) {
            threads[i].join();
        }
        System.out.println("최종 카운트 : " + counter.getCount());
    }
}
