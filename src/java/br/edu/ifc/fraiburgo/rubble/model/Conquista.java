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
@Table(name = "conquista")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Conquista.findAll", query = "SELECT c FROM Conquista c"),
    @NamedQuery(name = "Conquista.findByIdConquista", query = "SELECT c FROM Conquista c WHERE c.idConquista = :idConquista"),
    @NamedQuery(name = "Conquista.findByNome", query = "SELECT c FROM Conquista c WHERE c.nome = :nome"),
    @NamedQuery(name = "Conquista.findByDescricao", query = "SELECT c FROM Conquista c WHERE c.descricao = :descricao")})
public class Conquista implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_conquista")
    private Long idConquista;
    @Basic(optional = false)
    @Column(name = "nome")
    private String nome;
    @Basic(optional = false)
    @Column(name = "descricao")
    private String descricao;
    @Lob
    @Column(name = "icone")
    private String icone;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false)
    private Usuario idUsuario;

    public Conquista() {
    }

    public Conquista(Long idConquista) {
        this.idConquista = idConquista;
    }

    public Conquista(Long idConquista, String nome, String descricao) {
        this.idConquista = idConquista;
        this.nome = nome;
        this.descricao = descricao;
    }

    public Long getIdConquista() {
        return idConquista;
    }

    public void setIdConquista(Long idConquista) {
        this.idConquista = idConquista;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getIcone() {
        return icone;
    }

    public void setIcone(String icone) {
        this.icone = icone;
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
        hash += (idConquista != null ? idConquista.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Conquista)) {
            return false;
        }
        Conquista other = (Conquista) object;
        if ((this.idConquista == null && other.idConquista != null) || (this.idConquista != null && !this.idConquista.equals(other.idConquista))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.ifc.fraiburgo.rubble.model.Conquista[ idConquista=" + idConquista + " ]";
    }
    
}
