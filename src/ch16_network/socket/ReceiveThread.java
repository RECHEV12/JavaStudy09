package ch16_network.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

//연결된 소켓 객체의 inputStraem으로부터 전달받은 텍스트를 읽어다 출력해주는 클래스
public class ReceiveThread extends Thread {

    private Socket soc;

    public ReceiveThread(Socket soc) {
        this.soc = soc;
    }


    @Override
    public void run() {
        // 소켓의 inputStraem 가져오기
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(soc.getInputStream()));

            while (true) {
                //inputStraem 안에 있는 내용 읽기
                String inputMsg = reader.readLine(); //(SendThread에서 상대방에 wrihter.flush 할 때까지 대기)


                System.out.println(inputMsg); // 출력

                //넘어온 메시지가 exit이라면
                if ("exit".equals(inputMsg)){
                    break;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            if (soc != null){
                try {soc.close();} catch (IOException e) {}
            }
        }
    }
}
