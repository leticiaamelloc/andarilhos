package controller.autor;

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

@WebServlet("/autor/meus-posts")
public class MeusPostsController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
          
        ArtigoDAO dao = new ArtigoDAO();
          ComentarioDAO comentarioDAO = new ComentarioDAO();
        List<Artigo> artigos;
           Usuario user = (Usuario) req.getSession().getAttribute("user");
        artigos = dao.findByUsuarioId(user.getId());

        for (Artigo post : artigos) {
            post.setComentarios(comentarioDAO.findByArtigoId(post.getId()));
        }
     
        String param = req.getParameter("op");

        if (req.getParameter("id") != null) {
            Long id = Long.valueOf(req.getParameter("id"));
            if (param.equals("excluir")) {
                dao.delete(id);
            } else if (param.equals("liberar")) {
                Artigo a = new Artigo();
                a = dao.findById(Long.valueOf(req.getParameter("id"))).get();
                a.setLiberar("S");
                dao.saveOrUpdate(a);
            } else {
                Artigo a = new Artigo();
                a = dao.findById(Long.valueOf(req.getParameter("id"))).get();
                a.setLiberar("S");
            }

        }

        req.setAttribute("artigos", artigos);
        req.getRequestDispatcher("/WEB-INF/autor/meus-posts.jsp").forward(req, resp);
    }

}
