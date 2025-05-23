package sub4;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolTest {
    public static void main(String[] args) {
        // 스레드풀 생성
        ExecutorService pool = Executors.newFixedThreadPool(5);
        // Runnable 정의
        Runnable task1 = () -> {

            for (int i = 0; i < 10; i++) {
                System.out.println("task1 - "+i);
            }
        };
        Runnable task2 = () -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("task2 - "+i);
            }
        };
        Runnable task3 = () -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("task3 - "+i);
            }
        };

        // 작업 제출(스레드)
        pool.submit(task1);
        pool.submit(task2);
        pool.submit(task3);
    }
}