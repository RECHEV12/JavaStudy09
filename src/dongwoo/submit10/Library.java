package dongwoo.submit10;

import java.util.ArrayList;

public class Library {
    private ArrayList<book> bookList = new ArrayList<>(); /*책 목록*/


    String strBooks = "삼국지, 해리포터와 마법사의 돌, 해리포터와 비밀의 방 , 해리포터와 아즈카반의 죄수,해리포터와 불사조 기사단, 해리포터와 혼혈왕자, 해리포터와 죽음의 성물,어린왕자, 나의 라임 오렌지나무, 이것이 자바다, 좋은생각, 반지의 제왕: 반지 원정대, 반지의 제왕: 두 개의 탑, 반지의 제왕: 왕의 귀환, 토익보카, 개미";
    String[] booklistes = strBooks.split(", ");


    private Library() {
        for (String str : booklistes) {
            bookList.add(new book(bookList.size() + 1, str));
        }


    }

    private static Library instance = new Library();

    public static Library getInstance() {
        return instance;
    }

    public void showbooklist() {
        for (book bo : bookList) {
            System.out.println(bo);
        }
    }

    public void borrowBook(int no) {
        int count = 0;
        for (book bo : bookList) {
            if (bo.getNo() == no) {
                count++;
                if (!bo.isBorrow()) {
                    bo.setBorrow(true);
                    System.out.println(bo.getTitle() + "을(를) 대여하셨습니다.");
                    break;
                } else {
                    System.out.println("현재" + bo.getTitle() + "은(는) 대여중으로 빌릴 수 없습니다.");
                }
            }
        }
        if (count == 0) {
            System.out.println("잘못된 책 번호를 입력하셨습니다.");
        }
    }

    public void returnBook(int no) {
        int count = 0;
        for (book bo : bookList) {
            if (bo.getNo() == no) {
                count++;
                if (bo.isBorrow()) {
                    bo.setBorrow(false);
                    System.out.println(bo.getTitle() + "이(가) 입고되었습니다.");
                    break;
                } else {
                    System.out.println("현재" + bo.getTitle() + "은(는) 입고되어 있습니다.");
                }
            }
        }

        if (count == 0) {
            System.out.println("잘못된 책 번호를 입력하셨습니다.");
        }
    }


    public void findBook(String title) {
        int count = 0;
        for (book bo : bookList) {
            if (bo.getTitle().contains(title)) {
                count++;
                System.out.println(bo);
            }
        }
        if (count == 0) {
            System.out.println("현재 " + title + "이(가) 제목에 포함된 책이 없습니다.");
        }

    }


}
