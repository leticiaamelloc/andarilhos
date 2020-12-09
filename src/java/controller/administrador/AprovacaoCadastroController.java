package controller.administrador;

import dao.UsuarioDAO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import model.Usuario;

@WebServlet("/administrador/aprovacao-cadastro")
public class AprovacaoCadastroController extends HttpServlet {

    UsuarioDAO dao = new UsuarioDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String param = req.getParameter("id");
        String param2 = req.getParameter("op");

        if (param != null && param2 != null) {
            Long id = Long.valueOf(req.getParameter("id"));

            if (param2.equals("deletar")) {
                dao.delete(id);
            } else if (param2.equals("aprovar")) {
                Usuario u = dao.findById(id).get();
                u.setCadastroAprovado("S");
                dao.saveOrUpdate(u);
            }
        }

        req.setAttribute("usuarios", dao.findByAprovacaoCadastro("N"));
        req.getRequestDispatcher("/WEB-INF/administrador/aprovacao-cadastro.jsp").forward(req, resp);
    }

}
