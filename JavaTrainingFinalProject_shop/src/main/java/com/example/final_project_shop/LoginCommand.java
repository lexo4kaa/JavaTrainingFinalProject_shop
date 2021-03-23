package com.example.final_project_shop;
import com.example.final_project_shop.command.ActionCommand;
import com.example.final_project_shop.logic.LoginLogic;
import com.example.final_project_shop.resource.ConfigurationManager;
import com.example.final_project_shop.resource.MessageManager;
import com.example.final_project_shop.shape.entity.Point;
import com.example.final_project_shop.shape.entity.Triangle;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

public class LoginCommand implements ActionCommand {
    private static final String PARAM_NAME_LOGIN = "login";
    private static final String PARAM_NAME_PASSWORD = "password";
    private static final String PARAM_NUMBER_OF_TRIANGLE = "triangleNum";

    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        // получение из запроса логина и пароля
        String login = request.getParameter(PARAM_NAME_LOGIN);
        String pass = request.getParameter(PARAM_NAME_PASSWORD);
        // получение кол-ва треугольника
        String triangleNumStr = request.getParameter(PARAM_NUMBER_OF_TRIANGLE);
        int triangleNum = Integer.parseInt(triangleNumStr);
        // проверка логина и пароля
        if (LoginLogic.checkLogin(login, pass)) {
            // работа с треугольниками
            List<Triangle> list = new ArrayList<>();
            for(int i = 0; i < triangleNum; i++)
            {
                list.add(new Triangle(new Point(getRandomNumber(-10,10),getRandomNumber(-10,10)),
                                      new Point(getRandomNumber(-10,10),getRandomNumber(-10,10)),
                                      new Point(getRandomNumber(-10,10),getRandomNumber(-10,10))));
            }
            request.setAttribute("numResult", triangleNum);
            request.setAttribute("lst", list);

            request.setAttribute("user", login);
            // определение пути к main.jsp
            page = ConfigurationManager.getProperty("path.page.main");
        } else {
            request.setAttribute("errorLoginPassMessage",
                    MessageManager.getProperty("message.loginerror"));
            page = ConfigurationManager.getProperty("path.page.login");
        }
        return page;
    }
}