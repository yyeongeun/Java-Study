package sub5;


import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.SortedMap;

public class FileNIOTest {
    public static void main(String[] args) throws IOException {

        Path sourcepath = Path.of("C:\\Users\\busan\\Desktop\\test.txt");
        Path targetpath = Path.of("C:\\Users\\busan\\Desktop\\test2.txt");

        // 채널 생성
        FileChannel sourceChanner = FileChannel.open(sourcepath, StandardOpenOption.READ);
        FileChannel targetChanner = FileChannel.open(targetpath, StandardOpenOption.WRITE, StandardOpenOption.CREATE);

        // 버퍼 생성
        ByteBuffer buffer = ByteBuffer.allocate(1024); // 1KB

        while (true) {
            int read = sourceChanner.read(buffer);
            if(read == -1){
                break;
            }
            buffer.flip(); // 쓰기 모드를 읽기 모드로 전환
            targetChanner.write(buffer);
            buffer.clear();
        }

        // 채널 닫기
        sourceChanner.close();
        targetChanner.close();

        System.out.println("Done");
    }
}