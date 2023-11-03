package ch14_jdbc;

import java.sql.*;

public class ldbcUpdate {
    public static void main(String[] args) {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            System.out.println("드라이버 로드 성공");

        } catch (ClassNotFoundException e) {
//            throw new RuntimeException(e); // 프로그램 멈춤
            System.exit(0); // 프로그램 종료
        }

        String url = "jdbc:oracle:thin:@nextit.or.kr:1521:xe";
        String id = "std209";
        String pw = "oracle21c";

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;



        try {
            conn = DriverManager.getConnection(url, id, pw);

            StringBuffer query = new StringBuffer();
            query.append("UPDATE            ");
            query.append("  members             ");
            query.append("  SET              ");
            query.append("  mem_score = ?           ");

            ps = conn.prepareStatement(query.toString());


            int idx = 1;
            ps.setString(idx++, "0");

            // insert, update, delete 문은 excuteUpdate로 실행
            int result = ps.executeUpdate(); // DB 프로그램에서 updated rows의 값을 리턴

            System.out.println(result);

            // 추가적으로 SELECT문 실행
            ps.close();

            query = new StringBuffer();
            query.append("SELECT                 ");
            query.append("  mem_id,              ");
            query.append("  mem_pw,              ");
            query.append("  mem_name,            ");
            query.append("  mem_score AS score   ");
            query.append("  FROM                 ");
            query.append("  members              ");

             ps = conn.prepareStatement(query.toString());

             rs = ps.executeQuery();

            while (rs.next()){
                System.out.println(rs.getString("mem_id"));
                System.out.println(rs.getString("mem_pw"));
                System.out.println(rs.getString("mem_name"));
                System.out.println(rs.getInt("score"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            if (ps != null){try {ps.close();} catch (SQLException e) {e.printStackTrace();}}
            if (conn != null){try {conn.close();} catch (SQLException e) {e.printStackTrace();}}
            if (rs != null){try {rs.close();} catch (SQLException e) {e.printStackTrace();}}

        }


    }
}
