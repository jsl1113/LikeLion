package model;

import model.BaseDAO;

import java.sql.SQLException;

public class CountryDAO extends BaseDAO {
    public void gatCodeName() {
        String sql = "select code, name from country order by code, name";
        try {
            getConn();
            psmt = conn.prepareStatement(sql);
            rs = psmt.executeQuery();
            while( rs.next() ) {
                System.out.print( rs.getString("code") + "\t");
                System.out.println( rs.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close();
        }
    }
}
