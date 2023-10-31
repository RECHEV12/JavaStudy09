package dongwoo.submit11.q01;

public class AudioBoard extends Board {
    private String audio;



    public AudioBoard(int num, String title, String postDate, String descrition, String audio) {
        super(num, title, postDate, descrition);
        this.audio = audio;
    }

    @Override
    public String toString() {
        return "Board{" +
                "num=" + getNum() +
                ", title='" + getTitle() + '\'' +
                ", postDate='" + getPostDate() + '\'' +
                ", descrition='" + getDescrition() + '\'' +
                ", audio='" + audio + '\'' +
                '}';
    }

    public String getAudio() {
        return audio;
    }

    public void setAudio(String audio) {
        this.audio = audio;
    }
}
