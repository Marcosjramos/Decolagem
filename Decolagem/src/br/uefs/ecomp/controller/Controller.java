/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uefs.ecomp.controller;

import br.uefs.ecomp.model.Trecho;
import br.uefs.ecomp.model.Trechos;
import br.uefs.ecomp.util.ListaEspera;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;


/**
 *
 * @author marcos
 */
public class Controller {
    public ListaEspera p;

     public Controller(JLabel label) {
          p = new ListaEspera(label);
        
     
     }
     public void buscar(String origem ,String destino){
         
     }
          
     public void RealizarComparar(){
    
     } 
     
     public void Resevar(){
    
     }
        
     public void CancelarResevar(){
    
     }
     
     public void listaEspera(){
         p.getPosic();
         p.update();
    
     }
     public void conectar(){
         
     }
     public void atulizar(){
         System.out.println("Atualizar");
     }
    
    
}
