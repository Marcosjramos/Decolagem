/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uefs.ecomp.util;

import br.uefs.ecomp.model.Companhia;
import br.uefs.ecomp.model.Trecho;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author cassio
 */
public interface InterfaceData extends Remote {
    
    public String buscarTrecho (int id) throws RemoteException;
    public String testar() throws RemoteException;
    public void reservar(String t, String c) throws RemoteException;
    
}
