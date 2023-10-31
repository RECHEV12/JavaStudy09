package dongwoo.submit11.q02;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

public class DateBoardMain  {
    public static void main(String[] args) throws ParseException  {
        // dbList에 랜덤 날짜를 가지는 DateBoard 객체 100개 삽입
        ArrayList<DateBoard> dbList = new ArrayList<DateBoard>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");

        for(int i = 0; i < 100; i++) {
            int randDay = (int)(Math.random() * 365) + 1;		// 1~365
            Calendar cal = Calendar.getInstance(); // 오늘날짜
            cal.add(Calendar.DATE, randDay * -1); // 오늘날짜에서 1~365 중 랜덤한 일수를 뺀다.
            String strDate = sdf.format(cal.getTime());
            dbList.add(new DateBoard((i+1) + "번째 생성된 글", strDate));
        }
        System.out.println("\n======최신순=====================================================================\n");
        System.out.println("날짜별로 정렬 후 출력(최신순)");
        //최신순
        for(int t = 0; t < dbList.size() -1 ; t++) {
            for(int i = 0; i < dbList.size() -1 ; i++) {

                Date date1 = sdf.parse(dbList.get(i).getDate());
                Date date2 = sdf.parse(dbList.get(i+1).getDate());

                if (date1.getTime() < date2.getTime()){
                    DateBoard temp =  dbList.get(i);
                    dbList.set(i, dbList.get(i+1));
                    dbList.set(i+1, temp);
                }
            }
        }

        for(int i = 0; i < dbList.size(); i++) {
            System.out.println(dbList.get(i));
        }

        System.out.println("\n==========오래된 순=================================================================\n");
        System.out.println("날짜별로 정렬 후 출력(오래된 순)");

        //오래된 순
        for(int t = 0; t < dbList.size() -1 ; t++) {
            for(int i = 0; i < dbList.size() -1 ; i++) {

                Date date1 = sdf.parse(dbList.get(i).getDate());
                Date date2 = sdf.parse(dbList.get(i+1).getDate());

                if (date1.getTime() > date2.getTime()){
                    DateBoard temp =  dbList.get(i);
                    dbList.set(i, dbList.get(i+1));
                    dbList.set(i+1, temp);
                }
            }
        }

        for(int i = 0; i < dbList.size(); i++) {
            System.out.println(dbList.get(i));
        }

        System.out.println("\n============최근 한달 내===============================================================\n");
        System.out.println("최근 한달 내 작성된 게시글");
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy.MM.dd");

        Date nowDateA = new Date();
        String nowA = sdf2.format(nowDateA);
        Date A = sdf2.parse(nowA);

        for (int i = 0 ; i < dbList.size() ; i++){
            long diff = 1000 * 60 * 60 * 24;

            Date dbDate = sdf2.parse(dbList.get(i).getDate());

            int diffDate = (int)((A.getTime()-dbDate.getTime())/diff);

            if (diffDate <= 30){
                System.out.println(dbList.get(i));
            }
        }

        System.out.println("\n============이번 달===============================================================\n");
        System.out.println("이번달 작성된 게시글");
        Calendar cal = Calendar.getInstance();
        int thisMonth = cal.get(Calendar.MONTH) + 1;


        for (int i = 0 ; i < dbList.size() ; i++){
            Date thisDate = sdf.parse(dbList.get(i).getDate());
            Calendar calA = Calendar.getInstance();
            calA.setTime(thisDate);
            int dbMonth = calA.get(Calendar.MONTH) + 1;

            if (thisMonth == dbMonth){
                System.out.println(dbList.get(i));
            }
        }

        System.out.println("\n============6월===============================================================\n");
        System.out.println("6월에 작성된 게시글");

        for (int i = 0 ; i < dbList.size() ; i++){
            Date thisDate = sdf.parse(dbList.get(i).getDate());
            Calendar calA = Calendar.getInstance();
            calA.setTime(thisDate);
            int dbMonth = calA.get(Calendar.MONTH) + 1;

            if (6== dbMonth){
                System.out.println(dbList.get(i));
            }
        }

        System.out.println("\n============2023년 7월 14일부터 2023년 8월 21일==================================================\n");

        System.out.println("2023.07.14 ~ 2023.08.21 게시글");

        String setDate1 = "2023.07.14";
        String setDate2 = "2023.08.22"; // 22의 롱타입 숫자에서 -1을 한다

        Date setDay1 = sdf2.parse(setDate1);
        Date setDay2 = sdf2.parse(setDate2);

        long day1 = setDay1.getTime();
        long day2 = setDay2.getTime() - 1;

        for (int i = 0 ; i < dbList.size() ; i++){
             long dbTime = sdf.parse(dbList.get(i).getDate()).getTime();

            if (dbTime >= day1 && dbTime <= day2){
                System.out.println(dbList.get(i));
            }
        }








    }

}
