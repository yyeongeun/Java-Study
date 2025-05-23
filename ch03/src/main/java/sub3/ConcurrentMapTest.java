package sub3;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;

public class ConcurrentMapTest {

    public static void main(String[] args) throws InterruptedException {

        // 스레드에 안전하지 않은 컬렉션
        Map<String, Integer> map = new HashMap<>();

        // 스레드에 안전한 컬렉션
//        Map<String, Integer> map = new ConcurrentMap<>();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                map.put("k-"+i,i); // 쓰기
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                System.out.println(map.get("k-"+i)); // 읽기
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        //map.forEach((k,v)->System.out.println(k+":"+v));
        System.out.println("Map 크기"+map.size());

    }
}
