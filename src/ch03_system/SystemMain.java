package ch03_system;

import java.util.Scanner;

public class SystemMain {
    public static void main(String[] args) {

        // 콘솔창에 값, 문구 출력
        // printLn() 괄호 안 내용을 출력한 후에 줄바꿈을 자동으로 해준다.
        System.out.println("상단");
        System.out.println("중단");
        System.out.println("");
        System.out.println("하단");

        // print()는 괄호안 내용을 출력만 한다.
        System.out.print("프린트");
        System.out.print("줄바꿈없음");
        //괄호안에 아무것도 없다면 프린트는 오류가 난다.
        System.out.print("프린트");

        //콘솔창의 용도
        //프로젝트 내에 사용 중인 변수와 객체의 저장된 값을 확인하는데 사용
        //프로젝트 디버깅에 사용
        System.out.println("\n=========================\n");
        // \n과 같은 코드를 제어문자라고 함
        // 문자열 내에서(\)를 이용하여 특정 기능을 넣을 수 있다.

        // \n 줄바꿈
        System.out.print("오늘은 목요일\n");
        // System.out.println(); =  System.out.print("\n");

        // \t 탭
        System.out.println("일\t월\t화\t수\t목\t금\t토");
        System.out.println("\t\t\t\t\t1\t2");
        System.out.println("3\t4\t5\t6\t7\t8\t9");
        System.out.println("10\t11\t12\t13\t14\t15\t16");

        // 기능을 가지는 문자(\, "", '')를 콘솔창에 출력하고 싶다면
        // 해당 문자 앞에 \를 붙여준다.
        System.out.println("쌍따옴표는 \" 다");
        System.out.println("역슬래시는 \\ 다");
        System.out.println("●");
        System.out.println("—̳͟͞͞💁🏿‍♀️ᩚ ");

        System.out.println("\n=========================\n");

        //printf() 는 포맷 문자열(format string)과 함께 사용
        System.out.printf("안녕 printf야\n");
        System.out.printf("%d명이 수업을 듣고 있습니다.\n", 9);
        System.out.printf("%d명이 수업을 %d일째 듣고 있습니다.\n", 9, 4);
        System.out.printf("%d명이 %s을 %d일째 듣고 있습니다.\n", 9, "수업",  4);

        //예시 0(앞에 0을 채워라)2(자릿수)d(대응 숫자)
        System.out.printf("ch%02d_표준입출력\n", 3);
        System.out.printf("%.3f\n", 3.141592);
        System.out.printf("%.03f", 3.1);
        System.out.printf("통장 잔고는 %,d원 입니다.\n", 10000);


        System.out.println("\n=========================\n");

        // 표준입력
        // 객체는 참조타입을 담는 변수를 의미
        Scanner scan = new Scanner(System.in);
        String str = new String("오늘 비오나?");
        System.out.println(str);
        System.out.println(scan);

        System.out.println("이름을 입력해주세요");
        System.out.print(">>> ");
        String name = scan.nextLine();
        //nextLine은 문자열 타입으로 리턴
        //30 입력 시, "30"으로 가져온다.
        System.out.println(name + "님 환영합니다.");


        System.out.println("나이을 입력해주세요");
        System.out.print(">>> ");
        // String age = scan.nextLine();

        // "30"을 30으로 바꾸는 타입 변환이 일어나야 스트링을 써도 age-1이 적용된다.
        int intAge = Integer.parseInt(scan.nextLine());

        System.out.println("입력하신 나이는 " + (intAge - 1) + "입니다.");


        System.out.println("주소를 입력해주세요");
        System.out.print(">>> ");
        String address = scan.nextLine();

        System.out.println("주소확인 " + address);













    }
}
