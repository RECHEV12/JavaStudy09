package ch16_network.socket;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

// 연결된 소켓 객체의 OutputStrtream에다 문구를 작성하여 보내는 클래스
public class SendThread extends Thread {
    private Socket soc; /*연결된 소켓 객체를 담을 그릇*/

    public SendThread(Socket soc) {
        this.soc = soc;
    }

    @Override
    public void run() {
        // 멀티 쓰레드로 일을 시키면 실행되는 영역
        // 콘솔창에 키보드로 입력한 내용을 소켓의 OutputStrtream에 입력 후 보내기

        Scanner scan = new Scanner(System.in);

        // 연결된 소켓의 OutputStrtream 가져오기

        try {
//            PrintWriter writer = new PrintWriter(new OutputStreamWriter(soc.getOutputStream(), "utf-8"));
            PrintWriter writer = new PrintWriter(soc.getOutputStream());

            System.out.print("닉네임 입력: ");
            String name = scan.nextLine();
            writer.println(name + "님이 입장하셨습니다.");
            writer.flush();


            while (true) {

                System.out.println(">>> ");
                String msg = scan.nextLine();
                System.out.println(msg);

                //소켓 통신 종료
                if (msg.equals("exit")) {
                    writer.println("exit");
                    writer.flush();
                    break;
                }

                //OutputStrtream에 텍스트 작성
                writer.println(name + ": " + msg);
                //전송
                writer.flush();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (soc != null) {
                try {
                    soc.close();
                } catch (IOException e) {
                }
            }

        }
    }
}