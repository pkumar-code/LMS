<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="Boot.TO.Leads,java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<title>JLCBookStore</title>
<link href="webjars/bootstrap/5.3.3/css/bootstrap.min.css"
	rel="stylesheet">

<style type="text/css">
.hed {
	font-size: 30px;
	color: red;
	padding-left: 80px;
}

a {
	text-decoration: none;
}

h5 {
	text-align: center;
}

.headname {
	margin-left: 450px;
}

.inline {
	display: flex;
}
</style>
</head>
<body>
	<div class="card-header">
		<h1 class="text-center">Welcome to LMS LEADS Table</h1>
	</div>
	<br>
	<div class="inline">
		<div class="hed">
			<h1>LMS</h1>
		</div>
		<div class="headname">
			<h1>
				Welcome to : ${Users.fullName}&nbsp;|| <a href="logout">Logout</a>
			</h1>

		</div>
	</div>
	<div class="container">
		<table class="table table-striped table-bordered table-hover"
			style="font-size: 20px; font-weight: bold;">

			<tr>
				<th>Lead ID</th>
				<th>Name</th>
				<th>Email</th>
				<th>Phone</th>
				<th>CourseInterest</th>
				<th>CollegeName</th>
				<th>City</th>
				<th>Status</th>

				<th colspan="2" align="center"><form:form action="addEditLead">
						<input type="hidden" name="leadId" value="0" />
						<input type="submit" value="Add New Lead"
							class="btn btn-danger btn-lg" />
					</form:form></th>
			</tr>

			<c:forEach var="mylead" items="${MyLeads }">
				<tr>
					<td>${mylead.leadId }</td>
					<td>${mylead.name}</td>
					<td>${mylead.email }</td>
					<td>${mylead.phone}</td>
					<td>${mylead.courseInterest }</td>
					<td>${mylead.collegeName }</td>
					<td>${mylead.city }</td>
					<td>${mylead.status }</td>

					<td><form:form action="addEditLead?leadId=${mylead.leadId }">
							<input type="hidden" name="leadId" value="${mylead.leadId }" />
							<input type="submit" value="Edit" class="btn btn-primary  btn-lg" />
						</form:form></td>


					<td><form:form action="viewLead?leadId=${mylead.leadId }"
							method="get">
							<input type="hidden" name="leadId" value="${mylead.leadId }" />
							<input type="submit" value="View" class="btn btn-success  btn-lg" />
						</form:form></td>

				</tr>
			</c:forEach>

		</table>

		<h5>
			<c:if test="${ShowPrevious eq 'TRUE' }">
				<a href="previousLeads">Previous</a>
			</c:if>
			&nbsp;&nbsp;
			<c:if test="${ShowNext eq 'TRUE' }">
				<a href="nextLeads">Next</a>
			</c:if>
		</h5>

	</div>

	<%
	System.out.println("------------JSP COnsole--------------------");
	List list = (List) request.getAttribute("MyLeads");

	for (Object x : list) {
		System.out.println(x);
	}
	%>

</body>
</html>