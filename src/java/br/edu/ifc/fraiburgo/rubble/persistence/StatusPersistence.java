/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifc.fraiburgo.rubble.persistence;

import br.edu.ifc.fraiburgo.rubble.model.Postagem;
import br.edu.ifc.fraiburgo.rubble.model.Status;
import br.edu.ifc.fraiburgo.rubble.model.Status_;
import br.edu.ifc.fraiburgo.rubble.utils.Persist;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;

/**
 *
 * @author ander
 */
public class StatusPersistence extends Persist {
    
    public Status mergeStatus(Status status) throws Exception{
        Status s = new Status();
        s = (Status) inserirObjeto(status);
        return s;
    }
    
    public void removeStatus(Status status) throws Exception{
        removerObjeto(status);
    }
    
    public List<Status> getStatus() throws Exception{
        List<Status> s = new ArrayList();
        s = (List<Status>) consultarObjetos(Status.class);
        return s;
    }
    
    public List<Status> getStatusByPostagem(Postagem postagem) throws Exception{
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery query = cb.createQuery();
        Root<Status> from = query.from(Status.class);
        query.select(from);
        query.where(cb.and(cb.equal(from.get(Status_.idPostagem), postagem)));
        return (List<Status>) em.createQuery(query).getResultList();
    }
    
    public Status getActiveStatusByPostagem(Postagem postagem) throws Exception{
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery query = cb.createQuery();
        Root<Status> from = query.from(Status.class);
        query.select(from);
        query.where(cb.and(cb.equal(from.get(Status_.idPostagem), postagem), cb.equal(from.get(Status_.ativo), true)));
        return (Status) em.createQuery(query).getSingleResult();
    }
     
    public Status getStatusById(int idStatus) throws Exception{
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery query = cb.createQuery();
        Root<Status> from = query.from(Status.class);
        query.select(from);
        query.where(cb.and(cb.equal(from.get(Status_.idStatus), idStatus)));
        return (Status) em.createQuery(query).getSingleResult();
    }
    
    public void setAllStatusInactive(Long idStatus, Postagem p) throws Exception{
        em.getTransaction().begin();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaUpdate update = cb.createCriteriaUpdate(Status.class);
        Root<Status> e = update.from(Status.class);
        update.set(Status_.ativo, false);
        update.where(cb.and(cb.equal(e.get(Status_.idPostagem), p),cb.notEqual(e.get(Status_.idStatus), idStatus)));
        Query query = em.createQuery(update);
        int rowCount = query.executeUpdate();
        em.getTransaction().commit();
    }
    
}
