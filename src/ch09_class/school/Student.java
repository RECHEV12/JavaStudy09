package ch09_class.school;

import ch09_class.common.UtilClass;

public class Student {
    // 필드변수를 private로 두고
    // 필드 변수에 대해 getter setter를 만드는 행위를
    // 캡슐화(Encapsulation)라고 한다

    private String name;
    private int kor;
    private int eng;
    private int math;
    private double avg;

    public Student() {
    }


    //ALT INSTERT 단축키 있음
    // 접근제어자
    // public : 해당 필드변수, 메소드, 생성자를 다른 패키지 폴더에서 사용 가능
    // private : 현재 파일 내에서만 사용 가능
    // (default) : 접근제어자 기입 안한 상태, 같은 패키지 내에서만 사용 가능
    // protected : 같은 패키지 내에서만 사용 가능
    public Student(String name, int kor, int eng, int math, double avg) {
        this.name = name;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
        calAvg();
    }

    public Student(String name, int kor, int eng, int math) {
        this(name, kor, eng, math, (kor + eng + math) / 3.0);
    }


    @Override
    public String toString() {
        return name  +
                ", 국어: " + kor +
                ", 영어: " + eng +
                ", 수학: " + math +
                ", 평균: " + avg ;
    }

    //kor, eng, math로부터 평균을 계산하여 avg 적용 메소드
    private void calAvg(){
        this.avg = UtilClass.myRound((kor + eng + math) / 3.0, 2);
    }

    //값을 넘겨주는 메소드
    public int getmath() {
        return math;
    }

    //private인 필드변수에 대한 get set 메소드를
    //getter setter 라고 부른다
    // 알트 인서트로 자동 생성 가능


    // 값을 수정하는 메소드
    public void setMath(int math) {
        this.math = math;
        calAvg();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getKor() {
        return kor;
    }

    public void setKor(int kor) {
        this.kor = kor;
        calAvg();
    }

    public int getEng() {
        return eng;
    }

    public void setEng(int eng) {
        this.eng = eng;
        calAvg();
    }


    public double getAvg() {
        return avg;
    }
}