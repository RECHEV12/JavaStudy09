package ch06_method;

import java.util.ArrayList;
import java.util.Scanner;

public class MethodMain {

    public static void main(String[] args) {
        // 메소드 = 함수
        // 메소드는 클래스에 종속된 함수
        // 함수는 클래스에 독립적인 함수를 말한다.

        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            sum += i;
        }
        System.out.println("1부터 100까지 더한 값 : " + sum);


        int sum2 = 0;
        for (int i = 30; i <= 60; i++) {
            sum2 += i;
        }
        System.out.println("30부터 60까지 더한 값 : " + sum2);

        int sum3 = 0;
        for (int i = 25; i <= 50; i++) {
            sum3 += i;
        }
        System.out.println("25부터 50까지 더한 값 : " + sum3);

        System.out.println("\n===========================\n");

        // 위 작업을 메소드로 만들기
        // a부터 b까지 더한 결과는?


        // 함수의 실행 -> 함수명();
        System.out.println("printSum 실행 전");
        printSum(10, 20);
        System.out.println("printSum 실행 후");

        System.out.println("returnSUm 실행 전");
        returnSum(1, 3); //실행만하고 리턴값을 사용하지 않는 상황
        System.out.println("returnSUm 실행 후");

        // 리턴 값을 변수에 담을 수 있다.
        int num = returnSum(1, 3);
        // 리턴값이 없으면 변수에 안담김
//        int n = printSum(1,3);


        System.out.println("\n===========================\n");
//        System.out.println(); 를 파이썬처럼 print로 만들어 써보기
        System.out.println("우리의 밥");
        print("우리의 밥");
        System.out.println(returnSum(1, 3));
        print(returnSum(1, 3));


        // Math.abs() : 절대값 리턴
        System.out.println(Math.abs(-10));


        // 함수명 myAbs
        // 파라미터 타입 : int
        // 리턴타입 :  int
        int rst = myAbs(-10);
        System.out.println(rst);


        // 함수를 쓰면 좋은점
        // 실행부의 코드가 간결해진다(가독성 증가)
        // 중복된 코드를 한 곳에서 관리할 수 있기에 수정할 때 용이하다.

        // 리턴값이 존재하는 함수
        String fruit = "apple";
        fruit.substring(1, 3);

        // 리턴값 함수 생성


//        makeCard 메소드 만들기
//        파라미터로 이름 국영수 점수를 넣으면
//        =====성적표=====
//        이름 : 유민
//        국어 : 90
//        영어 : 97
//        수학 : 79
//        평균 : 85.45
//        등급: B
//        ===============
//        위와 같이 출력되도록 한다.
//        (평균이 90점 이상이면 A, 80점 이상이면 B 그 외 C)

//
        makeCard("유민", 90, 87, 79);

        System.out.println("\n===============마이라운드============\n");
        System.out.println(myRound(3.141592, 3));

//      LoopWHile에서 포켓몬 했던 거를 메소드로 묶어서 실행

        playPokemon();

        System.out.println("\n===========================\n");

        //팩토리얼의 메소드화
        // CTRL SHIFT F


        System.out.println(factorial(5));

        // 재귀함수
        // 메소드 내에서 해당 메소드를 실행하는 케이스

        //콘솔창에 1부터 n까지 출력하는 메소드
        printNum(10);

