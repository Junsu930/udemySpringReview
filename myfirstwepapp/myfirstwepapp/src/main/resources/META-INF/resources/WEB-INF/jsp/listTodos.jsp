<%@include file="common/header.jspf"%>
<%@include file="common/navigation.jspf"%>
<div class="container">
    <div><h1>Your Todos</h1></div>
        <table class="table">
            <thead>
            <tr>
                <th>Description</th>
                <th>Target Date</th>
                <th>Is Done</th>
                <th></th>
                <th></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${todos}" var="todos">
                <tr>
                    <td>${todos.description}</td>
                    <td>${todos.targetDate}</td>
                    <td>${todos.done}</td>
                    <td><a href="delete-todo?id=${todos.id}" class="btn btn-warning">Delete</a></td>
                    <td><a href="update-todo?id=${todos.id}" class="btn btn-success">Update</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    <a href="add-todo" class="btn btn-success">Add Todo</a>
</div>
<%@include file="common/footer.jspf"%>