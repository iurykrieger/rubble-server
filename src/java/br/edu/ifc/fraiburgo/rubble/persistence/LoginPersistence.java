package br.edu.ifc.fraiburgo.rubble.persistence;

import br.edu.ifc.fraiburgo.rubble.model.Usuario;
import br.edu.ifc.fraiburgo.rubble.model.Usuario_;
import br.edu.ifc.fraiburgo.rubble.utils.Persist;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author iuryk
 */
public class LoginPersistence extends Persist{
    
    public Usuario login(String email, String password) throws Exception{
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery query = cb.createQuery();
        Root<Usuario> from = query.from(Usuario.class);
        query.select(from);
        query.where(cb.and(cb.equal(from.get(Usuario_.email),email),cb.equal(from.get(Usuario_.senha), password)));
        Usuario u = (Usuario) em.createQuery(query).getSingleResult();
        return u;
    }
}
