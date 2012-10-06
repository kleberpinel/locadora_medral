package br.com.medral.locadora.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;

import br.com.caelum.vraptor.ioc.Component;
import br.com.medral.locadora.entity.TbCliente;
import br.com.medral.locadora.entity.TbFilme;
import br.com.medral.locadora.entity.TbLocacao;

@Component  
public class LocacaoDao {
	private Session session;  
    
    public LocacaoDao(Session session) {  
        this.session = session;  
    }  
      
    @SuppressWarnings("unchecked")
    public List<TbLocacao> listaTodos() {  
        return session.createCriteria(TbLocacao.class).list();  
    }

	public TbLocacao obter(Integer idFilme) {
		return (TbLocacao) this.session.load(TbLocacao.class, idFilme); 
	}

	public boolean indisponivel(TbFilme filme) {
		TbLocacao locacao = (TbLocacao) this.session.getNamedQuery("TbLocacao.filmeDisponivel").setParameter("filme", filme).uniqueResult(); 
		if(locacao == null){
			return false;
		}
		return true;
	}

	public void locarFilme(TbFilme filme, TbCliente clienteLocador) {
		TbLocacao locacao = new TbLocacao();
		locacao.setTbCliente(clienteLocador);
		locacao.setTbFilme(filme);
		locacao.setDataLocacao(new Date());
		
		session.save(locacao);
	}  
	
	public Boolean devolverFilme(TbFilme filme, TbCliente clienteLocador) {
		TbLocacao locacao = (TbLocacao) this.session.getNamedQuery("TbLocacao.findByFilmeAndLocador")
				.setParameter("filme", filme)
				.setParameter("cliente", clienteLocador)
				.uniqueResult(); 
		
		if(locacao != null){
			
			locacao.setDataDevolucao(new Date());
			session.update(locacao);
			
			return true;
		}
		return false;
		
	} 
}
