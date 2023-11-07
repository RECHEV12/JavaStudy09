package ch14_jdbc_jsp.main;

import ch14_jdbc_jsp.dao.BoardDAO;
import ch14_jdbc_jsp.dao.MemberDAO;
import ch14_jdbc_jsp.dto.BoardDTO;
import ch14_jdbc_jsp.dto.MemberDTO;
import ch14_jdbc_jsp.jdbc.ConnectionFactory;
import ch14_jdbc_jsp.jdbc.ConnectionPool;
import ch14_jdbc_jsp.service.BoardService;
import ch14_jdbc_jsp.service.MemberService;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class JdbcMain {
    public static void main(String[] args) {

        MemberService memberService = MemberService.getInstance();
        BoardService boardService = BoardService.getInstance();

        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.println("행동을 선택해 주세요.");
            System.out.println("1, 회원가입 | 2. 로그인 | 3. 회원 목록 | 4. 종료");
            System.out.print(">>> ");

            int command = Integer.parseInt(scan.nextLine());

            if (command == 1) {
                //회원가입
                System.out.println("아이디 입력 : ");
                String id = scan.nextLine();

                System.out.println("비밀번호 입력 : ");
                String pw = scan.nextLine();

                System.out.println("이름 입력 : ");
                String name = scan.nextLine();

                // 점수는 0이 기본
                MemberDTO member = new MemberDTO(id, pw, name, 0);
                memberService.singUp(member);


            } else if (command == 2) {
                //로그인

                System.out.println("아이디 입력 : ");
                String id = scan.nextLine();

                System.out.println("비밀번호 입력 : ");
                String pw = scan.nextLine();

                MemberDTO member = new MemberDTO(id, pw, "", 0);

                // 유효한 id pw 입력시 login 객체 내부 필드변수들은 채워져있음
                // 아이디나 비밀번호가 틀리면 객체 내부 필드변수들이 비어있음
                MemberDTO lgoin = memberService.login(member);

                if (lgoin.getMemId() != null) {
                    System.out.println("로그인 성공");

                    // 게시판 진입
                    while (true) {
                        // 게시글 목록 출력
                        ArrayList<BoardDTO> boardList = boardService.getBoardList();

                        for (int i = 0; i < boardList.size(); i++) {

                            BoardDTO bo = boardList.get(i);

                            System.out.println("[" + bo.getBoNo() + " | " + bo.getBoTitle()
                                    + " | " + bo.getMemName() + " | " + bo.getBoDate() + "]");
                        }

                        System.out.println("행동을 선택해 주세요.");
                        System.out.println("1, 글쓰기 | 2. 글 상세보기 | 3. 글 삭제 | 4. 로그아웃");
                        System.out.print(">>> ");

                        int select = Integer.parseInt(scan.nextLine());

                        if (select == 1) {
                            System.out.println("글 제목 : ");
                            String title = scan.nextLine();

                            System.out.println("글 내용 : ");
                            String content = scan.nextLine();

                            // 입력받은 title과 content를 입력
                            // DB에 boards 테이브에 INSERT

                            BoardDTO board = new BoardDTO(0, title, content, id, "", "");

                            boardService.insertBoard(board);

                        } else if (select == 2) {
                            System.out.println("글 번호 : ");
                            int boNo = Integer.parseInt(scan.nextLine());

                            BoardDTO detailBoard = boardService.detailGetBoard(boNo);

                            if (detailBoard.getBoContent() != null) {
                                System.out.println("===============================================");
                                System.out.println("제목 : " + detailBoard.getBoTitle());
                                System.out.println("작성자 : " + detailBoard.getMemName() + "\t\t\t " + "작성일 : " + detailBoard.getBoDate());
                                System.out.println("내용 : " + detailBoard.getBoContent());
                                System.out.println("===============================================");

                            } else {
                                System.out.println("유효하지 않은 게시글 번호 입니다.");
                            }


                        } else if (select == 3) {
                            System.out.println("글 번호 : ");
                            int boNo = Integer.parseInt(scan.nextLine());

                            // 해당 글번호인 게시글의 delyn값을 y로 업데이트
                            // 글 삭제 시 해당 게시글이 현재 로그인한 사람이 작성한
                            // 게시글 이어야만 삭제 가능

                            BoardDTO board = boardService.detailGetBoard(boNo);

                            if (id.equals(board.getBoId())) {

                                boardService.deleteBoard(board);
                            } else {
                                System.out.println("작성자와 로그인사람이 다릅니다.");
                            }


                        } else if (select == 4) {
                            System.out.println("로그아웃 합니다.");
                            break;
                        } else {
                            System.out.println("잘못 입력하셨습니다.");
                        }


                    }


                } else {
                    System.out.println("아이디 혹은 비밀번호가 틀립니다.");
                }


            } else if (command == 3) {
                ArrayList<MemberDTO> memList = memberService.getMemberList();
                for (int i = 0; i < memList.size(); i++) {
                    System.out.println(memList.get(i));
                }
            } else if (command == 4) {
                break;
            } else {
                System.out.println("잘못 입력하셨습니다.");
            }


        }


    }
}
