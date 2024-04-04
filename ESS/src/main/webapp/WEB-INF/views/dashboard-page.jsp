<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@page isELIgnored="false"%>
<%@include file="./base.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style type="text/css">
* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
	font-family: "Poppins", sans-serif;
}

.form {
	padding-left: 400px;
}
</style>
</head>
<body>
	<%@include file="admindashboard.jsp"%>

	<div class="form">
		<div class="container mt-3">
			<div class="row">
				<div class="col-md-6 offset-md-3">
					<h2 class="text-center">DashBoard</h2>
					
				</div>
			</div>
		</div>
	</div>

</body>
</html>