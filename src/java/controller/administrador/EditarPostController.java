package controller.administrador;

import dao.ArtigoDAO;
import dao.CategoriaDAO;
import model.Artigo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import model.Categoria;
import model.Usuario;

@WebServlet("/administrador/editar-post")
public class EditarPostController extends HttpServlet {

    ArtigoDAO dao = new ArtigoDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String param = req.getParameter("id");

        if (param != null) {
            Long id = Long.valueOf(param);
            dao.findById(id).ifPresent(i -> {
                req.setAttribute("artigo", i);
            });
        }

        req.getRequestDispatcher("/WEB-INF/administrador/editar-post.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String param = req.getParameter("id");
        Artigo a = new Artigo();
        Categoria categoria = new Categoria();
        CategoriaDAO Cdao = new CategoriaDAO();
        Usuario user = (Usuario) req.getSession().getAttribute("user");

        categoria = Cdao.findByDescricao(req.getParameter("categoria"));

        if (categoria.getId() == null) {
            categoria.setDescricao(req.getParameter("categoria"));
            Cdao.saveOrUpdate(categoria);
            categoria = Cdao.findByDescricao(req.getParameter("categoria"));
        }

        if (param != null) {
            a.setId(Long.valueOf(param));
        }

        a.setTitulo(req.getParameter("titulo"));
        a.setCategoria(categoria);
        a.setConteudo(req.getParameter("conteudo"));
        a.setLiberar("N");
        a.setAprovado("N");
        a.setUsuario(user);

        dao.saveOrUpdate(a);
        resp.sendRedirect("/autor/meus-posts");
    }

}
