package ch14_jdbc_jsp.dao;

import ch14_jdbc_jsp.dto.BoardDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BoardDAO {

    private BoardDAO() {

    }

    private static BoardDAO instance = new BoardDAO();

    public static BoardDAO getInstance() {
        return instance;
    }

    //게시글조회 SELECT 메소드
    public ArrayList<BoardDTO> getBoardList(Connection conn) throws SQLException {
        StringBuffer query = new StringBuffer();

        query.append("SELECT                          ");
        query.append(" b.BO_NO,                       ");
        query.append(" b.BO_TITLE,                    ");
        query.append(" b.BO_CONTENT,                  ");
        query.append(" b.BO_ID,                       ");
        query.append(" b.BO_DATE,                     ");
        query.append(" m.mem_name                     ");
        query.append("FROM                            ");
        query.append(" BOARDS b , MEMBERS m           ");
        query.append("WHERE 1=1                       ");
        query.append(" AND b.BO_ID = m.MEM_ID         ");
        query.append(" AND b.DELETE_YN ='N'           ");
        query.append(" ORDER BY b.BO_NO asc           ");

        PreparedStatement ps = conn.prepareStatement(query.toString());
        ResultSet rs = ps.executeQuery();

        ArrayList<BoardDTO> resullt = new ArrayList<>();

        while (rs.next()) {
            BoardDTO board = new BoardDTO();
            board.setBoNo(rs.getInt("BO_NO"));
            board.setBoTitle(rs.getString("BO_TITLE"));
            board.setBoContent(rs.getString("BO_CONTENT"));
            board.setBoId(rs.getString("BO_ID"));
            board.setBoDate(rs.getString("BO_DATE"));
            board.setMemName(rs.getString("mem_name"));

            resullt.add(board);

        }

        rs.close();
        ps.close();

        return resullt;
    }

    //게시글 INSERT
    public int insertBoard(Connection conn, BoardDTO board) throws SQLException {

        StringBuffer query = new StringBuffer();

        query.append("INSERT INTO                    ");
        query.append(" boards(                       ");
        query.append(" bo_no,                        ");
        query.append(" bo_title,                     ");
        query.append(" bo_content,                   ");
        query.append(" bo_id,                        ");
        query.append(" bo_date,                      ");
        query.append(" delete_yn)                    ");
        query.append(" VALUES(                       ");
        query.append(" seq_board.NEXTVAL,            ");
        query.append(" ?,                            ");
        query.append(" ?,                            ");
        query.append(" ?,                            ");
        query.append(" SYSDATE,                      ");
        query.append(" 'N')                          ");

        PreparedStatement ps = conn.prepareStatement(query.toString());


        int idx = 1;

        ps.setString(idx++, board.getBoTitle());
        ps.setString(idx++, board.getBoContent());
        ps.setString(idx++, board.getBoId());

        int result = ps.executeUpdate();

        ps.close();

        return result;


    }

    // 게시글 상세보기
    public BoardDTO detailGetBoard(Connection conn, int boNo) throws SQLException {
        StringBuffer query = new StringBuffer();

        query.append("SELECT                          ");
        query.append(" b.BO_NO,                       ");
        query.append(" b.BO_TITLE,                    ");
        query.append(" b.BO_CONTENT,                  ");
        query.append(" b.BO_ID,                       ");
        query.append(" b.BO_DATE,                     ");
        query.append(" m.mem_name                     ");
        query.append("FROM                            ");
        query.append(" BOARDS b , MEMBERS m           ");
        query.append("WHERE 1=1                       ");
        query.append(" AND b.BO_ID = m.MEM_ID         ");
        query.append(" AND b. BO_NO = ?               ");
        query.append(" ORDER BY b.BO_NO asc           ");

        PreparedStatement ps = conn.prepareStatement(query.toString());

        int idx = 1;

        ps.setInt(idx, boNo);

        ResultSet rs = ps.executeQuery();


        BoardDTO board = new BoardDTO();

        while (rs.next()) {


            board.setBoNo(rs.getInt("BO_NO"));
            board.setBoTitle(rs.getString("BO_TITLE"));
            board.setBoContent(rs.getString("BO_CONTENT"));
            board.setBoId(rs.getString("BO_ID"));
            board.setBoDate(rs.getString("BO_DATE"));
            board.setMemName(rs.getString("mem_name"));


        }

        rs.close();
        ps.close();

        return board;
    }

    public int deleteBoard(Connection conn, BoardDTO board) throws SQLException {
        StringBuffer query = new StringBuffer();

        query.append(" UPDATE                    ");
        query.append("  BOARDS                   ");
        query.append(" SET                       ");
        query.append("  delete_yn ='Y'           ");
        query.append("WHERE 1=1                  ");
        query.append(" AND BO_NO = ?          ");

        PreparedStatement ps = conn.prepareStatement(query.toString());

        int idx = 1;

        ps.setInt(idx++, board.getBoNo());

        int result = ps.executeUpdate();

        ps.close();

        return result;

    }
}
