package model;

import model.BaseDAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PersonDAO extends BaseDAO {

    public Optional<Person> findByNamePerson(String pname) {
        String sql = "select id, name from person where name=?";
        try {
            getConn();
            psmt = conn.prepareStatement(sql);
            psmt.setString(1, pname);
            rs = psmt.executeQuery();
            if ( rs.next() ) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                return Optional.of(new Person(id, name));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return Optional.empty();
    }

    public List<Person> findAllPerson() {
        List<Person> result = new ArrayList<>();
        String sql = "select id, name from person";
        try {
            getConn();
            psmt = conn.prepareStatement(sql);
            rs = psmt.executeQuery();
            while( rs.next() ) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                result.add(new Person(id, name));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return result;
    }

    public int insertPerson(String name) {
        int cnt = 0;
        String sql = "insert into person(name) values(?)";
        try {
            getConn();
            psmt = conn.prepareStatement(sql);
            psmt.setString(1, name);
            cnt = psmt.executeUpdate();
        }
        catch(SQLException e) {
            System.err.println(e.getMessage());
        }
        finally {
            close();
        }
        return cnt;
    }

    public void initPerson() {
        String sql = """
                create table person (
                id integer primary key autoincrement,
                name string
                )
                """;
        try {
            getConn();
            smt = conn.createStatement();
            smt.executeUpdate("drop table if exists person");
            smt.executeUpdate(sql);
        }
        catch(SQLException e) {
            System.err.println(e.getMessage());
        }
        finally {
            close();
        }
    }
}
