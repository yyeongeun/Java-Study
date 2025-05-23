package sub2.test;

class Artist{
    public String name;
    public String country;
    public int birth;

    public Artist(String name, String country, int birth){
        this.name = name;
        this.country = country;
        this.birth = birth;
    }

    @Override // Object 클래스의 toString() 메서드를 재정의(Oberride)
    // 객체를 출력할 때 자동으로 이 문자열이 사용됨
    public String toString() {
        return "Artist [name=" + name + ", country=" + country + ", birth=" + birth + "]";
    }
}

public class Test06 {
    public static void main(String[] args) {
        Artist[] famousArts = {
                new Artist("레오나르도 다빈치", "이탈리아", 1452),
                new Artist("미켈란젤로", "이탈리아", 1475),
                new Artist("빈센트 반 고흐", "네덜란드", 1853),
                new Artist("클로드 모네", "프랑스", 1840),
                new Artist("파블로 피카소", "스페인", 1881)
        };

        for (Artist art : famousArts) {
            System.out.println(art); //toString() 메소드 호출
        }
    }
}