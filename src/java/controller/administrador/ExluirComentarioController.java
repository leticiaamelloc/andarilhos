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

@WebServlet("/administrador/excluir-comentario")
public class ExluirComentarioController extends HttpServlet {

    ComentarioDAO dao = new ComentarioDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String param = req.getParameter("id");
         Usuario user = (Usuario) req.getSession().getAttribute("user");

           if (param != null) { 
                dao.delete(Long.valueOf(param));
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
