package mygame;

public class UtillMethod {

    //스킬 부여


    public static void setSkill(Class user) {
        SkillDB skillDB = SkillDB.getInstance();
        if (user.getPlayerClass().contains("전사")) {
            for (Skill skill : skillDB.skillList) {
                if (user.getLv() == skill.getLearnLevel() && skill.getClassType().equals("전사")) {
                    user.getPlayerSkillList().add(skill);
                    System.out.println("\n" + user.getPlayerName() + "은(는)" + skill.getSkillName() + "을 습득했다!! \n");
                    break;
                }


            }

        } else if (user.getPlayerClass().contains("마법사")) {
            for (Skill skill : skillDB.skillList) {
                if (user.getLv() == skill.getLearnLevel() && skill.getClassType().equals("마법사")) {
                    user.getPlayerSkillList().add(skill);
                    System.out.println("\n" + user.getPlayerName() + "은(는)" + skill.getSkillName() + "을 습득했다!! \n");
                    break;
                }


            }
        }


    }


    /**
     * a~b사이의 랜덤 정수를 리턴하는 메소드
     * @param a 시작 숫자
     * @param b 끝 숫자
     * @return
     */
    public static int makeRandom(int a, int b){
        return (int)((Math.random() *(b-a+1)) + a);
    }
}









