package ch13_thread.Issac;

public class Chef extends Thread {

    // 1. 콜백함수용 추상메소드를 가진 인터페이스 생성
    public EndCook endCook;




    @Override
    public void run() {
        Issac issac = Issac.getInstance();
        for (int i = 0; i < 20; i++) {
            issac.makeToast();

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        // 생산 끝
        endCook.theEnd(); // 추상 메소드 상태
    }
}
