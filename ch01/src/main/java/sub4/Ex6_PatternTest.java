package sub4;

import java.util.ArrayList;

public class Ex6_PatternTest {
    public static void main(String[] args) {
        Object obj = "문자열 데이터 입니다."; // 문자열도 Object로 취급 가능

        // 일반적인 방식
        if(obj instanceof String) { // 타입검사해서 str 일때만 해야 잠재적 위험 제거
            String str = (String) obj;
            System.out.println("문자열 길이 : " + str.length());
        }

        // 패턴 매칭 방식
        if(obj instanceof String str) { // 위에서 변수 하나만 선언
            System.out.println("문자열 길이 : " + str.length());
        }

        printInfo("Text");
        printInfo(100);
        printInfo(new ArrayList<String>());

    } // main() end

    public static void printInfo(Object obj) {
        if(obj instanceof String str) {
            System.out.println(str.toUpperCase());
        } else if (obj instanceof Integer num) {
            System.out.println(num * 2);
        } else {
            System.out.println(obj.getClass().getName());
        }
    }
}