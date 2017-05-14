/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifc.fraiburgo.rubble.persistence;

import br.edu.ifc.fraiburgo.rubble.model.Comentario;
import br.edu.ifc.fraiburgo.rubble.model.Comentario_;
import br.edu.ifc.fraiburgo.rubble.model.Postagem;
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
public class ComentarioPersistence extends Persist {
    
    public Comentario mergeComentario(Comentario comentario) throws Exception{
        Comentario c = new Comentario();
        c = (Comentario) inserirObjeto(comentario);
        return c;
    }
    
    public void removeComentario(Comentario comentario) throws Exception{
        removerObjeto(comentario);
    }
    
    public List<Comentario> getComentarios() throws Exception{
        List<Comentario> c = new ArrayList();
        c = (List<Comentario>) consultarObjetos(Comentario.class);
        return c;
    }
    
    public List<Comentario> getComentarioByUsuario(Usuario usuario) throws Exception{
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery query = cb.createQuery();
        Root<Comentario> from = query.from(Comentario.class);
        query.select(from);
        query.where(cb.and(cb.equal(from.get(Comentario_.idUsuario), usuario)));
        return (List<Comentario>) em.createQuery(query).getResultList();
    }
    
    public Comentario getComentarioById(int idComentario) throws Exception{
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery query = cb.createQuery();
        Root<Comentario> from = query.from(Comentario.class);
        query.select(from);
        query.where(cb.and(cb.equal(from.get(Comentario_.idComentario), idComentario)));
        return (Comentario) em.createQuery(query).getSingleResult();
    }
    
    public List<Comentario> getComentarioByPostagem(Postagem postagem) throws Exception{
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery query = cb.createQuery();
        Root<Comentario> from = query.from(Comentario.class);
        query.select(from);
        query.where(cb.and(cb.equal(from.get(Comentario_.idPostagem), postagem)));
        return (List<Comentario>) em.createQuery(query).getResultList();
    }
    
}
