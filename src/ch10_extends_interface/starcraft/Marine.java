package ch10_extends_interface.starcraft;

public class Marine extends StarUnit {



    public Marine() {
        super("마린", 6, 50, 0, 4, 1, 1, 50);
    }


    // 공격
    public void attack(StarUnit starunit){
        // 질럿의 체력이 마린의 공격력 만큼 감소
        starunit.setHp(starunit.getHp() - this.getDamage());
    }
    public void attack(HighTemplar highTemplar){
        // 질럿의 체력이 마린의 공격력 만큼 감소
        // 부모 필드에 private인 변수나 메소드는 자식 객체에서 사용 불가.
        highTemplar.setHp(highTemplar.getHp() - super.getDamage());
    }

    //스팀팩 메소드
public void  stimpack(){
    System.out.println("으아아아!!");
    //스팀팩 사용 시 체력 10 감소 공격속도 두배
    this.setHp(this.getHp() - 10);
    this.setAttackSpeed(this.getAttackSpeed() * 2 );

}





    @Override
    public String toString() {
        return "Marine{" +
                "name='" + this.getName() + '\'' +
                ", damage=" + getDamage() +
                ", hp=" + super.getHp() +
                ", armor=" + getArmor() +
                ", attackRange=" + getAttackRange() +
                ", attackSpeed=" + getAttackSpeed() +
                ", moveSpeed=" + getMoveSpeed() +
                ", mineral=" + getMineral() +
                '}';
    }


}
