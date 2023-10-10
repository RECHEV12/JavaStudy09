package ch07_array;

import java.beans.Encoder;
import java.util.Arrays;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Collection;
import java.util.Collections;

public class ArrayMain {
    public static void main(String[] args) {
        String samjang = "삼장";
        String woogong = "오공";
        String saojeong = "사오정";
        String palgye = "저팔계";
        // 문자열(String) 값들을 담는 배열 선언
        // 오른쪽 대괄호 안 숫자는 해당 배열이 담을 수 있는 값의 갯수를 의미
        String[] seoyugi = new String[4];
        // .length
        // 해당 배열의 크기를 리턴(문자열의 length와 달리 소괄호가 없음)
        System.out.println(samjang.length());
        System.out.println(seoyugi.length);

        // 배열 안에 담겨 있는 값을 요소(element)라고 함
        // 배열 내 요소 확인 = 인덱스
        System.out.println(seoyugi[0]); //배열 내 인덱스 0번 값 확인(인덱싱)

        // 크기만 선언되고 값을 별도로 부여하지 않은 배열 내에는
        // 해당 타입의 기본 값이 들어있다.
        // 숫자타입 = 0, 0.0
        // boolean타입 =  false
        // 참조타입 = null
//        System.out.println(seoyugi[4]); // 배열에 존재하지 않는 인덱스를 넣으면 에러 발생


        int[] numbers = new int[5];
        System.out.println(numbers[1]);

        boolean[] booleans = new boolean[3];
        System.out.println(booleans[2]);

        System.out.println("\n===========================\n");

        // 배열에 값 넣기
        seoyugi[0] = samjang;
        seoyugi[1] = "오공";
        seoyugi[2] = saojeong;
        seoyugi[3] = palgye;

        System.out.println(seoyugi[2]);

//        seoyugi[4] = "이수근";
//        System.out.println(seoyugi[4]);

        System.out.println(seoyugi);

        // 한번에 배열 내 요소를 확인
        // for문 이용한 배열 순회
        for (int i = 0 ; i < seoyugi.length ; i++){
            // 4번 반복
            System.out.println(seoyugi[i]);
        }

        // 배열 내 요소를 한 번에 볼 수 있는 함수 만들기
        System.out.println("\n===========================\n");

        printArray(seoyugi);

        // 자바에서 배열은 직접적으로 사용해서 만들어 쓰기에는 배열의 크기가 고정되어서 불편해서 안씀
        // 자바에서는 컬렉션(자바를 모아서 사용하하는)을 주로 사용한다

        // 배열의 장점은 for문을 이용하여 배열에 담긴 모든 요소를 한번에 처리할 수 있다
        // 모든 값 앞에 서유기 붙이기
        //

        for (int i = 0 ; i < seoyugi.length ; i++) {
         seoyugi [i] = "서유기 " + seoyugi[i];
        }
            printArray(seoyugi);

         // 배열 내 특정 요소에 접근하여 처리할 수 있다.
        for (int i = 0 ; i < seoyugi.length ; i++) {
//            seoyugi [i].equals("서유기 오공");
//            seoyugi [i].contains("서유기 오공");
            if (seoyugi [i].indexOf("서유기 오공") != -1){
                // seoyugi [i]는 서유기 오공이다.
                seoyugi[i] = seoyugi[i].replace("서유기", "드래곤볼");
            }
        }
        printArray(seoyugi);
        System.out.println("\n===========================\n");
        int[] intArray = new int[6];
        //기존 값 넣는 방식
        intArray[0] = 1;
        intArray[1] = 2;
        intArray[2] = 3;

        printArray(intArray);

        //숫자 배열 안에 로또 번호 넣기
        //math.random() : 0~1사이의 소수 리턴(1은 안나옴)
        // math.random() * 10 : 0~10 10은 안나옴
        // (int)math.random() * 10 :0~9사이 정수
        // 로또번호 1~45사이의 랜덤정수
        // (int)(math.random() * 45) :0~44사이 정수
        // (int)(math.random() * 45) +1 :1~45사이 정수

        for(int i = 0 ; i < intArray.length ; i++){
            intArray[i] = (int)(Math.random() * 45) +1;
        }

        printArray(intArray);

        System.out.println("\n===========================\n");

        // 배열을 선언함과 동시에 값을 지정
        String[] students = {"동우", "강연", "유민"};

        printArray(students);
        System.out.println("\n===========================\n");
        //문자열 나누기
        String myInfo = "정찬웅, 010-7398-7332, akow283@gmail.com";
        // .split(문자열)
        // 괄호안 문자열 기준으로 해당 문자열을 나누어
        // 문자열 배열로 리턴
        String[] infoArray = myInfo.split(", ");
        System.out.println(infoArray.length);
        System.out.println(infoArray[0]);
        System.out.println(infoArray[1]);
        System.out.println(infoArray[2]);

        myInfo = "정찬웅, 010-7398-7332,akow283@gmail.com";
        String[] myInfoArray = myInfo.split(",");
        // 각각의 요소에 좌우 공백 제거
        for (int i = 0 ; i < myInfoArray.length ; i++){
            myInfoArray[i] = myInfoArray[i].trim();
        }
        printArray(myInfoArray);

        System.out.println("\n===========================\n");

        String calStr = "해리포터+반지의제왕+막내아들";
        String[] calArray = calStr.split("\\+");
        // regex 정규표현식(regular expression)의 약자
        // * ? + 의 경우 정규표현식에서 특정 기능을 가지는 특수문자
        // 일반 문자로 사용하려면 해당 문자 앞에 \\ 를 붙여야 한다

        printArray(calArray);

        // 정규표현식 예시
        // PIN 비밀번호를 숫자만 기입했는지 체크
        // PIN 비밀번호에 동일한 숫자가 여러번 들어깄는지 체크
        // 비밀번호에 알파벳, 숫자, 특수기호 각각 1개 이상 들어갔는지 체크

        System.out.println("\n===========================\n");
        // 배열의 복사
        String[] sinSeoyugi = seoyugi;
        printArray(seoyugi);
        printArray(sinSeoyugi);

        sinSeoyugi[0] = "강호동";
        sinSeoyugi[1] = "이수근";
        printArray(sinSeoyugi);
        printArray(seoyugi);

        //@앞은 객체의 타입
        //@ 뒤는 메모리 주소의 해쉬코드를 16진수로 나타낸 것
        System.out.println(seoyugi); //
        System.out.println(sinSeoyugi); //[Ljava.lang.String;@36baf30c

        //해쉬코드(hashcode)
        //객체의 메모리 주소값에 해쉬를 적용한 코드
        // 실메 메모리 주소 -> 해쉬함수 적용-> 해쉬코드값
        System.out.println(seoyugi.hashCode());
        System.out.println(sinSeoyugi.hashCode()); //918221580


        System.out.println(Integer.toHexString(918221580)); //= 36baf30c

        // 해쉬(hash)
        // 해쉬함수(암호화 알고리즘)를 이용해서
        // 데이터를 암호화 하는 기법


        //base64 문자열 인코딩(암호화 아님)
        Base64.Encoder base64Encoder = Base64.getEncoder();
        String password = "1q2w3e4";
        //문자열을 byte 배열로 변환
        byte[] byteArray = password.getBytes();

        // byte 배열을 문자열로 변환
        String encryption = new String(base64Encoder.encode(byteArray));
        System.out.println(encryption);

        //인코딩된 문자열을 디코딩
        Decoder base64Decoder = Base64.getDecoder();
        String decryption = new String(base64Decoder.decode(encryption));

        System.out.println(decryption);

        System.out.println("\n===========================\n");
        //올바른 배열 복사
        String[] newSeoyugi = seoyugi.clone();

        printArray(seoyugi);
        printArray(newSeoyugi);

        newSeoyugi[2] = "은지원";

        printArray(newSeoyugi);
        printArray(seoyugi);

        // clone없이 복제
        String[] synSeoyugi = new String[seoyugi.length];
        for (int i = 0 ; i < seoyugi.length ; i++){
            synSeoyugi[i] = seoyugi[i];
        }
        printArray(seoyugi);
        printArray(synSeoyugi);

        synSeoyugi[2] = "안재현";
        printArray(synSeoyugi);

        System.out.println("\n===========================\n");
        //숫자 배열
        int[] numArray = {6, 13, 22, 3, 7, 30, 40};

        System.out.println(numArray[0]);
        System.out.println(numArray[1]);

        // 인덱스 0번 값과 인덱스 1번의 값의 위치를 바꿔보자

        int[] newNumArray = numArray.clone();

        numArray[0] = newNumArray[1];
        numArray[1] = newNumArray[0];

        System.out.println(numArray[0]);
        System.out.println(numArray[1]);

        int temp = numArray[0];
        numArray[0] = numArray[1];
        numArray[1] = temp;

        swap(numArray[3], numArray[4]);
        printArray(numArray);

        //가끔 면접에 나옴
        // Call by Value 와 Call by Reference 구분
        // 기본타입 변수에 대해서는 Call by Value로 동작
        // 참조타입 변수에 대해서는Call by Reference로 동작

        int a = 10;
        int b = a;

        System.out.println(b);

        a = 20;
        System.out.println(b);

        swap(a,b); // 20, 10
        System.out.println(a);
        System.out.println(b);

        printArray(numArray);
        swap(numArray, 3, 4);
        printArray(numArray);

        System.out.println("\n===========================\n");

        //정렬(sort)
        Arrays.sort(numArray); // 오름차순
        printArray(numArray);

        //내림차순 정렬
        //참조타입 객체를 담는 배열에 대해서만 가능
//        Arrays.sort(numArray, Collections.reverseOrder());

        //오름차순을 이용한 내림차순
        //1. numArray의 모든 요소에 -1 *
        //2. Array.sort()를 적용
        //3. 다시 -1 *

        for (int i = 0 ; i <numArray.length ; i++){
            numArray[i] *= -1;
        }
        printArray(numArray);

        Arrays.sort(numArray);
        printArray(numArray);

        for (int i = 0 ; i <numArray.length ; i++){
            numArray[i] *= -1;
        }

        printArray(numArray);


        //정렬(알고리즘)
        System.out.println("\n===========================\n");

        int[] intArreee = {3, 5, 8, 2, 4, 1};

        for (int t = 0 ; t <intArreee.length-1 ; t++){
            for (int i = 0 ; i<intArreee.length - 1 ; i++){
                if (intArreee[i] > intArreee[i+1]) {
                    int tmp = intArreee[i];
                    intArreee[i] = intArreee[i + 1];
                    intArreee[i + 1] = tmp;

                }
            }
        }
       printArray(intArreee);


        System.out.println("\n===========================\n");

        // 다차원 배열
        // 1차원 배열
        int[] oneDirArr = {1, 2, 3};
        // 2차원 배열
        int[][] twoDirArr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        // 1 2 3
        // 4 5 6
        // 7 8 9

        // 2행 4 5 6 꺼내기
        printArray(twoDirArr[1]);

        // 3행 2열 {8}
        System.out.println(twoDirArr[2][1]);

        // 3차원 배열
        int[][][] threeDirArr = {{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}},
                                 {{10, 11, 12}, {13, 14, 15}, {16, 17, 18}},
                                 {{19, 20, 21}, {22, 23, 24}, {25, 26, 27}}
                                    };

        // 0층
        // 1 2 3
        // 4 5 6
        // 7 8 9

        System.out.println(threeDirArr[2][0][0]);

    }

    /**
     * 배열 글자 병렬 표시
     * @param strArray 배열 이름
     */
    public static void printArray(String[] strArray){
        for (int i = 0 ; i < strArray.length ; i++)
        {
            if (i == strArray.length - 1)
            {
                System.out.println(strArray[i]);
            }
            else
            {
                System.out.print(strArray[i] + ", ");
            }

        }

    }
    public static void printArray(int[] intArray){
        for (int i = 0 ; i < intArray.length ; i++)
        {
            if (i == intArray.length - 1)
            {
                System.out.println(intArray[i]);
            }
            else
            {
                System.out.print(intArray[i] + ", ");
            }

        }

    }

    public static void swap(int idxA, int idxB){
        int temp = idxA;
        idxA = idxB;
        idxB = temp;
    }

    public static void swap(int[] intArray, int idxA, int idxB){
        int temp = intArray[idxA];
        intArray[idxA] = intArray[idxB];
        intArray[idxB] = temp;
    }

}
