package mygame;

public class Skill {
    private String skillName;
    private String skillType;
    private String skillInfo;
    private int useMp;
    private int perStr;
    private int perInt;


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

    @Override
    public String toString() {
        return "Skill{" +
                "skillName='" + skillName + '\'' +
                ", skillType='" + skillType + '\'' +
                ", skillInfo='" + skillInfo + '\'' +
                ", useMp=" + useMp +
                ", perStr=" + perStr +
                ", perInt=" + perInt +
                '}';
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
