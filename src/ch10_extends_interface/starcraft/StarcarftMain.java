package ch10_extends_interface.starcraft;

import java.util.ArrayList;

public class StarcarftMain {
    public static void main(String[] args) {
        Marine marine = new Marine();


        System.out.println(marine);

        Marine marine2 = new Marine();

        System.out.println(marine2);

        marine.stimpack();

        System.out.println(marine);

        Zealot zealot = new Zealot();

        System.out.println(zealot);

        marine.move(10, 20);
        zealot.move(10, 20);

        marine.attack(zealot);

        System.out.println(zealot);

        HighTemplar highTemplar = new HighTemplar();

        System.out.println(highTemplar);

        highTemplar.psionicStorm();
        highTemplar.hallucination();

        marine.attack(highTemplar);

        System.out.println(highTemplar);

        Zealot zealot2 = new Zealot();
        Zealot zealot3 = new Zealot();
        Zealot zealot4 = new Zealot();
        Zealot zealot5 = new Zealot();
        Zealot zealot6 = new Zealot();


        // 테란 본진에 출격
        zealot.move(100, 150);
        zealot2.move(100, 150);
        zealot3.move(100, 150);

        // 질럿을 드래그해서 한 번에 이동시키기
        ArrayList<Zealot> zealotList = new ArrayList<>();
        zealotList.add(zealot);
        zealotList.add(zealot2);
        zealotList.add(zealot3);
        zealotList.add(zealot4);
        zealotList.add(zealot5);
        zealotList.add(zealot6);


        for (int i = 0; i < zealotList.size(); i++) {
            zealotList.get(i).move(100, 150);
        }


        // ArrayList<Zealot>에 하이템플러 담을 수 없다
//        zealotList.add(highTemplar);

        // 다형성(Polymorphism)
        // 하나의 객체가 여러 타입을 가질 수 있는 것

        // 자식 객체에서 부모 객체로 형변환이 가능하다.
        StarUnit starZealot = zealot; // Zealot -> StarUnit 자동형변환

        ArrayList<StarUnit> starList = new ArrayList<>();

        starList.add(zealot);
        starList.add(zealot2);
        starList.add(zealot3);
        starList.add(highTemplar);

        for (int i = 0; i < starList.size(); i++) {
            starList.get(i).move(200, 300);
        }

        //마린의 attack에도 다형성 적용
        marine.attack(zealot);
        marine.attack(highTemplar);

        System.out.println(zealot);
        System.out.println(highTemplar);

        //.get(3)을 하면 StarUnit 타입이므로 자식 객체의 메소드 사용 불가
//        starList.get(3).psionicStorm;

        // HighTemplar -> StarUnit을 다시
        // StarUnit -> HighTemplar으로 되돌려 준 후 메소드 사용 가능
        ((HighTemplar) starList.get(3)).psionicStorm();

        starList.add(marine);

        // 리스트 내 StarUnit이 원래 어떤 객체 였는지 체크하기
        for (int i = 0; i < starList.size(); i++) {
            if (starList.get(i).getName().equals("하이템플러")) {
                ((HighTemplar) starList.get(i)).psionicStorm();
            }

            // 객체 instanceof 클래스
            // 좌측의 객체가 우측에 놓인 클래스로 형변환이 가능하다면
            // true, 불가능시 false 리턴
            if (starList.get(i) instanceof HighTemplar) {
                ((HighTemplar) starList.get(i)).psionicStorm();
            }
            //instanceof를 사용하여 스팀팩을 사용하도록 작성

            if (starList.get(i) instanceof Marine) {
                ((Marine) starList.get(i)).stimpack();
            }
        }

        //부모 객체 생성
        StarUnit star = new StarUnit();
        // 일반적으로 부모 객체[는 자식 클래스로 형변환할 수 없다
        System.out.println(star instanceof Zealot);
        System.out.println(star instanceof HighTemplar);

        System.out.println(marine instanceof StarUnit);
        System.out.println(zealot instanceof StarUnit);

        // 부모 클래스로 형변환 되었던 자식 객체는
        // ektl 자식 객체로 형변환이 가능하다.

        StarUnit temp = zealot2 ;
        System.out.println(temp instanceof Marine);


        System.out.println(temp);




    }
}
