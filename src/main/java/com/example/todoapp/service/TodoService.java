package com.example.todoapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.todoapp.entity.Todo;
import com.example.todoapp.repository.TodoRepo;

@Service
public class TodoService {
	
	@Autowired
	private TodoRepo TR;
	
	public List <Todo> getAllTodo()
	{
		return TR.findAll();
	}
	
	public Todo addTodo(Todo todo)
	{
	  	return TR.save(todo);
	}
	
	public void deleteTodo(Long id)
	{
		TR.deleteById(id);
	}
	public Todo changeTodoStatus(Long id,boolean completed)
	{
		Todo todo=TR.findById(id)
				.orElseThrow(()->new RuntimeException("Todo not found with id : "+id));
		todo.setCompleted(completed);
		return TR.save(todo);
	}
	

}
