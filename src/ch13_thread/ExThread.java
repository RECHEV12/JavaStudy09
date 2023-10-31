package ch13_thread;

// 1. 스레드를 상속시킨다
public class ExThread extends Thread{

    private int num;

    public ExThread(int num){
        this.num = num;
    }
    // 2. Thread의 run 메소드를 OVerride 한다.
    // 멀티스레드로 던질 일에 해당한다.
    @Override
    public void run() {
        for (int i = num ; i <= num + 5 ; i++) {
            System.out.println(i);

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
