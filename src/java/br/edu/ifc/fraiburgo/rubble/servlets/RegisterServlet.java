package br.edu.ifc.fraiburgo.rubble.servlets;

import br.edu.ifc.fraiburgo.rubble.control.CidadeController;
import br.edu.ifc.fraiburgo.rubble.control.UsuarioController;
import br.edu.ifc.fraiburgo.rubble.model.Usuario;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author iuryk
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            resp.setContentType("application/json");
            String nome = req.getParameter("name");
            String email = req.getParameter("email");
            String password = req.getParameter("password");
            int idCidade = Integer.valueOf(req.getParameter("idCidade"));
            Usuario u = new Usuario();
            u.setNome(nome);
            u.setEmail(email);
            u.setSenha(password);
            u.setNumComentarios(0);
            u.setNumPostagens(0);
            u.setIdCidade(new CidadeController().getCidadeById(idCidade));
            u = new UsuarioController().mergeUsuario(u);
            System.out.println("Usuário salvo com sucesso!");
        } catch (Exception e) {
            System.out.println("Deu ruim!");
            e.printStackTrace();
        }
    }
}