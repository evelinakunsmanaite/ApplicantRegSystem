<%-- 
    Document   : login
    Created on : 19 мая 2023 г., 08:12:08
    Author     : Administrator
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link href="resources/css/logincss.css" rel="stylesheet" />
    </head>
    <body>
        <div class="registration">

            <!-- Форма для отправки данных на сервлет "welcomeServlet" при входе -->
            <form method="post" action="welcomeServlet">
                <img src="resources/img/icon-university.png" alt="" class="round">
                <h2>Вход</h2><br>

                <!-- Поле для ввода логина -->
                <div class="form-group">
                    <input class="form-control item" type="text" name="login" 
                           maxlength="15" minlength="4" pattern="^[а-яА-Я0-9_.-]*$" 
                           id="login" placeholder="Логин" required>
                </div>

                <!-- Поле для ввода пароля -->
                <div class="form-group">
                    <input class="form-control item" type="password" name="password" 
                           minlength="5" id="password" placeholder="Пароль" required>
                </div>

                <!-- Кнопка для отправки формы -->
                <div class="form-group">
                    <input type="submit" name="signin" id="signin"
                           class="submit" value="войти" />
                </div>
            </form>
        </div>
    </body>
</html>

