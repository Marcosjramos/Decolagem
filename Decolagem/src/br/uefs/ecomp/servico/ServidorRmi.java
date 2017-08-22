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
import com.google.gson.Gson;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cassio
 */
public class ServidorRmi extends UnicastRemoteObject implements InterfaceData{

    public ServidorRmi() throws RemoteException {
        System.out.println("Servidor iniciado");
    }
    
    
    @Override
    public String buscarTrecho(int id) throws RemoteException {
        Gson gson = new Gson();
        return gson.toJson(Trechos.retornarListaTrechos(id));
    }

    @Override
    public String testar() {
        return "Testando o servidor";
    }

    @Override
    public void reservar(String s, String co) throws RemoteException {
        Gson gson = new Gson();
        Companhia c = gson.fromJson(co, Companhia.class);
        Trecho t = gson.fromJson(s, Trecho.class);
        List<Trecho> trechos = Trechos.retornarListaTrechos();
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
