package mygame;

public class UtillMethod {

    //스킬 부여
    public static double myRound(double num, int n) {
        int bai = 1;
        for (int i = 0; i < n; i++) {
            bai = 10 * bai;
        }
        return (double) Math.round(num * bai) / bai;
    }

    public static void userSetSkill(Class user) {
        SkillDB skillDB = SkillDB.getInstance();
        if (user.getPlayerClass().contains("전사")) {
            for (Skill skill : skillDB.playerskillList) {
                if (user.getLv() == skill.getLearnLevel() && skill.getClassType().equals("전사")) {
                    user.getPlayerSkillList().add(skill);
                    System.out.println("\n" + user.getPlayerName() + "은(는)" + skill.getSkillName() + "을 습득했다!! \n");
                    break;
                }


            }

        } else if (user.getPlayerClass().contains("마법사")) {
            for (Skill skill : skillDB.playerskillList) {
                if (user.getLv() == skill.getLearnLevel() && skill.getClassType().equals("마법사")) {
                    user.getPlayerSkillList().add(skill);
                    System.out.println("\n" + user.getPlayerName() + "은(는)" + skill.getSkillName() + "을 습득했다!! \n");
                    break;
                }


            }
        }


    }

    public static Skill monsterSetSkill(Monster a) {
        SkillDB skillDBA = SkillDB.getInstance();
        for (Skill skill : skillDBA.playerskillList) {
            if (skill.getClassType().equals(a.getMonsterName())) {
                a.getMonsterSkillList().add(skill);
            }


        }
        return null;
    }

    /**
     * a~b사이의 랜덤 정수를 리턴하는 메소드
     *
     * @param a 시작 숫자
     * @param b 끝 숫자
     * @return
     */
    public static int makeRandom(int a, int b) {
        return (int) ((Math.random() * (b - a + 1)) + a);
    }

    public static double random5per() {
        double a = (int) makeRandom(1, 100);
        if (a >= 1 && a <= 5) {
            a = 1.5;
        } else {
            a = 1;
        }
        return a;
    }

    public static Skill monsterChoiceSkill(Monster a){
        int num = makeRandom(0, a.getMonsterSkillList().size()-1);

        Skill skill = a.getMonsterSkillList().get(num);

        return skill;

    }
}







