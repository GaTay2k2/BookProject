/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import Model.Book;
import Utils.JDBCUtils;
import java.util.ArrayList;

/**
 *
 * @author THANG
 */
public class BookDAOimpl implements BookDAO{
    private static final String INSERT_TODOS_SQL = "INSERT INTO book"
			+ "  (title, author, category, sold) VALUES " + " (?, ?, ?, ?);";

	private static final String SELECT_TODO_BY_ID = "select * from book where id =?;";
	private static final String SELECT_ALL_TODOS = "select * from book;";
	private static final String DELETE_TODO_BY_ID = "delete from book where id = ?;";
	private static final String UPDATE_TODO = "update book set title = ?, author= ?, category =?, sold =? where id = ?;";

	public BookDAOimpl() {
	}

	@Override
	public void insertTodo(Book todo) throws SQLException {
		System.out.println(INSERT_TODOS_SQL);
		// try-with-resource statement will auto close the connection.
		try (Connection connection = JDBCUtils.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_TODOS_SQL)) {
			preparedStatement.setString(1, todo.getTitle());
			preparedStatement.setString(2, todo.getAuthor());
			preparedStatement.setString(3, todo.getCategory());
			preparedStatement.setInt(4, todo.getSold());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException exception) {
			JDBCUtils.printSQLException(exception);
		}
	}

	@Override
	public Book selectTodo(long todoId) {
		Book todo = null;
		// Step 1: Establishing a Connection
		try (Connection connection = JDBCUtils.getConnection();
				// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_TODO_BY_ID);) {
			preparedStatement.setLong(1, todoId);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				long id = rs.getLong("id");
				String title = rs.getString("title");
				String author = rs.getString("author");
				String category = rs.getString("category");
				int sold = rs.getInt("sold");
				todo = new Book(id, title, author, category, sold);
			}
		} catch (SQLException exception) {
			JDBCUtils.printSQLException(exception);
		}
		return todo;
	}

	@Override
	public List<Book> selectAllTodos() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<Book> todos = new ArrayList<>();

		// Step 1: Establishing a Connection
		try (Connection connection = JDBCUtils.getConnection();

			// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_TODOS);) {
			//System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				long id = rs.getLong("id");
				String title = rs.getString("title");
				String author = rs.getString("author");
				String category = rs.getString("category");
				int sold = rs.getInt("sold");
				todos.add(new Book(id, title, author, category, sold));
			}
		} catch (SQLException exception) {
			JDBCUtils.printSQLException(exception);
		}
		return todos;
	}

	@Override
	public boolean deleteTodo(int id) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = JDBCUtils.getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_TODO_BY_ID);) {
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}

	@Override
	public boolean updateTodo(Book todo) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = JDBCUtils.getConnection();
			PreparedStatement statement = connection.prepareStatement(UPDATE_TODO);) {
			statement.setString(1, todo.getTitle());
			statement.setString(2, todo.getAuthor());
			statement.setString(3, todo.getCategory());
			statement.setInt(5, todo.getSold());
			statement.setLong(6, todo.getId());
			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}
}
