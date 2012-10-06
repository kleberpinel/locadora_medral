<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
  <title>Locadora Medral</title>  

  <script src="/locadora/js/jquery-1.8.2.min.js" type="text/javascript"></script>

  <!-- Bootstrap -->
  <link href="/locadora/css/bootstrap.min.css" media="screen" rel="stylesheet" type="text/css" />
  <link href="/locadora/css/bootstrap-responsive.min.css" media="screen" rel="stylesheet" type="text/css" />

	<!--
  <link href="/assets/bootstrap/docs-50ea7a4a976cecc331cb1a90fcb67012.css" media="screen" rel="stylesheet" type="text/css" />
  <link href="/assets/bootstrap/prettify-484dff354158bde4dc7219d7a6f8d24b.css" media="screen" rel="stylesheet" type="text/css" />
	-->
	
  <script src="/locadora/js/bootstrap.min.js" type="text/javascript"></script>
  <script src="/locadora/js/index.js" type="text/javascript"></script>

  <meta http-equiv="content-language" content="pt">
</head>
<body>
	
  <div class="navbar navbar-fixed-top">
    <div class="navbar-inner">
      <div class="container">
        <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        </a>
        <img src="/locadora/img/banner_locadora.jpg" width="100px"/>
       </div><!--/.nav-collapse -->
    </div>
  </div>  
    
  
  	<div class="container">
       
      
     	<header class="jumbotron subhead" id="overview">
        <!--<h1>Atividades</h1>--><br>
        <p class="lead">Escolha a atividade que deseja executar</p>
        <div class="subnav">


          <ul class="nav nav-pills">
            <li class="dropdown">
              <a class="dropdown-toggle" data-toggle="dropdown" href="#">Cadastro <b class="caret"></b></a>
              <ul class="dropdown-menu">
                <li><a href="#" onclick="gerenciarFilme()">Filme</a></li>
                <li><a href="#" onclick="gerenciarCliente()">Cliente</a></li>
              </ul>
            </li>
            
             <li class="dropdown">
				
              <a href="#" onclick="alugarFilme()" class="dropdown-toggle" data-method="get">Alugar Filme</a> 
             </li>
             <li class="dropdown">
              <a href="#" onclick="devolverFilme()" data-method="get">Devolver Filme</a>  
            </li>
          </ul>
        </div>
      </header>

	 <span class="box green" id="successMsg">${msg}</span>
	 <div id="errosMsg"></div>
     
     <div id="conteudo"></div>
     
     <div id="alugarFilme" style="display: none;">
     	Digite o filme que o cliente 
     	<select id="idCliente_locacao">
     		<option value="-1">Selecione o cliente</option>
     		<c:forEach items="${listaCliente}" var="cliente">
     			<option value="${cliente.id}">${cliente.nome}</option>
     		</c:forEach>
     	</select>
     	deseja alugar:<br>
     	<input type="text" id="filme_locacao"><br>
     	<a href="#" onclick="alugar()"
			class="btn"><span class="translation_missing"
			title="Alugar">Alugar</span></a>
     </div>
     
     <div id="devolverFilme" style="display: none;">
     	Digite o filme que o cliente
     	<select id="idCliente_devolucao">
     		<option value="-1">Selecione o cliente</option>
     		<c:forEach items="${listaCliente}" var="cliente">
     			<option value="${cliente.id}">${cliente.nome}</option>
     		</c:forEach>
     	</select>
     	 deseja devolver:<br>
     	<input type="text" id="filme_devolucao"><br>
     	<a href="#" onclick="devolver()"
			class="btn"><span class="translation_missing"
			title="Devolver">Devolver</span></a>
     </div>

	</div> <!-- /container -->
	<script type="text/javascript">
	    $(document).scroll(function(){
	        // If has not activated (has no attribute "data-top"
	        if (!$('.subnav').attr('data-top')) {
	            // If already fixed, then do nothing
	            if ($('.subnav').hasClass('subnav-fixed')) return;
	            // Remember top position
	            var offset = $('.subnav').offset()
	            $('.subnav').attr('data-top', 110);
	        }
	
	        if ($('.subnav').attr('data-top') - $('.subnav').outerHeight() <= $(this).scrollTop())
	            $('.subnav').addClass('subnav-fixed');
	        else
	            $('.subnav').removeClass('subnav-fixed');
	        
	    });
	    ${loadFunctionJS}
        
	  </script>
	</body>
</html>