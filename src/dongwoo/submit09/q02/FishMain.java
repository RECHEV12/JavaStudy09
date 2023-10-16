package dongwoo.submit09.q02;

import ch09_class.common.UtilClass;
import ch09_class.common.UtilClass;

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

        // 낚시하기 선택시
        // 다금바리 5%
        // 능서어 10%
        // 돌돔 12%
        // 참돔 13%
        // 우럭 15%
        // 광어 15%
        // 고등어 30% 확률로 잡히도록 코드 설정
        // 5%  확률로 낚싯대가 부서질 수 있음
        // 낚시대가 뿌서지면 낚시 불가능

        boolean isBroken = false;
        long totalPrice = 0;
        // 미끼 갯수
        int count = 10; // 낚시를 할 때마다 미끼 1개씩 줄고, 미끼가 0개면 낚시 불가능
        while (true) {
            System.out.println("행동을 선택해주세요.");
            System.out.println("1. 낚시하기 | 2. 잡은 물고기 목록 확인 및 판매 | 3. 미끼 구입(5만원) | 4. 떠나기 | 5. 낚싯대 수리(20만원)");
            System.out.println("지갑" + totalPrice + "원");
            System.out.print(">>> ");

            int select = Integer.parseInt(scan.nextLine());


            if (select == 1) {
                if (isBroken) {
                    System.out.println("낚시대가 부러져서 더 이상 낚시를 할 수 없다");
                    continue;
                }

                if (count > 0) {
                    count -= 1;
                } else if (count == 0) {
                    System.out.println("미끼가 없습니다.");
                    continue;
                }
                int random1 = 0;
                int random = (int) ((Math.random() * 100) + 1);


                if (random <= 5) {
                    random1 = 6;
                } else if (random <= 15) {
                    random1 = 5;
                } else if (random <= 27) {
                    random1 = 4;
                } else if (random <= 40) {
                    random1 = 3;
                } else if (random <= 55) {
                    random1 = 2;
                } else if (random <= 70) {
                    random1 = 1;
                } else if (random <= 100) {
                    random1 = 0;
                }
                int broken = UtilClass.makeRandom(1, 100);
                if (broken <= 5) {
                    System.out.println("낚싯대가 부서져서 낚시를 할 수 없다,,,");
                    // 낚시대가 부러진 상태 저장
                    isBroken = true;
                    continue;
                }

                fishBag.add(fishList.get(random1));
                System.out.println(fishList.get(random1).getName() + "을 잡았다!!");
                System.out.println("여분 미끼 갯수 : " + count + "개");
                System.out.println("지갑" + totalPrice + "원");
                System.out.println("=======================");

            } else if (select == 2) {
                System.out.println("내 가방 ==========");
                for (int t = 0; t < fishBag.size(); t++) {
                    System.out.println(fishBag.get(t));
                }

                for (int i = 0; i < fishBag.size(); i++) {
                    totalPrice += fishBag.get(i).getPrice();
                }
                System.out.println("총 " + totalPrice + "원 ==============");
            } else if (select == 3) {
                if (totalPrice < 50000) {
                    System.out.println("돈이 부족해 미끼를 구매할 수 없습니다 \n 물고기를 팔아 돈을 벌어오세요");
                    System.out.println("=======================");
                } else {
                    count += 10;
                    System.out.println("10개 추가!" + "|" + "여분 미끼 갯수 : " + count + "개");
                    totalPrice -= 50000;
                    System.out.println("=======================");
                }
            } else if (select == 4) {
                break;
            } else if (select == 5) {
                if (totalPrice < 200000) {
                    System.out.println("돈이 부족해 수리할 수 없습니다 \n 물고기를 팔아 돈을 벌어오세요");
                    System.out.println("=======================");
                } else {
                    isBroken = false;
                    totalPrice -= 200000;
                    System.out.println("낚싯대가 수리되었습니다!");
                    System.out.println("여분 미끼 갯수 : " + count + "개");
                    System.out.println("지갑" + totalPrice + "원");
                    System.out.println("=======================");
                }
            }
        }
    }


}



