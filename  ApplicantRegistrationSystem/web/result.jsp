<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="resources/css/resultcss.css" rel="stylesheet" />

        <title>Результат</title>
    </head>
    <body>
        <c:choose>

            <!-- Проверка, есть ли результаты для отображения -->
            <c:when test="${not empty result}">
                <table>
                    <thead>
                    <th>Имя</th>
                    <th>Фамилия</th>
                    <th>Отчество</th>
                    <th>математика</th>
                    <th>физика</th>
                    <th>русский</th>
                    <th>средний балл</th>
                </thead>

                <!-- Перебор результатов и отображение информации в таблице -->
                <c:forEach var="ab" items="${result}">
                    <tr>
                        <td>${ab.name}</td>
                        <td>${ab.lastName}</td>
                        <td>${ab.patronimic}</td>
                        <td>${ab.noten[0]}</td>
                        <td>${ab.noten[1]}</td>
                        <td>${ab.noten[2]}</td>
                        <td><fmt:formatNumber type="number" maxFractionDigits="2">${ab.avg}</fmt:formatNumber></td>
                        </tr>
                </c:forEach>
            </table>
        </c:when>

        <!-- Если результаты отсутствуют -->
        <c:otherwise>
            <c:out value="искомые данные отсутствуют" />
        </c:otherwise>
    </c:choose>

    <!-- Ссылка для возврата на страницу userCabinet.jsp -->
    <a href="userCabinet.jsp">Назад</a>  
</body>
</html>
