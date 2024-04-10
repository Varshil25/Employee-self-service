<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Show Attendance</title>
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	rel="stylesheet">
<style>
/* Custom CSS to center text in table cells */
table th, table td {
	text-align: center;
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



	<div class="container">
		<h2 style="text-align: center">Attendance Records</h2>
		<table class="table table-bordered table-striped">
			<thead>
				<tr>
					<th>Date</th>
					<th>Shift</th>
					<th>First In</th>
					<th>Last Out</th>
					<th>Net Work</th>
					<th>First Half</th>
					<th>Second Half</th>
				</tr>
			</thead>
			<tbody>
				<!-- Iterate over the attendanceList to display each record -->
				<c:forEach items="${attendanceList}" var="attendance">
					<tr onclick="toggleAttendanceRecord(${attendance.id})">
						<td>${attendance.date}</td>
						<td>${attendance.shift}</td>
						<td>${attendance.firstIn}</td>
						<td>${attendance.lastout}</td>
						<td>${attendance.netWork}</td>
						<td>${attendance.firstHalf}</td>
						<td>${attendance.secondHalf}</td>
					</tr>
					<!-- Hidden row for attendance records -->
					<tr id="attendanceRecord${attendance.id}" style="display: none;">
						<td colspan="7">
							<table class="table table-sm table-striped">
								<thead>
									<tr>
										<th>Date</th>
										<th>Time</th>
										<th>Type</th>
									</tr>
								</thead>
								<tbody>
									<!-- Nested loop for each attendance record -->
									<c:forEach items="${attendance.attendanceRecords}" var="record">
										<tr>
											<td>${record.date}</td>
											<td>${record.time}</td>
											<td>${record.type}</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

	<div class="container text-center">
		<a href="javascript:history.back()" class="btn btn-outline-danger">Back</a>
	</div>
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

	<script>
    // Function to toggle the visibility of attendance records
    function toggleAttendanceRecord(attendanceId) {
        $('#attendanceRecord' + attendanceId).toggle();
    }
</script>

</body>
</html>