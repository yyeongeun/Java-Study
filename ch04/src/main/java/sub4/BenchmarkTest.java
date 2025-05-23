package sub4;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@State(Scope.Thread)
@Fork(value=1)
@Warmup(iterations=3, time= 1)
@Measurement(iterations=5, time= 1)
@OutputTimeUnit(TimeUnit.MICROSECONDS)

public class BenchmarkTest {

    @Param({"1000","10000"})
    private int size;

    public List<Integer> list;
    private Random random;

    @Setup
    public void setup(){
        list= new ArrayList<>(size);
        random = new Random();

        // 배열 초기화
        for(int i=0; i<size; i++){
            list.add(random.nextInt(10_000));
        }
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public List<Integer> testArraySortAverageTime(Blackhole blackhole){
        List<Integer> copyList = new ArrayList<>(size);
        Collections.sort(copyList);

        // Blackhole은 결과값을 '소비'해서 JIT 컴파일러가 해당 코드를 최적화하지 않도록 하기 위함
        blackhole.consume(copyList);

        return copyList;
    }


    /*
        Throughput 모드: 단위 시간당 처리량 측정
         - 초당 처리할 수 있는 작업 수(ops/sec) 측정
         - 처리량이 중요한 작업에 적합
     */
    @Benchmark
    @BenchmarkMode(Mode.Throughput)
    @OutputTimeUnit(TimeUnit.SECONDS)
    public List<Integer> testArraySortThroughput(Blackhole blackhole) {
        List<Integer> copyList = new ArrayList<>(list);
        Collections.sort(copyList);
        blackhole.consume(copyList);
        return copyList;
    }

    /*
        SampleTime 모드: 시간 표본 추출 측정
         - 실행 시간의 분포를 샘플링하여 측정
         - 시간 분포, 편차 등의 통계 정보 제공
     */
    @Benchmark
    @BenchmarkMode(Mode.SampleTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public int testLinearSearchSampleTime(Blackhole blackhole) {
        int searchValue = random.nextInt(100000);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == searchValue) {
                blackhole.consume(i);
                return i;
            }
        }
        return -1;
    }

    /*
        SingleShotTime 모드: 단일 실행 시간 측정
         - 한 번의 실행 시간을 밀리초 단위로 측정
         - 웜업 없이 콜드 스타트 성능을 측정하기 적합
         - SingleShotTime에서는 iteration이 단일 실행 횟수를 의미
     */
    @Benchmark
    @BenchmarkMode(Mode.SingleShotTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    @Measurement(iterations = 10)  // SingleShotTime에서는 iteration이 단일 실행 횟수
    @Warmup(iterations = 3)        // SingleShotTime에서의 웜업 횟수
    public double testMathOperationsSingleShot(Blackhole blackhole) {
        double result = 0;
        for (int i = 0; i < list.size(); i++) {
            result += Math.sqrt(list.get(i)) * Math.log(list.get(i) + 1);
            blackhole.consume(result);
        }
        return result;
    }

    //
    /*
        All 모드: 모든 측정 모드를 한 번에 실행
         - 단일 메서드에 대해 모든 벤치마크 모드를 적용
         - 다양한 관점에서 성능을 평가할 수 있음
     */
    @Benchmark
    @BenchmarkMode(Mode.All)
    public double testAllModes(Blackhole blackhole) {
        double result = 0;
        for (Integer value : list) {
            result += Math.sin(value) + Math.cos(value);
            blackhole.consume(result);
        }
        return result;
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(BenchmarkTest.class.getSimpleName())
                .build();

        new Runner(opt).run();
    }
}