package com.example.boardweb.component;

import com.example.boardweb.controller.Controller;
import com.example.boardweb.controller.board.*;
import com.example.boardweb.controller.login.LoginController;
import com.example.boardweb.controller.login.RegisterController;
import com.example.boardweb.controller.session.SessionController;

public class ControllerMapper {
    private ControllerMapper() {
    }
    private static ControllerMapper inst = null;
    public static ControllerMapper getInst() {
        if(inst == null) inst = new ControllerMapper();
        return inst;
    }

    public Controller getController(String name) {
        Controller bc = null;

        switch (name) {
            case "boradList":
                bc = new BoardListController();
                break;
            case "getPageBean":
                bc = new PagingController();
                break;
            case "category":
                bc = new CategoryController();
                break;
            case "getInfo":
                bc = new InfoController();
                break;
            case "updateInfo":
                bc = new UpdateController();
                break;
            case "getCntEmp":
                bc = new CntEmpController();
                break;
            case "getEmp":
                bc = new EmpathyController();
                break;
            case "insertInfo":
                bc = new InsertController();
                break;
            case "deleteInfo":
                bc = new DeleteController();
                break;
            case "checkLogin":
                bc = new LoginController();
                break;
            case "regUser":
                bc = new RegisterController();
                break;
            case "session":
                bc = new SessionController();
                break;
        }

        return bc;
    }
}
