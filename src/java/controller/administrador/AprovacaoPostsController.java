package controller.administrador;

import controller.autor.*;
import dao.ArtigoDAO;
import dao.CategoriaDAO;
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
import model.Categoria;

@WebServlet("/administrador/aprovacao-posts")
public class AprovacaoPostsController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArtigoDAO dao = new ArtigoDAO();
        ComentarioDAO comentarioDAO = new ComentarioDAO();
        List<Artigo> artigos;
        artigos = dao.findByLiberado();
         for (Artigo post : artigos) {
            post.setComentarios(comentarioDAO.findByArtigoId(post.getId()));
        }


        if ("true".equals(req.getParameter("aprovar"))) {

            if (req.getParameter("id") != null) {
                Artigo a = new Artigo();
                a = dao.findById(Long.valueOf(req.getParameter("id"))).get();
                a.setAprovado("S");
                dao.saveOrUpdate(a);
            }
        } else {
            if (req.getParameter("id") != null) {
                dao.delete(Long.valueOf(req.getParameter("id")));
            }
        }
        
        
        req.setAttribute("artigos", artigos);
        req.getRequestDispatcher("/WEB-INF/administrador/aprovacao-posts.jsp").forward(req, resp);
    }

}
