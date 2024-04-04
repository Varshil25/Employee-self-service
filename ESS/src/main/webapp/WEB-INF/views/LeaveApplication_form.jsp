<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@include file="./base.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<style>
hr {
	border: none;
	height: 1px; /* Adjust the height as needed */
	background-color: black; /* Color of the line */
}
</style>
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

	<div class="container mt-4">
		<div class="row">
			<div class="col-md-8 offset-md-2 ">
				<h2 class="text-center">Leave Application</h2>

				<form action="leave-module" method="post">

					<div class="form-group row">
						<label for="dateString"
							class="col-sm-3 col-form-label font-weight-bold">Application
							Date</label>
						<div class="col-sm-9">
							<input id="dateString" class="form-control" type="date"
								name="dateString">
						</div>
					</div>

					<div class="form-group row">
						<label for="startDate"
							class="col-sm-3 col-form-label font-weight-bold">Consideration
							In Terms Of</label>

						<div class="col-sm-9">
							<select id="dayType" class="form-control" name="leavetime">
								<option value="both">Both</option>
								<option value="fullDay">Full Day</option>
								<option value="halfDay">Half Day</option>
								<option value="hourly">Hourly</option>
							</select>
						</div>
					</div>

					<div class="form-group row">
						<label for="date" class="col-sm-3 col-form-label font-weight-bold">From</label>
						<div class="col-sm-6">
							<input id="date" class="form-control" type="date"
								name="fromDateString" required="required">
						</div>
						<div class="col-sm-3">
							<select id="dayType" class="form-control" name="fromdayType">
								<option value="fullDay">Full Day</option>
								<option value="halfDay">Half Day</option>
							</select>
						</div>
					</div>

					<div class="form-group row">
						<label for="date" class="col-sm-3 col-form-label font-weight-bold">To</label>
						<div class="col-sm-6">
							<input id="date" class="form-control" type="date"
								name="toDateString" required="required">
						</div>
						<div class="col-sm-3">
							<select id="dayType" class="form-control" name="todayType">
								<option value="fullDay">Full Day</option>
								<option value="halfDay">Half Day</option>
							</select>
						</div>
					</div>

					<div class="form-group row">
						<label for="reason"
							class="col-sm-3 col-form-label font-weight-bold">Applied
							Duration</label>
						<div class="col-sm-9">
							<input id="appliedDuration" class="form-control" type="text"
								name="appliedDuration">
						</div>
					</div>

					<div class="form-group row">
						<label for="reason"
							class="col-sm-3 col-form-label font-weight-bold">Posted
							Duration</label>
						<div class="col-sm-9">
							<input id="postedDuration" class="form-control" type="text"
								name="postedDuration">
						</div>
					</div>



					<hr style="font-weight: bold;">

					<div class="form-group row">
						<label class="col-sm-3 col-form-label font-weight-bold">Leave
							Type</label>
						<div class="col-sm-9">
							<select id="leaveType" class="form-control" name="leaveType">
								<option value="01-Previlege Leave">01-Previlege Leave</option>
								<option value="02-Tour Leave">02-Tour Leave</option>
								<option value="03-C Off Leave">03-C Off Leave</option>
								<option value="ML-Meeting">ML-Meeting</option>
								<option value="PT-Paternity Leave">PT-Paternity Leave</option>
								<option value="SL-Short Leave">SL-Short Leave</option>
							</select>
						</div>
					</div>

					<div class="form-group row">
						<label for="reason"
							class="col-sm-3 col-form-label font-weight-bold">Current
							Balance</label>
						<div class="col-sm-9">
							<input id="reason" class="form-control" type="text"
								name="balance">
						</div>
					</div>

					<h5 class="font-weight-light font-italic text-center"
						style="font-size: 16px; margin-bottom: 0; margin-top: 30px;">Reason
						And Contact Info</h5>
					<hr style="font-weight: bold; margin-top: 0">


					<div class="form-group row">
						<label for="reason"
							class="col-sm-3 col-form-label font-weight-bold">Reason</label>
						<div class="col-sm-9">
							<input id="reason" class="form-control" type="text" name="reason"
								required="required">
						</div>
					</div>

					<div class="form-group row">
						<label for="reason"
							class="col-sm-3 col-form-label font-weight-bold">Address</label>
						<div class="col-sm-9">
							<input id="reason" class="form-control" type="text"
								name="Address">
						</div>
					</div>

					<div class="form-group row">
						<label for="reason"
							class="col-sm-3 col-form-label font-weight-bold">Contact
							Number</label>
						<div class="col-sm-9">
							<input id="reason" class="form-control" type="number"
								name="number">
						</div>
					</div>

					<div class="form-group text-center">
						<a href="javascript:history.back()" class="btn btn-outline-danger">Back</a>
						<button type="submit" class="btn btn-outline-success">Apply
							Leave</button>
					</div>


				</form>
			</div>
		</div>
	</div>
</body>
</html>