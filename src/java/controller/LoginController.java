package controller;


import dao.UsuarioDAO;
import dao.LoginDAO;
import model.Usuario;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Optional;
import java.io.PrintWriter;

@WebServlet("/login")
public class LoginController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String cpf = req.getParameter("cpf");
        String senha = req.getParameter("senha");
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();

        if (cpf != null && senha != null) {
            LoginDAO<?> dao;

            dao = new UsuarioDAO();

            Optional<Usuario> user = dao.login(cpf, senha);

            if (user.isPresent()) {
                req.getSession().setAttribute("user", user.get());
                resp.sendRedirect("/");
                return;

            }
        }

        out.println("<script type=\"text/javascript\">");
        out.println("alert('Login incorreto!');");
        out.println("location='/login';");
        out.println("</script>");

        //   req.getRequestDispatcher("/WEB-INF/login.jsp").forward(req, resp);
    }

}
