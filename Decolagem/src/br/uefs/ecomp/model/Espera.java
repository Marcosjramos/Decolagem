/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uefs.ecomp.model;

/**
 *
 * @author cassio
 */

/** A classe  espera para ser o mecanisno de espera caso usuario precisar entrar . <br/>*/

public class Espera {
    private int num;    /** Variavel num  para ser  número na espera   .<br/>*/
    private String ip;  /** Variavel para  se o endereço ip .<br/>*/

    public int getNum() {
        /** A função retorna  o num  da lista de espera  .<br/>*/
        return num;
    }

    public void setNum(int num) {
        /** A função  que aletra o nun na lista de espera .<br/>*/
        this.num = num;
    }

    public String getIp() {
        /** A função retorna  o endereço  ip  .<br/>*/
        return ip;
    }

    public void setIp(String ip) {
        /** A função  que aletra o endereço ip .<br/>*/
        this.ip = ip;
    }
    
    
}
