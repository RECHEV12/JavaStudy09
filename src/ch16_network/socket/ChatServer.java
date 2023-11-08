package ch16_network.socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer {
    public static void main(String[] args) {
        // 소켓 통신
        // 소켓을 통해 서버와 클라이언트 간 데이터를 주고받는
        // 양방향 연결 지향 통신을 의미

        // 서버 소켓 생성

        try(   ServerSocket serverSocket = new ServerSocket(9001);) {

            // 9001 포트 번호로 서버를 열고 클라이언트의 요청 대기
            // 요청이 들어오면 해당 클라이언트와 연결된 Socket 객체 리턴
            Socket connectionSocket = serverSocket.accept();
            System.out.println("클라이언트 요청 수락 - 연결됨");
            // 연결된 상대방의 IP주소 확인
            System.out.println(connectionSocket.getRemoteSocketAddress());

            SendThread sendThread = new SendThread(connectionSocket);
            sendThread.start();

            ReceiveThread receiveThread = new ReceiveThread(connectionSocket);
            receiveThread.start();


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
