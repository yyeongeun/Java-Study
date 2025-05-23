package sub1;

public class BasicTest {
    public static void main(String[] args) {

        // Calc 계산
        Calc clac = new Calc();

        if(clac.plus(1,2)==3){
            System.out.println("⭕plus(1,2) test success");
        }else{
            System.out.println("❌plus(1,2) test fail");
        }

        if(clac.minus(1,2)==-1){
            System.out.println("⭕minus(1,2) test success");
        }else{
            System.out.println("❌minus(1,2) test fail");
        }

        if(clac.multiply(2,3)==6){
            System.out.println("⭕multiply(2,3) test success");
        }else{
            System.out.println("❌multiply(2,3) test fail");
        }

        if(clac.divide(4,2)==2){
            System.out.println("⭕divide(4,2) test success");
        }else{
            System.out.println("❌divide(4,2) test fail");
        }

    }
}
