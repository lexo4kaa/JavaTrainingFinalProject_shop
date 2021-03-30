package com.example.final_project_shop.dao.impl;

import com.example.final_project_shop.dao.BaseDao;
import com.example.final_project_shop.dao.UsersColumn;
import com.example.final_project_shop.dao.DaoException;
import com.example.final_project_shop.db.ConnectionCreator;
import com.example.final_project_shop.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BaseDaoImpl implements BaseDao {
    private static final char PERCENT = '%';
    private static final BaseDaoImpl instance = new BaseDaoImpl();
    private static final String FIND_ALL = "SELECT user_id,user_name,user_surname,user_nickname,user_password," +
                                            "user_DOB,user_phone_number,user_role FROM users";
    private static final String FIND_BY_NICKNAME = "SELECT  user_id,user_name,user_surname,user_nickname,user_password," +
                                                    "user_DOB,user_phone_number,user_role FROM users " +
                                                    "WHERE user_nickname LIKE ?";

    private BaseDaoImpl(){}

    public static BaseDao getInstance(){
        return instance;
    }

    @Override
    public List<User> findAllUsers() throws DaoException {
        try(Connection connection = ConnectionCreator.createConnection()) {
            PreparedStatement statement = connection.prepareStatement(FIND_ALL);
            ResultSet resultSet = statement.executeQuery();
            List<User> users = new ArrayList<>();
            while (resultSet.next()){
                users.add(createUserFromResultSet(resultSet));
            }
            return users;
        } catch (SQLException e) {
            throw new DaoException("Error while finding users", e);
        }
    }

    @Override
    public List<User> findUsersByNickname(String nickname) throws DaoException {
        try(Connection connection = ConnectionCreator.createConnection()) {
            PreparedStatement statement = connection.prepareStatement(FIND_BY_NICKNAME);
            statement.setString(1, nickname + PERCENT);
            ResultSet resultSet = statement.executeQuery();
            List<User> users = new ArrayList<>();
            while (resultSet.next()){
                users.add(createUserFromResultSet(resultSet));
            }
            return users;
        } catch (SQLException e) {
            throw new DaoException("Error while finding users", e);
        }
    }

    private User createUserFromResultSet(ResultSet resultSet) throws SQLException {
        User user = new User();
        int userId = resultSet.getInt(UsersColumn.USER_ID);
        String name = resultSet.getString(UsersColumn.USER_NAME);
        String surname = resultSet.getString(UsersColumn.USER_SURNAME);
        String nickname = resultSet.getString(UsersColumn.USER_NICKNAME);
        String password = resultSet.getString(UsersColumn.USER_PASSWORD);
        Date dob = resultSet.getDate(UsersColumn.USER_DOB);
        String phone = resultSet.getString(UsersColumn.USER_PHONE);
        String role = resultSet.getString(UsersColumn.USER_ROLE);
        user.setUserId(userId);
        user.setName(name);
        user.setSurname(surname);
        user.setNickname(nickname);
        user.setPassword(password);
        user.setDob(dob);
        user.setPhone(phone);
        user.setRole(role);
        return user;
    }
}
