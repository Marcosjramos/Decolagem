/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uefs.ecomp.util;

import br.uefs.ecomp.model.Trecho;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author cassio
 */
public interface InterfaceData extends Remote {
    public List<Trecho> buscarTrecho (String t1, String t2) throws RemoteException;
    
}
