<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <!-- Including Navbar -->
    <jsp:include page="navbar.jsp" />
    <br>

    <!-- Login Component -->
    <div class="mt-5">
        <h3>Login</h3>
        <form action="loginEndpoint" method="post">
            <!-- Hidden roleId input -->
            <input type="hidden" name="roleId" value="2">
            <div>
                <label for="userName">Username</label>
                <input type="text" class="form-control" id="userName" name="userName" required>
            </div>
            <div class="form-group">
                <label for="password">Password:</label>
                <input type="password" class="form-control" id="password" name="password" required>
            </div>
            <button type="submit" class="btn btn-primary">Login</button>
        </form>
    </div>

    <!-- Signup Component -->
    <div class="mt-5">
        <h4>New to BankingApp? <a href="/users/signup">Sign Up Now</a></h4>
    </div> 
</body>
</html>

