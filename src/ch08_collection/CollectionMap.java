package ch08_collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class CollectionMap {
    public static void main(String[] args) {
        // Map -> HashMap 선언
        // Map은 값을 key와  value값을 한쌍으로 저장한다는 특징이 있다.
        HashMap<String, String> stuMap = new HashMap<String, String>();
        HashMap<String, String> stuMap2 = new HashMap<>();

        // 대부분의 경우는 key이 string이다
        HashMap<String, Integer> coinMap = new HashMap<>();

        //값추가 .put(key, value)
        stuMap.put("첫째는", "태곤");
        stuMap.put("둘째는", "창연");
        stuMap.put("셋째는", "성복");
        //순서 보장 안됨
        System.out.println(stuMap);
        //중복 키값 허용 안함

        stuMap.put("첫째는", "민재"); // 기존 값에 덮어 씌워짐
        stuMap.put("넷째는", "성복");
        System.out.println(stuMap);


        coinMap.put("비트코인", 36000000);
        coinMap.put("도지코인", 78);
        System.out.println(coinMap);

        //.get(key) 밸류값 리턴
        System.out.println(stuMap.get("첫째는"));


        System.out.println(stuMap.get("첫째"));// 존재하지 않는 키값은 null값 리턴


        System.out.println(coinMap.get("비트코인"));

        //.size() Map내부 요소 개수 리턴
        System.out.println(stuMap.size());

        //.containskey(값)
        //Map내부 요소 중에 괄호안 값에 해당하는 key 값이 존재하면 T/F
        System.out.println(stuMap.containsKey("둘째는"));
        System.out.println(stuMap.get("둘째는") != null);

        //.containsValue(값)
        //Map 내부 요소 중에 괄호 안 값과 같은  value가 존재하면 TF
        System.out.println(stuMap.containsValue("성복"));

        //.remove(key)
        //해당 key 값을 가지는 내부 요소 삭제
        stuMap.remove("둘째는");
        System.out.println(stuMap);

        System.out.println("\n===========================\n");
        //Map 순회
        //. keyset 이용
        Set<String> keySet = stuMap.keySet();
        System.out.println(keySet);

        for ( String key   : keySet ){
            System.out.println(key);
            System.out.println(stuMap.get(key));
        }
        System.out.println("\n===========================\n");
        // 2. EntrySet 이용
        Set<Entry<String, String>> entrySet = stuMap.entrySet();

        for ( Entry<String, String> entry : entrySet ){
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }

    }
}
