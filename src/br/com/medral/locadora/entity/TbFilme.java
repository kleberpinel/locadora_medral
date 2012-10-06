/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.medral.locadora.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author kbernardo
 */
@Entity
@Table(name = "tbFilme")
@SequenceGenerator(name = "tbFilme_ID_seq", sequenceName = "tbFilme_ID_seq", allocationSize=1)
@NamedQueries({
    @NamedQuery(name = "TbFilme.findAll", query = "SELECT t FROM TbFilme t"),
    @NamedQuery(name = "TbFilme.findById", query = "SELECT t FROM TbFilme t WHERE t.id = :id"),
    @NamedQuery(name = "TbFilme.findByFilme", query = "SELECT t FROM TbFilme t WHERE t.filme = :filme"),
    @NamedQuery(name = "TbFilme.findByGenero", query = "SELECT t FROM TbFilme t WHERE t.genero = :genero")})

public class TbFilme implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tbFilme_ID_seq")
    private Integer id;
    
    @Basic(optional = false)
    @Column(name = "Filme")
    private String filme;
    
    @Basic(optional = false)
    @Column(name = "Genero")
    private String genero;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tbFilme")
    private Collection<TbLocacao> tbLocacaoCollection;

    public TbFilme() {
    }

    public TbFilme(Integer id) {
        this.id = id;
    }

    public TbFilme(Integer id, String filme, String genero) {
        this.id = id;
        this.filme = filme;
        this.genero = genero;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFilme() {
        return filme;
    }

    public void setFilme(String filme) {
        this.filme = filme;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Collection<TbLocacao> getTbLocacaoCollection() {
        return tbLocacaoCollection;
    }

    public void setTbLocacaoCollection(Collection<TbLocacao> tbLocacaoCollection) {
        this.tbLocacaoCollection = tbLocacaoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbFilme)) {
            return false;
        }
        TbFilme other = (TbFilme) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.medral.locadora.entity.TbFilme[id=" + id + "]";
    }

}
