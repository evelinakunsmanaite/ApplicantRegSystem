<%-- 
    Document   : cabinet
    Created on : 22 мая 2023 г., 01:37:36
    Author     : Administrator
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="resources/css/cabinetcss.css" rel="stylesheet" />

        <title>Кабинет</title>
    </head>
    <body>
        <!-- Приветственное сообщение с именем и фамилией пользователя, полученными из сессии -->
        <h2>Добро пожаловать, <%= session.getAttribute("name")%> <%= session.getAttribute("lastName")%></h2>

        <!-- Отображение среднего балла студента -->
        <h3> Ваш балл: <fmt:formatNumber type="number" maxFractionDigits="2"><%= session.getAttribute("avg")%> </fmt:formatNumber> </h3>  

            <!-- Таблица со списком университетов -->
            <table>
                <tr>
                    <th>Список университетов</th>
                    <th>Требуемое количество баллов</th>
                    <th>Нужно набрать</th>
                </tr>

                <!-- Цикл для прохода по университетам и отображения информации -->
            <c:forEach var="university" items="${universitys}" varStatus="loop">
                <tr>
                    <td>${university.universityName}</td>
                    <td>${university.passingScore}</td>
                    <td><fmt:formatNumber type="number" maxFractionDigits="2">${needs[loop.index]}</fmt:formatNumber></td>
                    </tr>
            </c:forEach>
        </table>

        <!-- Ссылка для возврата на страницу index.jsp -->
        <a href="index.jsp">Назад</a>  

    </body>
</html>