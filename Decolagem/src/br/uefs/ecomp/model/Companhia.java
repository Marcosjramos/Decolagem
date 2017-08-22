/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uefs.ecomp.model;

import java.util.List;

/**
 *
 * @author cassio
 */
public class Companhia {
    
    private String ip;
    private int id;
    private List<Integer> passagens;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Integer> getPassagens() {
        return passagens;
    }

    public void setPassagens(List<Integer> passagens) {
        this.passagens = passagens;
    }
    
    
}
