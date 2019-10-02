package com.wms.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wms.model.CustomerAccount;
import com.wms.model.ToDolist;
import com.wms.service.ITodolist;
import com.wms.service.TodolistServices;

/**
 * Servlet implementation class EditTodoServlet
 */
@WebServlet("/EditTodoServlet")
public class EditTodoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditTodoServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String tname = request.getParameter("tname");
		String status = request.getParameter("tstatus");
		String prio = request.getParameter("tpriority");
		String cmnt = request.getParameter("tcomment");

		if (!(tname.equals("") || status.equals("") || prio.equals(""))) {

			if (status.equals("COMPLETE") || status.equals("NOT COMPLETE")) {

				if (prio.equals("HIGH") || prio.equals("MEDIUM") || prio.equals("LOW")) {

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

							ToDolist tod = new ToDolist();

							tod.setTaskId(id);
							tod.setTasksName(tname);
							tod.setStatus(status);
							tod.setPriority(prio);
							tod.setComment(cmnt);

							System.out.println("Updated");

							todo.updateTodoById(id, tod);
						} else {

							request.setAttribute("error", "Invalid ToDo Item.!");

						}
					} else {

						request.setAttribute("error", "Invalid ToDo Item.!");

					}
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
