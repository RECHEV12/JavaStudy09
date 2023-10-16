package ch09_class.member;

import java.util.ArrayList;

public class MemberDB {
    private ArrayList<Member> memList; /*Member 보관 리스트*/

    public MemberDB() {
        memList = new ArrayList<>();
        memList.add(new Member("admin", "adminadmin", "관리자"));
        //  가데이터, 더미데이터
        memList.add(new Member("a001", "a001", "테스터"));
        memList.add(new Member("a002", "a002", "테스터2"));
    }

    public ArrayList<Member> getMemList() {
        return memList;
    }
}
