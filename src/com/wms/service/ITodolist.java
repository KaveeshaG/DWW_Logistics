package com.wms.service;

import java.util.ArrayList;

import com.wms.model.CustomerAccount;
import com.wms.model.ToDolist;

public interface ITodolist {
	
	
	public void addList(ToDolist todolist);
	public ArrayList<ToDolist> getList();
	public void todolistDeleteById(String itemNumber);
	public boolean isToDoAvailable(int toDoID);
	public ToDolist updateTodoById(int taskid,ToDolist todo);
	public ToDolist getTodolistByID(int TodolistID);
	public ArrayList<ToDolist>getToDolist();
	public ArrayList<ToDolist> searchToDoById(String txt);
	public ArrayList<ToDolist> searchToDoByStatus(String txt);
	public ArrayList<ToDolist> searchToDoByPriority(String txt);
	

}
