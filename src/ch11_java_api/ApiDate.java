package ch11_java_api;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class ApiDate {
    public static void main(String[] args) throws ParseException {
        // API 란? 완성된, 만들어져 있는 코드를 사용하는 것
        // SDK 란? 프로그램 로직, 기술이 만들어져 있으나
        // 그냥 가져다 쓰기보다는 가지고 와서 추가적인 개발을
        // 해서 써야 하는 것

        // JDK 안에 만들어져 있는 API들 배우기

        // 현재 시간 구하기
        //1. Date 클래스 사용
        Date dateToday = new Date();

        // Date객체가 생성될 때 ( = new Date()실행)
        // 해당 객체 내부에 = new Date()가 실행되었을 때의 시간이 저장된다.

        // Tue Oct 24 10:26:49 KST 2023
        System.out.println(dateToday);

        // 날짜 포맷을 바꿔서
        // 2023-10-24 10:26:49 형태로 바꾸기
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        // sdf.format(Date 객체)는 Date 객체에 저장된 날짜를
        // 정해둔 날짜보다 포맷형식으로 변환한 문자열 리턴
        String today = sdf.format(dateToday);
        System.out.println(today);

        System.out.println("\n=======================\n");

        // 2. Calender 클래스 사용
        // .getInstance 실행시 새로운 객체가 생성된다.
        // 객체가 생성될 때의 시간이 저장된다.
        Calendar calToday = Calendar.getInstance();

        System.out.println(calToday);

        // Calendar 객체에서 Date 객체로 꺼내기
        Date calToDate = calToday.getTime();

        System.out.println(calToDate);
        System.out.println(sdf.format(calToDate));
        System.out.println(sdf.format(calToday.getTime()));

        System.out.println("\n=======================\n");

        // 3. System 클래스 사용
        // 현재 시간에 대해 밀리초단위로 리턴
        // 1970년 1월 1일 0시부터 현재까지 경과된 시간을 밀리초 단위로 리턴
        long longToday = System.currentTimeMillis();

        System.out.println(longToday);

        System.out.println(sdf.format(longToday));
        System.out.println(sdf.format(0L));

        System.out.println("\n=======================\n");
        // 다양한 날짜 타입 만들기
        // 1. 2023/10/24 11:04:30
        // 2. 2023-10-24 오전 11:04:30
        // 3. 화요일 11:04:30
        // 4. 2023.10.24 AM 11:04:30
        System.out.println("\n=============111==========\n");
        sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        System.out.println(sdf.format(dateToday));
        System.out.println("\n============222===========\n");
        sdf = new SimpleDateFormat("yyyy-MM-dd a hh:mm:ss");
        System.out.println(sdf.format(dateToday));
        System.out.println("\n===============333========\n");
        sdf = new SimpleDateFormat("E요일 HH:mm:ss");
        System.out.println(sdf.format(dateToday));
        System.out.println("\n===============444========\n");
        sdf = new SimpleDateFormat("yyyy.MM.dd a hh:mm:ss", new Locale("en", "US"));
        System.out.println(sdf.format(dateToday));
        sdf = new SimpleDateFormat("yyyy.MM.dd a hh:mm:ss", Locale.US);
        System.out.println(sdf.format(dateToday));

        // hh -> 01~12라서 오후 2시면 14가 아닌 02로 표현
        // h -> 한자리 숫자의 앞에 0이 사라짐
        // HH -> 14시로 표현
        // yyyy 2023 // yy 23
        // MM 7월 07 // M 7월 7

        // 현재 미국 날짜를 2023.10.24 AM 01: 04:30


        System.out.println("\n=======================\n");
        TimeZone time;
        Date date = new Date();
        DateFormat df = new SimpleDateFormat(
                "yyyy-MM-dd a HH:mm:ss", Locale.US);

        time = TimeZone.getTimeZone("America/Los_Angeles");
        df.setTimeZone(time);
        System.out.println(df.format(date));

        System.out.println("\n=======================\n");

        // 날짜형 문자열(String) -> Date 객체로 변환
        String strTomorrow = "2023-10-25 20:12:45";

        // SimpleDateFormat 에 문자열과 같은 형태의 포맷 설정

        sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // 해당 날짜형 문자열의 날짜가 저장된 Date 객체리턴
        // sdf의 날짜포맷과 날짜형 문자열의 형식이 하나라도 다르면 에러가 난다

        Date dateTomorrow = sdf.parse(strTomorrow);

        System.out.println(dateTomorrow);

        String strTime = "11:48:32";
        sdf = new SimpleDateFormat("HH:mm:ss");
        Date dateTime = sdf.parse(strTime);
        System.out.println(dateTime);

        String strYear = "2020.10.10";
        sdf = new SimpleDateFormat("yyyy.MM.dd");
        Date dateYear = sdf.parse(strYear);
        System.out.println(dateYear);

        System.out.println("\n=======================\n");

        // 날짜 세팅하기
        Calendar cal = Calendar.getInstance();

        // 98년 12월 02일
        // 여기서 month 부분은 1월이 0, 2월이 1, 12월이 11
        cal.set(1998, 11, 02, 4, 20, 20);
        sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
        System.out.println(sdf.format(cal.getTime()));

        // Date 타입의 객체를 Calendar 타입으로 변환
        Date temp = new Date();
        Calendar calTemp = Calendar.getInstance();
        calTemp.setTime(temp);// Date 객체의 시간이 Calendar 객체에 저장된다.

        System.out.println(sdf.format(calTemp.getTime()));

        //날짜 꺼내기

        System.out.println(calTemp.get(Calendar.YEAR)); // Calendar.YEAR = 1
        System.out.println(calTemp.get(Calendar.MONTH) + 1);
        System.out.println(calTemp.get(Calendar.DATE));
        // 시간
        System.out.println(calTemp.get(Calendar.HOUR)); // 2
        System.out.println(calTemp.get(Calendar.HOUR_OF_DAY)); // 14
        System.out.println(calTemp.get(Calendar.MINUTE));
        System.out.println(calTemp.get(Calendar.SECOND));

        System.out.println("\n=======================\n");

        //날짜 연산
        String oneDay = "2023.10.24 12:21:32";
        String twoDay = "2023.11.21 11:11:22";

        sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
        Date oneDate = sdf.parse(oneDay);
        Date twoDate = sdf.parse(twoDay);

        //Date 객체에 .getTime하면 밀리초가 나온다
        System.out.println(oneDate.getTime());
        System.out.println(twoDate.getTime());

        long diffMillSec = twoDate.getTime() - oneDate.getTime();
        System.out.println(diffMillSec + "밀리초 차이");
        //1초 = 1000밀리초
        //diffMillSec /1000 => 초단위
        long diffSec = diffMillSec / 1000;
        System.out.println(diffSec + "초 차이");
        //diffSec /60 => 분단위
        long diffMin = diffSec / 60;
        System.out.println(diffMin + "분 차이");
        //diffMin /60 => 시단위
        long diffHour = diffMin / 60;
        System.out.println(diffHour + "시 차이");

        //diffHour /24 => 날 단위
        long diffDay = diffHour / 24;
        System.out.println(diffDay + "일 차이");

        // 한 줄로 며칠 차이인지 확인
        long diff = diffMillSec / 1000 / 60 / 60 / 24;

        System.out.println(diff + "일 차이");

        System.out.println("\n=======================\n");

        // 디데이 계산기
        // 2023.09.18에 대해 +36
        // 2023.11.03에 대해 -10
        // 이 출력되는 디데이 계산기 만들어보기

        sdf = new SimpleDateFormat("yyyy.MM.dd");

        String welcomeDay = "2023.09.18";

        Date welcomDate = sdf.parse(welcomeDay);

        String together = "2023.11.03";

        Date toghether = sdf.parse(together);

        Date todayDate = new Date();
        String strToday = sdf.format(todayDate);
        System.out.println(strToday);
        Date newDate = sdf.parse(strToday);

        Long welcomeAgo = newDate.getTime() - welcomDate.getTime();
        Long togetherAgo = newDate.getTime() - toghether.getTime();
        int dayCalcul = (1000 * 60 * 60 * 24);

        Long welcomeResult = welcomeAgo / dayCalcul;
        Long togetherResult = (togetherAgo / dayCalcul);

        System.out.println(togetherAgo / (1000 * 3600 * 24));

        System.out.println(welcomeResult);
        System.out.println(togetherResult);

        System.out.println("\n=======================\n");
        // Calendar 날짜연산
        // 특정 날짜를 기준으로 더하거나 뺄 때 유용

        Calendar calDate = Calendar.getInstance();

        System.out.println(sdf.format(calDate.getTime()));

        calDate.add(Calendar.DATE, 3);
        System.out.println(sdf.format(calDate.getTime()));

        calDate.add(Calendar.DATE, 20);
        System.out.println(sdf.format(calDate.getTime()));

        calDate.add(Calendar.DATE, -7);
        System.out.println(sdf.format(calDate.getTime()));

        calDate.add(Calendar.MONTH, 10);
        System.out.println(sdf.format(calDate.getTime()));

        System.out.println("\n=======================\n");

        // 달력 만들기
        int year = 2023;
        int month = 11;

        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month - 1, 1);

        System.out.println(sdf.format(calendar.getTime()));

        // 1일이 무슨 요일에 시작하는지 알아야 한다.
        int startDay = calendar.get(Calendar.DAY_OF_WEEK);
        // 1일요일 2월요일 3화요일 ~~~7토요일
        System.out.println(startDay);
        // 해당 월이 몇일 까지 있는지 알아야 한다.
        int lastDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        System.out.println(lastDay);


        System.out.println(year + "년 " + month + "월 달력");
        System.out.println("일\t월\t화\t수\t목\t금\t토");

        for (int i = 1; i <= 42; i++) {

            int currentDay = i - startDay + 1;
            if (lastDay < currentDay) {
                break;
            } else {
                if (i < startDay) {
                    System.out.print("\t");
                } else {

                    System.out.printf("%2d\t", currentDay);
                }
                if (i % 7 == 0) {
                    System.out.println();
                }
            }


        }


        System.out.println("\n=======================\n");

        System.out.println(year + "년 " + month + "월 달력");
        System.out.println("월\t화\t수\t목\t금");

        for (int i = 1; i <= 42; i++) {

            int currentDay = i - startDay + 1;
            if (lastDay < currentDay) {
                break;
            } else {
                if (i % 7 == 1 || i % 7 == 0) {
                    if (i % 7 == 0) {
                        System.out.println();
                    }
                } else {
                    if (i < startDay && i > 1) {
                        System.out.print("\t");

                    } else {
                        System.out.printf("%2d\t", currentDay);
                    }

                }

            }

        }

        System.out.println("\n==================이전 이후 달력 출력=====\n");

        System.out.println(year + "년 " + month + "월 달력");
        System.out.println("일\t월\t화\t수\t목\t금\t토");

        Calendar agoMonth = Calendar.getInstance();
        agoMonth.set(year, month - 2, 1);
        int agoMonthLastDay = agoMonth.getActualMaximum(Calendar.DAY_OF_MONTH);

        Calendar laterMonth = Calendar.getInstance();
        laterMonth.set(year, month, 1);
        int laterMothFirstDay = laterMonth.get(Calendar.DATE);



        for (int i = 1; i <= 42; i++) {
            int ddd = agoMonthLastDay - startDay + 1 + i;
            int currentDay = i - startDay + 1;
            if (i < startDay) {
                System.out.print(ddd + "\t");
            } else {
                if (currentDay<=lastDay) {

                    System.out.printf("%2d\t", currentDay);
                }else {
                    System.out.print((currentDay - lastDay) + "\t");

                }
                if (i % 7 == 0) {
                    System.out.println();
                }

            }


        }


    }
}
