package rikkei.academy.service;

import rikkei.academy.config.ConnectMySQL;
import rikkei.academy.model.Students;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentServiceIMPL implements IStudentService{
    private Connection connection = ConnectMySQL.getConnection();
    private static final String CREATE_STUDENT = "INSERT INTO students(name,age) VALUES(?,?);";
    private static final String LIST_STUDENT = "SELECT * FROM students";
    private static final String STUDENT_BY_ID = "SELECT* FROM students WHERE id = ?;";
    private static final String UPDATE_STUDENT = "UPDATE students SET name = ?,age = ? WHERE id = ?;";
    private static final String DELETE_STUDENT = "DELETE FROM students WHERE id = ?";
    private static  final String SEARCH_BY_NAME = "SELECT *FROM students WHERE name LIKE ?";
    @Override
    public List<Students> findAll() {
        List<Students> studentsList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(LIST_STUDENT);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                Students students = new Students(id, name, age);
                studentsList.add(students);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return studentsList;
    }

    @Override
    public void save(Students students) {
        try {
            if (findById(students.getId()) == null) {
                PreparedStatement preparedStatement = connection.prepareStatement(CREATE_STUDENT);
                preparedStatement.setString(1,students.getName());
                preparedStatement.setInt(2,students.getAge());
                preparedStatement.executeUpdate();
            }else {

                PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_STUDENT);
                preparedStatement.setString(1,students.getName());
                preparedStatement.setInt(2,students.getAge());
                preparedStatement.setInt(3,students.getId());
                preparedStatement.executeUpdate();
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Students findById(int id) {
        Students students = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(STUDENT_BY_ID);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
               String name = resultSet.getString("name");
               int age = resultSet.getInt("age");
               students = new Students(id,name,age);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return students;
    }

    @Override
    public void delete(int id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_STUDENT);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<Students> findByName(String nameSearch) {
        List<Students> studentsListSearch = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_BY_NAME);
            preparedStatement.setString(1,'%'+nameSearch+'%');
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int age = resultSet.getInt("age");
                String name = resultSet.getString("name");
                Students students = new Students(id, name, age);
                studentsListSearch.add(students);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return studentsListSearch;
    }
}
