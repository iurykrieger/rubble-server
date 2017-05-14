package br.edu.ifc.fraiburgo.rubble.persistence;

import br.edu.ifc.fraiburgo.rubble.model.Conquista;
import br.edu.ifc.fraiburgo.rubble.model.Conquista_;
import br.edu.ifc.fraiburgo.rubble.model.Usuario;
import br.edu.ifc.fraiburgo.rubble.utils.Persist;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author ander
 */
public class ConquistaPersistence extends Persist {
    
    public Conquista mergeConquista(Conquista conquista) throws Exception{
        Conquista c = new Conquista();
        c = (Conquista) inserirObjeto(conquista);
        return c;
    }
    
    public void removeConquista(Conquista conquista) throws Exception{
        removerObjeto(conquista);
    }
    
    public List<Conquista> getConquistas() throws Exception{
        List<Conquista> c = new ArrayList();
        c = (List<Conquista>) consultarObjetos(Conquista.class);
        return c;
    }
    
    public List<Conquista> getConquistaByUsuario(Usuario usuario) throws Exception{
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery query = cb.createQuery();
        Root<Conquista> from = query.from(Conquista.class);
        query.select(from);
        query.where(cb.and(cb.equal(from.get(Conquista_.idUsuario), usuario)));
        return (List<Conquista>) em.createQuery(query).getResultList();
    }
    
    public Conquista getConquistaById(int idConquista) throws Exception{
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery query = cb.createQuery();
        Root<Conquista> from = query.from(Conquista.class);
        query.select(from);
        query.where(cb.and(cb.equal(from.get(Conquista_.idConquista), idConquista)));
        return (Conquista) em.createQuery(query).getSingleResult();
    }
    
}
