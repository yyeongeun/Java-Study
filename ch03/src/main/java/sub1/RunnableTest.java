package sub1;

class MyRunnable implements Runnable {

    private String name;
    private int count;

    public MyRunnable(String name) {
        this.name = name;
        this.count = 0;
    }
    public int getCount() {
        return count;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            count++;
            System.out.println(name + "_Thread...");
        }
        System.out.println(name + "_Thread End!");
    }
}

public class RunnableTest {
    public static void main(String[] args) throws InterruptedException {
        // Runnable 생성
        MyRunnable run1 = new MyRunnable("run1");
        MyRunnable run2 = new MyRunnable("run2");
        // Thread 생성
        Thread t1 = new Thread(run1);
        Thread t2 = new Thread(run2);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        int count1 = run1.getCount();
        int count2 = run2.getCount();
        System.out.println("count1: " + count1);
        System.out.println("count2: " + count2);

        // 람다식을 이용한 스레드
        Runnable r1 = () ->{
            for (int i = 0; i < 10; i++) {
                System.out.println("r1_Thread..."+i);
            }
            System.out.println("r1_Thread End!");
        };
        Runnable r2 = () ->{
            for (int i = 0; i < 10; i++) {
                System.out.println("r2_Thread..."+i);
            }
            System.out.println("r2_Thread End!");
        };

        // 스레드 생성
        Thread th1 = new Thread(run1);
        Thread th2 = new Thread(run2);

        th1.start();
        th2.start();

        System.out.println("Main Thread End!");

    }
}