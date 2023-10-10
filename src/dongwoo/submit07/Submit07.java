package dongwoo.submit07;

import java.util.ArrayList;
import java.util.Collections;

public class Submit07 {
    public static void main(String[] args) {
        ArrayList<Integer> intList = new ArrayList<>();
        int count = 0;
        while (true) {
            int rand = (int) ((Math.random() * 20) + 1);
            if (rand >= 10) {
                intList.add(rand);
                count++;
            }
            if (count == 10) {
                break;
            }
        }
        // 1차 10개 숫자 랜덤 지정
        System.out.println(intList);

        ArrayList<Integer> intList2 = new ArrayList<>();

        for (int i = 0; i < intList.size(); i++) {
            intList2.add(intList.get(i));
            for (int t = 0; t < intList2.size() - 1; t++) {
                if (intList.get(i) == intList2.get(t)) {
                    intList2.remove(t);
                }
            }
        }

        // 중복 제거 올김
        System.out.println(intList2);

        // 오름차순
        Collections.sort(intList2);
        System.out.println(intList2);
        // 내림차순
        Collections.sort(intList2, Collections.reverseOrder());
        System.out.println(intList2);

        System.out.println("\n===========================\n");

        ArrayList<String> wifeWant = new ArrayList<>();
        ArrayList<String> husbandWant = new ArrayList<>();

        wifeWant.add("냉장고");
        wifeWant.add("로봇청소기");
        wifeWant.add("세탁기");
        wifeWant.add("에어컨");

        husbandWant.add("노트북");
        husbandWant.add("TV");
        husbandWant.add("에어컨");
        husbandWant.add("플레이스테이션");
        husbandWant.add("로봇청소기");

        ArrayList<String> sameWant = new ArrayList<>();

        for (int i = 0; i < wifeWant.size(); i++) {
            for (int t = 0; t < husbandWant.size(); t++) {
                if (wifeWant.get(i) == husbandWant.get(t)) {
                    sameWant.add(wifeWant.get(i));
                }
            }
        }

        // 교집합 출력
        System.out.println(sameWant);


        ArrayList<String> allWant = new ArrayList<>();
        allWant = wifeWant;

        for (int i = 0; i < husbandWant.size(); i++) {
            allWant.add(husbandWant.get(i));
            for (int t = 0; t < allWant.size() - 1; t++) {
                if (husbandWant.get(i) == allWant.get(t)) {
                    allWant.remove(allWant.size() - 1);
                }
            }
        }
        System.out.println(allWant);

    }
}
