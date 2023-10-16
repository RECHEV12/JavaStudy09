package ch09_class.cafe;

import java.util.Scanner;

public class CafeMain {
    public static void main(String[] args) {
        // 콘테 스타벅스
        // 음료, 커피 판매

        Cafe conte = new Cafe("콘테");
        // cafe 객체는 coffee 객체를  menu에 추가할 수 있다.를 메소드화
        conte.getMenu().add(new Coffee("아메리카노", 2000));
        conte.addCoffee(new Coffee("카페라떼", 4000));
        conte.addCoffee(new Coffee("레몬티", 5000));

        Cafe starbucks = new Cafe("스타벅스");
        starbucks.addCoffee(new Coffee("아메리카노", 5000));
        starbucks.addCoffee(new Coffee("바닐라라떼", 7000));
        starbucks.addCoffee(new Coffee("녹차라떼", 7000));

        Scanner scan =new Scanner(System.in);

        while (true){
            System.out.println("행동을 선택해 주세요.");
            System.out.println("1. 스타벅스 | 2. 콘테 | 3. 사무실 복귀");
            System.out.print(">>> ");

            int command = Integer.parseInt(scan.nextLine());

                if (command == 1){
                    //메뉴판 출력 및 메뉴 선택 -> 메소드화(중복코드를 최소화 하기 위한 작은 단위로 메소드 선언)
                    starbucks.printMenu();

                    System.out.print("메뉴 선택(번호): ");

                    int select = Integer.parseInt(scan.nextLine());

                    starbucks.selectMenu(select);


                } else if (command == 2) {

                   conte.printMenu();

                    System.out.print("메뉴 선택(번호): ");

                    int select = Integer.parseInt(scan.nextLine());

                    conte.selectMenu(select);

                } else if (command == 3) {
                    System.out.println("사무실로 복귀합니다..");
                    break;
                }


        }





    }
}
