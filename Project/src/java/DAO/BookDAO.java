/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.Book;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author THANG
 */
public interface BookDAO {

    void insertTodo(Book todo) throws SQLException;

    Book selectTodo(long todoId);

    List<Book> selectAllTodos();

    boolean deleteTodo(int id) throws SQLException;

    boolean updateTodo(Book todo) throws SQLException;

}
