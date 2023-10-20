package mygame;

import java.util.ArrayList;

import static mygame.Item.returnItemOne;
import static mygame.Item.returnItemOneName;

public class Class {
    private String playerClass; /*캐릭터 직업*/
    private String playerName; /*플레이어 이름*/
    private int lv; /*플레이어 레벨*/
    private int exp; /*경험치*/
    private int nextExp; /*다음 레벨업을 위한 경험치*/
    private int statSTR; /*캐릭터 힘*/
    private int statDEX; /*캐릭터 명중률/회피율*/
    private int statINT; /*캐릭터 지능*/
    private int statLUK; /*캐릭터 운*/
    private int statNowHP; /* 캐릭터 체력*/
    private int statMaxHP; /* 캐릭터 체력*/
    private int statNowMP; /*캐릭터 마나*/
    private int statMaxMP; /*캐릭터 마나*/
    private int extraStat; /*캐릭터 스탯 분배 여분 포인트*/


    @Override
    public String toString() {
        String weaponNull = "없음";
        String equiqNull = "없음";
        if (!(weapon == null)) {
            weaponNull = weapon.getItemName();
        }
        if (!(equiq == null)) {
            equiqNull = equiq.getItemName();
        }

        return
                "╔═════════════════════════════════════════════════════════════════╗" + '\n' +
                        "직업 : " + playerClass + '\n' +
                        "이름 : " + playerName + "  레벨 : " + lv + '\n' +
                        "현재 경험치 : " + exp + "  레벨업 요구치 : " + (nextExp - exp) + '\n' +
                        "\uD83D\uDCAA STR : " + statSTR + "  \uD83C\uDFAF DEX : " + statDEX + '\n' +
                        "\uD83C\uDF93 INT : " + statINT + "  \uD83C\uDFB2 LUK : " + statLUK + '\n' +
                        "❤\uFE0F 현재체력 : " + statNowHP + "  ❤\uFE0F 최대체력 : " + statMaxHP + '\n' +
                        "\uD83D\uDCA0 현재마나 : " + statNowMP + "  \uD83D\uDCA0 최대마나 : " + statMaxMP + '\n' +
                        "\uD83E\uDEA9 여분 스탯 : " + extraStat + "  \uD83D\uDCB0 소지금 : " + money + '\n' +
                        "\uD83D\uDDE1\uFE0F 무기 : " + weaponNull + "  \uD83D\uDEE1\uFE0F 방어구 : " + equiqNull + '\n' +
                        "╚═════════════════════════════════════════════════════════════════╝";
    }

    private int money; /*소지금*/
    private Item weapon; /*캐릭터 무기*/
    private Item equiq; /*캐릭터 방어구*/
    public ArrayList<Skill> playerSkillList = new ArrayList<>(); /*캐릭터 스킬 리스트*/
    private ArrayList<Item> itemsList = new ArrayList<>(); /*캐릭터 아이템 리스트*/


    public static void setEq(Class user, int myItemNumindex) {
        Item itemA = new Item();
        itemA = user.itemsList.get(myItemNumindex);
//        user.setWeapon();
//        user.setEquiq();
    }


