package ch09_class.homepage;

import java.util.ArrayList;
import java.util.Scanner;

public class MemberDB {
    private ArrayList<Member> memList = new ArrayList<>(); /*회원 목록 리스트*/
    private Scanner scan;

    // 싱글톤 패턴 적용
    // 프로젝트 전체에서 이 객체를 하나만 생성해서 쓸 때사용
    // 1. 기본 생성자의 접근제어자를 private 로 막는다


    private MemberDB() {
        memList.add(new Member("admin", "admin", "관리자"));
        memList.add(new Member("a001", "a001", "호빵맨"));
    }

    // 2. 필드에 자기자신 MemberDB 객체를 생성
    // 2-1. 스태틱을 붙여서 다른 곳에서 객체 생성 없이 접근하도록 만듬
    // 2-2. 다른곳에서 .instance로 직접 접근 못하도록 private처리
    private static MemberDB instance = new MemberDB();

    // 3. instace에 대한 getter 만들기
    public static MemberDB getInstance() {
        return instance;
    }

    // 회원가입 시 메소드
    // 회원가입 성공시
    public int signUp(Member mem) {

        for (int i = 0; i < memList.size(); i++) {
            if (mem.getId().equals(memList.get(i).getId())) {

                return 0;

            }
        }
        memList.add(mem);
        return 1;


    }

    public void showMemList() {
        for (int i = 0; i < memList.size(); i++) {
            System.out.println(memList.get(i));
        }
    }

    public Member login(String id, String pw) {

//        for (int i = 0; i < memList.size(); i++) {
//            Member temp = memList.get(i);
//            if (temp.getId().equals(id) && temp.getPw().equals(pw)) {
//                return temp;
//            }
//        }
        // 위와 같지만 깔끔함
        for (Member mem : memList) {
            if (mem.getId().equals(id) && mem.getPw().equals(pw)) {
                return mem;
            }
        }
        return null;
    }

}



