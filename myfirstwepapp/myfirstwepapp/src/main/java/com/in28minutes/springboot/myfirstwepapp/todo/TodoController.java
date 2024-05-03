package com.in28minutes.springboot.myfirstwepapp.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
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

    @RequestMapping(value = "add-todo", method = RequestMethod.GET)
    public String showNewTodoPage (){
        return "todo";
    }

    @RequestMapping(value = "add-todo", method = RequestMethod.POST)
    public String addNewTodo (@RequestParam String description, ModelMap model){

        String username = (String)model.get("name");
        todoService.addTodo(username, description, LocalDate.now().plusYears(1),false);

        return "redirect:list-todos";
    }
}
