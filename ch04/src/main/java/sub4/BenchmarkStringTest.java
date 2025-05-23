package sub4;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.openjdk.jmh.infra.Blackhole;

import java.util.concurrent.TimeUnit;

/**
 * 문자열 연결 성능 비교 벤치마크
 * 플러그인 없이 직접 실행하는 방식
 */
@BenchmarkMode(Mode.AverageTime)            // 평균 시간 측정
@OutputTimeUnit(TimeUnit.MILLISECONDS)      // 결과 단위
@Warmup(iterations = 3, time = 1)           // 벤치마크 실행 전 JVM 워밍업
@Measurement(iterations = 5, time = 1)      // iterations: 벤치마크 측정 횟수, time: 각 벤치마크 실행시간(작은작업 1, 보통작업 5, 큰작업 10)
@Fork(1)                                    // 새로운 JVM 프로세스 생성 후 벤치마크 실행
@State(Scope.Thread)                        // 벤치마크 인스턴스 범위, 각 스레드마다 상태 객체 생성
public class BenchmarkStringTest {

    @Param({"100", "1000", "10000"})
    private int length;

    @Benchmark
    public void stringConcatenation(Blackhole blackhole) {
        String result = "";
        for (int i = 0; i < length; i++) {
            result += "a";
        }
        blackhole.consume(result);
    }

    @Benchmark
    public void stringBuilder(Blackhole blackhole) {
        StringBuilder sb = new StringBuilder(); // 스레드 안전하지 않지만 성능이 더 좋음
        for (int i = 0; i < length; i++) {
            sb.append("a");
        }
        blackhole.consume(sb.toString());
    }

    @Benchmark
    public void stringBuffer(Blackhole blackhole) {
        StringBuffer sb = new StringBuffer(); // 스레드 안전
        for (int i = 0; i < length; i++) {
            sb.append("a");
        }
        blackhole.consume(sb.toString());
    }


    public static void main(String[] args) throws RunnerException {

        // 전체 벤치마크 실행
        Options opt = new OptionsBuilder()
                .include(BenchmarkStringTest.class.getSimpleName())
                .build();

        new Runner(opt).run();
    }
}