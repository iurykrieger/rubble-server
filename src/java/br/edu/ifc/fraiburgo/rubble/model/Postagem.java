/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifc.fraiburgo.rubble.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author iuryk
 */
@Entity
@Table(name = "postagem")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Postagem.findAll", query = "SELECT p FROM Postagem p"),
    @NamedQuery(name = "Postagem.findByIdPostagem", query = "SELECT p FROM Postagem p WHERE p.idPostagem = :idPostagem"),
    @NamedQuery(name = "Postagem.findByDescricao", query = "SELECT p FROM Postagem p WHERE p.descricao = :descricao"),
    @NamedQuery(name = "Postagem.findByVizualizacoes", query = "SELECT p FROM Postagem p WHERE p.vizualizacoes = :vizualizacoes"),
    @NamedQuery(name = "Postagem.findByData", query = "SELECT p FROM Postagem p WHERE p.data = :data"),
    @NamedQuery(name = "Postagem.findByTipo", query = "SELECT p FROM Postagem p WHERE p.tipo = :tipo"),
    @NamedQuery(name = "Postagem.findByNumComentarios", query = "SELECT p FROM Postagem p WHERE p.numComentarios = :numComentarios"),
    @NamedQuery(name = "Postagem.findByLatitude", query = "SELECT p FROM Postagem p WHERE p.latitude = :latitude"),
    @NamedQuery(name = "Postagem.findByLongitude", query = "SELECT p FROM Postagem p WHERE p.longitude = :longitude")})
public class Postagem implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_postagem")
    private Long idPostagem;
    @Basic(optional = false)
    @Column(name = "descricao")
    private String descricao;
    @Basic(optional = false)
    @Column(name = "vizualizacoes")
    private int vizualizacoes;
    @Lob
    @Column(name = "foto")
    private String foto;
    @Basic(optional = false)
    @Column(name = "data")
    @Temporal(TemporalType.TIMESTAMP)
    private Date data;
    @Basic(optional = false)
    @Column(name = "tipo")
    private String tipo;
    @Basic(optional = false)
    @Column(name = "num_comentarios")
    private int numComentarios;
    @Basic(optional = false)
    @Column(name = "latitude")
    private double latitude;
    @Basic(optional = false)
    @Column(name = "longitude")
    private double longitude;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPostagem")
    private List<Status> statusList;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false)
    private Usuario idUsuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPostagem")
    private List<Comentario> comentarioList;

    public Postagem() {
    }

    public Postagem(Long idPostagem) {
        this.idPostagem = idPostagem;
    }

    public Postagem(Long idPostagem, String descricao, int vizualizacoes, Date data, String tipo, int numComentarios, double latitude, double longitude) {
        this.idPostagem = idPostagem;
        this.descricao = descricao;
        this.vizualizacoes = vizualizacoes;
        this.data = data;
        this.tipo = tipo;
        this.numComentarios = numComentarios;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Long getIdPostagem() {
        return idPostagem;
    }

    public void setIdPostagem(Long idPostagem) {
        this.idPostagem = idPostagem;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getVizualizacoes() {
        return vizualizacoes;
    }

    public void setVizualizacoes(int vizualizacoes) {
        this.vizualizacoes = vizualizacoes;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getNumComentarios() {
        return numComentarios;
    }

    public void setNumComentarios(int numComentarios) {
        this.numComentarios = numComentarios;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    @XmlTransient
    public List<Status> getStatusList() {
        return statusList;
    }

    public void setStatusList(List<Status> statusList) {
        this.statusList = statusList;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    @XmlTransient
    public List<Comentario> getComentarioList() {
        return comentarioList;
    }

    public void setComentarioList(List<Comentario> comentarioList) {
        this.comentarioList = comentarioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPostagem != null ? idPostagem.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Postagem)) {
            return false;
        }
        Postagem other = (Postagem) object;
        if ((this.idPostagem == null && other.idPostagem != null) || (this.idPostagem != null && !this.idPostagem.equals(other.idPostagem))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.ifc.fraiburgo.rubble.model.Postagem[ idPostagem=" + idPostagem + " ]";
    }
    
}