    // 아이템 박스 열람
    public static void openItemBox(Class user, int inputNum) {
        if (!user.getItemsList().isEmpty()) {
            if (user.getPlayerClass().contains("전사")) {
                if (Class.getWarrior().itemsList.isEmpty()) {
                    System.out.println("아이템이 존재하지 않습니다.");

                } else {
                    if (inputNum == 1) {
                        for (Item item : Class.getWarrior().itemsList) {
                            if (item.getItemType().contains("무기")) {
                                returnItemOneName(item, Class.getWarrior().itemsList.indexOf(item));


                            } else {
                                UtillMethod.boxBox("무기가 없습니다");
                            }

                        }
                    } else if (inputNum == 2) {
                        for (Item item : Class.getWarrior().itemsList) {
                            if (item.getItemType().contains("방어구")) {
                                returnItemOneName(item, Class.getWarrior().itemsList.indexOf(item));
                            } else {
                                UtillMethod.boxBox("방어구가 없습니다");
                            }
                        }
                    } else if (inputNum == 3) {
                        for (Item item : Class.getWarrior().itemsList) {

                            if (item.getItemType().contains("포션")) {
                                returnItemOneName(item, Class.getWarrior().itemsList.indexOf(item));

                            } else {
                                UtillMethod.boxBox("포션이 없습니다");
                            }
                        }
                    }

                }
            } else if (user.getPlayerClass().contains("마법사")) {
                if (Class.getMagician().itemsList.isEmpty()) {
                    System.out.println("아이템이 존재하지 않습니다.");
                } else {
                    if (inputNum == 1) {
                        for (Item item : Class.getMagician().itemsList) {
                            if (item.getItemType().contains("무기")) {
                                returnItemOneName(item, Class.getMagician().itemsList.indexOf(item));


                            } else {
                                UtillMethod.boxBox("무기가 없습니다");
                            }

                        }
                    } else if (inputNum == 2) {
                        for (Item item : Class.getMagician().itemsList) {
                            if (item.getItemType().contains("방어구")) {

                                returnItemOneName(item, Class.getMagician().itemsList.indexOf(item));

                            } else {
                                UtillMethod.boxBox("방어구가 없습니다");
                            }
                        }
                    } else if (inputNum == 3) {
                        for (Item item : Class.getMagician().itemsList) {

                            if (item.getItemType().contains("포션")) {
                                returnItemOneName(item, Class.getMagician().itemsList.indexOf(item));

                            } else {
                                UtillMethod.boxBox("포션이 없습니다");
                            }
                        }
                    }
                }
            }
        } else {
            UtillMethod.boxBox("아이템이 존재하지 않습니다.");
        }
    }

    public static int openItemBoxAlpha(Class user, int inputNum) {
        int a = 1;

        if (user.getPlayerClass().contains("전사")) {
            if (Class.getWarrior().itemsList.isEmpty()) {

                a = 0;

            } else {
                if (inputNum == 1) {
                    for (Item item : Class.getWarrior().itemsList) {
                        if (item.getItemType().contains("무기")) {

                        } else {

                            a = 0;
                        }

                    }
                } else if (inputNum == 2) {
                    for (Item item : Class.getWarrior().itemsList) {
                        if (item.getItemType().contains("방어구")) {

                        } else {

                            a = 0;
                        }
                    }
                } else if (inputNum == 3) {
                    for (Item item : Class.getWarrior().itemsList) {

                        if (item.getItemType().contains("포션")) {

                        } else {

                            a = 0;
                        }
                    }
                }

            }
        } else if (user.getPlayerClass().contains("마법사")) {
            if (Class.getMagician().itemsList.isEmpty()) {
                System.out.println("아이템이 존재하지 않습니다.");
                a = 0;
            } else {
                if (inputNum == 1) {
                    for (Item item : Class.getMagician().itemsList) {
                        if (item.getItemType().contains("무기")) {

                        } else {
                            UtillMethod.boxBox("무기가 없습니다");
                            a = 0;
                        }

                    }
                } else if (inputNum == 2) {
                    for (Item item : Class.getMagician().itemsList) {
                        if (item.getItemType().contains("방어구")) {

                        } else {
                            UtillMethod.boxBox("방어구가 없습니다");
                            a = 0;
                        }
                    }
                } else if (inputNum == 3) {
                    for (Item item : Class.getMagician().itemsList) {

                        if (item.getItemType().contains("포션")) {

                        } else {
                            UtillMethod.boxBox("포션이 없습니다");
                            a = 0;
                        }
                    }
                }
            }
        }
        return a;
    }


