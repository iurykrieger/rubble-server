package br.edu.ifc.fraiburgo.rubble.control;

import br.edu.ifc.fraiburgo.rubble.model.Postagem;
import br.edu.ifc.fraiburgo.rubble.model.Usuario;
import br.edu.ifc.fraiburgo.rubble.persistence.PostagemPersistence;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Tuple;

/**
 *
 * @author iuryk
 */
public class PostagemController extends PostagemPersistence {

    @Override
    public List<Tuple> getAllPostagemPosition() {
        try {
            List<Tuple> tuplas;
            tuplas = super.getAllPostagemPosition();
            return tuplas;
        } catch (Exception ex) {
            Logger.getLogger(PostagemController.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public List<Postagem> getPostagemByUsuario(Usuario usuario) {
        try {
            List<Postagem> p;
            p = super.getPostagemByUsuario(usuario);
            return p;
        } catch (Exception ex) {
            Logger.getLogger(PostagemController.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public Postagem getPostagemById(int idPostagem) {
        try {
            Postagem p;
            p = super.getPostagemById(idPostagem);
            return p;
        } catch (Exception ex) {
            Logger.getLogger(PostagemController.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public List<Postagem> getPostagems() {
        try {
            List<Postagem> p;
            p = super.getPostagems();
            return p;
        } catch (Exception ex) {
            Logger.getLogger(PostagemController.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public void removePostagem(Postagem postagem) {
        try {
            super.removerObjeto(postagem);
        } catch (Exception ex) {
            Logger.getLogger(PostagemController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Postagem mergePostagem(Postagem postagem) {
        try {
            Postagem p;
            p = super.mergePostagem(postagem);
            return p;
        } catch (Exception ex) {
            Logger.getLogger(PostagemController.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public List<Postagem> getLimitedPostagensByComments(int first, int max) {
        try {
            List<Postagem> p;
            p = super.getLimitedPostagensByComments(first, max);
            return p;
        } catch (Exception ex) {
            Logger.getLogger(PostagemController.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public List<Postagem> getLimitedPostagensByViews(int first, int max) {
        try {
            List<Postagem> p;
            p = super.getLimitedPostagensByViews(first, max);
            return p;
        } catch (Exception ex) {
            Logger.getLogger(PostagemController.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
