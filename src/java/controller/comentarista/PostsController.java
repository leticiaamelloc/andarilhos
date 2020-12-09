package controller.comentarista;

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

@WebServlet("/comentarista/posts")
public class PostsController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Usuario user = (Usuario) req.getSession().getAttribute("user");
        ArtigoDAO dao = new ArtigoDAO();
        ComentarioDAO comentarioDAO = new ComentarioDAO();
        Artigo a = new Artigo();

        if (req.getParameter("id") != null) {
            a = dao.findById(Long.valueOf(req.getParameter("id"))).get();
            Comentario c = new Comentario();
            c.setArtigo(a);
            c.setUsuario(user);
            c.setComentario(req.getParameter("comentario"));
            comentarioDAO.saveOrUpdate(c);
        }

        List<Artigo> artigo;
        artigo = dao.findByAprovado();

        for (Artigo post : artigo) {
            post.setComentarios(comentarioDAO.findByArtigoId(post.getId()));
        }

        req.setAttribute("artigos", artigo);
        req.getRequestDispatcher("/WEB-INF/comentarista/posts.jsp").forward(req, resp);
    }

}
