<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
            integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
            integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
            crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
            integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
            crossorigin="anonymous"></script>

    <title>Форум</title>
</head>
<body>
<div class="navbar navbar-dark bg-dark box-shadow">
    <div class="container d-flex justify-content-between">
        <a class="navbar-brand d-flex align-items-center">
            <strong>${user.name}</strong>
        </a>
        <c:if test="${empty user}">
            <input type="button"
                   onclick="location.href='<c:url value='/login'/>'"
                   class="btn btn-warning" value="Войти">
        </c:if>
    </div>
</div>
<div class="container mt-3">
    <c:if test="${not empty user}">
        <br/><input type="button" onclick="location.href='<c:url value='/create'/>'"
                    class="btn btn-warning" value="Добавить"><br/><br/>
    </c:if>
    <table class="table">
        <table class="table">
            <thead>
            <tr>
                <th>Тема</th>
                <th>Дата создания</th>
                <th></th>
                <th></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${posts}" var="post">
                <tr>
                    <td><c:out value="${post.name}"/></td>
                    <td><fmt:formatDate value="${post.created}" pattern="dd.MM.yy"/></td>
                    <td><input type="button" onclick="location.href='<c:url value='/edit?id=${post.id}'/>'"
                               class="btn btn-warning" value="Редактировать"></td>
                    <td><input type="button"
                               onclick="location.href='<c:url value='/delete?id=${post.id}'/>'"
                               class="btn btn-warning" value="Удалить"></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </table>
</div>
</body>
</html>