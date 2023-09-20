$(document).ready(function(){
    $('#novo-sorteio').click(function(){
        $('#conteudo').load('Main.html #conteudo-formulario'); // Carrega apenas o conteúdo do formulário da página principal
    });
});