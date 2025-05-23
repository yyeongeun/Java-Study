package sub2.test;

import java.util.Scanner;

public class Test03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // 사용자가 입력하는 변수 Scanner

        System.out.print("숫자 입력 : ");
        int n = sc.nextInt();
        int sum = 0;
        for (int i=1; i<=n; i++){
            int fact = 1;
            for (int j=2; j<=i; j++){
                fact *=j;
            }
            sum += fact; //빈칸
            System.out.printf("%2d! = %,10d\n", i, fact);
        }
        System.out.printf("1! + 2! + ... + %d! = %,d\n", n, sum);
    }
}