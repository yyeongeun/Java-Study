package sub2;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import sub1.Calc;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class JunitBasicTest {

    Calc calc = new Calc();

    @DisplayName("plus() 테스트")
    @Test
    public void test1(){
        //given 테스트 준비
        int num1 = 1;
        int num2 = 2;
        int expected = 3;

        // when - 테스트 실행
        int actual = calc.plus(num1,num2);

        // then - 테스트 검증
        assertEquals(expected,actual);
    }


    @DisplayName("minus() 테스트")
    @Test
    public void test2(){
        //given 테스트 준비
        int num1 = 1;
        int num2 = 2;
        int expected = -1;

        // when - 테스트 실행
        int actual = calc.minus(num1,num2);

        // then - 테스트 검증
        assertEquals(expected,actual);
    }

    @DisplayName("multiply() 테스트")
    @Test
    public void test3(){
        //given 테스트 준비
        int num1 = 2;
        int num2 = 3;
        int expected = 6;

        // when - 테스트 실행
        int actual = calc.multiply(num1,num2);

        // then - 테스트 검증
        assertEquals(expected,actual);
    }

    @DisplayName("divide() 테스트")
    @Test
    public void test4(){
        //given 테스트 준비
        int num1 = 4;
        int num2 = 2;
        int expected = 2;

        // when - 테스트 실행
        int actual = calc.divide(num1,num2);

        // then - 테스트 검증
        assertEquals(expected,actual);
    }

    // Junit 검증 메서드 실습
    @Test
    public void assertTest(){

        // 값이 같은지 확인
        assertEquals(5,2+3,"2+3은 5이다.");

        // 조건이 같은지 확인
        assertTrue(1>0,"1은 0보다 크다.");

        // 조건이 거짓인지 확인
        assertFalse(-1>0, "-1은 0보다 크다"); // 거짓이면 True 성공

        // 객체가 null인지 확인
        String str1 = null;
        assertNull(str1,"str1은 null 입니다.");

        // 객체가 null이 아닌지 확인
        String str2 = "hello";
        assertNotNull(str2,"str2는 null이 아닙니다.");

        // 배열이 같은지 확인
        int arr1[] = {1,2,3};
        int[] arr2 = {1,2,3};

        assertArrayEquals(arr1,arr2);

        /*
        // 특정 예외가 발생하는지 확인
        Exception e = assertThrows(Exception.class,()->{
            int result 1/0; // 예외 발생 실패
        });
        System.out.println(e.getMessage());


        // 시간 제한 확인
        assertTimeout(Duration.ofMillis(1000), () -> {

            // 1초 내에 로직이 완료되어야 됨
            Thread.sleep(2000); // 2초니까 실패
        });
         */

    }

}