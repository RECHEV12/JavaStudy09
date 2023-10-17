package mygame;

import java.util.Scanner;

public class PlayMain {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Class user = new Class();

        LevelDB levelDB = new LevelDB();

        while (true) {
            System.out.println("===========================================");
            System.out.println("게임을 시작합니다.");
            System.out.println("직업을 선택해주세요");
            System.out.println("1. 전사 | 2. 마법사");
            System.out.print("숫자를 입력>>> ");
            int firstSelectClass = Integer.parseInt(scan.nextLine());

            System.out.println("플레이어의 이름을 입력해주세요");
            System.out.print("이름을 입력>>> ");
            String firstName = scan.nextLine();

            if (firstSelectClass == 1) {
                user = Class.getWarrior();
                user.setPlayerName(firstName);
                break;

            } else if (firstSelectClass == 2) {
                user = Class.getMagician();
                user.setPlayerName(firstName);
                break;

            } else {
                System.out.println("잘못 선택했습니다. 다시 선택해주세요");
                continue;
            }
        }

        while (true) {
            System.out.println("------ 계정 생성에 성공했습니다. 게임을 시작합니다! -----");
            System.out.println("행동을 선택해주세요");
            System.out.println("1. 필드에 나간다 | 2. 스테이터스를 확인한다");
            System.out.print("숫자를 입력>>> ");
            int command = Integer.parseInt(scan.nextLine());

            if (command == 1) {
                while (true) {

                    System.out.println("필드에서 할 행동을 선택해주세요");
                    System.out.println("1. 전투 | 2. 스테이터스를 확인한다 | 3. 이전으로");
                    System.out.print("숫자를 입력>>> ");
                    int command2 = Integer.parseInt(scan.nextLine());
                    if (command2 == 1) {

                        System.out.println("몬스터를 잡았다!");

                        if (user.getLv() < 40) {
                            user.setExp(user.getExp() + 200);
                            Class.levelUP(user, levelDB);
                        }
                        //레벨업




                    } else if (command2 == 2) {
                        System.out.println(user);
                    } else if (command2 == 3) {
                    }


                }


            } else if (command == 2) {
                System.out.println(user);

            }


        }
    }
}
