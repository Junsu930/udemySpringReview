package com.in28minutes.springboot.myfirstwepapp.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class TodoController {

    public TodoController(TodoService todoService){
        super();
        this.todoService = todoService;
    }

    @Autowired
    private TodoService todoService;

    // /list-todos
    @RequestMapping("list-todos")
    public String listAllTodos (ModelMap model){

        List<Todo> todos = todoService.findByUsername("junsu");
        model.put("todos", todos);

        return "listTodos";
    }

}
