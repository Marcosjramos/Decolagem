/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uefs.ecomp.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author marcos
 */

public enum Trechos {

    trecho1("Salvador", "Rio de Janeiro", 1, 2),
    
    trecho2("Rio de Janeiro", "São Paulo", 2, 2),
    
    trecho3("Brasília", "Fortaleza", 2, 2),
    
    trecho4("Salvador", "Aracaju", 2, 2),
   
    trecho5("Fortaleza", "Brasília", 2, 2),
    
    trecho6("Recife", "São Paulo", 2, 2),
   
    trecho7("Manaus", "Fortaleza", 2, 2),
    
    trecho8("Natal", "Vitória", 3, 2),
    
    trecho9("Recife", "São Paulo", 3, 2),
   
    trecho10("São Paulo", "Salvador", 3, 2),
   
    trecho11("Manaus", "São Paulo", 3, 2),
    
    trecho12("Fortaleza", "Natal", 3, 2),
   
    trecho13("Natal", "Brasília", 3, 2),
    
    trecho14("Salvador", "Vitória", 3, 2),
    
    trecho15("Salvador", "Manaus", 3, 2),
    
    trecho16("Natal", "Recife", 3, 2),
    
    trecho17("Salvador", "São Paulo", 1, 2),
    
    trecho18("Natal", "Salvador", 1, 2),
    
    trecho19("Cuiabá", "Vitória", 1, 2),
    
    trecho20("Brasília", "Vitória", 1, 2),
    
    trecho21("Manaus", "Vitória", 1, 2),
    
    trecho22("Curitiba", "Aracaju", 1, 2),
    
    trecho23("Recife", "Aracaju", 1, 2),
    
    trecho24("Recife", "Manaus", 1, 2),
    
    trecho25("Salvador", "São Paulo", 1, 2),
    
    trecho26("São Paulo", "Recife", 1, 2),
    
    trecho27("Aracaju", "Rio de Janeiro", 2, 2),
    
    trecho28("Rio de Janeiro", "Natal", 2, 2),
    
    trecho29("Rio de Janeiro", "Natal", 2, 2),
    
    trecho30("Salvador", "Brasília", 2, 2),
    
    trecho31("Salvador", "Florianópolis", 2, 2),
  
    trecho32("Porto Alegre", "Cuiaba", 3, 2);

    private final String origem;
    private final String destino;
    private final int companhia;
    private final int quantAssentos;

    Trechos(String origem, String destino, int companhia, int quantAssentos) {
        this.origem = origem;
        this.destino = destino;
        this.companhia = companhia;
        this.quantAssentos = quantAssentos;
    }

    private static final Trechos[] trechos = values();

 
    public static List retornarListaTrechos() {
        Trecho trecho;
        List<Trecho> lista = new ArrayList<>();

        for (Trechos trechos : trechos) {
                trecho = new Trecho(trechos.getOrigem(), trechos.getDestino(), trechos.getCompanhia(),
                                    trechos.getQuantAssentos());
                lista.add(trecho);
        }
       
        return lista;
    }

    public String getOrigem() {
        return origem;
    }

    public String getDestino() {
        return destino;
    }

    public int getCompanhia() {
        return companhia;
    }
    
    public int getQuantAssentos() {
        return quantAssentos;
    }
}