package ch09_class.homepage;

public class Member {
    private String id;  /*사용자 아이디*/
    private String pw; /*사용자 비밀번호*/
    private String name; /*사용자 닉네임*/

    public Member() {
    }

    public Member(String id, String pw, String name) {
        this.id = id;
        this.pw = pw;
        this.name = name;
    }

    @Override
    public String toString() {
        return
                "[아이디: " + id +
                ", 비밀번호: " + pw  +
                ", 닉네임: " + name +
                ']';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
