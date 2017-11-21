package com.milkfarm.testeapp;


import java.io.Serializable;

public class Signo implements Serializable {
    private  int diaInicio;
    private  int diaFim;
    private int mesInicio;
    private int mesFim;
    private String nome;
    private  String imagem;

    public Signo() {

    }

    public Signo(int diaInicio,int mesInicio, int diaFim,  int mesFim, String nome, String imagem) {
        this.diaInicio = diaInicio;
        this.diaFim = diaFim;
        this.mesInicio = mesInicio;
        this.mesFim = mesFim;
        this.nome = nome;
        this.imagem = imagem;
    }

    public int getDiaInicio() {
        return diaInicio;
    }

    public int getDiaFim() {
        return diaFim;
    }

    public int getMesInicio() {
        return mesInicio;
    }

    public int getMesFim() {
        return mesFim;
    }

    public String getNome() {
        return nome;
    }

    public String getImagem() {
        return imagem;
    }
}
