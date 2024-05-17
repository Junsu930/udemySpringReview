package com.in28minutes.springboot.myfirstwepapp.todo;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
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
    public String showNewTodoPage (ModelMap model){
        String username = (String)model.get("name");
        Todo todo = new Todo(0, username, "", LocalDate.now().plusYears(1),false);
        model.put("todo", todo);
        return "todo";
    }

    @RequestMapping(value = "add-todo", method = RequestMethod.POST)
    public String addNewTodo (ModelMap model, @Valid Todo todo, BindingResult result){
        if(result.hasErrors()){
            return "todo";
        }
        String username = (String)model.get("name");
        todoService.addTodo(username, todo.getDescription(),todo.getTargetDate(),false);

        return "redirect:list-todos";
    }

    @RequestMapping(value = "delete-todo", method = RequestMethod.GET)
    public String deleteTodo(@RequestParam("id") int id){
        // Delete
        todoService.deleteById(id);

        return "redirect:list-todos";
    }

    @RequestMapping(value = "update-todo", method = RequestMethod.POST)
    public String updateTodo (ModelMap model, @Valid Todo todo, BindingResult result){
        if(result.hasErrors()){
            return "todo";
        }
        String username = (String)model.get("name");
        todo.setUsername(username);
        todoService.updateTodo(todo);

        return "redirect:list-todos";
    }


    @RequestMapping(value = "update-todo")
    public String showUpdateTodoPage(@RequestParam("id") int id, ModelMap model){

        Todo todo = todoService.findById(id);
        model.addAttribute("todo", todo);
        return "todo";
    }

}
