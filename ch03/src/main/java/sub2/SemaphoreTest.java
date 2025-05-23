package sub2;

import java.util.concurrent.Semaphore;
/*
    세마포어(Semaphore)
    - 세마포어는 동시에 접근하는 공유 자원 수를 제어하는 동기화 기법
    - 세마포어는 내부적으로 카운터 값, 대기 큐, 원자적 감소/증가 연산으로 동기화 처리
    - 화장실 3칸 비유
 */

class Printer {
    private Semaphore semaphore;

    public Printer(int availablePermits){
        //세마포어 초기화
        this.semaphore = new Semaphore(availablePermits);
    }

    public void printDocument(String documentName){
        try {
            semaphore.acquire(); // 프린터 사용권한 획득
            System.out.println(Thread.currentThread().getName() + ": " + documentName + "인쇄 시작...");

            Thread.sleep((long) (Math.random() * 1000));

            System.out.println(Thread.currentThread().getName() + ": " + documentName + "인쇄 종료...");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            semaphore.release(); // 프린트 사용 권한 반납
        }
    }

}

public class SemaphoreTest {
    public static void main(String[] args) throws InterruptedException {

        int availablePermits = 1;
        Printer printer = new Printer(availablePermits);

        Thread[] threads = new Thread[5];

        for (int i = 0; i < 5; i++) {
            String documentName = "문서"+i;
            threads[i] = new Thread(() -> {
                printer.printDocument(documentName);
            });

            threads[i].start();

        }

        for (int i = 0; i < 5; i++) {
            threads[i].join();
        }
        System.out.println("모든 인쇄 작업 완료...");

    }
}
