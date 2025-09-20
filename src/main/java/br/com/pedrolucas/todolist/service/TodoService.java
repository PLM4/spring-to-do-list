package br.com.pedrolucas.todolist.service;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.pedrolucas.todolist.entity.Todo;
import br.com.pedrolucas.todolist.repository.TodoRepository;

@Service
public class TodoService {
    private TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
        
    }

    public List<Todo> createTodo(Todo todo){
        todoRepository.save(todo);
        return list();
    }

    public List<Todo> list(){
        Sort sort = Sort.by(Sort.Order.desc("priority")).and(Sort.by(Sort.Order.asc("title")));
        return todoRepository.findAll(sort);
    }
    
    public List<Todo> updateTodo(Todo todo ){
        todoRepository.save(todo);
        return list();
    }
    
    public List<Todo> deleteTodo(Long id){
        todoRepository.deleteById(id);
        return list();  
    }
}
