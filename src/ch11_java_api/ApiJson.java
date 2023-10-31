package ch11_java_api;

import ch09_class.school.Student;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.ArrayList;
import java.util.Arrays;

public class ApiJson {
    public static void main(String[] args) throws ParseException {
        // JSON 객체
        // JavaScript Object Notaion
        // 자바 스크립트 객체

        // 자바에서의 객체
        // Student -> name, kor, eng, math, avg
        //Student hodong =  new Student("호동이", 90, 80, 70, 80)
        //Student horang =  new Student("호랑이", 90, 80, 70, 80)
        //Student hodol =  new Student("호돌이", 90, 80, 70, 80)

        // JSON이라면
        // let hodong = { name : "호동이", kor : 90, eng : 80, math : 70, avg : 80}
        // let horang = { name : "호랑이", kor : 90, eng : 80, math : 70, avg : 80}
        // let hodol = { name : "호돌이", kor : 90, eng : 80, math : 70, avg : 80}


        // 자바라면
        // hodong.getName(); , hodong.name -> 호동이

        // 자바스크립트라면
        // hodong.name -> 호동이

        // 클라이언트와 서버간 데이터 통신

        // 자바에서 JSON 객체를 생성하고, JSON String으로 변환하기 -> 서버에 요청 가능
        // 자바에서 JSON String을 JSON 객체로 변환하기 -> 응답 데이터 사용 가능

        // 위 2가지 행동을 가능하게 하는 라이브러리를 가지고 와야 한다.
        //maven repository에서 json simple 검색 .jar파일 다운로드

        // .jar파일을 프로젝트 내부에서 불러올 수 있도록 설정
        // Menu - Project Structure - Libraries 에서 추가
        JSONObject jsonObject = new JSONObject();
        System.out.println(jsonObject);
        // JSON객체는 내부에 key와 value를 쌍으로 구성된 데이터를 가진다.
        // HashMap<String, Object>와 유사하다.

        //데이터 추가
        jsonObject.put("name", "아이유");
        System.out.println(jsonObject);

        jsonObject.put("age", 30);
        System.out.println(jsonObject);

        // 데이터 수정

        jsonObject.put("age", 31);
        System.out.println(jsonObject);

        // value 값에 배열 넣기
        // ArrayList와 사용법이 같음
        JSONArray jsonArray = new JSONArray();
        System.out.println(jsonArray);

        jsonArray.add("좋은날");
        jsonArray.add("블루밍");
        jsonArray.add("레옹");
        jsonArray.add(1); // 타입에 자유롭다

        System.out.println(jsonArray);

        jsonObject.put("song", jsonArray);
        System.out.println(jsonObject);

        System.out.println(jsonObject.toJSONString());
        System.out.println(jsonObject.toString());

        // value에 JSON 객체 추가

        JSONObject taeyeon = new JSONObject();

        taeyeon.put("name", "태연");
        taeyeon.put("age", 34);

        JSONArray taeyoenSong = new JSONArray();
        taeyoenSong.add("만약에");
        taeyoenSong.add("INVU");
        taeyoenSong.add("사계");

        taeyeon.put("songs", taeyoenSong);

        jsonObject.put("태연", taeyeon);

        System.out.println(jsonObject);

        //key를 이용해서 value값 꺼내보기
        System.out.println(jsonObject.get("name"));
        // .get으로 꺼낼 시 Object타입 리턴
        String name = (String) jsonObject.get("name");
        System.out.println(name);

        int age = (int) jsonObject.get("age");
        System.out.println(age);

        JSONArray iuSong = (JSONArray) jsonObject.get("song");
        System.out.println(iuSong);

        for (int i = 0; i < iuSong.size(); i++) {
            System.out.println(iuSong.get(i));
        }

        JSONObject ty = (JSONObject) jsonObject.get("태연");
        String tyName = (String) ty.get("name");
        System.out.println(tyName);


        System.out.println("\n===========================\n");

        // 서버로부터 JSON String을 받았다면
        String serverResponse = "{\"song\":[\"좋은날\",\"블루밍\",\"레옹\",1],\"name\":\"아이유\",\"age\":31,\"태연\":{\"songs\":[\"만약에\",\"INVU\",\"사계\"],\"name\":\"태연\",\"age\":34}}\n";

        System.out.println(serverResponse);

        // String을 JSON 객체로 변환해야 key갑에 대한 value를 얻을 수 있다.
        // String -> JSON을 위해 JSONParser 객체 생성
        JSONParser jsonParser = new JSONParser();
        JSONObject jsonResponse = (JSONObject) jsonParser.parse(serverResponse);

        System.out.println(jsonResponse);

        //key를 이용해서 value값 꺼내보기
        JSONObject tyResp = (JSONObject) jsonResponse.get("태연");

        // 태연 노래 꺼내기
        JSONArray tySongs = (JSONArray) tyResp.get("songs");

        for (int i = 0; i < tySongs.size(); i++) {
            if (tySongs.get(i).equals("INVU")) {
                System.out.println(tySongs.get(i));
            }
        }

        System.out.println("\n===========================\n");

        // GSON 라이브러리 사용

        // JsonObject 객체 생성
        JsonObject gsonObj = new JsonObject();
        System.out.println(gsonObj);

        // 값 추가
        gsonObj.addProperty("name", "아이유");
        gsonObj.addProperty("age", 31);
        System.out.println(gsonObj);

        // JsonObject -> String 변환
        String gsonStr = gsonObj.toString();
        System.out.println(gsonStr);

        //GSON 객체 생성
        Gson gson = new Gson();

        //GsonBuilder로 Gson 객체 생성
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson2 = gsonBuilder.create();

        // 몇몇 설정을 추가한 상태로 Gson객체를 만들 수도 있다
        Gson gsonPretty = gsonBuilder.setPrettyPrinting().create();

        // Gson 객체를 이용한 toString
        String gStr = gson.toJson(gsonObj);
        System.out.println(gStr);
        String pStr = gsonPretty.toJson(gsonObj);
        System.out.println(pStr);
        System.out.println(gsonPretty.toJson(jsonObject));

        // 여기까지는 JSON Simple 라이브러리와 별 차이 없음
        Student stu = new Student("호빵맨", 98, 67 ,32);

        // 자바 객체를 Json String으로 변환
        // = 직렬화(Serializaiton)

        String stuStr = gson.toJson(stu);
        System.out.println(stuStr);

        // 배열을 Json String으로 변환
        String[] stuArray = {"호빵맨", "찐빵맨", "식빵맨"};
        String strArr = gson.toJson(stuArray);
        System.out.println(strArr);


        // 리스트를 Json String으로 변환
        ArrayList<String> stuList = new ArrayList<>(Arrays.asList("호빵","찐빵", "식빵"));
        String listStr = gson.toJson(stuList);
        System.out.println(listStr);

        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("호빵맨", 98, 67 ,32));
        students.add(new Student("찐빵맨", 10,40,40));
        students.add(new Student("식빵맨", 66,32,89));

        String strStu = gson.toJson(students);
        System.out.println(strStu);

        // Json String인 stuStr -> Students 객체로 가능
        // 역직렬화(Deseiralization)
        // 이와같은 역직렬화를 위해 스프링 프레임워크에서 jackson 라이브러리를 이용하는 경우도 많다.
        Student comeback = gson.fromJson(stuStr, Student.class );

        System.out.println(comeback);




    }
}
