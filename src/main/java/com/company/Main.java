package com.company;

import java.sql.*;
import java.util.Locale;

public class Main {
    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager
                .getConnection("jdbc:postgresql://194.67.105.79:5432/testdb",
                        "testuser", "12345");

        Statement statement = connection.createStatement();

//        String insertQuery = String.format(Locale.US,"insert into authors (name, age, rating) values ('%s',%d,%f)", "Иван Семёнович", 41, 5.1);
//        statement.executeUpdate(insertQuery);

//        String deleteQuery = String.format("delete from authors where rating = 5.1");
//        statement.executeUpdate(deleteQuery);

//        String selectScalarQuery = String.format("SELECT max(age) as result FROM authors");
//        ResultSet resultScalarSet = statement.executeQuery(selectScalarQuery);
//        resultScalarSet.next();
//        int result = resultScalarSet.getInt("result");
//        System.out.println(result);

        String updateQuery = String.format("update authors set age=age+10 where id=20");
        statement.executeUpdate(updateQuery);

        String selectQuery = String.format("SELECT * FROM authors ORDER BY id ASC ");
        ResultSet resultSet = statement.executeQuery(selectQuery);
        while (resultSet.next()) {
            System.out.println(
                    resultSet.getInt("id") + " " +
                            resultSet.getString("name") + " " +
                            resultSet.getInt("age") + " " +
                            resultSet.getDouble("rating")
            );
        }
        resultSet.close();
    }
}
