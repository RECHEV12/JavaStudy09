package mygame;

public class Skill {
    private String skillName;
    private String skillType;
    private String skillInfo;
    private int learnLevel;
    private String classType;

    public static void printSkillList(Class user) {
        for (Skill sk : user.getPlayerSkillList()) {
            System.out.println(
                    " ⚔\uFE0F " + "No. " + (user.playerSkillList.indexOf(sk) + 1) + " - " + sk.getSkillName()
            );
        }
    }


    public static int getUserDamage(Class user, Skill skr, Monster mob, double critical) {
        int strDamage = (user.getStatSTR() * skr.getPerStr());
        int intDamage = (user.getStatINT() * skr.getPerInt());

        double typeCritical = 1;
        if ((skr.getSkillType().equals("참격") && mob.getMonsterType().equals("참격약점")) ||
                (skr.getSkillType().equals("마법") && mob.getMonsterType().equals("마법약점"))) {
            typeCritical = 1.2;
        }

        double totalDamage = ((strDamage + intDamage) * (typeCritical)) * (critical);

        return (int) UtillMethod.myRound(totalDamage, 1);

    }

    public static double criticalReturn(Class user) {
        double crtical = 0;
        if (user.getStatLUK() >= 100) {
            crtical = 1.5;
        } else {
            double retouch = ((double) user.getStatDEX() / 5);
            int randNum = UtillMethod.makeRandom(1, 100);
            int num = (int) UtillMethod.myRound((5 + retouch), 1);
            if (randNum >= 1 && randNum <= num) {
                crtical = 1.5;
            } else {
                crtical = 1;
            }
        }

        return crtical;

    }


    public static int getMonsterDamage(Class user, Skill skr, Monster mob) {
        int strDamage = (mob.getMonsterATK() * skr.getPerStr());

        int totalDamage = strDamage;

        return totalDamage;
    }


    public static Skill getMonsterSkill(Monster mob) {
        // 스킬 인덱스를 가져오기
        int index = UtillMethod.makeRandom(0, mob.getMonsterSkillList().size() - 1);

        Skill mobSkill = mob.getMonsterSkillList().get(index);

        return mobSkill;
    }


    public static int defDamage(Class user, Skill skr) {
        int plus = (user.getStatDEX() * skr.getPerDex());
        return plus;
    }


    @Override
    public String toString() {
        return "Skill{" +
                "skillName='" + skillName + '\'' +
                ", skillType='" + skillType + '\'' +
                ", skillInfo='" + skillInfo + '\'' +
                ", learnLevel=" + learnLevel +
                ", classType='" + classType + '\'' +
                ", useMp=" + useMp +
                ", perStr=" + perStr +
                ", perInt=" + perInt +
                ", perDex=" + perDex +
                '}';
    }

    public int getLearnLevel() {
        return learnLevel;
    }

    public void setLearnLevel(int learnLevel) {
        this.learnLevel = learnLevel;
    }

    public Skill(String skillName, String skillType, String skillInfo, int learnLevel, String classType, int useMp, int perStr, int perInt, int perDex) {
        this.skillName = skillName;
        this.skillType = skillType;
        this.skillInfo = skillInfo;
        this.learnLevel = learnLevel;
        this.classType = classType;
        this.useMp = useMp;
        this.perStr = perStr;
        this.perInt = perInt;
        this.perDex = perDex;
    }


    public String getClassType() {
        return classType;
    }

    public void setClassType(String classType) {
        this.classType = classType;
    }


    private int useMp;
    private int perStr;
    private int perInt;
    private int perDex;

    public int getPerDex() {
        return perDex;
    }

    public void setPerDex(int perDex) {
        this.perDex = perDex;
    }

    public Skill(String skillName, String skillType, String skillInfo, int useMp, int perStr, int perInt, int perDex) {
        this.skillName = skillName;
        this.skillType = skillType;
        this.skillInfo = skillInfo;
        this.useMp = useMp;
        this.perStr = perStr;
        this.perInt = perInt;
        this.perDex = perDex;
    }


    public Skill() {
    }

    public Skill(String skillName, String skillType, String skillInfo, int useMp, int perStr, int perInt) {
        this.skillName = skillName;
        this.skillType = skillType;
        this.skillInfo = skillInfo;
        this.useMp = useMp;
        this.perStr = perStr;
        this.perInt = perInt;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public String getSkillType() {
        return skillType;
    }

    public void setSkillType(String skillType) {
        this.skillType = skillType;
    }

    public String getSkillInfo() {
        return skillInfo;
    }

    public void setSkillInfo(String skillInfo) {
        this.skillInfo = skillInfo;
    }

    public int getUseMp() {
        return useMp;
    }

    public void setUseMp(int useMp) {
        this.useMp = useMp;
    }

    public int getPerStr() {
        return perStr;
    }

    public void setPerStr(int perStr) {
        this.perStr = perStr;
    }

    public int getPerInt() {
        return perInt;
    }

    public void setPerInt(int perInt) {
        this.perInt = perInt;
    }
}
