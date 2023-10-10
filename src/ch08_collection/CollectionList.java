package ch08_collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class CollectionList {
    public static void main(String[] args) {
        //리스트(ArrayList)

        // 리스트 객체 선언
        ArrayList<String> students = new ArrayList<String>();
        ArrayList<String> students2 = new ArrayList<>();
        // 다향성을 이용한 선언
        List<String> students3 = new ArrayList<>();

        // <> 제너릭 안에는 참조타입 객체만 담을 수 있다.
        // 숫자를 담는 컬렉션 리스트를 선언하고자 한다면
        // 기본타입의 경우 wrapper Class 를 이용한다.
        ArrayList<Integer> intList = new ArrayList<>();

        // wrapper Class는 기본타입의 데이터를 참조타입의 객체로 사용해야 하는 경우 사용한다.
        int num = 23;
        // 기본타입의 데이터를 Wrapper Class의 객체로 변환
        // = 박싱(boxing)
        // deprecated = 지원종료
        Integer numObj = num; //오토박싱
        System.out.println(numObj + 7);

        // Wrapper Class에 저장된 값을
        // 기본타입의 데이터로 꺼내기(언박싱) 하기

        // 오토 언박싱
        int val = numObj.intValue();
        System.out.println(val);

        // 오토 박싱과 언박싱이 자동으로 이루어지기 때문에
        // 기본타입에 대해  Wrapper Class를 이용한다 해도
        // 불편함이 없다.

        System.out.println("\n===========================\n");

        // ArrayList에 값  담기
        // .add() 사용
        intList.add(1); // 1 담기
        intList.add(2); // 2 담기
        intList.add(3);
        intList.add(4);
        intList.add(5);
        intList.add(6);
//        intList.add(6 , 7 , 8, 8, 9); 이렇게 여러개 한번에 못담음
        // 배열과 달리 컬렉션은 출력했을 때 내부 요소들이 잘 출력된다.
        System.out.println(intList);

        students.add("지우");
        students.add("성복");
        students.add("장선");
        students.add("태곤");
        students.add("창연");

        System.out.println(students);

        //<>제너릭 타입과 일치하는 데이터만 추가 가능

        System.out.println("\n===========================\n");

        // 리스트의 길이 리턴
        // .size()
        System.out.println(students.size());
        //값이 들어있지 않으면 사이즈는 0이다.
        ArrayList<String> tempList = new ArrayList<>();
        System.out.println(tempList.size());

        // 인덱싱
        //.get(인덱스)

        System.out.println(students.get(2));

        // 해당 인덱스의 값 변경
        // .set(인덱스, 변경값)
        students.set(2, "유민");
        System.out.println(students);

        //.contains(객체)
        // 리스트 안에 해당 객체가 존재하면 true, 없으면 false를 리턴
        // 나중에 클래스로 만든 객체들을 담게되면 잘 동작 안한다.
        //.index(객체)
        // 리스트 안에 해당 객체가 있으면 인덱스 리턴 없으면 -1 리턴
        System.out.println(students.contains("유민"));
        System.out.println(students.indexOf("유민"));

        //.isEmpty()
        //리스트가 비어있으면 true 아니면 false
        // .size() == 0 과 같다
        System.out.println(students.isEmpty());
        System.out.println(students.size() == 0);

        //.remove(인덱스)
        // 해당인덱스의 데이터 삭제
        students.remove(2);
        System.out.println(students);
        System.out.println(students.size()); // 삭제 후 사이즈가 줄어든다.
        System.out.println(students.get(2));

        //.clear()
        //리스트를 비움 (size가 0이 됨)
        students.clear(); // 기존 리스트 내부 요소 제거
        System.out.println(students);

        // 리스트를 초기화 해도 된다(Init)
        students = new ArrayList<>(); // 새롭게 생성된 빈 리스트로 변경

        System.out.println("\n===========================\n");

        // for문으로 ArrayList 내부요소 제어
        students.add("지우");
        students.add("성복");
        students.add("장선");
        students.add("태곤");
        students.add("창연");

        // 학생 이름 앞에 넘버링 추가
        // 1. 지우 2. 성복. 장선

        for (int i = 0 ; i < students.size() ; i++){
            students.set(i, (i+1) + ". " + students.get(i));
        }

        System.out.println(students);
        System.out.println("\n===========================\n");
        Collections.sort(intList); // 오름차순
        System.out.println(intList);
        Collections.sort(intList, Collections.reverseOrder());
        System.out.println(intList);






    }
}
