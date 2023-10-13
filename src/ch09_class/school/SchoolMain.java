package ch09_class.school;

import ch09_class.common.UtilClass;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SchoolMain {
    public static void main(String[] args) {
        // 학교의 성적 입력, 관리하는 프로그램 만들 예정
        // 각 학생에 대해 객체로 만들어 써야겠다.
        // 학생은 이름, 국어점수, 영어점수, 수학점수, 평균을 가진다.

        Student minjae = new Student("민재", 65, 33, 42, (65 + 33 + 42) / 3.0);
        System.out.println(minjae);

        Student yumin = new Student("유민", 78, 82, 100);
        System.out.println(yumin);

        System.out.println(yumin.getmath());


        // 필드변수값
        yumin.setMath(97);
        System.out.println(yumin); // 평균 변하지 않음

        //필드변수 수정에 대한 제어
        yumin.setEng(83);
        System.out.println(yumin);

        // 평균은 수정되면 안됨
        // 평균에 대한 setter를 지워야 한다
//        yumin.setAvg(90.5);
        System.out.println(yumin);
        // 기본적으로 클래스 내 메소드는
        // 해당 클래스를 객체로 생성한 후 사용
//      Student.getMath()

        // Math  클래스 내 메소드를 Math 객체로 생성하지 않아도 사용 가능
        Math.random();
        Math.round(3.14);

        // static이 붙어있는 빌드변수와 메소드는
        // 해당 클래스를 객체로 생성하지 않아도 사용 가능
        UtilClass.myRound(3.14159, 2);

        yumin.setKor(86);
        System.out.println(yumin);

        System.out.println("\n===========================\n");

        ArrayList<Student> stuList = new ArrayList<>();
        stuList.add(minjae);
        stuList.add(yumin);
        stuList.add(new Student("지우", 76, 98, 75));
        stuList.add(new Student("동우", 86, 88, 85));
        stuList.add(new Student("강연", 77, 99, 64));

        for (int i = 0; i < stuList.size(); i++) {
            System.out.println(stuList.get(i));
        }

//        stuList 학생들의 평균을 이용해서 종합 성적표 출력
//        1등/ 유민 2등 동우 3등 지우 순대로출력

        for (int i = 0; i < stuList.size() - 1; i++) {
            for (int t = 0; t < stuList.size() - 1; t++) {
                if (stuList.get(t).getAvg() < stuList.get(t + 1).getAvg()) {
                    Student tmp = stuList.get(t);
                    stuList.set(t, stuList.get(t + 1));
                    stuList.set(t + 1, tmp);
                }
            }
        }
        System.out.println("\n===========================\n");
        for (int i = 0; i < stuList.size(); i++) {
            System.out.println((i + 1) + "등. " + stuList.get(i));
        }

        System.out.println("\n===========================\n");
        Collections.sort(stuList, (stuA, stuB) -> ((stuA.getAvg() - stuB.getAvg() < 0) ? -1 : 1));
        Collections.sort(stuList, (stuA, stuB) ->
        {
            int result = 1;
            if (stuA.getAvg() - stuB.getAvg() < 0)
            {
                result = -1;
            }
            return result;
        });

        Collections.sort(stuList, new Comparator<Student>() {
            @Override
            public int compare(Student stuA, Student stuB) {
                return ((stuA.getAvg() - stuB.getAvg() < 0) ? -1 : 1);

            }
        });

    }
}