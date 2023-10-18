package mygame;

import java.util.ArrayList;

public class MonsterDB {
    private ArrayList<Monster> monsterList = new ArrayList<>();

    private MonsterDB() {
        monsterList.add(new Monster(1, 1, "고블린", 0, "참격약점", 5, 5, 10));
        monsterList.add(new Monster(1, monsterList.size() + 1, "슬라임", 0, "참격약점", 5, 5, 10));

        monsterList.add(new Monster(2, monsterList.size() + 1, "대왕슬라임", 10, "참격약점", 5, 5, 10));

        monsterList.add(new Monster(3, monsterList.size() + 1, "홉고블린", 0, "참격약점", 5, 5, 10));
        monsterList.add(new Monster(3, monsterList.size() + 1, "산성슬라임", 0, "참격약점", 5, 5, 10));

        monsterList.add(new Monster(4, monsterList.size() + 1, "킹고블린", 20, "참격약점", 5, 5, 10));

        monsterList.add(new Monster(5, monsterList.size() + 1, "흑랑", 0, "참격약점", 5, 5, 10));
        monsterList.add(new Monster(5, monsterList.size() + 1, "세이렌", 0, "참격약점", 5, 5, 10));
        monsterList.add(new Monster(5, monsterList.size() + 1, "골렘", 0, "참격약점", 5, 5, 10));

        monsterList.add(new Monster(6, monsterList.size() + 1, "거대 골렘", 30, "참격약점", 5, 5, 10));

        monsterList.add(new Monster(7, monsterList.size() + 1, "오우거", 0, "참격약점", 5, 5, 10));
        monsterList.add(new Monster(7, monsterList.size() + 1, "마인", 0, "참격약점", 5, 5, 10));
        monsterList.add(new Monster(7, monsterList.size() + 1, "타천사", 0, "참격약점", 5, 5, 10));

        monsterList.add(new Monster(8, monsterList.size() + 1, "드래곤", 40, "참격약점", 5, 5, 10));

    }

    public static MonsterDB instance = new MonsterDB();

    public static MonsterDB getInstance() {
        return instance;
    }

    /**
     * 몬스터 정보 입력
     *
     * @param monsterDB 메인 리스트
     * @param a         넣고자 하는 몬스터의 인덱스
     */
    public void inputMonster(ArrayList monsterDB, int a) {
        monsterDB.add(getInstance().getMonsterList().get(a));
    }


    public Monster settingLevel(ArrayList monsterDB) {
        int alpha = UtillMethod.makeRandom(0, monsterDB.size() - 1);
        Monster a = MonsterDB.instance.monsterList.get(alpha);

        if (a.getMonsterGroup() == 1) {
            a.setMonsterLv(UtillMethod.makeRandom(1, 9));
        } else if (a.getMonsterGroup() == 3) {
            a.setMonsterLv(UtillMethod.makeRandom(10, 19));
        } else if (a.getMonsterGroup() == 5) {
            a.setMonsterLv(UtillMethod.makeRandom(20, 29));
        } else if (a.getMonsterGroup() == 7) {
            a.setMonsterLv(UtillMethod.makeRandom(30, 39));
        }
        return a;
    }


    @Override
    public String toString() {
        return "MonsterDB{" +
                "monsterList=" + monsterList +
                '}';
    }

    public ArrayList<Monster> getMonsterList() {
        return monsterList;
    }

    public void setMonsterList(ArrayList<Monster> monsterList) {
        this.monsterList = monsterList;
    }

    public MonsterDB(ArrayList<Monster> monsterList) {
        this.monsterList = monsterList;
    }
}
