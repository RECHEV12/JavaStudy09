package dongwoo.submit04;

import java.util.Scanner;

public class Submit04 {
    public static void main(String[] args) {

        int eleA = 10;
        int eleB = 4;
        while (true) {
            System.out.println("========희영빌딩 엘리베이터========");
            System.out.println("승강기 A의 현재 위치 :" + eleA + "층");
            System.out.println("승강기 B의 현재 위치 :" + eleB + "층");
            System.out.print("몇 층에 계시나요? [종료하시려면 q 또는 exit 입력] : ");
            Scanner scan = new Scanner(System.in);

            String floorSelect = scan.nextLine();

            if (floorSelect.equals("q") || floorSelect.equals("exit"))
            {

                System.out.println("프로그램이 종료되었습니다.");

                break;

            }
            else if (Integer.parseInt(floorSelect) <= 10)
            {

                int eleA_mi = eleA - Integer.parseInt(floorSelect);
                int eleB_mi = eleB - Integer.parseInt(floorSelect);

                if (Math.abs(eleA_mi) < Math.abs(eleB_mi))
                {
                    System.out.println(eleA + "층에서 엘리베이터를 호출합니다");
                    System.out.println("승강기 A가 " + Integer.parseInt(floorSelect) + "층으로 이동하였습니다.");
                    eleA = Integer.parseInt(floorSelect);

                }
                else if (Math.abs(eleA_mi) > Math.abs(eleB_mi))
                {
                    System.out.println(eleB + "층에서 엘리베이터를 호출합니다");
                    System.out.println("승강기 B가 " + Integer.parseInt(floorSelect) + "층으로 이동하였습니다.");
                    eleB = Integer.parseInt(floorSelect);

                }
                else if (Math.abs(eleA_mi) == Math.abs(eleB_mi))
                {
                    if (eleA > eleB)
                    {
                        System.out.println(eleA + "층에서 엘리베이터를 호출합니다");
                        System.out.println("승강기 A가 " + Integer.parseInt(floorSelect) + "층으로 이동하였습니다.");
                        eleA = Integer.parseInt(floorSelect);
                    }
                    else if (eleA < eleB)
                    {
                        System.out.println(eleB + "층에서 엘리베이터를 호출합니다");
                        System.out.println("승강기 B가 " + Integer.parseInt(floorSelect) + "층으로 이동하였습니다.");
                        eleB = Integer.parseInt(floorSelect);
                    }

                }

            }


        }

    }
}







//            else if (Integer.parseInt(floorSelect) <= 10) {
//            int eleA_mi = eleA - Integer.parseInt(floorSelect);
//            int eleB_mi = eleB - Integer.parseInt(floorSelect);
//
//            if (eleB_mi < 0) {
//        eleB_mi = eleB_mi * -1;
//
//        } else if (eleA_mi < 0) {
//        eleA_mi = eleA_mi * -1;
//        }
//            }
//            if (eleA_mi > eleB_mi) {
//
//            System.out.println(eleA + "층에서 엘리베이터를 호출합니다");
//            System.out.println("승강기 A가 " + Integer.parseInt(floorSelect) + "층으로 이동하였습니다.");
//            eleA = Integer.parseInt(floorSelect);
//
//            } else if (eleA_mi > eleB_mi) {
//
//            System.out.println(eleB + "층에서 엘리베이터를 호출합니다");
//            System.out.println("승강기 B가 " + Integer.parseInt(floorSelect) + "층으로 이동하였습니다.");
//            eleB = Integer.parseInt(floorSelect);
//            ;
//            } else if (eleA_mi == eleB_mi) {
//
//            System.out.println(eleA + "층에서 엘리베이터를 호출합니다");
//            System.out.println("승강기 A가 " + Integer.parseInt(floorSelect) + "층으로 이동하였습니다.");
//            eleA = Integer.parseInt(floorSelect);
