package com.example.todoapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.todoapp.entity.Todo;
import com.example.todoapp.service.TodoService;

@Controller
@RequestMapping("/todos")
public class TodoController {

    @Autowired
    private TodoService TS;

    @GetMapping("/")
    public String getAllTodo(Model model) {
        List<Todo> t = TS.getAllTodo();
        model.addAttribute("todos", t);
        return "index";
    }

    @PostMapping("/add")
    public String addTodo(@RequestParam String title) {
        Todo todo = new Todo();
        todo.setTitle(title);
        TS.addTodo(todo);
        return "redirect:/todos/";
    }

    @GetMapping("/delete/{id}")
    public String deleteTodo(@PathVariable Long id) {
        TS.deleteTodo(id);
        return "redirect:/todos/";
    }

    @GetMapping("/status/{id}")
    public String changeStatus(@PathVariable Long id,
                               @RequestParam boolean completed) {
        TS.changeTodoStatus(id, completed);
        return "redirect:/todos/";
    }
}
