package dongwoo.submit09.q01;

import java.util.ArrayList;

public class ProductMain {
    public static void main(String[] args) {


        Product frige = new Product("냉장고", 2000000);
        Product tv = new Product("TV", 1000000);
        Product aircon = new Product("에어컨", 800000);
        Product com = new Product("컴퓨터", 1300000);
        Product fan = new Product("선풍기", 100000);

        ArrayList<Product> prodList = new ArrayList<>();
        prodList.add(frige);
        prodList.add(tv);
        prodList.add(aircon);
        prodList.add(com);
        prodList.add(fan);

        for (int t = 0 ; t < prodList.size() -1 ; t++){
            for (int i = 0 ; i < prodList.size() -1 ; i++){
                if (prodList.get(i).getPrice()>prodList.get(i + 1).getPrice()){
                    Product tmp = prodList.get(i);
                    prodList.set(i, prodList.get(i+1));
                    prodList.set(i+1, tmp);
                }
            }
        }
        for (int i = 0 ; i < prodList.size() ; i++){
            System.out.println(prodList.get(i));
        }
        System.out.println("\n===============\n");
        for (int i = 0 ; i < prodList.size() ; i ++){
            if (prodList.get(i).getName().equals("TV")){
                System.out.println(prodList.indexOf(prodList.get(i)));
            }
        }
    }
}
