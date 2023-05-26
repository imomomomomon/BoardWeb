package com.example.boardweb.controller.board;

import com.example.boardweb.controller.Controller;
import com.example.boardweb.service.BoardListService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class CategoryController extends Controller {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        List<Object> list = BoardListService.getInst().getCategoryList();
        throwingString(response,list.toString());
    }
}
