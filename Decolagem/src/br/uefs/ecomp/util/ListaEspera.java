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
/** A classe  ListaEspera  para poder  criar o mecanismo que vai exibir para usuario 
 *  a sua posição na lista de espera  quando ele cair na lista de espera . <br/>*/

public class ListaEspera{
    
    public  int posic;      /** variavel  posição  para  informa  a posição   do usuario  na lista de espera do sistema.  <br/>*/
    private String pos;      /** variavel  pos  para  poder transforma o valor da posição em uma string  para exibir para o  usuario.  <br/>*/
    private JLabel tela;    /**  variavel  tela  para  poder exibir exibir a posição da lista de espera .  <br/>*/   
    
    public static ListaEspera  lista ; /** varaiavel lista  para set o na tela o posicionamento na terla  <br/>*/
    
    public static ListaEspera getInstace() { 
        
        /** A função   para   retorna lista  de espera  caso usuario  cai nela.  <br/>*/
        
        if (lista == null) {
            lista = new ListaEspera();
            return lista;
        } else {
            return lista;
        }
    }

    public ListaEspera(JLabel tela) {
        /** A função  para fazer a exibição grafiga no posicinamento da tela . <br/>*/
         posic=00;
        this.tela= tela;
        pos= posic + " "+ "ª";
        tela.setText( pos); 
    }

    private ListaEspera() {
        /**  função zera  a posição  na lista de espera. <br/>*/
       posic=00;
    }

  public void setPosic(int posic) {
      /**A função altera o posicionamento na lista de espera.  <br/>*/
        this.posic=posic;
    }
  
   public int getPosic() {
       /***A função retorna o posicionamento na lista  de espera.  <br/>*/
        return posic;
    }
   
    public void update(){
        /**A função atualiza a lista de espera. <br/>*/
        
        pos=Integer.toString(posic);
        this.tela.setText(pos);
       
   }

   
}
