package ch14_jdbc;

import oracle.jdbc.driver.OracleDriver;

import java.sql.*;

public class jdbcSelect {
    public static void main(String[] args) {

        // ojdbc 라이브러리 내 oracleDriver 클래스 깨우기

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            System.out.println("드라이버 로드 성공");

        } catch (ClassNotFoundException e) {
//            throw new RuntimeException(e); // 프로그램 멈춤
            System.exit(0); // 프로그램 종료
        }

        // 2. DB 연결을 위한 URL, 계정  ID/PW 준비
        String url = "jdbc:oracle:thin:@nextit.or.kr:1521:xe";
        String id = "std209";
        String pw = "oracle21c";

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;


        // 3. 데이터베이스 서버와 연결
        // 연결에 성공하면 연결된 상태인 Connection  객체를 리턴한다 =
        try {
             conn = DriverManager.getConnection(url, id, pw);
            System.out.println("커넥션 성공");

            // 4. 쿼리문 작성
            StringBuffer query = new StringBuffer();
            // 문자열 더하기 중에 여백없이 딱 붙는 경우가 없도록 하기
            query.append("SELECT                 ");
            query.append("  mem_id,              ");
            query.append("  mem_pw,              ");
            query.append("  mem_name,            ");
            query.append("  mem_score AS score   ");
            query.append("  FROM                 ");
            query.append("  members              "); // query문 문자열 안에 ; 넣지 말아야 한다.

            // 5. 쿼리문을 실행하기 위한 PreparedStatment 객체 생성
             ps = conn.prepareStatement(query.toString());

            // 6. 쿼리문 실행 및 실행 결과를  ResultSet에 담기
             rs = ps.executeQuery();

            //7. ResultSet 내부 데이터 조회
            while (rs.next()){
                System.out.println(rs.getString("mem_id"));
                System.out.println(rs.getString("mem_pw"));
                System.out.println(rs.getString("mem_name"));
                // select 문에 알리아스가 있다면 맞춰주어야 한다.
                System.out.println(rs.getInt("score"));
            }



        } catch (SQLException e) {
            throw new RuntimeException(e);

        }finally {
            // 8. DB 연결에 사용된 객체들 close 해주기
            if (rs != null){try {rs.close();} catch (SQLException e) {e.printStackTrace();}}
            if (ps != null){try {ps.close();} catch (SQLException e) {e.printStackTrace();}}
            if (conn != null){try {conn.close();} catch (SQLException e) {e.printStackTrace();}}
        }


    }
}
