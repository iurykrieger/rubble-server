package br.edu.ifc.fraiburgo.rubble.control;

import br.edu.ifc.fraiburgo.rubble.model.Estado;
import br.edu.ifc.fraiburgo.rubble.persistence.EstadoPersistence;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author iuryk
 */
public class EstadoController extends EstadoPersistence{
    
    @Override
    public List<Estado> getEstados() {
        List<Estado> estados = new ArrayList();
        try {
            estados = super.getEstados();
        } catch (Exception ex) {
            Logger.getLogger(EstadoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return estados;
    }
    
    @Override
    public Estado getEstadoById(int idEstado){
        Estado e = new Estado();
        try {
            e = super.getEstadoById(idEstado);
        } catch (Exception ex) {
            Logger.getLogger(EstadoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return e;
    }
}
