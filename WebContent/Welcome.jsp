<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">

<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="javascripts/filter.js"></script>
<!-- Latest compiled JavaScript -->
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<!-- <link rel="stylesheet" href="css/style.css" /> -->
<title>Welcome</title>
</head>
<body>
	<c:set var="mes" scope="session" value="${message}" />
	<c:if test="${mes != null}">
		<div class="alert alert-success">
			<strong>${message}</strong> <span id="showSearchTerm"></span>
		</div>
	</c:if>

	<form id="target" action="Insert" method="post">
		<a href="<%=request.getContextPath()%>/Logout"><span
			class="glyphicon glyphicon-log-in"></span> LogOut</a> <input type="text"
			id="studentId" name="studentId" value=""
			placeholder="Enter Student ID"> <input type="text"
			id="typeAssgn" name="typeAssgn" value=""
			placeholder="Enter Type of Assignment"> <input type="text"
			id="assgnName" name="assgnName" value=""
			placeholder="Enter Assignment Name"> <input type="text"
			id="date" name="date" value=""
			placeholder="Enter Date of Assignment in MM/dd/yyyy format">
		<input type="text" id="grade" name="grade" value=""
			placeholder="Enter Grade"> <input type="submit" id="submit"
			value="Insert">

		<h2>Welcome Professor!!</h2>
		<h4>Filters:</h4>
		<input type="text" id="student" name="student" value=""
			placeholder="Enter Student ID"> <input type="text" id="type"
			name="type" value="" placeholder="Enter Type of Assignment">
		<input type="button" id="average" name="average" value="Average">
		<input type="button" id="assignments" name="assignments"
			value="Assignments"> <input type="button" id="highLow"
			name="highLow" value="High Low Score">

		<c:set var="res" scope="session" value="${result}" />
		<c:if test="${res != null}">
			<table>
				<thead>
					<tr>
						<th>Student ID</th>
						<th>Assignment Name</th>
						<th>Assignment Type</th>
						<th>Assignment date</th>
						<th>Grade</th>
					</tr>
				</thead>

				<tbody>
					<c:forEach var="result" items="${result}">
						<tr>
							<td>${result.studentId}</td>
							<td>${result.assignmentName}</td>
							<td>${result.typeassignment.type}</td>
							<td>${result.assdate}</td>
							<td>${result.grade}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>

		</c:if>
	</form>

	<c:set var="avg" scope="session" value="${average}" />
	<c:if test="${avg != null}">
		Average is: <c:out value="${average}"></c:out>
	</c:if>

	<c:set var="high" scope="session" value="${high}" />
	<c:if test="${high != null}">
		Highest Score is: <c:out value="${high}"></c:out>
		Minimum Score is: <c:out value="${low}"></c:out>
	</c:if>

</body>
</html>