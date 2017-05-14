package br.edu.ifc.fraiburgo.rubble.persistence;

import br.edu.ifc.fraiburgo.rubble.model.Postagem;
import br.edu.ifc.fraiburgo.rubble.model.Postagem_;
import br.edu.ifc.fraiburgo.rubble.model.Usuario;
import br.edu.ifc.fraiburgo.rubble.utils.Persist;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Tuple;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author iuryk
 */
public class PostagemPersistence extends Persist{
    
    public Postagem mergePostagem(Postagem postagem) throws Exception{
        Postagem p = new Postagem();
        p = (Postagem) inserirObjeto(postagem);
        return p;
    }
    
    public void removePostagem(Postagem postagem) throws Exception{
        removerObjeto(postagem);
    }
    
    public List<Postagem> getPostagems() throws Exception{
        List<Postagem> p = new ArrayList();
        p = (List<Postagem>) consultarObjetos(Postagem.class);
        return p;
    }
    
    public List<Postagem> getPostagemByUsuario(Usuario usuario) throws Exception{
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery query = cb.createQuery();
        Root<Postagem> from = query.from(Postagem.class);
        query.select(from);
        query.where(cb.and(cb.equal(from.get(Postagem_.idUsuario), usuario)));
        return (List<Postagem>) em.createQuery(query).getResultList();
    }
    
    public List<Postagem> getLimitedPostagensByViews(int first,int max) throws Exception{
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery query = cb.createQuery();
        Root<Postagem> from = query.from(Postagem.class);
        query.select(from);
        query.orderBy(cb.desc(from.get(Postagem_.vizualizacoes)));
        return (List<Postagem>) em.createQuery(query).setFirstResult(first).setMaxResults(max).getResultList();
    }
    
    public List<Postagem> getLimitedPostagensByComments(int first,int max) throws Exception{
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery query = cb.createQuery();
        Root<Postagem> from = query.from(Postagem.class);
        query.select(from);
        query.orderBy(cb.desc(from.get(Postagem_.numComentarios)));
        return (List<Postagem>) em.createQuery(query).setFirstResult(first).setMaxResults(max).getResultList();
    }
    
    public Postagem getPostagemById(int idPostagem) throws Exception{
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery query = cb.createQuery();
        Root<Postagem> from = query.from(Postagem.class);
        query.select(from);
        query.where(cb.and(cb.equal(from.get(Postagem_.idPostagem), idPostagem)));
        return (Postagem) em.createQuery(query).getSingleResult();
    }
    
    public List<Tuple> getAllPostagemPosition() throws Exception{
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Tuple> cq = cb.createTupleQuery();
        Root<Postagem> root = cq.from(Postagem.class);
        cq.multiselect(root.get(Postagem_.idPostagem), root.get(Postagem_.latitude), root.get(Postagem_.longitude));
        return (List<Tuple>) em.createQuery(cq).getResultList();
    }
}
