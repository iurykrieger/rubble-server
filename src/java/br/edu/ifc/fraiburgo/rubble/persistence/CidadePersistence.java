package br.edu.ifc.fraiburgo.rubble.persistence;

import br.edu.ifc.fraiburgo.rubble.model.Cidade;
import br.edu.ifc.fraiburgo.rubble.model.Cidade_;
import br.edu.ifc.fraiburgo.rubble.model.Estado;
import br.edu.ifc.fraiburgo.rubble.utils.Persist;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author iuryk
 */
public class CidadePersistence extends Persist{

    public List<Cidade> getCidadeByEstado(Estado estado) throws Exception{
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery query = cb.createQuery();
        Root<Cidade> from = query.from(Cidade.class);
        query.select(from);
        query.where(cb.and(cb.equal(from.get(Cidade_.idEstado), estado)));
        return (List<Cidade>) em.createQuery(query).getResultList();
    }

    public Cidade getCidadeById(int idCidade) throws Exception{
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery query = cb.createQuery();
        Root<Cidade> from = query.from(Cidade.class);
        query.select(from);
        query.where(cb.and(cb.equal(from.get(Cidade_.idCidade), idCidade)));
        return (Cidade) em.createQuery(query).getSingleResult();
    }
}
