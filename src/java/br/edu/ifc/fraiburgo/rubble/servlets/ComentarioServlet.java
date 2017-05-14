package br.edu.ifc.fraiburgo.rubble.servlets;

import br.edu.ifc.fraiburgo.rubble.control.ComentarioController;
import br.edu.ifc.fraiburgo.rubble.control.PostagemController;
import br.edu.ifc.fraiburgo.rubble.control.StatusController;
import br.edu.ifc.fraiburgo.rubble.control.UsuarioController;
import br.edu.ifc.fraiburgo.rubble.model.Comentario;
import br.edu.ifc.fraiburgo.rubble.model.Postagem;
import br.edu.ifc.fraiburgo.rubble.model.Status;
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
@WebServlet("/ComentarioServlet")
public class ComentarioServlet extends HttpServlet {

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
        //get list of countries
        List<Comentario> comments = new ArrayList();
        if (request.getParameter("action").equals("postComments")) {
            try {
                Integer idPostagem = Integer.parseInt(request.getParameter("idPostagem"));
                if (idPostagem != null) {
                    Postagem p = new PostagemController().getPostagemById(idPostagem);
                    comments = new ComentarioController().getComentarioByPostagem(p);
                    sucess = true;
                    if (comments.size() != 0) {
                        for (Comentario c : comments) {
                            c.setIdPostagem(null);
                            c.setMarcacaoList(null);
                            c.getIdUsuario().setComentarioList(null);
                            c.getIdUsuario().setConquistaList(null);
                            c.getIdUsuario().setMarcacaoList(null);
                            c.getIdUsuario().setPostagemList(null);
                            c.getIdUsuario().setRedeSocialList(null);
                            c.getIdUsuario().setStatusList(null);
                            c.getIdUsuario().setBugreportList(null);
                            c.getIdUsuario().setIdCidade(null);
                            Gson gson = new Gson();
                            JsonElement comentarioObj = gson.toJsonTree(c);
                            arrayObj.add(comentarioObj);
                        }
                    } else {
                        arrayObj = null;
                    }
                    myObj.addProperty("size", comments.size());
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else if (request.getParameter("action").equals("register")) {
            try {
                Usuario u = new UsuarioController().getUsuarioById(Integer.parseInt(request.getParameter("idUsuario")));
                u.setNumComentarios(u.getNumComentarios() + 1);
                u = new UsuarioController().mergeUsuario(u);
                Postagem p = new PostagemController().getPostagemById(Integer.parseInt(request.getParameter("idPostagem")));
                p.setNumComentarios(p.getNumComentarios() + 1);
                p = new PostagemController().mergePostagem(p);
                Comentario c = new Comentario();
                c.setComentario(request.getParameter("comentario"));
                c.setData(new Date());
                c.setIdPostagem(p);
                c.setIdUsuario(u);
                String imageBase64 = request.getParameter("foto");
                if (imageBase64 != null) {
                    File saveFile = new File(getServletContext().getRealPath("/Content/Image") + "/" + System.currentTimeMillis() + ".jpg");
                    OutputStream output = new FileOutputStream(saveFile);
                    writeOutputStream(imageBase64, output);
                    c.setFoto("/Content/Image/" + saveFile.getName());
                    output.flush();
                    output.close();
                }
                c = new ComentarioController().mergeComentario(c);
                c.setIdPostagem(null);
                c.setMarcacaoList(null);
                c.getIdUsuario().setComentarioList(null);
                c.getIdUsuario().setConquistaList(null);
                c.getIdUsuario().setMarcacaoList(null);
                c.getIdUsuario().setPostagemList(null);
                c.getIdUsuario().setRedeSocialList(null);
                c.getIdUsuario().setStatusList(null);
                c.getIdUsuario().setIdCidade(null);
                Gson gson = new Gson();
                JsonElement comentarioObj = gson.toJsonTree(c);
                myObj.add("comentario", comentarioObj);
                sucess = true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        //add property as success
        myObj.addProperty("success", sucess);
        //add the countryList object
        myObj.add("comentarioList", arrayObj);
        //convert the JSON to string and send back
        out.println(myObj.toString());
        out.close();
    }
}
