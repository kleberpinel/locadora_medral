<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<form class="form-horizontal" id="form" method="post">
	
	<input type="hidden" name="filme.id" id="filme_id" value="${filme.id}" />

	<div class="control-group">
		<label class="control-label" for="filme_nome">Filme</label>
		<div class="controls">
			<input class="text_field" id="filme_nome" name="filme.nome"
				value="${filme.filme}" size="30" type="text" />
		</div>
	</div>

	<div class="control-group">
		<label class="control-label" for="filme_genero">Genero</label>
		<div class="controls">
			<input class="text_field" id="filme_genero"
				name="filme.genero" value="${filme.genero}" size="30"
				type="text" />
		</div>
	</div>

	<div class="form-actions">
		<input class="btn btn-primary" name="commit" type="submit"
			value="Salvar" /> <a href="#" onclick="gerenciarFilme()"
			class="btn"><span class="translation_missing"
			title="translation missing: en.helpers.links.cancel">Cancelar</span>
		</a>
	</div>
	
	<script type="text/javascript">
		$("#form").bind({
			submit : function() {
				mensagemSucesso = "Filme salvo com sucesso!";
				filme = {
					filme : $("#filme_nome").val(),
					genero : $("#filme_genero").val()
				};
				if($("#filme_id").val() != ""){
					filme.id = $("#filme_id").val();
					mensagemSucesso = "Filme atualizado com sucesso!";
				}
				ajaxSubmit(
						'/locadora/filme/salvar', 
						"POST", 
						JSON.stringify({filme: filme}), 
						mensagemSucesso,
						function(data) {
							carregarListaFilme();
							$("#successMsg").html(mensagemSucesso);
						});
				
				return false;
			},
		});
	</script>

</form>
