package com.controller;

import entity.Abiturient;
import entity.AbiturientList;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "AvgServlet", urlPatterns = {"/avgServlet"})
public class AvgServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        try {
            // Получение заданного среднего балла из запроса
            double avg = Double.parseDouble(request.getParameter("avg"));

            // Получение массива абитуриентов из класса AbiturientList
            Abiturient[] abiturients = AbiturientList.getAbiturients();

            // Создание списка для хранения результата
            ArrayList<Abiturient> result = new ArrayList<>();

            // Проверка каждого абитуриента на средний балл выше заданного значения
            for (Abiturient abiturient : abiturients) {
                if (abiturient.getAvg() > avg) {
                    result.add(abiturient);
                }
            }

            // Установка атрибута "result" с результатом для передачи на другую страницу
            request.setAttribute("result", result);

            // Перенаправление запроса и ответа на страницу result.jsp
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/result.jsp");
            rd.forward(request, response);
        } catch (Exception e) {
            // Обработка исключения в случае ошибки ввода данных
            request.setAttribute("error", "Ошибка ввода данных");

            // Перенаправление запроса и ответа на страницу error.jsp
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/error.jsp");
            rd.forward(request, response);
        }
    }
}
