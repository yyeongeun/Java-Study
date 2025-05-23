package sub3;

import java.lang.ref.Cleaner;

class MyObject {
    private int id;

    // cleaner 생성
    private static final Cleaner cleaner = Cleaner.create();
    private final Cleaner.Cleanable cleanable;

    public MyObject(int id) {
        this.id = id;
        this.cleanable = cleaner.register(this, new CleanTask(id));
    }

    // 카비지컬렉터 정리작업 메서드
    public static class CleanTask implements Runnable {
        private final int id;

        public CleanTask(int id) {
            this.id = id;
        }

        @Override // 스레드 메서드
        public void run() {
            System.out.println(id+"번 객체 해제...");
        }
    }
}

public class GCTest {

    public static void main(String[] args) {

        MyObject myObject1 = new MyObject(1);
        MyObject myObject2 = new MyObject(2);

        myObject1 = null;
        myObject2 = null;

        System.gc(); // 가비지 컬렉터 유도

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}