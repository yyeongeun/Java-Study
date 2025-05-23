package sub4;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        // 비동기 작업 정의
        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> {

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            return 10;
        });

        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> {

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            return 20;
        });

        CompletableFuture<Integer> result = future1.thenCombine(future2, Integer::sum);
        System.out.println("결과 : " +result.get());

    }
}
