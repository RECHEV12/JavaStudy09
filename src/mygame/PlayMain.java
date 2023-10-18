package mygame;

import java.util.ArrayList;
import java.util.Scanner;

public class PlayMain {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Class user = new Class();

        LevelDB levelDB = LevelDB.getInstance();
        MonsterDB monsterDB = MonsterDB.getInstance();
        ArrayList<Monster> mainMonsterList = new ArrayList<>();
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
        SkillDB skillDB = SkillDB.getInstance();

        if (user.getPlayerClass().equals("전사")) {

            user.getPlayerSkillList().add(SkillDB.getInstance().getSkillList().get(0));
            user.getPlayerSkillList().add(SkillDB.getInstance().getSkillList().get(1));

            System.out.println("\n" + user.getPlayerName() + "은(는)" + skillDB.skillList.get(0).getSkillName() + "을 습득했다!!\n");
            System.out.println(user.getPlayerName() + "은(는)" + skillDB.skillList.get(1).getSkillName() + "을 습득했다!!\n");
        } else if (user.getPlayerClass().equals("마법사")) {

            user.getPlayerSkillList().add(SkillDB.getInstance().getSkillList().get(12));
            user.getPlayerSkillList().add(SkillDB.getInstance().getSkillList().get(13));

            System.out.println("\n" + user.getPlayerName() + "은(는)" + skillDB.skillList.get(12).getSkillName() + "을 습득했다!!\n");
            System.out.println(user.getPlayerName() + "은(는)" + skillDB.skillList.get(13).getSkillName() + "을 습득했다!!\n");

        }


        System.out.println("------ 계정 생성에 성공했습니다. 게임을 시작합니다! -----");
        System.out.println("알아두면 좋은 정보");
        System.out.println("STR은 힘, DEX는 회피율, INT는 지능, LUK는 운을 나타내며");
        System.out.println("LUK를 제외한 스탯은 스킬과 기본공격 대미지에 영향을 줍니다.");
        System.out.println("LUK을 100 달성 시, 모든 공격이 치명타가 됩니다.");
        //todo 구현기능 : 장비, 몬스터, 대미지 계산식, 아이템 드롭(무기, 회복약), 아이템 사용, 각종 상태이상
        while (true) {
            System.out.println("※※ 거점 : 마을 ※※");
            System.out.println("※※행동을 선택해주세요※※");
            System.out.println("1. 필드에 나간다 | 2. 스테이터스를 확인한다 | 3. 아이템박스 확인");
            System.out.print("숫자를 입력>>> ");
            int command = Integer.parseInt(scan.nextLine());

            if (command == 1) {
                mainMonsterList.clear();
                System.out.println("※※필드를 선택해주세요※※");
                System.out.println("1. 초심자 평원(Lv1~Lv10) | 2. 무너진 성터(Lv10~Lv20) |3. 옛 전쟁터(Lv20~Lv30) |4. 마왕성(Lv3~Lv40)");
                System.out.println("5. 보스 : 대왕 슬라임(Lv10) | 6. 보스 : 킹 고블린(Lv10~Lv20) |7. 보스 : 거대 골렘(Lv20~Lv30) |8. 보스 : 드래곤(Lv3~Lv40)");
                System.out.print("숫자를 입력>>> ");
                int selectField = Integer.parseInt(scan.nextLine());
                if (selectField == 1) {
                    System.out.println("초심자 평원으로 출발합니다.");
                    MonsterDB.getInstance().inputMonster(mainMonsterList, 0);
                    MonsterDB.getInstance().inputMonster(mainMonsterList, 1);
                } else if (selectField == 2) {
                    System.out.println("무너진 성터로 출발합니다.");
                    MonsterDB.getInstance().inputMonster(mainMonsterList, 3);
                    MonsterDB.getInstance().inputMonster(mainMonsterList, 4);
                } else if (selectField == 3) {
                    System.out.println("옛 전쟁터로 출발합니다.");
                    MonsterDB.getInstance().inputMonster(mainMonsterList, 6);
                    MonsterDB.getInstance().inputMonster(mainMonsterList, 7);
                    MonsterDB.getInstance().inputMonster(mainMonsterList, 8);
                } else if (selectField == 4) {
                    System.out.println("마왕성으로 출발합니다.");
                    MonsterDB.getInstance().inputMonster(mainMonsterList, 10);
                    MonsterDB.getInstance().inputMonster(mainMonsterList, 11);
                    MonsterDB.getInstance().inputMonster(mainMonsterList, 12);
                } else if (selectField == 5) {
                    System.out.println("대왕 슬라임에게 도전합니다.");
                    MonsterDB.getInstance().inputMonster(mainMonsterList, 2);
                } else if (selectField == 6) {
                    System.out.println("킹 고블린에게 도전합니다.");
                    MonsterDB.getInstance().inputMonster(mainMonsterList, 5);
                } else if (selectField == 7) {
                    System.out.println("거대 골렘에게 도전합니다.");
                    MonsterDB.getInstance().inputMonster(mainMonsterList, 9);
                } else if (selectField == 8) {
                    System.out.println("드래곤에게 도전합니다.");
                    MonsterDB.getInstance().inputMonster(mainMonsterList, 13);

                } else {
                    System.out.println("잘못 선택했습니다. 다시 선택해주세요");
                    continue;
                }

                while (true) {

                    System.out.println("필드에서 할 행동을 선택해주세요");
                    System.out.println("1. 전투 | 2. 스테이터스를 확인한다 | 3. 거점으로 돌아간다");
                    System.out.print("숫자를 입력>>> ");
                    int command2 = Integer.parseInt(scan.nextLine());
                    if (command2 == 1) {

                        System.out.println(user);

                        System.out.println("몬스터를 잡았다!");
                        //경험치 추가 기믹
                        if (user.getLv() < 40) {
                            user.setExp(user.getExp() + 10);
                        }
                        //레벨업 기믹
                        if (user.getExp() > user.getNextExp()) {
                            Class.levelUP(user, levelDB);
                            UtillMethod.setSkill(user);
                        }


                    } else if (command2 == 2) {
                        System.out.println(user);

                    } else if (command2 == 3) {
                        System.out.println("마을로 이동합니다.");
                        break;

                    } else {
                        System.out.println("잘못 선택했습니다. 다시 선택해주세요");
                        continue;
                    }


                }


            } else if (command == 2) {
                System.out.println(user);

            } else if (command == 3) {
                //todo 아이템박스 구현 및 리스트업
                System.out.println(user);

            } else {
                System.out.println("잘못 선택했습니다. 다시 선택해주세요");
            }


        }
    }
}
