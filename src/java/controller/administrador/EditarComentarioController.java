package controller.administrador;

import dao.ArtigoDAO;
import dao.CategoriaDAO;
import dao.ComentarioDAO;
import model.Artigo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import model.Categoria;
import model.Comentario;
import model.Usuario;

@WebServlet("/administrador/editar-comentario")
public class EditarComentarioController extends HttpServlet {

    ComentarioDAO dao = new ComentarioDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String param = req.getParameter("id");

        if (param != null) {
            Long id = Long.valueOf(param);
            dao.findById(id).ifPresent(i -> {
                req.setAttribute("comentario", i);
            });
        }

        req.getRequestDispatcher("/WEB-INF/administrador/editar-comentario.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
          ArtigoDAO dao = new ArtigoDAO();
        ComentarioDAO comentarioDAO = new ComentarioDAO();
        Artigo a = new Artigo();
        Usuario user = (Usuario) req.getSession().getAttribute("user");

        if (req.getParameter("id") != null) {
            a = dao.findById(Long.valueOf(req.getParameter("idArtigo"))).get();
            Comentario c = new Comentario();
            c.setId(Long.valueOf(req.getParameter("id")));
            c.setArtigo(a);
            c.setUsuario(user);
            c.setComentario(req.getParameter("comentario"));
            comentarioDAO.saveOrUpdate(c);
        }

       
        if (user.getPapel() == 0) {
            //se for adm
            resp.sendRedirect("/administrador/aprovacao-posts");
        } else {
             //se for comentarista
            resp.sendRedirect("/comentarista/posts");
        }
        
    }

}
