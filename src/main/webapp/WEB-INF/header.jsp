<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <title>WEB Form Handling Example</title>

    <c:url value="/bootstrap/css/hello.css" var="coreCss" />
    <c:url value="/bootstrap/css/bootstrap.min.css" var="bootstrapCss" />

</head>

<c:url value="/" var="urlHome" />

<nav class="navbar navbar-inverse ">
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand" href="${urlHome}">MVC Form</a>
        </div>
        <div id="navbar">
            <ul class="nav navbar-nav navbar-right">
                <li class="active"><a href="${urlAddUser}">Add User</a></li>
            </ul>
        </div>
    </div>
</nav>