package sub4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Ex1_VarTest {

    public static void main(String[] args) {

        String name = "홍길동";

        // var 타입으로 변수 선언
        var age = 25;
        var price = 25.0; // 실수 float price = 25.0f

        var list = new ArrayList<String>();
        list.add("서울");
        list.add("대전");
        list.add("대구");
        list.add("부산");
        list.add("광주");

        for(var city : list){
            System.out.println(city);
        }

        var map = new HashMap<String, List<String>>();

        var seoulList = new ArrayList<String>();
        seoulList.add("강남");
        seoulList.add("신촌");
        seoulList.add("홍대");

        var busanList = new ArrayList<String>();
        busanList.add("서면");
        busanList.add("수영");
        busanList.add("경대");
        //map.put("seoul",)

    }

}
