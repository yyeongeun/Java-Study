package sub5;

import jdk.jfr.MemoryAddress;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Scanner;

class Cilent {
    public static void main(String[] args) throws IOException {
        // 소켓 채널 생성 및 서버 연결
        SocketChannel cilent = SocketChannel.open();
        cilent.connect(new InetSocketAddress("localhost",5000));

        System.out.println("서버에 연결되었습니다. 메시지를 입력하세요.");

        ByteBuffer buffer = ByteBuffer.allocate(1024); //1KB
        Scanner scanner = new Scanner(System.in);

        while(true){
            System.out.print("> ");
            String message = scanner.nextLine();

            if(":q".equals(message)){
                break;
            }

            buffer.clear();
            buffer.put(message.getBytes());
            buffer.flip();
            cilent.write(buffer);
        }
        scanner.close();
        cilent.close();

        System.out.println("클라이언트 종료...");
    }
}

public class SocketChannelTest {
    public static void main(String[] args) throws IOException {

        // Selector 생성
        Selector selector = Selector.open();

        // 서버 생성
        ServerSocketChannel server = ServerSocketChannel.open();
        server.bind(new InetSocketAddress(5000));
        server.configureBlocking(false);

        // Selector에 접속 이벤트 등록
        server.register(selector, SelectionKey.OP_ACCEPT);

        System.out.println("서버 시작: 포트 5000에서 대기 중...");

        // 이벤트 감시 루프
        while (true) {

            System.out.println("이벤트 대기 중...");
            selector.select(); // 이벤트 발생까지 블로킹됨

            Iterator<SelectionKey> keys = selector.selectedKeys().iterator();

            while (keys.hasNext()) {

                SelectionKey key = keys.next();
                keys.remove(); // 반드시 제거!

                if (key.isAcceptable()) {
                    // 클라이언트 접속 처리
                    SocketChannel client = server.accept();
                    client.configureBlocking(false);
                    client.register(selector, SelectionKey.OP_READ); // SocketChannel(클라이언트)을 Selector에 등록하고 읽기 이벤트를 감지
                    System.out.println("클라이언트 접속");

                } else if (key.isReadable()) {
                    // 클라이언트 메시지 읽기
                    SocketChannel client = (SocketChannel) key.channel();
                    ByteBuffer buffer = ByteBuffer.allocate(1024); // ByteBuffer는 기본적으로 쓰기 모드
                    int bytesRead = client.read(buffer);

                    if (bytesRead == -1) {
                        // 연결 종료
                        client.close();
                        System.out.println("클라이언트 연결 종료");
                        continue;
                    }

                    buffer.flip(); // 쓰기 → 읽기 전환, 읽기 전환을 해야 buffer값 출력 가능
                    System.out.println("수신: " + new String(buffer.array(), 0, bytesRead));
                }
            }
        }
    }
}