<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<!DOCTYPE html>
<html lang="en">
<html>
<head>
    <title>User detail</title>
    <style>
        <%@include file="/bootstrap/css/bootstrap.min.css" %>
        <%@include file="/bootstrap/css/hello.css" %>
        <%@include file="header.jsp"%>
    </style>
</head>
<body>
<div class="container">

    <h3>User Details</h3>

    <form method="get" action="/root/user?userId=${user.userId}" class="well">

        <table class="table table-striped">
            <thead>
            <tr>
                <td><b>UserId</b></td>
                <td><b>Username</b></td>
                <td><b>Password</b></td>
                <td><b>Email</b></td>
                <td><b>Role</b></td>
            </tr>
            </thead>
                <tr>
                    <td>${user.userId}</td>
                    <td>${user.username}</td>
                    <td>${user.password}</td>
                    <td>${user.email}</td>
                    <td>${user.role}</td>
                </tr>
        </table>
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
