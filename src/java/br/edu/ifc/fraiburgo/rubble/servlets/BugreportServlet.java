package br.edu.ifc.fraiburgo.rubble.servlets;

import br.edu.ifc.fraiburgo.rubble.control.BugreportController;
import br.edu.ifc.fraiburgo.rubble.control.CidadeController;
import br.edu.ifc.fraiburgo.rubble.control.ComentarioController;
import br.edu.ifc.fraiburgo.rubble.control.PostagemController;
import br.edu.ifc.fraiburgo.rubble.control.UsuarioController;
import br.edu.ifc.fraiburgo.rubble.model.Bugreport;
import br.edu.ifc.fraiburgo.rubble.model.Comentario;
import br.edu.ifc.fraiburgo.rubble.model.Postagem;
import br.edu.ifc.fraiburgo.rubble.model.Usuario;
import static br.edu.ifc.fraiburgo.rubble.utils.ImageUtils.writeOutputStream;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author iuryk
 */
@WebServlet("/BugreportServlet")
public class BugreportServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        response.setCharacterEncoding("utf8");

        String start = request.getParameter("start");
        String limit = request.getParameter("limit");

        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setHeader("Cache-control", "no-cache, no-store");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Expires", "-1");
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "GET,POST");
        response.setHeader("Access-Control-Allow-Headers", "Content-Type");
        response.setHeader("Access-Control-Max-Age", "86400");

        boolean sucess = false;
        JsonObject myObj = new JsonObject();
        //get list of countries
        List<Comentario> comments = new ArrayList();
        if (request.getParameter("action").equals("register")) {
            try {
                Usuario u = new UsuarioController().getUsuarioById(Integer.parseInt(request.getParameter("idUsuario")));
                Bugreport b = new Bugreport();
                b.setIdUsuario(u);
                b.setReport(request.getParameter("report"));
               
                b = new BugreportController().mergeBugreport(b);
                sucess = true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        //add property as success
        myObj.addProperty("success", sucess);
        //convert the JSON to string and send back
        out.println(myObj.toString());
        out.close();
    }
}