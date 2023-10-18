package mygame;

import java.util.ArrayList;

public class Item {
    private String itemName; /*아이템 이름*/
    private String itemType; /*아이템 타입*/
    private int plusSTR; /*STR 부여*/

    private int plusDEX; /*DEX 부여*/
    private int plusINT; /*INT 부여*/
    private int plusLUK; /*LUK 부여*/
    private int plusNowHP; /*HP 부여*/
    private int plusMaxHP; /*HP 부여*/
    private int plusNowMP; /*MP 부여*/
    private int plusMaxMP; /*MP 부여*/
    private String itemDetail; /*상세 설명*/
    private boolean isNowEq; /*현재 장비중인가*/
    private String dropMob; /*누가 드랍하는지*/
    private int price; /*아이템 가격*/

    public Item(String itemName,
                String itemType,
                int plusSTR,
                int plusDEX,
                int plusINT,
                int plusLUK,
                int plusNowHP,
                int plusMaxHP,
                int plusNowMP,
                int plusMaxMP,
                String itemDetail,
                boolean isNowEq,
                String dropMob,
                int price) {
        this.itemName = itemName;
        this.itemType = itemType;
        this.plusSTR = plusSTR;
        this.plusDEX = plusDEX;
        this.plusINT = plusINT;
        this.plusLUK = plusLUK;
        this.plusNowHP = plusNowHP;
        this.plusMaxHP = plusMaxHP;
        this.plusNowMP = plusNowMP;
        this.plusMaxMP = plusMaxMP;
        this.itemDetail = itemDetail;
        this.isNowEq = isNowEq;
        this.dropMob = dropMob;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Item{" +
                "itemName='" + itemName + '\'' +
                ", itemType='" + itemType + '\'' +
                ", plusSTR=" + plusSTR +
                ", plusDEX=" + plusDEX +
                ", plusINT=" + plusINT +
                ", plusLUK=" + plusLUK +
                ", plusNowHP=" + plusNowHP +
                ", plusMaxHP=" + plusMaxHP +
                ", plusNowMP=" + plusNowMP +
                ", plusMaxMP=" + plusMaxMP +
                ", itemDetail='" + itemDetail + '\'' +
                ", isNowEq=" + isNowEq +
                ", dropMob='" + dropMob + '\'' +
                ", price=" + price +
                '}';
    }


    public Item(String itemName,
                String itemType,
                int plusSTR,
                int plusDEX,
                int plusINT,
                int plusLUK,
                int plusNowHP,
                int plusMaxHP,
                int plusNowMP,
                int plusMaxMP,
                String itemDetail,
                boolean isNowEq,
                String dropMob) {
        this.itemName = itemName;
        this.itemType = itemType;
        this.plusSTR = plusSTR;
        this.plusDEX = plusDEX;
        this.plusINT = plusINT;
        this.plusLUK = plusLUK;
        this.plusNowHP = plusNowHP;
        this.plusMaxHP = plusMaxHP;
        this.plusNowMP = plusNowMP;
        this.plusMaxMP = plusMaxMP;
        this.itemDetail = itemDetail;
        this.isNowEq = isNowEq;
        this.dropMob = dropMob;
    }

    public static Item dropItem(Monster a){
        ArrayList<Item> temp = new ArrayList<>();
        ItemDB itemDB = new ItemDB();
        Item tempItem = new Item();

        for (Item it : itemDB.getItemList()){
            if (it.getDropMob().contains(a.getMonsterName())){
                temp.add(it);
            }
        }
        double randNum = UtillMethod.random5per();

        if (randNum == 1){
            int randomNum =UtillMethod.makeRandom(0, temp.size()-1);
            tempItem = temp.get(randomNum);

        }
        return tempItem;
    }


    public Item() {
    }


    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public int getPlusSTR() {
        return plusSTR;
    }

    public void setPlusSTR(int plusSTR) {
        this.plusSTR = plusSTR;
    }

    public int getPlusDEX() {
        return plusDEX;
    }

    public void setPlusDEX(int plusDEX) {
        this.plusDEX = plusDEX;
    }

    public int getPlusINT() {
        return plusINT;
    }

    public void setPlusINT(int plusINT) {
        this.plusINT = plusINT;
    }

    public int getPlusLUK() {
        return plusLUK;
    }

    public void setPlusLUK(int plusLUK) {
        this.plusLUK = plusLUK;
    }

    public int getPlusNowHP() {
        return plusNowHP;
    }

    public void setPlusNowHP(int plusNowHP) {
        this.plusNowHP = plusNowHP;
    }
    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
    public int getPlusMaxHP() {
        return plusMaxHP;
    }

    public void setPlusMaxHP(int plusMaxHP) {
        this.plusMaxHP = plusMaxHP;
    }

    public int getPlusNowMP() {
        return plusNowMP;
    }

    public void setPlusNowMP(int plusNowMP) {
        this.plusNowMP = plusNowMP;
    }

    public int getPlusMaxMP() {
        return plusMaxMP;
    }

    public void setPlusMaxMP(int plusMaxMP) {
        this.plusMaxMP = plusMaxMP;
    }

    public String getItemDetail() {
        return itemDetail;
    }

    public void setItemDetail(String itemDetail) {
        this.itemDetail = itemDetail;
    }

    public boolean isNowEq() {
        return isNowEq;
    }

    public void setNowEq(boolean nowEq) {
        isNowEq = nowEq;
    }

    public String getDropMob() {
        return dropMob;
    }

    public void setDropMob(String dropMob) {
        this.dropMob = dropMob;
    }
}