<%-- 
    Document   : book-form
    Created on : May 26, 2023, 9:35:46 PM
    Author     : THANG
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Management Application</title>

        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" 
              rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" 
              crossorigin="anonymous">

    </head>

</head>
<body>
    <header>
        <nav class="navbar navbar-expand-md navbar-dark"
             style="background-color: tomato">
            <div>
                <a href="https://www.javaguides.net" class="navbar-brand"> Book
                    App</a>
            </div>

            <ul class="navbar-nav">
                <li><a href="<%=request.getContextPath()%>/list"
                       class="nav-link">Books</a></li>
            </ul>

            <ul class="navbar-nav navbar-collapse justify-content-end">
                <li><a href="<%=request.getContextPath()%>/logout"
                       class="nav-link">Logout</a></li>
            </ul>
        </nav>
    </header>
    <div class="container col-md-5">
        <div class="card">
            <div class="card-body">
                <c:if test="${todo != null}">
                    <form action="update" method="post">
                    </c:if>
                    <c:if test="${todo == null}">
                        <form action="insert" method="post">
                    </c:if>

                        <caption>
                            <h2>
                                <c:if test="${todo != null}">
                                    Edit Book
                                </c:if>
                                <c:if test="${todo == null}">
                                    Add New Book
                                </c:if>
                            </h2>
                        </caption>

                        <c:if test="${todo != null}">
                            <input type="hidden" name="id" value="<c:out value='${todo.id}' />" />
                        </c:if>

                        <fieldset class="form-group">
                            <label>Book Title</label> <input type="text"
                                                             value="<c:out value='${todo.title}' />" class="form-control"
                                                             name="title" required="required" minlength="5">
                        </fieldset>

                        <fieldset class="form-group">
                            <label>Book Author</label> <input type="text"
                                                              value="<c:out value='${todo.author}' />" class="form-control"
                                                              name="description" minlength="5">
                        </fieldset>

                        <fieldset class="form-group">
                            <label>Book Category</label> <input type="text"
                                                              value="<c:out value='${todo.category}' />" class="form-control"
                                                              name="description" minlength="5">
                        </fieldset>
                        <fieldset class="form-group">
                            <label>Book sold</label> <input type="text"
                                                              value="<c:out value='${todo.sold}' />" class="form-control"
                                                              name="description" minlength="5">
                        </fieldset>

                        <button type="submit" class="btn btn-success">Save</button>
                    </form>
            </div>
        </div>
    </div>

    <jsp:include page="../common/footer.jsp"></jsp:include>
</body>
</html>
