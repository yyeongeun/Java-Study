package sub2;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@ToString
@AllArgsConstructor
class Person {
    private String name;
    private int age;
}

public class StreamTest {
    public static void main(String[] args) {

        // 리스트 선언
        List<Integer> list = List.of(1,2,3,4,5,6,7,8,9,10);

        // 리스트 원소 출력
        for(int i=0; i<list.size(); i++){
            System.out.println("list element : " + list.get(i));
        }

        // 스트림을 이용한 출력(함수형 프로그래밍)
        list.stream().forEach((num)->{
            System.out.println(num);
        });

        list.forEach(System.out::println);

        // map() - 컬렉션 각 원소의 일괄 처리
        List<Integer> resultList = list.stream()
                                                .map((num)->{
                                                    return num * num;
                                                })
                                                .collect(Collectors.toList());
        System.out.println(resultList);

        // person 리스트 생성
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("김영은",25));
        persons.add(new Person("김영선",27));
        persons.add(new Person("박희숙",54));
        persons.add(new Person("김이태",59));
        persons.add(new Person("제상민",27));

        System.out.println(persons);

        // person 리스트 map() 연산 실습
        persons.stream().map((person)->{
                                                int age = person.getAge();
                                                return age;
                        }).forEach((age)->{
                                                System.out.println(age);
                        });

        // person 리스트 map() 연산
        persons.stream()
                        .map(Person::getAge)
                        .forEach(System.out::println);

        // mapToInt() - 최종 집계처리를 위한 map API
        int totalAge = persons
                        .stream()
                        .mapToInt((person) -> {
                            return person.getAge();
                        }).sum();
        System.out.println("totalAge : " + totalAge);

        // flatMap() - 컬렉션 데이터를 평탄화 작업
        List<String> fruits1 = List.of("Apple","Banana");
        List<String> fruits2 = List.of("Coconut","Grape");
        List<String> fruits3 = List.of("Orange","Mango");

        List<List<String>> fruitList = List.of(fruits1,fruits2,fruits3);

        List<String> resultList2 = fruitList.stream()
                                      .flatMap(list2 -> {

                                          List<String> list2List = list2.stream().map((fruit) ->{
                                              return fruit.toUpperCase();
                                          }).toList();

                                          return list2List.stream();

                                      })
                                      .collect(Collectors.toList());

        System.out.println(resultList2);
    }
}