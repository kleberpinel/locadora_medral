<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<table class="table table-striped">
	<thead>
		<tr>
			<th>Id</th>
			<th>Nome</th>
			<th>Genero</th>
			<th><span class="translation_missing"
				title="translation missing: en.helpers.actions">Actions</span>
			</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${listaFilme}" var="filme">
			<tr>
				<td>${filme.id}</td>
				<td>${filme.filme}</td>
				<td>${filme.genero}</td>
				<td><a href="#" class="btn btn-mini"
					onclick="ajax('/locadora/filme/form?idFilme=${filme.id}','GET')"> <span
						title="Editar">Editar</span>
				</a> <a href="#" class="btn btn-mini btn-danger"
					data-method="delete" rel="nofollow"
					onclick="removerFilme('${filme.id}')"> <span
						title="Remover">Remover</span>
				</a></td>
			</tr>
		</c:forEach>
	</tbody>
</table>

<a href="#" onclick="ajax('/locadora/filme/form','GET')" class="btn btn-primary"> <span
	title="Adicionar">Adicionar</span> </a>

<script type="text/javascript">
	function removerFilme(idFilme) {
		$("#successMsg").html("");
		$.ajax({
			type : 'POST',
			url : '/locadora/filme/excluir/' + idFilme,
			success : function(data) {
				carregarListaFilme();
				$("#successMsg").html("Filme removido com sucesso!");
			}
		});
	}
</script>