    //스탯증가표시
    public static void showChangeUpStat(int choiceNum, Class user) {

        ArrayList<Item> temp = user.getItemsList();
        Class newClass = new Class();


        int a = user.getStatSTR();
        int b = user.getStatDEX();
        int c = user.getStatINT();
        int d = user.getStatLUK();
        int e = user.getStatNowHP();
        int f = user.getStatMaxHP();
        int g = user.getStatNowMP();
        int h = user.getStatMaxMP();

        Item im = temp.get(choiceNum);

        user.setStatSTR(user.getStatSTR() + im.getPlusSTR());
        user.setStatDEX(user.getStatDEX() + im.getPlusDEX());
        user.setStatINT(user.getStatINT() + im.getPlusINT());
        user.setStatLUK(user.getStatLUK() + im.getPlusLUK());
        user.setStatNowHP(user.getStatNowHP() + im.getPlusNowHP());
        user.setStatMaxHP(user.getStatMaxHP() + im.getPlusMaxHP());
        user.setStatNowMP(user.getStatNowMP() + im.getPlusNowMP());
        user.setStatMaxMP(user.getStatMaxMP() + im.getPlusMaxMP());

        if (a < user.getStatSTR()) {
            System.out.println("\uD83D\uDCAA STR " + a + "➡\uFE0F" + (user.getStatSTR()));
        }
        if (b < user.getStatDEX()) {
            System.out.println("\uD83C\uDFAF DEX " + b + "➡\uFE0F" + (user.getStatDEX()));
        }
        if (c < user.getStatINT()) {
            System.out.println("\uD83C\uDF93 INT " + c + "➡\uFE0F" + (user.getStatINT()));
        }
        if (d < user.getStatLUK()) {
            System.out.println("\uD83C\uDFB2 LUK " + d + "➡\uFE0F" + (user.getStatLUK()));
        }
        if (e < user.getStatNowHP()) {
            if (user.getStatNowHP() >= user.getStatMaxHP()) {
                user.setStatNowHP(user.getStatMaxHP());
                System.out.println("❤\uFE0F 현재체력 " + e + "➡\uFE0F" + (user.getStatNowHP()));
            } else {
                System.out.println("❤\uFE0F 현재체력 " + e + "➡\uFE0F" + (user.getStatNowHP()));
            }
        }
        if (f < user.getStatMaxHP()) {
            System.out.println("❤\uFE0F 최대체력 " + f + "➡\uFE0F" + (user.getStatMaxHP()));
        }
        if (g < user.getStatNowMP()) {
            if (user.getStatNowMP() >= user.getStatMaxMP()) {
                user.setStatNowMP(user.getStatMaxMP());
                System.out.println("\uD83D\uDCA0 현재마나 " + g + "➡\uFE0F" + (user.getStatNowMP()));
            } else {
                System.out.println("\uD83D\uDCA0 현재마나 " + g + "➡\uFE0F" + (user.getStatNowMP()));
            }
        }
        if (h < user.getStatMaxMP()) {
            System.out.println("\uD83D\uDCA0 최대마나 " + h + "➡\uFE0F" + (user.getStatMaxMP()));
        }


    }

    public static void showChangeDownStat(int choiceNum, Class user) {


        ArrayList<Item> temp = user.getItemsList();
        Class newClass = new Class();


        int a = user.getStatSTR();
        int b = user.getStatDEX();
        int c = user.getStatINT();
        int d = user.getStatLUK();
        int e = user.getStatNowHP();
        int f = user.getStatMaxHP();
        int g = user.getStatNowMP();
        int h = user.getStatMaxMP();

        Item im = temp.get(choiceNum);

        user.setStatSTR(user.getStatSTR() - im.getPlusSTR());
        user.setStatDEX(user.getStatDEX() - im.getPlusDEX());
        user.setStatINT(user.getStatINT() - im.getPlusINT());
        user.setStatLUK(user.getStatLUK() - im.getPlusLUK());
        user.setStatNowHP(user.getStatNowHP() - im.getPlusNowHP());
        user.setStatMaxHP(user.getStatMaxHP() - im.getPlusMaxHP());
        user.setStatNowMP(user.getStatNowMP() - im.getPlusNowMP());
        user.setStatMaxMP(user.getStatMaxMP() - im.getPlusMaxMP());


        if (a > user.getStatSTR()) {
            System.out.println("\uD83D\uDCAA STR " + a + "➡\uFE0F" + (user.getStatSTR()));
        }
        if (b > user.getStatDEX()) {
            System.out.println("\uD83C\uDFAF DEX " + b + "➡\uFE0F" + (user.getStatDEX()));
        }
        if (c > user.getStatINT()) {
            System.out.println("\uD83C\uDF93 INT " + c + "➡\uFE0F" + (user.getStatINT()));
        }
        if (d > user.getStatLUK()) {
            System.out.println("\uD83C\uDFB2 LUK " + d + "➡\uFE0F" + (user.getStatLUK()));
        }
        if (e > user.getStatNowHP()) {
            System.out.println("❤\uFE0F 현재체력 " + e + "➡\uFE0F" + (user.getStatNowHP()));
        }
        if (f > user.getStatMaxHP()) {
            System.out.println("❤\uFE0F 최대체력 " + f + "➡\uFE0F" + (user.getStatMaxHP()));
        }
        if (g > user.getStatNowMP()) {
            System.out.println("\uD83D\uDCA0 현재마나 " + g + "➡\uFE0F" + (user.getStatNowMP()));
        }
        if (h > user.getStatMaxMP()) {
            System.out.println("\uD83D\uDCA0 최대마나 " + h + "➡\uFE0F" + (user.getStatMaxMP()));
        }
    }


