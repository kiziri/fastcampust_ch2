<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page session="false" %>
<html>
<head>
	<title>YoilTellerMVC</title>
</head>
<body>
	<h6>year=<% request.getParameter("year") %></h6>
	<P> ${year }년 ${month }월 ${day }일은 ${yoil }요일 입니다.</P>
</body>
</html>
