/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.joseprado.factory;

import br.com.joseprado.entity.Acoes;
import br.com.joseprado.entity.Jogo;
import br.com.joseprado.entity.Resultado;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author jose.prado
 */
public class OrganizaLogFactory {
    
    public OrganizaLogFactory() {

    }
    
    public Jogo organizaJogo(String[] lista){
       // List<Jogo> listaJogo = new ArrayList<>();
        Jogo jogo = new Jogo();
        if(lista == null || lista.length > 0){
            
           // Jogo jogo = new Jogo();
            List<Acoes> listaAcoes = new ArrayList<>();
            
            for (String linha : lista) {
                if(linha != null || !linha.equals("")){
                    
                    String[] separacao = linha.split(" ");
                    
                    if(separacao != null || separacao.length > 0){
                        
                        if(separacao[3].equals("New")) {
                                jogo.setHora_inicio(separacao[0].concat(" ").concat(separacao[1]));
                                jogo.setNome(separacao[5]);
                        } else if (separacao[3].equals("Match")) {
                                jogo.setHora_fim(separacao[0].concat(" ").concat(separacao[1]));
                        } else {
                                Acoes acoes = new Acoes();
                                
                                acoes.setHora(separacao[0].concat(" ").concat(separacao[1]));
                                if(!separacao[3].equals("<WORLD>")) {
                                    acoes.setAssassino(separacao[3]);
                                } else {
                                    acoes.setAssassino("");
                                }
                                acoes.setAssassinado(separacao[5]);
                                acoes.setArmaUsada(separacao[7]);
                                
                                listaAcoes.add(acoes);
                        }
                    }
                    
                }
            }
            jogo.setAcoes(listaAcoes);
         //   listaJogo.add(jogo);
        }
        
        //return listaJogo;
        return jogo;
    }
    
    public Resultado getResultado(List<Acoes> listaAcoes){
        Resultado resultado = null;
        
        if(listaAcoes != null || !listaAcoes.isEmpty()){
            resultado = new Resultado();
            
            String maiorAssassino = getDestaques(listaAcoes, true, false, false, null);
            String maiorAssassinado = getDestaques(listaAcoes, false, true, false, null);
            
            maiorAssassino = maiorAssassino.replace("{", "").replace("}", "").trim();
            maiorAssassinado = maiorAssassinado.replace("{", "").replace("}", "").trim();
            
            String[] listAssassino = maiorAssassino.split("=");
            String[] listAssassinado = maiorAssassinado.split("=");
            
            resultado.setMaiorAssassino(listAssassino[0]);
            resultado.setNumeroAssassinatos(listAssassino[1]);
            
            resultado.setMaiorAssassinado(listAssassinado[0]);
            resultado.setNumeroMortes(listAssassinado[1]);
            
            String armaUsada = getDestaques(listaAcoes, false, false, true, resultado.getMaiorAssassino());
            
            armaUsada = armaUsada.replace("{", "").replace("}", "").trim();
            
            String[] listArma = armaUsada.split("=");
            
            resultado.setArmaUsada(listArma[0]);
         }
        
        
        return resultado;
    }
    
    public String getDestaques(List<Acoes> listaAcoes, boolean assassino, boolean assassinado, boolean arma, String maiorAssassino) {
        
        List<String> lista = new ArrayList<>();
        Map<String, Integer> map = new LinkedHashMap<>(); 
        if(listaAcoes != null || !listaAcoes.isEmpty()) {
            for(Acoes acoes : listaAcoes){
                if(assassino) {
                    if(!acoes.getAssassino().equals(""))
                        lista.add(acoes.getAssassino());
                }
                else if (assassinado) {
                    lista.add(acoes.getAssassinado());
                }
                else if (arma) {
                    if(maiorAssassino != null && acoes.getAssassino().equals(maiorAssassino))
                        lista.add(acoes.getArmaUsada());
                }   
            } 
            
            Iterator it = lista.iterator();
            while(it.hasNext()){
                Object obj = it.next();
                int frequency = Collections.frequency(lista, obj);
                int lastFrequency = 0;
                if (frequency > lastFrequency){
                    lastFrequency = frequency;
                    map.clear();
                    map.put(String.valueOf(obj), frequency);
                }
            }
         }
        
        return  map.toString();
    }
    
   /* public String getMaiorAssassino(List<Acoes> listaAcoes) {
        List<String> assassinos = new ArrayList<>();
        String maiorAssassino = "";
        Map<String, Integer> map = new LinkedHashMap<>(); 
        if(listaAcoes != null || !listaAcoes.isEmpty()) {
            for(Acoes acoes : listaAcoes){
                if(!acoes.getAssassino().equals(""))
                    assassinos.add(acoes.getAssassino());
            } 
            
            Iterator it = assassinos.iterator();
            while(it.hasNext()){
                Object obj = it.next();
                int frequency = Collections.frequency(assassinos, obj);
                int lastFrequency = 0;
                if (frequency > lastFrequency){
                    lastFrequency = frequency;
                    map.clear();
                    map.put(String.valueOf(obj), frequency);
                }
            }
            maiorAssassino = map.toString();
        }
        return maiorAssassino;
    }
    
    public String getMaiorAssassinado(List<Acoes> listaAcoes) {
        List<String> assassinados = new ArrayList<>();
        String maiorAssassinado;
        Map<String, Integer> map = new LinkedHashMap<>(); 
        if(listaAcoes != null || !listaAcoes.isEmpty()) {
            for(Acoes acoes : listaAcoes){
                assassinados.add(acoes.getAssassinado());
            } 
            
            Iterator it = assassinados.iterator();
            while(it.hasNext()){
                Object obj = it.next();  
                int frequency = Collections.frequency(assassinados, obj);  
                int lastFrequency = 0;
                if (frequency > lastFrequency){
                    lastFrequency = frequency;
                    map.clear();
                    map.put(String.valueOf(obj), frequency);
                }
            }
            System.out.println(map);
        }
        return "";
    }
    
    public String getArmaUsada(List<Acoes> listaAcoes, String assassino) {
        List<String> armaUsada = new ArrayList<>();
        String armaMaisUsada;
        Map<String, Integer> map = new LinkedHashMap<>(); 
        if(listaAcoes != null || !listaAcoes.isEmpty()) {
            for(Acoes acoes : listaAcoes){
                if(acoes.getAssassino().equals(assassino))
                    armaUsada.add(acoes.getArmaUsada());
            } 
            
            Iterator it = armaUsada.iterator();
            while(it.hasNext()){
                Object obj = it.next();  
                int frequency = Collections.frequency(armaUsada, obj);  
                int lastFrequency = 0;
                if (frequency > lastFrequency){
                    lastFrequency = frequency;
                    map.clear();
                    map.put(String.valueOf(obj), frequency);
                } 
            }
            String mapa = map.toString();
        }
        return "";
    }*/
}
