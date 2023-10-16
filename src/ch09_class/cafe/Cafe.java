package ch09_class.cafe;

import java.util.ArrayList;

public class Cafe {
    private String name; /*카페명*/
    private ArrayList<Coffee> menu; /*음료 목록*/

    public Cafe(String name) {
        this.name = name;
        menu = new ArrayList<>();
    }

    // 메뉴판 출력
    public void printMenu(){
        for (int i = 0 ; i <menu.size() ; i++){
            System.out.println((i+1) + ". "+ menu.get(i));
        }
    }

    //메뉴 선택
    public void selectMenu(int select){
        String name = menu.get(select -1).getName();
        int price = menu.get(select -1).getPrice();
        System.out.println(name + "을(를) " + price + "원에 구입하였습니다.");
    }


    // 메뉴에 커피 객체 추가하는 메소드
    public void addCoffee (Coffee coffee){
        menu.add(coffee);
    }


















    public String getName() {
        return name;
    }

    public ArrayList<Coffee> getMenu() {
        return menu;
    }


}
