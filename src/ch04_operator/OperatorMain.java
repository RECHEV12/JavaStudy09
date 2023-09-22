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

        // 홀수 짝수 판별
        // 2로 나누었을 때 0이면 짝수, 1이면 홀
        int anyNum = 7;
        System.out.println(anyNum % 2);










    }
}
