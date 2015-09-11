/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.joseprado.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Classe que contem todos os métodos uteis para o projeto
 *
 * @author jose.prado
 */
public class Util {

    public Util() {

    }

    /**
     * Método responsável por conveter arquivo em Lista de String.
     *
     * @param caminhoArquivo
     * @return
     */
    public List<String> TxttoListString(String caminhoArquivo) {

        File arquivo = new File(caminhoArquivo);
        List<String> lista = new ArrayList<>();

        if (arquivo.exists()) {
            try {
                FileReader file = new FileReader(caminhoArquivo);
                BufferedReader leitura = new BufferedReader(file);
                while (true) {
                    lista.add(leitura.readLine());
                    if (leitura.readLine() == null) {
                        break;
                    }
                }

            } catch (FileNotFoundException ex) {
                Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return lista;
    }

    public String getStringFromInputStream(InputStream is) {

        BufferedReader br = null;
        StringBuilder sb = new StringBuilder();

        String line;
        try {

            br = new BufferedReader(new InputStreamReader(is));
            while ((line = br.readLine()) != null) {
                sb.append(line).append("\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return sb.toString();

    }

}
