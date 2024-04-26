package com.in28minutes.springboot.myfirstwepapp.todo;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService {
    private static List<Todo> todos = new ArrayList<Todo>();

    static {
        todos.add(new Todo(1, "junsu", "Learn AWS", LocalDate.now().plusYears(1), false));
        todos.add(new Todo(2, "junsu", "Learn React", LocalDate.now().plusYears(2), false));
        todos.add(new Todo(3, "junsu", "Learn OS", LocalDate.now().plusYears(3), false));
    }

    public List<Todo> findByUsername(String username){
        return todos;
    }
}
