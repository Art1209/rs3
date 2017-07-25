<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %><html>
<head>
    <title>Hello page</title>
</head>
<body>
<h1>Message : ${message}</h1>
<div>
    <div style="margin-top: 20px;">
        <h1>Авторизация</h1>
        <p>Тестовый сервис</p>
        <sec:authorize access="!isAuthenticated()">
            <p><a href="<c:url value="/login" />">Войти</a></p>
        </sec:authorize>
        <sec:authorize access="isAuthenticated()">
            <p>Ваш логин: <sec:authentication property="principal.username" /></p>
            <p><a href="<c:url value="/logout" />">Выйти</a></p>
        </sec:authorize>
    </div>
</div>
</body>
</html>