    public static void useItem(int choiceNum, Class user) {
        ArrayList<Item> temp = user.getItemsList();

        Item im = temp.get(choiceNum);

        if (im.getItemType().contains("포션") && !im.isNowEq()) {

            UtillMethod.boxBox(im.getItemName() + "을(를) 사용했습니다.");


            showChangeUpStat(choiceNum, user);


                temp.remove(choiceNum);


        } else if (im.getItemType().contains("무기")) {
            //장비하고 있는 장비가 하나도 없을 때
            if (user.getWeapon() == null) {

                user.setWeapon(im);

                UtillMethod.boxBox(user.getWeapon().getItemName() + "을(를) 장착했습니다.");


                showChangeUpStat(choiceNum, user);

                im.setNowEq(true);
                //장비하고 있는게 있을 때
            } else {
                UtillMethod.boxBox(user.getWeapon().getItemName() + "을(를) 탈착했습니다.");

                showChangeDownStat(user.getItemsList().indexOf(user.getWeapon()), user);

                user.getWeapon().setNowEq(false);
                user.setWeapon(null);
                System.out.println("⊶⊷⊶⊷⊶⊷⋆⊶⊷⊶⊷⊶⊶⊷⊶⊷⊶⊷⋆⊶⊷⊶⊷⊶⊶⊷⊶⊷⊶⊷⋆⊶⊷⊶⊷⊶⊶⊷⊶⊷⊶⊷⋆⊶⊷⊶⊷⊶⊶⊷⊶⊷⊶⊷⋆⊶⊷⊶⊷⊶");
                user.setWeapon(im);
                UtillMethod.boxBox(user.getWeapon().getItemName() + "을(를) 장착했습니다.");


                showChangeUpStat(choiceNum, user);

                im.setNowEq(true);


            }

        } else if (im.getItemType().contains("방어구")) {
            if (user.getEquiq() == null) {

                user.setEquiq(im);
                UtillMethod.boxBox(user.getEquiq().getItemName() + "을(를) 장착했습니다.");


                showChangeUpStat(choiceNum, user);

                im.setNowEq(true);
                //장비하고 있는게 있을 때
            } else {
                UtillMethod.boxBox(user.getEquiq().getItemName() + "을(를) 탈착했습니다.");

                showChangeDownStat(user.getItemsList().indexOf(user.getEquiq()), user);

                user.getEquiq().setNowEq(false);
                user.setEquiq(null);
                System.out.println("⊶⊷⊶⊷⊶⊷⋆⊶⊷⊶⊷⊶⊶⊷⊶⊷⊶⊷⋆⊶⊷⊶⊷⊶⊶⊷⊶⊷⊶⊷⋆⊶⊷⊶⊷⊶⊶⊷⊶⊷⊶⊷⋆⊶⊷⊶⊷⊶⊶⊷⊶⊷⊶⊷⋆⊶⊷⊶⊷⊶");
                user.setEquiq(im);
                UtillMethod.boxBox(user.getEquiq().getItemName() + "을(를) 장착했습니다.");


                showChangeUpStat(choiceNum, user);

                im.setNowEq(true);


            }
        }
    }

    public static int lastestItem(Class user) {
        int a = user.getItemsList().size() - 1;
        return a;
    }

    public static void buyItem(int choiceNum, Class user, ShopDB shopDB) {
        if (user.getMoney() < shopDB.getShopList().get(choiceNum).getPrice()) {
            UtillMethod.boxBox("돈이 부족합니다.");
        } else {
            Item item = new Item(shopDB.getShopList().get(choiceNum));
            user.getItemsList().add(item);
            UtillMethod.boxBox(shopDB.getShopList().get(choiceNum).getItemName() + "을(를) 구입했습니다!");
            int a = user.getMoney();
            user.setMoney(user.getMoney() - shopDB.getShopList().get(choiceNum).getPrice());
            UtillMethod.boxBox("소지금 : " + a + "➡\uFE0F" + user.getMoney(), "현재 소지금 : " + user.getMoney());
        }
    }

