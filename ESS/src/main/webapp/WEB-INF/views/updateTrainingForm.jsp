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
				class="fas fa-users"></i> Employee Self Service (Admin Panel)
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


	<div class="container" style="padding-top: 80px;">
		<div class="row ">
			<div class="col-md-8 offset-md-2">
				<h2 class="text-center" style="font-weight: bolder;">Update
					Training Module</h2>
				<form action="${pageContext.request.contextPath }/training-module"
					method="post" class="pt-3">

					<input type="text" value="${tr.id }" hidden="" name="id" />
					<div class="form-group">
						<label class="font-weight-bold">Name of Training </label> <input
							type="text" class="form-control" id="trName" name="trainingName"
							aria-describedby="emailHelp" placeholder="Enter Training Name"
							value="${tr.trainingName }">
					</div>

					<div class="form-group">
						<label class="font-weight-bold">Duration of Training </label> <input
							type="text" class="form-control" id="trDuration" name="duration"
							aria-describedby="emailHelp"
							placeholder="Duration of Training in MM" value="${tr.duration }">
					</div>

					<div class="form-group row">
						<label for="startDate"
							class="col-sm-3 col-form-label font-weight-bold">Start
							Date</label>
						<div class="col-sm-9">
							<input id="startDate" class="form-control" type="date"
								name="startDate" value="${tr.startDate }">
						</div>
					</div>

					<div class="form-group row">
						<label for="endDate"
							class="col-sm-3 col-form-label font-weight-bold">End Date</label>
						<div class="col-sm-9">
							<input id="endDate" class="form-control" type="date"
								name="endDate" value="${tr.endDate }">
						</div>
					</div>

					<div class="form-group row">
						<label for="mode" class="col-sm-3 col-form-label font-weight-bold">Mode</label>
						<div class="col-sm-9">
							<div class="form-check form-check-inline">
								<input class="form-check-input" type="radio" name="mode"
									id="online" value="Online"
									<c:if test="${tr.mode == 'Online' }"> checked </c:if>>
								<label class="form-check-label" for="online">Online</label>
							</div>
							<div class="form-check form-check-inline">
								<input class="form-check-input" type="radio" name="mode"
									id="offline" value="Offline"
									<c:if test="${tr.mode == 'Offline' }"> checked </c:if>>
								<label class="form-check-label" for="offline">Offline</label>
							</div>
						</div>
					</div>

					<div class="form-group">
						<label class="font-weight-bold">Required Skills</label> <input
							type="text" class="form-control" name="skillsNeeded"
							id="trSkills" aria-describedby="emailHelp"
							placeholder="Enter Skills.." value="${tr.skillsNeeded }">
					</div>

					<div class="form-group">
						<label class="font-weight-bold">Objective Of Training</label>
						<textarea rows="3" name="trainingObjective" class="form-control"
							placeholder="Enter Training ViewPoint">${tr.trainingObjective }</textarea>
					</div>

					<div class="form-group">
						<label class="font-weight-bold">Location</label> <input
							type="text" class="form-control" name="location" id="trSkills"
							aria-describedby="emailHelp" placeholder="Enter Location"
							value="${tr.location }">
					</div>

					<div class="form-group">
						<label class="font-weight-bold">Conducted By</label> <input
							type="text" class="form-control" name="industryExpertName"
							id="trSkills" aria-describedby="emailHelp"
							placeholder="Enter Name" value="${tr.industryExpertName }">
					</div>

					<div class="form-group text-center">
						<a href="javascript:history.back()" class="btn btn-outline-danger">Back</a>
						<button type="submit" class="btn btn-outline-success">Update</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>