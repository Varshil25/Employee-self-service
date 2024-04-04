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
			<div class="col-md-8 offset-md-2">
				<h2 class="text-center">Add HoliDay</h2>

				<form action="holiday-module" method="post">
					<input type="text" name="holidayId" value="" hidden="">


					<div class="form-group">
						<label class="font-weight-bold">HoliDay Name </label> <input
							type="text" class="form-control" id="event" name="name"
							aria-describedby="emailHelp" placeholder="Enter Holiday Name">
					</div>


					<div class="form-group row">
						<label for="startDate"
							class="col-sm-3 col-form-label font-weight-bold">Start
							Date</label>
						<div class="col-sm-9">
							<input id="startDate" class="form-control" type="date"
								name="startDateString">
						</div>
					</div>

					<div class="form-group row">
						<label for="endDate"
							class="col-sm-3 col-form-label font-weight-bold">End Date</label>
						<div class="col-sm-9">
							<input id="endDate" class="form-control" type="date"
								name="endDateString">
						</div>
					</div>


					<div class="form-group text-center">
						<button type="submit" class="btn btn-outline-success">Add
							HoliDay</button>
					</div>
				</form>
			</div>
		</div>
	</div>

	<div class="container mt-4">
		<div class="row">
			<div class="col-md-8 offset-md-2">
				<h1 class="text-center">-- Holiday List --</h1>
				<div class="table-responsive">
					<table class="table">
						<thead class="thead-dark">
							<tr>
								<th scope="col">Sr.No.</th>
								<th scope="col">Holiday Name</th>
								<th scope="col">From</th>
								<th scope="col">TO</th>
								<th scope="col">Action</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${holiday}" var="holiday">
								<tr>
									<td>${holiday.id}</td>
									<td>${holiday.name}</td>
									<td>${holiday.startDate}</td>
									<td>${holiday.endDate}</td>

									<td><a href="deleteHoliday/${holiday.id}"><i
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