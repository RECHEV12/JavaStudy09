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
        System.out.println("이름을 입력해주세요.");
        System.out.print(">>> ");
        String reverAn = "";
        String reverse = scan.nextLine();
        for (int i = 0 ; i < reverse.length() ; i++){
            String reverSub = reverse.substring(reverse.length()-(1+i),reverse.length()-i);
            reverAn += reverSub;
        }
        System.out.println(reverAn);



    }
}
