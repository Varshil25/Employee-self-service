<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Report Viewer</title>
<!-- Add necessary CSS styles here -->
</head>
<body>
	<embed src="<c:url value="/display-report/${reportName}"/>"
		type="application/pdf" width="100%" height="600px" />
</body>
</html>
