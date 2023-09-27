package practicefiles;

import java.util.Scanner;

public class PraticeFile {
    public static void main(String[] args) {


        int example = 278;
        String strExm = ("" + example);


        System.out.println((Integer.parseInt(strExm.substring(0, 1)) )
                         + (Integer.parseInt(strExm.substring(1, 2) ))
                         + (Integer.parseInt(strExm.substring(2, 3))));

        System.out.println(strExm.indexOf("7"));

        Scanner scan = new Scanner(System.in);
//        System.out.println("이름을 입력해주세요.");
        System.out.print(">>> ");
        String reverAn = "";
        String reverse = scan.nextLine();
        for (int i = 0 ; i < reverse.length() ; i++){
            String reverSub = reverse.substring(reverse.length()-(1+i),reverse.length()-i);
            reverAn += reverSub;
        }
        System.out.println(reverAn);


//         트리      i    별   공백  별
//              *   0   +1
//             * *  1   +1    +1(1번반복) +1
//            *   * 2   +1   +3(3번반복)   +1
//           *     * 3   +1    +5(5번반복)    +1
//          *********   4   +5


        int ran = 7;
        for (int i = 0 ; i <5 ; i++){
            String blk = "";
            for (int k = 0; k < 4-i ; k++){
                blk += " ";
            }
            String stars = "";
            for (int t = 0; t < i+1 ; t++){
                stars = "*";
            }
            String stars1 = "";
            for (int y = 1 ; y < i+1 ; y++){
                stars1 = "*";
            }
            String blk2 = "";
            for (int j = 0 ; j <(i*2)-1 ; j++){
                if (j == 6){
                    blk2 = "*******";
                } else{
                    blk2 += " ";
                }
            }
            System.out.println(blk + stars  + blk2 + stars1);
        }

        System.out.println("숫자를 입력해주세요");
        System.out.print(">>> ");
        int ran1 = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < ran1; i++) {
            String blk = "";
            for (int k = 0; k < ran1 - 1 - i; k++) {
                blk += " ";
            }
            String stars = "";
            for (int t = 0; t < i + 1; t++) {
                stars = "*";
            }
            String stars1 = "";
            for (int y = 1; y < i + 1; y++) {
                stars1 = "*";
            }
            String blk2 = "";
            {
                if (i == ran1 - 1) {
                    for (int Q = 0; Q < (i * 2) - 1; Q++) {
                        blk2 += "*";

                    }
                } else {
                    for (int j = 0; j < (i * 2) - 1; j++)
                        blk2 += " ";
                }
            }

            System.out.println(blk + stars + blk2 + stars1);
        }


    }
}
