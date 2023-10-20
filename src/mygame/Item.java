package mygame;

import java.util.ArrayList;

import static mygame.UtillMethod.random5perInt;

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
    public Item(Item item) {
        this.itemName = item.getItemName();
        this.itemType = item.getItemType();
        this.plusSTR = item.getPlusSTR();
        this.plusDEX = item.getPlusDEX();
        this.plusINT = item.getPlusINT();
        this.plusLUK = item.getPlusLUK();
        this.plusNowHP = item.getPlusNowHP();
        this.plusMaxHP = item.getPlusMaxHP();
        this.plusNowMP = item.getPlusNowMP();
        this.plusMaxMP = item.getPlusMaxMP();
        this.itemDetail = item.getItemDetail();
        this.isNowEq = item.isNowEq;
        this.dropMob = item.getDropMob();
    }
    public static void showShop(ShopDB shop, int inputNum) {

        ArrayList<Item> shoplist = shop.getShopList();
        if (inputNum == 1) {
            for (Item item : shoplist) {
                if (item.getItemType().contains("무기")) {
                    returnItemOne(item, shoplist.indexOf(item));
                }

            }
        } else if (inputNum == 2) {
            for (Item item : shoplist) {
                if (item.getItemType().contains("방어구")) {
                    returnItemOne(item, shoplist.indexOf(item));
                }
            }
        } else if (inputNum == 3) {
            for (Item item : shoplist) {

                if (item.getItemType().contains("포션")) {
                    returnItemOne(item, shoplist.indexOf(item));
                }
            }
        }
    }


    public static Item dropItem(Monster a) {
        ArrayList<Item> temp = new ArrayList<>();

        ItemDB itemDB = new ItemDB();
        CanUseItemDB canUseItemDB = new CanUseItemDB();
        Item tempItem = new Item();
        Item tempItem2 = new Item();

        for (Item it : itemDB.getItemList()) {
            if (it.getDropMob().equals(a.getMonsterName())) {
                tempItem = new Item(it);
                temp.add(tempItem);
            }
        }

        for (Item it :canUseItemDB.getCanItemList()) {
            if (it.getDropMob().equals(a.getMonsterName())) {
                tempItem = new Item(it);
                temp.add(tempItem);
            }
        }

        int b = random5perInt();
        if (b == 1) {
            int randomNum = UtillMethod.makeRandom(0, temp.size() - 1);
            tempItem2 = temp.get(randomNum);
        }
        return tempItem2;
    }


    public static void returnItemOne(Item item, int a) {

        String nowEq = "";

        if (item.isNowEq()) {
            nowEq = "장비중";
        } else {
            nowEq = "수납중/판매중";
        }
        System.out.println("╔═════════════════════════════════════════════════════════════════╗");
        System.out.println("아이템 번호 : " + (a+1));
        System.out.println("이름 : " + item.getItemName());
        System.out.println("분류 : " + item.getItemType());
        System.out.println("아이템 설명 : " + item.getItemDetail());
        System.out.println("\uD83D\uDCAA STR : " + item.getPlusSTR() + "\uD83C\uDFAF DEX : " + item.getPlusDEX());
        System.out.println("\uD83C\uDF93 INT : " + item.getPlusINT() + "\uD83C\uDFB2 LUK : " + item.getPlusLUK());
        System.out.println("❤\uFE0F 현재체력 : " + item.getPlusNowHP() + "❤\uFE0F 최대체력 : " + item.getPlusMaxHP());
        System.out.println("\uD83D\uDCA0 현재마나 : " + item.getPlusNowMP() + "\uD83D\uDCA0 최대마나 : " + item.getPlusMaxMP());
        System.out.println("현재 장비 상태 : " + nowEq);
        System.out.println("획득처 : " + item.getDropMob());
        System.out.println("가격 : " + item.getPrice());
        System.out.println("╚═════════════════════════════════════════════════════════════════╝");
    }


    public static void returnItemOneName(Item item, int a) {

        String nowEq = "";

        if (item.isNowEq()) {
            nowEq = "장비중";
        } else {
            nowEq = "수납중/판매중";
        }
        System.out.println("╔═════════════════════════════════════════════════════════════════╗");
        System.out.println("아이템 번호 : " + (a + 1));
        System.out.println("이름 : " + item.getItemName());
        System.out.println("분류 : " + item.getItemType());
        System.out.println("현재 장비 상태 : " + nowEq);
        System.out.println("가격 : " + item.getPrice());
        System.out.println("╚═════════════════════════════════════════════════════════════════╝");
    }

    public static void returnItemAllName(ArrayList<Item> list) {
        for (int i = 0; i < list.size(); i++) {
            Item temp = list.get(i);
            String nowEq = "";


            if (temp.isNowEq()) {
                nowEq = "장비중";
            } else {
                nowEq = "수납중/판매중";
            }
            System.out.println("╔═════════════════════════════════════════════════════════════════╗");
            System.out.println("아이템 번호 : " + (i +1));
            System.out.println("이름 : " + temp.getItemName());
            System.out.println("분류 : " + temp.getItemType());
            System.out.println("현재 장비 상태 : " + nowEq);
            System.out.println("가격 : " + temp.getPrice());
            System.out.println("╚═════════════════════════════════════════════════════════════════╝");
        }
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
