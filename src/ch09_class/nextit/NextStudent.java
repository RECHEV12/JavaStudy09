package ch09_class.nextit;

public class NextStudent {
    String name; /* 학생 이름  */
    int age;     /* 학생 나이 */
    int level = 1;    /* 학생 레벨 */
    int exp;     /* 학생 경험치(경험치가 100이 되면 레벨업) */

    // 파라미터를 입력받지 않는 기본 생성자
    // 클래스 내에 생성자를 별도로 만들어주지 않으면
    // 보이지 않더라도 기본적을 존재한다
    NextStudent(){

    }
    // 파라미터를 입력받는 생정자 만들기
    NextStudent(String p_name, int p_age, int level, int exp){
        name = p_name;
        //this 현재 객체를 의미
        // 현재 객체의 필드변수에 생성자의 파라미터로 들어온 값 부여
        this.age = p_age;
        this.level = level;
        this.exp = exp;
    }
    NextStudent(String name, int age,int exp){
//        this.name = name;
//        this.age = age;
//        this.exp = exp;
//        this.level = 1;
        // this()는 현재 객체의 생성자를 의미한다.
        this(name, age, 1, exp);
    }
    //.toString() 메소드 오버라이딩
    // 단축키 ALT+ INSERT


    @Override
    public String toString() {
        return "NextStudent{" +
                "이름:'" + name + '\'' +
                ", 나이: " + age +
                ", 레벨: " + level +
                ", 경험치: " + exp +
                '}';
    }

    public void printState(){
        System.out.println("이름: " + name);
        System.out.println("나이: " + age);
        System.out.println("레벨: " + level);
        System.out.println("경험치: " + exp);
    }


    //하루가 지날 때 실행
    //경험치를 얻고, 경험치가 100 이상이 되면 레벨업
    public void oneDayLater(){
        exp += (int)(Math.random()*31) + 10;

        if (exp >= 100){
            level += 1;
            exp %= 100;
            System.out.println("레벨업!! 레벨이 " + level +"이(가) 되었습니다.");
        }
        System.out.println("현재 경험치 : " + exp);
    }

}
