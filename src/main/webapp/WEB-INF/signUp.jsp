<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Sign up Page</title>

    <style>
        <%@include file="/bootstrap/css/bootstrap.min.css" %>
        <%@include file="/bootstrap/css/signin.css" %>
    </style>
</head>

<body>
<div class="container">
    <form class="form-signin" action="/root/signUp" method="post">
        <h2 class="form-signin-heading">Please sign up</h2>

        <label for="inputLogin" class="sr-only">User login</label>
        <input type="text" id="inputLogin" class="form-control" name="username" placeholder="Login">

        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" id="inputPassword" class="form-control" name="password" placeholder="Password">

        <label for="inputEmail" class="sr-only">Email address</label>
        <input type="email" id="inputEmail" class="form-control" name="email" placeholder="Email address">

        <input type="hidden" id="inputRole" class="form-control" name="role" value="user">

        <div class="checkbox">
            <label>
                <input type="checkbox" value="remember-me"> Remember me
            </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign up</button>
    </form>
</div>

<script>window.jQuery || document.write('<script src="<c:url value="/bootstrap/js/jquery.min.js"/>"><\/script>')</script>
<script>
    <%@include file="/bootstrap/js/bootstrap.min.js" %>
</script>

</body>
</html>