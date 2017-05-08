<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Confirm operation page</title>

    <style>
        <%@include file="/bootstrap/css/bootstrap.min.css" %>
        <%@include file="/bootstrap/css/signin.css" %>
    </style>
</head>

<body>
<div style="text-align: center">
    <h1>Congratulations, your operation with <c:out value="${user.username}"/> is done successfully!</h1>
    <a href="/root/home" class="btn btn-lg btn-default">Home</a>
</div>


</body>
</html>