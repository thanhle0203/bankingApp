<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Sign Up</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <h1 class="text-center">Sign Up</h1>
    <form action="signup" method="post">
        <!-- User Information -->
        <div class="form-group">
            <label for="userName">Username:</label>
            <input type="text" name="userName" class="form-control" required />
        </div>
        <div class="form-group">
            <label for="password">Password:</label>
            <input type="password" name="password" class="form-control" required />
        </div>
        
        <!-- Customer Information -->
        <div class="form-group">
            <label for="customerName">Customer Name:</label>
            <input type="text" name="customer.customerName" class="form-control" required />
        </div>
        <div class="form-group">
            <label for="customerGender">Gender:</label>
            <input type="text" name="customer.customerGender" class="form-control" required />
        </div>
        <div class="form-group">
            <label for="customerDob">Date of Birth:</label>
            <input type="date" name="customer.customerDob" class="form-control" required />
        </div>
        <div class="form-group">
            <label for="customerMobileNum">Mobile Number:</label>
            <input type="text" name="customer.customerMobileNum" class="form-control" required />
        </div>
        

        <!-- Address Fields -->
        <div class="form-group">
            <label for="customerAddress.addressLine1">Address Line 1:</label>
            <input type="text" name="customer.customerAddress.addressLine1" class="form-control" required />
        </div>
        <div class="form-group">
            <label for="customerAddress.addressLine2">Address Line 2:</label>
            <input type="text" name="customer.customerAddress.addressLine2" class="form-control" />
        </div>
        <div class="form-group">
            <label for="customerAddress.city">City:</label>
            <input type="text" name="customer.customerAddress.city" class="form-control" required />
        </div>
        <div class="form-group">
            <label for="customerAddress.state">State:</label>
            <input type="text" name="customer.customerAddress.state" class="form-control" required />
        </div>
        <div class="form-group">
            <label for="customerAddress.county">County:</label>
            <input type="text" name="customer.customerAddress.county" class="form-control" required />
        </div>
        <div class="form-group">
            <label for="customerAddress.zipCode">Zip Code:</label>
            <input type="text" name="customer.customerAddress.zipCode" class="form-control" required />
        </div>

        <div class="form-group">
            <label for="realId">Real ID:</label>
            <input type="text" name="customer.realId" class="form-control" required />
        </div>

        <button type="submit" class="btn btn-primary">Sign Up</button>
    </form>
    <a href="login" class="btn btn-link">Login</a>
</div>
</body>
</html>
