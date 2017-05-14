package br.edu.ifc.fraiburgo.rubble.servlets;

import br.edu.ifc.fraiburgo.rubble.control.LoginController;
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
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String start = request.getParameter("start");
        String limit = request.getParameter("limit");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Cache-control", "no-cache, no-store");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Expires", "-1");
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST");
        response.setHeader("Access-Control-Allow-Headers", "Content-Type");
        response.setHeader("Access-Control-Max-Age", "86400");

        //test password and email
        boolean b = false;
        JsonElement usuarioObj = null;
        Usuario u = new LoginController().login(email, password);
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
        //create a new JSON object
        JsonObject myObj = new JsonObject();
        //add property as success
        myObj.addProperty("success", b);
        myObj.add("user", usuarioObj);
        //convert the JSON to string and send back
        out.println(myObj.toString());
        out.close();
    }
}
