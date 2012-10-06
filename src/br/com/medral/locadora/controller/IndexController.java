package br.com.medral.locadora.controller;

import java.util.List;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.medral.locadora.dao.ClienteDao;
import br.com.medral.locadora.entity.TbCliente;

@Resource
public class IndexController {

	private final Result result;
	private ClienteDao clienteDao;

	public IndexController(Result result, ClienteDao clienteDao) {
		this.result = result;
		this.clienteDao = clienteDao;
	}
	
	@Get("/")
	public void index() {
		List<TbCliente> listaTodos = clienteDao.listaTodos();
		
		result.include("listaCliente", listaTodos);	
	}
}
