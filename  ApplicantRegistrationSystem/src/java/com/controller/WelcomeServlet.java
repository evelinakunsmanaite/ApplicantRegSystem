package com.controller;

import entity.Abiturient;
import entity.AbiturientList;
import entity.University;
import entity.UniversitysList;
import entity.User;
import entity.UsersList;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "WelcomeServlet", urlPatterns = {"/welcomeServlet"})
public class WelcomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        RequestDispatcher rd;
        String out = request.getParameter("logout");
        if (out != null && !out.isEmpty()) {
            // Выход из системы: сброс сессии и перенаправление на главную страницу
            request.getSession().invalidate();
            rd = getServletContext().getRequestDispatcher("/");
            rd.forward(request, response);
            return;
        }

        out = request.getParameter("toCab");
        if (out != null && !out.isEmpty()) {
            // Переход к личному кабинету: сброс сессии и перенаправление на страницу cabinet.jsp
            request.getSession().invalidate();
            rd = getServletContext().getRequestDispatcher("/cabinet.jsp");
            rd.forward(request, response);
            return;
        }

        User[] users = UsersList.getUsers();
        request.setAttribute("users", users);
        rd = getServletContext().getRequestDispatcher("/showUsers.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        // Получение введенного логина и пароля из формы
        String login = request.getParameter("login");
        String pass = request.getParameter("password");

        User[] users = UsersList.getUsers();
        Abiturient[] abiturients = AbiturientList.getAbiturients();
        University[] universitys = UniversitysList.getUniversitys();
        List<University> universitysList = new ArrayList();
        List<Abiturient> abiturientList = new ArrayList();
        List<Double> needs = new ArrayList();
        RequestDispatcher rd;

        // Проверка введенных логина и пароля для пользователя
        for (User user : users) {
            if (user.getLogin().equals(login)
                    && user.getPassword().equals(pass)) {
                // Установка атрибутов сессии для пользователя и перенаправление на страницу userCabinet.jsp
                request.getSession().setAttribute("firstName", user.getFirstName());
                request.getSession().setAttribute("middleName", user.getMiddleName());
                rd = getServletContext().getRequestDispatcher("/userCabinet.jsp");
                rd.forward(request, response);
                return;
            } else {
                // Проверка введенных логина и пароля для абитуриента
                for (Abiturient abiturient : abiturients) {
                    if (abiturient.getLastName().equals(login) && (abiturient.getId().equals(pass))) {
                        // Установка атрибутов сессии для абитуриента и перенаправление на страницу cabinet.jsp
                        request.getSession().setAttribute("name", abiturient.getName());
                        rd = getServletContext().getRequestDispatcher("/cabinet.jsp");
                        abiturientList.add(abiturient);

                        // Заполнение списков университетов, средних баллов и необходимых баллов для абитуриента
                        for (University university : universitys) {
                            universitysList.add(university);
                            double need = (university.getPassingScore() - (abiturient.getAvg() * 10));
                            needs.add(need);
                        }

                        request.getSession().setAttribute("lastName", abiturient.getLastName());
                        request.getSession().setAttribute("avg", abiturient.getAvg());
                        request.getSession().setAttribute("name", abiturient.getName());
                        request.setAttribute("universitys", universitysList);
                        request.setAttribute("abiturients", abiturientList);
                        request.setAttribute("needs", needs);
                        rd.forward(request, response);
                        return;
                    }
                }
            }
        }

        // Если авторизация неуспешна, установка атрибута "error" и перенаправление на страницу error.jsp
        request.setAttribute("error", "Ошибка авторизации");
        rd = getServletContext().getRequestDispatcher("/error.jsp");
        rd.forward(request, response);
    }
}
