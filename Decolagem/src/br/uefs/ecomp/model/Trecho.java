/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uefs.ecomp.model;

import java.util.ArrayList;
import java.util.List;

/**
 *Classe modelo
 * @author marcos
 */
public class Trecho implements Comparable<Trecho> {
    
    private String cidadeorigem;
    private String cidadedestino;
    private int  companhia;
    private int quantAssentos;
    private int semaforo;
    private int id;
    private List<Espera> fila;

    public Trecho(String cidadeorigem, String cidadedestino, int  companhia, int quantAssentos, int id) {
        this.cidadeorigem = cidadeorigem;
        this.cidadedestino = cidadedestino;
        this.companhia = companhia;
        this.quantAssentos = quantAssentos;
        this.fila = new ArrayList<>();
        this.semaforo = 0;
        this.id = id;
    }

    public String getCidadeorigem() {
        return cidadeorigem;
    }

    public void setCidadeorigem(String cidadeorigem) {
        this.cidadeorigem = cidadeorigem;
    }

    public String getCidadedestino() {
        return cidadedestino;
    }

    public void setCidadedestino(String cidadedestino) {
        this.cidadedestino = cidadedestino;
    }

    public int  getCompanhia() {
        return companhia;
    }

    public void setCompanhia(int  companhia) {
        this.companhia = companhia;
    }

    public int getQuantAssentos() {
        return quantAssentos;
    }

    public void setQuantAssentos(int quantAssentos) {
        this.quantAssentos = quantAssentos;
    }

    public List<Espera> getFila() {
        return fila;
    }

    public void setFila(List<Espera> fila) {
        this.fila = fila;
    }

    public int getSemaforo() {
        return semaforo;
    }

    public void setSemaforo(int semaforo) {
        this.semaforo = semaforo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return  cidadeorigem +" --> "+ cidadedestino + " | assentos: " + quantAssentos ;
    }

    @Override
    public int compareTo(Trecho t) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       if (this.semaforo < t.semaforo) {
            return 1;
        }
        if (this.semaforo > t.semaforo  ) {
            return -1;
        }
        return 0;
    }
    
    
    
    
}
