package br.edu.ifc.fraiburgo.rubble.servlets;

import br.edu.ifc.fraiburgo.rubble.control.ComentarioController;
import br.edu.ifc.fraiburgo.rubble.control.PostagemController;
import br.edu.ifc.fraiburgo.rubble.control.StatusController;
import br.edu.ifc.fraiburgo.rubble.control.UsuarioController;
import br.edu.ifc.fraiburgo.rubble.model.Comentario;
import br.edu.ifc.fraiburgo.rubble.model.Postagem;
import br.edu.ifc.fraiburgo.rubble.model.Status;
import br.edu.ifc.fraiburgo.rubble.model.Usuario;
import br.edu.ifc.fraiburgo.rubble.utils.ImageUtils;
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
import javax.persistence.Tuple;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author iuryk
 */
@WebServlet("/PostagemServlet")
@MultipartConfig
public class PostagemServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setCharacterEncoding("utf8");
        String action = request.getParameter("action");

        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setHeader("Expires", "-1");
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST");
        JsonElement postagemObj = null;
        JsonArray arrayObj = new JsonArray();
        JsonObject myObj = new JsonObject();
        boolean b = false;
        if (action.equals("register")) {
            try {
                Usuario u = new UsuarioController().getUsuarioById(Integer.parseInt(request.getParameter("idUsuario")));
                u.setNumPostagens(u.getNumPostagens() + 1);
                u = new UsuarioController().mergeUsuario(u);
                Postagem postagem = new Postagem();
                postagem.setLatitude(Double.parseDouble(request.getParameter("latitude")));
                postagem.setLongitude(Double.parseDouble(request.getParameter("longitude")));
                postagem.setData(new Date());
                postagem.setDescricao(request.getParameter("descricao"));
                postagem.setIdUsuario(u);
                postagem.setNumComentarios(0);
                postagem.setTipo(request.getParameter("tipo"));
                postagem.setVizualizacoes(0);
                String imageBase64 = request.getParameter("foto");
                if (imageBase64 != null) {
                    File saveFile = new File(getServletContext().getRealPath("/Content/Image") + "/" + System.currentTimeMillis() + ".jpg");
                    OutputStream output = new FileOutputStream(saveFile);
                    writeOutputStream(imageBase64, output);
                    postagem.setFoto("/Content/Image/" + saveFile.getName());
                    output.flush();
                    output.close();
                }
                postagem = new PostagemController().mergePostagem(postagem);
                Status status = new Status();
                status.setAtivo(true);
                status.setData(new Date());
                status.setIdPostagem(postagem);
                status.setIdUsuario(u);
                status.setStatus(request.getParameter("status"));
                status = new StatusController().mergeStatus(status);
                postagem.setComentarioList(null);
                postagem.setStatusList(null);
                postagem.setIdUsuario(null);
                Gson gson = new Gson();
                postagemObj = gson.toJsonTree(postagem);
                myObj.add("postagem", postagemObj);
                b = true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (action.equals("get")) {
            try {
                List<Tuple> result = new PostagemController().getAllPostagemPosition();
                if (result != null) {
                    Gson gson = new Gson();
                    for (Tuple t : result) {
                        Postagem p = new Postagem();
                        p.setIdPostagem((Long) t.get(0));
                        p.setLatitude((Double) t.get(1));
                        p.setLongitude((Double) t.get(2));
                        JsonElement estadoObj = gson.toJsonTree(p);
                        arrayObj.add(estadoObj);
                    }
                    b = true;
                    myObj.add("postagemList", arrayObj);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (action.equals("build")) {
            try {
                Integer idPostagem = Integer.parseInt(request.getParameter("idPostagem"));
                if (idPostagem != null) {
                    Postagem post = new PostagemController().getPostagemById(idPostagem);
                    if (post != null) {
                        post.setVizualizacoes(post.getVizualizacoes() + 1);
                        post = new PostagemController().mergePostagem(post);
                        Status s = new StatusController().getActiveStatusByPostagem(post);
                        s.setIdUsuario(null);
                        s.setIdPostagem(null);
                        List<Status> lista = new ArrayList<>();
                        lista.add(s);
                        post.setComentarioList(null);
                        post.setStatusList(lista);
                        post.getIdUsuario().setComentarioList(null);
                        post.getIdUsuario().setConquistaList(null);
                        post.getIdUsuario().setMarcacaoList(null);
                        post.getIdUsuario().setPostagemList(null);
                        post.getIdUsuario().setRedeSocialList(null);
                        post.getIdUsuario().setStatusList(null);
                        post.getIdUsuario().setIdCidade(null);
                        post.getIdUsuario().setBugreportList(null);
                        Gson gson = new Gson();
                        postagemObj = gson.toJsonTree(post);
                        myObj.add("postagem", postagemObj);
                        b = true;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (action.equals("userPosts")) {
            try {
                Usuario u = new UsuarioController().getUsuarioById(Integer.parseInt(request.getParameter("idUsuario")));
                List<Postagem> posts = new PostagemController().getPostagemByUsuario(u);
                if (posts != null) {
                    Gson gson = new Gson();
                    for (Postagem p : posts) {
                        p.setComentarioList(null);
                        p.setIdUsuario(null);
                        p.setStatusList(null);
                        JsonElement estadoObj = gson.toJsonTree(p);
                        arrayObj.add(estadoObj);
                    }
                    b = true;
                    myObj.add("postagemList", arrayObj);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (action.equals("trending")) {
            String by = request.getParameter("by");
            try {
                Integer first = Integer.parseInt(request.getParameter("first"));
                Integer max = Integer.parseInt(request.getParameter("max"));
                List<Postagem> posts = new ArrayList();
                if (by.equals("views")) {
                    posts = new PostagemController().getLimitedPostagensByViews(first, max);
                } else if (by.equals("comments")) {
                    posts = new PostagemController().getLimitedPostagensByComments(first, max);
                }
                b = true;
                if (posts.size() != 0) {
                    for (Postagem p : posts) {
                        p.setComentarioList(null);
                        p.setIdUsuario(null);
                        p.setStatusList(null);
                        Gson gson = new Gson();
                        postagemObj = gson.toJsonTree(p);
                        arrayObj.add(postagemObj);
                    }
                    myObj.add("postagemList", arrayObj);
                } else {
                    arrayObj = null;
                }
                myObj.addProperty("size", posts.size());
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        myObj.addProperty("success", b);
        out.println(myObj.toString());
        out.close();
    }
}
