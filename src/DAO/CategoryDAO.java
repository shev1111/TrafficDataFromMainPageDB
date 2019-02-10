package DAO;

import com.dao.ConnectionDB;
import model.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CategoryDAO {

    public static void insertCategories(List<Category> categories){
        String sql = "INSERT INTO categories (name)  VALUES (?)";

        try (Connection connection = ConnectionDB.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);) {
            Iterator<Category> categoryIterator = categories.iterator();
            while (categoryIterator.hasNext()){
                Category category = categoryIterator.next();
               preparedStatement.setString(1, category.getName());
               preparedStatement.addBatch();
            }
            preparedStatement.executeBatch();

        } catch (SQLException e) {
            e.printStackTrace();
            //logger.error("SQL error: " + e.getMessage());
            //logger.error("Polygons for buffer "+meters_buffer+" was not received");
        }
    }



}
