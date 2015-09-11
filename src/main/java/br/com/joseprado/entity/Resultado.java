/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.joseprado.entity;

/**
 *
 * @author jose.prado
 */
public class Resultado {
    
    private String maiorAssassino;
    private String maiorAssassinado;
    private String armaUsada;
    private String numeroAssassinatos;
    private String numeroMortes;

    public String getMaiorAssassino() {
        return maiorAssassino;
    }

    public void setMaiorAssassino(String maiorAssassino) {
        this.maiorAssassino = maiorAssassino;
    }

    public String getMaiorAssassinado() {
        return maiorAssassinado;
    }

    public void setMaiorAssassinado(String maiorAssassinado) {
        this.maiorAssassinado = maiorAssassinado;
    }

    public String getArmaUsada() {
        return armaUsada;
    }

    public void setArmaUsada(String armaUsada) {
        this.armaUsada = armaUsada;
    }

    public String getNumeroAssassinatos() {
        return numeroAssassinatos;
    }

    public void setNumeroAssassinatos(String numeroAssassinatos) {
        this.numeroAssassinatos = numeroAssassinatos;
    }

    public String getNumeroMortes() {
        return numeroMortes;
    }

    public void setNumeroMortes(String numeroMortes) {
        this.numeroMortes = numeroMortes;
    }
    
    
}
