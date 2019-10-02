package com.wms.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wms.model.ToDolist;
import com.wms.service.ITodolist;
import com.wms.service.TodolistServices;

/**
 * Servlet implementation class UpdateToDo
 */
@WebServlet("/UpdateToDo")
public class UpdateToDo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateToDo() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ITodolist todo = new TodolistServices();

		boolean isInt2 = false;
		int id = 0;
		try {
			id = Integer.parseInt(request.getParameter("taskid"));
			isInt2 = true;
		} catch (Exception e) {
			isInt2 = false;
		}

		if (isInt2) {

			if (todo.isToDoAvailable(id)) {

				ToDolist todoacc = todo.getTodolistByID(id);

				request.setAttribute("todo", todoacc);
				RequestDispatcher dispatcher = getServletContext()
						.getRequestDispatcher("/WEB-INF/views/Customer/EditTodolist.jsp");
				dispatcher.forward(request, response);

			} else {

				request.setAttribute("error", "Invalid ToDo Item.!");
				RequestDispatcher dispatcher = getServletContext()
						.getRequestDispatcher("/WEB-INF/views/Customer/ToDolist.jsp");
				dispatcher.forward(request, response);

			}
		} else {

			request.setAttribute("error", "Invalid ToDo Item.!");
			RequestDispatcher dispatcher = getServletContext()
					.getRequestDispatcher("/WEB-INF/views/Customer/ToDolist.jsp");
			dispatcher.forward(request, response);

		}

	}

}
