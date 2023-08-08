<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Create Bank Transaction</title>
	<!-- Bootstrap CSS -->
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<h1 class="text-center my-3">Create a New Transaction</h1>
		<form method="POST" action="/bankTransactions/transaction" class="mb-4">
			<div class="form-group">
				<label for="fromAccountId">From Account ID</label>
				<input type="text" id="fromAccountId" name="fromAccountId" class="form-control">
			</div>

			<div class="form-group">
				<label for="toAccountId">To Account ID</label>
				<input type="text" id="toAccountId" name="toAccountId" class="form-control">
			</div>

			<div class="form-group">
				<label for="amount">Amount</label>
				<input type="text" id="amount" name="amount" class="form-control" />
			</div>
			<div class="form-group">
				<label for="transactionType">Transaction Type</label>
				<select id="transactionType" name="transactionType" class="form-control">
					<option value="DEPOSIT">Deposit</option>
					<option value="WITHDRAWAL">Withdrawal</option>
					<option value="TRANSFER">Transfer</option>
				</select>
			</div>
			<button type="submit" class="btn btn-primary">Create Transaction</button>
		</form>

		<h2 class="text-center my-3">Existing Transactions</h2>
		<table class="table table-striped">
			<thead class="thead-dark">
				<tr>
					<th>Transaction ID</th>
					<th>From Account ID</th>
					<th>To Account ID</th>
					<th>Amount</th>
					<th>Transaction Type</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${transactions}" var="transaction">
					<tr>
						<td>${transaction.bankTransactionId}</td>
						<td>${transaction.bankTransactionFromAccount.accountId}</td>
						<td>${transaction.bankTransactionToAccount.accountId}</td>
						<td>${transaction.transactionAmount}</td>
						<td>${transaction.transactionType}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

	<!-- Bootstrap JS -->
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>
