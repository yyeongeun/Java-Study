package sub2;

@FunctionalInterface
interface A {
    int method(int a, int b);
    // int method(int a, int b); -> 함수형 인터페이스는 하나의 메서드만 선언할 수 있다. 두 개 선언 못함!
}
@FunctionalInterface
interface B {
    void method(double a);
}
@FunctionalInterface
interface C {
    boolean method();
}
@FunctionalInterface
interface D {
    void method();
}
@FunctionalInterface
interface E {
    double method(double a);
}

// 람다식 기본 구조 () -> {};
public class LamdaTest {
    public static void main(String[] args) {
        A a1 = (a,b) -> a + b;        // A a1 = (a,b) -> {return a+b}; // 중괄호 생략 = RETURN
        B b1 = (a) -> System.out.println("a : " + a);
        B b2 = System.out::println; // :: 메소드 참조 연산자(람다식) // b1 = b2 같음
        C c1 = () -> true;
        C c2 = () -> false;
        D d1 = () -> {
            System.out.println("d1 running...");
        };
        D d2 = () -> System.out.println("d2 running...");
        E e1 = Math::ceil;
        E e2 = Math::floor;
        E e3 = Math::round;

        int r1 = a1.method(3, 4);
        int r2 = a1.method(5, 6);
        System.out.println("r1 = : " + r1);
        System.out.println("r2 = : " + r2);

        b1.method(1.0);
        b2.method(2.1);

        boolean r3 = c1.method();
        boolean r4 = c2.method();
        System.out.println("r3 = " + r3);
        System.out.println("r4 = " + r4);

        d1.method();
        d2.method();

        double r5= e1.method(1.2);
        double r6= e2.method(1.8);
        double r7= e3.method(1.5);
        System.out.println("r5 = " + r5);
        System.out.println("r6 = " + r6);
        System.out.println("r7 = " + r7);

    }
}