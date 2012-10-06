<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<table class="table table-striped">
	<thead>
		<tr>
			<th>Id</th>
			<th>Nome</th>
			<th>Endereco</th>
			<th>CPF</th>
			<th><span class="translation_missing"
				title="translation missing: en.helpers.actions">Actions</span>
			</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${listaCliente}" var="cliente">
			<tr>
				<td>${cliente.id}</td>
				<td>${cliente.nome}</td>
				<td>${cliente.endereco}</td>
				<td>${cliente.cpf}</td>
				<td><a href="#" class="btn btn-mini"
					onclick="ajax('/locadora/cliente/form?idCliente=${cliente.id}','GET')"> <span
						title="Editar">Editar</span>
				</a> <a href="#" class="btn btn-mini btn-danger"
					data-method="delete" rel="nofollow"
					onclick="removerCliente('${cliente.id}')"> <span
						title="Remover">Remover</span>
				</a></td>
			</tr>
		</c:forEach>
	</tbody>
</table>

<a href="#" onclick="ajax('/locadora/cliente/form','GET')" class="btn btn-primary"> <span
	title="Adicionar">Adicionar</span> </a>

<script type="text/javascript">
	function removerCliente(idCliente) {
		$("#successMsg").html("");
		$.ajax({
			type : 'POST',
			url : '/locadora/cliente/excluir/' + idCliente,
			success : function(data) {
				carregarListaCliente();
				$("#successMsg").html("Cliente removido com sucesso!");
			}
		});
	}
</script>