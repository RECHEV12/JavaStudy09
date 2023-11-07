package ch16_network.open_api.getData;


import ch16_network.open_api.dto.MedicineDTO;
import ch16_network.open_api.service.MedicineService;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class DataParsing {
    public static void main(String[] args) throws IOException, ParseException {
        MedicineService medicineService = MedicineService.getInstance();



        String path = System.getProperty("user.dir");

        FileReader reader = new FileReader(path + "/src/files/mediData.txt");

        char[] bowl = new char[1];

        StringBuilder sb = new StringBuilder();

        while (true){
            int cnt = reader.read(bowl);

            if (cnt == -1){
                break;
            }

            String text = new String(bowl);
            sb.append(text);

        }
        System.out.println(sb);

        JSONParser jsonParser = new JSONParser();

        JSONObject body = (JSONObject)jsonParser.parse(sb.toString());

        System.out.println(body);

        JSONArray items = (JSONArray)body.get("items");

        System.out.println(items.size());

        for (int i = 0 ; i <items.size(); i ++){
            JSONObject item = (JSONObject)items.get(i);

            String itemName = (String)item.get("itemName");
            String entpName = (String)item.get("entpName");
            String efctQesItm = (String)item.get("efcyQesitm");

            MedicineDTO medicine = new MedicineDTO(itemName, entpName, efctQesItm);

            medicineService.insertMedicine(medicine);

        }







    }
}
