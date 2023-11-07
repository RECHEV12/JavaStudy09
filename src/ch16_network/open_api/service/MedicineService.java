package ch16_network.open_api.service;

import ch14_jdbc_jsp.jdbc.ConnectionPool;
import ch16_network.open_api.dao.MedicineDAO;
import ch16_network.open_api.dto.MedicineDTO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class MedicineService {
    private MedicineService() {

    }

    private static MedicineService instance = new MedicineService();

    public static MedicineService getInstance() {
        return instance;
    }

    private ConnectionPool cp = ConnectionPool.getInstance();
    private MedicineDAO dao = MedicineDAO.getInstance();


    public void insertMedicine(MedicineDTO medicine) {
        Connection conn = cp.getConnection();

        try {
            dao.insertMedicine(conn, medicine);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            cp.realeaseConnection(conn);
        }

    }

    public ArrayList<MedicineDTO> acheSelectMed(String ache) {

        Connection conn = cp.getConnection();
        ArrayList<MedicineDTO> list;

        try {
            list = dao.acheSelectMed(conn, ache);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            cp.realeaseConnection(conn);
        }

        return list;
    }


}
