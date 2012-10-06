package br.com.medral.locadora.dao;

import java.util.List;

import org.hibernate.Session;

import br.com.caelum.vraptor.ioc.Component;
import br.com.medral.locadora.entity.TbCliente;

@Component  
public class ClienteDao {
	private Session session;  
    
    public ClienteDao(Session session) {  
        this.session = session;  
    }  
      
    public void adiciona(TbCliente cliente) {  
        session.save(cliente);  
    }
    
    public void atualiza(TbCliente cliente) {  
        session.update(cliente);  
    }
    
    public void remover(TbCliente cliente) {  
        session.delete(cliente);  
    }
      
    @SuppressWarnings("unchecked")
	public List<TbCliente> listaTodos() {  
        return session.createCriteria(TbCliente.class).list();  
    }

	public TbCliente obter(Integer idCliente) {
		return (TbCliente) this.session.load(TbCliente.class, idCliente); 
	}  
}
