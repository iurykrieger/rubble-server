package br.edu.ifc.fraiburgo.rubble.servlets;

import br.edu.ifc.fraiburgo.rubble.control.UsuarioController;
import br.edu.ifc.fraiburgo.rubble.model.Usuario;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author iuryk
 */
@WebServlet("/UsuarioServlet")
public class UsuarioServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setCharacterEncoding("utf8");
        
        String start = request.getParameter("start");
        String limit = request.getParameter("limit");

        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setHeader("Cache-control", "no-cache, no-store");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Expires", "-1");
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST");
        response.setHeader("Access-Control-Allow-Headers", "Content-Type");
        response.setHeader("Access-Control-Max-Age", "86400");

        boolean b = false;
        JsonElement usuarioObj = null;
        try {
            Long id = Long.parseLong(request.getParameter("idUsuario"));
            if (id != null) {
                Usuario u = new UsuarioController().getUsuarioById(id.intValue());
                if (u != null) {
                    b = true;
                    u.setBugreportList(null);
                    u.setComentarioList(null);
                    u.setConquistaList(null);
                    u.setMarcacaoList(null);
                    u.setPostagemList(null);
                    u.setRedeSocialList(null);
                    u.setStatusList(null);
                    u.setIdCidade(null);
                    Gson gson = new Gson();
                    usuarioObj = gson.toJsonTree(u);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        JsonObject myObj = new JsonObject();
        myObj.addProperty("success", b);
        myObj.add("user", usuarioObj);
        out.println(myObj.toString());
        out.close();
    }
}
