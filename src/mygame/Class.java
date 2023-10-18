package mygame;

import java.util.ArrayList;

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
        return "Class{" +
                "playerClass='" + playerClass + '\'' +
                ", playerName='" + playerName + '\'' +
                ", lv=" + lv +
                ", exp=" + exp +
                ", nextExp=" + nextExp +
                ", statSTR=" + statSTR +
                ", statDEX=" + statDEX +
                ", statINT=" + statINT +
                ", statLUK=" + statLUK +
                ", statNowHP=" + statNowHP +
                ", statMaxHP=" + statMaxHP +
                ", statNowMP=" + statNowMP +
                ", statMaxMP=" + statMaxMP +
                ", extraStat=" + extraStat +
                ", money=" + money +
                ", weapon=" + weapon +
                ", equiq=" + equiq +
                ", playerSkillList=" + playerSkillList +
                ", itemsList=" + itemsList +
                '}';
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

        if (user.getPlayerClass().contains("전사")) {
            if (Class.getWarrior().itemsList.isEmpty()) {
                System.out.println("아이템이 존재하지 않습니다.");

            } else {
                if (inputNum == 1) {
                    for (Item item : Class.getWarrior().itemsList) {
                        if (item.getItemType().contains("무기")) {
                            System.out.println("No." + Class.getWarrior().itemsList.indexOf(item) + item);
                        }

                    }
                } else if (inputNum == 2) {
                    for (Item item : Class.getWarrior().itemsList) {
                        if (item.getItemType().contains("방어구")) {
                            System.out.println("No." + Class.getWarrior().itemsList.indexOf(item) + item);
                        }
                    }
                } else if (inputNum == 3) {
                    for (Item item : Class.getWarrior().itemsList) {

                        if (item.getItemType().contains("포션")) {
                            System.out.println("No." + Class.getWarrior().itemsList.indexOf(item) + item);
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
                            System.out.println("No." + Class.getMagician().itemsList.indexOf(item) + item);
                        }

                    }
                } else if (inputNum == 2) {
                    for (Item item : Class.getMagician().itemsList) {
                        if (item.getItemType().contains("방어구")) {
                            System.out.println("No." + Class.getMagician().itemsList.indexOf(item) + item);
                        }
                    }
                } else if (inputNum == 3) {
                    for (Item item : Class.getMagician().itemsList) {

                        if (item.getItemType().contains("포션")) {
                            System.out.println("No." + Class.getMagician().itemsList.indexOf(item) + item);
                        }
                    }
                }
            }
        }
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
            System.out.println("스탯 : STR " + a + "➡\uFE0F" + (user.getStatSTR()));
        }
        if (b < user.getStatDEX()) {
            System.out.println("스탯 : DEX " + b + "➡\uFE0F" + (user.getStatDEX()));
        }
        if (c < user.getStatINT()) {
            System.out.println("스탯 : INT " + c + "➡\uFE0F" + (user.getStatINT()));
        }
        if (d < user.getStatLUK()) {
            System.out.println("스탯 : LUK " + d + "➡\uFE0F" + (user.getStatLUK()));
        }
        if (e < user.getStatNowHP()) {
            System.out.println("스탯 : 현재체력 " + e + "➡\uFE0F" + (user.getStatNowHP()));
        }
        if (f < user.getStatMaxHP()) {
            System.out.println("스탯 : 최대체력 " + f + "➡\uFE0F" + (user.getStatMaxHP()));
        }
        if (g < user.getStatNowMP()) {
            System.out.println("스탯 : 현재마나 " + g + "➡\uFE0F" + (user.getStatNowMP()));
        }
        if (h < user.getStatMaxMP()) {
            System.out.println("스탯 : 최대마나 " + h + "➡\uFE0F" + (user.getStatMaxMP()));
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
            System.out.println("스탯 : STR " + a + "➡\uFE0F" + (user.getStatSTR()));
        }
        if (b > user.getStatDEX()) {
            System.out.println("스탯 : DEX " + b + "➡\uFE0F" + (user.getStatDEX()));
        }
        if (c > user.getStatINT()) {
            System.out.println("스탯 : INT " + c + "➡\uFE0F" + (user.getStatINT()));
        }
        if (d > user.getStatLUK()) {
            System.out.println("스탯 : LUK " + d + "➡\uFE0F" + (user.getStatLUK()));
        }
        if (e > user.getStatNowHP()) {
            System.out.println("스탯 : 현재체력 " + e + "➡\uFE0F" + (user.getStatNowHP()));
        }
        if (f > user.getStatMaxHP()) {
            System.out.println("스탯 : 최대체력 " + f + "➡\uFE0F" + (user.getStatMaxHP()));
        }
        if (g > user.getStatNowMP()) {
            System.out.println("스탯 : 현재마나 " + g + "➡\uFE0F" + (user.getStatNowMP()));
        }
        if (h > user.getStatMaxMP()) {
            System.out.println("스탯 : 최대마나 " + h + "➡\uFE0F" + (user.getStatMaxMP()));
        }
    }


    public static void useItem(int choiceNum, Class user) {
        ArrayList<Item> temp = user.getItemsList();

        Item im = temp.get(choiceNum);

        if (im.getItemType().contains("포션") && !im.isNowEq()) {
            System.out.println(im.getItemName() + "을(를) 사용했습니다.");

            im.setNowEq(true);

            showChangeUpStat(choiceNum, user);
            if (temp.get(choiceNum).isNowEq()) {
                temp.remove(choiceNum);
            }

        } else if (im.getItemType().contains("무기")) {
            //장비하고 있는 장비가 하나도 없을 때
            if (user.getWeapon() == null) {

                user.setWeapon(im);
                System.out.println(user.getWeapon().getItemName() + "을(를) 장착했습니다.");


                showChangeUpStat(choiceNum, user);

                im.setNowEq(true);
                //장비하고 있는게 있을 때
            } else {
                System.out.println(user.getWeapon().getItemName() + "을(를) 탈착했습니다.");
                showChangeDownStat(user.getItemsList().indexOf(user.getWeapon()), user);

                user.getWeapon().setNowEq(false);
                user.setWeapon(null);
                System.out.println("=====================================");
                user.setWeapon(im);
                System.out.println(user.getWeapon().getItemName() + "을(를) 장착했습니다.");


                showChangeUpStat(choiceNum, user);

                im.setNowEq(true);


            }

        } else if (im.getItemType().contains("방어구")) {
            if (user.getEquiq() == null) {

                user.setEquiq(im);
                System.out.println(user.getEquiq().getItemName() + "을(를) 장착했습니다.");


                showChangeUpStat(choiceNum, user);

                im.setNowEq(true);
                //장비하고 있는게 있을 때
            } else {
                System.out.println(user.getEquiq().getItemName() + "을(를) 탈착했습니다.");
                showChangeDownStat(user.getItemsList().indexOf(user.getEquiq()), user);

                user.getEquiq().setNowEq(false);
                user.setEquiq(null);
                System.out.println("=====================================");
                user.setEquiq(im);
                System.out.println(user.getEquiq().getItemName() + "을(를) 장착했습니다.");


                showChangeUpStat(choiceNum, user);

                im.setNowEq(true);


            }
        }
    }


    /**
     * 최종 레벨업 기믹
     *
     * @param user    유저 정보
     * @param levelDB 레벨 리스트
     */
    public static void levelUP(Class user, LevelDB levelDB) {
        while (user.getExp() >= user.getNextExp() && user.getLv() < 40) {
            if (user.getExp() >= user.getNextExp()) {
                if (user.getPlayerClass().equals("전사") ||
                        user.getPlayerClass().equals("용사")) {
                    user.setStatSTR(user.getStatSTR() + 3);
                    user.setStatDEX(user.getStatDEX() + 2);
                    user.setStatINT(user.getStatINT() + 1);
                    user.setStatNowHP(user.getStatNowHP() + 10);
                    user.setStatMaxHP(user.getStatMaxHP() + 10);
                    user.setStatNowMP(user.getStatNowMP() + 8);
                    user.setStatMaxMP(user.getStatMaxMP() + 8);
                    user.setStatLUK(user.getStatLUK() + 1);
                    user.setExtraStat(user.getExtraStat() + 4);

                } else if (user.getPlayerClass().equals("마법사") ||
                        user.getPlayerClass().equals("현자")) {
                    user.setStatSTR(user.getStatSTR() + 1);
                    user.setStatDEX(user.getStatDEX() + 1);
                    user.setStatINT(user.getStatINT() + 4);
                    user.setStatNowHP(user.getStatNowHP() + 6);
                    user.setStatMaxHP(user.getStatMaxHP() + 6);
                    user.setStatNowMP(user.getStatNowMP() + 12);
                    user.setStatMaxMP(user.getStatMaxMP() + 12);
                    user.setStatLUK(user.getStatLUK() + 1);
                    user.setExtraStat(user.getExtraStat() + 4);
                }
            }

            user.setExp(user.getExp() - user.getNextExp());
            user.setLv(user.getLv() + 1);
            user.setNextExp(levelDB.LevelUP(user.getLv()));
            System.out.println("레벨 업!! 레벨이 " + user.getLv() + "이 되었다!!");
            UtillMethod.userSetSkill(user);

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
    private static Class warrior = new Class("전사", "", 1, 0, 10, 1200, 10, 7, 5, 17, 17, 9, 9, 0, 1000);
    private static Class magician = new Class("마법사", "", 1, 0, 10, 700, 100, 1002, 5, 14, 14, 12, 12, 0, 1000);

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
