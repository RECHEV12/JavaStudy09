package dongwoo.submit06;

import ch07_array.ArrayMain;

import java.util.Arrays;

public class Submit06 {
    public static void main(String[] args) {
        String[] nameList = {"이정재", "김혜수", "이병헌", "송중기", "유아인", "류준열", "공유", "마동석", "이종석", "황정민", "박소담", "이선균", "이성민", "최민식", "이동휘", "권상우", "소지섭", "공효진", "조정석", "허성태", "이하늬"};
        int count = 0;
        for (int i = 0; i < nameList.length; i++) {

            if ((nameList[i].substring(0, 1)).equals("이")) {
                count += 1;
            }
        }
        System.out.println("이씨 성을 가진 배우가 총 " + count + "명 있습니다.");

        System.out.println("\n===========================\n");
        int[] intArr = {23, 456, 213, 32, 464, 1, 2, 4};
        int maxNum = intArr[0];
        int minNum = intArr[0];
        Arrays.sort(intArr);
        for (int i = 0; i < intArr.length; i++) {
            if (maxNum < intArr[i]) {
                maxNum = intArr[i];
            }
            if (minNum > intArr[i]) {
                minNum = intArr[i];
            }
        }

        System.out.println("최댓값: " + maxNum);
        System.out.println("최솟값: " + minNum);

        System.out.println("\n===========================\n");

        makeLotto();


    }

    /**
     * 중복없는 로또번호 출력
     */
    public static int[] makeLotto() {
        int[] myLotto = new int[6];
        for (int i = 0; i < myLotto.length; i++) {

            myLotto[i] = (int) (Math.random() * 45) + 1;

            for (int t = 0; t < i; t++) {

                if (myLotto[i] == myLotto[t]) {

                    i--;

                    break;
                }
            }
        }
        Arrays.sort(myLotto);
        return myLotto;
    }


    public static int[] daieo(){
        int[] Lotto = new int[6];
        int rand = (int) (Math.random() * 45) + 1;
        int idx = 0 ;
        while (true) {
            boolean isduple = false;
            for (int i = 0 ; i < Lotto.length ; i++){

                if (Lotto[i] == rand){
                    isduple = true;
                }
            }
            if (isduple == false){
                Lotto[idx] = rand;
                idx++;
            }
            if (idx == 6){
                break;
            }

        }
        return Lotto;
    }



}












