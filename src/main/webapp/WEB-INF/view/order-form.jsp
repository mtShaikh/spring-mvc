<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Orders Tracker</title>
</head>
<body>

	<h3>Add Order</h3>

	<form:form action="saveOrder" modelAttribute="order" method="POST">
		<form:hidden path="id" />
		<label>Customer:</label>
		<form:input path="customer" />
		<br />

		<label>Price:</label>
		<form:input path="price" />
		<br />

		<label>Date of Order:</label>
		<input type="text" path="dateOfOrder" name="dateOfOrder" value = "<fmt:formatDate value="${order.dateOfOrder}" pattern="MM/dd/yyyy" />"/>
		<%-- <form:input type="text" path="dateOfOrder" name="dateOfOrder"
			value="<fmt:formatDate value="${order.dateOfOrder}" pattern="MM-dd-yyyy" />" /> --%>
		<br />

		<input type="submit" value="Save" class="save" />
	</form:form>
</body>
</html>