package ch05_controll;

public class RacingGame {
    public static void main(String[] args) throws InterruptedException {

        String lane1 = "1. ";
        String lane2 = "2. ";
        String lane3 = "3. ";
        String lane4 = "4. ";

        //🚙 🚗 🚕 🚌
        String car1 = "\uD83D\uDE99";
        String car2 = "\uD83D\uDE97";
        String car3 = "\uD83D\uDE95";
        String car4 = "\uD83D\uDE8C";

        while (true) {
            // 랜덤 숫자 생성
            // Math.random() 0~1
            // 6을 곱하면 0~6 소수
            //int로 바꾸기
            int ramdom = (int) (Math.random() * 6);

            //각 자동차는 1/6확률로 1칸 전진
            if (ramdom == 1) {
                lane1 += "_";
            } else if (ramdom == 2) {
                lane2 += "_";
            } else if (ramdom == 3) {
                lane3 += "_";
            } else if (ramdom == 4) {
                lane4 += "_";
            }
            // 콘솔창에 줄바꿈 20줄 20번 하도록해서 기존 내용이 안보이도록 하기
            for (int i = 0 ; i<20; i++)
                System.out.println();
            System.out.println(lane1 + car1);
            System.out.println(lane2 + car2);
            System.out.println(lane3 + car3);
            System.out.println(lane4 + car4);
            //각 레인의 길이가 40이 되면 break
            if (lane1.length() == 40){
                System.out.println("1번 승리!!");
                break;
            }
            if (lane2.length() == 40){
                System.out.println("2번 승리!!");
                break;
            }  if (lane3.length() == 40){
                System.out.println("3번 승리!!");
                break;
            }  if (lane4.length() == 40){
                System.out.println("4번 승리!!");
                break;
            }
            //잠깐 쉬기
            //100 밀리초만큼 쉬게한다.(0.1초)
            Thread.sleep(100);
        }
    }
}
