package sub4;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

class SumTask extends RecursiveTask<Long> {
    private long[] array;
    private int start,end;
    private final int THRESHOLD = 100; // 작업 분할 기준

    public SumTask(long[] array, int start, int end){
        this.array = array;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        int length = end-start;

        // Fork/Join 분할 작업
        if(length < THRESHOLD){
            long sum=0;
            for (int i = start; i < end; i++){
                sum += array[i];
            }
            return sum;
        }else {
            int middle = (start + end)/2;

            SumTask leftTask = new SumTask(array, start, middle);
            SumTask rightTask = new SumTask(array, middle, end);

            leftTask.fork();

            long rightSum = rightTask.join();
            long leftSum = leftTask.join();

            return leftSum + rightSum;
        }
    }
}

public class ForkJoinTest {
    public static void main(String[] args) {

        long[] numbers = new long[1000];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = i + 1;
        }

        // Fork/Join을 실행하는 스레드 풀
        ForkJoinPool pool = new ForkJoinPool();

        SumTask task = new SumTask(numbers, 0, numbers.length);

        // 작업 실행 후 결과 대기
        long result = pool.invoke(task);

        // 결과 확인
        System.out.println(result);

        // 스레드풀 종료
        pool.shutdown();
    }
}