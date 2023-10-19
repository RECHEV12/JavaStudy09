package mygame;

import java.util.ArrayList;

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
                    UtillMethod.boxBox(user.getPlayerName() + "은(는)" + skill.getSkillName() + "을 습득했다!!");
                    break;
                }


            }

        } else if (user.getPlayerClass().contains("마법사")) {
            for (Skill skill : skillDB.playerskillList) {
                if (user.getLv() == skill.getLearnLevel() && skill.getClassType().equals("마법사")) {
                    user.getPlayerSkillList().add(skill);
                    UtillMethod.boxBox(user.getPlayerName() + "은(는)" + skill.getSkillName() + "을 습득했다!!");
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

    public static Skill monsterChoiceSkill(Monster a) {
        int num = makeRandom(0, a.getMonsterSkillList().size() - 1);

        Skill skill = a.getMonsterSkillList().get(num);

        return skill;

    }

    public static void boxBox(String text) {
        String a = "╔";
        String b = "╗";
        String c = "╚";
        String d = "╝";
        String e = "═════";
        text = " " + text + " ";
        int length = text.length();

        for (int i = 0; i < length + 15; i++) {
            e += "═";
        }
        System.out.println(a + e + b);
        System.out.println(text);
        System.out.println(c + e + d);

    }


    public static void boxBox(String text, String text1) {
        String a = "╔";
        String b = "╗";
        String c = "╚";
        String d = "╝";
        String e = "═════";
        text = " " + text + " ";
        text1 = " " + text1 + " ";
        int length = 0;
        if (text.length() > text1.length()) {
            length = text.length();
        } else {
            length = text1.length();

        }

        for (int i = 0; i < length + 15; i++) {
            e += "═";
        }
        System.out.println(a + e + b);
        System.out.println(text);
        System.out.println(text1);
        System.out.println(c + e + d);

    }

    public static void boxBox(String text, String text1, String text2) {
        String a = "╔";
        String b = "╗";
        String c = "╚";
        String d = "╝";
        String e = "═════";
        text = " " + text + " ";
        text1 = " " + text1 + " ";
        text2 = " " + text2 + " ";
        int length = 0;
        if (text.length() > text1.length()) {
            length = text.length();
        } else {
            if (text1.length() > text2.length()) {
                length = text1.length();
            } else {
                length = text2.length();
            }
        }

        for (int i = 0; i < length + 15; i++) {
            e += "═";
        }
        System.out.println(a + e + b);
        System.out.println(text);
        System.out.println(text1);
        System.out.println(c + e + d);

    }


    public static void returnItemListAll(ArrayList<Item> list) {
        for (int i = 0; i < list.size(); i++) {
            Item temp = list.get(i);
            String nowEq = "";

            if (temp.isNowEq()) {
                nowEq = "장비중";
            } else {
                nowEq = "수납중/판매중";
            }
            System.out.println("╔═════════════════════════════════════════════════════════════════╗");
            System.out.println("이름 : " + temp.getItemName());
            System.out.println("분류 : " + temp.getItemType());
            System.out.println("아이템 설명 : " + temp.getItemDetail());
            System.out.println("\uD83D\uDCAA STR : " + temp.getPlusSTR() + "\uD83C\uDFAF DEX : " + temp.getPlusDEX());
            System.out.println("\uD83C\uDF93 INT : " + temp.getPlusINT() + "\uD83C\uDFB2 LUK : " + temp.getPlusLUK());
            System.out.println("❤\uFE0F 현재체력 : " + temp.getPlusNowHP() + "❤\uFE0F 최대체력 : " + temp.getPlusMaxHP());
            System.out.println("\uD83D\uDCA0 현재마나 : " + temp.getPlusNowMP() + "\uD83D\uDCA0 최대마나 : " + temp.getPlusMaxMP());
            System.out.println("현재 장비 상태 : " + nowEq);
            System.out.println("획득처 : " + temp.getDropMob());
            System.out.println("가격 : " + temp.getPrice());
            System.out.println("╚═════════════════════════════════════════════════════════════════╝");
        }
    }
    public static void returnSkillListAll(ArrayList<Skill> list) {
        for (int i = 0; i < list.size(); i++) {
            Skill skill = list.get(i);
            System.out.println("╔═════════════════════════════════════════════════════════════════╗");
            System.out.println("스킬번호 : No." + (i+1));
            System.out.println("이름 : " + skill.getSkillName());
            System.out.println("스킬타입 : " + skill.getSkillType());
            System.out.println("소비 마나량 : " + skill.getUseMp());
            System.out.println("\uD83D\uDCAA STR : " + skill.getPerStr() + "%" + " \uD83C\uDFAF DEX : " + skill.getPerDex() + "%" );
            System.out.println("\uD83C\uDF93 INT : " + skill.getPerInt() + "%");
            System.out.println("스킬 설명 : " + skill.getSkillInfo());
            System.out.println("╚═════════════════════════════════════════════════════════════════╝");
        }
    }
    public static void showSkillName(ArrayList<Skill> list) {
        for (int i = 0; i < list.size(); i++) {
            Skill skill = list.get(i);
            System.out.println("╔═════════════════════════════════════════════════════════════════╗");
            System.out.println("스킬번호 : No." + (i+1));
            System.out.println("이름 : " + skill.getSkillName());
            System.out.println("╚═════════════════════════════════════════════════════════════════╝");
        }
    }

    public static void returnSkillListone(ArrayList<Skill> list, int beta) {

      Skill newSkill = list.get(beta);

            System.out.println("╔═════════════════════════════════════════════════════════════════╗");
            System.out.println("스킬번호 : No." + (list.indexOf(newSkill)+1));
            System.out.println("이름 : " + newSkill.getSkillName());
            System.out.println("스킬타입 : " + newSkill.getSkillType());
            System.out.println("소비 마나량 : " + newSkill.getUseMp());
            System.out.println("\uD83D\uDCAA STR : " + newSkill.getPerStr() + "%" + " \uD83C\uDFAF DEX : " + newSkill.getPerDex() + "%" );
            System.out.println("\uD83C\uDF93 INT : " + newSkill.getPerInt() + "%");
            System.out.println("스킬 설명 : " + newSkill.getSkillInfo());
            System.out.println("╚═════════════════════════════════════════════════════════════════╝");

    }
}







