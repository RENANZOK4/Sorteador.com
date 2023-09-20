package com.example.Sorteador.Controller;

import com.example.Sorteador.Model.Sorteio;
import com.example.Sorteador.Service.S_informações;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;;
import java.util.List;


@Controller
public class SorteioController {
    @Autowired
    private S_informações informacoesService;

    @GetMapping("/resultado")
    public String resultpage() {
        return "Resultado";
    }

    @GetMapping("/")
    public String landPage() {
        return "Home/Main";
    }

    @PostMapping("/sortear")
    public ResponseEntity<List<Integer>> sortearNumeros(
            @RequestParam int quantidade,
            @RequestParam int minimo,
            @RequestParam int maximo) {
        try {
            List<Integer> numerosSorteados = Sorteio.sortearNumeros(quantidade, minimo, maximo);
            return ResponseEntity.ok(numerosSorteados);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/informacoes")
    public ResponseEntity<Informacoes> obterInformacoes(
            @RequestParam int quantidade,
            @RequestParam int minimo,
            @RequestParam int maximo) {
        try {
            List<Integer> numerosSorteados = Sorteio.sortearNumeros(quantidade, minimo, maximo);
            Informacoes informacoes = informacoesService.obterInformacoesExtras(numerosSorteados, minimo, maximo);

            return ResponseEntity.ok(informacoes);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
