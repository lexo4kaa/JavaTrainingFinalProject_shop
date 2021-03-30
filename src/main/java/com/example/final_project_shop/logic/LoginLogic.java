package com.example.final_project_shop.logic;

import com.example.final_project_shop.dao.DaoException;
import com.example.final_project_shop.dao.UsersColumn;
import com.example.final_project_shop.db.ConnectionCreator;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginLogic {
    private static final String FIND_PASSWORD_BY_NICKNAME = "SELECT user_password FROM users WHERE user_nickname = ?";

    public static boolean checkLogin(String enterLogin, String enterPass) throws DaoException {
        String password = findUserPasswordByNickname(enterLogin);

        MessageDigest messageDigest;
        byte[] bytesEncoded = null;
        try {
            messageDigest = MessageDigest.getInstance("SHA-1");
            messageDigest.update(enterPass.getBytes("utf8"));
            bytesEncoded = messageDigest.digest();
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        BigInteger bigInt = new BigInteger(1, bytesEncoded);
        String enterPassHex = bigInt.toString(16);
        return password.equals(enterPassHex);
    }

    public static String findUserPasswordByNickname(String nickname) throws DaoException {
        try(Connection connection = ConnectionCreator.createConnection()) {
            PreparedStatement statement = connection.prepareStatement(FIND_PASSWORD_BY_NICKNAME);
            statement.setString(1, nickname);
            ResultSet resultSet = statement.executeQuery();
            String pass = "";
            if (resultSet.next()){
                pass = resultSet.getString(UsersColumn.USER_PASSWORD);
            }
            return pass;
        } catch (SQLException e) {
            throw new DaoException("Error while finding users", e);
        }
    }
}
