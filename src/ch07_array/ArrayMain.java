package ch07_array;

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
                System.out.print(strArray[i]);
            }
            else
            {
                System.out.print(strArray[i] + ", ");
            }

        }

    }







}
