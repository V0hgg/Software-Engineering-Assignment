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
	<h1 class="space">Assign Janitor with ${collector.getName()}</h1>
	<h4>Janitor</h4>
	<div id="survey_options">
		<form action="addNewJaniToTask" method ="post">
			<select name="idJanitor" id="select_jani">
				<c:forEach var="jani" items="${janiFree}">
					<option value="${jani.getId_user()}">${jani.getName()}</option>
				</c:forEach>
			</select>
			<input type="hidden" name ="idCollector" value="${collector.getId_user() }"/>
			<input type="hidden" name ="i_day" value="${i_day }"/>
			<input type="hidden" name ="i_month" value="${i_month }"/>
			<input type="hidden" name ="i_year" value="${i_year}"/>
			<input type="hidden" name ="idMcp" value="${mcp.getId() }"/>
			<button type="submit">Submit</button>
		</form>
	</div>
	
	
</div>

<div class="wrapper">

</div>



<div class="boxslideJC2">
	<h1 class="space">List members</h1>
	<table id="Collector">
		<tr>
			<th>Id</th>
			<th>Name Janitor</th>
			<th>Remove</th>
		</tr>
		<c:if test="${allJaniWith.size() > 0}">
			<c:forEach var = "jani" items="${allJaniWith}" varStatus="loop">
				<tr>
					<td>${jani.getId_user() }</td>
					<td>${jani.getName() }</td>
					<td><a href="removeJani?idCollector=${collector.getId_user()}&idJani=${jani.getId_user()}&i_day=${i_day }&i_month=${i_month}&i_year=${i_year}">Remove</a></td>
				</tr>
			</c:forEach>
		</c:if>
	</table>
	<a href="task_detail?i_day=${i_day }&i_month=${i_month}&i_year=${i_year}"><button class="normal">End Assign</button></a>
</div>


<div class="footer"></div>

<script src="<c:url value="/assets/user/js/box.js" />">
	
</script>