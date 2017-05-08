<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Users</title>
    <style>
        <%@include file="/bootstrap/css/bootstrap.min.css" %>
        <%@include file="/bootstrap/css/hello.css" %>
        <%@include file="header.jsp"%>
    </style>

</head>
<body>
<% request.setAttribute("isAdmin", request.isUserInRole("admin")); %>
<c:if test="${requestScope.isAdmin}">
<div class="container">
    <h3>Users List</h3>

    <form method="post" action="/root/users" class="well">

    <table class="table table-striped">
        <thead>
        <tr>
            <td><b>UserId</b></td>
            <td><b>Username</b></td>
            <td><b>Email</b></td>
            <td><b>Action</b></td>
            <td><b>Action</b></td>
            <td><b>Action</b></td>
        </tr>
        </thead>
                  <c:forEach var = "user" items="${users}">
            <tr>
                <td>${user.userId}</td>
                <td>${user.username}</td>
                <td>${user.email}</td>
                <td><a href="/root/user?userId=${user.userId}" methods="get">User details</a></td>
                <td><a href="/root/users/remove?userId=${user.userId}" methods="get">Delete</a></td>
                <td><a href="/root/userform?userId=${user.userId}" methods="get">Update</a></td>
            </tr>
                  </c:forEach>
    </table>

    </form>
    <a href="/root/home" class="btn btn-lg btn-default">Home</a>
</div>
</c:if>
<c:if test="${!requestScope.isAdmin}">
    <div style="text-align: center">
        <h1>Sorry, this page is displayed only if the user has the role "admin".</h1>
        <a href="/root/home" class="btn btn-lg btn-default">Home</a>
    </div>
</c:if>
<script>window.jQuery || document.write('<script src="<c:url value="/bootstrap/js/jquery.min.js"/>"><\/script>')</script>
<script>
    <%@include file="/bootstrap/js/bootstrap.min.js" %>
    <%@include file="footer.jsp"%>
</script>

</body>
</html>
