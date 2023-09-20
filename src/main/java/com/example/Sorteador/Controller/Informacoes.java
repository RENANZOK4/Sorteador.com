package com.example.Sorteador.Controller;

public class Informacoes {
    private String horaSorteio;
    private int qtdSorteados;
    private String intervaloSorteado;

    // Construtor
    public Informacoes(String horaSorteio, int qtdSorteados, String intervaloSorteado) {
        this.horaSorteio = horaSorteio;
        this.qtdSorteados = qtdSorteados;
        this.intervaloSorteado = intervaloSorteado;
    }

    // Getters e Setters (Métodos de Acesso)
    public String getHoraSorteio() {
        return horaSorteio;
    }

    public void setHoraSorteio(String horaSorteio) {
        this.horaSorteio = horaSorteio;
    }

    public int getQtdSorteados() {
        return qtdSorteados;
    }

    public void setQtdSorteados(int qtdSorteados) {
        this.qtdSorteados = qtdSorteados;
    }

    public String getIntervaloSorteado() {
        return intervaloSorteado;
    }

    public void setIntervaloSorteado(String intervaloSorteado) {
        this.intervaloSorteado = intervaloSorteado;
    }
}
