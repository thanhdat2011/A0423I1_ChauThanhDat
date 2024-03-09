package com.example.ss9.repositories.impl;

import com.example.ss9.models.Student;
import com.example.ss9.repositories.IStudentRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository implements IStudentRepository {

    public static final String DELETE = "delete from students2 where id = ?";

    @Override
    public List<Student> findAll() {
        List<Student> studentList = new ArrayList<>();
        Student student;
        try {
            Statement statement = BaseRepository.getConnectionJavaToDB().createStatement();
            ResultSet resultSet = statement.executeQuery("select * from students2");
            while (resultSet.next()) {
                student = new Student();
                student.setId(resultSet.getInt("id"));
                student.setName(resultSet.getString("name"));
                student.setGender(resultSet.getBoolean("gender"));
                student.setPoint(resultSet.getDouble("point"));
                studentList.add(student);
            }
         } catch (SQLException e) {
            System.out.println("Lỗi connect DB");
        }
        return studentList;
    }

    @Override
    public void save(Student student) {
        try {
            PreparedStatement preparedStatement = BaseRepository.getConnectionJavaToDB()
                    .prepareStatement("insert into students2(name, gender, point) value (?,?,?)");
            preparedStatement.setString(1, student.getName());
            preparedStatement.setBoolean(2, student.getGender());
            preparedStatement.setDouble(3, student.getPoint());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteById(int id) {
        try {
            PreparedStatement preparedStatement = BaseRepository.getConnectionJavaToDB()
                    .prepareStatement(DELETE);
           preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
