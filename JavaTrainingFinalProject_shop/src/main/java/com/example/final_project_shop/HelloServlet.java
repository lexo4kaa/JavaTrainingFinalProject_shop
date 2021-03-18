package com.example.final_project_shop;

import java.io.*;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/helloservlet")
public class HelloServlet extends HttpServlet {

    public void init() {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + "hello message" + "</h1>");
        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String numStr = req.getParameter("number"); // где number -- название текстового поля из index.jsp
        int num = Integer.parseInt(numStr);
        num *= 2;
        req.setAttribute("numResult", num);

        List<Message> list = List.of(new Message(45, "hello"), new Message(3, "hi"));
        req.setAttribute("lst", list); // где lst -- название текстового поля из main.jsp

        req.getRequestDispatcher("/pages/main.jsp").forward(req, resp);
    }

    public void destroy() {
    }
}