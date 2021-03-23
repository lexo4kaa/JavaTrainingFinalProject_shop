package com.example.final_project_shop.command;

import javax.servlet.http.HttpServletRequest;
public interface ActionCommand {
    String execute(HttpServletRequest request);
}
