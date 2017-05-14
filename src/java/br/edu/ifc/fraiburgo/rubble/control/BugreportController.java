/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifc.fraiburgo.rubble.control;

import br.edu.ifc.fraiburgo.rubble.model.Bugreport;
import br.edu.ifc.fraiburgo.rubble.persistence.BugreportPersistence;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author iuryk
 */
public class BugreportController extends BugreportPersistence{
    
    public Bugreport mergeBugreport(Bugreport bugreport){
        Bugreport b = new Bugreport();
        try {
            b = super.mergeBugreport(bugreport);
        } catch (Exception ex) {
            Logger.getLogger(BugreportController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return b;
    }
}
