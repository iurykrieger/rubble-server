package br.edu.ifc.fraiburgo.rubble.persistence;

import br.edu.ifc.fraiburgo.rubble.model.Bugreport;
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
public class BugreportPersistence extends Persist{
    
    public Bugreport mergeBugreport(Bugreport bugreport) throws Exception{
        Bugreport b;
        b = (Bugreport) inserirObjeto(bugreport);
        return b;
    }
    
}