        recPrintNum(10);
        System.out.println(recFactorial(5));


    }// 메인 메소드의 끝

    public static long recFactorial(int num) {
        if (num == 1) {
            return 1;
        }
        return num * recFactorial(num - 1);
        // 5*4
    }


    public static void recPrintNum(int num) {
        System.out.println(num);
        if (num == 1) {
            return;// 메소드 즉시 종료
        }
        recPrintNum(num - 1);
    }

    public static void printNum(int num) {
        for (int i = 1; i <= num; i++) {
            System.out.println(i);
        }


    }

    public static long factorial(int factNum) {
        long qusOneAlpha = 1;
        for (int i = 1; i <= factNum; i++) {
            qusOneAlpha *= i;
        }
        return qusOneAlpha;
    }

    public static void playPokemon() {
        Scanner scan = new Scanner(System.in);
        int hp = 100;
        // 외부 while문의 이름이 outer가
        outer:
        while (true) {
            System.out.println("야생의 피카츄를 만났습니다.");
            System.out.println("행동을 선택해 주세요");
            System.out.println("1. 공격 | 2. 도망");
            System.out.print(">>> ");

            int command = Integer.parseInt(scan.nextLine());

            if (command == 1) {
                // TODO 공격
                while (true) {
                    System.out.println("공격 방법 선택");
                    System.out.println("1. 몸통박치기 | 2. 하이드로펌프 | 3.취소");
                    System.out.print(">>> ");

                    int attack = Integer.parseInt(scan.nextLine());

                    if (attack == 1) {
                        System.out.println("몸통박치기 시전");
                        hp -= 20;
                    } else if (attack == 2) {
                        System.out.println("하이드로펌프 시전");
                        hp -= 40;
                    } else if (attack == 3) {
                        //취소
                        //가까운 반복문 1개를 즉시종료
                        break;
                    }
                    if (hp <= 0) {
                        System.out.println("피카츄를 잡았다");
                        //외부 while문 종료
//                        System.exit(0); 프로그램 종료
                        //외부 while문의 네임태그 설정됨
//                        break outer;
                        //리턴타입이  void라도 사용이 가능하다
                        //메소드 내에서 리턴이 실행되면 해당 메소드는 즉시 종료된다.
                        return;
                    }

                }

            } else if (command == 2) {
                System.out.println("메다닥 도망갔습니다.");
                break;
            } else {
                System.out.println("잘못 입력하셨습니다.");
            }


        }
    }


    // 메소드 선언
    // public 접근제어자
    // static 정적메소드
    // void 함수의 리턴값이 없음을 의미(리턴 값이 있으면 이 자리에 리턴값에 타입을 적어준다)
    // printSum 함수명(선언한 메소드를 실행시 함수명을 이용
    // 함수 생성은 메인메소드에서
    // 소괄호 안에는 입력받을 파라미터 선언
    public static void printSum(int startNumber, int endNumber) {
        // a b의 값을 메소드가 실행할 때 받아야 한다. => 파라미터에 기입
        int sum3 = 0;
        for (int i = startNumber; i <= endNumber; i++) {
            sum3 += i;
        }
        System.out.println(startNumber + "부터 " + endNumber + "까지 더한 값 : " + sum3);
    }

    public static int returnSum(int startNumber, int endNumber) {
        int sum3 = 0;
        for (int i = startNumber; i <= endNumber; i++) {
            sum3 += i;
        }
        // sum3값을 리턴
        return sum3;
    }

    //    기본적으로 변수와 같이 메소드 명은 중복선언 불가
//    하지만 하나의 클래스 내에서 이름이 같은 메소드명에서
//    파라미터를 다르게 선언하면 중복선언할 수 있다. =>메소드 오버로딩
    public static void print(String word) {
        System.out.println(word);
    }

    public static void print(int word) {
        System.out.println(word);

    }


    public static int myAbs(int a) {
        a = a < 0 ? -a : a;
        return a;
    }

    public static void makeCard(String name, int korScore, int engScore, int mathScore) {
        double avg = myRound(((double) (korScore + engScore + mathScore) / 3), 3);
        // 소수점 셋째자리에서 반올림 하여 둘째자리에서 자르기
        // Math.round는 첫째자리에서 반올림한 정수값을 리턴
        // 반올림 메소드 myRound()를 만들어보기
        System.out.println("=====성적표=====");
        System.out.println("이름: " + name);
        System.out.println("국어: " + korScore);
        System.out.println("영어: " + engScore);
        System.out.println("수학: " + mathScore);
        System.out.println("평균: " + avg);
        String grade = (avg >= 90) ? ("A") : ((avg >= 80) ? ("B") : ("C"));
        System.out.println("등급: " + grade);
        System.out.println("===============");
    }


    /**
     * 입력한 소수를 소수 n번째 자리로 반올림하여 리턴해주는 메소드
     *
     * @param num 반올림하고자 하는 소수
     * @param n   소수 n번째 자리를 지정하는 정수
     * @return 반올림 된 소수 리턴
     */
    public static double myRound(double num, int n) {
        //Math.round는 소수 첫째자리에서 반올림 한 정수 리턴
        //3.141592
        //Math.round(3.141592) => 3리턴

        // 3.141592에 10을 곱하고 31.41592
        //Math.round(31.41592) => 31리턴
        //리턴값에 10을 나누면 3.1
        //n이 1일 때 10 곱하고 나누기

        //3.141592에 100을 곱하면 314.1592
        //Math.round(314.1592) => 314리턴
        //리턴값에 100을 나누면 3.14
        // n이 2일 때 100을 곱하고 100 나누기

        //math.pow(정수, 정수의 n승)

        int bai = 1;

        for (int i = 0; i < n; i++) {
            bai = 10 * bai;
        }
        return (double) Math.round(num * bai) / bai;




    }



}
