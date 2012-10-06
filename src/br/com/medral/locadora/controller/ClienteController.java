package br.com.medral.locadora.controller;

import static br.com.caelum.vraptor.view.Results.http;
import static br.com.caelum.vraptor.view.Results.json;

import java.util.ArrayList;
import java.util.List;

import br.com.caelum.vraptor.Consumes;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.medral.locadora.dao.ClienteDao;
import br.com.medral.locadora.entity.TbCliente;

@Resource
public class ClienteController {

	private final Result result;
	
	public ClienteDao clienteDao;

	public ClienteController(Result result, ClienteDao clienteDao) {
		this.result = result;
		this.clienteDao = clienteDao;
	}
	
	@Get("/cliente")
	public void cliente() {
		List<TbCliente> listaTodos = clienteDao.listaTodos();
		
		result.include("listaCliente", listaTodos);
	}
	
	@Get("/cliente/form")
	public void form(Integer idCliente) {
		if(idCliente != null){
			TbCliente cliente  = clienteDao.obter(idCliente);
			result.include("cliente", cliente);
		}
	}
	
	@Post("/cliente/salvar")
	@Consumes("application/json")
	public void salvar(TbCliente cliente) {
		List<String> erros = validar(cliente);
		if(erros == null){
			if(cliente.getId() != null){
				clienteDao.atualiza(cliente);
			} else {
				clienteDao.adiciona(cliente);
			}
			result.use(json());
		} else {
			result.use(http()).setStatusCode(400);
			result.use(json()).from(erros).serialize();
		}
	}
	
	@Post("/cliente/excluir/{idCliente}")
	public void excluir(Integer idCliente) {
		clienteDao.remover(new TbCliente(idCliente));
	}
	
	private List<String> validar(TbCliente cliente){
		List<String> msgsErro = new ArrayList<String>();
		if(cliente.getNome() == null || cliente.getNome().equals("")){
			msgsErro.add("O campo Nome é obrigatório!");
		}
		if(cliente.getEndereco() == null || cliente.getEndereco().equals("")){
			msgsErro.add("O campo Endereço é obrigatório!");
		}
		if(cliente.getCpf() == null || cliente.getCpf().equals("")){
			msgsErro.add("O campo CPF é obrigatório!");
		}
		if(msgsErro.size() > 0){
			return msgsErro;
		} else {
			return null;
		}
	}
	

}
