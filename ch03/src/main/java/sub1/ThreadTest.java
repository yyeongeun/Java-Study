package sub1;

class MyThread extends Thread {

    private String name;

    public MyThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        // 작업 스레드로 실행
        for (int i = 0; i < 10; i++) {
            System.out.println(name + "_스레드 실행..." + i);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println(name + "_스레드 종료...");
    }
}

public class ThreadTest {

    public static void main(String[] args) throws InterruptedException {
        // 스레드 객체 생성
        MyThread t1 = new MyThread("t1");
        MyThread t2 = new MyThread("t2");
        t1.setDaemon(true);
        t2.setDaemon(true);

        // 스레드 실행
        t1.start();
        t2.start();

        for (int i = 0; i < 5; i++) {
            System.out.println("메인 스레드 실행...."+i);
            Thread.sleep(1000);
        }

        System.out.println("main 종료....");
    }
}