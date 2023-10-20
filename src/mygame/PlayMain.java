package mygame;

import java.util.ArrayList;

import java.util.Scanner;

import static mygame.Item.returnItemAllName;
import static mygame.Item.returnItemOne;
import static mygame.UtillMethod.*;

//todo 여유 남을 시 각종 상태이상, 팔았던 장비 복구 기능
public class PlayMain {
    public static void main(String[] args) throws InterruptedException {
        Scanner scan = new Scanner(System.in);
        Class user = new Class();

        LevelDB levelDB = LevelDB.getInstance();
        MonsterDB monsterDB = MonsterDB.getInstance();
        ArrayList<Monster> mainMonsterList = new ArrayList<>();
        SkillDB skillDB = SkillDB.getInstance();
        ShopDB shopDB = new ShopDB();

        String field1 = "1. \uD83C\uDFDE\uFE0F 초심자 평원(Lv1~Lv10)";
        String field2 = "2. \uD83E\uDEA8 무너진 성터(Lv10~Lv20)";
        String field3 = "3. \uD83D\uDED5 옛 전쟁터(Lv20~Lv30)";
        String field4 = "4. \uD83C\uDF06 마왕성(Lv30~Lv40)";
        String field5 = "5. ⚜\uFE0F 대왕 슬라임(Lv10)";
        String field6 = "6. ⚜\uFE0F 킹 고블린(v20) ";
        String field7 = "7. ⚜\uFE0F 거대 골렘(Lv30) ";
        String field8 = "8. ⚜\uFE0F 드래곤(Lv40)";

        while (true) {
            System.out.println("─━━━━━━━━━━━━━━━━━━━━━━━━⊱༻ ⚪ ༺⊰━━━━━━━━━━━━━━━━━━━━━━━━─");
            System.out.println("   게임을 시작합니다. ");
            System.out.println("  직업을 선택해주세요.  ");
            System.out.println(" 1. ⚔\uFE0F 전사 | 2. \uD83D\uDD2E 마법사   ");
            System.out.print("숫자 ▶\uFE0F  ");
            int firstSelectClass = Integer.parseInt(scan.nextLine());

            System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━⊱⋆⊰━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");

            System.out.println("플레이어의 이름을 입력해주세요");
            System.out.print("이름을 ▶\uFE0F   ");
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
                boxBox("잘못 선택했습니다. 다시 선택해주세요");
                continue;
            }
        }

        if (user.getPlayerClass().equals("전사")) {
            user.getPlayerSkillList().add(SkillDB.getInstance().getSkillList().get(0));
            user.getPlayerSkillList().add(SkillDB.getInstance().getSkillList().get(1));

            boxBox(user.getPlayerName() + "은(는) " + skillDB.playerskillList.get(0).getSkillName() + "을 습득했다!");
            boxBox(user.getPlayerName() + "은(는) " + skillDB.playerskillList.get(1).getSkillName() + "을 습득했다!");

        } else if (user.getPlayerClass().equals("마법사")) {

            user.getPlayerSkillList().add(SkillDB.getInstance().getSkillList().get(12));
            user.getPlayerSkillList().add(SkillDB.getInstance().getSkillList().get(13));

            boxBox(user.getPlayerName() + "은(는)" + skillDB.playerskillList.get(12).getSkillName() + "을 습득했다!");
            boxBox(user.getPlayerName() + "은(는)" + skillDB.playerskillList.get(13).getSkillName() + "을 습득했다!");
        }

        System.out.println("─━━━━━━━━━━━━━━━━━━━━━━━━⊱༻ ⚪ ༺⊰━━━━━━━━━━━━━━━━━━━━━━━━─");
        System.out.println("            계정 생성에 성공했습니다. 게임을 시작합니다!");
        System.out.println("─━━━━━━━━━━━━━━━━━━━━━━━━⊱༻ ⚪ ༺⊰━━━━━━━━━━━━━━━━━━━━━━━━─");
        System.out.println("  STR은 힘, DEX는 회피율 및 치명타, INT는 지능, LUK는 운을 나타내며" +
                "\n  LUK를 제외한 스탯은 스킬과 기본공격 대미지에 영향을 줍니다." +
                "\n  LUK을 1010 달성 시, 모든 공격이 치명타가 됩니다.");

