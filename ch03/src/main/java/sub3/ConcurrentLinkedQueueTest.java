package sub3;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/*
    리스트 비교
    - 읽기 중심 -> CopyWriteArrayList
    - 쓰기 중심 -> ConcurrentLinkedQueue
 */

public class ConcurrentLinkedQueueTest {
    public static void main(String[] args) throws InterruptedException {
        // 스레드에 안전하지 않은 컬렉션
        //List<String> list= new LinkedList<>();
        // 스레드에 안전한 컬렉션
        Queue<String> list= new ConcurrentLinkedQueue<>();

        Runnable runnable = () -> {
            for (int i=0;i<100;i++) {
                String value = Thread.currentThread().getName() +"-"+i;
                list.add(value);
            }
        };

        Thread t1 = new Thread(runnable, "t1");
        Thread t2 = new Thread(runnable, "t2");

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        for(String value : list){
            System.out.println(value);
        }
        System.out.println(list.size());

    }
}
