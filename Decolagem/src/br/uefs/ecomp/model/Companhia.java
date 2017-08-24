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
/**  Classe  que refere-se a companhia  no sistema.   <br/>*/
public class Companhia {
    
    private String ip; /** variavel ip para ser usada identifica qual é a compatia  em questão.  <br/>*/
    private int id; /**  variavél id  para  fazer  a  referencia de algumas ações  do sistema .<br/>*/

    public String getIp() {
        /** A função  getIp retorno o ip da companhia. <br/>*/
        return ip;
    }

    public void setIp(String ip) {
         /** A função  setIp  altera  o endereço ip da companhia.  <br/>*/
        this.ip = ip;
    }

    public int getId() {
         /** A função getId  retorna o id da companhia.  <br/>*/
        return id;
    }

    public void setId(int id) {
         /** A função setId retorna o ide da companhia. <br/>*/
        this.id = id;
    }
    
    
}
