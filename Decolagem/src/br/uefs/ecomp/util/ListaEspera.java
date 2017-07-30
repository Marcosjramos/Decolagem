/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uefs.ecomp.util;

import javax.swing.JLabel;

/**
 *
 * @author marcos
 */
public class ListaEspera{
    
    public  int posic; 
    private String pos; 
    private JLabel tela;      
    
    public static ListaEspera  lista ;
    public static ListaEspera getInstace() { 
        if (lista == null) {
            lista = new ListaEspera();
            return lista;
        } else {
            return lista;
        }
    }

 
  

    public ListaEspera(JLabel tela) {
         posic=00;
        this.tela= tela;
        pos= posic + " "+ "ª";
        tela.setText( pos); 
    }

    private ListaEspera() {
       posic=00;
    }

  public void setPosic(int posic) {
        this.posic=posic;
    }
  
   public int getPosic() {
        return posic;
    }
   
    public void update(){
        
        pos=Integer.toString(posic);
        this.tela.setText(pos);
       
   }

   
}
