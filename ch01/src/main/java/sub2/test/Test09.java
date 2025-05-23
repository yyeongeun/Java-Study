package sub2.test;

enum Gender {
    MALE, FEMALE
}
class Man {
    public void print() {
        System.out.println("남자 입니다.");
    }
}
class Woman {
    public void print() {
        System.out.println("여자 입니다.");
    }
}

public class Test09 {
    public static void main(String[] args) {
        Object human1 = makeHuman(Gender.MALE); // 최상위클래스 object로 선언
        Object human2 = makeHuman(Gender.FEMALE);

        if (human1 instanceof Man) {
            Man man = (Man) human1;
            man.print();
        }
        if (human2 instanceof Woman woman) { //Woman이 맞다면 woman으로 형변환까지
            woman.print();
        }
    }

    public static Object makeHuman(Gender gender) {
        if (gender == Gender.MALE) {
            return new Man();
        } else if (gender == Gender.FEMALE) {
            return new Woman();
        }
        return null;
    }
}