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
    private int statHP; /* 캐릭터 체력*/
    private int statMP; /*캐릭터 마나*/
    public ArrayList<Skill> playerSkillList = new ArrayList<>();


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
                ", statHP=" + statHP +
                ", statMP=" + statMP +
                ", playerSkillList=" + playerSkillList +
                '}';
    }

    public ArrayList<Skill> getPlayerSkillList() {
        return playerSkillList;
    }

    public void setPlayerSkillList(ArrayList<Skill> playerSkillList) {
        this.playerSkillList = playerSkillList;
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
                    user.setStatHP(user.getStatHP() + 10);
                    user.setStatMP(user.getStatMP() + 8);
                    user.setStatLUK(user.getStatLUK() + 1);

                } else if (user.getPlayerClass().equals("마법사") ||
                        user.getPlayerClass().equals("현자")) {
                    user.setStatSTR(user.getStatSTR() + 1);
                    user.setStatDEX(user.getStatDEX() + 1);
                    user.setStatINT(user.getStatINT() + 4);
                    user.setStatHP(user.getStatHP() + 6);
                    user.setStatMP(user.getStatMP() + 12);
                    user.setStatLUK(user.getStatLUK() + 1);
                }
            }

            user.setExp(user.getExp() - user.getNextExp());
            user.setLv(user.getLv() + 1);
            user.setNextExp(levelDB.LevelUP(user.getLv()));
            System.out.println("레벨 업!! 레벨이 " + user.getLv() + "이 되었다!!");

        }
    }




    public Class() {
    }

    // 초기 캐릭터 설정
    private static Class warrior = new Class("전사", "", 1, 0, 10, 12, 10, 7, 5, 17, 9);
    private static Class magician = new Class("마법사", "", 1, 0, 10, 7, 10, 12, 5, 14, 12);

    public static Class getWarrior() {
        return warrior;
    }

    public static Class getMagician() {
        return magician;
    }


    public Class(String playerClass, String playerName, int lv, int exp, int nextExp, int statSTR, int statDEX, int statINT, int statLUK, int statHP, int statMP) {
        this.playerClass = playerClass;
        this.playerName = playerName;
        this.lv = lv;
        this.exp = exp;
        this.nextExp = nextExp;
        this.statSTR = statSTR;
        this.statDEX = statDEX;
        this.statINT = statINT;
        this.statLUK = statLUK;
        this.statHP = statHP;
        this.statMP = statMP;
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

    public int getStatHP() {
        return statHP;
    }

    public void setStatHP(int statHP) {
        this.statHP = statHP;
    }

    public int getStatMP() {
        return statMP;
    }

    public void setStatMP(int statMP) {
        this.statMP = statMP;
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

    public static void setMagician(Class magician) {
        Class.magician = magician;
    }
}
