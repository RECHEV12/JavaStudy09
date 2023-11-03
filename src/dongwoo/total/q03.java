package dongwoo.total;

import java.util.ArrayList;
import java.util.Scanner;

public class q03 {
    public static void main(String[] args) {

        ArrayList<String> foodList = new ArrayList<>();

        String food = "짜장면, 짬뽕, 볶음밥, 김치찌개, 제육볶음, 돈까스, 카레, 김밥/라면, 순대국밥, 냉면, 삼겹살, 생선구이, 햄버거, 떡볶이, 소고기국밥, 시래기";

        String[] foods = food.split(", ");

        for (String str : foods) {
            foodList.add(str);
        }

        Scanner scan = new Scanner(System.in);


        outer:
        while (true) {
            if (foodList.size() == 2){
                System.out.println("@@@준결승@@@");
            }
            else {

            System.out.println("@@@ " + foodList.size() + "강 @@@");
            }

            ArrayList<String> myList = new ArrayList<>();

            while (true) {

                System.out.println("메뉴를 선택해주세요");

                String oneFood = rand(foodList, myList, foodList.size());
                String twoFood = rand(foodList, myList, foodList.size());

                System.out.println("1. " + oneFood + " | " + "2. " + twoFood);
                System.out.print(">>> ");
                int selectNum = Integer.parseInt(scan.nextLine());

                if (selectNum == 1) {
                    myList.remove(twoFood);
                } else if (selectNum == 2) {
                    myList.remove(oneFood);
                }

                if (foodList.isEmpty()) {
                    if (myList.size() == 1) {
                        System.out.println(myList.get(0) + " 우승!!");
                        break outer;
                    } else {

                        foodList.addAll(myList);
                        myList.clear();
                        break;
                    }
                }
            }


        }


    }

    public static String rand(ArrayList<String> mainList, ArrayList<String> setList, int listSize) {
        int randNum = (int) ((Math.random() * listSize));
        String thisFood = mainList.get(randNum);
        setList.add(thisFood);
        mainList.remove(randNum);
        return thisFood;


    }
}

