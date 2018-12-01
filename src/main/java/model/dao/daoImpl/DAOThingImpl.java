package model.dao.daoImpl;

import db.DBConnect;
import model.dao.DAOThing;
import model.entity.Thing;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class DAOThingImpl implements DAOThing {
    @Override
    public List<Thing> getAll() {
        String q = "SELECT * From things;";
        DBConnect connect = new DBConnect();
        List<Thing> things = new LinkedList<>();
        try (PreparedStatement ps = connect.getConnection().prepareStatement(q);) {
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                Thing thing = new Thing();
                thing.setId(resultSet.getInt("id"));
                thing.setPrice(resultSet.getInt("price"));
                thing.setWeight(resultSet.getInt("weight"));
                thing.setName(resultSet.getString("name"));
                things.add(thing);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return things;
    }

    @Override
    public List<Thing> getInPriceDiapason(Integer minPrice, Integer maxPrice) {
        String q = "SELECT * From things WHERE price >= ? AND price <= ?;";
        DBConnect connect = new DBConnect();
        List<Thing> things = new LinkedList<>();
        try (PreparedStatement ps = connect.getConnection().prepareStatement(q)) {
            ps.setInt(1, minPrice);
            ps.setInt(2, maxPrice);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                Thing thing = new Thing();
                thing.setId(resultSet.getInt("id"));
                thing.setPrice(resultSet.getInt("price"));
                thing.setWeight(resultSet.getInt("weight"));
                thing.setName(resultSet.getString("name"));
                things.add(thing);
                System.out.println(thing);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return things;
    }

    @Override
    public void update(Thing entity) {
    }

    @Override
    public Thing getEntityById(Integer id) {
        String q = "SELECT * From things WHERE id = ?;";
        Thing thing = new Thing();
        DBConnect connect = new DBConnect();
        try (PreparedStatement ps = connect.getConnection().prepareStatement(q)) {
            ps.setInt(1, id);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                thing.setId(resultSet.getInt("id"));
                thing.setPrice(resultSet.getInt("price"));
                thing.setWeight(resultSet.getInt("weight"));
                thing.setName(resultSet.getString("name"));
            }
            System.out.println(thing);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return thing;
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public boolean create(Thing entity) {
        String q = "INSERT INTO things (name, price, weight) VALUE (?,?,?);";
        DBConnect connect = new DBConnect();
        try (PreparedStatement ps = connect.getConnection().prepareStatement(q)) {
            ps.setString(1, entity.getName());
            ps.setInt(2, entity.getPrice());
            ps.setInt(3, entity.getWeight());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
