package dongwoo.submit11.q01;

public class Board {
    private int num;
    private String title;
    private String postDate;
    private String descrition;

    public Board() {
    }

    public Board(int num, String title, String postDate, String descrition) {
        this.num = num;
        this.title = title;
        this.postDate = postDate;
        this.descrition = descrition;
    }

    @Override
    public String toString() {
        return "Board{" +
                "num=" + num +
                ", title='" + title + '\'' +
                ", postDate='" + postDate + '\'' +
                ", descrition='" + descrition + '\'' +
                '}';
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPostDate() {
        return postDate;
    }

    public void setPostDate(String postDate) {
        this.postDate = postDate;
    }

    public String getDescrition() {
        return descrition;
    }

    public void setDescrition(String descrition) {
        this.descrition = descrition;
    }
}
