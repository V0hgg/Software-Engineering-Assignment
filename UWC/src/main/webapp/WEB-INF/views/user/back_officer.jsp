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

<div class="boxslide"> 
      <h1 class="space">Status of MCP</h1>
      
      <table id="customers">
        <tr>
          <th>Name MCP</th>
          <th>Collector in charge</th>
          <th>Companion Janitor</th>
          <th>Delete assignment</th>
          <th>Change assignment</th>
        </tr>
        
        <!-- Lấy ra toàn bộ Task -->
        <c:forEach var = "task" items="${all_task }">
        
	        <tr>
	            <td>${task.key }</td>
	            <c:if test="${task.value.size() != 0}">
					<td>${task.value.get(0).getCollector().getName() }</td>
					<td><ul>
							<c:forEach var = "jani" items="${task.value }">
								<li>${jani.getJanitor().getName()}</li>
							</c:forEach>
						</ul></td>
					<td><a href="deleteTask?idMcp=${task.value.get(0).getId_mcp() }&i_day=${i_day }&i_month=${i_month}&i_year=${i_year}">Delete</a></td>
	            	<td><a href="updateTaskView?idCollector=${task.value.get(0).getCollector().getId_user() }&idMcp=${task.value.get(0).getId_mcp() }&i_day=${i_day }&i_month=${i_month}&i_year=${i_year}">Update</a></td>
				</c:if>
				
				<c:if test="${task.value.size() == 0}">
					<td colspan="4"><a href="assginTask_Collector?nameMcp=${task.key }&i_day=${i_day }&i_month=${i_month}&i_year=${i_year}">Nothing in here, click to assgin someone</a></td>
				</c:if>
	        </tr>
        </c:forEach>
        
      </table>    
    </div>