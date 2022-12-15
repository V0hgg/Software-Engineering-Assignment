<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>UWC2.0</title>
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.15.4/css/all.css" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css"
	integrity="sha512-9usAa10IRO0HhonpyAIVpjrylPvoDwiPUiKdWk5t3PyolY1cOd4DSE0Ga+ri4AuTroPR5aQvXU9xC6qOPnzFeg=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
<link rel='stylesheet'
	href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css'>
<link rel="stylesheet"
	href="<c:url value="/assets/user/css/new.css" />">

<%@include file="/WEB-INF/views/user/menu.jsp"%>


<div class="boxslideJC1">
	<h1 class="space">Today's calendar</h1>
	<h4>Collector</h4>
	<select id="allCollector" onchange="changeCollector()">
		<c:forEach var="collector" items="${allCollector}">
			<option value="${collector.getId_user() }">${collector.getName() }</option>
		</c:forEach>
	</select>

	<div class="boxslideJC11">
		<form action="assginTask_Jani" method = "POST">
			<input type="hidden" name ="idCollector" id ="idCollector" value="${allCollector.get(0).getId_user() }">
			<input type = "hidden" value="${ i_day}" name = "i_day">
			<input type = "hidden" value="${ i_month}" name = "i_month">
			<input type = "hidden" value="${ i_year}" name = "i_year">
			<input type = "hidden" value="${ mcp.getId()}" name = "idMcp">
			<button class="normal">Submit</button>
		</form>
	</div>
</div>


<div class="footer"></div>

<script src="<c:url value="/assets/user/js/box.js" />">
	
</script>