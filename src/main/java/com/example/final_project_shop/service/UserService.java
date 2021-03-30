package com.example.final_project_shop.service;

import com.example.final_project_shop.dao.BaseDao;
import com.example.final_project_shop.dao.DaoException;
import com.example.final_project_shop.dao.impl.BaseDaoImpl;
import com.example.final_project_shop.entity.User;
import java.util.List;

public class UserService { //todo add interface
    private final BaseDao baseDao = BaseDaoImpl.getInstance();

    public List<User> findAllUsers() throws ServiceException {
        List<User> users;
        try {
            users = baseDao.findAllUsers();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
        return users;
    }

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
}
