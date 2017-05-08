<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Home Page</title>

    <style>
        <%@include file="/bootstrap/css/bootstrap.min.css" %>
        <%@include file="/bootstrap/css/cover.css" %>
    </style>

</head>

<body>

<div class="site-wrapper">

    <div class="site-wrapper-inner">

        <div class="cover-container">

            <div class="masthead clearfix">
                <div class="inner">
                    <nav>
                        <ul class="nav masthead-nav">
                            <li class="active"><a href="/root/users">Users</a></li>
                            <li class="active"><a href="/root/categories">Categories</a></li>
                            <li class="active"><a href="/root/products">Products</a></li>
                        </ul>
                    </nav>
                </div>
            </div>

            <div class="inner cover">
                <h1 class="cover-heading">My first WEB app without frameworks</h1>
                <p class="lead">
                    <a href="/root/signUp" class="btn btn-lg btn-default">Sign up</a>
                </p>
            </div>

            <div class="mastfoot">
                <div class="inner">
                    <p><a href="https://github.com/FeschenkoNatalia">More samples of works at https://github.com/FeschenkoNatalia</a></p>
                </div>
            </div>

        </div>

    </div>

</div>
<script>window.jQuery || document.write('<script src="<c:url value="/bootstrap/js/jquery.min.js"/>"><\/script>')</script>
<script>
    <%@include file="/bootstrap/js/bootstrap.min.js" %>
</script>
</body>
</html>