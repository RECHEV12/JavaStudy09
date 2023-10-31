package dongwoo.submit11.q01;

public class CartoonBoard extends Board{
    private String img;


    public CartoonBoard(int num, String title, String postDate, String descrition, String img) {
        super(num, title, postDate, descrition);
        this.img = img;
    }

    @Override
    public String toString() {
        return "Board{" +
                "num=" + getNum() +
                ", title='" + getTitle() + '\'' +
                ", postDate='" + getPostDate() + '\'' +
                ", descrition='" + getDescrition() + '\'' +
                ", img='" + img + '\'' +
                '}';
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}


