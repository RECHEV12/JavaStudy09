package ch10_extends_interface.lol;



// 인터페이스는 imploments
public class Yasuo implements Skill {
    private String name;
    private int damage;
    private int hp;







    @Override
    public void skillQ() {
        System.out.println("칼로 찌르기");
    }

    @Override
    public void skillW() {
        System.out.println("바람의 장막");
    }

    @Override
    public void skillE() {
        System.out.println("돌진");
    }

    @Override
    public void skillR() {
        System.out.println("난도질");

    }
}
