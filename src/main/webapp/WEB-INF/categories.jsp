<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Categories</title>

    <style>
        <%@include file="/bootstrap/css/bootstrap.min.css" %>
        <%@include file="/bootstrap/css/hello.css" %>
    </style>

</head>
<body>
<table class="table table-striped">
<div class="btn-group">
    <c:forEach var="category" items="${categories}">
    <button type="button" data-toggle="dropdown" class="btn btn-default dropdown-toggle"><h3><c:out value="${category.categoryName}"/></h3><span class="caret"></span></button>
    <ul class="dropdown-menu">
        <c:forEach var="product" items="${products}">
            <li><a href="#">"${product.productName}"</a></li>
        </c:forEach>
    </ul>
    </c:forEach>
</div>
</table>
<a href="/root/home" class="btn btn-lg btn-default">Home</a>
</body>
</html>