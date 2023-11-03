package ch02_variable;

public class StringMain {
    public static void main(String[] args) {
        // 문자열 (String)
        // 문자열을 처리할 수 있는 String 클래스를 보유
        // 문자열을 다룰 수 있는 다양한 메소드들이 존재
        // 문자열은 쌍따옴표("")안에 있는 문자를 의미
        // char 타입의 '가'는 string 타입의 "가"와 서로 타입이 다르다.
        String fruits = "Apple, Banana, Cherry";
        System.out.println(fruits);

        // .length()
        //문자열의 길이를 리턴(괄호 안에 있는 작용이 먼저 일어나고 후에 발동되는)
        System.out.println(fruits.length());
        System.out.println("Apple, Banana, Cherry".length());
        // .charAt(인덱스)
        // 인덱스는 배열에서 해당 요소의 순번에 해당
        // 인덱스는 0부터 시작
        // 밑에는 15번째 글자인 C가 출력되는 모습. char타입으로 리턴
       //String p = fruits.charAt(15);    // 'C'
        char v = fruits.charAt(15);
        System.out.println(v);

        // .indexOf(문자열)
        // 해당 문자열에서 괄호 안에 있는 문자열의 인덱스(위치)를 리턴
        System.out.println(fruits.indexOf("Banana"));

        // 괄호 안 문자열을 포함하지 않는다면 -1을 리턴
        System.out.println(fruits.indexOf("Melon"));
        // .contains는 문자열을 포함하면 true, 안하면 false를 리턴
        System.out.println(fruits.contains("Melon"));
        // 대소문자를 구별하며, 가장 앞에 있는 문자의 인덱스만을 리턴
        System.out.println(fruits.indexOf("a"));

        // .substring(시작 인덱스, 끝 인덱스)
        // 해당 문자열을 시작 인덱스에서 끝 인덱스 전까지 자른 값을 리턴
        System.out.println(fruits.substring(7, 13));
        // 해당 문자열이 변하지는 않음
        System.out.println(fruits);
        // 숫자를 하나만 작성할 경우, 그 위치부터 끝까지 출력
        System.out.println(fruits.substring(15));

        // .replace(바뀔 문자열, 바꾸고 싶은 문자열)
        // 해당 문자열에서 특정 문자열을 바꾸고 싶은 문자열로 교체
        System.out.println(fruits.replace("Cherry", "Melon"));
        System.out.println(fruits);

        // 원본에 적용하는 법
        System.out.println(fruits.replace("Cherry", "Melon"));
        fruits = fruits.replace("Cherry", "Melon");
        System.out.println("\n==================\n");
        System.out.println(fruits);

        // .trim()
        // 해당 문자열의 양 끝에 존재하는 모든 공백문자를 제거함
        // 외부에서 가져온 데이터에 있는 공백 처리에 사용
        String world = "  The New World!    ";
        System.out.println(world.trim());
        // replace를 이용하여 공백제거
        System.out.println(world.replace(" ", ""));

        // .tuUpperCase()
        // .toLowerCase()
        // 해당 문자열에 존재하는 알파벳들을 전부 대문자/소문자로 바꾼 값을 리턴
        System.out.println(world.trim().toUpperCase());
        // 대소문자를 구별하지 않는 검색 기능을 구현할 때 사용
        System.out.println(fruits.toLowerCase().contains("banana"));
        // .concat(문자열)
        // 해당 문자열 뒤에 괄호 안에 문자열을 이어붙인 결과 리턴
        System.out.println(fruits.concat(", Cherry"));
        //문자열 이어 붙이기는 + 기호로도 구현 가능
        System.out.println(fruits + ", cherry");
        System.out.println("\n====\n");
        fruits = fruits + ", Cherry";
        System.out.println(fruits);
        fruits = "Mango, " + fruits;
        System.out.println(fruits);

        System.out.println("\n===============\n");
        //빈 문자열(Empty) 라고 부른다.
        String nothing = "";
        System.out.println(nothing);
        System.out.println(nothing.length());
        System.out.println(nothing.replace("","super"));

        //기본타입 변수는 null값을 가질 수 없다
        //int number = null; //컴파일 에러

        //String은 참조타입이므로 null값을 가질 수 있다.
        //참조타입인 변수를 객체(instance)라고 부른다.
        String nullthing = null;
        System.out.println(nullthing);

        // 둘 다  값이 없는 것을 보이지만
        // 본체가 없는 null과 빈 문자열 Empty는 다르다





    }


}
