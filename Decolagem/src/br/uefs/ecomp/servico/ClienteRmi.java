/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uefs.ecomp.servico;

import br.uefs.ecomp.model.Companhia;
import br.uefs.ecomp.model.Trecho;
import br.uefs.ecomp.util.InterfaceData;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;

/**
 *
 * @author cassio
 */
public class ClienteRmi{
    
    private InterfaceData msi1;
     private InterfaceData msi2;
      private InterfaceData msi3;
      private Companhia c1;
      private Companhia c2;
      private Companhia c3;
      private List<Companhia> companhias;
      
    //private 
        public ClienteRmi() {
         
        System.out.println("Arrancando cliente...");
        companhias = new ArrayList<>();
        c1 = new Companhia();
        c1.setIp("40.0.0.106");
        c1.setId(1);
        c2 = new Companhia();
        c2.setIp("40.0.0.106");
        c2.setId(2);
        c3 = new Companhia();
        c3.setIp("40.0.0.106");
        c3.setId(3);
        companhias.add(c1);
        companhias.add(c2);
        companhias.add(c3);
        
        try {
            msi1 = (InterfaceData) Naming.lookup("//"+c1.getIp()+"/"+"1099");
            msi2 = (InterfaceData) Naming.lookup("//"+c2.getIp()+"/"+"1099");
            msi3 = (InterfaceData) Naming.lookup("//"+c3.getIp()+"/"+"1099");
        } catch (Exception e) {
            System.out.println("Falhou o arranque do Cliente.\n" + e.toString());
            System.out.println("Certifique-se que tanto o Servidor de registros como a aplicação Servidora estão  a correr corretamente.\n");
            System.exit(0);
        }
    }
        
        public String trechos() throws RemoteException, UnknownHostException, JSONException{
            JSONArray trechos = new JSONArray();
           // trechos.add(msi1.buscarTrecho(2));
            System.out.println(getIp()); 
            String ip = getIp();
            for (int i = 0; companhias.size() > i; i++) {
                if((companhias.get(i).equals(ip))){
                    switch(companhias.get(i).getId()) {
                        case 1:
                             JSONArray j1 = new JSONArray(msi1.buscarTrecho(companhias.get(i).getId()));
                             trechos.put(j1);
                            break;
                        case 2:
                         //   msi2.buscarTrecho(companhias.get(i).getId());
                             JSONArray j2 = new JSONArray(msi1.buscarTrecho(companhias.get(i).getId()));
                             trechos.put(j2);
                            break;
                        case 3:
                             JSONArray j3 = new JSONArray(msi1.buscarTrecho(companhias.get(i).getId()));
                             trechos.put(j3);
                    }
                     //msi1.buscarTrecho(companhias.get(i).getId());
                     
                }
            }
           return trechos().toString();
        }
        
                public String trechos2() throws RemoteException, UnknownHostException, JSONException{
            JSONArray trechos = new JSONArray();
           // trechos.add(msi1.buscarTrecho(2));
            System.out.println(getIp()); 
            String ip = getIp();
            for (int i = 0; companhias.size() > i; i++) {
                if((companhias.get(i).equals(ip))){
                    switch(companhias.get(i).getId()) {
                        case 1:
                             JSONArray j1 = new JSONArray(msi1.buscarTrecho(companhias.get(i).getId()));
                             trechos.put(j1);
                            break;
                        case 2:
                         //   msi2.buscarTrecho(companhias.get(i).getId());
                             JSONArray j2 = new JSONArray(msi1.buscarTrecho(companhias.get(i).getId()));
                             trechos.put(j2);
                            break;
                        case 3:
                             JSONArray j3 = new JSONArray(msi1.buscarTrecho(companhias.get(i).getId()));
                             trechos.put(j3);
                    }
                     //msi1.buscarTrecho(companhias.get(i).getId());
                     
                }
            }
           return trechos().toString();
        }
        
        public String testar() throws RemoteException{
            return msi1.testar();
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