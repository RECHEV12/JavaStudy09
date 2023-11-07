package ch16_network.open_api.dao;

import ch16_network.open_api.dto.MedicineDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MedicineDAO {

    private MedicineDAO() {
    }

    private static MedicineDAO instance = new MedicineDAO();

    public static MedicineDAO getInstance() {
        return instance;
    }


    /**
     * 데이터 입력 쿼리문
     *
     * @param conn
     * @param medicine
     * @throws SQLException
     */
    public void insertMedicine(Connection conn, MedicineDTO medicine) throws SQLException {
        StringBuffer query = new StringBuffer();

        query.append("INSERT INTO               ");
        query.append("  medicines(              ");
        query.append("       med_itmName        ");
        query.append("     , med_entpName       ");
        query.append("     , med_efcyQesItm)    ");
        query.append("VALUES(                   ");
        query.append("       ?                  ");
        query.append("     , ?                  ");
        query.append("     , ?)                 ");

        PreparedStatement ps = conn.prepareStatement(query.toString());

        int idx = 1;

        ps.setString(idx++, medicine.getMed_itmName());
        ps.setString(idx++, medicine.getMed_entpName());
        ps.setString(idx++, medicine.getMed_efcyQesItm());

        ps.executeUpdate();

        ps.close();

    }

    /**
     * 어디가 아픈지 입력하면 약 이름을 알려주는 메소드
     *
     * @param conn
     * @param ache
     * @return
     * @throws SQLException
     */
    public ArrayList<MedicineDTO> acheSelectMed(Connection conn, String ache) throws SQLException {
        StringBuffer query = new StringBuffer();

        query.append("SELECT *                      ");
        query.append("FROM medicines                ");
        query.append("WHERE 1=1                     ");
        query.append("AND med_efcyqesitm LIKE ?     ");

        PreparedStatement ps = conn.prepareStatement(query.toString());

        int idx = 1;

        ps.setString(idx++, "%" + ache + "%");


        ResultSet rs = ps.executeQuery();

        ArrayList<MedicineDTO> list = new ArrayList<>();

        while (rs.next()) {
            MedicineDTO temp = new MedicineDTO();

            temp.setMed_itmName(rs.getString("med_itmName"));
            temp.setMed_entpName(rs.getString("med_entpName"));
            temp.setMed_efcyQesItm(rs.getString("med_efcyQesItm"));

            list.add(temp);
        }

        rs.close();
        ps.close();

        return list;
    }


}




