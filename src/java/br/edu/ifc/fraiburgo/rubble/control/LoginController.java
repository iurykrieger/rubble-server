package br.edu.ifc.fraiburgo.rubble.control;

import br.edu.ifc.fraiburgo.rubble.model.Usuario;
import br.edu.ifc.fraiburgo.rubble.persistence.LoginPersistence;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author iuryk
 */
public class LoginController extends LoginPersistence{
    
    @Override
    public Usuario login(String email, String password){
        try {
            Usuario u;
            u = super.login(email, password);
            return u;
        } catch (Exception ex) {
            return null;
        }
    }
}
