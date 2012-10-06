package br.com.medral.locadora.controller;

import static br.com.caelum.vraptor.view.Results.http;
import static br.com.caelum.vraptor.view.Results.json;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.ObjectNotFoundException;

import br.com.caelum.vraptor.Consumes;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.medral.locadora.dao.ClienteDao;
import br.com.medral.locadora.dao.FilmeDao;
import br.com.medral.locadora.dao.LocacaoDao;
import br.com.medral.locadora.entity.TbCliente;
import br.com.medral.locadora.entity.TbFilme;

@Resource
public class LocacaoController {

	private final Result result;
	
	public FilmeDao filmeDao;
	public ClienteDao clienteDao;
	public LocacaoDao locacaoDao;

	public LocacaoController(Result result, FilmeDao filmeDao, LocacaoDao locacaoDao, ClienteDao clienteDao) {
		this.result = result;
		this.filmeDao = filmeDao;
		this.locacaoDao = locacaoDao;
		this.clienteDao = clienteDao;
	}
	
	@Post("/locacao/alugar/{idClienteLocador}")
	@Consumes("application/json")
	public void alugar(TbFilme filme, Integer idClienteLocador) {
		List<String> erros = new ArrayList<String>();
		filme = filmeDao.obterByNome(filme.getFilme());
		if(filme == null){
			erros.add("O filme que você procura não faz parte do nosso catalogo de filme!");
		} else {
			if(locacaoDao.indisponivel(filme)){
				erros.add("O filme que você procura não está disponivel para locação pois ja está alugado para outro cliente!");
			} else {
				TbCliente clienteLocador = clienteDao.obter(idClienteLocador);
				try{
					if(clienteLocador.getId() != null){
						locacaoDao.locarFilme(filme, clienteLocador);
						result.use(json());
					}
				} catch (ObjectNotFoundException e) {
					erros.add("Cliente não encontrado!");
				}
			}
		}
		if(erros.size() > 0){
			result.use(http()).setStatusCode(400);
			result.use(json()).from(erros).serialize();
		}
	}
	
	@Post("/locacao/devolver/{idClienteLocador}")
	@Consumes("application/json")
	public void devolver(TbFilme filme, Integer idClienteLocador) {
		List<String> erros = new ArrayList<String>();
		filme = filmeDao.obterByNome(filme.getFilme());
		if(filme == null){
			erros.add("O filme que você procura não faz parte do nosso catalogo de filme!");
		} else {
			if(locacaoDao.indisponivel(filme)){
				TbCliente clienteLocador = clienteDao.obter(idClienteLocador);
				try{
					if(clienteLocador.getId() != null){
						if(locacaoDao.devolverFilme(filme, clienteLocador)){
							result.use(json());
						} else {
							erros.add("Este filme não esta alugado para o cliente escolhido!");
						}
					}
				} catch (ObjectNotFoundException e) {
					erros.add("Cliente não encontrado!");
				}
			} else {
				erros.add("O filme que NÃO está alugado!");
			}
		}
		if(erros.size() > 0){
			result.use(http()).setStatusCode(400);
			result.use(json()).from(erros).serialize();
		}
	}
}
