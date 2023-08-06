<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Create Account</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
    <div class="container mt-4">
        <h1>Create Account</h1>
        <form action="/accounts/save/${customer.customerId}" method="post">
            <input type="hidden" name="customerId" value="${customer.customerId}" />
            <div class="form-group">
                <label>Customer ID:</label>
                <p>${customer.customerId}</p>
            </div>
            <div>
                <label>Customer Name:</label>
                <p>${customer.customerName}</p>
            </div>
            <div class="form-group">
                <label for="accountType">Account Type:</label>
                <select id="accountType" name="accountType" class="form-control">
                    <option value="SAVING">Saving Account</option>
                    <option value="CHECKING">Checking Account</option>
                    <option value="LOAN">Loan Account</option>
                </select>
            </div>

            <div class="form-group">
                <label for="accountDateOpen">Date of Opening (YYYY-MM-DD):</label>
                <input type="date" id="accountDateOpen" name="accountDateOpen" class="form-control" required>
            </div>

            <div class="form-group">
                <label for="accountBalance">Balance:</label>
                <input type="number" id="accountBalance" name="accountBalance" class="form-control" required>
            </div>

            <button type="submit" class="btn btn-primary">Create Account</button>
        </form>
        <br>
        <div id="message" class="alert alert-success">${account}</div>
        <br>
        <h2>All Accounts</h2>
        <table class="table table-bordered">
            <tr>
                <th>Customer ID</th>
                <th>Customer Name</th>
                <th>Account ID</th>
                <th>Type</th>
                <th>Date of Opening</th>
                <th>Balance</th>
            </tr>
            <c:forEach var="account" items="${accounts}">
                <tr>
                    <td>${account.accountCustomer.customerId}</td>
                    <td>${account.accountCustomer.customerName}</td>
                    <td>${account.accountId}</td>
                    <td>${account.accountType}</td>
                    <td>${account.accountDateOpen}</td>
                    <td>${account.accountBalance}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>
