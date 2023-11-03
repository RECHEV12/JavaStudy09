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
    // synchronized 를 붙여주어야 동기화 적용(=멀티스레드에서 안정적)
    public synchronized void makeToast(){
        toast++;
        System.out.println("토스트를 하나 만들었습니다. 재고 : " + toast + "개");

        // wait set에서 대기중인 임의의 스레드를 하나 깨운다.
//        notify();

        // wait set에서 대기중인 모든 스레드를 깨운다.
        notifyAll();

    }

    // 토스트 구매( =Customer 클래스가 가져다 씀)
    // count는 사고자 하는 수량
    public synchronized void buyToast(int count){
        if (toast >= count){
        toast -= count;
            System.out.println("토스트를 " + count + "개 구매하였습니다.");
            System.out.println("남은 토스트 갯수 : " + toast + "개");
        }else {
            // 토스트 수량이 구매하고자 하는 수량보다 부족
            // 해당 스레드를 대기시킨다.
            try {
                // wait를 실행한 스레드는
                // 다른 스레드에서 notify로 깨울때까지
                // 대기 상태에 놓인다.
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            buyToast(count);
        }



    }






}
