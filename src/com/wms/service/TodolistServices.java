package com.wms.service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.wms.model.CustomerAccount;
import com.wms.model.ToDolist;
import com.wms.util.CommonConstants;
import com.wms.util.DBConnectionUtil;
import com.wms.util.QueryUtil;

public class TodolistServices implements ITodolist {
	public static final Logger log = Logger.getLogger(TodolistServices.class.getName());

	private static Connection connection;

	private static Statement statement;

	private static PreparedStatement ps;

	private static ResultSet rs;

	@Override
	public void addList(ToDolist todolist) {
		// TODO Auto-generated method stub

		try {

			connection = DBConnectionUtil.getDBConnection();

			ps = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_ADD_LIST_TABLE));
			connection.setAutoCommit(false);

			ps.setString(1, todolist.getTasksName());
			ps.setString(2, todolist.getStatus());
			ps.setString(3, todolist.getPriority());
			ps.setString(4, todolist.getComment());

			ps.execute();
			connection.commit();

		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		} finally {
			/*
			 * Close prepared statement and database connectivity at the end of transaction
			 */
			try {
				if (ps != null) {
					ps.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}

	}

	@Override
	public ArrayList<ToDolist> getList() {

		ArrayList<ToDolist> list = new ArrayList<ToDolist>();

		try {
			connection = DBConnectionUtil.getDBConnection();

			ps = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_TODOLIST_TABLE));
			rs = ps.executeQuery();

			while (rs.next()) {

				ToDolist todolist = new ToDolist();
				todolist.setTaskId(Integer.parseInt(rs.getString(1)));
				todolist.setTasksName(rs.getString(2));
				todolist.setStatus(rs.getString(3));
				todolist.setPriority(rs.getString(4));
				todolist.setComment(rs.getString(5));

				list.add(todolist);

			}

		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		} finally {
			/*
			 * Close prepared statement and database connectivity at the end of transaction
			 */
			try {
				if (ps != null) {
					ps.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}
		return list;

	}

	@Override
	public void todolistDeleteById(String itemNumber) {
		// TODO Auto-generated method stub
		try {

			connection = DBConnectionUtil.getDBConnection();

			ps = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_DELETE_FROM_TODOLIST));

			ps.setString(CommonConstants.COLUMN_INDEX_ONE, itemNumber);

			ps.execute();

		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		} finally {
			/*
			 * Close prepared statement and database connectivity at the end of transaction
			 */
			try {
				if (ps != null) {
					ps.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}
	}

	@Override
	public boolean isToDoAvailable(int toDoID) {

		try {
			connection = DBConnectionUtil.getDBConnection();
			ps = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_CHECK_TODO_AVAILABILITY));
			ps.setInt(1, toDoID);

			ResultSet rs = ps.executeQuery();

			return rs.next();

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			/*
			 * Close prepared statement and database connectivity at the end of transaction
			 */
			try {
				if (ps != null) {
					ps.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}

	}

	@Override
	public ToDolist getTodolistByID(int TodolistID) {

		return actionOnToDolist(TodolistID).get(0);
	}

	@Override
	public ArrayList<ToDolist> getToDolist() {

		return actionOnToDolist(0);
	}

	private ArrayList<ToDolist> actionOnToDolist(int TodolistID) {

		ArrayList<ToDolist> todoList = new ArrayList<ToDolist>();

		try {
			connection = DBConnectionUtil.getDBConnection();

			if (TodolistID == 0) {

				ps = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_TODOLIST_TABLE));
			}

			else {
				ps = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_TODOLIST_BY_ID));
				ps.setInt(CommonConstants.COLUMN_INDEX_ONE, TodolistID);
			}
			ResultSet resultSet = ps.executeQuery();

			while (resultSet.next()) {
				ToDolist todolist = new ToDolist();
				todolist.setTaskId(resultSet.getInt(1));
				todolist.setTasksName(resultSet.getString(2));
				todolist.setStatus(resultSet.getString(3));
				todolist.setPriority(resultSet.getString(4));
				todolist.setComment(resultSet.getString(5));

				todoList.add(todolist);
			}

		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		} finally {
			/*
			 * Close prepared statement and database connectivity at the end of transaction
			 */
			try {
				if (ps != null) {
					ps.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}

		return todoList;
	}

	@Override
	public ToDolist updateTodoById(int taskid, ToDolist todo) {
		if (taskid + "" != null && !((todo + "").isEmpty())) {

			try {
				connection = DBConnectionUtil.getDBConnection();
				ps = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_UPDATE_TODOLIST_ITEM_BY_ID));
				ps.setString(1, todo.getTasksName());
				ps.setString(2, todo.getStatus());
				ps.setString(3, todo.getPriority());
				ps.setString(4, todo.getComment());
				ps.setInt(5, todo.getTaskId());
				ps.executeUpdate();

			} catch (SQLException | SAXException | IOException | ParserConfigurationException
					| ClassNotFoundException e) {
				log.log(Level.SEVERE, e.getMessage());
			} finally {
				/*
				 * Close prepared statement and database connectivity at the end of transaction
				 */
				try {
					if (ps != null) {
						ps.close();
					}
					if (connection != null) {
						connection.close();
					}
				} catch (SQLException e) {
					log.log(Level.SEVERE, e.getMessage());
				}
			}
		}
		// Get the updated employee
		return getTodolistByID(taskid);

	}

	@Override
	public ArrayList<ToDolist> searchToDoById(String txt) {

		ArrayList<ToDolist> list = new ArrayList<ToDolist>();

		try {
			connection = DBConnectionUtil.getDBConnection();

			ps = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_SEARCH_TODO_BY_ID));
			ps.setString(1, txt);
			rs = ps.executeQuery();

			while (rs.next()) {

				ToDolist todolist = new ToDolist();
				todolist.setTaskId(Integer.parseInt(rs.getString(1)));
				todolist.setTasksName(rs.getString(2));
				todolist.setStatus(rs.getString(3));
				todolist.setPriority(rs.getString(4));
				todolist.setComment(rs.getString(5));

				list.add(todolist);

			}

		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		} finally {
			/*
			 * Close prepared statement and database connectivity at the end of transaction
			 */
			try {
				if (ps != null) {
					ps.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}
		return list;

	}

	@Override
	public ArrayList<ToDolist> searchToDoByStatus(String txt) {

		ArrayList<ToDolist> list = new ArrayList<ToDolist>();

		try {
			connection = DBConnectionUtil.getDBConnection();

			ps = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_SEARCH_TODO_BY_STATUS));
			ps.setString(1, txt + "%");
			rs = ps.executeQuery();

			while (rs.next()) {

				ToDolist todolist = new ToDolist();
				todolist.setTaskId(Integer.parseInt(rs.getString(1)));
				todolist.setTasksName(rs.getString(2));
				todolist.setStatus(rs.getString(3));
				todolist.setPriority(rs.getString(4));
				todolist.setComment(rs.getString(5));

				list.add(todolist);

			}

		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		} finally {
			/*
			 * Close prepared statement and database connectivity at the end of transaction
			 */
			try {
				if (ps != null) {
					ps.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}
		return list;
	}

	@Override
	public ArrayList<ToDolist> searchToDoByPriority(String txt) {

		ArrayList<ToDolist> list = new ArrayList<ToDolist>();

		try {
			connection = DBConnectionUtil.getDBConnection();

			ps = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_SEARCH_TODO_BY_PRIORITY));
			ps.setString(1, txt + "%");
			rs = ps.executeQuery();

			while (rs.next()) {

				ToDolist todolist = new ToDolist();
				todolist.setTaskId(Integer.parseInt(rs.getString(1)));
				todolist.setTasksName(rs.getString(2));
				todolist.setStatus(rs.getString(3));
				todolist.setPriority(rs.getString(4));
				todolist.setComment(rs.getString(5));

				list.add(todolist);

			}

		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		} finally {
			/*
			 * Close prepared statement and database connectivity at the end of transaction
			 */
			try {
				if (ps != null) {
					ps.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}
		return list;
	}

}
