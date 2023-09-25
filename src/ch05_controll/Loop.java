package ch05_controll;

public class Loop {
    public static void main(String[] args) {
        //반복문
        //for문
        int one = 1;
        System.out.println("\n=========================\n");
        // 반복문 사용
        // ; 를 기준으로
        //  초기화식 ; 조건식 ; 증감식
        // 초기화식에는 for문의 반복횟수를 결정해주는 변수 설정
        // 증감식에는 for문이 반복될 때마다 변수의 증가량 설정
        // 조건식에는 for문이 반복되는 기준을 설정

        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }
        //for문 내부 변수 i는  for문 내에서 선언되고 종료시 제거된다.
        // System.out.println(i); 사용불가

        for (int i = 1; i <= 10; i++) {
            System.out.println(i);
        }

        // for의 내부 변수 i는 for문의 반복 횟수를 조정하기 위함
        // for믄 내에서 꼭 i를 사용할 필요는 없다.
        // i는 단순히 변수명일 뿐이므로 i가 아닌 다른 단어를 사용해도 무방
        System.out.println("\n=========================\n");
        // 10번 반복하는 for문 완성
        for (int number = 0; number < 10; number += 1) {
            System.out.println(one++);
        }

        // 정말 많이 쓰게 될 for문 형식

        for (int i = 0; i < 20; i++) {

        }

        System.out.println("\n=========================\n");

        // 1부터 20까지 더한 값
        // 변수의 스코프를 이용한 for문 작성
              // 1부터 40까지 중에 짝수끼리만 더한 값을 구하기
        int sum = 0;
        for (int i = 1; i <= 40; i++) {
            if (i % 2 == 0){
                sum += i;
            }
        }
        System.out.println(sum);


    }
}
