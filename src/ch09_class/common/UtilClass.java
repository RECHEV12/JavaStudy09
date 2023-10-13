package ch09_class.common;

//유용한 함수 제공 클래스
public class UtilClass {
    /**
     * 입력한 소수를 소수 n번째 자리로 반올림하여 리턴해주는 메소드
     *
     * @param num 반올림하고자 하는 소수
     * @param n   소수 n번째 자리를 지정하는 정수
     * @return 반올림 된 소수 리턴
     */
    public static double myRound(double num, int n) {
        int bai = 1;
        for (int i = 0; i < n; i++) {
            bai = 10 * bai;
        }
        return (double) Math.round(num * bai) / bai;
    }


}
