package ch10_extends_interface.mysort;

import ch09_class.school.Student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MySortMain {
    public static void main(String[] args) {
        ArrayList<Student> stuList = new ArrayList<>();

        stuList.add(new Student("코난", 98, 89, 77));
        stuList.add(new Student("짱구", 28, 46, 97));
        stuList.add(new Student("나루토", 92, 39, 87));
        stuList.add(new Student("루피", 88, 69, 79));
        stuList.add(new Student("이치고", 81, 82, 67));

        for (Student stu : stuList) {
            System.out.println(stu);
        }

        // 정렬
        // 인터페이스의 추상메소드를 이용한 콜백함수 구현
        // 인터페이스의 추상메소드를 Collections의 sort메소드 안에 사용한 후
        // 추상메소드의 구현은 sort 메소드를 실행하는 쪽에서 정의 내린다.
        Collections.sort(stuList, new Comparator<Student>() {
            @Override
            public int compare(Student stuA, Student stuB) {
                if (stuA.getAvg() - stuB.getAvg() < 0) {

                    return -1;
                }
                return 0;
            }
        });

        System.out.println("\n=======================\n");

        MyCollections.mysort(stuList, new MyComparator<Student>() {
            @Override
            public boolean mycompare(Student stuA, Student stuB) {

                return stuA.getAvg() > stuB.getAvg() ;
            }
        });
        for (Student stu : stuList) {
            System.out.println(stu);
        }
    }
}