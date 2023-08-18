<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Banking App</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <style>
        .hero-section {
            background-color: #007BFF;
            color: white;
            padding: 100px 0;
            text-align: center;
        }
        .feature-icon {
            font-size: 50px;
            margin-bottom: 20px;
        }
    </style>
</head>
<body>
    
<div class="container">
    <!-- Including Navbar -->
    <jsp:include page="navbar.jsp" />
    <br>
    <!-- Hero Section -->
    <div class="hero-section">
        <h1>Welcome to Online Banking</h1>
        <p>Your trusted partner for all financial needs</p>
        <a href="/users/login">
            <button class="btn btn-light mt-3">Get Started</button>
        </a>
        
    </div>

    <!-- Features Section -->
    <div class="container mt-5">
        <div class="row">
            <div class="col-md-4 text-center">
                <div class="feature-icon">
                    <i class="fas fa-shield-alt"></i>
                </div>
                <h3>Secure Transactions</h3>
                <p>We ensure all your transactions are encrypted and secure.</p>
            </div>
            <div class="col-md-4 text-center">
                <div class="feature-icon">
                    <i class="fas fa-mobile-alt"></i>
                </div>
                <h3>Mobile Banking</h3>
                <p>Manage your finances on the go with our mobile banking services.</p>
            </div>
            <div class="col-md-4 text-center">
                <div class="feature-icon">
                    <i class="fas fa-users"></i>
                </div>
                <h3>24/7 Support</h3>
                <p>Our support team is always ready to help, anytime, anywhere.</p>
            </div>
        </div>
    </div>

</div>

<!-- Bootstrap JS, jQuery, and FontAwesome -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<script src="https://kit.fontawesome.com/a076d05399.js"></script>

</body>
</html>
