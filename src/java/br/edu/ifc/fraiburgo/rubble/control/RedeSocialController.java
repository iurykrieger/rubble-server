package br.edu.ifc.fraiburgo.rubble.control;

import br.edu.ifc.fraiburgo.rubble.model.RedeSocial;
import br.edu.ifc.fraiburgo.rubble.model.Usuario;
import br.edu.ifc.fraiburgo.rubble.persistence.RedeSocialPersistence;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ander
 */
public class RedeSocialController extends RedeSocialPersistence {

    @Override
    public List<RedeSocial> getRedeSocialByUsuario(Usuario usuario) {
        try {
            List<RedeSocial> rs;
            rs = super.getRedeSocialByUsuario(usuario);
            return rs;
        } catch (Exception ex) {
            Logger.getLogger(RedeSocialController.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public RedeSocial getRedeSocialById(int idRedeSocial) {
        try {
            RedeSocial rs = new RedeSocial();
            rs = super.getRedeSocialById(idRedeSocial);
            return rs;
        } catch (Exception ex) {
            Logger.getLogger(RedeSocialController.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public List<RedeSocial> getRedeSocials() {
        try {
            List<RedeSocial> rs;
            rs = super.getRedeSocials();
            return rs;
        } catch (Exception ex) {
            Logger.getLogger(RedeSocialController.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public void removeRedeSocial(RedeSocial redesocial) {
        try {
            super.removerObjeto(redesocial);
        } catch (Exception ex) {
            Logger.getLogger(RedeSocialController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public RedeSocial mergeRedeSocial(RedeSocial redesocial) {
        try {
            RedeSocial rs;
            rs = super.mergeRedeSocial(redesocial);
            return rs;
        } catch (Exception ex) {
            Logger.getLogger(RedeSocialController.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

}
