<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<html>
<head>
    <title>User form</title>
    <style>
        <%@include file="/bootstrap/css/bootstrap.min.css" %>
        <%@include file="/bootstrap/css/hello.css" %>
        <%@include file="header.jsp"%>
    </style>
</head>
<body>

<div class="container">
    <form class="form-user" action="/root/userform" method="post">
        <h2 class="form-user-heading">Please input user's details</h2>

        <label for="inputUserId" class="sr-only">UserId</label>
        <input type="text" id="inputUserId" class="form-control" name="userId" value="${userId}">

        <label for="inputUsername" class="sr-only">Username</label>
        <input type="text" id="inputUsername" class="form-control" name="username" placeholder="Username">

        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" id="inputPassword" class="form-control" name="password" placeholder="Password">

        <label for="inputEmail" class="sr-only">Email address</label>
        <input type="email" id="inputEmail" class="form-control" name="email" placeholder="Email">

        <button class="btn btn-lg btn-primary btn-block" type="submit">Update</button>
    </form>
    <a href="/root/users" class="btn btn-lg btn-default">Users list</a>
    <a href="/root/home" class="btn btn-lg btn-default">Home</a>
</div>
<script>window.jQuery || document.write('<script src="<c:url value="/bootstrap/js/jquery.min.js"/>"><\/script>')</script>
<script>
    <%@include file="/bootstrap/js/bootstrap.min.js" %>
    <%@include file="footer.jsp"%>
</script>
</body>
</html>