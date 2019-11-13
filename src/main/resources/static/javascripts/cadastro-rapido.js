$ (function() {
	
	var modal = $('#myModal');
	var btnSalvar = modal.find('.js-estilo-salvar-btn');
	var form = modal.find('form');
	form.on('submit', function(event){event.preventDefault()});
	var url = form.attr('action');
	var inputNomeEstilo=$('#nomeEstilo');
	var containerMensagemDeErro=$('.js-mensagem-cadastro-estilo');
	
	
	
	modal.on('hide.bs.modal' ,  onModalClose);
	modal.on('show.bs.modal' , onModalShow);
	btnSalvar.on('click' , onBotaoSalvarClick);
	
	function onModalClose(){
		inputNomeEstilo.val('');
	}
	
	function onModalShow(){
		inputNomeEstilo.focus();
	}
	
	
	function onBotaoSalvarClick(){
		var nomeEstilo= inputNomeEstilo.val().trim();
		$.ajax({
			url: url,
			method : 'POST',
			contentType: 'application/json',
			data:JSON.stringify({nome: nomeEstilo}),
			error: onErrorSalvandoEstilo,
			success:onEstiloSalvo
			
		});
		
	function onErrorSalvandoEstilo(obj){
		var mensagemErro=obj.responseText;
		containerMensagemDeErro.removeClass('hidden');
		containerMensagemDeErro.html('<span>' + mensagemErro + '</span>');
		form.find('.form-group').addClass('has-error');
	}		
	
	function onEstiloSalvo(estilo){
		var comboEstilo = $('#estilo');
		comboEstilo.append('<option value=' + estilo.codigo + '>'+ estilo.nome + '</option>');
		comboEstilo.val(estilo.codigo);
		modal.modal('hide');
	}
		
	}
	
	
});