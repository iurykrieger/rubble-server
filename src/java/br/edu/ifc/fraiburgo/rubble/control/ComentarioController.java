package br.edu.ifc.fraiburgo.rubble.control;

import br.edu.ifc.fraiburgo.rubble.model.Comentario;
import br.edu.ifc.fraiburgo.rubble.model.Postagem;
import br.edu.ifc.fraiburgo.rubble.model.Usuario;
import br.edu.ifc.fraiburgo.rubble.persistence.ComentarioPersistence;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ander
 */
public class ComentarioController extends ComentarioPersistence {

    @Override
    public List<Comentario> getComentarioByUsuario(Usuario usuario) {
        try {
            List<Comentario> c;
            c = super.getComentarioByUsuario(usuario);
            return c;
        } catch (Exception ex) {
            Logger.getLogger(ComentarioController.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public List<Comentario> getComentarioByPostagem(Postagem postagem) {
        try {
            List<Comentario> c;
            c = super.getComentarioByPostagem(postagem);
            return c;
        } catch (Exception ex) {
            Logger.getLogger(ComentarioController.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public Comentario getComentarioById(int idComentario) {
        try {
            Comentario c;
            c = super.getComentarioById(idComentario);
            return c;
        } catch (Exception ex) {
            Logger.getLogger(ComentarioController.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public List<Comentario> getComentarios() {
        try {
            List<Comentario> c;
            c = super.getComentarios();
            return c;
        } catch (Exception ex) {
            Logger.getLogger(ComentarioController.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public void removeComentario(Comentario comentario) {
        try {
            super.removerObjeto(comentario);
        } catch (Exception ex) {
            Logger.getLogger(ComentarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Comentario mergeComentario(Comentario comentario) {
        try {
            Comentario c;
            c = super.mergeComentario(comentario);
            return c;
        } catch (Exception ex) {
            Logger.getLogger(ComentarioController.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
