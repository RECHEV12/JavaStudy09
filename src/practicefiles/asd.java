package practicefiles;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) throws ParseException {
        today = "2023.05.01";
        Date date= new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
        date = sdf.parse(today);

        terms[0] = "A 6";
        terms[1] = "B 12";
        terms[2] = "C 3";





        int[] answer = {};
        return answer;
    }
}