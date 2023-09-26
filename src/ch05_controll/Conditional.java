package ch05_controll;

public class Conditional {

    static String today = "월요일";
    public static void main(String[] args) {
        // 조건문 if
        int price = 30000;
        int myMoney = 10000;

        // myMoney가 Price보다 작으면 "돈이 부족합니다" 문구 출력
        // 조건 안에는 불리언타입이 들어간다.
        // if문의 소괄호 안 조건이 true면 종괄호 내부 실행 false면 실행 안함
        if(myMoney < price){
            System.out.println("돈이 부족합니다.");
        }
        // 중괄호 블록 안 명령어가 한줄 뿐 이라면 중괄호 블록을 생략할 수 있다.
        if(myMoney < price)
            System.out.println("돈이 부족합니다.");
        System.out.println("\n=========================\n");
        // 변수의 사용 범위(Scope)
        // 중괄호 블록 안에서 선언된 변수(지역 변수)는 해당 중괄호 블록 밖에서 사용할 수가 없다.
        String review = "맛있어요~";
        if (review.length() < 10);{
            // warning이 메모리에 등록이 되고 중괄호 블록이 끝나면 메모리에서 삭제
            String warning = "리뷰는 10글자 이상 작성해주세요";
        }
        // 전역 변수
        // class 중괄호 블록 안에 있는 선언된 변수
        // 해당 class내 어디에서든 사용 가능하다.
        System.out.println(today);

        // 조건에 따른 변수 값 변화
        // 리뷰 길이가 10글자 이상이면 warning " 통과" 담기
        String warning = "통과";
        if (review.length() < 10){
            System.out.println("리뷰는 10글자 이상 작성해주세요.");
        }
        System.out.println(warning);

        System.out.println("\n==================\n");

        // 삼항연산자는 조건에 따른 변수 값 변화시 사용하면 좋다.
        warning = (review.length() < 10) ? ("리뷰는 10글자 이상 작성해주세요.") : ("통과");
        System.out.println(warning);

        System.out.println("\n=========================\n");

        // else와 else if
        int numZero = 0;
        if (numZero < 0){
            System.out.println("numZero가 0보다 작다.");
        }else{
            // if문 조건이 false면 else 내부 코드 실행
            System.out.println("numZero가 0보다 크거나 같다.");
        }

        // 주민번호 뒷자리가 홀수면 남성 짝수면 여성
        int idBack = 3;
        if (idBack % 2 == 1){
            System.out.println("남성");
        }else {
            System.out.println("여성");
        }

        if (numZero < 0){
            System.out.println("numZero가 0보다 작다");
        }else if (numZero == 0){
            System.out.println("numZero가 0이다");
        }else {
            System.out.println("numZero가 0보다 크다");
        }

        System.out.println("\n=========================\n");
        // 세상 모든 가전제품에는 프로그래밍 코드가 들어가 있다.
        // 리모콘 전원 버튼 하나로 on/off 담당
        // isPowerOn 전원이 켜져있으면 true, 꺼져있으면 false
        boolean isPowerOn = false;
        // 전원 버튼 누르기
        if (isPowerOn == false){
            System.out.println("TV를 켭니다.");
            isPowerOn = true;
        }else if (isPowerOn == true){
            System.out.println("TV를 끕니다.");
            isPowerOn = false;
        }
        System.out.println("\n=========================\n");
            // 중복되는 코드는 밑으로 내러도 무방
            // bolean  타입을 on/off처럼 만드는 변수를 토글(toggle) 혹은 플래그(flag)라고 부른다
        if (!isPowerOn){
            System.out.println("TV를 켭니다.");
        }else{
            System.out.println("TV를 끕니다.");
        }
            isPowerOn = !isPowerOn;

        System.out.println("\n=========================\n");
        // 이중삼항연산자로 점수에 따른 등급 표현 -> if문
        int score = 85;
        String grade = "";
        // if, else if, else를 활용하여
        // 90이상 grade a
        // 80이상 grade b
        // 나머지는 grade c
        if (score >= 90){
            grade = "A";
        }else if (score >= 80){
            grade = "B";
        }else {
            grade = "C";
        }
            System.out.println(grade);



        grade = "C";
        if (score >= 90){
            grade = "A";
        }else if (score >= 80) {
            grade = "B";
        }

        System.out.println(grade);


        // 첫 순서가 true 가 걸리면 뒤는 보지도 않는다.
        // 순서를 잘 잡거나 범위를 확실하게 명시
        score = 92;
        if (score >= 80){
            grade = "B";
        } else if (score >= 90) {
            grade = "A";
        }else {
            grade = "C";
        }
        System.out.println(grade);

        System.out.println("\n=========================\n");
        // 회원가입 조건체크
        // 이름은 한글자 이상
        // 나이는 14세 이상
        // 휴대폰 번호는 10자리 또는 11자리
        String name = "ㄴ";
        int age = 20;
        String phone = "01020203939";

        if (name.length() > 0){
            // 이름 조건충족
            if (age >= 14) {
                // 나이조건 충족
                if (phone.length() == 10 || phone.length() == 11){
                    // 휴대폰 조건 통과
                    System.out.println("회원가입 성공!");
                }else {
                    System.out.println("회원 가입 불가\n사유 : 전화번호 오류");
                }
            }else{
                System.out.println("회원 가입 불가\n사유 : 나이 제한");
            }
        }else {
            //이름 조건 불통과
            System.out.println("회원 가입 불가\n사유 : 이름 글자수 불충");
        }

        // 논리 연산자를 이용하여 개선
        if (name.length() > 0
                && (age >= 14)
                && (phone.length() == 10 || phone.length() == 11))
        {
            System.out.println("회원 가입 성공!");
        } else {
            System.out.println("회원 가입 불가");
        }

        System.out.println("\n=========================\n");
        // switch문
        // 특정 변수에 대한 값에 따라 다른 구문을 실행하는 경우 사용
        // 교육기간 (단위 : 월)
        int month = 2;

        if (month == 0){
            System.out.println("자바, DB 배우는 중");
        } else if (month == 1){
            System.out.println("자바, 화면구현 배우는 중");
        } else if (month == 2) {
            System.out.println("자바FX 프로젝트(우웩)");
        }else if (month == 3){
            System.out.println("JSP-스프링, SPA 배우는 중");
        } else if (month == 4) {
            System.out.println("팀 프로젝트 하는 중");
        }else {
            System.out.println("취업, 수료");
        }
        // switch문 안에 변수를 넣는다.
        switch (month){
            case 0:
                System.out.println("자바, DB 배우는 중");

            case 1:
                System.out.println("자바, 화면구현 배우는 중");
                break;
            case 2:
                System.out.println("자바FX 프로젝트(우웩)");
                break;
            case 3:
                System.out.println("JSP-스프링, SPA 배우는 중");
                break;
            case 4:
                System.out.println("팀 프로젝트 하는 중");
                break;
            default: // if문의 else = default
                System.out.println("취업, 수료");
        }

        //month에 대한 계절을 출력해주는 switch 문 작성
        int month2 = 9;

        switch (month2){
            case 12:
            case 1:
            case 2:
                System.out.println("Winter");
                break;
            case 3:
            case 4:
            case 5:
                System.out.println("Spring");
                break;
            case 6:
            case 7:
            case 8:
                System.out.println("Summer");
                break;
            case 9:
            case 10:
            case 11:
                System.out.println("Fall");
                break;
        }


























    }
}
