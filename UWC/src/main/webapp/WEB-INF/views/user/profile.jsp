<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>

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

<i class='fa fa-user-circle fixpro'></i>
<span class="Name">${sessionScope.currentUser.name }</span>
<span class="editprofile"><a class="editpro">Edit profile</a></span>
<span class="textpro1">Position</span>
<span class="boxprofile1"><a class="textprofile">${sessionScope.currentUser.name }</a></span>
<span class="textpro2">Day Of Birth</span>
<span class="boxprofile2"><a class="textprofile">${sessionScope.currentUser.dob }</a></span>
<div></div>

<div class="footer"></div>
