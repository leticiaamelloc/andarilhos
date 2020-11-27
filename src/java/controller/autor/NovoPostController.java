package controller.autor;

import dao.ArtigoDAO;
import dao.UsuarioDAO;
import dao.CategoriaDAO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;
import model.Artigo;
import model.Usuario;
import model.Categoria;

@WebServlet("/autor/novo-post")
public class NovoPostController extends HttpServlet {

    UsuarioDAO Udao = new UsuarioDAO();
       
     @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Usuario user = (Usuario) req.getSession().getAttribute("user");
        req.setAttribute("usuario", Udao.findById(user.getId()).get());
        
        req.getRequestDispatcher("/WEB-INF/autor/novo-post.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Artigo artigo = new Artigo();
        ArtigoDAO dao = new ArtigoDAO();
        Categoria categoria = new Categoria();
        CategoriaDAO Cdao = new CategoriaDAO(); 
        Usuario user = (Usuario) req.getSession().getAttribute("user");
        
       
        categoria = Cdao.findByDescricao(req.getParameter("categoria"));
        
        if(categoria.getId() == null) {
            categoria.setDescricao(req.getParameter("categoria"));
            Cdao.saveOrUpdate(categoria);
            categoria = Cdao.findByDescricao(req.getParameter("categoria"));
        }
           
        artigo.setTitulo(req.getParameter("titulo"));
        artigo.setConteudo(req.getParameter("conteudo"));
        artigo.setLiberar("N");
        artigo.setAprovado("N");
        artigo.setUsuario(user);
        artigo.setCategoria(categoria);
       

        dao.saveOrUpdate(artigo);
        req.getRequestDispatcher("/WEB-INF/autor/novo-post.jsp").forward(req, resp);
    }

}
