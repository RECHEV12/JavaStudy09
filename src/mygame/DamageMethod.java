package mygame;

public class DamageMethod {
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
        double crtical;
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
    public static int getMonsterDamage(Skill skr, Monster mob) {

        return  (mob.getMonsterATK() * skr.getPerStr());


    }
    public static int defDamage(Class user, Skill skr) {
        return (user.getStatDEX() * skr.getPerDex());
    }
}
