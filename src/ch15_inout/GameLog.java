package ch15_inout;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class GameLog {
    public static void main(String[] args) {

        // 강화게임

        Scanner scan = new Scanner(System.in);


        System.out.print("아이디 입력 : ");

        String id = scan.nextLine();

        int grade = 1;

        while (true) {
            System.out.println("현재 강화 상태 : " + grade);
            System.out.println("강화 성공 확률 : " + 1);
            System.out.println("1. 강화");
            System.out.println("2. 종료");
            System.out.print(">>> ");

            int command = Integer.parseInt(scan.nextLine());

            if (command == 1) {
                int rand = (int) (Math.random() * 100) + 1;

                if (rand <= 80) {
                    System.out.println("강화 성공");
                    grade++;
                    saveLog(id + "님이 " + grade + "강 강화에 성공하였습니다.");
                } else {
                    System.out.println("강화 실패");
                    saveLog(id + "님이 " + grade + "강 강화에 실패하였습니다.");
                }

            } else {
                break;
            }
        }


    }

    public static void saveLog(String log) {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

        try (FileWriter writer = new FileWriter("/home/pc12/stuList/gameLog.txt", true)) {
            writer.write(sdf.format(new Date()) + " || " + log + "\n");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
