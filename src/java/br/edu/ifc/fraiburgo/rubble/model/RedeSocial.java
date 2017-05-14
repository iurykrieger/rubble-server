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
@Table(name = "rede_social")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RedeSocial.findAll", query = "SELECT r FROM RedeSocial r"),
    @NamedQuery(name = "RedeSocial.findByIdRede", query = "SELECT r FROM RedeSocial r WHERE r.idRede = :idRede"),
    @NamedQuery(name = "RedeSocial.findByEndereco", query = "SELECT r FROM RedeSocial r WHERE r.endereco = :endereco"),
    @NamedQuery(name = "RedeSocial.findByRede", query = "SELECT r FROM RedeSocial r WHERE r.rede = :rede")})
public class RedeSocial implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_rede")
    private Long idRede;
    @Basic(optional = false)
    @Column(name = "endereco")
    private String endereco;
    @Basic(optional = false)
    @Column(name = "rede")
    private String rede;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false)
    private Usuario idUsuario;

    public RedeSocial() {
    }

    public RedeSocial(Long idRede) {
        this.idRede = idRede;
    }

    public RedeSocial(Long idRede, String endereco, String rede) {
        this.idRede = idRede;
        this.endereco = endereco;
        this.rede = rede;
    }

    public Long getIdRede() {
        return idRede;
    }

    public void setIdRede(Long idRede) {
        this.idRede = idRede;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getRede() {
        return rede;
    }

    public void setRede(String rede) {
        this.rede = rede;
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
        hash += (idRede != null ? idRede.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RedeSocial)) {
            return false;
        }
        RedeSocial other = (RedeSocial) object;
        if ((this.idRede == null && other.idRede != null) || (this.idRede != null && !this.idRede.equals(other.idRede))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.ifc.fraiburgo.rubble.model.RedeSocial[ idRede=" + idRede + " ]";
    }
    
}
