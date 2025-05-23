package sub5;

import java.util.ArrayList;
import java.util.List;

public class MemoryProfilingTest {

    private static final List<byte[]> leakedList = new ArrayList<>();


    public static void main(String[] args) {

        printMemoryStatus("시작");
        // 메모리릭 연산 수행
        memoryLeakTask();
    }

    private static void memoryLeakTask() {

        System.out.println("메모리 누수 데모 시작...");
        for (;;) { // while True 무한반복
            // 고정된 크기의 리스트에 대형 객체 추가 (메모리 누수 시뮬레이션)
            byte[] leakyMemory = new byte[1024 * 1024]; // 1MB

            leakedList.add(leakyMemory);

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }

    /**
     * 현재 힙 메모리 상태 출력
     */
    private static void printMemoryStatus(String stage) {
        Runtime runtime = Runtime.getRuntime();
        long totalMemory = runtime.totalMemory(); // JVM이 운영체제로부터 할당받은 힙 메모리의 총량
        long freeMemory = runtime.freeMemory();   // 사용 가능한 메모리
        long usedMemory = totalMemory - freeMemory; // 사용 중인 메모리

        System.out.println("\n=== 메모리 상태 (" + stage + ") ===");
        System.out.println("총 할당 메모리: " + formatMemory(totalMemory));
        System.out.println("사용 중인 메모리: " + formatMemory(usedMemory));
        System.out.println("사용 가능한 메모리: " + formatMemory(freeMemory));
        System.out.println("최대 사용 가능 메모리: " + formatMemory(runtime.maxMemory()));
    }

    /**
     * 메모리 크기를 보기 좋게 포맷팅
     */
    private static String formatMemory(long bytes) {
        long kilobytes = bytes / 1024;
        long megabytes = kilobytes / 1024;
        return bytes + " 바이트 (" + megabytes + "MB)";
    }

    private static void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException ignored) {
        }
    }
}