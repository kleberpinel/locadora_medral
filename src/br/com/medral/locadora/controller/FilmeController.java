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
import br.com.medral.locadora.dao.FilmeDao;
import br.com.medral.locadora.entity.TbFilme;

@Resource
public class FilmeController {

	private final Result result;
	
	public FilmeDao filmeDao;

	public FilmeController(Result result, FilmeDao filmeDao) {
		this.result = result;
		this.filmeDao = filmeDao;
	}
	
	@Get("/filme")
	public void filme() {
		List<TbFilme> listaTodos = filmeDao.listaTodos();
		
		result.include("listaFilme", listaTodos);
	}
	
	@Get("/filme/form")
	public void form(Integer idFilme) {
		if(idFilme != null){
			TbFilme filme  = filmeDao.obter(idFilme);
			result.include("filme", filme);
		}
	}
	
	@Post("/filme/salvar")
	@Consumes("application/json")
	public void salvar(TbFilme filme) {
		List<String> erros = validar(filme);
		if(erros == null){
			if(filme.getId() != null){
				filmeDao.atualiza(filme);
			} else {
				filmeDao.adiciona(filme);
			}
			result.use(json());
		} else {
			result.use(http()).setStatusCode(400);
			result.use(json()).from(erros).serialize();
		}
	}
	
	@Post("/filme/excluir/{idFilme}")
	public void excluir(Integer idFilme) {
		filmeDao.remover(new TbFilme(idFilme));
	}
	
	private List<String> validar(TbFilme filme){
		List<String> msgsErro = new ArrayList<String>();
		if(filme.getFilme() == null || filme.getFilme().equals("")){
			msgsErro.add("O campo Filme é obrigatório!");
		}
		if(filme.getGenero() == null || filme.getGenero().equals("")){
			msgsErro.add("O campo Genero é obrigatório!");
		}
		if(msgsErro.size() > 0){
			return msgsErro;
		} else {
			return null;
		}
	}
	

}
