package mygame;

public class DamageMethod {
    public static int getUserDamage(Class user, Skill skr, Monster mob, double critical) {
        int strDamage = (int)UtillMethod.myRound(user.getStatSTR() * (skr.getPerStr() /(double) 100),1);
        int intDamage = (int)UtillMethod.myRound(user.getStatINT() * (skr.getPerInt()/ (double)100),1);

        double typeCritical = 1;
        if ((skr.getSkillType().equals("참격") && mob.getMonsterType().equals("참격약점")) ||
                (skr.getSkillType().equals("마법") && mob.getMonsterType().equals("마법약점"))) {
            typeCritical = 1.3;
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
        double num =(skr.getPerStr() / (double)100);
        return(int) UtillMethod.myRound((mob.getMonsterATK()) * num,1);
    }
    public static int defDamage(Class user, Skill skr) {
        double num =(skr.getPerDex() / (double)100);
     return    (int)UtillMethod.myRound((num * user.getStatDEX()),1);
    }
}
