/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifc.fraiburgo.rubble.servlets;

import br.edu.ifc.fraiburgo.rubble.control.PostagemController;
import br.edu.ifc.fraiburgo.rubble.control.StatusController;
import br.edu.ifc.fraiburgo.rubble.control.UsuarioController;
import br.edu.ifc.fraiburgo.rubble.model.Comentario;
import br.edu.ifc.fraiburgo.rubble.model.Postagem;
import br.edu.ifc.fraiburgo.rubble.model.Status;
import br.edu.ifc.fraiburgo.rubble.model.Usuario;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.io.IOException;
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
@WebServlet("/StatusServlet")
public class StatusServlet extends HttpServlet {

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
        response.setHeader("Access-Control-Allow-Methods", "GET,POST");
        response.setHeader("Access-Control-Allow-Headers", "Content-Type");
        response.setHeader("Access-Control-Max-Age", "86400");

        boolean sucess = false;
        JsonArray arrayObj = new JsonArray();
        JsonObject myObj = new JsonObject();
        List<Comentario> comments = new ArrayList();
        if (request.getParameter("action").equals("change")) {
            try {
                Postagem p = new PostagemController().getPostagemById(Integer.parseInt(request.getParameter("idPostagem")));
                Usuario u = new UsuarioController().getUsuarioById(Integer.parseInt(request.getParameter("idUsuario")));
                Status s = new Status();
                s.setAtivo(true);
                s.setData(new Date());
                s.setIdPostagem(p);
                s.setIdUsuario(u);
                s.setStatus(request.getParameter("status"));
                s = new StatusController().mergeStatus(s);
                new StatusController().setAllStatusInactive(s.getIdStatus(),p);
                s.setIdPostagem(null);
                s.setIdUsuario(null);
                Gson gson = new Gson();
                JsonElement statusObj = gson.toJsonTree(s);
                myObj.add("status", statusObj);
                sucess = true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        myObj.addProperty("success", sucess);
        out.println(myObj.toString());
        out.close();
    }
}
