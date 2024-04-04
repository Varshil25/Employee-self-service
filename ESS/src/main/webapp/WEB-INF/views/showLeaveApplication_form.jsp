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

	<div class="container-fluid mt-2">
		<div class="row">
			<div class="col-md-12 ">
				<h2 class="text-center">-- Applied Leave List --</h2>
				<div class="table-responsive">
					<table class="table">
						<thead class="thead-dark">
							<tr>
								<th scope="col">Id</th>
								<th scope="col">Application Date</th>
								<th scope="col">Consideration In Terms Of</th>
								<th scope="col">From</th>
								<th scope="col">From Date(Type Of Leave)</th>
								<th scope="col">To</th>
								<th scope="col">To Date(Type Of Leave)</th>
								<th scope="col">Applied Duration</th>
								<th scope="col">Posted Duration</th>
								<th scope="col">Leave Type</th>
								<th scope="col">Current Balance</th>
								<th scope="col">Reason</th>
								<th scope="col">Address</th>
								<th scope="col">Contact Number</th>
								<th scope="col">Status</th>
								<th scope="col">Update Status</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${leaveApplications}" var="la">
								<tr>
									<td>${la.id}</td>
									<td>${la.date}</td>
									<td>${la.leavetime}</td>
									<td>${la.fromDate}</td>
									<td>${la.fromdayType}</td>
									<td>${la.toDate}</td>
									<td>${la.todayType}</td>
									<td>${la.appliedDuration}</td>
									<td>${la.postedDuration}</td>
									<td>${la.leaveType}</td>
									<td>${la.balance}</td>
									<td>${la.reason}</td>
									<td>${la.address}</td>
									<td>${la.number}</td>
									<td><c:choose>
											<c:when test="${la.status eq 'Pending'}">
												<a href="approveLeave/${la.id}" class="btn btn-outline">
													<i class="fas fa-check text-success float-right"></i>
												</a>
												<a href="rejectLeave/${la.id}" class="btn btn-outline"><i
													class="fas fa-times text-danger float-right"></i></a>
											</c:when>
											<c:otherwise>
           											 ${la.status}
       										</c:otherwise>
										</c:choose></td>
									<td>
										<form action="updateLeaveStatus/${la.id}">
											<select name="status" onchange="this.form.submit()">
												<option value="Pending"
													${la.status eq 'Pending' ? 'selected' : ''}>Pending</option>
												<option value="Approved"
													${la.status eq 'Approved' ? 'selected' : ''}>Approved</option>
												<option value="Rejected"
													${la.status eq 'Rejected' ? 'selected' : ''}>Rejected</option>
											</select> <input type="hidden" name="_method" value="PATCH"> <input
												type="hidden" name="_csrf" value="${_csrf.token}">
										</form>
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