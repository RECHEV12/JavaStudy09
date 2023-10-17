package dongwoo.submit10;

public class Book {
    private int no; /*도서 번호*/
    private String title; /*도서 제목*/
    private boolean borrow; /*대여 여부*/

    public Book() {
    }

    public Book(int no, String title, boolean borrow) {
        this.no = no;
        this.title = title;
        this.borrow = borrow;
    }

    public Book(int no, String title) {
        this(no, title, false);
    }


    @Override
    public String toString() {
        String bornow = "대여중";
        if (borrow){
             bornow = "대여중";
        }else {
            bornow = "입고중";
        }
        return "[" +
                "도서 번호 : " + no +
                ", 책 제목 : " + title +
                ", 대여 상태 : " + bornow +
                ']';
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isBorrow() {
        return borrow;
    }

    public void setBorrow(boolean borrow) {
        this.borrow = borrow;
    }
}
