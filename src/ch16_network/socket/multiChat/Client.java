package ch16_network.socket.multiChat;

// 각 클라이언트와 연결된 소켓에 대해
// flush로 넘어온 데이터를 다른 소켓들에게 전달하는 클래스

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

public class Client extends Thread {
     Socket soc;

    public Client(Socket soc) {
        this.soc = soc;
    }


    @Override
    public void run() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(soc.getInputStream()));

            while (true) {
                // 상대방이 flush한 내용 받음
                String msg = reader.readLine();

                //연결된 모든 상대방들에게 전달
                ArrayList<Client> clientList = MutliChatServer.clientList;
                for (int i = 0 ; i < clientList.size(); i++){
                    Socket eachSocket = clientList.get(i).soc;
                    PrintWriter writer = new PrintWriter(eachSocket.getOutputStream());
                    writer.println(msg);
                    writer.flush();
                }
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