    public static boolean buyItemAlpha(int choiceNum, Class user, ShopDB shopDB) {
        boolean al = false;
        if (user.getMoney() < shopDB.getShopList().get(choiceNum).getPrice()) {
            al = false;
        } else {
            al = true;
        }
        return al;
    }

    public static void sellItem(int choiceNum, Class user) {
        Item willSellItem = user.getItemsList().get(choiceNum);

        if (willSellItem.isNowEq()) {

            if (willSellItem.getItemType().contains("무기")) {

                UtillMethod.boxBox(user.getWeapon().getItemName() + "을(를) 탈착했습니다.");
                showChangeDownStat(user.getItemsList().indexOf(user.getWeapon()), user);

                user.getWeapon().setNowEq(false);
                user.setWeapon(null);

                System.out.println("⊶⊷⊶⊷⊶⊷⋆⊶⊷⊶⊷⊶⊶⊷⊶⊷⊶⊷⋆⊶⊷⊶⊷⊶⊶⊷⊶⊷⊶⊷⋆⊶⊷⊶⊷⊶⊶⊷⊶⊷⊶⊷⋆⊶⊷⊶⊷⊶⊶⊷⊶⊷⊶⊷⋆⊶⊷⊶⊷⊶");
                UtillMethod.boxBox(willSellItem.getItemName() + "이(가) 판매되었습니다.");
                int a = user.getMoney();
                user.setMoney(user.getMoney() + willSellItem.getPrice());
                UtillMethod.boxBox("소지금 : " + a + "➡\uFE0F" + user.getMoney(), "현재 소지금 : " + user.getMoney());
                user.getItemsList().remove(choiceNum);


            } else if (willSellItem.getItemType().contains("방어구")) {
                UtillMethod.boxBox(user.getEquiq().getItemName() + "을(를) 탈착했습니다.");

                showChangeDownStat(user.getItemsList().indexOf(user.getEquiq()), user);

                user.getEquiq().setNowEq(false);
                user.setEquiq(null);
                System.out.println("⊶⊷⊶⊷⊶⊷⋆⊶⊷⊶⊷⊶⊶⊷⊶⊷⊶⊷⋆⊶⊷⊶⊷⊶⊶⊷⊶⊷⊶⊷⋆⊶⊷⊶⊷⊶⊶⊷⊶⊷⊶⊷⋆⊶⊷⊶⊷⊶⊶⊷⊶⊷⊶⊷⋆⊶⊷⊶⊷⊶");
                UtillMethod.boxBox(willSellItem.getItemName() + "이(가) 판매되었습니다.");

                int a = user.getMoney();
                user.setMoney(user.getMoney() + willSellItem.getPrice());
                UtillMethod.boxBox("소지금 : " + a + "➡\uFE0F" + user.getMoney(), "현재 소지금 : " + user.getMoney());
                user.getItemsList().remove(choiceNum);
            }
        } else {
            UtillMethod.boxBox(willSellItem.getItemName() + "이(가) 판매되었습니다.");
            int a = user.getMoney();
            user.setMoney(user.getMoney() + willSellItem.getPrice());
            UtillMethod.boxBox("소지금 : " + a + "➡\uFE0F" + user.getMoney(), "현재 소지금 : " + user.getMoney());

            user.getItemsList().remove(choiceNum);
        }


        ArrayList<Item> temp = user.getItemsList();
    }

