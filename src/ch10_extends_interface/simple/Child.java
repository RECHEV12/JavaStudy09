package ch10_extends_interface.simple;

// child 는 parent를 상속받는 클래스이다
// = 클래스 이름 옆에 extends Parent를 작성해준다
public class Child extends Parent{




    public Child() {
    }

    public Child(String name, int age) {
        // super는 부모 객체를 의미
        // super()는 부모의 생성자를 의미

        super(name, age);
    }

    // 부모가 가진 메소드를 자식 클래스에서 재정의
    // = Override

    @Override
    public void hello() {
//        super.hello(); //부모의 hello 메소드 실행
        System.out.println("아이인 " + name + "입니다.");
    }
}
