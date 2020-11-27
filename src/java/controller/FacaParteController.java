/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.UsuarioDAO;
import model.Usuario;

import javax.servlet.ServletException;
import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author lcunha
 */
@WebServlet("/faca_parte")
public class FacaParteController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/faca_parte.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Usuario usuario = new Usuario();
        UsuarioDAO dao = new UsuarioDAO();

        Integer papel;

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
        usuario.setCadastroAprovado("N");

        dao.saveOrUpdate(usuario);
        req.getRequestDispatcher("/WEB-INF/faca_parte.jsp").forward(req, resp);
    }

}
