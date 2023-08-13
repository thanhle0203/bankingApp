<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Banking App</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
    
<div class="container">
    <!-- Navbar -->
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand" href="#">BankingApp</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link" href="/customers">Customer</a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link" href="/accounts">Account</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/transactions">Transaction</a>
                </li>
            </ul>
        </div>
    </nav>

    <!-- Login Component -->
    <div class="mt-5">
        <h3>Login</h3>
        <form action="loginEndpoint" method="post">
            <!-- Hidden roleId input -->
            <input type="hidden" name="roleId" value="2">
            <!-- <div class="form-group">
                <label for="email">Email:</label>
                <input type="email" class="form-control" id="email" name="email" required>
            </div> -->
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
</div>

<!-- Bootstrap JS and jQuery -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

</body>
</html>
