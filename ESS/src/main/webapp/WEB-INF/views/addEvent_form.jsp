<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@page isELIgnored="false"%>
<%@include file="./base.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



</head>
<body>

	<div class="container-fluid p-0">
		<nav class="navbar navbar-light" style="background: #1d1b31">
			<a class="navbar-brand text-light" href="#"> <i
				class="fas fa-users"></i> Employee Self Service (Admin Panel)
			</a>

			<form action="logout" method="post">
				<div class="form-inline">
					<i class="fas fa-user text-light mr-sm-4"></i>
					<button onclick="logout()"
						class="btn btn-outline-success my-2 my-sm-0" type="submit">
						<i class="fas fa-sign-out-alt"></i> Logout
					</button>
				</div>
			</form>
		</nav>
	</div>

	<div class="container mt-4">
		<div class="row">
			<div class="col-md-8 offset-md-2 ">
				<h2 class="text-center">Add Event</h2>

				<form action="event-form" method="post">



					<div class="form-group">
						<label class="font-weight-bold">Event Name </label> <input
							type="text" class="form-control" id="event" name="name"
							aria-describedby="emailHelp" placeholder="Enter Event Name">
					</div>

					<div class="form-group">
						<label for="date">Date </label> <input type="date"
							class="form-control" id="date" name="dateString">
					</div>

					<div class="form-group">
						<label for="time">Time </label> <input type="time"
							class="form-control" id="time" name="timeString">
					</div>

					<div class="form-group text-center">
						<button type="submit" class="btn btn-outline-success">Add
							Event</button>
					</div>
				</form>
			</div>
		</div>
	</div>

	<div class="container mt-2">
		<div class="row">
			<div class="col-md-8 offset-md-2">
				<h1 class="text-center">-- Event List --</h1>
				<div class="table-responsive">
					<table class="table">
						<thead class="thead-dark">
							<tr>
								<th scope="col">No.</th>
								<th scope="col">Event Name</th>
								<th scope="col">Date</th>
								<th scope="col">Time</th>
								<th scope="col">Action</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${event}" var="event">
								<tr>
									<td>${event.id}</td>
									<td>${event.name}</td>
									<td>${event.date}</td>
									<td>${event.time}</td>

									<td><a href="deleteEvent/${event.id}"><i
											class="fas fa-trash text-danger" style="font-size: 20px;"></i></a>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				<div class="container text-center">
					<a href="javascript:history.back()" class="btn btn-outline-danger">Back</a>
				</div>
			</div>
		</div>
	</div>

</body>
</html>