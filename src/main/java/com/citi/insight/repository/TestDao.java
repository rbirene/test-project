package com.citi.insight.repository;

import com.citi.insight.model.Test;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TestDao
{

    private static final String SQL_SERVER_CONNECTION = "jdbc:sqlserver://<server>:<port>;databaseName=Test;user=<user>;password=<password>";

    private static final String SQL_RETURN_CONDITIONAL_TEST = "SELECT * FROM test_table WHERE ? = ?";

    private static final String SQL_RETURN_ALL_TESTS = "SELECT * FROM test_table";

    public List<Test> returnTestByFieldAndValue(String field, String value) throws SQLException {

        List<Test> tests = new ArrayList<>();

        Connection connection = DriverManager.getConnection(SQL_SERVER_CONNECTION);

        PreparedStatement preparedStatement = connection.prepareStatement(SQL_RETURN_CONDITIONAL_TEST);

        preparedStatement.setString(0, field);
        preparedStatement.setString(1, value);

        ResultSet resultSet = preparedStatement.executeQuery();

        while(resultSet.next()){
            Test test = new Test();
            test.setId(resultSet.getString("id"));
            test.setValue(resultSet.getString("value"));
            test.setNumber(resultSet.getInt("number"));
            tests.add(test);
        }

        preparedStatement.close();
        connection.close();
        resultSet.close();

        return tests;
    }

    public List<Test> returnAllTests() throws SQLException {

        List<Test> tests = new ArrayList<>();

        Connection connection = DriverManager.getConnection(SQL_SERVER_CONNECTION);

        PreparedStatement preparedStatement = connection.prepareStatement(SQL_RETURN_ALL_TESTS);

        ResultSet resultSet = preparedStatement.executeQuery();

        while(resultSet.next()){
            Test test = new Test();
            test.setId(resultSet.getString("id"));
            test.setValue(resultSet.getString("value"));
            test.setNumber(resultSet.getInt("number"));
            tests.add(test);
        }

        preparedStatement.close();
        connection.close();
        resultSet.close();

        return tests;
    }
}
