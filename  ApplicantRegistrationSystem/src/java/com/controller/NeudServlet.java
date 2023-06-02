package com.controller;

import entity.Abiturient;
import entity.AbiturientList;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;

@WebServlet(name = "NeudServlet", urlPatterns = {"/neudServlet"})
public class NeudServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        // Получение массива абитуриентов из класса AbiturientList
        Abiturient[] abiturients = AbiturientList.getAbiturients();

        // Создание списка для хранения результата
        ArrayList<Abiturient> result = new ArrayList<>();

        // Проверка каждого абитуриента на наличие неудовлетворительных оценок
        for (Abiturient abiturient : abiturients) {
            for (int note : abiturient.getNoten()) {
                if (note < 4) {
                    result.add(abiturient);
                    break;
                }
            }
        }

        // Установка атрибута "result" с результатом для передачи на другую страницу
        request.setAttribute("result", result);

        // Перенаправление запроса и ответа на страницу result.jsp
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/result.jsp");
        rd.forward(request, response);
    }
}
