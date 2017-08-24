/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uefs.ecomp.view;

import br.uefs.ecomp.model.Trecho;
import br.uefs.ecomp.model.Trechos;
import br.uefs.ecomp.servico.ClienteRmi;
import br.uefs.ecomp.servico.ServidorRmi;
import java.awt.EventQueue;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author marcos
 */
public class Start {
    public static List<Trecho> trechos;
    
      
    /** A  seguir as instruções    que  stat o  sistema   e  seta os paramentros   para o funcionamento  do RMI .<br>*/
    public static void main(String[] args) throws SocketException {
        gerarTrechos();
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
            System.out.println("Arranca servidor..."+getIp());
           Naming.rebind("//"+getIp()+"/1099", new ServidorRmi());
        } catch (Exception e) {
            System.out.println("Ocorreu um problema de arranque no servidor.\n" + e.toString());
        }
    }
    
    public static void gerarTrechos(){
         trechos = new ArrayList<>();
         for (Trecho trecho : Trechos.retornarListaTrechos2()) {
             trechos.add(trecho);
        }
    }
    
     public static String getIp() throws UnknownHostException {
        String host = "";
        String endereco = "";
        try {
            InetAddress myself = InetAddress.getLocalHost();
            host = myself.getHostName();
            //endereco = myself.getHostAddress();
        } catch (UnknownHostException ex) {
            ex.printStackTrace();
        }
        endereco = host + ".local";
        return InetAddress.getByName(endereco).getHostAddress();
        //return  "HostName: " + host + " IP: " + endereco;
    }

}
