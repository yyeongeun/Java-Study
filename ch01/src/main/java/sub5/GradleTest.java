package sub5;

import com.google.gson.Gson;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.annotation.processing.Generated;

@Getter
@Setter
@ToString
class Person{
    private String name;
    private int age;
}

public class GradleTest {

    public static void main(String[] args) {
        Person p = new Person();
        p.setName("홍길동");
        p.setAge(20);
        System.out.println(p);

        Gson gson = new Gson();
        String json = gson.toJson(p);
        System.out.println(json);
    }
}