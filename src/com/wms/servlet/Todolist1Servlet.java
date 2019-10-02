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
 * Servlet implementation class Todolist1Servlet
 */
@WebServlet("/Todolist1Servlet")
public class Todolist1Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Todolist1Servlet() {

		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String tname = request.getParameter("TasksName");
		String status = request.getParameter("Status");
		String prio = request.getParameter("Priority");
		String cmnt = request.getParameter("Comment");

		if (!(tname.equals("") || status.equals("") || prio.equals(""))) {

			if (status.equals("COMPLETE") || status.equals("NOT COMPLETE")) {

				if (prio.equals("HIGH") || prio.equals("MEDIUM") || prio.equals("LOW")) {

					ToDolist todolist = new ToDolist();

					todolist.setTasksName(tname);
					todolist.setStatus(status);
					todolist.setPriority(prio);
					todolist.setComment(cmnt);

					ITodolist list = new TodolistServices();
					list.addList(todolist);

				} else {

					request.setAttribute("error", "Invalid Priority.!");

				}

			} else {

				request.setAttribute("error", "Invalid Status.!");

			}

		} else {

			request.setAttribute("error", "Some details are empty.!");

		}

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/Customer/ToDolist.jsp");
		dispatcher.forward(request, response);

	}

}
