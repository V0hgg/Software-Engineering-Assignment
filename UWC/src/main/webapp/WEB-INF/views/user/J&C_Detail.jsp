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
	href="<c:url value="/assets/user/css/style.css" />">

<%@include file="/WEB-INF/views/user/menu.jsp"%>



<div class="boxslideJC1">
	<h1 class="space">Today's calendar: ${i_day} - ${i_month} - ${i_year}</h1>
	<h1 class="space">Collector: ${collector.getName()}</h1>
	<table id="Collector">
		<tr>
			<th>Number</th>
			<th>Name MCP</th>
		</tr>
		<c:forEach var="mcp" items="${all_mcp}" varStatus="loop">
			<tr>
				<td>${loop.index}</td>
				<td>${mcp.getName()}</td>
			</tr>
		</c:forEach>
	</table>
</div>

<div class="boxslideJC2">
		<h1 class="space">List Janitor</h1>

		<table id="Collector">
			<tr>
				<th>Number</th>
				<th>Janitor List</th>
			</tr>
			<c:forEach var="jani" items="${all_janitor}" varStatus="loop">
				<tr>
					<td>${loop.index}</td>
					<td>${jani.getName()}</td>
				</tr>
			</c:forEach>
		</table>
</div>


