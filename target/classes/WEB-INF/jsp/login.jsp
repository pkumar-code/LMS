<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE  html>
<html>
<head>
<title>JLCBookStore</title>
<link href="webjars/bootstrap/5.3.3/css/bootstrap.min.css" rel="stylesheet">
<style>
h1 {
	font-size: 30px;
	font-weight: bold;
	font-family: Cambria, Cochin, Georgia, Times, 'Times New Roman', serif;
	border: 1px solid #000;
	color: red;
	display: inline-block;
	padding: 2px 4px;
	background-color: grey;
}

body {
	margin-top: 30px;
	margin-left: 250px;
	margin-right: 250px;
	border: 1px solid;
	background-color: azure;
}

table, tr, td {
	text-align: center;
	padding: 20px;
	font-size: 20px;
}
</style>

</head>
<body>
	<div class="container">
		<h1>LMS</h1>
	</div>
	<br>
	<div class="container" align="center">
		<h2>Leads Login Form</h2>
		<form action="/allleads" method="post">
			<table>
				<tr>
					<td>Username</td>
					<td><input type="text" name="username" required /></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="password" name="password" required /></td>
				</tr>
				<tr>
					<td colspan="3" align="center"><input type="submit"
						value="LoginNow" /></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>