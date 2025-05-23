package sub4;

class User1 {
    private String name;
    private int age;

    public User1(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

// record
record User2(String name, int age) {
}

public class Ex5_RecordTest {
    public static void main(String[] args) {

        User1 user1 = new User1("Jack", 20);
        System.out.println(user1);
        System.out.println("이름 : " + user1.getName());
        System.out.println("나이 : " + user1.getAge());

        User1 user3 = new User1("Jack", 20);
        System.out.println(user1.equals(user3)); // false

        User2 user2 = new User2("김춘추", 26);
        System.out.println(user2);
        System.out.println("이름 : " + user2.name());
        System.out.println("나이 : " + user2.age());

        User2 user4 = new User2("김춘추", 26);
        System.out.println(user2.equals(user4)); // true
        // record는 불변성을 유지한다. 하나의 오브젝트만 참고한다. user2 = user4
    }
}