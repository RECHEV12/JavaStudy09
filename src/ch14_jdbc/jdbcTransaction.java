package ch14_jdbc;

import java.sql.*;

public class jdbcTransaction {
    /*
     * 호빵맨의 score 50을 식빵맨에게 주기
     * Update문이 호빵맨의 score에 한번
     * 식빵맨의 score에 두번 실행된다.
     *
     * 만약 호빵맨의 score 50이 안되는 상황이면
     * 식빵맨에게 score를 줄 수 없으니 취소한다.*/



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

            // 자동 커밋 기능 (auto-commit) 기능 끄기
            conn.setAutoCommit(false);

            StringBuffer query = new StringBuffer();
            query.append("UPDATE                           ");
            query.append("  members                        ");
            query.append("  SET                            ");
            query.append("  mem_score = mem_score - ?      ");
            query.append("  WHERE 1=1                      ");
            query.append("  AND mem_name = ?               ");

            ps = conn.prepareStatement(query.toString());


            int idx = 1;
            ps.setInt(idx++, 50);
            ps.setString(idx++, "호빵맨");


            int result = ps.executeUpdate(); // DB 프로그램에서 updated rows의 값을 리턴

            System.out.println(result);

            ps.close();

            query = new StringBuffer();
            query.append("SELECT                 ");
            query.append("  mem_score AS score   ");
            query.append("  FROM                 ");
            query.append("  members              ");
            query.append("  WHERE 1=1                      ");
            query.append("  AND mem_name = ?               ");



            ps = conn.prepareStatement(query.toString());

            ps.setString(1,"호빵맨");

            rs = ps.executeQuery();

            if (rs.next()) {
                System.out.println("호빵맨 score : " + rs.getInt("score"));
                // 호빵맨의 score에 -50을 한 결과가 음수라면
                // 해당 어데이트 롤백 시키기
              if (rs.getInt("score")<0){
                  conn.rollback();
              }else {
                  //-50을 한 이후 0보다 크면 식빵맨의 score +50

                  ps.close();

                  query = new StringBuffer();
                  query.append("UPDATE                           ");
                  query.append("  members                        ");
                  query.append("  SET                            ");
                  query.append("  mem_score = mem_score + ?      ");
                  query.append("  WHERE 1=1                      ");
                  query.append("  AND mem_name = ?               ");

                  ps = conn.prepareStatement(query.toString());

                  ps.setInt(1,50);
                  ps.setString(2,"식빵맨");

                int rst = ps.executeUpdate();

                if (rst > 0){
                    // 호빵맨의 스코어가 -50이 잘 되었고
                    // 식빵맨의 스코어가 +50이 잘됨
                    conn.commit();

                }else {
                    conn.rollback();

                }






              }
            }

        } catch (SQLException e) {
            try {conn.rollback();} catch (SQLException ex) {}
            throw new RuntimeException(e);
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }


    }
}



