package com.example.Sorteador.Service;

import com.example.Sorteador.Controller.Informacoes;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
    public class S_informações {

        public static Informacoes obterInformacoesExtras(List<Integer> numerosSorteados, int minimo, int maximo) {
            String horaSorteio = obterHoraAtualComoString();
            int qtdSorteados = numerosSorteados.size();
            String intervaloSorteado = minimo + " - " + maximo;

            return new Informacoes(horaSorteio, qtdSorteados, intervaloSorteado);
        }

        private static String obterHoraAtualComoString() {
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
            return now.format(formatter);
        }
    }


