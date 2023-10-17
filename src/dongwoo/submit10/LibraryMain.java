package dongwoo.submit10;

import java.util.ArrayList;
import java.util.Scanner;

public class LibraryMain {
    public static void main(String[] args) {

        Library libDB = Library.getInstance();

        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.println("**행동을 입력해 주세요**");
            System.out.println("1. 책 입고 | 2. 책 대여 | 3. 책 목록 | 4. 책 검색 | 5. 종료 ");
            System.out.print(">>> ");
            int command = Integer.parseInt(scan.nextLine());

            if (command == 1) {


                System.out.println("책 번호를 입력하세요");
                System.out.print(">>> ");
                int no = Integer.parseInt(scan.nextLine());

                libDB.returnBook(no);

            } else if (command == 2) {

                // todo 책대여
                System.out.println("책 제목을 입력해 주세요");
                System.out.print(">>> ");
                String title = scan.nextLine();
                libDB.findBook(title);

                System.out.println("책 번호를 입력하세요");
                System.out.print(">>> ");
                int no = Integer.parseInt(scan.nextLine());

                libDB.borrowBook(no);

            } else if (command == 3) {

                libDB.showbooklist();

            } else if (command == 4) {

                System.out.println("책 제목을 입력해 주세요");
                System.out.print(">>> ");
                String title = scan.nextLine();
                libDB.findBook(title);


            } else if (command == 5) {

                System.out.println("도서관을 나갑니다");
                break;

            } else {
                System.out.println("잘못 입력하셨습니다. 다시 입력해주세요");
            }


        }


    }
}
