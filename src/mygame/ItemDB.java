package mygame;

import java.util.ArrayList;

public class ItemDB {


    public ArrayList<Item> itemList = new ArrayList<>(); /*아이템 목록*/



    public ItemDB() {
        ArrayList<Item> itemDB = Class.getWarrior().getItemsList();
        itemList.add(new Item("혈랑검", "무기", 0, 3, 3, 100, 3, 3,3 ,3, "피에 굶주린 늑대의 뼈로 만든 검, 고블린이 드랍한다.",false, "고블린", 1000 ));
        itemList.add(new Item("가죽조끼", "방어구", 3, 3, 3, 100, 3, 3,3 ,3, "피에 굶주린 늑대의 뼈로 만든 검, 고블린이 드랍한다.",false, "고블린" , 1000));
        itemList.add(new Item("죽검", "무기", 100, 3, 3, 100, 3, 3,3 ,3, "피에 굶주린 늑대의 뼈로 만든 검, 고블린이 드랍한다.",false, "고블린" , 1000));
        itemList.add(new Item("11혈랑검", "무기", 3, 3, 3, 100, 3, 3,3 ,3, "피에 굶주린 늑대의 뼈로 만든 검, 고블린이 드랍한다.",false, "고블린" , 1000));
        itemList.add(new Item("사과", "포션", 0, 0, 0, 100, 0, 3,3 ,3, "피에 굶주린 늑대의 뼈로 만든 검, 고블린이 드랍한다.",false, "슬라임", 1000 ));
        itemList.add(new Item("딸기", "포션", 3, 3, 3, 100, 3, 3,3 ,3, "피에 굶주린 늑대의 뼈로 만든 검, 고블린이 드랍한다.",false, "슬라임", 1000));
       itemList.add(new Item("방어구인데요", "방어구", 3, 3, 3, 100, 3, 3,3 ,3, "피에 굶주린 늑대의 뼈로 만든 검, 고블린이 드랍한다.",false, "슬라임", 1000 ));

    }

    @Override
    public String toString() {
        return "ItemDB{" +
                "itemList=" + itemList +
                '}';
    }

    public ArrayList<Item> getItemList() {
        return itemList;
    }

    public void setItemList(ArrayList<Item> itemList) {
        this.itemList = itemList;
    }
}
