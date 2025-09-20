package br.com.pedrolucas.todolist.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.pedrolucas.todolist.entity.Todo;

public interface TodoRepository extends JpaRepository<Todo, UUID>{
    
}
