package dongwoo.submit02;

import java.util.Iterator;
import java.util.Scanner;

public class Submit02 {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("이름을 입력해주세요.");
        System.out.print(">>> ");
        String name = scan.nextLine();

        System.out.println("국어 점수을 입력해주세요.");
        System.out.print(">>> ");
        String korScore = scan.nextLine();

        System.out.println("영어 점수을 입력해주세요.");
        System.out.print(">>> ");
        String engScore = (scan.nextLine());

        System.out.println("수학 점수을 입력해주세요.");
        System.out.print(">>> ");
        String mathScore = scan.nextLine();

        int kor = Integer.parseInt(korScore);
        int eng = Integer.parseInt(engScore);
        int math = Integer.parseInt(mathScore);
        double avr = ((double) (math + eng + kor) / 3);
        System.out.println("이름: " + name);
        System.out.println("국어: " + korScore);
        System.out.println("영어: " + engScore);
        System.out.println("수학: " + mathScore);
        System.out.printf("평균: " + "%.2f", avr);


        System.out.println("\n======================\n");
        
        int example = 278;
        String strExm = ("" + example);


        System.out.println((Integer.parseInt(strExm.substring(0, 1)) ) + (Integer.parseInt(strExm.substring(1, 2) ))+ (Integer.parseInt(strExm.substring(2, 3))));




        System.out.println("\n======================\n");

        // 축약 정리
        System.out.println("이름을 입력해주세요.");
        System.out.print(">>> ");
        String name1 = scan.nextLine();

        System.out.println("국어 점수을 입력해주세요.");
        System.out.print(">>> ");
        int kor2 = Integer.parseInt(scan.nextLine());

        System.out.println("영어 점수을 입력해주세요.");
        System.out.print(">>> ");
        int eng2 = Integer.parseInt(scan.nextLine());

        System.out.println("수학 점수을 입력해주세요.");
        System.out.print(">>> ");
        int math2 = Integer.parseInt(scan.nextLine());

        System.out.println("이름: " + name1 + "\n국어: " + kor2 + "\n영어: " + eng2 + "\n수학: " + math2);
        System.out.printf("평균: " + "%.2f", ((double) (math2 + eng2 + kor2) / 3));











    }
}
