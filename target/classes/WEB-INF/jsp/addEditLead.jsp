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
		<h1 class="text-center">Welcome to Lead Add/Edit Info</h1>

	</div>
	<br>

	<div align="center" class="container">
		<form:form action="saveUpdateLead" method="post"
			modelAttribute="mylead">
			<table class="table" style="font-size: 20px; font-weigth: bold;">
				<tr>
					<c:if test="${OpType eq 'ADD' }">
						<td align="center" colspan="3"><h2>Add New Lead</h2></td>
					</c:if>

					<c:if test="${OpType eq 'UPDATE' }">
						<td align="center" colspan="3"><h2>Update Lead</h2></td>
					</c:if>
				</tr>

				<tr>
					<td>Name</td>
					<td><input type="text" name="name" value="${Lead.name }"
						class="formpcontrol form-control-lg" /></td>
				</tr>

				<tr>
					<td>Email</td>
					<td><input type="text" name="email" value="${Lead.email }"
						class="formpcontrol form-control-lg" /></td>
				</tr>

				<tr>
					<td>Phone</td>
					<td><input type="tel" name="phone" value="${Lead.phone }"
						class="formpcontrol form-control-lg" /></td>
				</tr>

				<tr>
					<td>CourseInterest</td>
					<td><input type="text" name="courseInterest"
						value="${Lead.courseInterest }"
						class="formpcontrol form-control-lg" /></td>
				</tr>

				<tr>
					<td>CollegeName</td>
					<td><input type="text" name="collegeName"
						value="${Lead.collegeName }" class="formpcontrol form-control-lg" /></td>
				</tr>

				<tr>
					<td>City</td>
					<td><input type="text" name="city" value="${Lead.city }"
						class="formpcontrol form-control-lg" /></td>
				</tr>

				<tr>
					<td>Status</td>
					<td><input type="text" name="status" value="${Lead.status }"
						class="formpcontrol form-control-lg" /></td>
				</tr>



				<tr>
					<td align="center" colspan="3"><input type="hidden"
						name="OpType" value="${OpType }" /> <c:if
							test="${OpType eq 'ADD'  }">
							<input type="submit" value="Add New Lead"
								class="btn btn-primary btn-lg" />
						</c:if> <c:if test="${OpType eq 'UPDATE'  }">
							<input type="submit" value="Update Lead"
								class="btn btn-primary btn-lg" />
							<input type="hidden" name="leadId" value="${Lead.leadId }" />
						</c:if></td>
				</tr>


			</table>
		</form:form>
	</div>


</body>
</html>