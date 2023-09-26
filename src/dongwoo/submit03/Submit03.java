package dongwoo.submit03;

public class Submit03 {
    public static void main(String[] args) {
        int qusOne = 1;
        for (int i = 1; i <= 10; i++) {
            qusOne *= i;
        }
        System.out.println(qusOne);

        long qusOneAlpha = 1L;
        for (int i = 1; i <= 15; i++) {
            qusOneAlpha *= i;
        }
        System.out.println(qusOneAlpha);

        System.out.println("\n=========================\n");


        String findWally = "윌리울리일리울리울리일리월리일리윌리월리울리일리일리월리일리윌리일리윌리일리월리월리윌리울리윌리울리일리울리울리윌리일리";
        int wally = 0;
        for (int i = 0 ; i < findWally.length() - 2 ; i++){
            String walo = findWally.substring(i , i+2);
            if (walo.equals("월리")){
                wally += 1;
            }
        }
        System.out.println(wally);

        System.out.println("\n=========================\n");

        String stars = "*****";
        for (int i = 0 ; i < stars.length() ; i++){
            String starsAn= stars.substring(0,5-i);
            System.out.println(starsAn);
        }

        System.out.println("\n=========================\n");
        String reverAn = "";
        String reverse = "로꾸꺼 로꾸꺼";
        for (int i = 0 ; i < reverse.length() ; i++){
            String reverSub = reverse.substring(reverse.length()-(1+i),reverse.length()-i);
            reverAn += reverSub;
        }
        System.out.println(reverAn);






















    }


















}
