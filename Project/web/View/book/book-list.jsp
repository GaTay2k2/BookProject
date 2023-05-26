<%-- 
    Document   : book-list
    Created on : May 26, 2023, 9:35:56 PM
    Author     : THANG
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>User Management Application</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" 
            rel="stylesheet"integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" 
            crossorigin="anonymous">
</head>

</head>
<body>
	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: tomato">
			<div>
				<a href="https://www.javaguides.net" class="navbar-brand"> Todo
					App</a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">Todos</a></li>
			</ul>

			<ul class="navbar-nav navbar-collapse justify-content-end">
				<li><a href="<%=request.getContextPath()%>/logout"
					class="nav-link">Logout</a></li>
			</ul>
		</nav>
	</header>

	<div class="row">
		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

		<div class="container">
			<h3 class="text-center">List of Todos</h3>
			<hr>
			<div class="container text-left">

				<a href="<%=request.getContextPath()%>/new"
					class="btn btn-success">Add Book</a>
			</div>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>Title</th>
						<th>Author</th>
						<th>Category</th>
						<th>Sold</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="todo" items="${listTodo}">

						<tr>
							<td><c:out value="${todo.title}" /></td>
							<td><c:out value="${todo.author}" /></td>
							<td><c:out value="${todo.category}" /></td>
                                                        <td><c:out value="${todo.sold}" /></td>
							<td><a href="edit?id=<c:out value='${todo.id}' />">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="delete?id=<c:out value='${todo.id}' />">Delete</a></td>

							<!--  <td><button (click)="updateTodo(todo.id)" class="btn btn-success">Update</button>
          							<button (click)="deleteTodo(todo.id)" class="btn btn-warning">Delete</button></td> -->
						</tr>
					</c:forEach>
					<!-- } -->
				</tbody>

			</table>
		</div>
	</div>

	<jsp:include page="../common/footer.jsp"></jsp:include>
</body>
</html>
