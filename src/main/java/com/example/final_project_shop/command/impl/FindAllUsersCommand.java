package com.example.final_project_shop.command.impl;

import com.example.final_project_shop.command.ActionCommand;
import com.example.final_project_shop.entity.User;
import com.example.final_project_shop.resource.ConfigurationManager;
import com.example.final_project_shop.service.ServiceException;
import com.example.final_project_shop.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class FindAllUsersCommand implements ActionCommand {
    private static final UserService userService = new UserService();

    @Override
    public String execute(HttpServletRequest request) {
        String page;
        List<User> users;
        try {
            users = userService.findAllUsers();
            request.setAttribute("lst", users);
            request.setAttribute("lst_length", users.size());
            page = ConfigurationManager.getProperty("path.page.tables");
        } catch (ServiceException e) {
            // log
            page = ConfigurationManager.getProperty("path.page.error");
        }
        return page;
    }
}
