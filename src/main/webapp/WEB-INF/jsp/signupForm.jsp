<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User Form</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
    <div class="container">
        <h1>Create a New User</h1>
        <form action="/users/save" method="post">
            <div class="form-group">
                <label for="userName">User Name:</label>
                <input type="text" name="userName" id="userName" class="form-control" required>
            </div>
            <div class="form-group">
                <label for="password">Password:</label>
                <input type="password" name="password" id="password" class="form-control" required>
            </div>
            <div class="form-group">
                <label>Role:</label><br>
                <input type="radio" id="admin" name="role" value="ADMIN">
                <label for="admin">Admin</label><br>
                <input type="radio" id="user" name="role" value="USER">
                <label for="user">User</label>
            </div>
            <input type="submit" value="Create User" class="btn btn-primary">
        </form>

        <h2>All Users</h2>
        <table class="table">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Roles</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${users}" var="user">
                    <tr>
                        <td>${user.userId}</td>
                        <td>${user.userName}</td>
                        <td>
                            <c:forEach items="${user.roles}" var="role">
                                ${role.roleName}<br>
                            </c:forEach>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>
