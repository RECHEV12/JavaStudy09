package mygame;

import java.util.ArrayList;

public class CanUseItemDB {

    public ArrayList<Item> canItemList = new ArrayList<>(); /*사용아이템 목록*/

    public ArrayList<Item> getCanItemList() {
        return canItemList;
    }

    public void setCanItemList(ArrayList<Item> canItemList) {
        this.canItemList = canItemList;
    }

    @Override
    public String toString() {
        return "CanUseItemDB{" +
                "canItemList=" + canItemList +
                '}';
    }

    public CanUseItemDB() {
        canItemList.add(new Item("사과", "포션", 0, 0, 0, 0, 10, 0, 5, 0, "맛있어보이는 사과이다.", false, "슬라임, 고블린, 대왕슬라임, 홉고블린, 산성슬라임, 킹고블린", 200));
        canItemList.add(new Item("맛있는 사과", "포션", 0, 0, 0, 0, 20, 0, 10, 0, "더 더  맛있어보이는 사과이다.", false, "흑랑, 세이렌, 거대 골렘", 500));
        canItemList.add(new Item("골드 애플", "포션", 0, 0, 0, 0, 30, 0, 20, 0, "더 더  맛있어보이는 사과이다.", false, "오우거, 타천사, 마인", 1000));
        canItemList.add(new Item("선악과", "포션", 0, 0, 0, 0, 40, 0, 30, 0, "더 더  맛있어보이는 사과이다.", false, "드래곤", 2000));
        canItemList.add(new Item("딸기", "포션", 0, 0, 0, 0, 5, 0, 10, 0, "맛있어보이는 딸기이다.", false, "슬라임, 고블린, 대왕슬라임, 홉고블린, 산성슬라임, 킹고블린", 200));
        canItemList.add(new Item("맛있는 딸기", "포션", 0, 0, 0, 0, 10, 0, 20, 0, "더 맛있어보이는 딸기이다.", false, "흑랑, 세이렌, 거대 골렘", 500));
        canItemList.add(new Item("골드 스트로베리", "포션", 0, 0, 0, 0, 20, 0, 30, 0, "더 더 맛있어보이는 딸기이다.", false, "오우거, 타천사, 마인", 1000));
        canItemList.add(new Item("마나 엘릭서", "포션", 0, 0, 0, 0, 30, 0, 40, 0, "마나를 대량으로 회복시켜주는 포션이다", false, "드래곤", 2000));
    }

    public CanUseItemDB(ArrayList<Item> canItemList) {
        this.canItemList = canItemList;
    }
}
