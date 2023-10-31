package dongwoo.submit11.q01;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class BoardMain {
    public static void main(String[] args) {

        ArrayList<Board> boardDB = new ArrayList<>();

        Scanner scan = new Scanner(System.in);



        while (true) {

            System.out.println("행동을 선택해주세요.");
            System.out.println("1. 글 목록 | 2. 글 쓰기 | 3. 종료");
            System.out.print(">>> ");
            int select = Integer.parseInt(scan.nextLine());

            if (select == 1) {
                for (int i = 0 ; i < boardDB.size(); i ++){
                    Board board = boardDB.get(i);
                    System.out.println("[" + board.getNum() + ". | " + board.getTitle() + " | " + board.getPostDate() + "]");
                }

            } else if (select == 2) {
                System.out.print("글 제목을 입력해주세요: ");
                String inputTitle = scan.nextLine();

                System.out.print("글 내용을 입력해주세요: ");
                String  inputDes = scan.nextLine();

                Date postingDate = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");

                String postingStr = sdf.format(postingDate);

                boardDB.add(new Board((boardDB.size() + 1), inputTitle, postingStr , inputDes));



            } else if (select == 3) {
                System.out.println("종료합니다");
                break;
            }else {
                System.out.println("잘못 입력하셨습니다.");
            }
        }


    }
}
