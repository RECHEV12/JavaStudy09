package mygame;

public class Monster {
    @Override
    public String toString() {
        return "Monster{" +
                "monsterGroup=" + monsterGroup +
                ", monsterNum=" + monsterNum +
                ", monsterName='" + monsterName + '\'' +
                ", monsterLv=" + monsterLv +
                ", monsterType='" + monsterType + '\'' +
                ", monsterATK=" + monsterATK +
                ", monsterDEF=" + monsterDEF +
                ", monsterHP=" + monsterHP +
                '}';
    }

    public int getMonsterGroup() {
        return monsterGroup;
    }

    public void setMonsterGroup(int monsterGroup) {
        this.monsterGroup = monsterGroup;
    }

    public Monster(int monsterGroup, int monsterNum, String monsterName, int monsterLv, String monsterType, int monsterATK, int monsterDEF, int monsterHP) {
        this.monsterGroup = monsterGroup;
        this.monsterNum = monsterNum;
        this.monsterName = monsterName;
        this.monsterLv = monsterLv;
        this.monsterType = monsterType;
        this.monsterATK = monsterATK;
        this.monsterDEF = monsterDEF;
        this.monsterHP = monsterHP;
    }

    private int monsterGroup;
    private int monsterNum;
    private String monsterName;
    private int monsterLv;
    private String monsterType;
    private int monsterATK;
    private int monsterDEF;

    public Monster(int monsterNum, String monsterName, int monsterLv, String monsterType, int monsterATK, int monsterDEF, int monsterHP) {
        this.monsterNum = monsterNum;
        this.monsterName = monsterName;
        this.monsterLv = monsterLv;
        this.monsterType = monsterType;
        this.monsterATK = monsterATK;
        this.monsterDEF = monsterDEF;
        this.monsterHP = monsterHP;
    }

    public int getMonsterHP() {
        return monsterHP;
    }

    public void setMonsterHP(int monsterHP) {
        this.monsterHP = monsterHP;
    }

    private int monsterHP;

    public Monster() {
    }

    public Monster(int monsterNum, String monsterName, int monsterLv, String monsterType, int monsterATK, int monsterDEF) {
        this.monsterNum = monsterNum;
        this.monsterName = monsterName;
        this.monsterLv = monsterLv;
        this.monsterType = monsterType;
        this.monsterATK = monsterATK;
        this.monsterDEF = monsterDEF;
    }

    public int getMonsterNum() {
        return monsterNum;
    }

    public void setMonsterNum(int monsterNum) {
        this.monsterNum = monsterNum;
    }

    public String getMonsterName() {
        return monsterName;
    }

    public void setMonsterName(String monsterName) {
        this.monsterName = monsterName;
    }

    public int getMonsterLv() {
        return monsterLv;
    }

    public void setMonsterLv(int monsterLv) {
        this.monsterLv = monsterLv;
    }

    public String getMonsterType() {
        return monsterType;
    }

    public void setMonsterType(String monsterType) {
        this.monsterType = monsterType;
    }

    public int getMonsterATK() {
        return monsterATK;
    }

    public void setMonsterATK(int monsterATK) {
        this.monsterATK = monsterATK;
    }

    public int getMonsterDEF() {
        return monsterDEF;
    }

    public void setMonsterDEF(int monsterDEF) {
        this.monsterDEF = monsterDEF;
    }
}

