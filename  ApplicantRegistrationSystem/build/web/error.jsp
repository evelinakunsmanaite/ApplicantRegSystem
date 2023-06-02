<%-- 
    Document   : error
    Created on : 21 мая 2023 г., 18:30:03
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="resources/css/errorcss.css" rel="stylesheet" />
        <title>Ошибка</title>
    </head>
    <body>
        <!-- Заголовок с сообщением об ошибке, переданным в переменной error -->
        <h1 style='color:red;'>${error}</h1>

        <!-- Ссылка для возврата на страницу index.jsp -->
        <a href="index.jsp">Назад</a>         
    </body>
</html>
