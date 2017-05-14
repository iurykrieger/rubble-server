/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifc.fraiburgo.rubble.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author iuryk
 */
@Entity
@Table(name = "bugreport")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bugreport.findAll", query = "SELECT b FROM Bugreport b"),
    @NamedQuery(name = "Bugreport.findByIdBugreport", query = "SELECT b FROM Bugreport b WHERE b.idBugreport = :idBugreport")})
public class Bugreport implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_bugreport")
    private Long idBugreport;
    @Basic(optional = false)
    @Lob
    @Column(name = "report")
    private String report;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false)
    private Usuario idUsuario;

    public Bugreport() {
    }

    public Bugreport(Long idBugreport) {
        this.idBugreport = idBugreport;
    }

    public Bugreport(Long idBugreport, String report) {
        this.idBugreport = idBugreport;
        this.report = report;
    }

    public Long getIdBugreport() {
        return idBugreport;
    }

    public void setIdBugreport(Long idBugreport) {
        this.idBugreport = idBugreport;
    }

    public String getReport() {
        return report;
    }

    public void setReport(String report) {
        this.report = report;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idBugreport != null ? idBugreport.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bugreport)) {
            return false;
        }
        Bugreport other = (Bugreport) object;
        if ((this.idBugreport == null && other.idBugreport != null) || (this.idBugreport != null && !this.idBugreport.equals(other.idBugreport))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.ifc.fraiburgo.rubble.model.Bugreport[ idBugreport=" + idBugreport + " ]";
    }
    
}
