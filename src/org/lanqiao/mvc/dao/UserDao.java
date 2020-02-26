package org.lanqiao.mvc.dao;

import org.lanqiao.mvc.domain.User;
import org.lanqiao.mvc.utils.JDBCUtils;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    public void add(String name,int age,String sex,String addr){
        try {
            Connection connection = JDBCUtils.getConnection();
            String sql = "insert into user(name,age,sex,addr) values(?,?,?,?) ";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, age);
            preparedStatement.setString(3, sex);
            preparedStatement.setString(4, addr);
            preparedStatement.execute();

            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void delete(int id){
        try {
            Connection connection = JDBCUtils.getConnection();
            String sql = "delete from user where id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();

            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void update(int id, String name, int age, String sex, String addr){
        try {
            Connection connection = JDBCUtils.getConnection();
            String sql = "update user set name = ?,age = ?,sex = ?,addr = ? where id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, age);
            preparedStatement.setString(3, sex);
            preparedStatement.setString(4, addr);
            preparedStatement.setInt(5, id);
            preparedStatement.execute();

            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public List<User> list(){
        List<User> users = new ArrayList<>();
        try {
            Connection connection = JDBCUtils.getConnection();
            String sql = "select * from user";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                String name = resultSet.getString(1);
                int age = resultSet.getInt(2);
                String sex = resultSet.getString(3);
                String addr = resultSet.getString(4);
                int id = resultSet.getInt(5);
                User user = new User(name,age,sex,addr,id);
                users.add(user);
            }
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return users;
    }
}
