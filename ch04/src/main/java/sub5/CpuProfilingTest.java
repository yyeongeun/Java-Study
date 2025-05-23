package sub5;

import java.util.ArrayList;
import java.util.List;

public class CpuProfilingTest {

    private static final int ITERATIONS = 1_000_000;
    private static final int SIZE = 1_000;

    public static void main(String[] args) {
        hardTask();
    }

    public static void hardTask(){
        List<Double> list = new ArrayList<>();
        for (int i = 0; i < SIZE; i++) {
            list.add(Math.random());
        }
        for (int i = 0; i < ITERATIONS; i++) {
            list.forEach(Math::sqrt);
        }

    }
}
