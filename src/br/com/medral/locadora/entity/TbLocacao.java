/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.medral.locadora.entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author kbernardo
 */
@Entity
@Table(name = "tbLocacao")
@SequenceGenerator(name = "tbLocacao_ID_seq", sequenceName = "tbLocacao_ID_seq", allocationSize=1)
@NamedQueries({
    @NamedQuery(name = "TbLocacao.findAll", query = "SELECT t FROM TbLocacao t"),
    @NamedQuery(name = "TbLocacao.findByDataLocacao", query = "SELECT t FROM TbLocacao t WHERE t.dataLocacao = :dataLocacao"),
    @NamedQuery(name = "TbLocacao.findByDataDevolucao", query = "SELECT t FROM TbLocacao t WHERE t.dataDevolucao = :dataDevolucao"),
    @NamedQuery(name = "TbLocacao.filmeDisponivel", query = "SELECT t FROM TbLocacao t WHERE t.tbFilme = :filme AND t.dataDevolucao = null"),
    @NamedQuery(name = "TbLocacao.findByFilmeAndLocador", 
    	query = "SELECT t FROM TbLocacao t WHERE " +
    			"t.tbFilme = :filme AND " +
    			"t.tbCliente = :cliente AND " +
    			"t.dataDevolucao = null"),
    @NamedQuery(name = "TbLocacao.findById", query = "SELECT t FROM TbLocacao t WHERE t.id = :id")})
public class TbLocacao implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Basic(optional = false)
    @Column(name = "dataLocacao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataLocacao;
    
    @Column(name = "DataDevolucao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataDevolucao;
    
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tbLocacao_ID_seq")
    private Integer id;
    
    @JoinColumn(name = "tbFilmeID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private TbFilme tbFilme;
    
    @JoinColumn(name = "tbClienteID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private TbCliente tbCliente;

    public TbLocacao() {
    }

    public TbLocacao(Integer id) {
        this.id = id;
    }

    public TbLocacao(Integer id, Date dataLocacao) {
        this.id = id;
        this.dataLocacao = dataLocacao;
    }

    public Date getDataLocacao() {
        return dataLocacao;
    }

    public void setDataLocacao(Date dataLocacao) {
        this.dataLocacao = dataLocacao;
    }

    public Date getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(Date dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TbFilme getTbFilme() {
        return tbFilme;
    }

    public void setTbFilme(TbFilme tbFilme) {
        this.tbFilme = tbFilme;
    }

    public TbCliente getTbCliente() {
        return tbCliente;
    }

    public void setTbCliente(TbCliente tbCliente) {
        this.tbCliente = tbCliente;
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
        if (!(object instanceof TbLocacao)) {
            return false;
        }
        TbLocacao other = (TbLocacao) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.medral.locadora.entity.TbLocacao[id=" + id + "]";
    }

}
