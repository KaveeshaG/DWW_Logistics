package com.wms.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wms.model.CustomerAccount;
import com.wms.model.ToDolist;
import com.wms.service.CustomerServices;
import com.wms.service.ICustomer;
import com.wms.service.ITodolist;
import com.wms.service.TodolistServices;

/**
 * Servlet implementation class SearchToDo
 */
@WebServlet("/SearchToDo")
public class SearchToDo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchToDo() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String stype = request.getParameter("stype");
		String txt = request.getParameter("txt");
		String resp = "";

		if (!txt.equals("")) {

			if (stype.equals("1")) {

				ITodolist todo = new TodolistServices();
				ArrayList<ToDolist> todos = todo.searchToDoById(txt);
				for (ToDolist todolist : todos) {

					resp += "<tr>\r\n" + "				<th scope=\"row\">" + todolist.getTaskId() + "</th>\r\n"
							+ "				<th scope=\"row\">" + todolist.getTasksName() + "</th>\r\n"
							+ "				<th scope=\"row\">" + todolist.getStatus() + "</th>\r\n"
							+ "				<th scope=\"row\">" + todolist.getPriority() + "</th>\r\n"
							+ "				<th scope=\"row\">" + todolist.getComment() + "</th>\r\n"
							+ "				<td>\r\n"
							+ "					<form action=\"UpdateToDo\" method=\"POST\">\r\n"
							+ "						<input type=\"hidden\" value=\"" + todolist.getTaskId() + "\"\r\n"
							+ "							name=\"taskid\" />\r\n"
							+ "						<button type=\"submit\" class=\"btn btn-primary\">Update ToDo</button>\r\n"
							+ "					</form>\r\n" + "				</td>\r\n" + "				<td>\r\n"
							+ "					<form action=\"TodolistDeleteById\" method=\"POST\">\r\n"
							+ "						<input type=\"hidden\" name=\"listID\"\r\n"
							+ "							value=\"" + todolist.getTaskId() + "\">\r\n"
							+ "						<button type=\"submit\" class=\"btn btn-danger m-0\">delete\r\n"
							+ "							ToDoList</button>\r\n" + "					</form>\r\n"
							+ "				</td>\r\n" + "			</tr>";

				}

				response.getWriter().write(resp);

			} else if (stype.equals("2")) {

				ITodolist todo = new TodolistServices();
				ArrayList<ToDolist> todos = todo.searchToDoByStatus(txt);
				for (ToDolist todolist : todos) {

					resp += "<tr>\r\n" + "				<th scope=\"row\">" + todolist.getTaskId() + "</th>\r\n"
							+ "				<th scope=\"row\">" + todolist.getTasksName() + "</th>\r\n"
							+ "				<th scope=\"row\">" + todolist.getStatus() + "</th>\r\n"
							+ "				<th scope=\"row\">" + todolist.getPriority() + "</th>\r\n"
							+ "				<th scope=\"row\">" + todolist.getComment() + "</th>\r\n"
							+ "				<td>\r\n"
							+ "					<form action=\"UpdateToDo\" method=\"POST\">\r\n"
							+ "						<input type=\"hidden\" value=\"" + todolist.getTaskId() + "\"\r\n"
							+ "							name=\"taskid\" />\r\n"
							+ "						<button type=\"submit\" class=\"btn btn-primary\">Update ToDo</button>\r\n"
							+ "					</form>\r\n" + "				</td>\r\n" + "				<td>\r\n"
							+ "					<form action=\"TodolistDeleteById\" method=\"POST\">\r\n"
							+ "						<input type=\"hidden\" name=\"listID\"\r\n"
							+ "							value=\"" + todolist.getTaskId() + "\">\r\n"
							+ "						<button type=\"submit\" class=\"btn btn-danger m-0\">delete\r\n"
							+ "							ToDoList</button>\r\n" + "					</form>\r\n"
							+ "				</td>\r\n" + "			</tr>";

				}

				response.getWriter().write(resp);

			} else if (stype.equals("3")) {

				ITodolist todo = new TodolistServices();
				ArrayList<ToDolist> todos = todo.searchToDoByPriority(txt);
				for (ToDolist todolist : todos) {

					resp += "<tr>\r\n" + "				<th scope=\"row\">" + todolist.getTaskId() + "</th>\r\n"
							+ "				<th scope=\"row\">" + todolist.getTasksName() + "</th>\r\n"
							+ "				<th scope=\"row\">" + todolist.getStatus() + "</th>\r\n"
							+ "				<th scope=\"row\">" + todolist.getPriority() + "</th>\r\n"
							+ "				<th scope=\"row\">" + todolist.getComment() + "</th>\r\n"
							+ "				<td>\r\n"
							+ "					<form action=\"UpdateToDo\" method=\"POST\">\r\n"
							+ "						<input type=\"hidden\" value=\"" + todolist.getTaskId() + "\"\r\n"
							+ "							name=\"taskid\" />\r\n"
							+ "						<button type=\"submit\" class=\"btn btn-primary\">Update ToDo</button>\r\n"
							+ "					</form>\r\n" + "				</td>\r\n" + "				<td>\r\n"
							+ "					<form action=\"TodolistDeleteById\" method=\"POST\">\r\n"
							+ "						<input type=\"hidden\" name=\"listID\"\r\n"
							+ "							value=\"" + todolist.getTaskId() + "\">\r\n"
							+ "						<button type=\"submit\" class=\"btn btn-danger m-0\">delete\r\n"
							+ "							ToDoList</button>\r\n" + "					</form>\r\n"
							+ "				</td>\r\n" + "			</tr>";

				}

				response.getWriter().write(resp);

			} else {
				response.getWriter().write("1");
			}

		} else {

			response.getWriter().write("0");

		}

	}

}
