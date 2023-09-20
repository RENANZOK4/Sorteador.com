$(document).ready(function(){
    // Esconde as informações no início
    $('.info').hide();
    $('.info, #novo-sorteio').hide();

    $('#sortear').click(function(){
        var quantidade = $('#quantidade').val();
        var minimo = $('#minimo').val();
        var maximo = $('#maximo').val();
        var ordenar = $('#ordenar').val(); // Obtém o valor da caixa de seleção de ordenação
        var permitirRepeticoes = $('#repeticoes').val(); // Obtém o valor da caixa de seleção de repetições

        $.ajax({
            type: 'POST',
            url: '/sortear',
            data: {
                quantidade: quantidade,
                minimo: minimo,
                maximo: maximo,
                ordenar: ordenar, // Envia a seleção de ordenação
                permitirRepeticoes: permitirRepeticoes // Envia a seleção de repetições
            },
            success: function(data){
                // Esconde o conteúdo do formulário
                $('#conteudo-formulario').hide();

                // Atualiza e exibe o conteúdo dos resultados
                $('#conteudo-resultados').html('Números Sorteados: ' + data.join(', '));
                $('#conteudo-resultados').show(); // Aqui ele exibe os resultados

                // Adiciona informações extras usando AJAX
                $.ajax({
                    type: 'GET',
                    url: '/informacoes',
                    data: {
                        quantidade: quantidade,
                        minimo: minimo,
                        maximo: maximo,
                        ordenar: ordenar, // Envia a seleção de ordenação
                        permitirRepeticoes: permitirRepeticoes // Envia a seleção de repetições
                    },
                    success: function(info){
                        $('#hora-sorteo').text('Hora do Sorteio: ' + info.horaSorteio);
                        $('#qtd-sorteada').text('Quantidade de Números Sorteados: ' + info.qtdSorteados);
                        $('#intervalo-sorteado').text('Intervalo Sorteado: ' + info.intervaloSorteado);

                        // Exibe as informações extras
                        $('.info').show();
                        $('#novo-sorteio').show();
                    },
                    error: function(){
                        alert('Ocorreu um erro ao obter informações extras.');
                    }
                });
            },
            error: function(){
                alert('Ocorreu um erro ao sortear os números.');
            }
        });
    });

    // Adiciona a ação ao botão "Fazer outro sorteio"
    $('#novo-sorteio').click(function(){
        // Reseta os valores dos inputs
        $('#quantidade').val('1');
        $('#minimo').val('1');
        $('#maximo').val('10');

        // Esconde as informações e o botão
        $('.info, #novo-sorteio').hide();

        // Exibe o conteúdo do formulário
        $('#conteudo-formulario').show();

        // Limpa os resultados anteriores
        $('#conteudo-resultados').empty();
    });
});
