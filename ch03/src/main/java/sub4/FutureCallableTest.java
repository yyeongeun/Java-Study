package sub4;

import java.util.concurrent.*;

public class FutureCallableTest {
    public static <Future1> void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executor = Executors.newFixedThreadPool(2);

        Callable<Integer> task1 = () -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("task1 done");
            return 10;
        };

        Callable<Integer> task2 = () -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("task1 done");
            return 20;
        };

        // Callable 실행 후 결과 객체 Future 반환
        Future<Integer> f1 = executor.submit(task1);
        Future<Integer> f2 = executor.submit(task2);

        // 각 스레드 반환값 대입(blocking)
        int result1 = f1.get();
        int result2 = f2.get();

        // 작업 결과 확인
        System.out.println("result1: " + result1);
        System.out.println("result2: " + result2);
    }
}