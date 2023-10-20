package mygame;

import java.util.ArrayList;

public class ShopDB {
    ArrayList<Item> shopList = new ArrayList<>();

    public ShopDB() {
        shopList.add(new Item("몽둥이", "무기", 3, 3, 3, 0, 0, 0, 0, 0, "고블린이 들고다니던 몽둥이. 고블린이 드랍한다.", false, "고블린", 1000));
        shopList.add(new Item("끈적한 옷", "방어구", 1, 2, 0, 0, 3, 3, 3, 3, "슬라임의 점성으로 만든 끈적한 옷, 슬라임이 드랍한다.", false, "슬라임", 1000));


        shopList.add(new Item("사과", "포션", 0, 0, 0, 0, 10, 0, 5, 0, "맛있어보이는 사과이다.", false, "슬라임, 고블린, 대왕슬라임, 홉고블린, 산성슬라임, 킹고블린", 300));
        shopList.add(new Item("맛있는 사과", "포션", 0, 0, 0, 0, 20, 0, 10, 0, "더 더  맛있어보이는 사과이다.", false, "흑랑, 세이렌, 거대 골렘", 700));
        shopList.add(new Item("골드 애플", "포션", 0, 0, 0, 0, 30, 0, 20, 0, "더 더  맛있어보이는 사과이다.", false, "오우거, 타천사, 마인", 1500));
        shopList.add(new Item("딸기", "포션", 0, 0, 0, 0, 5, 0, 10, 0, "맛있어보이는 딸기이다.", false, "슬라임, 고블린, 대왕슬라임, 홉고블린, 산성슬라임, 킹고블린", 300));
        shopList.add(new Item("맛있는 딸기", "포션", 0, 0, 0, 0, 10, 0, 20, 0, "더 맛있어보이는 딸기이다.", false, "흑랑, 세이렌, 거대 골렘", 700));
        shopList.add(new Item("골드 스트로베리", "포션", 0, 0, 0, 0, 20, 0, 30, 0, "더 더 맛있어보이는 딸기이다.", false, "오우거, 타천사, 마인", 1500));



    }

    @Override
    public String toString() {
        return shopList + "";
    }

    public ArrayList<Item> getShopList() {
        return shopList;
    }

    public void setShopList(ArrayList<Item> shopList) {
        this.shopList = shopList;
    }
}
