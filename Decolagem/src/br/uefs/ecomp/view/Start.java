/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uefs.ecomp.view;

import br.uefs.ecomp.model.Trechos;
import br.uefs.ecomp.servico.ServidorRmi;
import java.awt.EventQueue;
import java.net.SocketException;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

/**
 *
 * @author marcos
 */
public class Start {
      
    /** A  seguir as instruções    que  stat o  sistema   e  seta os paramentros   para o funcionamento  do RMI .<br>*/
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

        try {
            LocateRegistry.createRegistry(1099);
            // Naming.rebind("//192.168.43.226/7777", servidorRMI);
            System.out.println("Arranca servidor...");
           Naming.rebind("//40.0.0.106/1099", new ServidorRmi());
        } catch (Exception e) {
            System.out.println("Ocorreu um problema de arranque no servidor.\n" + e.toString());
        }
    }

}
