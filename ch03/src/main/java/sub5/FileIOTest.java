package sub5;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileIOTest {
    public static void main(String[] args) throws IOException {

        String source = "C:\\Users\\busan\\Desktop\\test.txt";
        String target = "C:\\Users\\busan\\Desktop\\test2.txt";

        // 스트림(파일 입출력)
        FileInputStream fis = new FileInputStream(source);
        FileOutputStream fos = new FileOutputStream(target);

        while(true) {
            // 파일 읽기
            int data = fis.read();

            if(data == -1){
                break;
            }

            // 파일 쓰기
            fos.write(data);
        }

        // 스트림 해제
        fis.close();
        fos.close();
    }
}
