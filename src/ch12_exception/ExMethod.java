package ch12_exception;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExMethod {

    // 날짜 문자열을 입력하면 밀리초로 바꿔서 리턴
    // yyyy.MM.dd로 들어와야 함
    public static long dateToMillSec(String date) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
        // 패턴과 다른 형태의 문자열이 파라미터로 들어오면 ParseException 발생
        // try-catch는 에러상황 적절히 처리
        // 해당 에러에 대한 처리를 여기서 할거면 try-catch 사용
        // 해당 에러에 대한 처리를 여기서 안 할거면 throws를 사용
        // -> 이후 dateToMillSec를 사용 하는 곳에서 try-cat 사용


        Date result = sdf.parse(date);
        return result.getTime();

    }


    // 파라미터로 0이 들어오면 가위 리턴
    // 파라미터로 1이 들어오면 바위 리턴
    // 파라미터로 2이 들어오면 보 리턴

    public static String game(int num) throws Exception {
        if (num == 0) {
            return "가위";
        } else if (num == 1) {

            return "바위";
        } else if (num == 2) {
            return "보";

        } else {
            // 에러 발생시키기
            // Exception을 상속받는 예외 클래스 객체를 생성하면서 던진다.
            throw new Exception("0~2중 하나의 숫자를 입력 해주세요");
        }
    }

    // 입력받은 이름을 콘솔창에 출력
    // 파라미터로 들어온 문자열이 숫자이거나, empty면 안됨
    public static void printName(String name) throws  BizException{
        if (name.isEmpty()) {
            throw new BizException(ExCode.API_001, "빈문자열은 안됩니다.");
        } else if (name.matches("^[0-9]+$")) {
            throw new BizException(ExCode.API_002, "숫자는 안됩니다.");
        } else {
            System.out.println(name);
        }
    }
}
