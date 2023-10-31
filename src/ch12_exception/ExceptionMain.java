package ch12_exception;

import java.text.ParseException;
import java.util.Iterator;
import java.util.Scanner;

public class ExceptionMain {
    public static void main(String[] args) {
        int[] intArray = {1, 2, 3};


        // 대부분 예외 상황에 대해 에러가 났다고 표현(=뻑났다)
        // 깊게 들어갔을 때의 에러는 코드에 실수가 있는 경우에 해당(= 코드 고치기)
        // 예외는 어느정도 예측이 가능한 예외와, 예측하지 못한 예외로 나눌 수 있다.
        // = try-catch를 이용하여 처리가능

        try {
            // try 중괄호 내부에는 에러가 발생할 가능성이 있는 코드를 넣는다.
            System.out.println(intArray[10]);
            System.out.println("인뎅싱 끝");
        } catch (ArrayIndexOutOfBoundsException aioobe) { // try 내부 코드에서 타입에 맞는 에러 발생 시 실행
            aioobe.printStackTrace(); // 에러 메시지 출력
        }


        System.out.println("\n---------------------------------------------\n");

        try {
            System.out.println(intArray[10]);
        } catch (Exception e) { // 모든 예외 클래스의 최상위 객체이므로 어떤 예외든 캐치됨
            e.printStackTrace();
            // 에러가 콘솔창에 출력되는 시점과 println 이 콘솔창에 출력되는 시점이 다르다.
            System.out.println("빨간글씨들 아래");
            System.err.println("빨간글씨들 출력");
            System.out.println("검정글씨들 아래");
            // 스프링 프레임워크 (자바가 서버 벡단을 맡음)
            // 에서 예외처리 상황이라면 에러페이지로 전환하도록 함
        }


        // 예외처리는 충분한 테스트 이후에 적용하는 것을 권장
        // 개발 후반부에 전체적으로 예외처리를 싹 다 해주는 경우가 많다.


        System.out.println("\n---------------------------------------------\n");

        Scanner scan = new Scanner(System.in);

//        while (true){
//            System.out.println("행동 선택");
//            System.out.println("1. 밥먹기 | 2. 잠자기 | 3. 종료");
//            System.out.print(">>> ");
//
//            int command = 0;
//            try {
//
//            command = Integer.parseInt(scan.nextLine());
//            }catch(Exception e){
//                System.out.println("숫자만 입력해주세요.");
//
//                continue;
//            }
//
//            if (command == 1){
//                System.out.println("냠냠쩝쩝");
//            }
//            else if (command == 2){
//                System.out.println("쿨쿨");
//
//            }
//            else if (command == 3){
//                System.out.println("종료");
//
//            }else {
//                System.out.println("잘못 입력하셨습니다.");
//
//            }
//        }

        System.out.println("\n---------------------------------------------\n");

        try {
            int rand = (int) (Math.random() * 10);
            System.out.println(intArray[rand]);
        } catch (ArrayIndexOutOfBoundsException aioobe) { // 예측 가능한 예외 상황 처리
            System.out.println("배열의 인덱스를 넘어감");
        } catch (Exception e) { // 예측 못한 예외 상황 발생 시 처리(최후의 보험)
            System.out.println("예측하지 못한 예외 발생");

        }

        // 일반적으로 예측 가능한 예외 상황 처리를 위해
        // 따로 Exception을 상속받은 클래스를 만들어서 사용
        // BizException(비즈니스 익셉션)
        System.out.println("\n---------------------------------------------\n");

        // dateToMillSec를 최종적으로 실행하는 부분에서는 쓰로우를 하지 않고 try-catch를 해준다.
        try {
            long time = ExMethod.dateToMillSec("2023");
            System.out.println(time);
        } catch (ParseException e) {
            System.out.println("날짜 형식은 yyyy.MM.dd");
        }

        try {
            System.out.println(ExMethod.game(30));
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            System.out.println("0~2중 하나의 숫자를 입력");
        }


        try {

            ExMethod.printName("123");
        }catch (BizException b){
            b.printStackTrace();

            System.out.println(b.getMessage());
            System.out.println(b.getErrCode());
        }catch (Exception e){
            System.out.println("예측 불가능한 에러");
        }
    }
}

