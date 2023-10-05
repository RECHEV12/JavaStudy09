package dongwoo.submit05;

public class Submit05 {
    public static void main(String[] args) {
        makeTree(5);

        System.out.println(reverseString("로꾸꺼"));

        System.out.println(makeBinary(16));

     makeTriangle(5);
    }

    /**
     * 나무 만들기 함수
     * @param num 만들고자 하는 나무의 크기
     */
    public static void makeTree (int num) {

        for (int i = 0 ; i <num ; i++){

            String blk = "";
            String stars = "";

            for (int k = 1; k < num-i ; k++){
                blk += " ";
            }
            for (int t = 0; t < (i*2)+1 ; t++){
                stars += "*";
            }
            System.out.println(blk+stars);
        }

    }


    /**
     * 거꾸로 단어 메소드
     *
     * @param n 거꾸로 만들 단어
     * @return 결과값
     */
    public static String reverseString(String n) {
        String reverAn = "";
        for (int i = 0; i < n.length(); i++) {
            String reverSub = n.substring(n.length() - (1 + i), n.length() - i);
            reverAn += reverSub;
        }
        return reverAn;
    }

    /**
     * 십진수를 이진수(String 타입)로 리턴해주는 makeBinary(int 타입) 함수
     * @param num 바꾸고자 하는 숫자
     * @return 결과값
     */
    public static String makeBinary(int num) {
        String plusBinary = "";
        while (true) {
            plusBinary += num % 2;

            if (num / 2 == 1) {
                plusBinary += 1;
                break;
            } else {
                num = num / 2;
            }
        }

        return reverseString(plusBinary);
    }


    /**
     * 삼각형 함수
     * @param num 만들고자하는 삼각형의 갯수
     */
    public static void makeTriangle(int num){
        for (int i = 0; i < num; i++) {
            String blk = "";
            for (int k = 1; k < num - i; k++) {
                blk += " ";
            }
            String stars = "*";
            String stars1 = "";
            for (int y = 1; y < i + 1; y++) {
                stars1 = "*";
            }
            String blk2 = "";
            {
                if (i == num - 1) {
                    for (int Q = 0; Q < (i * 2) - 1; Q++) {
                        blk2 += "*";

                    }
                } else {
                    for (int j = 0; j < (i * 2) - 1; j++)
                        blk2 += " ";
                }
            }

            System.out.println(blk + stars + blk2 + stars1);
        }

    }





}
