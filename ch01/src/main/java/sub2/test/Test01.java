package sub2.test;

public class Test01 {

    public static void main(String[] args) {
        char var1 = 'A'; //빈칸 : char, int
        int  var2 = var1; // 아스키코드값 A=65
        char var3 = 'B';
        int  var4 = var1 + var3;

        System.out.println("var1 : " + var1);
        System.out.println("var2 : " + var2);
        System.out.println("var3 : " + var3);
        System.out.println("var4 : " + var4);

        int a = 10;
        int b = 5;
        System.out.println(a > b || a == b);       // true || false → true
        System.out.println(a < b && a == b);       // false && false → false

        System.out.println(a > b ^ a == 10);       // true ^ true → false
        System.out.println(a > b ^ a == b);        // true ^ false → true

        System.out.println(a == b & test(1));      // false & test(1) 실행 → test(1) 실행, false
        System.out.println(a == b && test(2));     // false && ... → 단락평가로 test(2) 실행 안됨, false

        System.out.println(b > 0 & (a / b > 0));   // true & true → true
        System.out.println(b > 0 && (a / b > 0));  // true && true → true
    }

    public static boolean test(int n) {
        System.out.println("test(" + n + ") 실행...");
        return true;
    }
}