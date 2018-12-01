package db;

import model.dao.daoImpl.DAOThingImpl;
import model.entity.Thing;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        DAOThingImpl a =new DAOThingImpl();
        a.getAll();
    }
}
