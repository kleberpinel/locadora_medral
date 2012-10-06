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
@Table(name = "tbCliente")
@SequenceGenerator(name = "tbCliente_ID_seq", sequenceName = "tbCliente_ID_seq", allocationSize=1)
@NamedQueries({
    @NamedQuery(name = "TbCliente.findAll", query = "SELECT t FROM TbCliente t"),
    @NamedQuery(name = "TbCliente.findById", query = "SELECT t FROM TbCliente t WHERE t.id = :id"),
    @NamedQuery(name = "TbCliente.findByNome", query = "SELECT t FROM TbCliente t WHERE t.nome = :nome"),
    @NamedQuery(name = "TbCliente.findByEndereco", query = "SELECT t FROM TbCliente t WHERE t.endereco = :endereco"),
    @NamedQuery(name = "TbCliente.findByCpf", query = "SELECT t FROM TbCliente t WHERE t.cpf = :cpf")})
public class TbCliente implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tbCliente_ID_seq")
    private Integer id;

    @Basic(optional = false)
    @Column(name = "Nome")
    private String nome;
    
    @Basic(optional = false)
    @Column(name = "Endereco")
    private String endereco;
    
    @Basic(optional = false)
    @Column(name = "CPF")
    private String cpf;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tbCliente")
    private Collection<TbLocacao> tbLocacaoCollection;

    public TbCliente() {
    }

    public TbCliente(Integer id) {
        this.id = id;
    }

    public TbCliente(Integer id, String nome, String endereco, String cpf) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.cpf = cpf;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
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
        if (!(object instanceof TbCliente)) {
            return false;
        }
        TbCliente other = (TbCliente) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.medral.locadora.entity.TbCliente[id=" + id + "]";
    }

}
