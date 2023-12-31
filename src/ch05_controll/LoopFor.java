package ch05_controll;

public class LoopFor {
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
            if (i % 2 == 0) {
                sum += i;
            }
        }
        System.out.println(sum);

        sum = 0;
        // 실행 결과는 같으나 실행 횟수는 더 적기에 실행속도 증가 = 성능이 증가
        for (int i = 0; i <= 40; i += 2) {
            sum += i;
        }
        System.out.println(sum);


        // 0부터 2까지 0.2마다 출력
        // 소수타입은 연산이 정확하지 않으므로 비추천
        for (double i = 0; i <= 2; i += 0.2) {
            System.out.println(i);
        }

        // 0부터 2까지 0.2마다 출력
        for (int i = 0 ; i <= 20  ; i += 2){
            System.out.println((double) i / 10);
        }

        System.out.println("\n=========================\n");

        // 구구단 2단
        // for문으로 표현

        for (int i = 1 ; i <= 9 ; i++){
            System.out.println("2 x " + i + " = " + (i*2));
        }
        System.out.println("\n=========================\n");
        System.out.println("*");
        System.out.println("**");
        System.out.println("***");
        System.out.println("****");
        System.out.println("*****");
        //표현
        String star = "";
        for (int i = 0 ; i<5 ; i++){
            star += "*";
            System.out.println(star);
        }
        System.out.println("\n=========================\n");
        // 나머지 연산자(%)의 사용 예시
        // for문 내에서 순환하는 숫자에 대해 사용하면 좋다.

        //국수공장에서 면을 20cm 뽑고 있다.
        for (int i = 0 ; i <20; i ++){
            System.out.println("||||||||");

            if (i == 4 || i == 9 || i == 14){
                System.out.println("------");
            }
            // i가 4, 8, 14일 때 절단 시키기
            if (i % 5 == 4){
                System.out.println("------");
            }
        }

        System.out.println("\n=========================\n");
        // 라면 공장에서 면을 30cm 뽑고 있는데
        // 6cm마다 잘라주어야 한다.
        // 콘솔창에 //////
        //        \\\\\\
        for (int i = 1 ; i <= 30 ; i++){
            if (i % 2 == 1){
                System.out.println("//////");
            }else //if (i % 2 == 0)
            {
                System.out.println("\\\\\\\\\\\\");
            }
            // 조건을 체크하는 목적이 다르면 if문은 분리
            if (i % 6 == 0){
                System.out.println("----------");
            }
        }
        System.out.println("\n=========================\n");
        //10부터 1까지

        for (int i  = 0 ; i < 10 ; i++){
            System.out.println(10 - i);
        }
        for (int i = 10 ; i>=1 ; i--){
            System.out.println(i);
        }

        System.out.println("\n=========================\n");

        //for문으로 string 사용
        //숫자형 문자열의 각 자리수를 더한 결과 얻기
        String example = "47325";
        int result = 0;
        for (int i = 0 ; i < example.length() ; i++){
            System.out.println(example.substring( i , i+1));
            result += Integer.parseInt(example.substring( i , i+1));
        }
        System.out.println(result);
        System.out.println("\n=========================\n");
        //슈의 갯수는?
        String syusyu = "슈슈슈슈슈슘슝ㅈㅅ뮷ㅅㄴㅇㅅ뮤슈슈슈슈ㅠㄴㅁㅇ슈ㅠ슛";
        // syusyu에서 정확히 슈라는 글자가 몇 글자
        // 한글자 씩 잘라서 "슈"와 일치하는지 체크(if문)
        // 개수 체크(if가 실행될 때마다 1씩 증가하는 변수 필요)
        int syuPlus = 0;
        for (int i = 0 ; i < syusyu.length() ; i++){
            String syuss = syusyu.substring(i, i+1);
                if (syuss.equals("슈")) {
                    syuPlus += 1;
                }
        }
        System.out.println("슈의 갯수 : " + syuPlus);
        System.out.println("\n=========================\n");
        // break문
        // 반복문을 종료 시키는데 사용
        // 반복횟수를 줄여서 실행속도를 향상시키는데 사용

        // 내 이름을 유니코드로 표현한다면?
        // 유니코드 0~70000 중에 찾기
        //
        char word = 0;
        for (int i = 0 ; i < 70000 ; i++){
            if (word == '우'){
                System.out.println(i);
                System.out.println(word);
                break; //  break문이 실행되면 가까운 반복문(for while)
                // 하나를 즉시 종료
            }
            word++;
        }
        System.out.println("\n=========================\n");

        //continue 문
        // 구구단을 출력하는 중에 너무 쉬운  1 2 3 은 출력안함
         for (int i = 0 ; i <= 9 ; i++){
             if (i<4){
                 // 반복문 내에서 continue가 실행되면
                 // 바로 다음 반복문으로 넘어간다
                 // (continue 아래의 코드는 실행되지 않음)
                 continue;
             }
             System.out.println("8 x " + i + " = " +  (8 *  i));

        }
        System.out.println("\n=========================\n");
         // 구구단(2단~9단) 출력
        for (int i = 2 ; i<= 9 ; i++){
            System.out.println(i + "단");
            for (int t = 2 ; t<=9 ; t++){
            System.out.println(i + " X " + t + " = " + i*t);


            }
            System.out.println("----------");
        }
        // 디버깅 기능
        /*
            디버깅모드
            코드 라인 좌측(라인 숫자 있는 부분)을 마우스 좌클릭
            breakpoint가 생성된다.(빨간 동그라미)
            다시 좌클하면 사라짐
            breakpoint 생성 후 디버깅모드 실행시(shift + F9)
            코드들이 위에서부터 실행되다가 breakpoint가 있는 지점에 멈춰서 대기

            이후 하단 debug 탭의 step over(F8)를 실행하면
            한단계씩 실행이 이루어진다.
            코드를 한줄씩 실행해보면서 컴퓨터가 정확히 어디를 실행하고
            그때마다 변수에 어떤 값이 담기고 있는지 확인할 때 사용

            디버빙 모드 종료(ctrl + F2)
         */

        System.out.println("\n=========================\n");
        //트리
        //     *
        //    **
        //   ***
        //  ****
        // *****
        // i = 0 _> 공백4칸 *1칸
        // i = 1 _> 공백3칸 *2칸
        // i = 2 _> 공백2칸 *3칸



        for (int i = 0 ; i <5 ; i++){
            String blk = "";
            for (int k = 0; k < 4-i ; k++){
                blk += " ";
            }
            String stars = "";
            for (int t = 0; t < 1+i ; t++){
                stars += "*";
            }
            System.out.println(blk + stars);
        }

        // 트리
        //      *   0   +1
        //     ***  1   +2
        //    ***** 2   +3
        //   *******    3   +4
        //  *********   4   +5

        for (int i = 0 ; i <5 ; i++){
            String blk = "";
            for (int k = 0; k < 4-i ; k++){
                blk += " ";
            }
            String stars = "";
            for (int t = 0; t < i+i+1 ; t++){
                stars += "*";

            }
            System.out.println(blk + stars);
        }
























    }
}
