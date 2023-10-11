package ch08_collection;

import java.util.*;

public class CollectionSet {
    public static void main(String[] args) {
        // 배열처럼 set을 우리가 직접적으로 만들어서 사용하는 경우는 드물다
        // 하지만 사용법은 알아야 한다
        // set = 집합
        // set 중에 hashSet 학습

        HashSet<String> stuSet = new HashSet<String>();
        HashSet<String> stuSet2 = new HashSet<>();

        // 다형성
        Set<String> stuSet3 = new HashSet<>();

        //.add 값 추가
        stuSet.add("유민");
        stuSet.add("민재");
        stuSet.add("강연");
        stuSet.add("태곤");

        // 값 확인
        // 담고있는 데이터의 인덱스 및 순서가 존재하지 않는다.
        System.out.println(stuSet);

        // 중복데이터 담을 수 없다.
        stuSet.add("태곤");
        System.out.println(stuSet);

        System.out.println("\n===========================\n");

        // .contains(객체)
        // 해당 객체가 set안에 있으면 true 없으면 false
        System.out.println(stuSet.contains("태곤"));

        // .size
        // set 내부 요소 리턴
        System.out.println(stuSet.size());

        System.out.println("\n===========================\n");

        //set 내부 요소 순회
        // 1. while문 사용

        Iterator<String> iterator = stuSet.iterator();
        while (iterator.hasNext()){
            String stu = iterator.next();
            System.out.println(stu);
        }
        System.out.println("\n===========================\n");
        //2. 향상된 for문
        for ( String stu : stuSet ){
            System.out.println(stu);
        }
        System.out.println("\n===========================\n");
        // 3. forEach문
        stuSet.forEach(s -> {
            System.out.println(s);
        });
        System.out.println("\n===========================\n");
        // set 중복 허용 안하는 특성 이용
        // 중복제거

        ArrayList<Integer> intList = new ArrayList<>();

        for (int i = 0 ; i < 10 ; i ++){
            int rand = (int) ((Math.random() * 11) + 10);
            intList.add(rand);
        }

        // 1차 10개 숫자 랜덤 지정
        System.out.println(intList);

        HashSet<Integer> intSet = new HashSet<>();
        // intList 내부 요소들이 intSet에 담긴다
        intSet.addAll(intList);
        System.out.println(intSet); // 중복된 데이터 하나만 남음

        intList.clear();
        intList.addAll(intSet);

        System.out.println(intList); // 순서 박


    }
}
