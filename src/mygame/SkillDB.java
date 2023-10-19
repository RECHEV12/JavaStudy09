package mygame;

import java.util.ArrayList;

public class SkillDB {
    public ArrayList<Skill> playerskillList = new ArrayList<>();



// 대미지 계산식 (str * 계수) + (int * 계수) + (타입 * 몹타입) 후, mp소모하고 , 상태이상 있을시 독립시

 // todo 스킬 대미지 설정 제대로 넣기
    private  SkillDB() {
        // 검사공용
        playerskillList.add(new Skill("⚔\uFE0F 찌르기", "참격", "대검으로 찌릅니다. \n STR 10% | INT 5%",1,"전사", 0, 40, 30, 0));
        playerskillList.add(new Skill("\uD83D\uDEE1\uFE0F 막기", "방어", "검으로 막습니다. DEX가 높을 시, 더 많은 수치의 대미지를 방어합니다. \n STR 20% | DEX 20% ", 1,"전사",0, 20, 0, 20));
        playerskillList.add(new Skill("⚔\uFE0F 크게 휘두르기", "참격", "대검으로 크게 휘두릅니다. \n STR 15% | INT 5%",5,"전사",20, 15, 5, 0));
        playerskillList.add(new Skill("⚔\uFE0F 십자베기", "참격", "대검을 십자로 휘둘러 참격을 입힙니다. \n STR 25% | INT 5%",9,"전사", 20, 25, 5, 0));
        playerskillList.add(new Skill("⚔\uFE0F 홀리 슬래시", "참격", "빛을 검에 담아 베어가릅니다. \n STR 30% | INT 5%", 10,"전사",20, 30, 5,0));
        playerskillList.add(new Skill("⚔\uFE0F 홀리 레이", "마법", "빛으로 된 레이저를 발사합니다. \n STR 10% | INT 40%", 14,"전사",20, 10, 40,0));
        playerskillList.add(new Skill("\uD83D\uDC89 HP힐", "버프", "체력을 회복합니다. \n STR 20% | DEX 40%", 18,"전사",20, 20, 0, 40));
        playerskillList.add(new Skill("⚔\uFE0F2회전 베기", "참격", "검을 두 번 연속으로 휘두릅니다. \n STR 45% | INT 10%",20, "", 20, 45, 10, 0));
        playerskillList.add(new Skill("⚔\uFE0F별모양 베기", "참격", "별 모양으로 베어가릅니다. \n STR 60% | INT 10%", 27,"전사",20, 60, 10,0));
        playerskillList.add(new Skill("\uD83E\uDE85오러 두르기", "버프", "몸에 오러를 둘러 공격력을 높입니다. \n STR * 2", 30,"전사",1, 0, 0, 0));
        playerskillList.add(new Skill("\uD83E\uDE85천사의 손길", "버프", "다음 공격이 확정적으로 2배의 대미지를 줍니다.", 33,"전사",20, 0,0,0 ));
        playerskillList.add(new Skill("\uD83C\uDF87스타라이트 스트림", "참격", "별무리와 같은 빛을 내며 검을 휘두릅니다. \n STR 80% |INT 10% ", 40,"전사",20, 80,0, 10));

        //마법사공용
        playerskillList.add(new Skill("\uD83D\uDD2E 매직 미사일", "마법", "마법으로 된 미사일을 발사합니다. \n STR 5% | INT 15%",1,"마법사", 0, 5, 15, 0));
        playerskillList.add(new Skill("\uD83D\uDEE1\uFE0F 마나 실드", "마법", "마나를 몸 주위에 펼쳐 적의 공격을 방어합니다. \n STR 10% | INT 5%", 1,"마법사", 0,20, 20, 30));
        playerskillList.add(new Skill("\uD83D\uDD2E 차지 미사일", "마법", "미사일을 응축시켜 빠르게 쏘아냅니다. \n STR 10% | INT 5%",5,"마법사", 0, 20, 20, 30));
        playerskillList.add(new Skill("\uD83D\uDD2E 마나 봄", "마법", "마력을 한 곳에 응집시켜 폭발시킵니다. \n STR 10% | INT 5%", 9,"마법사", 0,20, 20, 30));
        playerskillList.add(new Skill("\uD83D\uDD2E 파이어 볼", "마법", "마력에 불의 힘을 담아 공의 형태로 쏘아냅니다. \n STR 10% | INT 5%", 10,"마법사", 0,20, 20, 30));
        playerskillList.add(new Skill("⚔\uFE0F 블레이즈 소드", "마법", "불로 된 검을 만들어 참격을 입힙니다. \n STR 10% | INT 5%", 14,"마법사", 0,20, 20, 30));
        playerskillList.add(new Skill("\uD83D\uDC89 체력 회복", "마법", "체력을 회복합니다. \n STR 10% | INT 5%", 18,"마법사", 0,20, 20, 30));
        playerskillList.add(new Skill("\uD83D\uDD2E 익스플로전", "마법", "불의 힘으로 적의 주위를 폭발시킵니다. \n STR 10% | INT 5%",20,"마법사", 0, 20, 20, 30));
        playerskillList.add(new Skill("\uD83D\uDD2E 선 버스트", "마법", "태양의 힘을 빌려 고온의 불꽃을 폭발시킵니다. \n STR 10% | INT 5%", 27,"마법사", 0,20, 20, 30));
        playerskillList.add(new Skill("\uD83E\uDE85 마력 증폭", "마법", "마력을 높여 공격력을 높입니다. \n STR 10% | INT 5%",30,"마법사", 0, 20, 20, 30));
        playerskillList.add(new Skill("\uD83E\uDE85 불의 손길", "마법", "다음 공격이 확정적으로 2배의 대미지를 입힙니다. \n STR 10% | INT 5%", 33,"마법사", 0,20, 20, 30));
        playerskillList.add(new Skill("\uD83C\uDF87 메테오 샤워", "마법", "유성우를 떨어뜨려 높은 대미지를 입힙니다. \n STR 10% | INT 5%",40,"마법사", 0, 20, 20, 30));

        playerskillList.add(new Skill("몽둥이 휘두르기", "물리", "몽둥이를 휘두릅니다",40,"고블린", 0, 30, 0, 0));
        playerskillList.add(new Skill("용액 뿌리기", "마법", "슬라임이 자신의 일부를 던집니다",40,"슬라임", 0, 30, 0, 0));

        playerskillList.add(new Skill("메테오 샤워", "마법", "유성우를 떨어뜨려 높은 대미지를 입힙니다. \n STR 10% | INT 5%",40,"대왕슬라임", 0, 40, 20, 30));
        playerskillList.add(new Skill("메테오 샤워", "마법", "유성우를 떨어뜨려 높은 대미지를 입힙니다. \n STR 10% | INT 5%",40,"홉고블린", 0, 40, 20, 30));
        playerskillList.add(new Skill("메테오 샤워", "마법", "유성우를 떨어뜨려 높은 대미지를 입힙니다. \n STR 10% | INT 5%",40,"산성슬라임", 0, 20, 20, 30));
        playerskillList.add(new Skill("메테오 샤워", "마법", "유성우를 떨어뜨려 높은 대미지를 입힙니다. \n STR 10% | INT 5%",40,"킹고블린", 0, 20, 20, 30));
        playerskillList.add(new Skill("메테오 샤워", "마법", "유성우를 떨어뜨려 높은 대미지를 입힙니다. \n STR 10% | INT 5%",40,"흑랑", 0, 20, 20, 30));
        playerskillList.add(new Skill("메테오 샤워", "마법", "유성우를 떨어뜨려 높은 대미지를 입힙니다. \n STR 10% | INT 5%",40,"세이렌", 0, 20, 20, 30));
        playerskillList.add(new Skill("메테오 샤워", "마법", "유성우를 떨어뜨려 높은 대미지를 입힙니다. \n STR 10% | INT 5%",40,"골렘", 0, 20, 20, 30));
        playerskillList.add(new Skill("메테오 샤워", "마법", "유성우를 떨어뜨려 높은 대미지를 입힙니다. \n STR 10% | INT 5%",40,"거대 골렘", 0, 20, 20, 30));
        playerskillList.add(new Skill("메테오 샤워", "마법", "유성우를 떨어뜨려 높은 대미지를 입힙니다. \n STR 10% | INT 5%",40,"오우거", 0, 20, 20, 30));
        playerskillList.add(new Skill("메테오 샤워", "마법", "유성우를 떨어뜨려 높은 대미지를 입힙니다. \n STR 10% | INT 5%",40,"마인", 0, 20, 20, 30));
        playerskillList.add(new Skill("메테오 샤워", "마법", "유성우를 떨어뜨려 높은 대미지를 입힙니다. \n STR 10% | INT 5%",40,"타천사", 0, 20, 20, 30));
        playerskillList.add(new Skill("메테오 샤워", "마법", "유성우를 떨어뜨려 높은 대미지를 입힙니다. \n STR 10% | INT 5%",40,"드래곤", 0, 20, 20, 30));

        //몬스터 스킬
            }

    public static SkillDB instance = new SkillDB();

    public static SkillDB getInstance(){
        return instance;
    }



    @Override
    public String toString() {
        return "SkillDB{" +
                "playerskillList=" + playerskillList +

                '}';
    }

    public ArrayList<Skill> getPlayerskillList() {
        return playerskillList;
    }

    public void setPlayerskillList(ArrayList<Skill> playerskillList) {
        this.playerskillList = playerskillList;
    }




    public SkillDB(ArrayList<Skill> skillList) {
        this.playerskillList = skillList;
    }

    public void setSkillList(ArrayList<Skill> skillList) {
        this.playerskillList = skillList;
    }

    public static void setInstance(SkillDB instance) {
        SkillDB.instance = instance;
    }

    public ArrayList<Skill> getSkillList() {
        return playerskillList;
    }

}
