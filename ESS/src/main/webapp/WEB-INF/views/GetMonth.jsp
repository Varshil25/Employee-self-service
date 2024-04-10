<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Bootstrap Form Example</title>
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	rel="stylesheet">
<style>
label {
	font-size: 1rem;
}

input, label {
	margin: 0.4rem 0;
}
</style>
</head>
<body>

	<div class="container">
		<form action="ShowAttendance/<c:out value="${userId}"></c:out>">
			<div class="form-group">
				<label for="start">Start month:</label> <input type="month"
					class="form-control" id="start" name="month" min="2024-03"
					value="2024-03">
			</div>
			<button type="submit" class="btn btn-primary">Submit</button>
			<a href="javascript:history.back()" class="btn btn-outline-danger">Back</a>
		</form>
	</div>

	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
