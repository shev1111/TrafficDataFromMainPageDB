package DAO;

import com.dao.ConnectionDB;
import model.Category;
import model.Template;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

public class TemplateDAO {

    public static void insertTemplates(List<Template> templates){
        String sql = "INSERT INTO templates (category_id, info, name, url, image)  VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = ConnectionDB.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);) {
            Iterator<Template> templateIterator = templates.iterator();
            while (templateIterator.hasNext()){
                Template template = templateIterator.next();
                preparedStatement.setInt(1, getCategoryId(template.getCategory()));
                preparedStatement.setString(2, template.getInfo());
                preparedStatement.setString(3, template.getName());
                preparedStatement.setString(4, template.getUrl());
                preparedStatement.setString(5, template.getImage());
                preparedStatement.addBatch();
            }
            preparedStatement.executeBatch();

        } catch (SQLException e) {
            e.printStackTrace();
            //logger.error("SQL error: " + e.getMessage());
            //logger.error("Polygons for buffer "+meters_buffer+" was not received");
        }

    }


    private static Integer getCategoryId(String category){
        switch (category) {
            case "Телефонія":return 1;
            case "Розшукові обліки":return 2;
            case "Санкції":return 3;
            case "Очищення влади":return 4;
            case "Уповноважені особи":return 5;
            case "Податки":return 6;
            case "Майно":return 7;
            case "Банкінг":return 8;
            case "Інформація":return 9;
            case "Перевірка":return 10;
            case "Освіта":return 11;
            case "Патенти":return 12;
            case "Свідоцтва":return 13;
            case "Дозволи/ліцензії/сертифікати":return 14;
            case "Організація, об’єднання, формування":return 15;
            case "Транспорт":return 16;
            case "Телефон":return 17;
            case "Виконавчі провадження":return 18;
            case "Страхування":return 18;
            case "Фондовий ринок України":return 20;
            case "Іноземні юридичні та фізичні особи":return 21;


        }
        return 0;
    }

}
