package ch14_jdbc_jsp.service;

import ch14_jdbc_jsp.dao.BoardDAO;
import ch14_jdbc_jsp.dto.BoardDTO;
import ch14_jdbc_jsp.dto.MemberDTO;
import ch14_jdbc_jsp.jdbc.ConnectionPool;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class BoardService {

    private BoardService() {

    }

    private static BoardService instance = new BoardService();

    public static BoardService getInstance() {
        return instance;
    }

    private ConnectionPool cp = ConnectionPool.getInstance();
    private BoardDAO dao = BoardDAO.getInstance();


    // 게시글 목록
    public ArrayList<BoardDTO> getBoardList() {
        Connection conn = cp.getConnection();
        ArrayList<BoardDTO> result = new ArrayList<>();

        try {
            result = dao.getBoardList(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            cp.realeaseConnection(conn);
        }

        return result;
    }

    // 게시글 입력
    public void insertBoard(BoardDTO board){
        Connection conn = cp.getConnection();

        try {
            dao.insertBoard(conn, board);
            System.out.println("게시글이 등록되었습니다.");
        } catch (SQLException e) {
            System.out.println("게시글이 등록되지 않았습니다.");
        }finally {
            cp.realeaseConnection(conn);
        }
    }
    // 게시글 상세보기
    public BoardDTO detailGetBoard(int boNo){

        Connection conn = cp.getConnection();
        BoardDTO board = new BoardDTO();

        try {
            board =  dao.detailGetBoard(conn, boNo);
        } catch (SQLException e) {
            System.out.println("게시글이 검색되지 않았습니다.");
        }finally {
            cp.realeaseConnection(conn);
        }
        return board;
    }

    public void deleteBoard(BoardDTO board){

        Connection conn = cp.getConnection();

        try {
            dao.deleteBoard(conn, board);
            System.out.println("게시글이 삭제되었습니다.");
        } catch (SQLException e) {
            System.out.println("게시글이 삭제되지 않았습니다.");
        }finally {
            cp.realeaseConnection(conn);
        }

    }

}
