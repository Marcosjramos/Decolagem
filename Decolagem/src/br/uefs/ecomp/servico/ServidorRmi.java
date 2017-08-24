/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uefs.ecomp.servico;

import br.uefs.ecomp.model.Companhia;
import br.uefs.ecomp.model.Espera;
import br.uefs.ecomp.model.Trecho;
import br.uefs.ecomp.model.Trechos;
import br.uefs.ecomp.util.InterfaceData;
import br.uefs.ecomp.view.Start;
import com.google.gson.Gson;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe Servidor
 * @author cassio
 */
public class ServidorRmi extends UnicastRemoteObject implements InterfaceData{

    /**
     * Construtor
     * @throws RemoteException 
     */
    public ServidorRmi() throws RemoteException {
        System.out.println("Servidor iniciado");
    }
    
    /**
     * Busca um trecho 
     * @param id int
     * @return JsonObject toString
     * @throws RemoteException 
     */
    @Override
    public String buscarTrecho(int id) throws RemoteException {
        Gson gson = new Gson();
        return gson.toJson(Trechos.retornarListaTrechos(id));
    }

    /**
     * Bloquia o recurso para os demais clientes
     * @param s Trecho
     * @param co Companhia
     * @throws RemoteException 
     */
    @Override
    public void reservar(String s, String co) throws RemoteException {
       
        Gson gson = new Gson();
        Companhia c = gson.fromJson(co, Companhia.class);
        Trecho t = gson.fromJson(s, Trecho.class);
        if (t.getSemaforo() == 0) {
        List<Trecho> trechos = Start.trechos;
        Trecho mTrecho = null;
        for (Trecho trecho : trechos) {
            if(trecho.getId() == t.getId()) {
                mTrecho = trecho;
                break;
            
            }
        }
        System.out.println("Verificação 2: "+ gson.toJson(mTrecho).toString() );
        if (mTrecho != null && t.getSemaforo() != 1) {
                mTrecho.setSemaforo(1);
                //Trechos.atualizarListaTrecho(mTrecho);
                List<Espera> lista = mTrecho.getFila();
                if(lista == null) {
                    lista = new ArrayList<>();
                }
                Espera e = new Espera();
                e.setIp(c.getIp());
                e.setNum(lista.size());
                lista.add(e);
                mTrecho.setFila(lista);
                Trechos.atualizarListaTrecho(mTrecho);
        }
        }
    }

    /**
     * Disponibiliza o recurso para os demais clientes
     * @param s Trecho
     * @param co Compnhia
     * @throws RemoteException 
     */
    @Override
    public void cancelarReservar(String s, String co) throws RemoteException {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
        Gson gson = new Gson();
        Companhia c = gson.fromJson(co, Companhia.class);
        Trecho t = gson.fromJson(s, Trecho.class);
        List<Trecho> trechos = Start.trechos;
        Trecho mTrecho = null;
        for (Trecho trecho : trechos) {
            if(trecho.getId() == t.getId()) {
                mTrecho = trecho;
                break;
            }
        }
        
        if (mTrecho != null) {
                mTrecho.setSemaforo(1);
                Trechos.atualizarListaTrecho(mTrecho);
                List<Espera> lista = mTrecho.getFila();
                Espera espera = null;
                if(lista != null) {
                    for (Espera espera1 : lista) {
                        if(espera1.getIp().equals(c.getIp())){
                            espera = espera1;
                            break;
                        }
                    }
                    //lista = new ArrayList<>();
                }
                 mTrecho.setSemaforo(0);
                lista.remove(espera);
                mTrecho.setFila(lista);
                Trechos.atualizarListaTrecho(mTrecho);
                
        }
    }

    /**
     * Realiza a compra e diponibiliza o recurso
     * @param s Trecho
     * @param co Companhia
     * @throws RemoteException 
     */
    @Override
    public void comprar(String s, String co) throws RemoteException {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Gson gson = new Gson();
        Companhia c = gson.fromJson(co, Companhia.class);
        Trecho t = gson.fromJson(s, Trecho.class);
        List<Trecho> trechos = Start.trechos;
        Trecho mTrecho = null;
        for (Trecho trecho : trechos) {
            if(trecho.getId() == t.getId()) {
                mTrecho = trecho;
                break;
            
            }
        }
        
        if (mTrecho != null) {
                mTrecho.setSemaforo(1);
                Trechos.atualizarListaTrecho(mTrecho);
                List<Espera> lista = mTrecho.getFila();
                 mTrecho.setSemaforo(0);
                //lista.remove(espera);
                mTrecho.setFila(lista);
                Trechos.atualizarListaTrecho(mTrecho);
                
        }
    }

    @Override
    public String testar() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  
    
    
    
}
