package controller;

import dao.ArtigoDAO;
import dao.ComentarioDAO;
import model.Usuario;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import model.Artigo;
import model.Comentario;

@WebServlet("/posts")
public class PostsController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArtigoDAO dao = new ArtigoDAO();
        ComentarioDAO comentarioDAO = new ComentarioDAO();
        List<Artigo> artigo;
        artigo = dao.findByAprovado();

        for (Artigo post : artigo) {
            post.setComentarios(comentarioDAO.findByArtigoId(post.getId()));
        }

        req.setAttribute("artigos", artigo);
        req.getRequestDispatcher("/WEB-INF/posts.jsp").forward(req, resp);
    }

}
