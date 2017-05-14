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
@Table(name = "usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u"),
    @NamedQuery(name = "Usuario.findByIdUsuario", query = "SELECT u FROM Usuario u WHERE u.idUsuario = :idUsuario"),
    @NamedQuery(name = "Usuario.findByNome", query = "SELECT u FROM Usuario u WHERE u.nome = :nome"),
    @NamedQuery(name = "Usuario.findByEmail", query = "SELECT u FROM Usuario u WHERE u.email = :email"),
    @NamedQuery(name = "Usuario.findBySenha", query = "SELECT u FROM Usuario u WHERE u.senha = :senha"),
    @NamedQuery(name = "Usuario.findByNumPostagens", query = "SELECT u FROM Usuario u WHERE u.numPostagens = :numPostagens"),
    @NamedQuery(name = "Usuario.findByNumComentarios", query = "SELECT u FROM Usuario u WHERE u.numComentarios = :numComentarios")})
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_usuario")
    private Long idUsuario;
    @Basic(optional = false)
    @Column(name = "nome")
    private String nome;
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @Column(name = "senha")
    private String senha;
    @Basic(optional = false)
    @Column(name = "num_postagens")
    private int numPostagens;
    @Basic(optional = false)
    @Column(name = "num_comentarios")
    private int numComentarios;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuario")
    private List<Marcacao> marcacaoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuario")
    private List<Conquista> conquistaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuario")
    private List<Status> statusList;
    @JoinColumn(name = "id_cidade", referencedColumnName = "id_cidade")
    @ManyToOne(optional = false)
    private Cidade idCidade;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuario")
    private List<Bugreport> bugreportList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuario")
    private List<Postagem> postagemList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuario")
    private List<RedeSocial> redeSocialList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuario")
    private List<Comentario> comentarioList;

    public Usuario() {
    }

    public Usuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Usuario(Long idUsuario, String nome, String senha, int numPostagens, int numComentarios) {
        this.idUsuario = idUsuario;
        this.nome = nome;
        this.senha = senha;
        this.numPostagens = numPostagens;
        this.numComentarios = numComentarios;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getNumPostagens() {
        return numPostagens;
    }

    public void setNumPostagens(int numPostagens) {
        this.numPostagens = numPostagens;
    }

    public int getNumComentarios() {
        return numComentarios;
    }

    public void setNumComentarios(int numComentarios) {
        this.numComentarios = numComentarios;
    }

    @XmlTransient
    public List<Marcacao> getMarcacaoList() {
        return marcacaoList;
    }

    public void setMarcacaoList(List<Marcacao> marcacaoList) {
        this.marcacaoList = marcacaoList;
    }

    @XmlTransient
    public List<Conquista> getConquistaList() {
        return conquistaList;
    }

    public void setConquistaList(List<Conquista> conquistaList) {
        this.conquistaList = conquistaList;
    }

    @XmlTransient
    public List<Status> getStatusList() {
        return statusList;
    }

    public void setStatusList(List<Status> statusList) {
        this.statusList = statusList;
    }

    public Cidade getIdCidade() {
        return idCidade;
    }

    public void setIdCidade(Cidade idCidade) {
        this.idCidade = idCidade;
    }

    @XmlTransient
    public List<Bugreport> getBugreportList() {
        return bugreportList;
    }

    public void setBugreportList(List<Bugreport> bugreportList) {
        this.bugreportList = bugreportList;
    }

    @XmlTransient
    public List<Postagem> getPostagemList() {
        return postagemList;
    }

    public void setPostagemList(List<Postagem> postagemList) {
        this.postagemList = postagemList;
    }

    @XmlTransient
    public List<RedeSocial> getRedeSocialList() {
        return redeSocialList;
    }

    public void setRedeSocialList(List<RedeSocial> redeSocialList) {
        this.redeSocialList = redeSocialList;
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
        hash += (idUsuario != null ? idUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.idUsuario == null && other.idUsuario != null) || (this.idUsuario != null && !this.idUsuario.equals(other.idUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.ifc.fraiburgo.rubble.model.Usuario[ idUsuario=" + idUsuario + " ]";
    }
    
}
