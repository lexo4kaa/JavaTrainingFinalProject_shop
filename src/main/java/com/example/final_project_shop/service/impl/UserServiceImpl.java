package com.example.final_project_shop.service.impl;

import com.example.final_project_shop.dao.BaseDao;
import com.example.final_project_shop.dao.DaoException;
import com.example.final_project_shop.dao.impl.BaseDaoImpl;
import com.example.final_project_shop.entity.User;
import com.example.final_project_shop.service.ServiceException;
import com.example.final_project_shop.service.UserService;
import com.example.final_project_shop.validator.UserValidator;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

public class UserServiceImpl implements UserService {
    private final BaseDao baseDao = BaseDaoImpl.getInstance();

    @Override
    public List<User> findAllUsers() throws ServiceException {
        List<User> users;
        try {
            users = baseDao.findAllUsers();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
        return users;
    }

    @Override
    public List<User> findUsersByNickname(String nickname) throws ServiceException {
        List<User> users;
        try {
            // todo add validator (video 26.03 23:00)
            users = baseDao.findUsersByNickname(nickname);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
        return users;
    }

    @Override
    public boolean authorizeUser(String login, String password) throws ServiceException {
        String findPassword = "";
        String encPassword = encryptPassword(password);
        if (UserValidator.isLoginCorrect(login) && UserValidator.isPasswordCorrect(password)) {
            try {
                findPassword = baseDao.findPasswordByNickname(login);
            } catch (DaoException e) {
                throw new ServiceException(e);
            }
        }
        return findPassword.equals(encPassword);
    }

    private String encryptPassword(String password) {
        byte[] bytesEncoded = null;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
            messageDigest.update(password.getBytes("utf8"));
            bytesEncoded = messageDigest.digest();
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        BigInteger bigInt = new BigInteger(1, bytesEncoded);
        String enterPassHex = bigInt.toString(16);
        return enterPassHex;
    }
}
