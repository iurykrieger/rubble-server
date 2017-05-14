/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifc.fraiburgo.rubble.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author iuryk
 */
@Entity
@Table(name = "cidade")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cidade.findAll", query = "SELECT c FROM Cidade c"),
    @NamedQuery(name = "Cidade.findByIdCidade", query = "SELECT c FROM Cidade c WHERE c.idCidade = :idCidade"),
    @NamedQuery(name = "Cidade.findByNome", query = "SELECT c FROM Cidade c WHERE c.nome = :nome"),
    @NamedQuery(name = "Cidade.findByPopulacao", query = "SELECT c FROM Cidade c WHERE c.populacao = :populacao"),
    @NamedQuery(name = "Cidade.findByCodigoIbge", query = "SELECT c FROM Cidade c WHERE c.codigoIbge = :codigoIbge"),
    @NamedQuery(name = "Cidade.findByDensidadeDemo", query = "SELECT c FROM Cidade c WHERE c.densidadeDemo = :densidadeDemo"),
    @NamedQuery(name = "Cidade.findByGentilico", query = "SELECT c FROM Cidade c WHERE c.gentilico = :gentilico"),
    @NamedQuery(name = "Cidade.findByArea", query = "SELECT c FROM Cidade c WHERE c.area = :area")})
public class Cidade implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_cidade")
    private Long idCidade;
    @Basic(optional = false)
    @Column(name = "nome")
    private String nome;
    @Basic(optional = false)
    @Column(name = "populacao")
    private int populacao;
    @Basic(optional = false)
    @Column(name = "codigo_ibge")
    private int codigoIbge;
    @Basic(optional = false)
    @Column(name = "densidade_demo")
    private int densidadeDemo;
    @Basic(optional = false)
    @Column(name = "gentilico")
    private String gentilico;
    @Basic(optional = false)
    @Column(name = "area")
    private long area;
    @JoinColumn(name = "id_estado", referencedColumnName = "id_estado")
    @ManyToOne(optional = false)
    private Estado idEstado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCidade")
    private List<Usuario> usuarioList;

    public Cidade() {
    }

    public Cidade(Long idCidade) {
        this.idCidade = idCidade;
    }

    public Cidade(Long idCidade, String nome, int populacao, int codigoIbge, int densidadeDemo, String gentilico, long area) {
        this.idCidade = idCidade;
        this.nome = nome;
        this.populacao = populacao;
        this.codigoIbge = codigoIbge;
        this.densidadeDemo = densidadeDemo;
        this.gentilico = gentilico;
        this.area = area;
    }

    public Long getIdCidade() {
        return idCidade;
    }

    public void setIdCidade(Long idCidade) {
        this.idCidade = idCidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPopulacao() {
        return populacao;
    }

    public void setPopulacao(int populacao) {
        this.populacao = populacao;
    }

    public int getCodigoIbge() {
        return codigoIbge;
    }

    public void setCodigoIbge(int codigoIbge) {
        this.codigoIbge = codigoIbge;
    }

    public int getDensidadeDemo() {
        return densidadeDemo;
    }

    public void setDensidadeDemo(int densidadeDemo) {
        this.densidadeDemo = densidadeDemo;
    }

    public String getGentilico() {
        return gentilico;
    }

    public void setGentilico(String gentilico) {
        this.gentilico = gentilico;
    }

    public long getArea() {
        return area;
    }

    public void setArea(long area) {
        this.area = area;
    }

    public Estado getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Estado idEstado) {
        this.idEstado = idEstado;
    }

    @XmlTransient
    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCidade != null ? idCidade.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cidade)) {
            return false;
        }
        Cidade other = (Cidade) object;
        if ((this.idCidade == null && other.idCidade != null) || (this.idCidade != null && !this.idCidade.equals(other.idCidade))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.ifc.fraiburgo.rubble.model.Cidade[ idCidade=" + idCidade + " ]";
    }
    
}
