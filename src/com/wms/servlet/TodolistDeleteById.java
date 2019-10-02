package com.wms.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wms.service.CustomerServices;
import com.wms.service.ICustomer;
import com.wms.service.ITodolist;
import com.wms.service.TodolistServices;

/**
 * Servlet implementation class TodolistDeleteById
 */
@WebServlet("/TodolistDeleteById")
public class TodolistDeleteById extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TodolistDeleteById() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);

		ITodolist List = new TodolistServices();

		boolean isInt = false;
		int id = 0;
		try {
			id = Integer.parseInt(request.getParameter("listID"));
			isInt = true;
		} catch (Exception e) {
			isInt = false;
		}

		if (isInt) {

			if (List.isToDoAvailable(id)) {

				List.todolistDeleteById(request.getParameter("listID"));

				request.setAttribute("error", "ToDo Item Deleted.!");

			} else {

				request.setAttribute("error", "Invalid ToDo Item to delete.!");

			}

		} else {

			request.setAttribute("error", "Invalid ToDo Item to delete.!");

		}

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/Customer/ToDolist.jsp");
		dispatcher.forward(request, response);

	}

}
