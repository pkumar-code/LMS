<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<title>JLCBookStore</title>
<link href="webjars/bootstrap/5.3.3/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<div class="card-header">
		<h1 class="text-center">Welcome to LMS Info</h1>
	</div>
	<br>

	<table class="table table-striped table-bordered table-hover"
		style="font-size: 20px; font-weight: bold;">
		<tr>
			<td align="center" colspan="3">Lead Details</td>
		</tr>
		<tr>
			<td>Lead Id</td>
			<td>${Lead.leadId }</td>
		</tr>

		<tr>
			<td>Name</td>
			<td>${Lead.name }</td>
		</tr>

		<tr>
			<td>Email</td>
			<td>${Lead.email }</td>
		</tr>

		<tr>
			<td>Phone</td>
			<td>${Lead.phone }</td>
		</tr>

		<tr>
			<td>CourseInterest</td>
			<td>${Lead.courseInterest }</td>
		</tr>

		<tr>
			<td>CollegeName</td>
			<td>${Lead.collegeName }</td>
		</tr>

		<tr>
			<td>City</td>
			<td>${Lead.city }</td>
		</tr>

		<tr>
			<td>Status</td>
			<td>${Lead.status}</td>
		</tr>

	</table>
</body>
</html>