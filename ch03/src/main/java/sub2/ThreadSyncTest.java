package sub2;

class Counter {
    private int count = 0;

    // 동기화가 안된 메서드 => total count = 1696
    public void increment1() {
        count ++;
    }

    // 동기화가 된 메서드 => total count = 2000
    public synchronized void increment2() {
        count ++;
    }

    // 동기화 블록을 갖는 메서드 => total count = 2000
    public  void increment3() {
        synchronized (this){
            count ++;
        }
    }


    public int getCount() {
        return count;
    }
}

public class ThreadSyncTest {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        // 스레드 생성
        Thread t1 = new Thread(()->{
            for (int i = 0; i < 1000; i++) {
                counter.increment3();
            }
        });
        Thread t2 = new Thread(()->{
            for (int i = 0; i < 1000; i++) {
                counter.increment3();
            }
        });

        // 스레드 실행
        t1.start();
        t2.start();

        // 스레드 대기(블록킹, 메인 스레드가 자식 스레드 종료를 기다림)
        t1.join();
        t2.join();

        // 결과 확인(2000이 정상)
        System.out.println("total count = " +counter.getCount());
    }
}