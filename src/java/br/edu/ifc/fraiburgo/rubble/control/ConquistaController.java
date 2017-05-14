/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifc.fraiburgo.rubble.control;

import br.edu.ifc.fraiburgo.rubble.model.Conquista;
import br.edu.ifc.fraiburgo.rubble.model.Usuario;
import br.edu.ifc.fraiburgo.rubble.persistence.ConquistaPersistence;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ander
 */
public class ConquistaController extends ConquistaPersistence{
    
    @Override
    public List<Conquista> getConquistaByUsuario(Usuario usuario){
        List<Conquista> c = new ArrayList();
        try {
            c = super.getConquistaByUsuario(usuario);
        } catch (Exception ex) {
            Logger.getLogger(ConquistaController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return c;
    }
    
    @Override 
    public Conquista getConquistaById(int idConquista){
        Conquista c = new Conquista();
        try {
            c = super.getConquistaById(idConquista);
        } catch (Exception ex) {
            Logger.getLogger(ConquistaController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return c;
    }
    
    @Override
    public List<Conquista> getConquistas(){
        List<Conquista> c = new ArrayList();
        try{
            c = super.getConquistas();
        } catch (Exception ex) {
            Logger.getLogger(ConquistaController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return c;
    }
    
    @Override
    public void removeConquista(Conquista conquista){
        try {
            super.removerObjeto(conquista);
        } catch (Exception ex) {
            Logger.getLogger(ConquistaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public Conquista mergeConquista(Conquista conquista) {
        Conquista c = new Conquista();
        try {
            c = super.mergeConquista(conquista);
        } catch (Exception ex) {
            Logger.getLogger(ConquistaController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return c;
    }
    
}
