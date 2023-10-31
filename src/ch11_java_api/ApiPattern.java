package ch11_java_api;

import java.util.regex.Pattern;

public class ApiPattern {
    public static void main(String[] args) {
        // 정규표현식(regular expression)
        // 특정한 규칙을 가진 문자열의 집합을 표현하기 위해 쓰는 형식

        // 숫자만 존재하는지 검증(유효성 검증, Validation)
        String example = "123121";
        String regex = "^[0-9]+$";
        //검사결과 T/F 리턴
        boolean result = Pattern.matches(regex, example);
        System.out.println(example + "의 검증 " + regex + " 의 결과 = " + result);

        // String 클래스 내부에 Pattern.matches를 적용한 메소드가 있음
        System.out.println(example.matches(regex));

        // 알파벳만 존재하는지 검증
        example = "dong woo";
        regex = "^[a-zA-Z\\s]+$";
        System.out.println(example + "의 검증 " + regex + " 의 결과 = " + example.matches(regex));

        // 한글만 존재하는지 검증
        example = "동우";
        regex = "^[가-힣]+$";
        System.out.println(example + "의 검증 " + regex + " 의 결과 = " + example.matches(regex));

        // 아이디 패턴
        // 영어 + 숫자 구성
        // 아이디는 7글자 이상 12글자 이하
        example = "hdaw112";
        regex = "^[a-zA-Z0-9]{7,12}$";
        regex = "^\\w{7,12}$";
        System.out.println(example + "의 검증 " + regex + " 의 결과 = " + example.matches(regex));

        // 비밀번호 패턴
        // 영어와 숫자 + 특수문자
        example = "Eefef123!";
        regex = "^[\\w~!@#$%^&*()_+=]+$";
        System.out.println(example + "의 검증 " + regex + " 의 결과 = " + example.matches(regex));

        // 영어 소문자, 대문자, 숫자, 특수문자 1개 이상
        // 8~16글자 사이
        example = "Eeeq123!";
        regex =  "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[~!@#$%^&*()+|=])[A-Za-z\\d~!@#$%^&*()+|=]{8,16}$";
        System.out.println(example + "의 검증 " + regex + " 의 결과 = " + example.matches(regex));

        // PIN 비밀번호 설정시
        // 6자리 숫자중 동일한 숫자 연달아 3개 이상 금지
        example = "232326";
        regex = "^.*(\\d)\\1\\1.*$";
        System.out.println(example + "의 검증 " + regex + " 의 결과 = " + example.matches(regex));
        if (!example.matches(regex)){
            regex = "^[0-9]{6}$";
            if (example.matches(regex)){
                System.out.println("동일한 숫자가 반복되지 않고 6자리임");
            }
        }

        // 이메일 형식 체크
        example = "hdw1202@naver.com";
        regex = "^[\\w]+@[a-zA-Z]+[.][a-zA-Z]+$";
        System.out.println(example + "의 검증 " + regex + " 의 결과 = " + example.matches(regex));




    }
}
