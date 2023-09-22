package ch04_operator;

public class OperatorMain {
    public static void main(String[] args) {

        //산술 연산자(operator)
    int numA = 10;
    int numB = 3;

        // numA에 1 더하기
        numA = numA + 1;
        System.out.println(numA);
        // numA에 20 더하기
        numA = numA + 20;
        System.out.println(numA);
        // numA에 21 빼기
        numA = numA -21;
        System.out.println(numA);

        System.out.println("더하기 " + numA + numB);
        System.out.println("더하기 " + (numA + numB));
        System.out.println("빼기 " + (numA - numB));
        System.out.println("곱하기 " + (numA * numB));
        System.out.println("나누기 " + (numA / numB));
        System.out.println("나머지 " + (numA % numB));

        System.out.println("\n=========================\n");

        // 증감 연산자
        numA++; // 1증가
        System.out.println(numA);

        numA--; // 1감소
        System.out.println(numA);

        ++numA; // 1증가
        System.out.println(numA); //11

        System.out.println(numA++); //11 글자가 먼저 출력되서 11이 된다 고로 ++을 먼저 주면 됨
        System.out.println(numA); //12
        System.out.println(++numA);

        System.out.println("\n=========================\n");

        // 대입 연산자
        numA = numA + 1; // 산술
        numA++; // 증감
        numA += 60; // 대입
        System.out.println(numA);

        numA -= 30;
        System.out.println(numA);
        numA *= 3;
        System.out.println(numA);
        numA /= 2;
        System.out.println(numA);
        numA %= 2;
        System.out.println(numA);

        System.out.println("\n=========================\n");

        // 문자열 더하기
        String subway = "반석역";
        subway = subway + " 지족역";
        System.out.println(subway);

        //대입 연산자도 가능(뒤에만 추가 가능)
         subway += " 노은역";
        System.out.println(subway);

        subway = "대전지하철 " + subway + " 월드컵경기장역";
        System.out.println(subway);

        System.out.println("\n=========================\n");

        // 형(Type) 변환 - Casting
        int intNum = 15;
        double doubNum = 1.23;

        System.out.println(intNum * doubNum);

        // int +/*- double은 double 타입이 된다(자동 형변환)
        double mulResult = intNum * doubNum;

        // int +/*- float은 float 타입이 된다(자동 형변환)
        float floatMul = intNum + 2.34f;

        // 정수와 소수를 곱하거나 나누면 결과는 소수가 나온다.
        // 같은 정수타입과 같은 소수타입의 경우, 메모리 크기만 허용된다면 형변환이 가능
        long longNum = 4356;
        //int castLong = 4356L; // int는 메모리가 작아 자동형변환x
        int castLong = (int) 3560000000L; //(타입)값을 이용하여 강제 형변환이 가능하다.
        System.out.println(castLong); // 크기가 넘어가는 경우 제대로 된 값이 담기지 않는다.

        // 숫자와 문자열을 더하면 숫자가 문자열로 자동 형변환이 되어 문자 이어붙이기가 된다.
        String month = "이번달 " + 9;

        // 강제 형변환 주의사항
        int intCast = (int)3.376;
        System.out.println(intCast); // int가 정수이기에 소수가 다 사라진 3만 출력.

        int intMul = (int) (10 * 3.333);
        System.out.println(intMul);
        //가장 많이 하는 실수력
        //10/3 ->33333
        // 연산값이 소수 일지라도, 정수타입이 유지됨으로 정수만 출

        double result = (double) 10 / 3;
        System.out.println(result);

       //프로그래밍에서의 소수 연산의 정확도는 떨어지지만 소수 둘,셋째자리까지 사용하기 때문에 상관하지 않아도 된다.
       //정확한 소수 연산이 꼭 필요하다면 다른 사람들이 만들어 놓은 라이브러리를 가져다 쓰면 된다.

        // 숫자형 문자열을 정수로 형변환
        String strNum = "123";
        System.out.println(strNum + 2);

        int num = Integer.parseInt(strNum);
        System.out.println(num + 2);

        //소수형 문자열을 소수타입으로 형변환
        strNum = "23.45";
        double numDoub = Double.parseDouble(strNum);
        System.out.println(numDoub + 1.23);

        System.out.println("\n=========================\n");

        //나머지 연산자(%) 사용 예시

        // 홀수 짝수 판별할 때
        // 2로 나누었을 때 0이면 짝수, 1이면 홀수
        int anyNum = 7;
        System.out.println(anyNum % 2);

        System.out.println("\n====================페이징===================\n");

        // 게시판 페이징 구현
        int totalCountGul = 333; // 게시판에 글이 총 33개 있다.
        int showCountPage = 10; // 한 페이지에서 보여줄 글의 수가 10개

        // 총 페이지 수 4페이지
        // 33/10 =3.3(올림처리) = 4
        int totalPage = (int)Math.ceil((double)totalCountGul / showCountPage);
        System.out.println(totalPage);

        // 마지막 4페이지에 있는 글의 개수 = 3
        // 33/ 10 = 3

        int countlastPage = (totalCountGul % showCountPage );
        System.out.println(countlastPage);

        System.out.println("\n====================연산자===================\n");
        // 비교 연산자
        int numFive = 5;
        double pi = 3.14;
        int numOne = 1;

        // 비교 결과에 따라 TRUE와 FALSE가 리턴된다.
        System.out.println(numFive < numOne);
        System.out.println(numFive > numOne);

        // 결과가 TRUE와 FALSE라서 boolean에 담을 수 있다.
        boolean boolrst = numFive > numOne;

        System.out.println(numFive < pi);

        // ==는 왼쪽과 오른쪽이 같은지 비교

        System.out.println(numFive == pi);
        System.out.println(numFive == 5);

        // !=는 왼쪽과 오른쪽이 다른지 비교
        // 다르다면 TRUE와 FALSE
        System.out.println(numOne != numFive);
        System.out.println(numFive != 5);

        // 문자(char)도 비교연산자를 통해 이름순 정렬에 사용할 수 있다.
        System.out.println('가' < '나'); // 유니코드상 '가'가 '나'보다 먼저 위치 = '가'가 작은 숫자 라는 뜻

        String cat = "고양이";
        String dog = "강아지";

        System.out.println(dog.charAt(0) < cat.charAt(0));

        String ship = "배";
        String pear = "배";
        String stomach = new String("배");
        System.out.println(ship == pear);
        System.out.println(ship == stomach);
        System.out.println(pear == stomach);

        // 문자열 값이 같은지 비교
        // .equals(문자열)
        // 해당 문자열이 괄호 안에 문자열과 같다면 true 다르면 false
        System.out.println(ship.equals(stomach));

        // 빈 문자열 체크
        String inputData = "";
        System.out.println(inputData.equals(""));
        System.out.println(inputData.length() == 0);
        System.out.println(inputData.isEmpty()); // 빈 문자열이면 true


        System.out.println("\n====================삼항 연산자===================\n");

        // 삼항 연산자
        String inputId = "RECHEV12";

        //inputId의 글자수가 7글자 이상이면 통과, 미만이면 탈락
        // 첫번째 항에는 조건(boolean), 두번째 항에는 조건이 true일 때 리턴, 세번째 항에는 조건이 false일 때 리턴
        String check = (inputId.length() >= 7) ? ("통과") : ("탈락");

        System.out.println(check);

        //삼항 연산자의 괄호는 생략가능
        int checkInt = (inputId.length() >= 7) ? 1 : 0;
        System.out.println(checkInt);

        int score = 85;
        // score가 90점 이상이면 "A", 미만이면 "B"가 담기도록
        String grade = (score >= 90) ? "A" : "B";
        System.out.println(grade);

        //이중 삼항연산자
        // score가 90점 이상이면 "A", 미만이면 80점 이상이면 "B", 그 외 "C"
        // 형식은 () ? (): ( () ? () : ()  )
        String grade2 = (score >= 90) ? ("A") : ( (score >= 80) ? ("B") : ("C"));
        System.out.println(grade2);

        System.out.println("\n==================== 논리 연산자 ===================\n");

        // 논리 연산자
        // 조건 체크를 여러번 하지 않고 한번에 끝낼 수 있도록 도와줌

        // 회원가입 시, 나이는 14세 이상, 이름은 한글자 이상
        // 휴대폰 번호는 11자리 또는 10자리

        int inputAge = 10;
        String inputPhone = "01073987332";
        String inputName = "동우";
        System.out.println(inputName.length() >= 1);
        System.out.println(inputAge >= 14);

        // 논리 연산자 AND
        // &&
        // && 좌측 조건 우측 조건 모두 true일 때만 true로 리턴
        // 둘 중 하나라도 만족하지 않으면 false를 리턴
        System.out.println(inputPhone.length() == 10);
        System.out.println(inputPhone.length() == 11);
        System.out.println(inputName.length() >= 1 && inputAge >= 14);

        // 논리 연산자 OR
        // ||
        // || 좌측 조건 우측 조건 중 하나라도 true일 때 true로 리턴
        //    둘 다 만족하지 않으면 false를 리턴
        System.out.println(inputPhone.length() == 10 || inputPhone.length() ==11);
        // 10<= x <= 11 은 기동 불가
        // 10<= x && x <= 11
        System.out.println(10 <= inputPhone.length() && inputPhone.length() <= 11);

        // !
        // !를 boolean 타입 앞에 붙이면 값을 뒤집는다.
        // 이름은 1글자 이상 = 이름은 empty가 아니어야 한다.
        // name이 empty일 때 true 리턴
        // inputName.isEmpty() // 공백일 때 트루 리턴
        //!inputName.isEmpty() // 공백이 아닐 때 트루 리턴


        System.out.println(
                !inputName.isEmpty()
                && inputAge >= 14
                && (inputPhone.length() == 10 || inputPhone.length() == 11)
        );

        System.out.println("\n=====================================\n");

        // 비트연산자(실무에서 거의 사용 않함)
        // 2진수의 이해 필요
        int bitTen = 10; // 1010
        int bitNine = 9; // 1001
             //"AND" 연산     // 1000
             //"OR"  연산     // 1011
             //"XOR"  연산    //   11
        // 비트연산자 AND
        // &
        // 2진수의 각 자리수를 비교해서 같은 자리의 숫자가 둘 다 1이면
        // 그 자리에 1이 남고, 둘 중 하나라도 1이 아니면 그 자리에 0이 남는다.
        System.out.println(bitTen & bitNine); // 8 -> 1000

        // 비트연산자 OR
        // |
        // 2진수의 각 자리수를 비교해서 같은 자리의 숫자가 둘 중 하나라도 1이면
        // 그 자리에 1이 남고, 둘 댜 1이 아니면 그 자리에 0이 남는다.
        System.out.println(bitTen | bitNine); // 11

        //비트연산자 XOR
        //^
        // 각 자리수를 비교해서 서로 다른 경우에만 그자리에 1이 남음
         System.out.println(bitTen ^ bitNine); // 3 -> 0011

        // 2진수 예시
        // 4가지 취미를 나타내기 위해 숫자로 저장
        // 0 0 0 1 : 축구
        // 0 0 1 0 : 야구
        // 0 1 0 0 : 농구
        // 1 0 0 0 : 배구
        // 강연 : 0011 -> 3
        int gyLike = 3;
        // 동우 : 0110 -> 6
        int dwLike = 6;
        System.out.println(gyLike & dwLike);

        // 리눅스에서 파일, 폴더의 권한을 설정하는 명령어인 chmod
        // chmod rwx rwx rwx 각각 777이면 전체권한 설정

        // 십진수 303과 147에 대해서 비트연산자 &를 직접 해보기
        System.out.println(303 & 147);


        11110100
         1100100
       1100100




    }
}
