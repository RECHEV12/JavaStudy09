package ch02_variable;

public class VariableMain {
    public static void main(String[] args) {
        //변수 선언
        //[변수타입] [변수명]의 형태
        int myMoney; //변수가 선언됨-> 메모리에 변수명 등록
        //변수에 값을 담지 않은 경우는 사용할 수 없다.
        //주석 단축키 Ctrl + /
//        System.out.println(myMoney);

        //변수에 값 할당 = 변수 초기화(Initialization = Init)
        //=를 사용하여 변수에 값을 담을 수 있다.
        //=는 오른쪽의 값을 왼쪽의 그릇에 담는 기능을 수행한다.
        myMoney = 10000;
        System.out.println(myMoney);

        // 변수의 값 변경 가능
        myMoney = 100000;
        System.out.println(myMoney);
        //변수의 선언과 함께 값을 할당

        int number = 10;

        //변수의 타입
        byte bytenMum = 5;
        short shortNum = 5000;
        int intNum = 30000;
        //21억을 초과하는 숫자에 대해 뒤에 L을 붙여야 long 타입으로 인식
        long longNum = 111111111112321313L;
        char charNum = 5456;





        // 소수타입의 경우 그냥 입력하면 doudble 타입으로 인식
        // 뒤에 f를 붙여줘야 float로 인식
        float pi = 3.141592f;
        double doubleNum = 100.34234;

        //불리언 타입은 true false만 담을 수 있다
        boolean isGood = true;

        // 변수의 다중선언
        int numOne, numTwo;
        numOne = 1;
        numTwo = 2;

        // Java에서는 다중선언과 동시에 값을 부여할 수 없다.
//        int a, b, c = 4, 5, 6;

        //상수의 선언
        final double MATH_PI = 3.141592;
        //상수는 값을 바꿀 수 없다. 바뀔 일이 없는 값을 상수로 사
//        MATH_PI = 5.2;
        System.out.println("\n==============\n");
        int testNum = 15;
        System.out.println(testNum);
        System.out.println(testNum);
        System.out.println(testNum);
        System.out.println(testNum);
        System.out.println(testNum);
        System.out.println(testNum);
        System.out.println(testNum);
        System.out.println(testNum);
        System.out.println(testNum);
        System.out.println(testNum);
        System.out.println(testNum);
        System.out.println(testNum);
        System.out.println(testNum);
        System.out.println(testNum);
        System.out.println(testNum);

        System.out.println("\n==============\n");

        System.out.println(32);
        System.out.println(32);
        System.out.println(32);
        System.out.println(32);
        System.out.println(32);
        System.out.println(32);
        System.out.println(32);
        System.out.println(32);
        System.out.println(32);
        System.out.println(32);
        System.out.println(32);
        // 이곳 저곳 사용할 때 변수 활용하는 것이 편함
        // 수정할 때 용이하다.
        // 값에 대한 이름을 부여할 수 있다.
        int myAge = 26;
         System.out.println(myAge);
        System.out.println("\n========================char==============\n");

        // char는 문자를 담는데 사용
        // 유니코드에 등록된 각 문자들의 넘버링을 담을 수 있다.
        // 작은 따옴표 안에 하나의 문자를 담을 수도 있다.
        // A는 유니코드에서 65번째 위치
        char numA = 65;
        System.out.println(numA);
        char ioi = 'o';
        System.out.println(ioi);
        char hangul = 44032;
        System.out.println(hangul);

        //++를 붙이면 1이 증가한다
        hangul++;
        System.out.println(hangul);

        ioi++;
        System.out.println(ioi);

        //byte는 -128 ~ 127
        byte byteNumber = 127;
        byteNumber++;
        System.out.println(byteNumber);
















    }

}


