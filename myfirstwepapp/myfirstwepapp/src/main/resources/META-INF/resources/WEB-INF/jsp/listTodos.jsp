<!doctype html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">
    <title>List Todos Page</title>
</head>
<body>

<div class="container">
    <div><h1>Your Todos</h1></div>
        <table class="table">
            <thead>
            <tr>
                <th>ID</th>
                <th>Description</th>
                <th>Target Date</th>
                <th>Is Done</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${todos}" var="todos">
                <tr>
                    <td>${todos.id}</td>
                    <td>${todos.description}</td>
                    <td>${todos.targetDate}</td>
                    <td>${todos.done}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    <a href="add-todo" class="btn btn-success">Add Todo</a>
</div>
    <script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
    <script src="webjars/jquery/3.6.0/jquery.min.js"></script>
</body>
</html>