        outer:
        while (true) {
            System.out.println("\n─━━━━━━━━━━━━━━━━━━━━━━━━⊱༻ 거점 : 마을 ༺⊰━━━━━━━━━━━━━━━━━━━━━━━━─\n");
            System.out.println("                       \uD83D\uDC47 행동을 선택해주세요");
            System.out.println("1. \uD83C\uDF0D 필드에 나간다 |2. \uD83D\uDCD6 스테이터스를 확인한다 |3.  ⚔\uFE0F\uD83D\uDD2E 보유 스킬 확인  |4. \uD83D\uDCE6 아이템박스 확인  | 5. \uD83D\uDED2 상점에 들어간다 | 6. ✏\uFE0F 스탯 분배");
            System.out.print("숫자 ▶\uFE0F  ");
            int command = Integer.parseInt(scan.nextLine());

            String nowField = "";

            if (command == 1) {

                while (true) {
                    mainMonsterList.clear();
                    System.out.println("\n─━━━━━━━━━━━━━━━━━━━━━━━━⊱༻ 월드 맵 ༺⊰━━━━━━━━━━━━━━━━━━━━━━━━─\n");
                    System.out.println("                   \uD83D\uDC47 \uD83C\uDF0D  필드를 선택해주세요");
                    System.out.println(field1 + " " + field2 + " " + field3 + " " + field4);
                    System.out.println(field5 + " " + field6 + " " + field7 + " " + field8);
                    System.out.print("숫자 ▶\uFE0F  ");
                    int selectField = Integer.parseInt(scan.nextLine());

                    if (selectField == 1) {
                        boxBox("\uD83C\uDFDE\uFE0F 초심자 평원으로 출발합니다.");
                        MonsterDB.getInstance().inputMonster(mainMonsterList, 0);
                        MonsterDB.getInstance().inputMonster(mainMonsterList, 1);
                        nowField = field1;
                        break;

                    } else if (selectField == 2) {

                        if (user.getLv() < 10) {
                            boxBox("❌입장하기 위한 레벨이 부족합니다.❌");
                            continue;

                        } else {
                            boxBox("\uD83E\uDEA8 무너진 성터로 출발합니다.");
                            MonsterDB.getInstance().inputMonster(mainMonsterList, 3);
                            MonsterDB.getInstance().inputMonster(mainMonsterList, 4);
                            nowField = field2;
                            break;
                        }

                    } else if (selectField == 3) {

                        if (user.getLv() < 20) {
                            boxBox("❌입장하기 위한 레벨이 부족합니다.❌");
                            continue;

                        } else {
                            boxBox("\uD83D\uDED5 옛 전쟁터로 출발합니다.");
                            MonsterDB.getInstance().inputMonster(mainMonsterList, 6);
                            MonsterDB.getInstance().inputMonster(mainMonsterList, 7);
                            MonsterDB.getInstance().inputMonster(mainMonsterList, 8);
                            nowField = field3;
                            break;
                        }

                    } else if (selectField == 4) {

                        if (user.getLv() < 30) {
                            boxBox("❌입장하기 위한 레벨이 부족합니다.❌");
                            continue;

                        } else {
                            boxBox("\uD83C\uDF06 마왕성으로 출발합니다.");
                            MonsterDB.getInstance().inputMonster(mainMonsterList, 10);
                            MonsterDB.getInstance().inputMonster(mainMonsterList, 11);
                            MonsterDB.getInstance().inputMonster(mainMonsterList, 12);
                            nowField = field4;
                            break;
                        }

                    } else if (selectField == 5) {

                        if (user.getLv() < 10) {
                            boxBox("❌입장하기 위한 레벨이 부족합니다.❌");
                            continue;

                        } else {
                            boxBox("⚜\uFE0F 대왕 슬라임에게 도전합니다.");
                            MonsterDB.getInstance().inputMonster(mainMonsterList, 2);
                            nowField = field5;
                            break;
                        }

                    } else if (selectField == 6) {

                        if (user.getLv() < 10) {
                            boxBox("❌입장하기 위한 레벨이 부족합니다.❌");
                            continue;

                        } else {
                            boxBox("⚜\uFE0F 킹 고블린에게 도전합니다.");
                            MonsterDB.getInstance().inputMonster(mainMonsterList, 5);
                            nowField = field6;
                            break;
                        }

                    } else if (selectField == 7) {

                        if (user.getLv() < 20) {
                            boxBox("❌입장하기 위한 레벨이 부족합니다.❌");
                            continue;

                        } else {
                            boxBox("⚜\uFE0F 거대 골렘에게 도전합니다.");
                            MonsterDB.getInstance().inputMonster(mainMonsterList, 9);
                            nowField = field7;
                            break;
                        }

                    } else if (selectField == 8) {

                        if (user.getLv() < 30) {
                            boxBox("❌입장하기 위한 레벨이 부족합니다.❌");
                            continue;

                        } else {
                            boxBox("⚜\uFE0F 드래곤에게 도전합니다.");
                            MonsterDB.getInstance().inputMonster(mainMonsterList, 13);
                            nowField = field8;
                            break;
                        }

                    } else {
                        boxBox("❌잘못 선택했습니다. 다시 선택해주세요.❌");
                        continue;
                    }

                }
                while (true) {
                    System.out.println("\n─━━━━━━━━━━━━━━━━━━━━━━━━⊱༻ 현재 필드 ༺⊰━━━━━━━━━━━━━━━━━━━━━━━━─\n");
                    System.out.println("                   " + nowField);
                    System.out.println("\n[필드에서 할 행동을 선택해주세요]\n");
                    System.out.println("1. \uD83D\uDDE1\uFE0F 전투 | 2. \uD83D\uDCD6 스테이터스를 확인한다 |  3. \uD83D\uDCE6 아이템박스 확인  | 4. ⛺ 거점으로 돌아간다");
                    System.out.print("숫자 ▶\uFE0F  ");

                    int command2 = Integer.parseInt(scan.nextLine());

                    if (command2 == 1) {
                        Monster a = new Monster(MonsterDB.instance.getMonster(mainMonsterList));

                        double rare = UtillMethod.random5perRare();

                        MonsterDB.instance.setMonster(a, user);

                        //레어도에 따른 특수개체 출현 표시

                        String mobName = "";

                        if (rare == 1.0) {
                            mobName = a.getMonsterName();

                        } else if (rare == 1.5) {
                            mobName = ("🌟 특수 개체 출현! 경험치 추가 🌟" + "\n" + "🌟 " + a.getMonsterName());
                        }


                        System.out.println("\n[" + mobName + " Lv." + a.getMonsterLv() + "이(가) 나타났다!]\n");


                        //배틀로직
                        battlInner:
                        while (true) {

                            a.battleMonsterData(a, rare);

                            System.out.println("※※행동을 선택해주세요※※");
                            System.out.println("1. \uD83D\uDDE1\uFE0F 싸운다 | 2. \uD83D\uDCD6 스테이터스를 확인한다 | 3. \uD83D\uDCE6 아이템박스 확인 | 4. \uD83D\uDEB4 도망간다");
                            System.out.print("숫자 ▶\uFE0F  ");
                            int battleCommand = Integer.parseInt(scan.nextLine());

                            if (battleCommand == 1) {
                                boxBox("사용할 스킬을 선택해주세요");
                                boxBox("0을 입력하면 이전 메뉴로 돌아갑니다.");

                                while (true) {
                                    a.battleMonsterData(a, rare);
                                    System.out.println(user);

                                    System.out.println(" ⚔\uFE0F " + "No. 0 - 이전 메뉴로");

                                    Skill.printSkillList(user);

                                    System.out.print("숫자 ▶\uFE0F  ");
                                    int battleSelect = Integer.parseInt(scan.nextLine()) - 1;

                                    if (battleSelect == -1) {
                                        boxBox("이전 메뉴로 돌아갑니다.");
                                        break;

                                    } else if (battleSelect >= user.playerSkillList.size()) {
                                        boxBox("❌잘못 선택했습니다. 다시 선택해주세요.❌");

                                    } else {
                                        // 선택 스킬 설정
                                        Skill userChoiceSkill = user.playerSkillList.get(battleSelect);

                                        if (user.getStatNowMP() < userChoiceSkill.getUseMp()) {
                                            boxBox("마나가 부족합니다. 다시 선택해주세요");
                                            continue;

                                        } else {
                                            int nwMP = user.getStatNowMP();
                                            user.setStatNowMP(user.getStatNowMP() - userChoiceSkill.getUseMp());
                                            boxBox("\uD83D\uDCA0 현재마나 " + nwMP + "➡\uFE0F" + (user.getStatNowMP()));
                                        }

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
                                            boxBox(user.getPlayerName() + "의 " + userChoiceSkill.getSkillName() + "!!", "\uD83D\uDEE1\uFE0F 방어 계열 스킬을 사용했다");
                                            Thread.sleep(400);

                                            if (criticaldamage == 1.5) {
                                                boxBox("❗" + user.getPlayerName() + "은(는) \uD83D\uDEE1\uFE0F완벽한 방어\uD83D\uDEE1\uFE0F를 를 펼쳤다.");
                                                Thread.sleep(400);

                                            }
                                            boxBox(user.getPlayerName() + "은(는) " + " \uD83D\uDCA2 " + defDamage + "만큼의 대미지를 \uD83D\uDEE1\uFE0F방어할 수 있다!");
                                            Thread.sleep(400);

                                            System.out.println("⊶⊷⊶⊷⊶⊷⋆⊶⊷⊶⊷⊶⊶⊷⊶⊷⊶⊷⋆⊶⊷⊶⊷⊶⊶⊷⊶⊷⊶⊷⋆⊶⊷⊶⊷⊶⊶⊷⊶⊷⊶⊷⋆⊶⊷⊶⊷⊶⊶⊷⊶⊷⊶⊷⋆⊶⊷⊶⊷⊶");

                                            if (defDamage > mobBattleDamage) {
                                                boxBox(a.getMonsterName() + "의 " + mobChoiceDamage.getSkillName() + "!!", " \uD83D\uDCA2 " + mobBattleDamage + " 대미지!!");
                                                Thread.sleep(400);
                                                boxBox(user.getPlayerName() + "은(는) 모든 데미지를 \uD83D\uDEE1\uFE0F방어했다!!");
                                                Thread.sleep(400);
                                                System.out.println("⊶⊷⊶⊷⊶⊷⋆⊶⊷⊶⊷⊶⊶⊷⊶⊷⊶⊷⋆⊶⊷⊶⊷⊶⊶⊷⊶⊷⊶⊷⋆⊶⊷⊶⊷⊶⊶⊷⊶⊷⊶⊷⋆⊶⊷⊶⊷⊶⊶⊷⊶⊷⊶⊷⋆⊶⊷⊶⊷⊶");

                                            } else if (defDamage < mobBattleDamage) {

                                                int againMobDamage = Math.abs(defDamage - mobBattleDamage);
                                                user.setStatNowHP(user.getStatNowHP() - againMobDamage);
                                                boxBox(user.getPlayerName() + "은(는) " + a.getMonsterName() + "의 대미지를 모두 막아내지 못했다!!", a.getMonsterName() + "의 " + againMobDamage + "!!");
                                                Thread.sleep(400);
                                                boxBox(user.getPlayerName() + "은(는) " + " \uD83D\uDCA2 " + againMobDamage + "대미지를 입어 체력이" + user.getStatNowHP() + "가 되었다.");
                                                Thread.sleep(400);

                                                System.out.println("⊶⊷⊶⊷⊶⊷⋆⊶⊷⊶⊷⊶⊶⊷⊶⊷⊶⊷⋆⊶⊷⊶⊷⊶⊶⊷⊶⊷⊶⊷⋆⊶⊷⊶⊷⊶⊶⊷⊶⊷⊶⊷⋆⊶⊷⊶⊷⊶⊶⊷⊶⊷⊶⊷⋆⊶⊷⊶⊷⊶");
                                            }

                                        } else {
                                            a.setMonsterHP((a.getMonsterHP() - userBattleDamage));
                                            boxBox(user.getPlayerName() + "의 " + userChoiceSkill.getSkillName() + "!!");
                                            Thread.sleep(400);

                                            if (criticaldamage == 1.5) {
                                                boxBox("❗ 크리티컬 발동!", " \uD83D\uDCA2 " + userBattleDamage + " 대미지!!");
                                                Thread.sleep(400);

                                            } else {
                                                boxBox(" \uD83D\uDCA2 " + userBattleDamage + " 대미지!!");
                                                Thread.sleep(400);
                                            }


                                            //체력이 0이 되면 처치 break;
                                            if (a.getMonsterHP() <= 0) {
                                                a.setMonsterHP(0);
                                                boxBox(a.getMonsterName() + "은(는) " + " \uD83D\uDCA2 " + userBattleDamage + " 대미지를 입어 체력이 " +
                                                        a.getMonsterHP() + "이(가) 되었다.", mobName + " Lv." + a.getMonsterLv() + "을(를) 쓰러뜨렸다!");
                                                Thread.sleep(400);

                                                //경험치 추가 기믹
                                                if (user.getLv() < 40) {
                                                    int exp = a.getExp(a, rare);
                                                    int userExp = user.getExp();
                                                    user.setExp(user.getExp() + exp);
                                                    boxBox("경험치 " + exp + " 획득!", "현재 경험치 :  " + userExp + "➡\uFE0F" + user.getExp(), "필요 경험치" + (user.getNextExp() - user.getExp()));


                                                    Thread.sleep(400);
                                                }

                                                //레벨업 기믹
                                                if (user.getExp() >= user.getNextExp()) {
                                                    Class.levelUP(user, levelDB);

                                                }
                                                // 돈 드랍 기믹
                                                int money = a.getMoney(a, rare);
                                                user.setMoney(user.getMoney() + money);
                                                boxBox(money + "원을 획득했다!", "현재 소지금 : " + user.getMoney());
                                                Thread.sleep(400);


                                                // 아이템 드랍 기믹
                                                Item temp = Item.dropItem(a);

                                                if (!(temp == null)) {
                                                    user.getItemsList().add(temp);
                                                    boxBox(temp.getItemName() + "을(를) 획득했다!!");
                                                }
                                                Thread.sleep(400);

                                                System.out.println("⊶⊷⊶⊷⊶⊷⋆⊶⊷⊶⊷⊶⊶⊷⊶⊷⊶⊷⋆⊶⊷⊶⊷⊶⊶⊷⊶⊷⊶⊷⋆⊶⊷⊶⊷⊶⊶⊷⊶⊷⊶⊷⋆⊶⊷⊶⊷⊶⊶⊷⊶⊷⊶⊷⋆⊶⊷⊶⊷⊶");

                                                break battlInner;

                                            } else {
                                                boxBox(a.getMonsterName() + "은(는) " + " \uD83D\uDCA2 " + userBattleDamage + " 대미지를 입어 체력이 " + a.getMonsterHP() + "이(가) 되었다.");
                                                Thread.sleep(400);
                                            }

                                            System.out.println("⊶⊷⊶⊷⊶⊷⋆⊶⊷⊶⊷⊶⊶⊷⊶⊷⊶⊷⋆⊶⊷⊶⊷⊶⊶⊷⊶⊷⊶⊷⋆⊶⊷⊶⊷⊶⊶⊷⊶⊷⊶⊷⋆⊶⊷⊶⊷⊶⊶⊷⊶⊷⊶⊷⋆⊶⊷⊶⊷⊶");

                                            user.setStatNowHP(user.getStatNowHP() - mobBattleDamage);
                                            boxBox(a.getMonsterName() + "의 " + mobChoiceDamage.getSkillName() + "!!", " \uD83D\uDCA2 " + mobBattleDamage + " 대미지!!");
                                            Thread.sleep(400);

                                            if (user.getStatNowHP() <= 0) {
                                                user.setStatNowHP(0);
                                                boxBox(user.getPlayerName() + "은(는) " + " \uD83D\uDCA2 " + mobBattleDamage + "의 대미지를 입어 체력이" + user.getStatNowHP() + "가 되었다.", user.getPlayerName() + "은()는 사망하였습니다.");
                                                Thread.sleep(400);
                                                System.out.println(":'######::::::'###::::'##::::'##:'########::'#######::'##::::'##:'########:'########::\n" +
                                                        "'##... ##::::'## ##::: ###::'###: ##.....::'##.... ##: ##:::: ##: ##.....:: ##.... ##:\n" +
                                                        " ##:::..::::'##:. ##:: ####'####: ##::::::: ##:::: ##: ##:::: ##: ##::::::: ##:::: ##:\n" +
                                                        " ##::'####:'##:::. ##: ## ### ##: ######::: ##:::: ##: ##:::: ##: ######::: ########::\n" +
                                                        " ##::: ##:: #########: ##. #: ##: ##...:::: ##:::: ##:. ##:: ##:: ##...:::: ##.. ##:::\n" +
                                                        " ##::: ##:: ##.... ##: ##:.:: ##: ##::::::: ##:::: ##::. ## ##::: ##::::::: ##::. ##::\n" +
                                                        ". ######::: ##:::: ##: ##:::: ##: ########:. #######::::. ###:::: ########: ##:::. ##:\n" +
                                                        ":......::::..:::::..::..:::::..::........:::.......::::::...:::::........::..:::::..::\n");
                                                break outer;

                                            } else {
                                                boxBox(user.getPlayerName() + "은(는) " + " \uD83D\uDCA2 " + mobBattleDamage + "의 대미지를 입어 체력이" + user.getStatNowHP() + "가 되었다.");
                                                Thread.sleep(400);
                                            }
                                        }
                                    }
                                }
                            } else if (battleCommand == 2) {
                                System.out.println(user);

                            } else if (battleCommand == 3) {

                                boxBox("아이템 카테고리를 선택해주세요");

                                while (true) {
                                    System.out.println("1. \uD83D\uDDE1\uFE0F 무기 | 2. \uD83D\uDEE1\uFE0F 방어구 | 3. \uD83C\uDF77 포션 | 4. ⛺ 거점으로 돌아간다");
                                    System.out.print("숫자 ▶\uFE0F  ");
                                    int itemLookCommand = Integer.parseInt(scan.nextLine());

                                    if (itemLookCommand >= 4) {
                                        System.out.println("이전으로 돌아갑니다.");
                                        break;
                                    }
                                    if (user.getItemsList().isEmpty()) {
                                        boxBox("아이템이 존재하지 않습니다.", "전투로 돌아갑니다.");
                                        Thread.sleep(400);
                                        break;
                                    }

                                    Class.openItemBox(user, itemLookCommand);
                                    int returnThere = Class.openItemBoxAlpha(user, itemLookCommand);

                                    if (returnThere == 0) {
                                        boxBox("아이템이 존재하지 않습니다.", "전투로 돌아갑니다.");
                                        Thread.sleep(400);
                                        break;
                                    }

                                    boxBox("자세히 볼 장비의 번호를 입력해주세요", "0을 입력하면 전투로 돌아갑니다.");
                                    System.out.print("숫자 ▶\uFE0F  ");
                                    int choicedItem = Integer.parseInt(scan.nextLine()) - 1;

                                    if (choicedItem == -1) {
                                        boxBox("전투로 돌아갑니다.");
                                        continue;
                                    }

                                    returnItemOne(user.getItemsList().get(choicedItem), choicedItem);

                                    System.out.println("1. \uD83D\uDDB2\uFE0F 장착/탈착/사용 | 2. ⛺ 이전으로");
                                    System.out.print("숫자 ▶\uFE0F  ");
                                    int itemLookCommand2 = Integer.parseInt(scan.nextLine());

                                    if (itemLookCommand2 == 1) {

                                        System.out.print("No.숫자 ▶\uFE0F  ");

                                        int choiceItem = Integer.parseInt(scan.nextLine()) - 1;

                                        Class.useItem(choiceItem, user);

                                    } else if (itemLookCommand2 == 2) {
                                        break;

                                    } else {
                                        boxBox("❌잘못 선택했습니다. 다시 선택해주세요.❌");
                                        continue;
                                    }

                                }
                            } else if (battleCommand == 4) {
                                System.out.println(mobName + " Lv." + a.getMonsterLv() + "(으)로부터 도망쳤다!");
                                break;

                            } else {
                                boxBox("❌잘못 선택했습니다. 다시 선택해주세요.❌");
                                continue;
                            }
                        }


                    } else if (command2 == 2) {
                        System.out.println(user);

                    } else if (command2 == 3) {

                        boxBox("아이템 카테고리를 선택해주세요");

                        while (true) {
                            System.out.println("1. \uD83D\uDDE1\uFE0F 무기 | 2. \uD83D\uDEE1\uFE0F 방어구 | 3. \uD83C\uDF77 포션 | 4. ⛺ 거점으로 돌아간다");
                            System.out.print("숫자 ▶\uFE0F  ");
                            int itemLookCommand = Integer.parseInt(scan.nextLine());

                            if (itemLookCommand >= 4) {
                                System.out.println("이전으로 돌아갑니다.");
                                break;
                            }
                            if (user.getItemsList().isEmpty()) {
                                boxBox("아이템이 존재하지 않습니다.", "필드로 돌아갑니다.");
                                Thread.sleep(400);
                                break;
                            }

                            Class.openItemBox(user, itemLookCommand);
                            int returnThere = Class.openItemBoxAlpha(user, itemLookCommand);

                            if (returnThere == 0) {
                                boxBox("아이템이 존재하지 않습니다.", "필드로 돌아갑니다.");
                                Thread.sleep(400);
                                break;
                            }

                            boxBox("자세히 볼 장비의 번호를 입력해주세요", "0을 입력하면 필드로 돌아갑니다.");
                            System.out.print("숫자 ▶\uFE0F  ");
                            int choicedItem = Integer.parseInt(scan.nextLine()) - 1;

                            if (choicedItem == -1) {
                                boxBox("카테고리 선택으로 돌아갑니다.");
                                continue;
                            }

                            returnItemOne(user.getItemsList().get(choicedItem), choicedItem);

                            System.out.println("1. \uD83D\uDDB2\uFE0F 장착/탈착/사용 | 2. ⛺ 이전으로");
                            System.out.print("숫자 ▶\uFE0F  ");

                            int itemLookCommand2 = Integer.parseInt(scan.nextLine());
                            if (itemLookCommand2 == 1) {


                                System.out.print("No.숫자 ▶\uFE0F  ");

                                int choiceItem = Integer.parseInt(scan.nextLine()) - 1;

                                Class.useItem(choiceItem, user);

                            } else if (itemLookCommand2 == 2) {
                                break;

                            } else {
                                boxBox("❌잘못 선택했습니다. 다시 선택해주세요.❌");
                                continue;
                            }


                        }

                    } else if (command2 == 4) {
                        System.out.println("마을로 이동합니다.");
                        break;

                    } else {
                        boxBox("❌잘못 선택했습니다. 다시 선택해주세요.❌");
                        continue;
                    }


                }


            } else if (command == 2) {
                System.out.println(user);

            } else if (command == 3) {
                showSkillName(user.getPlayerSkillList());
                boxBox("자세히 볼 스킬의 번호를 입력해주세요", "0을 입력하면 거점으로 돌아갑니다.");
                System.out.print("숫자 ▶\uFE0F  ");
                int choicedSkill = Integer.parseInt(scan.nextLine()) - 1;

                if (choicedSkill == -1) {
                    boxBox("거점으로 돌아갑니다.");
                    continue;
                }
                returnSkillListone(user.getPlayerSkillList(), choicedSkill);


            } else if (command == 4) {

                boxBox("아이템 카테고리를 선택해주세요");

                while (true) {
                    System.out.println("1. \uD83D\uDDE1\uFE0F 무기 | 2. \uD83D\uDEE1\uFE0F 방어구 | 3. \uD83C\uDF77 포션 | 4. ⛺ 거점으로 돌아간다");
                    System.out.print("숫자 ▶\uFE0F  ");
                    int itemLookCommand = Integer.parseInt(scan.nextLine());

                    if (itemLookCommand >= 4) {
                        System.out.println("이전으로 돌아갑니다.");
                        break;
                    }
                    if (user.getItemsList().isEmpty()) {
                        boxBox("아이템이 존재하지 않습니다.", "거점으로 돌아갑니다.");
                        Thread.sleep(400);
                        break;
                    }

                    Class.openItemBox(user, itemLookCommand);
                    int returnThere = Class.openItemBoxAlpha(user, itemLookCommand);

                    if (returnThere == 0) {
                        boxBox("아이템이 존재하지 않습니다.", "거점으로 돌아갑니다.");
                        Thread.sleep(400);
                        break;
                    }

                    boxBox("자세히 볼 장비의 번호를 입력해주세요", "0을 입력하면 거점으로 돌아갑니다.");
                    System.out.print("숫자 ▶\uFE0F  ");
                    int choicedItem = Integer.parseInt(scan.nextLine()) - 1;

                    if (choicedItem == -1) {
                        boxBox("카테고리 선택으로 돌아갑니다.");
                        continue;
                    }

                    returnItemOne(user.getItemsList().get(choicedItem), choicedItem);

                    System.out.println("1. \uD83D\uDDB2\uFE0F 장착/탈착/사용 | 2. ⛺ 이전으로");
                    System.out.print("숫자 ▶\uFE0F  ");
                    int itemLookCommand2 = Integer.parseInt(scan.nextLine());
                    if (itemLookCommand2 == 1) {

                        System.out.print("No.숫자 ▶\uFE0F  ");

                        int choiceItem = Integer.parseInt(scan.nextLine()) - 1;

                        Class.useItem(choiceItem, user);

                    } else if (itemLookCommand2 == 2) {
                        break;

                    } else {
                        boxBox("❌잘못 선택했습니다. 다시 선택해주세요.❌");
                        continue;
                    }

                }
            } else if (command == 5) {
                boxBox("상점으로 이동합니다.");
                boxBox("아이템 카테고리를 선택해주세요");

                while (true) {
                    System.out.println("1. 💰 구입 | 2. \uD83D\uDCB8 판매 | 3. ⛺ 이전으로 ");
                    System.out.print("숫자 ▶\uFE0F  ");

                    int itemShopCommandFirst = Integer.parseInt(scan.nextLine());

                    if (itemShopCommandFirst == 1) {
                        System.out.println("\n1. \uD83D\uDDE1\uFE0F 무기 | 2. \uD83D\uDEE1\uFE0F 방어구 | 3. \uD83C\uDF77 포션 | 4. ⛺ 거점으로 돌아간다");
                        System.out.print("숫자 ▶\uFE0F  ");

                        int itemShopCommand = Integer.parseInt(scan.nextLine());

                        if (itemShopCommand >= 4) {
                            boxBox("거점으로 돌아갑니다.");
                            break;
                        }

                        System.out.println("\n");

                        Item.showShop(shopDB, itemShopCommand);
                        System.out.println(user.getMoney());

                        boxBox("구매할 아이템 번호를 선택해 주세요.");
                        System.out.print("숫자 ▶\uFE0F  ");
                        int itemBuyCommand = Integer.parseInt(scan.nextLine()) - 1;
                        // 💰 구입하기
                        boolean reallyGetMoney = Class.buyItemAlpha(itemBuyCommand, user, shopDB);

                        if (reallyGetMoney) {
                            Class.buyItem(itemBuyCommand, user, shopDB);
                            System.out.println("※※방금 구매한 아이템 장착/사용하시겠습니까?※※");
                            System.out.println("※※ Y /N ※※");
                            System.out.print("▶\uFE0F  ");
                            String setNowBuyItem = scan.nextLine();

                            if (setNowBuyItem.equals("y")) {
                                Class.useItem(Class.lastestItem(user), user);
                            }

                        } else {
                            boxBox("돈이 부족합니다.", "상점 입구로 돌아갑니다.");
                            break;
                        }

                    } else if (itemShopCommandFirst == 2) {
                        boxBox("아이템 카테고리를 선택해주세요");
                        System.out.println("1. \uD83D\uDDE1\uFE0F 무기 | 2. \uD83D\uDEE1\uFE0F 방어구 | 3. \uD83C\uDF77 포션 | 4. ⛺ 거점으로 돌아간다");
                        System.out.print("숫자 ▶\uFE0F  ");
                        int itemSellCommand = Integer.parseInt(scan.nextLine());
                        // 판매하기
                        if (itemSellCommand >= 4) {
                            boxBox("거점으로 돌아갑니다.");
                            break;
                        }

                        Class.openItemBox(user, itemSellCommand);

                        int returnThere = Class.openItemBoxAlpha(user, itemSellCommand);

                        if (returnThere == 0) {
                            boxBox("거점으로 돌아갑니다.");
                            Thread.sleep(400);
                            break;
                        }

                        System.out.print("숫자 ▶\uFE0F  ");

                        int choiceItem = Integer.parseInt(scan.nextLine()) - 1;

                        Class.sellItem(choiceItem, user);

                    } else if (itemShopCommandFirst == 3) {
                        break;

                    } else {
                        boxBox("❌잘못 선택했습니다. 다시 선택해주세요.❌");
                        continue;
                    }


                }

            } else if (command == 6) {
                boxBox("스탯을 자유롭게 분배해 보세요");

                if (user.getExtraStat() == 0) {
                    boxBox("여유 스탯이 없습니다. 레벨업을 하여 스탯을 모아주세요");

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
                        boxBox("체력과 마나는 여유스탯 +1 당 +3으로 계산됩니다.", "현재 사용 가능 \uD83E\uDEA9 포인트 : " + user.getExtraStat());
                        System.out.println("[1. \uD83D\uDCAA STR | 2. \uD83C\uDFAF DEX | 3. \uD83C\uDF93 INT | 4. \uD83C\uDFB2 LUK | 5. ❤\uFE0F HP | 6. \uD83D\uDCA0 MP | 7. ⛺ 거점으로 돌아간다]");
                        System.out.print("올릴 스탯 번호 ▶\uFE0F  ");
                        int statIndexNum = Integer.parseInt(scan.nextLine());

                        if (statIndexNum == 7) {
                            break;
                        }
                        System.out.print("올릴 스탯 양 ▶\uFE0F  ");
                        int statNum = Integer.parseInt(scan.nextLine());

                        if (user.getExtraStat() < statNum) {
                            boxBox("잘못된 수치를 입력하셨습니다.");
                            continue;
                        }

                        if (statIndexNum == 1) {
                            user.setStatSTR(user.getStatSTR() + statNum);
                            System.out.println("\n \uD83D\uDCAA STR " + a + "➡\uFE0F" + (user.getStatSTR()));
                            user.setExtraStat(user.getExtraStat() - statNum);

                        } else if (statIndexNum == 2) {
                            user.setStatDEX(user.getStatDEX() + statNum);
                            System.out.println("\n \uD83C\uDFAF DEX " + b + "➡\uFE0F" + (user.getStatDEX()));
                            user.setExtraStat(user.getExtraStat() - statNum);

                        } else if (statIndexNum == 3) {
                            user.setStatINT(user.getStatINT() + statNum);
                            System.out.println("\n \uD83C\uDF93 INT " + c + "➡\uFE0F" + (user.getStatINT()));
                            user.setExtraStat(user.getExtraStat() - statNum);

                        } else if (statIndexNum == 4) {
                            user.setStatLUK(user.getStatLUK() + statNum);
                            System.out.println("\n \uD83C\uDFB2 LUK " + d + "➡\uFE0F" + (user.getStatLUK()));
                            user.setExtraStat(user.getExtraStat() - statNum);

                        } else if (statIndexNum == 5) {
                            user.setStatNowHP(user.getStatNowHP() + +(statNum * 3));
                            user.setStatMaxHP(user.getStatMaxHP() + +(statNum * 3));
                            user.setExtraStat(user.getExtraStat() - statNum);
                            System.out.println("\n ❤\uFE0F 현재체력 " + e + "➡\uFE0F" + (user.getStatNowHP()));
                            System.out.println("\n ❤\uFE0F 최대체력 " + f + "➡\uFE0F" + (user.getStatMaxHP()));

                        } else if (statIndexNum == 6) {
                            user.setStatNowMP(user.getStatNowMP() + +(statNum * 3));
                            user.setStatMaxMP(user.getStatMaxMP() + +(statNum * 3));
                            System.out.println("\n \uD83D\uDCA0 현재마나 " + g + "➡\uFE0F" + (user.getStatNowMP()));
                            System.out.println("\n \uD83D\uDCA0 최대마나 " + h + "➡\uFE0F" + (user.getStatMaxMP()));
                            user.setExtraStat(user.getExtraStat() - statNum);
                        }

                        System.out.println("\n현재 사용 가능 \uD83E\uDEA9 포인트 : " + user.getExtraStat() + "\n");


                    }
                }
            } else {
                boxBox("❌잘못 선택했습니다. 다시 선택해주세요.❌");
            }


        }
    }
}
