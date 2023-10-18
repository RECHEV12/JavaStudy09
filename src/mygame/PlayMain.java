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
        SkillDB skillDB = SkillDB.getInstance();

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


        if (user.getPlayerClass().equals("전사")) {
            user.getPlayerSkillList().add(SkillDB.getInstance().getSkillList().get(0));
            user.getPlayerSkillList().add(SkillDB.getInstance().getSkillList().get(1));

            System.out.println("\n" + user.getPlayerName() + "은(는) " + skillDB.playerskillList.get(0).getSkillName() + "을 습득했다!!\n");
            System.out.println(user.getPlayerName() + "은(는) " + skillDB.playerskillList.get(1).getSkillName() + "을 습득했다!!\n");
        } else if (user.getPlayerClass().equals("마법사")) {

            user.getPlayerSkillList().add(SkillDB.getInstance().getSkillList().get(12));
            user.getPlayerSkillList().add(SkillDB.getInstance().getSkillList().get(13));

            System.out.println("\n" + user.getPlayerName() + "은(는)" + skillDB.playerskillList.get(12).getSkillName() + "을 습득했다!!\n");
            System.out.println(user.getPlayerName() + "은(는)" + skillDB.playerskillList.get(13).getSkillName() + "을 습득했다!!\n");

        }


        System.out.println("------ 계정 생성에 성공했습니다. 게임을 시작합니다! -----");
        System.out.println("알아두면 좋은 정보");
        System.out.println("STR은 힘, DEX는 회피율 및 치명타, INT는 지능, LUK는 운을 나타내며");
        System.out.println("LUK를 제외한 스탯은 스킬과 기본공격 대미지에 영향을 줍니다.");
        System.out.println("LUK을 100 달성 시, 모든 공격이 치명타가 됩니다.");
        //todo 구현기능 : 장비,아이템 드롭(무기, 회복약), 아이템 사용, 각종 상태이상, 몸 스킬
        outer:
        while (true) {
            System.out.println("※※ 거점 : 마을 ※※");
            System.out.println("※※행동을 선택해주세요※※");
            System.out.println("1. 필드에 나간다 | 2. 스테이터스를 확인한다 | 3. 아이템박스 확인");
            System.out.print("숫자를 입력>>> ");
            int command = Integer.parseInt(scan.nextLine());

            if (command == 1) {
                while (true) {
                    mainMonsterList.clear();

                    System.out.println("※※필드를 선택해주세요※※");
                    System.out.println("1. 초심자 평원(Lv1~Lv10) | 2. 무너진 성터(Lv10~Lv20) |3. 옛 전쟁터(Lv20~Lv30) |4. 마왕성(Lv30~Lv40)");
                    System.out.println("5. 보스 : 대왕 슬라임(Lv10) | 6. 보스 : 킹 고블린(v20) |7. 보스 : 거대 골렘(Lv30) |8. 보스 : 드래곤(Lv40)");
                    System.out.print("숫자를 입력>>> ");
                    int selectField = Integer.parseInt(scan.nextLine());

                    if (selectField == 1) {
                        System.out.println("초심자 평원으로 출발합니다.");
                        MonsterDB.getInstance().inputMonster(mainMonsterList, 0);
                        MonsterDB.getInstance().inputMonster(mainMonsterList, 1);
                        break;
                    } else if (selectField == 2) {
                        if (user.getLv() < 10) {
                            System.out.println("입장하기 위한 레벨이 부족합니다.");
                            continue;
                        } else {
                            System.out.println("무너진 성터로 출발합니다.");
                            MonsterDB.getInstance().inputMonster(mainMonsterList, 3);
                            MonsterDB.getInstance().inputMonster(mainMonsterList, 4);
                            break;
                        }

                    } else if (selectField == 3) {
                        if (user.getLv() < 20) {
                            System.out.println("입장하기 위한 레벨이 부족합니다.");
                            continue;
                        } else {
                            System.out.println("옛 전쟁터로 출발합니다.");
                            MonsterDB.getInstance().inputMonster(mainMonsterList, 6);
                            MonsterDB.getInstance().inputMonster(mainMonsterList, 7);
                            MonsterDB.getInstance().inputMonster(mainMonsterList, 8);
                            break;
                        }

                    } else if (selectField == 4) {
                        if (user.getLv() < 30) {
                            System.out.println("입장하기 위한 레벨이 부족합니다.");
                            continue;
                        } else {
                            System.out.println("마왕성으로 출발합니다.");
                            MonsterDB.getInstance().inputMonster(mainMonsterList, 10);
                            MonsterDB.getInstance().inputMonster(mainMonsterList, 11);
                            MonsterDB.getInstance().inputMonster(mainMonsterList, 12);
                            break;
                        }

                    } else if (selectField == 5) {
                        if (user.getLv() < 10) {
                            System.out.println("입장하기 위한 레벨이 부족합니다.");
                            continue;
                        } else {
                            System.out.println("대왕 슬라임에게 도전합니다.");
                            MonsterDB.getInstance().inputMonster(mainMonsterList, 2);
                            break;
                        }

                    } else if (selectField == 6) {
                        if (user.getLv() < 10) {
                            System.out.println("입장하기 위한 레벨이 부족합니다.");
                            continue;
                        } else {
                            System.out.println("킹 고블린에게 도전합니다.");
                            MonsterDB.getInstance().inputMonster(mainMonsterList, 5);
                            break;
                        }

                    } else if (selectField == 7) {
                        if (user.getLv() < 20) {
                            System.out.println("입장하기 위한 레벨이 부족합니다.");
                            continue;
                        } else {
                            System.out.println("거대 골렘에게 도전합니다.");
                            MonsterDB.getInstance().inputMonster(mainMonsterList, 9);
                            break;
                        }

                    } else if (selectField == 8) {
                        if (user.getLv() < 30) {
                            System.out.println("입장하기 위한 레벨이 부족합니다.");
                            continue;
                        } else {
                            System.out.println("드래곤에게 도전합니다.");
                            MonsterDB.getInstance().inputMonster(mainMonsterList, 13);
                            break;
                        }

                    } else {
                        System.out.println("잘못 선택했습니다. 다시 선택해주세요");
                        continue;
                    }
                }
                while (true) {
                    System.out.println("필드에서 할 행동을 선택해주세요");
                    System.out.println("1. 전투 | 2. 스테이터스를 확인한다 | 3. 거점으로 돌아간다");
                    System.out.print("숫자를 입력>>> ");

                    int command2 = Integer.parseInt(scan.nextLine());

                    if (command2 == 1) {
                        Monster a = MonsterDB.instance.getMonster(mainMonsterList);

                        double rare = UtillMethod.random5per();

                        MonsterDB.instance.setMonster(a);
//                        몹 데이터 세팅


                        //레어도에 따른 특수개체 출현 표시
                        String mobName = "";
                        if (rare == 1.0) {
                            mobName = a.getMonsterName();
                        } else if (rare == 1.5) {
                            mobName = ("🌟 특수 개체 출현! 경험치 추가 🌟" + "\n" + "🌟 " + a.getMonsterName());
                        }


                        System.out.println(mobName + " Lv." + a.getMonsterLv() + "이(가) 나타났다!");


                        //배틀로직
                        while (true) {

                            a.battleMonsterData(a, rare);

                            System.out.println("※※행동을 선택해주세요※※");
                            System.out.println("1. 싸운다 | 2. 스테이터스를 확인한다 | 3. 아이템박스 확인 | 4. 도망간다");
                            System.out.print("숫자를 입력>>> ");
                            int battleCommand = Integer.parseInt(scan.nextLine());
                            if (battleCommand == 1) {
                                System.out.println("※※사용할 스킬을 선택해주세요※※");
                                System.out.println("※※0을 입력하면 이전 메뉴로 돌아갑니다.※※");

                                while (true) {
                                    // 스킬 인덱스를 가져오기
                                    Skill.printSkillList(user);
                                    System.out.print("숫자를 입력>>> ");
                                    int battleSelect = Integer.parseInt(scan.nextLine()) - 1;
                                    if (battleSelect == -1) {
                                        System.out.println("이전 메뉴로 돌아갑니다.");
                                        break;
                                    } else if (battleSelect >= user.playerSkillList.size()) {

                                        System.out.println("잘못 선택했습니다. 다시 선택해주세요");

                                    } else {

                                        // 선택 스킬 설정
                                        Skill userChoiceSkill = user.playerSkillList.get(battleSelect);

                                        //최종대미지 표시
                                        double criticaldamage = Skill.criticalReturn(user);

                                        int userBattleDamage = Skill.getUserDamage(user, userChoiceSkill, a, criticaldamage);


                                        // 몬스터 스킬 넣기
                                        UtillMethod.monsterSetSkill(a);

                                        // 몬스터 스킬 설정
                                        Skill mobChoiceDamage = Skill.getMonsterSkill(a);

                                        //최종 대미지 표시
                                        int mobBattleDamage = Skill.getMonsterDamage(user, mobChoiceDamage, a);

                                        // 방어인지 공격인지 선공권 정하기(공격 주고받기)
                                        if (userChoiceSkill.getSkillType().equals("방어")) {
                                            int defDamage = Skill.defDamage(user, userChoiceSkill);
                                            System.out.println(user.getPlayerName() + "의 " + userChoiceSkill.getSkillName() + "!!");
                                            System.out.println("방어 계열 스킬을 사용했다");
                                            if (criticaldamage == 1.5) {
                                                System.out.println(user.getPlayerName() + "은(는) 완벽한 방어를 를 펼쳤다.");
                                            }
                                            System.out.println(user.getPlayerName() + "은(는) " + defDamage + "만큼의 대미지를 방어할 수 있다!");
                                            System.out.println("-----------------------------------------------------------------");
                                            if (defDamage > mobBattleDamage) {
                                                System.out.println(a.getMonsterName() + "의 " + mobChoiceDamage.getSkillName() + "!!");
                                                System.out.println(mobBattleDamage + " 대미지!!");
                                                System.out.println(user.getPlayerName() + "은(는) 모든 데미지를 방어했다!!");
                                            } else if (defDamage < mobBattleDamage) {
                                                int againMobDamage = Math.abs(defDamage - mobBattleDamage);
                                                user.setStatHP(user.getStatHP() - againMobDamage);
                                                System.out.println(user.getPlayerName() + "은(는) " + a.getMonsterName() + "의 대미지를 모두 막아내지 못했다!!");
                                                System.out.println(a.getMonsterName() + "의 " + againMobDamage + "!!");
                                                System.out.println(user.getPlayerName() + "은(는) " + againMobDamage + "대미지를 입어 체력이" + user.getStatHP() + "가 되었다.");
                                            }
                                        } else {
                                            a.setMonsterHP((a.getMonsterHP() - userBattleDamage));

                                            System.out.println(user.getPlayerName() + "의 " + userChoiceSkill.getSkillName() + "!!");

                                            if (criticaldamage == 1.5) {
                                                System.out.println("크리티컬 발동!");
                                            }

                                            System.out.println(userBattleDamage + " 대미지!!");

                                            //체력이 0이 되면 처치 break;
                                            if (a.getMonsterHP() <= 0) {
                                                a.setMonsterHP(0);
                                                System.out.println(a.getMonsterName() + "은(는) " + userBattleDamage + " 대미지를 입어 체력이 " + a.getMonsterHP() + "이(가) 되었다.");
                                                System.out.println(mobName + " Lv." + a.getMonsterLv() + "을(를) 쓰러뜨렸다!");

                                                //경험치 추가 기믹
                                                if (user.getLv() < 40) {
                                                    int exp = a.getExp(a, rare);
                                                    System.out.println("경험치 " + exp + " 획득");
                                                    user.setExp(user.getExp() + exp);
                                                }

                                                //레벨업 기믹
                                                if (user.getExp() >= user.getNextExp()) {
                                                    Class.levelUP(user, levelDB);
                                                    UtillMethod.userSetSkill(user);
                                                }
                                                break;
                                            } else {
                                                System.out.println(a.getMonsterName() + "은(는) " + userBattleDamage + " 대미지를 입어 체력이 " + a.getMonsterHP() + "이(가) 되었다.");
                                            }
                                            System.out.println("-----------------------------------------------------------------");
                                            user.setStatHP(user.getStatHP() - mobBattleDamage);
                                            System.out.println(a.getMonsterName() + "의 " + mobChoiceDamage.getSkillName() + "!!");
                                            System.out.println(mobBattleDamage + " 대미지!!");
                                            if (user.getStatHP() <= 0) {
                                                user.setStatHP(0);
                                                System.out.println(user.getPlayerName() + "은(는) " + mobBattleDamage + "의 대미지를 입어 체력이" + user.getStatHP() + "가 되었다.");
                                                System.out.println(user.getPlayerName() + "은()는 사망하였습니다. \n" + "GAME OVER");
                                                break outer;
                                            } else {
                                                System.out.println(user.getPlayerName() + "은(는) " + mobBattleDamage + "의 대미지를 입어 체력이" + user.getStatHP() + "가 되었다.");

                                            }
                                        }
                                    }
                                }
                            } else if (battleCommand == 2) {
                                System.out.println(user);

                            } else if (battleCommand == 3) {

                            } else if (battleCommand == 4) {
                                System.out.println(mobName + " Lv." + a.getMonsterLv() + "(으)로부터 도망쳤다!");
                                break;
                            } else {
                                System.out.println("잘못 선택했습니다. 다시 선택해주세요");
                                continue;
                            }
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
                System.out.println("게임을 종료합니다");
                break;
            }


        }
    }
}
