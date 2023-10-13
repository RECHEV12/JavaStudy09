package ch09_class.nextit;

import ch09_class.school.Student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class NextitMain {
    public static void main(String[] args) {
        String gyName = "강연";
        int gyAge = 27;
        int gyLevel = 1;
        int gyExp = 40;

        String ymName = "유민";
        int ymAge = 27;
        int ymLevel = 1;
        int ymExp = 30;

        // 하루가 지나서 경험치가 오른다.
        gyExp += 30;
        ymExp += 30;

        // 이틀이 지남
        gyExp += 30;
        ymExp += 30;

        // 삼일이 지남
        gyExp += 30;
        ymExp += 30;

        // 경험치가 100 이상이 되면 레벨업
        if (gyExp >= 100){
            gyLevel++;
            gyExp %= 100;
        }
        if (ymExp >= 100){
            ymLevel++;
            ymExp %= 100;
        }

        System.out.println(gyName);
        System.out.println(gyLevel);
        System.out.println(gyExp);

        System.out.println(ymName);
        System.out.println(ymLevel);
        System.out.println(ymExp);

        System.out.println("\n===========================\n");
        // 클래스로부터 객체 생성
        NextStudent gangyeon = new NextStudent();

        // 객체의 속성(=필드변수)에 접근
        System.out.println(gangyeon.name);
        System.out.println(gangyeon.age);
        System.out.println(gangyeon.level);
        System.out.println(gangyeon.exp);

        // 필드변수에 값을 담아주지 않으면
        // 생성된 객체의 필드 변수들은 초기값(default)인 상태
        // 숫자: 0, 불리언 : false, 나머지 : null

        gangyeon.name = "강연";
        gangyeon.age = 27;
        gangyeon.level = 1;
        gangyeon.exp = 40;

        System.out.println(gangyeon);

        System.out.println(gangyeon.name);
        System.out.println(gangyeon.age);
        System.out.println(gangyeon.level);
        System.out.println(gangyeon.exp);

        // 하루가 지남
        gangyeon.exp += 30;
        System.out.println(gangyeon.exp);

        // 이틀이 지남
        gangyeon.exp += 30;
        System.out.println(gangyeon.exp);

        if (gangyeon.exp >= 100){
            gangyeon.level += 1;
            gangyeon.exp %= 100;
        }

        // 삼일이 지남
        // 객체의 메소드 실행
        gangyeon.oneDayLater();

        System.out.println("\n===========================\n");

        NextStudent yumin = new NextStudent();
        yumin.name = "유민";
        yumin.age = 27;
        yumin.level = 1;
        yumin.exp =  30;

        yumin.oneDayLater();
        yumin.oneDayLater();
        yumin.oneDayLater();

        //동일한 클래스로부터 생성된 객체들은
        //같은 속성(필드변수)과 메소드를 가지고 있으나
        //속성의 값은 개별적이다.

        // 한번에 속성값 확인하기
        // 객체를 println에 넣었을 때 자동으로 출력된다(toString)
        System.out.println(yumin.toString());
        System.out.println(gangyeon);
        //toString()이 있으면 필요 없음
        gangyeon.printState();
        yumin.printState();

        System.out.println("\n===========================\n");
        // 필드값을 입력받는 생성자(Constructor)로 객체를 생성하기
        // new NextStudent();에서  NextStudent()를 생성자라고 부름
        // 파라미터를 입력받지 않는 생성자를 기본생성자라고 함
        NextStudent minje = new NextStudent("민재", 21, 1, 30);
        System.out.println(minje);

        // 나머지 학생들 중 2명을 객체 만들기
        NextStudent dongwoo = new NextStudent("동우" , 26, 1, 80);
        NextStudent taegon = new NextStudent("태곤", 36, 1, 50);

        //생성자를 생성해서 레벨 기본값 1이 나오도록 만들기
        NextStudent jiwoo = new NextStudent("지우", 27, 40);
        System.out.println(jiwoo);

        System.out.println("\n===========================\n");
        // 객체의 복사

        NextStudent taegonBot = new NextStudent(taegon.name, taegon.age, taegon.level, taegon.exp);

        taegonBot.name = "태곤봇";
        System.out.println(taegonBot);
        System.out.println(taegon);

        // 하루가 지났습니다.
        gangyeon.oneDayLater();
        yumin.oneDayLater();
        jiwoo.oneDayLater();
        dongwoo.oneDayLater();
        taegon.oneDayLater();

        // 이틀이 지났습니다.
        gangyeon.oneDayLater();
        yumin.oneDayLater();
        jiwoo.oneDayLater();
        dongwoo.oneDayLater();
        taegon.oneDayLater();

        //여러개의 객체 한번에 다루기
        ArrayList<NextStudent> stuList = new ArrayList<>();
        stuList.add(gangyeon);
        stuList.add(yumin);
        stuList.add(jiwoo);
        stuList.add(dongwoo);
        stuList.add(taegon);


        for (int i = 0 ; i < stuList.size() ; i ++){
            System.out.println(stuList.get(i));
        }

        //하루가 더 지났습니다.
        for (int i = 0 ; i < stuList.size() ; i ++){
           stuList.get(i).oneDayLater();
        }
        //향상된 for 문
        for( NextStudent stu : stuList){
            System.out.println(stu);
        }

        //5일이 한 번에 지난다.
        for (int t = 0 ; t <5 ; t++){
            for (int i = 0 ; i < stuList.size() ; i ++){
                stuList.get(i).oneDayLater();
            }
        }
        for( NextStudent stu : stuList){
            System.out.println(stu);
        }
        System.out.println("\n===========================\n");
        //굳이 객체를 변수에 담은 후 리스트에 추가하지 않아도 된다.
        NextStudent jangseon = new NextStudent("장선", 30, 30);
        stuList.add(jangseon);

        stuList.add(new NextStudent("창연", 34, 80));
        for( NextStudent stu : stuList){
            System.out.println(stu);
        }

        for (int t = 0 ; t <100 ; t++){
            for (int i = 0 ; i < stuList.size() ; i ++){
                stuList.get(i).oneDayLater();
            }
        }
        for( NextStudent stu : stuList){
            System.out.println(stu);
        }
        System.out.println("\n===========================\n");

        // stuList에 담겨있는 학생들의 레벨 기준으로 정렬

        for (int t = 0 ; t <stuList.size()-1 ; t++){
            for (int i = 0 ; i<stuList.size() - 1 ; i++){
               if (stuList.get(i).level < stuList.get(i+1).level){
                   NextStudent tmp = stuList.get(i);
                   stuList.set(i , stuList.get(i+1));
                   stuList.set(i+1, tmp);

                }
            }
        }

        for( NextStudent stu : stuList){
            System.out.println(stu);
        }
        // 등수와 함께 출력
        for (int i = 0 ; i < stuList.size() ; i ++ ){
            System.out.println((i+1) + "등. " + stuList.get(i));
        }

        System.out.println("\n===========================\n");
        //Collections.sort()사용
        // stuList.get(i)<stuList.get(i+1)과 유사한 상태가 되서
        // 정렬이 안됨
        // ->정렬 기능을 알려주면 된다
        Collections.sort(stuList, new Comparator<NextStudent>() {
            @Override
            public int compare(NextStudent stuA, NextStudent stuB) {
                //기준
                // 왼쪽 stuA의 레벨에서 오른쪽 stuB의 레벨을 뺀 값이
                // 양수인지 음수인지에 따라 내부적으로 자리를 바꾼다.
                // stuA.level - stuB.level 오름차순
                // stuB.level - stuA.level 내림차순
                return stuB.level - stuA.level;
            }
        });
        for (int i = 0 ; i < stuList.size() ; i ++ ){
            System.out.println((i+1) + "등. " + stuList.get(i));
        }
        System.out.println("\n===========================\n");
        Collections.sort(stuList, (stuA, stuB) -> stuB.level - stuA.level);
        Collections.sort(stuList, (stuA, stuB) -> {
            return stuB.level - stuA.level;
        });


        Student naruto = new Student();





    }
}
