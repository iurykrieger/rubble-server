package br.edu.ifc.fraiburgo.rubble.persistence;

import br.edu.ifc.fraiburgo.rubble.model.Comentario;
import br.edu.ifc.fraiburgo.rubble.model.Marcacao;
import br.edu.ifc.fraiburgo.rubble.model.Marcacao_;
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
public class MarcacaoPersistence extends Persist{
    
    public Marcacao mergeMarcacao(Marcacao marcacao) throws Exception{
        Marcacao m = new Marcacao();
        m = (Marcacao) inserirObjeto(marcacao);
        return m;
    }
    
    public void removeMarcacao(Marcacao marcacao) throws Exception{
        removerObjeto(marcacao);
    }
    
    public List<Marcacao> getMarcacaos() throws Exception{
        List<Marcacao> m = new ArrayList();
        m = (List<Marcacao>) consultarObjetos(Marcacao.class);
        return m;
    }
    
    public List<Marcacao> getMarcacaoByUsuario(Usuario usuario) throws Exception{
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery query = cb.createQuery();
        Root<Marcacao> from = query.from(Marcacao.class);
        query.select(from);
        query.where(cb.and(cb.equal(from.get(Marcacao_.idUsuario), usuario)));
        return (List<Marcacao>) em.createQuery(query).getResultList();
    }
    
    public Marcacao getMarcacaoById(int idMarcacao) throws Exception{
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery query = cb.createQuery();
        Root<Marcacao> from = query.from(Marcacao.class);
        query.select(from);
        query.where(cb.and(cb.equal(from.get(Marcacao_.idMarcacao), idMarcacao)));
        return (Marcacao) em.createQuery(query).getSingleResult();
    }
    
    public List<Marcacao> getMarcacaoByComentario(Comentario comentario) throws Exception{
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery query = cb.createQuery();
        Root<Marcacao> from = query.from(Marcacao.class);
        query.select(from);
        query.where(cb.and(cb.equal(from.get(Marcacao_.idComentario), comentario)));
        return (List<Marcacao>) em.createQuery(query).getResultList();
    }
    
    
}
