package br.edu.ifc.fraiburgo.rubble.servlets;

import br.edu.ifc.fraiburgo.rubble.control.CidadeController;
import br.edu.ifc.fraiburgo.rubble.control.EstadoController;
import br.edu.ifc.fraiburgo.rubble.model.Cidade;
import br.edu.ifc.fraiburgo.rubble.model.Estado;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet("/CidadeServlet")
public class CidadeServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public CidadeServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setCharacterEncoding("utf8");

        String start = request.getParameter("start");
        String limit = request.getParameter("limit");
        int idEstado = Integer.parseInt(request.getParameter("idEstado"));

        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setHeader("Cache-control", "no-cache, no-store");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Expires", "-1");
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "GET,POST");
        response.setHeader("Access-Control-Allow-Headers", "Content-Type");
        response.setHeader("Access-Control-Max-Age", "86400");

        //get list of countries
        Estado estado = new EstadoController().getEstadoById(idEstado);
        List<Cidade> cidadeList = new CidadeController().getCidadeByEstado(estado);
        for (Cidade c : cidadeList) {
            c.setUsuarioList(null);
            c.setIdEstado(null);
        }

        Gson gson = new Gson();
        JsonArray arrayObj = new JsonArray();
        for (int i = 0; i < cidadeList.size(); i++) {
            JsonElement cidadeObj = gson.toJsonTree(cidadeList.get(i));
            arrayObj.add(cidadeObj);
        }
        //create a new JSON object
        JsonObject myObj = new JsonObject();
        //add property as success
        myObj.addProperty("success", true);
        //add the countryList object
        myObj.add("cidadeList", arrayObj);
        //convert the JSON to string and send back
        out.println(myObj.toString());
        out.close();
    }
}
