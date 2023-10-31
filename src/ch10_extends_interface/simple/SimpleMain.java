package ch10_extends_interface.simple;

import java.util.*;

public class SimpleMain {
    public static void main(String[] args) {
        Parent miseon = new Parent("미선", 30);
        System.out.println(miseon);

        miseon.hello();

        Child jjanggu = new Child("짱구", 5);
        // 기본적으로 자식 클래스는
        // 부모 클래스의 필드변수와 메소드를 사용할 수 있다.
        System.out.println(jjanggu); // 부모의 toString 실행

        System.out.println(jjanggu.name);
        System.out.println(jjanggu.age);
        jjanggu.hello(); // 부모의 메소드 실행

        // 자식, 부모 간 형변환
        List<String> stringList = new ArrayList<>();
        Set<String> setString = new HashSet<>();
        Map<String, String> strMap = new HashMap<>();


        // 다형성 문제, 면접, 정처기 단골 문제
        Parent who = new Child("짱아", 2);
        who.hello();
    }
}
