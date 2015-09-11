/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.joseprado.entity;

import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author jose.prado
 */
public class Acoes {
    
    private String assassino;
    private String assassinado;
    private String armaUsada;
    private String hora;

    
    public String getAssassino() {
        return assassino;
    }

    public void setAssassino(String assassino) {
        this.assassino = assassino;
    }

    public String getAssassinado() {
        return assassinado;
    }

    public void setAssassinado(String assassinado) {
        this.assassinado = assassinado;
    }

    public String getArmaUsada() {
        return armaUsada;
    }

    public void setArmaUsada(String armaUsada) {
        this.armaUsada = armaUsada;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    
}
