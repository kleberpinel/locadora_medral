<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<form class="form-horizontal" id="form" method="post">
	
	<input type="hidden" name="cliente.id" id="cliente_id" value="${cliente.id}" />

	<div class="control-group">
		<label class="control-label" for="cliente_nome">Nome</label>
		<div class="controls">
			<input class="text_field" id="cliente_nome" name="cliente.nome"
				value="${cliente.nome}" size="30" type="text" />
		</div>
	</div>

	<div class="control-group">
		<label class="control-label" for="cliente_endereco">Endereço</label>
		<div class="controls">
			<input class="text_field" id="cliente_endereco"
				name="cliente.endereco" value="${cliente.endereco}" size="30"
				type="text" />
		</div>
	</div>

	<div class="control-group">
		<label class="control-label" for="cliente_cpf">CPF</label>
		<div class="controls">
			<input class="text_field" id="cliente_cpf" name="cliente.cpf"
				value="${cliente.cpf}" size="30" type="text" />
		</div>
	</div>

	<div class="form-actions">
		<input class="btn btn-primary" name="commit" type="submit"
			value="Salvar" /> <a href="#" onclick="gerenciarCliente()"
			class="btn"><span class="translation_missing"
			title="translation missing: en.helpers.links.cancel">Cancelar</span>
		</a>
	</div>
	
	<script type="text/javascript">
		$("#form").bind({
			submit : function() {
				mensagemSucesso = "Cliente salvo com sucesso!";
				cliente = {
					nome : $("#cliente_nome").val(),
					endereco : $("#cliente_endereco").val(),
					cpf : $("#cliente_cpf").val(),
				};
				if($("#cliente_id").val() != ""){
					cliente.id = $("#cliente_id").val();
					mensagemSucesso = "Cliente atualizado com sucesso!";
				}
				ajaxSubmit(
						'/locadora/cliente/salvar', 
						"POST", 
						JSON.stringify({cliente: cliente}), 
						mensagemSucesso,
						function(data) {
							carregarListaCliente();
							$("#successMsg").html(mensagemSucesso);
						});
				
				return false;
			},
		});
	</script>

</form>
