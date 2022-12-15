<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>

<c:if test="${sessionScope.currentUser == null}">
	<c:redirect url="/login" />

</c:if>


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
	href="<c:url value="/assets/user/css/style2Nha.css" />">




<%@include file="/WEB-INF/views/user/menu.jsp"%>



<div class="container">
	<button class="btn btn-prev">
		<span><i class="fa fa-chevron-left" aria-hidden="true"></i></span>
	</button>
	<div class="calendar">
		<h1>Calendar</h1>
		<div class="info">
			<p class="month">September</p>
			<p class="year">2020</p>
		</div>
		<div class="date">
			<div class="day-name">Sun</div>
			<div class="day-name">Mon</div>
			<div class="day-name">Tue</div>
			<div class="day-name">Wen</div>
			<div class="day-name">Thu</div>
			<div class="day-name">Fri</div>
			<div class="day-name">Sat</div>
		</div>
		<div class="date date-container">
			<div class="day"></div>
			<div class="day"></div>
			<div class="day">1</div>
			<div class="day">2</div>
			<div class="day">3</div>
			<div class="day">4</div>
			<div class="day">5</div>
			<div class="day">6</div>
			<div class="day">7</div>
			<div class="day">8</div>
			<div class="day">9</div>
			<div class="day active">10</div>
			<div class="day">11</div>
			<div class="day">12</div>
			<div class="day">13</div>
			<div class="day">14</div>
			<div class="day">15</div>
			<div class="day">16</div>
			<div class="day">17</div>
			<div class="day">18</div>
			<div class="day">19</div>
			<div class="day">20</div>
			<div class="day">21</div>
			<div class="day">22</div>
			<div class="day">23</div>
			<div class="day">24</div>
			<div class="day">25</div>
			<div class="day">26</div>
			<div class="day">27</div>
			<div class="day">28</div>
			<div class="day">29</div>
			<div class="day">30</div>
			<div class="day">31</div>
		</div>
	</div>
	<button class="btn btn-next">
		<span><i class="fa fa-chevron-right" aria-hidden="true"></i></span>
	</button>
</div>


<form action="task_detail" method="GET" id="form_task">
	<input name ="i_day" type="hidden" id = "i_day"/>
	<input name ="i_month" type="hidden" id = "i_month"/>
	<input name ="i_year" type="hidden" id = "i_year"/>
</form>


<script src="<c:url value="/assets/user/js/main.js" />"></script>


<div class="footer"></div>

<script src="<c:url value="/assets/user/js/script.js" />">
	
</script>
