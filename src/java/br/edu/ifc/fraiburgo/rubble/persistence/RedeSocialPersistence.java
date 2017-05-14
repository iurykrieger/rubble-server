/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifc.fraiburgo.rubble.persistence;

import br.edu.ifc.fraiburgo.rubble.model.RedeSocial;
import br.edu.ifc.fraiburgo.rubble.model.RedeSocial_;
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
public class RedeSocialPersistence extends Persist {
    
    public RedeSocial mergeRedeSocial(RedeSocial redesocial) throws Exception{
        RedeSocial rs = new RedeSocial();
        rs = (RedeSocial) inserirObjeto(redesocial);
        return rs;
    }
    
    public void removeRedeSocial(RedeSocial redesocial) throws Exception{
        removerObjeto(redesocial);
    }
    
    public List<RedeSocial> getRedeSocials() throws Exception{
        List<RedeSocial> rs = new ArrayList();
        rs = (List<RedeSocial>) consultarObjetos(RedeSocial.class);
        return rs;
    }
    
    public List<RedeSocial> getRedeSocialByUsuario(Usuario usuario) throws Exception{
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery query = cb.createQuery();
        Root<RedeSocial> from = query.from(RedeSocial.class);
        query.select(from);
        query.where(cb.and(cb.equal(from.get(RedeSocial_.idUsuario), usuario)));
        return (List<RedeSocial>) em.createQuery(query).getResultList();
    }
    
    public RedeSocial getRedeSocialById(int idRedeSocial) throws Exception{
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery query = cb.createQuery();
        Root<RedeSocial> from = query.from(RedeSocial.class);
        query.select(from);
        query.where(cb.and(cb.equal(from.get(RedeSocial_.idRede), idRedeSocial)));
        return (RedeSocial) em.createQuery(query).getSingleResult();
    }
     
}