    /**
     * 최종 레벨업 기믹
     *
     * @param user    유저 정보
     * @param levelDB 레벨 리스트
     */
    public static void levelUP(Class user, LevelDB levelDB) throws InterruptedException {

        int a = user.getStatSTR();
        int b = user.getStatDEX();
        int c = user.getStatINT();
        int d = user.getStatLUK();
        int e = user.getStatNowHP();
        int f = user.getStatMaxHP();
        int g = user.getStatNowMP();
        int h = user.getStatMaxMP();

        while (user.getExp() >= user.getNextExp() && user.getLv() < 40) {
            if (user.getExp() >= user.getNextExp()) {
                if (user.getPlayerClass().equals("전사") ||
                        user.getPlayerClass().equals("용사")) {
                    user.setStatSTR(user.getStatSTR() + 3);
                    user.setStatDEX(user.getStatDEX() + 2);
                    user.setStatINT(user.getStatINT() + 1);
                    user.setStatNowHP(user.getStatNowHP() + 5);
                    user.setStatMaxHP(user.getStatMaxHP() + 12);
                    user.setStatNowMP(user.getStatNowMP() + 8);
                    user.setStatMaxMP(user.getStatMaxMP() + 8);
                    user.setStatLUK(user.getStatLUK() + 1);
                    user.setExtraStat(user.getExtraStat() + 4);

                    System.out.println("\uD83D\uDCAA STR " + a + "➡\uFE0F" + (user.getStatSTR()));
                    System.out.println("\uD83C\uDFAF DEX " + b + "➡\uFE0F" + (user.getStatDEX()));
                    System.out.println("\uD83C\uDF93 INT " + c + "➡\uFE0F" + (user.getStatINT()));
                    System.out.println("\uD83C\uDFB2 LUK " + d + "➡\uFE0F" + (user.getStatLUK()));
                    System.out.println("❤\uFE0F 현재체력 " + e + "➡\uFE0F" + (user.getStatNowHP()));
                    System.out.println("❤\uFE0F 최대체력 " + f + "➡\uFE0F" + (user.getStatMaxHP()));
                    System.out.println("\uD83D\uDCA0 현재마나 " + g + "➡\uFE0F" + (user.getStatNowMP()));
                    System.out.println("\uD83D\uDCA0 최대마나 " + h + "➡\uFE0F" + (user.getStatMaxMP()));

                } else if (user.getPlayerClass().equals("마법사") ||
                        user.getPlayerClass().equals("현자")) {
                    user.setStatSTR(user.getStatSTR() + 1);
                    user.setStatDEX(user.getStatDEX() + 1);
                    user.setStatINT(user.getStatINT() + 4);
                    user.setStatNowHP(user.getStatNowHP() + 5);
                    user.setStatMaxHP(user.getStatMaxHP() + 10);
                    user.setStatNowMP(user.getStatNowMP() + 12);
                    user.setStatMaxMP(user.getStatMaxMP() + 12);
                    user.setStatLUK(user.getStatLUK() + 1);
                    user.setExtraStat(user.getExtraStat() + 4);

                    System.out.println("\uD83D\uDCAA STR " + a + "➡\uFE0F" + (user.getStatSTR()));
                    System.out.println("\uD83C\uDFAF DEX " + b + "➡\uFE0F" + (user.getStatDEX()));
                    System.out.println("\uD83C\uDF93 INT " + c + "➡\uFE0F" + (user.getStatINT()));
                    System.out.println("\uD83C\uDFB2 LUK " + d + "➡\uFE0F" + (user.getStatLUK()));
                    System.out.println("❤\uFE0F 현재체력 " + e + "➡\uFE0F" + (user.getStatNowHP()));
                    System.out.println("❤\uFE0F 최대체력 " + f + "➡\uFE0F" + (user.getStatMaxHP()));
                    System.out.println("\uD83D\uDCA0 현재마나 " + g + "➡\uFE0F" + (user.getStatNowMP()));
                    System.out.println("\uD83D\uDCA0 최대마나 " + h + "➡\uFE0F" + (user.getStatMaxMP()));
                }
            }

            user.setExp(user.getExp() - user.getNextExp());
            user.setLv(user.getLv() + 1);
            user.setNextExp(levelDB.LevelUP(user.getLv()));
            UtillMethod.boxBox("레벨 업!! 레벨이 " + user.getLv() + "이 되었다!!");
            UtillMethod.userSetSkill(user);
            Thread.sleep(400);

        }
    }

    public Class() {
    }

    public Class(String playerClass, String playerName, int lv, int exp, int nextExp, int statSTR, int statDEX, int statINT, int statLUK, int statNowHP, int statMaxHP, int statNowMP, int statMaxMP, int extraStat) {
        this.playerClass = playerClass;
        this.playerName = playerName;
        this.lv = lv;
        this.exp = exp;
        this.nextExp = nextExp;
        this.statSTR = statSTR;
        this.statDEX = statDEX;
        this.statINT = statINT;
        this.statLUK = statLUK;
        this.statNowHP = statNowHP;
        this.statMaxHP = statMaxHP;
        this.statNowMP = statNowMP;
        this.statMaxMP = statMaxMP;
        this.extraStat = extraStat;
        this.weapon = weapon;
        this.equiq = equiq;
        this.playerSkillList = playerSkillList;
    }

