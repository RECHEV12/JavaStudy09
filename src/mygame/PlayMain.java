package mygame;

import java.util.ArrayList;
import java.util.Scanner;

//todo 여유 남을 시 각종 상태이상, 팔았던 장비 복구 기능
public class PlayMain {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Class user = new Class();

        LevelDB levelDB = LevelDB.getInstance();
        MonsterDB monsterDB = MonsterDB.getInstance();
        ArrayList<Monster> mainMonsterList = new ArrayList<>();
        SkillDB skillDB = SkillDB.getInstance();

        String field1 = "1. 초심자 평원(Lv1~Lv10)";
        String field2 = "2. 무너진 성터(Lv10~Lv20)";
        String field3 = "3. 옛 전쟁터(Lv20~Lv30)";
        String field4 = "4. 마왕성(Lv30~Lv40)";
        String field5 = "5. 보스 : 대왕 슬라임(Lv10)";
        String field6 = "6. 보스 : 킹 고블린(v20) ";
        String field7 = "7. 보스 : 거대 골렘(Lv30) ";
        String field8 = "8. 보스 : 드래곤(Lv40)";

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
        System.out.println("STR은 힘, DEX는 회피율 및 치명타, INT는 지능, LUK는 운을 나타내며");
        System.out.println("LUK를 제외한 스탯은 스킬과 기본공격 대미지에 영향을 줍니다.");
        System.out.println("LUK을 100 달성 시, 모든 공격이 치명타가 됩니다.");
        //todo, 상점, 현재 착용중인 장비 보여주기, 장비판매 , 회피공식(몹 레벨에 따라 피하기 어려워짐)
        outer:
        while (true) {
            System.out.println("※※ 거점 : 마을 ※※");
            System.out.println("※※행동을 선택해주세요※※");
            System.out.println("1. 필드에 나간다 | 2. 스테이터스를 확인한다 | 3. 아이템박스 확인  | 4. 상점에 들어간다 | 5. 스탯 분배");
            System.out.print("숫자를 입력>>> ");
            int command = Integer.parseInt(scan.nextLine());
            String nowField = "";
            if (command == 1) {
                while (true) {
                    mainMonsterList.clear();

                    System.out.println("※※필드를 선택해주세요※※");
                    System.out.println(field1 + " | " + field2 + " | " + field3 + " | " + field4);
                    System.out.println(field5 + " | " + field6 + " | " + field7 + " | " + field8);
                    System.out.print("숫자를 입력>>> ");
                    int selectField = Integer.parseInt(scan.nextLine());

                    if (selectField == 1) {
                        System.out.println("초심자 평원으로 출발합니다.");
                        MonsterDB.getInstance().inputMonster(mainMonsterList, 0);
                        MonsterDB.getInstance().inputMonster(mainMonsterList, 1);
                        nowField = field1;
                        break;
                    } else if (selectField == 2) {
                        if (user.getLv() < 10) {
                            System.out.println("입장하기 위한 레벨이 부족합니다.");
                            continue;
                        } else {
                            System.out.println("무너진 성터로 출발합니다.");
                            MonsterDB.getInstance().inputMonster(mainMonsterList, 3);
                            MonsterDB.getInstance().inputMonster(mainMonsterList, 4);
                            nowField = field2;
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
                            nowField = field3;
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
                            nowField = field4;
                            break;
                        }

                    } else if (selectField == 5) {
                        if (user.getLv() < 10) {
                            System.out.println("입장하기 위한 레벨이 부족합니다.");
                            continue;
                        } else {
                            System.out.println("대왕 슬라임에게 도전합니다.");
                            MonsterDB.getInstance().inputMonster(mainMonsterList, 2);
                            nowField = field5;
                            break;
                        }

                    } else if (selectField == 6) {
                        if (user.getLv() < 10) {
                            System.out.println("입장하기 위한 레벨이 부족합니다.");
                            continue;
                        } else {
                            System.out.println("킹 고블린에게 도전합니다.");
                            MonsterDB.getInstance().inputMonster(mainMonsterList, 5);
                            nowField = field6;
                            break;
                        }

                    } else if (selectField == 7) {
                        if (user.getLv() < 20) {
                            System.out.println("입장하기 위한 레벨이 부족합니다.");
                            continue;
                        } else {
                            System.out.println("거대 골렘에게 도전합니다.");
                            MonsterDB.getInstance().inputMonster(mainMonsterList, 9);
                            nowField = field7;
                            break;
                        }

                    } else if (selectField == 8) {
                        if (user.getLv() < 30) {
                            System.out.println("입장하기 위한 레벨이 부족합니다.");
                            continue;
                        } else {
                            System.out.println("드래곤에게 도전합니다.");
                            MonsterDB.getInstance().inputMonster(mainMonsterList, 13);
                            nowField = field8;
                            break;
                        }

                    } else {
                        System.out.println("잘못 선택했습니다. 다시 선택해주세요");
                        continue;
                    }
                }
                while (true) {
                    System.out.println("현재 필드 : " + nowField);
                    System.out.println("필드에서 할 행동을 선택해주세요");
                    System.out.println("1. 전투 | 2. 스테이터스를 확인한다 |  3. 아이템박스 확인  | 4. 거점으로 돌아간다");
                    System.out.print("숫자를 입력>>> ");

                    int command2 = Integer.parseInt(scan.nextLine());

                    if (command2 == 1) {
                        Monster a = MonsterDB.instance.getMonster(mainMonsterList);

                        double rare = UtillMethod.random5per();

                        MonsterDB.instance.setMonster(a);

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
                                        double criticaldamage = DamageMethod.criticalReturn(user);

                                        int userBattleDamage = DamageMethod.getUserDamage(user, userChoiceSkill, a, criticaldamage);


                                        // 몬스터 스킬 넣기
                                        UtillMethod.monsterSetSkill(a);

                                        // 몬스터 스킬 설정
                                        Skill mobChoiceDamage = UtillMethod.monsterChoiceSkill(a);

                                        //최종 대미지 표시
                                        int mobBattleDamage = DamageMethod.getMonsterDamage(mobChoiceDamage, a);

                                        // 방어인지 공격인지 선공권 정하기(공격 주고받기)
                                        if (userChoiceSkill.getSkillType().equals("방어")) {
                                            int defDamage = DamageMethod.defDamage(user, userChoiceSkill);
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
                                                user.setStatNowHP(user.getStatNowHP() - againMobDamage);
                                                System.out.println(user.getPlayerName() + "은(는) " + a.getMonsterName() + "의 대미지를 모두 막아내지 못했다!!");
                                                System.out.println(a.getMonsterName() + "의 " + againMobDamage + "!!");
                                                System.out.println(user.getPlayerName() + "은(는) " + againMobDamage + "대미지를 입어 체력이" + user.getStatNowHP() + "가 되었다.");
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
                                                    user.setExp(user.getExp() + exp + 1000);
                                                    System.out.println("경험치 " + exp + " 획득");
                                                }

                                                //레벨업 기믹
                                                if (user.getExp() >= user.getNextExp()) {
                                                    Class.levelUP(user, levelDB);
                                                }
                                                // 돈 드랍 기믹
                                                int money = a.getMoney(a, rare);
                                                user.setMoney(user.getMoney() + money);
                                                System.out.println(money + "원을 획득했다!");
                                                System.out.println("현재 소지금 : " + user.getMoney());

                                                // 아이템 드랍 기믹
                                                Item temp = Item.dropItem(a);
                                                user.getItemsList().add(temp);
                                                System.out.println(temp.getItemName() + "을(를) 획득했다!!");

                                                break;
                                            } else {
                                                System.out.println(a.getMonsterName() + "은(는) " + userBattleDamage + " 대미지를 입어 체력이 " + a.getMonsterHP() + "이(가) 되었다.");
                                            }
                                            System.out.println("-----------------------------------------------------------------");
                                            user.setStatNowHP(user.getStatNowHP() - mobBattleDamage);
                                            System.out.println(a.getMonsterName() + "의 " + mobChoiceDamage.getSkillName() + "!!");
                                            System.out.println(mobBattleDamage + " 대미지!!");
                                            if (user.getStatNowHP() <= 0) {
                                                user.setStatNowHP(0);
                                                System.out.println(user.getPlayerName() + "은(는) " + mobBattleDamage + "의 대미지를 입어 체력이" + user.getStatNowHP() + "가 되었다.");
                                                System.out.println(user.getPlayerName() + "은()는 사망하였습니다. \n" + "GAME OVER");
                                                break outer;
                                            } else {
                                                System.out.println(user.getPlayerName() + "은(는) " + mobBattleDamage + "의 대미지를 입어 체력이" + user.getStatNowHP() + "가 되었다.");

                                            }
                                        }
                                    }
                                }
                            } else if (battleCommand == 2) {
                                System.out.println(user);

                            } else if (battleCommand == 3) {
                                System.out.println(user.getItemsList());
                                System.out.println("※※아이템 카테고리를 선택해주세요※※");
                                while (true) {
                                    System.out.println("1. 무기 | 2. 방어구 | 3. 포션 | 4. 이전으로");
                                    System.out.print("숫자를 입력>>> ");
                                    int itemLookCommand = Integer.parseInt(scan.nextLine());
                                    if (itemLookCommand >= 4) {
                                        System.out.println("이전으로 돌아갑니다.");
                                        break;
                                    }
                                    if (user.getItemsList().isEmpty()) {
                                        System.out.println("아이템이 존재하지 않습니다.");
                                        break;
                                    }

                                    Class.openItemBox(user, itemLookCommand);

                                    System.out.println("1. 장착/탈착/사용 | 2. 이전으로");
                                    System.out.print("숫자를 입력>>> ");
                                    int itemLookCommand2 = Integer.parseInt(scan.nextLine());
                                    if (itemLookCommand2 == 1) {

                                        Class.openItemBox(user, itemLookCommand);

                                        System.out.print("No.숫자를 입력>>> ");

                                        int choiceItem = Integer.parseInt(scan.nextLine());

                                        Class.useItem(choiceItem, user);

                                    } else if (itemLookCommand2 == 2) {
                                        break;
                                    } else {
                                        System.out.println("잘못 선택했습니다. 다시 선택해주세요");
                                        continue;
                                    }

                                }
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
                        System.out.println(user.getItemsList());
                        System.out.println("※※아이템 카테고리를 선택해주세요※※");
                        while (true) {
                            System.out.println("1. 무기 | 2. 방어구 | 3. 포션 | 4. 이전으로");
                            System.out.print("숫자를 입력>>> ");
                            int itemLookCommand = Integer.parseInt(scan.nextLine());
                            if (itemLookCommand >= 4) {
                                System.out.println("이전으로 돌아갑니다.");
                                break;
                            }
                            if (user.getItemsList().isEmpty()) {
                                System.out.println("아이템이 존재하지 않습니다.");
                                break;
                            }

                            Class.openItemBox(user, itemLookCommand);

                            System.out.println("1. 장착/탈착/사용 | 2. 이전으로");
                            System.out.print("숫자를 입력>>> ");
                            int itemLookCommand2 = Integer.parseInt(scan.nextLine());
                            if (itemLookCommand2 == 1) {

                                Class.openItemBox(user, itemLookCommand);

                                System.out.print("No.숫자를 입력>>> ");

                                int choiceItem = Integer.parseInt(scan.nextLine());

                                Class.useItem(choiceItem, user);

                            } else if (itemLookCommand2 == 2) {
                                break;
                            } else {
                                System.out.println("잘못 선택했습니다. 다시 선택해주세요");
                                continue;
                            }

                        }

                    } else if (command2 == 4) {
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
                System.out.println(user.getItemsList());
                System.out.println("※※아이템 카테고리를 선택해주세요※※");
                while (true) {
                    System.out.println("1. 무기 | 2. 방어구 | 3. 포션 | 4. 이전으로");
                    System.out.print("숫자를 입력>>> ");
                    int itemLookCommand = Integer.parseInt(scan.nextLine());
                    if (itemLookCommand >= 4) {
                        System.out.println("이전으로 돌아갑니다.");
                        break;
                    }
                    if (user.getItemsList().isEmpty()) {
                        System.out.println("아이템이 존재하지 않습니다.");
                        break;
                    }

                    Class.openItemBox(user, itemLookCommand);

                    System.out.println("1. 장착/탈착/사용 | 2. 이전으로");
                    System.out.print("숫자를 입력>>> ");
                    int itemLookCommand2 = Integer.parseInt(scan.nextLine());
                    if (itemLookCommand2 == 1) {

                        Class.openItemBox(user, itemLookCommand);

                        System.out.print("No.숫자를 입력>>> ");

                        int choiceItem = Integer.parseInt(scan.nextLine());

                        Class.useItem(choiceItem, user);

                    } else if (itemLookCommand2 == 2) {
                        break;
                    } else {
                        System.out.println("잘못 선택했습니다. 다시 선택해주세요");
                        continue;
                    }

                }
            } else if (command == 4) {
                System.out.println("상점으로 이동합니다.");

















            } else if (command == 5) {
                System.out.println("스탯을 자유롭게 분배해 보세요");
                if (user.getExtraStat() == 0) {
                    System.out.println("여유 스탯이 없습니다. 레벨업을 하여 스탯을 모아주세요");
                } else {
                    while (user.getExtraStat() > 0) {
                        int a = user.getStatSTR();
                        int b = user.getStatDEX();
                        int c = user.getStatINT();
                        int d = user.getStatLUK();
                        int e = user.getStatNowHP();
                        int f = user.getStatMaxHP();
                        int g = user.getStatNowMP();
                        int h = user.getStatMaxMP();

                        System.out.println("체력과 마나는 여유스탯 +1 당 +3으로 계산됩니다.");
                        System.out.println("현재 사용 가능 포인트 : " + user.getExtraStat());
                        System.out.println("1. STR | 2. DEX | 3. INT | 4. LUK | 5. HP | 6. MP");
                        System.out.print("올릴 스탯 번호를 입력>>> ");
                        int statIndexNum = Integer.parseInt(scan.nextLine());

                        System.out.print("올릴 스탯 양을 입력>>> ");
                        int statNum = Integer.parseInt(scan.nextLine());

                        if (statIndexNum == 1) {
                            user.setStatSTR(user.getStatSTR() + statNum);
                            System.out.println("스탯 : STR " + a + "➡\uFE0F" + (user.getStatSTR()));
                            user.setExtraStat(user.getExtraStat() - statNum);

                        } else if (statIndexNum == 2) {
                            user.setStatDEX(user.getStatDEX() + statNum);
                            System.out.println("스탯 : DEX " + b + "➡\uFE0F" + (user.getStatDEX()));
                            user.setExtraStat(user.getExtraStat() - statNum);
                        } else if (statIndexNum == 3) {
                            user.setStatINT(user.getStatINT() + statNum);
                            System.out.println("스탯 : INT " + c + "➡\uFE0F" + (user.getStatINT()));
                            user.setExtraStat(user.getExtraStat() - statNum);
                        } else if (statIndexNum == 4) {
                            user.setStatLUK(user.getStatLUK() + statNum);
                            System.out.println("스탯 : LUK " + d + "➡\uFE0F" + (user.getStatLUK()));
                            user.setExtraStat(user.getExtraStat() - statNum);
                        } else if (statIndexNum == 5) {
                            user.setStatNowHP(user.getStatNowHP() +  + (statNum*3));
                            user.setStatMaxHP(user.getStatMaxHP() +  + (statNum*3));
                            user.setExtraStat(user.getExtraStat() - statNum);
                            System.out.println("스탯 : 현재체력 " + e + "➡\uFE0F" + (user.getStatNowHP()));
                            System.out.println("스탯 : 최대체력 " + f + "➡\uFE0F" + (user.getStatMaxHP()));
                        } else if (statIndexNum == 6) {
                            user.setStatNowMP(user.getStatNowMP() +  + (statNum*3));
                            user.setStatMaxMP(user.getStatMaxMP() +  + (statNum*3));
                            System.out.println("스탯 : 현재마나 " + g + "➡\uFE0F" + (user.getStatNowMP()));
                            System.out.println("스탯 : 최대마나 " + h + "➡\uFE0F" + (user.getStatMaxMP()));
                            user.setExtraStat(user.getExtraStat() - statNum);
                        }

                        System.out.println("현재 사용 가능 포인트 : " + user.getExtraStat());

                    }
                }
            } else {
                System.out.println("잘못 선택했습니다. 다시 선택해주세요");
                System.out.println("게임을 종료합니다");
                break;
            }


        }
    }
}
