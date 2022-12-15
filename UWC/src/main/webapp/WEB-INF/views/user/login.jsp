<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Login</title>
</head>
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.4/css/all.css"/>

<link rel="stylesheet" href="<c:url value="/assets/user/css/styleLogin.css" />">
<link href="https://fonts.google.com/specimen/Roboto?query=Christian+Robertson&subset=vietnamese">

  <section id="log">
        <div class="color">
        	
        	<h1 style="color:red;" >${sessionScope.fail_mess}</h1>
        	
            <div class = "pois0">Login</div>
            <div class = "pois1"><h6>Email</h6></div>
            <div class = "pois2"><h6>Password</h6></div>
            <div class = "pois3" onclick="window.location.href='Forgotpassword.html';"><h6>Forgot Password?</h6></div>
            
            
           	<form:form action="loginHandelling" method="POST" modelAttribute="user">
        		<form:input  class="khung1" type="name" path="username"/>
        		<form:input  class="khung2" type="password" path="password"/>
        		<input class="khung3" type="submit" value="Login" />  
        	</form:form>
            <img src="<c:url value="/assets/user/img/Logologin.png" />" class="logo" alt="">
        </div>
    </section>

