package br.com.medral.locadora.dao;

import java.util.List;

import org.hibernate.Session;

import br.com.caelum.vraptor.ioc.Component;
import br.com.medral.locadora.entity.TbFilme;

@Component  
public class FilmeDao {
	private Session session;  
    
    public FilmeDao(Session session) {  
        this.session = session;  
    }  
      
    public void adiciona(TbFilme filme) {  
        session.save(filme);  
    }
    
    public void atualiza(TbFilme filme) {  
        session.update(filme);  
    }
    
    public void remover(TbFilme filme) {  
        session.delete(filme);  
    }
    
    @SuppressWarnings("unchecked")
    public List<TbFilme> listaTodos() {  
        return session.createCriteria(TbFilme.class).list();  
    }

	public TbFilme obter(Integer idFilme) {
		return (TbFilme) this.session.load(TbFilme.class, idFilme); 
	}

	public TbFilme obterByNome(String nomeFilme) {
		return (TbFilme) this.session.getNamedQuery("TbFilme.findByFilme").setString("filme", nomeFilme).uniqueResult(); 
	}  
}
