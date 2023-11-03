package ch14_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class jdbcDelete {
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



        try {
            conn = DriverManager.getConnection(url, id, pw);

            StringBuffer query = new StringBuffer();
            query.append("DELETE            ");
            query.append("  members            ");
            query.append("  WHERE              ");
            query.append("  mem_name = '세균맨'            ");

            ps = conn.prepareStatement(query.toString());

            // 쿼리문 내부 물음표 채우기
            // 첫번째 물음표의 인덱스는 0이 아니라 1부터 시작
            int idx = 1;
            ps.setString(idx++, "f001");

            // insert, update, delete 문은 excuteUpdate로 실행
            int result = ps.executeUpdate(); // DB 프로그램에서 updated rows의 값을 리턴

            System.out.println(result);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            if (ps != null){try {ps.close();} catch (SQLException e) {e.printStackTrace();}}
            if (conn != null){try {conn.close();} catch (SQLException e) {e.printStackTrace();}}
        }


    }
}
