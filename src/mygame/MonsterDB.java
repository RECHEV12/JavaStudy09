package mygame;

import java.util.ArrayList;

public class MonsterDB {
    private ArrayList<Monster> monsterList = new ArrayList<>();

    private MonsterDB() {
        monsterList.add(new Monster(1, 1, "고블린", 0, "참격약점", 10, 5));
        monsterList.add(new Monster(1, monsterList.size() + 1, "슬라임", 0, "참격약점", 10, 5));

        monsterList.add(new Monster(2, monsterList.size() + 1, "대왕슬라임", 10, "참격약점", 5, 10));

        monsterList.add(new Monster(3, monsterList.size() + 1, "홉고블린", 0, "참격약점", 5, 10));
        monsterList.add(new Monster(3, monsterList.size() + 1, "산성슬라임", 0, "참격약점", 5, 10));

        monsterList.add(new Monster(4, monsterList.size() + 1, "킹고블린", 20, "참격약점", 5, 10));

        monsterList.add(new Monster(5, monsterList.size() + 1, "흑랑", 0, "참격약점", 5, 10));
        monsterList.add(new Monster(5, monsterList.size() + 1, "세이렌", 0, "참격약점", 5, 10));
        monsterList.add(new Monster(5, monsterList.size() + 1, "골렘", 0, "참격약점", 5, 10));

        monsterList.add(new Monster(6, monsterList.size() + 1, "거대 골렘", 30, "참격약점", 5, 10));

        monsterList.add(new Monster(7, monsterList.size() + 1, "오우거", 0, "참격약점", 5, 10));
        monsterList.add(new Monster(7, monsterList.size() + 1, "마인", 0, "참격약점", 5, 10));
        monsterList.add(new Monster(7, monsterList.size() + 1, "타천사", 0, "참격약점", 5, 10));

        monsterList.add(new Monster(8, monsterList.size() + 1, "드래곤", 40, "참격약점", 5, 10));

    }

    public static MonsterDB instance = new MonsterDB();

    public static MonsterDB getInstance() {
        return instance;
    }


    public void inputMonster(ArrayList A, int a) {
        A.add(MonsterDB.getInstance().getMonsterList().get(a));
    }


    public Monster getMonster(ArrayList<Monster> a) {
        // 몬스터의 인덱스 추출
        int alpha = UtillMethod.makeRandom(0, a.size() - 1);

        // 몬스터를 새 개체에 담기
        return a.get(alpha);
    }

    public void setMonster(Monster a, Class user) {
        // 레벨 설정
        Monster mob = a;
        if (a.getMonsterGroup() == 1) {
            if (user.getLv() < 5){
            a.setMonsterLv(UtillMethod.makeRandom(1, 5));
            }else {
                a.setMonsterLv(UtillMethod.makeRandom(1, 9));
            }

        } else if (a.getMonsterGroup() == 3) {
            if (user.getLv() < 15) {
                a.setMonsterLv(UtillMethod.makeRandom(10, 15));
            }else {
                a.setMonsterLv(UtillMethod.makeRandom(10, 19));
            }
        } else if (a.getMonsterGroup() == 5) {
            if (user.getLv() < 25) {
                a.setMonsterLv(UtillMethod.makeRandom(20, 25));
            }else {
                a.setMonsterLv(UtillMethod.makeRandom(20, 29));
            }
        } else if (a.getMonsterGroup() == 7) {
            if (user.getLv() < 35) {
                a.setMonsterLv(UtillMethod.makeRandom(30, 35));
            }else {
                a.setMonsterLv(UtillMethod.makeRandom(30, 39));
            }
        }

        a.setMonsterHP(a.getMonsterHP() + (a.getMonsterLv() * 2));
        a.setMonsterATK(a.getMonsterATK() + (int) UtillMethod.myRound(((double) a.getMonsterLv() / 2 ), 1));


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
