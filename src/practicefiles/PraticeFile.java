package practicefiles;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class PraticeFile {
    public static void main(String[] args) {


//        int example = 278;
//        String strExm = ("" + example);
//
//
//        System.out.println((Integer.parseInt(strExm.substring(0, 1)) )
//                         + (Integer.parseInt(strExm.substring(1, 2) ))
//                         + (Integer.parseInt(strExm.substring(2, 3))));
//
//        System.out.println(strExm.indexOf("7"));
//
//        Scanner scan = new Scanner(System.in);
////        System.out.println("이름을 입력해주세요.");
//        System.out.print(">>> ");
//        String reverAn = "";
//        String reverse = scan.nextLine();
//        for (int i = 0 ; i < reverse.length() ; i++){
//            String reverSub = reverse.substring(reverse.length()-(1+i),reverse.length()-i);
//            reverAn += reverSub;
//        }
//        System.out.println(reverAn);
//
//
////         트리      i    별   공백  별
////              *   0   +1
////             * *  1   +1    +1(1번반복) +1
////            *   * 2   +1   +3(3번반복)   +1
////           *     * 3   +1    +5(5번반복)    +1
////          *********   4   +5
//
//
//        int ran = 7;
//        for (int i = 0 ; i <5 ; i++){
//            String blk = "";
//            for (int k = 0; k < 4-i ; k++){
//                blk += " ";
//            }
//            String stars = "";
//            for (int t = 0; t < i+1 ; t++){
//                stars = "*";
//            }
//            String stars1 = "";
//            for (int y = 1 ; y < i+1 ; y++){
//                stars1 = "*";
//            }
//            String blk2 = "";
//            for (int j = 0 ; j <(i*2)-1 ; j++){
//                if (j == 6){
//                    blk2 = "*******";
//                } else{
//                    blk2 += " ";
//                }
//            }
//            System.out.println(blk + stars  + blk2 + stars1);
//        }
//
//        System.out.println("숫자를 입력해주세요");
//        System.out.print(">>> ");
//        int ran1 = Integer.parseInt(scan.nextLine());
//
//        for (int i = 0; i < ran1; i++) {
//            String blk = "";
//            for (int k = 0; k < ran1 - 1 - i; k++) {
//                blk += " ";
//            }
//            String stars = "*";
//            String stars1 = "";
//            for (int y = 1; y < i + 1; y++) {
//                stars1 = "*";
//            }
//            String blk2 = "";
//            {
//                if (i == ran1 - 1) {
//                    for (int Q = 0; Q < (i * 2) - 1; Q++) {
//                        blk2 += "*";
//
//                    }
//                } else {
//                    for (int j = 0; j < (i * 2) - 1; j++)
//                        blk2 += " ";
//                }
//            }
//
//            System.out.println(blk + stars + blk2 + stars1);
//        }
//
//
//        HashMap<String, String> infoMap = new HashMap<>();
//        infoMap.put("a001", "1234a");
//        infoMap.put("b001", "1234b");
//        infoMap.put("c001", "1234c");
//        infoMap.put("d001", "1234d");
//        infoMap.put("e001", "1234e");
//
//        Scanner scan21 = new Scanner(System.in);
//
//        Set<Map.Entry<String, String>> entrySet = infoMap.entrySet();
//
//
//        Set<String> keySet = infoMap.keySet();
//        outer:
//        while (true) {
//
//            System.out.println("아이디를 입력해주세요");
//            System.out.print(">>> ");
//            String idAnswer = scan.nextLine();
//
//            System.out.println("비밀번호를 입력해주세요");
//            System.out.print(">>> ");
//            String pwAnswer = scan.nextLine();
//            if (infoMap.containsKey(idAnswer)) {
//                for (String i : keySet) {
//                    if (idAnswer.equals(i)) {
//                        if (pwAnswer.equals(infoMap.get(i))) {
//                            System.out.println("로그인 성공");
//                            System.out.println("\n===========================\n");
//                            break outer;
//                        } else {
//                            System.out.println("비밀번호가 틀렸습니다.");
//                            System.out.println("\n===========================\n");
//                            break;
//                        }
//                    }
//                }
//            }else{
//                System.out.println("존재하지 않는 아이디입니다.");
//                System.out.println("\n===========================\n");
//            }

        System.out.println(0+1);

            System.out.println("\n===========================\n");

            HashMap<String, String> infoMapa = new HashMap<>();
            infoMapa.put("a001", "1234a");
            infoMapa.put("b001", "1234b");
            infoMapa.put("c001", "1234c");
            infoMapa.put("d001", "1234d");
            infoMapa.put("e001", "1234e");

            Scanner scana = new Scanner(System.in);

            Set<Map.Entry<String, String>> entrySeta = infoMapa.entrySet();


            Set<String> keySeta = infoMapa.keySet();
            outer:
            while (true) {

                System.out.println("아이디를 입력해주세요");
                System.out.print(">>> ");
                String idAnswera = scana.nextLine();

                System.out.println("비밀번호를 입력해주세요");
                System.out.print(">>> ");
                String pwAnswera = scana.nextLine();
                System.out.println(infoMapa.equals(idAnswera));
                if (infoMapa.equals(idAnswera)) {
                    for (String i : keySeta) {
                        if (idAnswera.equals(i)) {
                            if (pwAnswera.equals(infoMapa.get(i))) {
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
                } else {
                    System.out.println("존재하지 않는 아이디입니다.");
                    System.out.println("\n===========================\n");
                }


            }
        }
}
