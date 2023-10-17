package mygame;

import java.util.Scanner;

public class PlayMain {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Class user = new Class();

        LevelDB levelDB = LevelDB.getInstance();

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
        System.out.println("------ 계정 생성에 성공했습니다. 게임을 시작합니다! -----");
        System.out.println("알아두면 좋은 정보");
        System.out.println("STR은 힘, DEX는 회피율, INT는 지능, LUK는 운을 나타내며");
        System.out.println("LUK를 제외한 스탯은 스킬과 기본공격 대미지에 영향을 줍니다.");
        System.out.println("LUK을 100 달성 시, 모든 공격이 치명타가 됩니다.");
        //todo 구현기능 : 장비, 몬스터, 대미지 계산식, 아이템 드롭(무기, 회복약), 아이템 사용, 각종 상태이상, 필드 증가
        while (true) {
            System.out.println("※※태초 마을※※");
            System.out.println("※※행동을 선택해주세요※※");
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
                        //경험치 추가 기믹
                        if (user.getLv() < 40) {
                            user.setExp(user.getExp() + 200);
                        }
                        //레벨업 기
                        if (user.getExp() > user.getNextExp()){
                            Class.levelUP(user, levelDB);
                        }

                    } else if (command2 == 2) {
                        System.out.println(user);

                    }else if (command2 == 3) {
                        System.out.println("마을로 이동합니다.");
                        break;

                    }else {
                        System.out.println("잘못 선택했습니다. 다시 선택해주세요");
                        continue;
                    }


                }


            } else if (command == 2) {
                System.out.println(user);

            }else {
                System.out.println("잘못 선택했습니다. 다시 선택해주세요");
            }


        }
    }
}
