<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@include file="./base.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
</head>
<body>
	<div class="container-fluid p-0">
		<nav class="navbar navbar-light" style="background: #1d1b31">
			<a class="navbar-brand text-light" href="#"> <i
				class="fas fa-users"></i> Employee Self Service
			</a>

			<form action="logout" method="post">
				<div class="form-inline my-2 my-lg-0">
					<i class="fas fa-user text-light mr-sm-4"></i>

					<button onclick="logout()"
						class="btn btn-outline-success my-2 my-sm-0" type="submit">
						<i class="fas fa-sign-out-alt"></i> Logout
					</button>
				</div>
			</form>
		</nav>
	</div>


	<div class="container mt-3">
		<div class="row ">
			<div class="col-md-8 offset-md-2">
				<h2 class="text-center" style="font-weight: bolder;">Employee
					Entry & Exit</h2>
				<form action="entry-exit" method="post" class="pt-3">
					<div class="form-group text-center">
						<a href="in" class="btn btn-outline-primary">PunchIn</a> <a
							href="out" class="btn btn-outline-success">PunchOut</a>
					</div>
					<div class="form-group text-center">
						<a href="attendance-show" class="btn btn-outline-dark">Show
							Attendance</a>
					</div>
					<div class="form-group text-center">
						<a href="javascript:history.back()" class="btn btn-outline-danger">Back</a>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>