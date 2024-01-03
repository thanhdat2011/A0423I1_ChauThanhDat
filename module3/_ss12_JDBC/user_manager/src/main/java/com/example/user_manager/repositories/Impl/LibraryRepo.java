package com.example.user_manager.repositories.Impl;

import com.example.user_manager.models.Book;
import com.example.user_manager.repositories.IBookRepo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookRepo implements IBookRepo {

    private final static String INSERT_USER_SQL = "insert into users(user_name, user_email,user_country) values (?,?,?);";
    private final static String SELECT_ALL_BOOK_SQL = "select * from books;";
    private final static String SELECT_BOOK_BY_ID_SQL = "select * from books where book_id = ?";
    private final static String UPDATE_USER_BY_ID_SQL = "update users set user_name = ?, user_email = ?, user_country = ? where user_id = ?;";
    public static final String DELETE_USER_BY_ID = "delete from users where user_id = ?";


    @Override
    public List<Book> findAll() {
        List<Book> users = new ArrayList<>();
        Book book;
        try {
            Statement statement = BaseRepo.getConnectionJavaToDB().createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_ALL_BOOK_SQL);
            while (resultSet.next()) {
                book = new Book();
                book.setId(resultSet.getString("book_id"));
                book.setName(resultSet.getString("book_name"));
                book.setAuthor(resultSet.getString("book_author"));
                book.setAmount(resultSet.getInt("book_amount"));
                book.setDescription(resultSet.getString("book_description"));
                users.add(book);
            }
        } catch (SQLException e) {
            System.out.println("Error connect to DB");
        }
        return users;
    }

    @Override
    public Book findById(String bookID) {
        Book book = null;
        try {
            CallableStatement callableStatement = BaseRepo.getConnectionJavaToDB().prepareCall("call get_book_by_id(?)");
            callableStatement.setString(1, bookID);
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("book_name");
                String author = resultSet.getString("book_author");
                int amount = resultSet.getInt("book_amount");
                String description = resultSet.getString("book_description");
                book = new Book(bookID, name, author, amount, description);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return book;
    }

//    @Override
//    public Student findById(int id) {
//        Student user;
//        try {
//            PreparedStatement preparedStatement = BaseRepo.getConnectionJavaToDB().prepareStatement(SELECT_USER_BY_ID_SQL);
//            preparedStatement.setInt(1, id);
//            ResultSet resultSet = preparedStatement.executeQuery();
//            resultSet.next();
//            user = new Student();
//            user.setId(resultSet.getInt("user_id"));
//            user.setName(resultSet.getString("user_name"));
//            user.setEmail(resultSet.getString("user_email"));
//            user.setCountry(resultSet.getString("user_country"));
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//        return user;
//    }

//    @Override
//    public void save(Book user) {
//        try {
//            PreparedStatement preparedStatement = BaseRepo.getConnectionJavaToDB().prepareStatement(INSERT_USER_SQL);
//
//            preparedStatement.setString(1, user.getName());
//            preparedStatement.setString(2, user.getEmail());
//            preparedStatement.setString(3, user.getCountry());
//            preparedStatement.executeUpdate();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }

//    @Override
//    public void update(Book user) {
//        try{
//            PreparedStatement preparedStatement = BaseRepo.getConnectionJavaToDB().prepareStatement(UPDATE_USER_BY_ID_SQL);
//            //"update users set user_name = ?, user_email = ?, user_country = ? where user_id = ?"
//            preparedStatement.setString(1, user.getName());
//            preparedStatement.setString(2, user.getEmail());
//            preparedStatement.setString(3, user.getCountry());
//            preparedStatement.setInt(4, user.getId());
//            preparedStatement.executeUpdate();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }

//    @Override
//    public void deleteUserById(int id) {
//        try{
//            PreparedStatement preparedStatement = BaseRepo.getConnectionJavaToDB().prepareStatement(DELETE_USER_BY_ID);
//            preparedStatement.setInt(1, id);
//            preparedStatement.executeUpdate();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }

//    @Override
//    public List<User> searchByCountry(String country) {
//        List<User> users= new ArrayList<>();
//        User user;
//        try {
//            PreparedStatement preparedStatement = BaseRepo.getConnectionJavaToDB().prepareStatement("select * from users where user_country like ?");
//            preparedStatement.setString(1, country);
//            ResultSet resultSet = preparedStatement.executeQuery();
//            while(resultSet.next()){
//            user = new User();
//            user.setId(resultSet.getInt("user_id"));
//            user.setName(resultSet.getString("user_name"));
//            user.setEmail(resultSet.getString("user_email"));
//            user.setCountry(resultSet.getString("user_country"));
//            users.add(user);
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//
//        return users;
//    }


//    @Override
//    public Student getUserByIdSP(int id) {
//        Student user = null;
//        try {
//            CallableStatement callableStatement = BaseRepo.getConnectionJavaToDB().prepareCall("call get_user_by_id(?)");
//            callableStatement.setInt(1,id);
//            ResultSet resultSet = callableStatement.executeQuery();
//            while (resultSet.next()) {
//                String name = resultSet.getString("user_name");
//                String email = resultSet.getString("user_email");
//                String country = resultSet.getString("user_country");
//                user = new Student(name,email,country);
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//        return user;
//    }


}
