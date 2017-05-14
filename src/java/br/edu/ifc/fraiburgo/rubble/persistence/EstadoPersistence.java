package br.edu.ifc.fraiburgo.rubble.persistence;

import br.edu.ifc.fraiburgo.rubble.model.Estado;
import br.edu.ifc.fraiburgo.rubble.model.Estado_;
import br.edu.ifc.fraiburgo.rubble.utils.Persist;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author iuryk
 */
public class EstadoPersistence extends Persist{
    
    public List<Estado> getEstados() throws Exception{
        List<Estado> estados;
        estados = (List<Estado>) consultarObjetos(Estado.class);
        return estados;
    }
    
    public Estado getEstadoById(int idEstado) throws Exception{
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery query = cb.createQuery();
        Root<Estado> from = query.from(Estado.class);
        query.select(from);
        query.where(cb.and(cb.equal(from.get(Estado_.idEstado), idEstado)));
        return (Estado) em.createQuery(query).getSingleResult();
    }
    
}
