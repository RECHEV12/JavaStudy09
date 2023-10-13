package dongwoo.submit08;

import java.util.*;

public class Submit08 {
    public static void main(String[] args) {

        ArrayList<Integer> myLotto = makeLotto();
        System.out.println(myLotto);

        // 로또를 몇장 사야 당첨이 될까.
//        int[] winLotto = {11, 21, 22, 30, 39, 44};
//        int sum = 0;
//        while (true) {
//            ArrayList<Integer> LottoA = makeLotto();
//            int count = 0;
//            for (int i = 0; i < winLotto.length; i++) {
//                if (winLotto[i] == LottoA.get(i)) {
//                    count += 1;
//                }
//            }
//            if (count == 6) {
//                System.out.println("당첨");
//                System.out.println(sum + "회 구매");
//                System.out.println((sum * 1000l) + "원 소비");
//                break;
//            } else {
//                sum += 1;
//            }
//        }

        System.out.println("\n===========================\n");

        HashMap<String, String> infoMap = new HashMap<>();
        infoMap.put("a001", "1234a");
        infoMap.put("b001", "1234b");
        infoMap.put("c001", "1234c");
        infoMap.put("d001", "1234d");
        infoMap.put("e001", "1234e");

        Scanner scan = new Scanner(System.in);


        System.out.println("아이디를 입력해주세요");
        System.out.print(">>> ");
        String idAnswer = scan.nextLine();

        System.out.println("비밀번호를 입력해주세요");
        System.out.print(">>> ");
        String pwAnswer = scan.nextLine();
        if (infoMap.containsKey(idAnswer)) {
            if (infoMap.get(idAnswer).equals(pwAnswer)) {
                System.out.println("로그인 성공");
                System.out.println("\n===========================\n");
            } else {
                System.out.println("비밀번호가 틀렸습니다.");
                System.out.println("\n===========================\n");
            }
        } else {
            System.out.println("존재하지 않는 아이디입니다.");
            System.out.println("\n===========================\n");
        }
    }

    public static ArrayList<Integer> makeLotto() {
        HashSet<Integer> tmp = new HashSet<>();
        while (tmp.size() < 6) {
            int random = (int) (Math.random() * 45 + 1);
            tmp.add(random);
//            if (tmp.size() == 6) {
//                break;
//            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        result.addAll(tmp);
        Collections.sort(result);
        return result;
    }
}



