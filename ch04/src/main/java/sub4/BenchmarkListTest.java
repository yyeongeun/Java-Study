package sub4;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.openjdk.jmh.runner.options.TimeValue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.Throughput) // 처리량 측정
@OutputTimeUnit(TimeUnit.SECONDS) // 초당 연산 수
@State(Scope.Thread) // 스레드 단위 상태
public class BenchmarkListTest {

    @Param({"1000", "10000"})
    private int size;

    private List<Integer> arrayList;
    private List<Integer> linkedList;

    @Setup()
    public void setup() {
        arrayList = new ArrayList<>();
        linkedList = new LinkedList<>();

        for (int i = 0; i < size; i++) {
            arrayList.add(i);
            linkedList.add(i);
        }
    }

    @Benchmark
    public int accessArrayList() {
        return arrayList.get(size / 2); // 중간 인덱스 접근, 인덱스로 직접 접근 O(1)
    }

    @Benchmark
    public int accessLinkedList() {
        return linkedList.get(size / 2); // 중간 인덱스 접근, 앞에서부터 노드를 순차적으로 탐색 O(n) (리스트 크기에 비례)
    }

    @Benchmark
    public List<Integer> arrayListAddFirst() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add(0, i); // 맨 앞에 삽입, ArrayList는 맨 앞에 삽입할 때 모든 요소를 밀어야 하므로 성능이 떨어짐, O(n)
        }
        return list;
    }

    @Benchmark
    public List<Integer> linkedListAddFirst() {
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < 100; i++) {
            list.add(0, i); // 맨 앞에 삽입, LinkedList는 맨 앞에 노드만 연결하면 되므로 **O(1)**의 시간 복잡도
        }
        return list;
    }



    public static void main(String[] args) throws RunnerException {

        // 전체 벤치마크 실행
        Options opt = new OptionsBuilder()
                .include(BenchmarkListTest.class.getSimpleName())
                .warmupIterations(3)
                .warmupTime(TimeValue.seconds(1)) // 기본 타임 10초 (엄청 오래 걸림) 그래서 기본 타임 1초 설정
                .measurementIterations(5)
                .measurementTime(TimeValue.seconds(1))
                .forks(1)
                .build();

        new Runner(opt).run();
    }
}