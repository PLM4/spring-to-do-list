package br.com.pedrolucas.todolist.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.pedrolucas.todolist.entity.Todo;
import br.com.pedrolucas.todolist.service.TodoService;

@RestController
@RequestMapping("/todos")
public class TodoController {
    
    private TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }
    
    @PostMapping
    public List<Todo> create(@RequestBody Todo todo){
        return todoService.createTodo(todo);
    }

    @GetMapping
    public List<Todo> list(){
        return todoService.list();
    }

    @PutMapping
    public List<Todo> update(@RequestBody Todo todo){
        return todoService.updateTodo(todo);
    }

    @DeleteMapping("/{id}")
    public List<Todo> delete(@PathVariable("id") UUID id){
        return todoService.deleteTodo(id);
    }
}
