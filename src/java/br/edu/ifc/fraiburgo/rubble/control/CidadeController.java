package br.edu.ifc.fraiburgo.rubble.control;

import br.edu.ifc.fraiburgo.rubble.model.Cidade;
import br.edu.ifc.fraiburgo.rubble.model.Estado;
import br.edu.ifc.fraiburgo.rubble.persistence.CidadePersistence;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author iuryk
 */
public class CidadeController extends CidadePersistence{
    
    @Override
    public List<Cidade> getCidadeByEstado(Estado estado){
        List<Cidade> cidades = new ArrayList();
        try {
            cidades = super.getCidadeByEstado(estado);
        } catch (Exception ex) {
            Logger.getLogger(CidadeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cidades;
    }
    
    @Override 
    public Cidade getCidadeById(int idCidade){
        Cidade cidade = new Cidade();
        try {
            cidade = super.getCidadeById(idCidade);
        } catch (Exception ex) {
            Logger.getLogger(CidadeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cidade;
    }
}
