package sub4;

public class Ex2_TextBlockTest {

    public static void main(String[] args) {

        String text1 = "<html>";
        text1 += "h2";
        text1 += "안녕하세요";
        text1 += "</h2>";
        text1 += "</html>";

        System.out.println(text1); // concat 문자열(문장) 출력

        // 템플릿 문자열
        String text2 = """
                <html>
                <h2>반갑습니다</h2>
                </html>
                """;
        System.out.println(text2);

    }
}
