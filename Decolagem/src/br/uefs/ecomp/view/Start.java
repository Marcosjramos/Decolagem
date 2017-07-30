/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uefs.ecomp.view;

import java.awt.EventQueue;
import java.net.SocketException;

/**
 *
 * @author marcos
 */
public class Start {
       
    
    
    public static void main(String[] args) throws SocketException {
      
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UsuarioGui window = new UsuarioGui();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    
}
