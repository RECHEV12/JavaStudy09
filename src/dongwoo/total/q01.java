package dongwoo.total;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class q01 {
    public static void main(String[] args) throws ParseException {
        String response = "{ \"city\" : [\"서울\", \"광주\", \"대구\", \"대전\", \"부산\", \"울산\", \"인천\"], \"fields\": [{\"id\": \"자장면\"},{\"id\": \"냉면\"}, {\"id\": \"김밥\"}, {\"id\": \"칼국수\"}], \"records\": [{\"시도명\": \"서울\", \"자장면\": 7069, \"냉면\": 11308, \"김밥\": 3215, \"칼국수\": 8962}, {\"시도명\": \"광주\", \"자장면\": 6800, \"냉면\": 9400, \"김밥\": 3160, \"칼국수\": 8400}, {\"시도명\": \"대구\", \"자장면\": 6250, \"냉면\": 10417, \"김밥\": 2750, \"칼국수\": 6750}, { \"시도명\": \"대전\", \"자장면\": 6700, \"냉면\": 10400, \"김밥\": 3000, \"칼국수\": 7800}, {\"시도명\": \"부산\", \"자장면\": 6143, \"냉면\": 10857, \"김밥\": 2786, \"칼국수\": 6986}, { \"시도명\": \"울산\", \"자장면\": 6500, \"냉면\": 9900, \"김밥\": 3300, \"칼국수\": 8400}, {\"시도명\": \"인천\", \"자장면\": 6500, \"냉면\": 10667, \"김밥\": 3050, \"칼국수\": 8000}]}";


        JSONParser jsonParser = new JSONParser();
        JSONObject cityAll = (JSONObject) jsonParser.parse(response);
        JSONArray records = (JSONArray) cityAll.get("records");



        for (int i = 0; i < records.size() - 1; i++) {
            for (int k = 0; k < records.size() - 1; k++) {

                JSONObject tempA = (JSONObject) records.get(k);
                long priceA = (long) tempA.get("냉면");

                JSONObject tempB = (JSONObject) records.get(k + 1);
                long priceB = (long) tempB.get("냉면");

                if (priceA > priceB) {

                    JSONObject temp;
                    temp = tempA;

                    records.set(k, tempB);
                    records.set(k + 1, temp);

                }
            }
        }

        System.out.println(records);

        JSONObject lowPrice = (JSONObject) records.get(0);
        System.out.println(lowPrice.get("시도명") +  ", 냉면가격: " + lowPrice.get("냉면") + "원");

        long totalPrice = 0;

        for (int i = 0 ; i < records.size() ; i++){

            JSONObject jajang =(JSONObject) records.get(i);
            long jajangPrice = (long)jajang.get("자장면");

            totalPrice += jajangPrice;
        }

        long resultPrice = (totalPrice/ records.size());

        System.out.println("7개 도시 자장면 평균 가격: " + resultPrice + "원");





































    }

}
