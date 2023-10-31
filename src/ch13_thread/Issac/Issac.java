package ch13_thread.Issac;

public class Issac {
    // 토스트의 수량
    private int toast = 0;

    // Issac 싱글톤 패턴 적용

    private Issac(){

    }

    private static Issac instance = new Issac();

    public static Issac getInstance() {
        return instance;
    }

    // 토스트 만들기( =chef 클래스가 가져다 씀)

    public void makeToast(){
        toast++;
        System.out.println("토스트를 하나 만들었습니다. 재고 : " + toast + "개");

    }

    // 토스트 구매( =Customer 클래스가 가져다 씀)
    // count는 사고자 하는 수량
    public void buyToast(int count){
        if (toast >= count){
        toast -= count;
            System.out.println("토스트를 " + count + "개 구매하였습니다.");
            System.out.println("남은 토스트 갯수 : " + toast + "개");
        }

    }






}
