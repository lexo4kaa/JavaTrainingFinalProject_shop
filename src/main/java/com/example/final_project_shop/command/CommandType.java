package com.example.final_project_shop.command;

import com.example.final_project_shop.command.impl.FindAllUsersCommand;
import com.example.final_project_shop.command.impl.FindUsersByNicknameCommand;
import com.example.final_project_shop.command.impl.LoginCommand;
import com.example.final_project_shop.command.impl.LogoutCommand;

public enum CommandType {
    LOGIN {
        {
            this.command = new LoginCommand();
        }
    },
    LOGOUT {
        {
            this.command = new LogoutCommand();
        }
    },
    FIND_ALL_USERS {
        {
            this.command = new FindAllUsersCommand();
        }
    },
    FIND_USERS_BY_NICKNAME {
        {
            this.command = new FindUsersByNicknameCommand();
        }
    };
    ActionCommand command;
    public ActionCommand getCurrentCommand() {
        return command;
    }
}
