package br.edu.ifc.fraiburgo.rubble.control;

import br.edu.ifc.fraiburgo.rubble.model.Usuario;
import br.edu.ifc.fraiburgo.rubble.persistence.UsuarioPersistence;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author iuryk
 */
public class UsuarioController extends UsuarioPersistence {

    @Override
    public Usuario mergeUsuario(Usuario usuario) {
        try {
            Usuario u;
            u = super.mergeUsuario(usuario);
            return u;
        } catch (Exception ex) {
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public Usuario getUsuarioById(int idUsuario) {
        try {
            Usuario u;
            u = super.getUsuarioById(idUsuario);
            return u;
        } catch (Exception ex) {
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
