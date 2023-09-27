package ch05_controll;

import java.util.Scanner;

public class LoopWhile {
    public static void main(String[] args) {
        // while문
        for (int i = 0; i <= 10; i++) {
            System.out.println(i);
        }

        //소괄호 안이 true이면 조건이 false가 될때까지 중괄호 내부 코드 반복
        int i = 1;
        while (i <= 10) {//조건식
            System.out.println(i);
            i++;
        }

        int j = 1;
        for (; j <= 10; ) {
            System.out.println(j);
            j++;
        }
        //while 문으로 구구단 2단 출력
        int cu = 2;
        while (cu <= 9) {
            System.out.println("2 X " + cu + " = " + 2 * cu);
            cu++;
        }
        //for문은 반복횟수가 정해진 뚜렷한 경우에 좋고
        //while문은 반복횟수가 애매한 경우에 좋음

        System.out.println("\n=========================\n");

        Scanner Scan = new Scanner(System.in);

        boolean isrRun = true;

        // 사용자가 q를 입력하면 종료하게 만들기
//        while (isrRun){
//            System.out.print("채팅 입력 : ");
//            String inputText = Scan.nextLine();
//            if (inputText.equals("q")){
//                isrRun = false;
//            }
//            System.out.println(inputText);
//        }
//


//        while (true) {
//            System.out.print("채팅 입력 : ");
//            String inputText = Scan.nextLine();
//            if (inputText.equals("q")) {
//                //break 실행시 바로 반복이 종료된다.
//                break;
//            }
//            System.out.println(inputText);
//
//        }

        // do+whil문
        // 반복해야될 내용이 최소 1번은 무조건 실행되게끔 하고 싶을 때 사ㅏ용
        // 잘 사용 안함
        isrRun = false;
        do{
            System.out.println("반복될 내용");
        }while (isrRun);


        //while문 다중 사용 가능
        // 포켓몬스터
        int hp = 100;
        // 외부 while문의 이름이 outer가
        outer: while (true){
            System.out.println("야생의 피카츄를 만났습니다.");
            System.out.println("행동을 선택해 주세요");
            System.out.println("1. 공격 | 2. 도망");
            System.out.print(">>> ");

            int command = Integer.parseInt(Scan.nextLine());

            if (command == 1){
                // TODO 공격
                while (true){
                    System.out.println("공격 방법 선택");
                    System.out.println("1. 몸통박치기 | 2. 하이드로펌프 | 3.취소");
                    System.out.print(">>> ");

                    int attack = Integer.parseInt(Scan.nextLine());

                    if (attack == 1){
                        System.out.println("몸통박치기 시전");
                        hp -= 20;
                    }else if (attack == 2){
                        System.out.println("하이드로펌프 시전");
                        hp -= 40;
                    }else if (attack == 3){
                        //취소
                        //가까운 반복문 1개를 즉시종료
                        break;
                    }
                    if (hp <=0){
                        System.out.println("피카츄를 잡았다");
                        //외부 while문 종료
//                        System.exit(0); 프로그램 종료
                        //외부 while문의 네임태그 설정됨
                        break outer;
                    }

                }

            } else if (command == 2) {
                System.out.println("메다닥 도망갔습니다.");
                break;
            }else{
                System.out.println("잘못 입력하셨습니다.");
            }


        }












    }
}
