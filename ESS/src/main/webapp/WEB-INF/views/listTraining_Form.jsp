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
	<%-- <%@include file="admindashboard.jsp"%> --%>
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

	<div class="container-fluid mt-3">
		<div class="row">
			<div class="col-md-12">
				<h1 class="text-center">-- Training Details List --</h1>
				<div class="table-responsive">
					<table class="table">
						<thead class="thead-dark">
							<tr>
								<th scope="col">Training Id</th>
								<th scope="col">Training Name</th>
								<th scope="col">Training Duration</th>
								<th scope="col">Start Date</th>
								<th scope="col">End Date</th>
								<th scope="col">Mode</th>
								<th scope="col">Skills</th>
								<th scope="col">Objective</th>
								<th scope="col">Location</th>
								<th scope="col">Expert Name</th>
								<th scope="col">Action</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${training}" var="tr">
								<tr>
									<td>${tr.id}</td>
									<td>${tr.trainingName}</td>
									<td>${tr.duration}</td>
									<td>${tr.startDate}</td>
									<td>${tr.endDate}</td>
									<td>${tr.mode}</td>
									<td>${tr.skillsNeeded}</td>
									<td>${tr.trainingObjective}</td>
									<td>${tr.location}</td>
									<td>${tr.industryExpertName}</td>
									<td><a href="deleteTraining/${tr.id}"><i
											class="fas fa-trash text-danger" style="font-size: 20px;"></i></a>
										<a href="updateTraining/${tr.id}"><i
											class="fas fa-pen-nib text-primary" style="font-size: 20px;"></i></a>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				<div class="container text-center">
					<a href="javascript:history.back()" class="btn btn-outline-danger">Back</a>
					<a href="add-training" class="btn btn-outline-success">Add Training Module</a>
				</div>
			</div>
		</div>
	</div>

</body>
</html>