<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Customer Form</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
    <div class="container">
        <!-- Including Navbar -->
        <jsp:include page="navbar.jsp" />
    </div>

    <div class="container">
        <h1>Create a New Customer</h1>
        <form action="/customers/save" method="post">
            <div class="form-group">
                <label for="customerName">Customer Name:</label>
                <input type="text" name="customerName" id="customerName" class="form-control" required>
            </div>
            <div class="form-group">
                <label for="customerGender">Gender:</label>
                <input type="text" name="customerGender" id="customerGender" class="form-control" required>
            </div>
            <div class="form-group">
                <label for="customerDob">Date of Birth:</label>
                <input type="date" name="customerDob" id="customerDob" class="form-control" required>
            </div>
            <div class="form-group">
                <label for="customerMobileNum">Mobile Number:</label>
                <input type="text" name="customerMobileNum" id="customerMobileNum" class="form-control" required>
            </div>
            <div class="form-group">
                <label for="realId">Real ID:</label>
                <input type="text" name="realId" id="realId" class="form-control" required>
            </div>
            <!-- Address details -->
            <div class="form-group">
                <label for="addressLine1">Address Line 1:</label>
                <input type="text" name="customerAddress.addressLine1" id="addressLine1" class="form-control" required>
            </div>
            <div class="form-group">
                <label for="addressLine2">Address Line 2:</label>
                <input type="text" name="customerAddress.addressLine2" id="addressLine2" class="form-control">
            </div>
            <div class="form-group">
                <label for="city">City:</label>
                <input type="text" name="customerAddress.city" id="city" class="form-control" required>
            </div>
            <div class="form-group">
                <label for="state">State:</label>
                <input type="text" name="customerAddress.state" id="state" class="form-control" required>
            </div>
            <div class="form-group">
                <label for="county">County:</label>
                <input type="text" name="customerAddress.county" id="county" class="form-control" required>
            </div>
            <div class="form-group">
                <label for="zipCode">Zip Code:</label>
                <input type="text" name="customerAddress.zipCode" id="zipCode" class="form-control" required>
            </div>

            <div class="form-group">
                <label for="userId">User ID</label>
                <input type="text" name="user.userId" id="userId" value="${user.userId}" class="form-control" readonly>
            </div>

            <input type="submit" value="Create Customer" class="btn btn-primary">
        </form>

        <h2>All Customers</h2>
        <table class="table">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Gender</th>
                    <th>Date of Birth</th>
                    <th>Mobile Number</th>      
                    <th>Address</th>
                    <th>Real ID</th>
                    <th>UserId</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${customers}" var="customer">
                    <tr>
                        <td>${customer.customerId}</td>
                        <td>${customer.customerName}</td>
                        <td>${customer.customerGender}</td>
                        <td>${customer.customerDob}</td>
                        <td>${customer.customerMobileNum}</td>
                        <td>${customer.customerAddress.addressLine1}, ${customer.customerAddress.addressLine2}, ${customer.customerAddress.city}, ${customer.customerAddress.state}, ${customer.customerAddress.county}, ${customer.customerAddress.zipCode}</td>
                        <td>${customer.realId}</td>
                        <td>${customer.user.userId}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>
