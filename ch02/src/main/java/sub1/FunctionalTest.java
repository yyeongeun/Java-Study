package sub1;

@FunctionalInterface
interface Calculator {
    int add(int a, int b);
}

public class FunctionalTest {
    public static void main(String[] args) {
        // 람다식 정의
        Calculator calc = (a, b) -> {
            return a + b;
        };

        int sum1 = calc.add(1, 2);
        int sum2 = calc.add(2, 3);
        int sum3 = calc.add(4, 5);

        System.out.println("sum1 = " + sum1);
        System.out.println("sum2 = " + sum2);
        System.out.println("sum3 = " + sum3);

        // 고차함수 예제
        int result = operation(10,20,(a,b) -> a*b);
        System.out.println("result = " + result);

    } // end main

    // 고차함수
    public static int operation(int a, int b, Calculator calc) {
        return calc.add(a,b);
    }
}
