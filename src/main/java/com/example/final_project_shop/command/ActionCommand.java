package com.example.final_project_shop.command;

import com.example.final_project_shop.dao.DaoException;

import javax.servlet.http.HttpServletRequest;

public interface ActionCommand {
    String execute(HttpServletRequest request) throws DaoException;
}
