package controller.administrador;

import dao.ArtigoDAO;
import dao.CategoriaDAO;
import dao.UsuarioDAO;
import model.Artigo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import model.Categoria;
import model.Usuario;

@WebServlet("/administrador/editar-cadastro")
public class EditarCadastroController extends HttpServlet {

    UsuarioDAO dao = new UsuarioDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String param = req.getParameter("id");

        if (param != null) {
            Long id = Long.valueOf(param);
            dao.findById(id).ifPresent(i -> {
                req.setAttribute("usuario", i);
            });
        }

        req.getRequestDispatcher("/WEB-INF/administrador/editar-cadastro.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Usuario usuario = new Usuario();

        Integer papel;

        String param = req.getParameter("id");
        if (param != null) {
            usuario.setId(Long.valueOf(param));
        }

        usuario.setNome(req.getParameter("nome"));
        usuario.setSenha(req.getParameter("senha"));
        usuario.setCpf(req.getParameter("cpf"));
        usuario.setEmail(req.getParameter("email"));
        if (req.getParameter("papel").equals("Desejo ser autor(a) do Blog") == true) {
            papel = 1;
        } else if (req.getParameter("papel").equals("Desejo comentar nos posts do Blog") == true) {
            papel = 2;
        } else {
            papel = 0;
        }
        usuario.setPapel(papel);
        usuario.setCadastroAprovado(req.getParameter("cadastroAprovado"));

        dao.saveOrUpdate(usuario);
        resp.sendRedirect("/administrador/usuarios");

    }

}
