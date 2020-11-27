package controller.autor;

import dao.ArtigoDAO;
import model.Usuario;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/autor/meus-posts")
public class MeusPostsController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArtigoDAO dao = new ArtigoDAO();

        Usuario user = (Usuario) req.getSession().getAttribute("user");
        req.setAttribute("artigos", dao.findByUsuarioId(user.getId()));
        req.getRequestDispatcher("/WEB-INF/autor/meus-posts.jsp").forward(req, resp);
    }
  
   
}
