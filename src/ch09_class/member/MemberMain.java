package ch09_class.member;

import java.util.ArrayList;
import java.util.Scanner;

public class MemberMain {
    public static void main(String[] args) {
        // 회원가입/회원목록/로그인
        // 회원 : id, pw, Name -> Member
        // 회원관리 객체 : ArrayList<Member> memList

        MemberDB memDB = new MemberDB();

        System.out.println(memDB.getMemList());
        ArrayList<Member> memList = memDB.getMemList();

        Scanner scan = new Scanner(System.in);


        while (true) {
            System.out.println("행동을 선택해 주세요");
            System.out.println("1. 회원가입 | 2. 로그인 | 3. 회원목록 | 4. 종료");
            System.out.print(">>> ");

            int command = Integer.parseInt(scan.nextLine());

            if (command == 1) {
                // todo 회원가입
                System.out.print("id 입력: ");
                String inputId = scan.nextLine();

                System.out.println("pw 입력: ");
                String inputPw = scan.nextLine();

                System.out.println("이름 입력: ");
                String inputName = scan.nextLine();

                Member mem = new Member(inputId, inputPw, inputName);
                memList.add(mem);

            } else if (command == 2) {
                int count = 0;
                // todo 로그인
                System.out.print("id 입력: ");
                String inputId2 = scan.nextLine();

                System.out.print("pw 입력: ");
                String inputPw2 = scan.nextLine();

                for (int i = 0; i < memList.size(); i++) {
                    Member tmp = memList.get(i);
                    if (tmp.getId().equals(inputId2) && tmp.getPw().equals(inputPw2)) {
                        System.out.println("로그인성공, " + tmp.getName() + "님 환영합니다.");
                        count += 1;
                        break;
                    }
                }
                if (count == 0){
                    System.out.println("실패");
                }

            } else if (command == 3) {
                // todo 회원목록
                for (int i = 0; i < memList.size(); i++) {
                    System.out.println(memList.get(i));
                }

            } else if (command == 4) {
                // todo 종료
                System.out.println("시스템이 종료되었습니다");
                break;
            }
        }


    }
}