    // 초기 캐릭터 설정
    private static Class warrior = new Class("전사", "", 1, 0, 10, 12, 10, 7, 5, 17, 17, 9, 9, 0, 1000);
    private static Class magician = new Class("마법사", "", 1, 0, 10, 7, 10, 12, 5, 14, 14, 12, 12, 0, 1000);

    public static Class getWarrior() {
        return warrior;
    }

    public static Class getMagician() {
        return magician;
    }


    public String getPlayerClass() {
        return playerClass;
    }

    public void setPlayerClass(String playerClass) {
        this.playerClass = playerClass;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getLv() {
        return lv;
    }

    public void setLv(int lv) {
        this.lv = lv;
    }

    public int getStatSTR() {
        return statSTR;
    }

    public void setStatSTR(int statSTR) {
        this.statSTR = statSTR;
    }

    public int getStatDEX() {
        return statDEX;
    }

    public void setStatDEX(int statDEX) {
        this.statDEX = statDEX;
    }

    public int getStatINT() {
        return statINT;
    }

    public void setStatINT(int statINT) {
        this.statINT = statINT;
    }

    public int getStatLUK() {
        return statLUK;
    }

    public void setStatLUK(int statLUK) {
        this.statLUK = statLUK;
    }

    public Item getWeapon() {
        return weapon;
    }

    public void setWeapon(Item weapon) {
        this.weapon = weapon;
    }

    public Item getEquiq() {
        return equiq;
    }

    public void setEquiq(Item equiq) {
        this.equiq = equiq;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public int getNextExp() {
        return nextExp;
    }

    public void setNextExp(int nextExp) {
        this.nextExp = nextExp;
    }

    public static void setWarrior(Class warrior) {
        Class.warrior = warrior;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public Class(String playerClass, String playerName, int lv, int exp, int nextExp, int statSTR, int statDEX, int statINT, int statLUK, int statNowHP, int statMaxHP, int statNowMP, int statMaxMP, int extraStat, int money) {
        this.playerClass = playerClass;
        this.playerName = playerName;
        this.lv = lv;
        this.exp = exp;
        this.nextExp = nextExp;
        this.statSTR = statSTR;
        this.statDEX = statDEX;
        this.statINT = statINT;
        this.statLUK = statLUK;
        this.statNowHP = statNowHP;
        this.statMaxHP = statMaxHP;
        this.statNowMP = statNowMP;
        this.statMaxMP = statMaxMP;
        this.extraStat = extraStat;
        this.money = money;
        this.weapon = weapon;
        this.equiq = equiq;
        this.playerSkillList = playerSkillList;
        this.itemsList = itemsList;
    }

    public static void setMagician(Class magician) {
        Class.magician = magician;
    }


    public int getExtraStat() {
        return extraStat;
    }

    public void setExtraStat(int extraStat) {
        this.extraStat = extraStat;
    }


    public ArrayList<Skill> getPlayerSkillList() {
        return playerSkillList;
    }

    public void setPlayerSkillList(ArrayList<Skill> playerSkillList) {
        this.playerSkillList = playerSkillList;
    }

    public int getStatNowHP() {
        return statNowHP;
    }

    public void setStatNowHP(int statNowHP) {
        this.statNowHP = statNowHP;
    }

    public int getStatMaxHP() {
        return statMaxHP;
    }

    public void setStatMaxHP(int statMaxHP) {
        this.statMaxHP = statMaxHP;
    }

    public int getStatNowMP() {
        return statNowMP;
    }

    public void setStatNowMP(int statNowMP) {
        this.statNowMP = statNowMP;
    }

    public int getStatMaxMP() {
        return statMaxMP;
    }

    public void setStatMaxMP(int statMaxMP) {
        this.statMaxMP = statMaxMP;
    }

    public ArrayList<Item> getItemsList() {
        return itemsList;
    }

    public void setItemsList(ArrayList<Item> itemsList) {
        this.itemsList = itemsList;
    }
}
