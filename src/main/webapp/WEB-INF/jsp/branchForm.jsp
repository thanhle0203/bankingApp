<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Branch Form</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
    <div class="container">
        <h1>Create a New Branch</h1>
        <form action="/branches/save" method="post">

            <div class="form-group">
                <label for="branchName">Branch Name:</label>
                <input type="text" name="branchName" id="branchName" class="form-control" required>
            </div>
            <div class="form-group">
                <label for="branchAddress.addressLine1">Address Line 1:</label>
                <input type="text" name="branchAddress.addressLine1" id="branchAddress.addressLine1" class="form-control" required>
            </div>
            <div class="form-group">
                <label for="branchAddress.addressLine2">Address Line 2:</label>
                <input type="text" name="branchAddress.addressLine2" id="branchAddress.addressLine2" class="form-control">
            </div>
            <div class="form-group">
                <label for="branchAddress.city">City:</label>
                <input type="text" name="branchAddress.city" id="branchAddress.city" class="form-control" required>
            </div>
            <div class="form-group">
                <label for="branchAddress.county">County:</label>
                <input type="text" name="branchAddress.county" id="branchAddress.county" class="form-control" required>
            </div>
            <div class="form-group">
                <label for="branchAddress.state">State:</label>
                <input type="text" name="branchAddress.state" id="branchAddress.state" class="form-control" required>
            </div>
            <div class="form-group">
                <label for="branchAddress.zipCode">Zip Code:</label>
                <input type="text" name="branchAddress.zipCode" id="branchAddress.zipCode" class="form-control" required>
            </div>
            <input type="submit" value="Create Branch" class="btn btn-primary">
        </form>
        <br> 
        <h2>All Branches</h2>
        <table class="table">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Address Line 1</th>
                    <th>Address Line 2</th>
                    <th>City</th>
                    <th>County</th>
                    <th>State</th>
                    <th>Zip Code</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${branches}" var="branch">
                    <tr>
                        <td>${branch.branchId}</td>
                        <td>${branch.branchName}</td>
                        <td>${branch.branchAddress.addressLine1}</td> 
                        <td>${branch.branchAddress.addressLine2}</td> 
                        <td>${branch.branchAddress.city}</td> 
                        <td>${branch.branchAddress.county}</td> 
                        <td>${branch.branchAddress.state}</td> 
                        <td>${branch.branchAddress.zipCode}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>
