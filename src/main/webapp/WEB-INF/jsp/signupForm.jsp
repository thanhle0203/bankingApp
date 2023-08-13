<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Sign Up</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
    <div class="container mt-5">
        <!-- Navigation Bar -->
        <nav class="navbar navbar-expand-lg navbar-light bg-light mb-5">
            <a class="navbar-brand" href="#">BankingApp</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a class="nav-link" href="#">Account</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Transaction</a>
                    </li>
                </ul>
            </div>
        </nav>

        <!-- User Signup Form -->
        <h1>Create a New User</h1>
        <form action="/users/save" method="post">
            <div class="form-group">
                <label for="userName">Username:</label>
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
            <input type="submit" value="Sign Up" class="btn btn-primary">
        </form>
        <div class="mt-3">
            <p>Have an account? <a href="/users/login">Login</a></p>
        </div> 
        <!-- Users List -->
        <div class="mt-5">
            <h2>All Users</h2>
            <table class="table table-striped">
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
    </div>

    <!-- Bootstrap JS and jQuery -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>
