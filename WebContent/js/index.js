function gerenciarCliente() {
	$.ajax({
		url : '/locadora/cliente',
		success : function(data){
			$("#errosMsg").html("");
			$("#successMsg").html("");
			$('#conteudo').html(data);
		}
	});
}

function gerenciarFilme() {
	$.ajax({
		url : '/locadora/filme',
		success : function(data) {
			$("#errosMsg").html("");
			$("#successMsg").html("");
			$('#conteudo').html(data);
		}
	});
}

function alugarFilme(){
	$("#successMsg").html("");
	$("#errosMsg").html("");
	$('#conteudo').html($("#alugarFilme").html());
}

function alugar(){
	var mensagemSucesso = "Filme reservado com sucesso!";
	filme = {
			filme : $("#filme_locacao").val()
		};
	ajaxSubmit(
		'/locadora/locacao/alugar/'+$("#idCliente_locacao").val(), 
		"POST", 
		JSON.stringify({filme: filme}), 
		mensagemSucesso,
		function(data) {
			$("#successMsg").html(mensagemSucesso);
		});
}

function devolverFilme(){
	$("#successMsg").html("");
	$("#errosMsg").html("");
	$('#conteudo').html($("#devolverFilme").html());
}

function devolver(){
	var mensagemSucesso = "Filme devolvido com sucesso!";
	filme = {
			filme : $("#filme_devolucao").val()
		};
	ajaxSubmit(
		'/locadora/locacao/devolver/'+$("#idCliente_devolucao").val(), 
		"POST", 
		JSON.stringify({filme: filme}), 
		mensagemSucesso,
		function(data) {
			$("#successMsg").html(mensagemSucesso);
		});
}

function carregarListaCliente(){
	$.ajax({
		url : '/locadora/cliente',
		success : function(data){
			$('#conteudo').html(data);
		}
	});
}

function carregarListaFilme(){
	$.ajax({
		url : '/locadora/filme',
		success : function(data){
			$('#conteudo').html(data);
		}
	});
}

function ajax(url, metodo){
	$("#successMsg").html("");
	$("#errosMsg").html("");
	$.ajax({
		type : metodo,
		url : url,
		success : function(data) {
			$('#conteudo').html(data);
		}
	});
}

function ajaxSubmit(url, metodo, dados, mensagemSucesso, callBackSuccess){
	$("#successMsg").html("");
	$("#errosMsg").html("");
	$.ajax({
		type : metodo,
		contentType: "application/json",
		url : url,
		data: dados,
		success : callBackSuccess,
		
		error: function(jqXHR, textStatus, errorThrown) {
			var mensagemErro = "";
			erros = jQuery.parseJSON(jqXHR.responseText).list;
			if ($.isArray(erros)) {
				for (var i = 0; i < erros.length; i++) {
					mensagemErro += erros[i] + "</br>";
				}
			} 
	        $("#errosMsg").html(mensagemErro);
	    }
	});
}