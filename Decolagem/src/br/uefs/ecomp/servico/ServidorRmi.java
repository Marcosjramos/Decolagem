/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uefs.ecomp.servico;

import br.uefs.ecomp.model.Trecho;
import br.uefs.ecomp.model.Trechos;
import br.uefs.ecomp.util.InterfaceData;
import com.google.gson.Gson;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
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
    
    
    
}
