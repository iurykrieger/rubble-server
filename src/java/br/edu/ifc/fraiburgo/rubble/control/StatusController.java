package br.edu.ifc.fraiburgo.rubble.control;

import br.edu.ifc.fraiburgo.rubble.model.Postagem;
import br.edu.ifc.fraiburgo.rubble.model.Status;
import br.edu.ifc.fraiburgo.rubble.persistence.StatusPersistence;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ander
 */
public class StatusController extends StatusPersistence {

    @Override
    public void setAllStatusInactive(Long idStatus, Postagem p) {
        try {
            super.setAllStatusInactive(idStatus, p);
        } catch (Exception ex) {
            Logger.getLogger(StatusController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Status> getStatusByPostagem(Postagem postagem) {
        try {
            List<Status> s;
            s = super.getStatusByPostagem(postagem);
            return s;
        } catch (Exception ex) {
            Logger.getLogger(StatusController.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public Status getActiveStatusByPostagem(Postagem postagem) {
        try {
            Status s;
            s = super.getActiveStatusByPostagem(postagem);
            return s;
        } catch (Exception ex) {
            Logger.getLogger(StatusController.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public Status getStatusById(int idStatus) {
        try {
            Status s;
            s = super.getStatusById(idStatus);
            return s;
        } catch (Exception ex) {
            Logger.getLogger(StatusController.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public List<Status> getStatus() {
        try {
            List<Status> s;
            s = super.getStatus();
            return s;
        } catch (Exception ex) {
            Logger.getLogger(StatusController.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public void removeStatus(Status status) {
        try {
            super.removerObjeto(status);
        } catch (Exception ex) {
            Logger.getLogger(StatusController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Status mergeStatus(Status status) {
        try {
            Status s;
            s = super.mergeStatus(status);
            return s;
        } catch (Exception ex) {
            Logger.getLogger(StatusController.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

}
