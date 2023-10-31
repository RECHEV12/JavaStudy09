package dongwoo.total;

import java.text.SimpleDateFormat;
import java.util.Date;

public class q02 {
    public static void main(String[] args) {
        String uniqueId = makeUniqueId();
        System.out.println(uniqueId);
    }


    public static String makeUniqueId() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyMMddHHmmssSSS");
        Date nowDate = new Date();
        StringBuffer nowTime = new StringBuffer();
        nowTime.append(sdf.format(nowDate));
        for (int i = 0; i < 6; i++) {
            int randNum = (int) ((Math.random() * 9) + 1);
            nowTime.append(randNum);
        }
        return nowTime.toString();
    }


}

