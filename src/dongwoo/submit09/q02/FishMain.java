package dongwoo.submit09.q02;

import java.util.ArrayList;
import java.util.Scanner;

public class FishMain {
    public static void main(String[] args) {

        ArrayList<Fish> fishList = new ArrayList<>();
        fishList.add(new Fish("고등어", 5000));
        fishList.add(new Fish("광어", 25000));
        fishList.add(new Fish("우럭", 27000));
        fishList.add(new Fish("참돔", 30000));
        fishList.add(new Fish("돌돔", 35000));
        fishList.add(new Fish("능성어", 70000));
        fishList.add(new Fish("다금바리", 120000));

        Scanner scan = new Scanner(System.in);

        ArrayList<Fish> fishBag = new ArrayList<>();

        while (true) {
            System.out.println("행동을 선택해주세요.");
            System.out.println("1. 낚시하기 | 2. 잡은 물고기 목록 | 3. 떠나기");
            System.out.print(">>> ");

            int select = Integer.parseInt(scan.nextLine());

            if (select == 1) {
                int random = (int)((Math.random()*6) +1);
                fishBag.add(fishList.get(random));
                System.out.println(fishList.get(random).getName() + "을 잡았다!!");
                System.out.println("=======================");

            } else if (select == 2) {
                System.out.println("내 가방 ==========");
                for (int t = 0 ; t < fishBag.size() ; t++){
                    System.out.println(fishBag.get(t));
                }
                int totalPrice = 0;
                for (int i = 0; i < fishBag.size(); i++) {
                    totalPrice += fishBag.get(i).getPrice();
                }
                System.out.println("총 " + totalPrice + "원 ==============");
            } else if (select == 3)

                break;
        }

    }



}
