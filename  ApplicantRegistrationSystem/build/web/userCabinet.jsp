<%-- 
    Document   : userCabinet
    Created on : 22 мая 2023 г., 01:37:53
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="resources/css/userCabinetcss.css" rel="stylesheet" />

        <title>JSP Page</title>
    </head>
    <body>
        <div class="registration">

            <!-- Приветственное сообщение с отображением имени и отчества пользователя, полученных из сессии -->
            <h2>Добро пожаловать, <%= session.getAttribute("firstName")%> <%= session.getAttribute("middleName")%></h2>
            <h2>Списки данных</h2>

            <img src="resources/img/icon-university.png" alt="" class="round">

            <!-- Форма для получения списка студентов с недостаточными оценками -->
            <form  action="neudServlet" method="get">
                <div class="form-group"> 
                    <div class="input-container">
                        <label><h3>Cписок абитуриентов, имеющих неудовлетворительные оценки:</h3>
                            <input class="form-control item" type="submit" value="Отправить">
                        </label>    
                    </div>

                </div>
            </form>

            <!-- Форма для получения списка студентов с средним баллом выше указанного значения -->
            <form action="avgServlet" method="post">
                <div class="form-group"> <div class="input-container">
                        <label><h3>Cписок абитуриентов, средний балл у которых выше заданного:</h3>
                            <input class="form-control item" type="text" name="avg" required placeholder="Введите средний балл">
                            <input class="form-control item" type="submit" value="Отправить">
                        </label>    
                    </div> 
                </div>
            </form>
            <a href="index.jsp">Назад</a>  
        </div>

    </body>
</html>