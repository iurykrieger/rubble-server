package br.edu.ifc.fraiburgo.rubble.control;

import br.edu.ifc.fraiburgo.rubble.model.Comentario;
import br.edu.ifc.fraiburgo.rubble.model.Marcacao;
import br.edu.ifc.fraiburgo.rubble.model.Usuario;
import br.edu.ifc.fraiburgo.rubble.persistence.MarcacaoPersistence;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ander
 */
public class MarcacaoController extends MarcacaoPersistence {
    
    @Override
    public List<Marcacao> getMarcacaoByUsuario(Usuario usuario){
        List<Marcacao> m = new ArrayList();
        try {
            m = super.getMarcacaoByUsuario(usuario);
        } catch (Exception ex) {
            Logger.getLogger(MarcacaoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return m;
    }
    
    @Override
    public List<Marcacao> getMarcacaoByComentario(Comentario comentario){
        List<Marcacao> m = new ArrayList();
        try {
            m = super.getMarcacaoByComentario(comentario);
        } catch (Exception ex) {
            Logger.getLogger(MarcacaoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return m;
    }
    
    @Override 
    public Marcacao getMarcacaoById(int idMarcacao){
        Marcacao m = new Marcacao();
        try {
            m = super.getMarcacaoById(idMarcacao);
        } catch (Exception ex) {
            Logger.getLogger(MarcacaoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return m;
    }
    
    @Override
    public List<Marcacao> getMarcacaos(){
        List<Marcacao> m = new ArrayList();
        try{
            m = super.getMarcacaos();
        } catch (Exception ex) {
            Logger.getLogger(MarcacaoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return m;
    }
    
    @Override
    public void removeMarcacao(Marcacao marcacao){
        try {
            super.removerObjeto(marcacao);
        } catch (Exception ex) {
            Logger.getLogger(MarcacaoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public Marcacao mergeMarcacao(Marcacao marcacao) {
        Marcacao m = new Marcacao();
        try {
            m = super.mergeMarcacao(marcacao);
        } catch (Exception ex) {
            Logger.getLogger(MarcacaoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return m;
    }
    
}
