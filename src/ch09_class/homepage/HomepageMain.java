package ch09_class.homepage;

import java.util.Scanner;

public class HomepageMain {

    public static void main(String[] args) {
        // 회원가입, 로그인, 회원 목록
        // 로그인 후 게시판 진입
        // 글목록, 글쓰기, 글조회
        // 회원 : 아이디 비밀번호 닉네임
        // 게시글: 글 번호, 글제목, 글내용, 작성자(닉네임

        // 회원가입 할 때마다 Member 객체를 생성하고
        // 생성된 Member객체들은 MemberDB안에 담는다.
        // MemberDB는 한 번만 생성됨 - 싱글톤(Singleton) 패턴 적용

        MemberDB memDB = MemberDB.getInstance();
        BoardDB borDB = BoardDB.getInstance();

        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.println("**행동을 선택해 주세요**");
            System.out.println("1. 회원가입 | 2. 로그인 | 3. 회원목록 | 4. 종료");
            System.out.print(">>> ");

            int command = Integer.parseInt(scan.nextLine());

            if (command == 1) {
                // TODO 회원가입
                System.out.println("아이디를 입력해주세요");
                System.out.print(">>> ");
                String inputID = scan.nextLine();

                System.out.println("비밀번호를 입력해주세요");
                System.out.print(">>> ");
                String inputPW = scan.nextLine();

                System.out.println("닉네임을 입력해주세요");
                System.out.print(">>> ");
                String inputName = scan.nextLine();

                Member mem = new Member(inputID, inputPW, inputName);

                // 회원가입시 중복된 아이디를 입력했다면 회원가입을 진행시키지 않음

                int result = memDB.signUp(mem);
                if (result == 1) {

                    System.out.println("회원가입에 성공했습니다. 로그인 해주세요");
                } else {
                    System.out.println("회원 가입 실패!! 중복된 아이디 입니다");
                }


            } else if (command == 2) {
                // TODO  로그인
                System.out.println("아이디를 입력해주세요");
                System.out.print(">>> ");
                String inputID = scan.nextLine();

                System.out.println("비밀번호를 입력해주세요");
                System.out.print(">>> ");
                String inputPW = scan.nextLine();

                Member result = memDB.login(inputID, inputPW);
                if (result != null) {
                    System.out.println("로그인 성공! " + result.getName() + "님, 환영합니다.");
                    // 게시판 진입
                    while (true){
                        // 게시물 목록 출력
                        borDB.showBoard();
                        System.out.println("**행동을 선택해 주세요**");
                        System.out.println("1. 글쓰기 | 2. 글보기 | 3. 로그아웃");
                        System.out.print(">>> ");
                        int select = Integer.parseInt(scan.nextLine());
                        if (select == 1){
                            System.out.print("글 제목 입력 : ");
                            String inputTitle = scan.nextLine();

                            System.out.print("글 내용 입력 : ");
                            String inputContent = scan.nextLine();

                            borDB.writeBoard(inputTitle, inputContent, result.getName());
                        }
                        else if (select == 2){
                            System.out.print("글 번호 입력 : ");
                            int no = Integer.parseInt(scan.nextLine());

                            borDB.readBoard(no);

                        }
                        else if (select == 3){
                            System.out.println("로그아웃 합니다.");
                            break;

                        }else {
                            System.out.println("잘못 입력하셨습니다.");
                        }
                        //




                    }






                } else {
                    System.out.println("로그인 실패! 아이디와 비밀번호를 다시 입력해주세요");
                }

            } else if (command == 3) {
                // TODO 회원목록
                memDB.showMemList();
            } else if (command == 4) {
                // TODO 종료
                System.out.println("종료하였습니다.");
                break;
            } else {
                System.out.println("잘못 입력하셨습니다.");
            }









        }
    }
}
