/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uefs.ecomp.model;

/**
 *
 * @author marcos
 */
public class Trecho {
    
    private String cidadeorigem;
    private String cidadedestino;
    private int  companhia;
    private int quantAssentos;

    public Trecho(String cidadeorigem, String cidadedestino, int  companhia, int quantAssentos) {
        this.cidadeorigem = cidadeorigem;
        this.cidadedestino = cidadedestino;
        this.companhia = companhia;
        this.quantAssentos = quantAssentos;
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
    
    
    
}
