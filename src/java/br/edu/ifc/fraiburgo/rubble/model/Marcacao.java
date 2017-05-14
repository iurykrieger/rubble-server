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
@Table(name = "marcacao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Marcacao.findAll", query = "SELECT m FROM Marcacao m"),
    @NamedQuery(name = "Marcacao.findByIdMarcacao", query = "SELECT m FROM Marcacao m WHERE m.idMarcacao = :idMarcacao")})
public class Marcacao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_marcacao")
    private Long idMarcacao;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false)
    private Usuario idUsuario;
    @JoinColumn(name = "id_comentario", referencedColumnName = "id_comentario")
    @ManyToOne(optional = false)
    private Comentario idComentario;

    public Marcacao() {
    }

    public Marcacao(Long idMarcacao) {
        this.idMarcacao = idMarcacao;
    }

    public Long getIdMarcacao() {
        return idMarcacao;
    }

    public void setIdMarcacao(Long idMarcacao) {
        this.idMarcacao = idMarcacao;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Comentario getIdComentario() {
        return idComentario;
    }

    public void setIdComentario(Comentario idComentario) {
        this.idComentario = idComentario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMarcacao != null ? idMarcacao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Marcacao)) {
            return false;
        }
        Marcacao other = (Marcacao) object;
        if ((this.idMarcacao == null && other.idMarcacao != null) || (this.idMarcacao != null && !this.idMarcacao.equals(other.idMarcacao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.ifc.fraiburgo.rubble.model.Marcacao[ idMarcacao=" + idMarcacao + " ]";
    }
    
}
