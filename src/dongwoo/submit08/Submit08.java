package dongwoo.submit08;

import java.util.*;

public class Submit08 {
    public static void main(String[] args) {
        HashSet<Integer> makeLotto = new HashSet<>();
        while (true) {
            int random = (int) (Math.random() * 45 + 1);
            makeLotto.add(random);
            if (makeLotto.size() == 6) {
                break;
            }
        }
        ArrayList<Integer> myLotto = new ArrayList<>(makeLotto);
        Collections.sort(myLotto);
        System.out.println(myLotto);


        System.out.println("\n===========================\n");

        HashMap<String, String> infoMap = new HashMap<>();
        infoMap.put("a001", "1234a");
        infoMap.put("b001", "1234b");
        infoMap.put("c001", "1234c");
        infoMap.put("d001", "1234d");
        infoMap.put("e001", "1234e");

        Scanner scan = new Scanner(System.in);

        Set<Map.Entry<String, String>> entrySet = infoMap.entrySet();


        Set<String> keySet = infoMap.keySet();
        outer:
        while (true) {

            System.out.println("아이디를 입력해주세요");
            System.out.print(">>> ");
            String idAnswer = scan.nextLine();

            System.out.println("비밀번호를 입력해주세요");
            System.out.print(">>> ");
            String pwAnswer = scan.nextLine();
            if (infoMap.containsKey(idAnswer)) {
                for (String i : keySet) {
                    if (idAnswer.equals(i)) {
                        if (pwAnswer.equals(infoMap.get(i))) {
                            System.out.println("로그인 성공");
                            System.out.println("\n===========================\n");
                            break outer;
                        } else {
                            System.out.println("비밀번호가 틀렸습니다.");
                            System.out.println("\n===========================\n");
                            break;
                        }
                    }
                }
            }else{
                System.out.println("존재하지 않는 아이디입니다.");
                System.out.println("\n===========================\n");
            }


        }
    }
}


