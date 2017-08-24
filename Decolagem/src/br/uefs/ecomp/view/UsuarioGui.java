/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uefs.ecomp.view;

import br.uefs.ecomp.controller.Controller;
import br.uefs.ecomp.model.Companhia;
import br.uefs.ecomp.model.Espera;
import br.uefs.ecomp.model.Trecho;
import br.uefs.ecomp.model.Trechos;
import br.uefs.ecomp.servico.ClienteRmi;
import static br.uefs.ecomp.view.Start.trechos;
import com.google.gson.Gson;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author marcos
 */
public class UsuarioGui {

    public JFrame frame; /** A   variavél  frame correpode parapoder criara a tela onde  a aplicação vai funcionar. <br/> */
    public int id; /**A  variavel id  e utilizar para algunas  determinada ações  do sistema. <br/> */
    public JPanel panel = new JPanel();/** a variavel panel  que é usada para criar um  efeito  na tela. <br/>  */
    public javax.swing.JList<Trecho> listaReservas = new JList(); /**A variavél listas de Reservas é utilizada para crira as area onde vai exibir  a resevas do usuarios.  <br/> */
    public javax.swing.JList<Trecho> listaTrechos = new JList(); /**A variavél mostra  trechos é utilizada para crira as area onde vai exibir  os trechos e/ou passagens  disponiveis para os usuarios.  <br/> */
    public List<Trecho> trechosReserva = new ArrayList<>();  /** a variavél trechosReserva é utilizada para correrponder as lista de resevas do ususario .  <br/> */
    public DefaultListModel src = new DefaultListModel(); /** A  variavél src é usada para  poder captura a escolha do usuario . <br/> */
    public DefaultListModel dst = new DefaultListModel();/** A  variavél src é usada para  poder captura a escolha do usuario . <br/> */
    public JTextField origem = new JTextField();/** A  variavél origem  é usada para  o que o usuario  indicou   com origem. <br/> */
    public JTextField destino = new JTextField();/** A  variavél destino  é usada para  o que o usuario  indicou   com destino . <br/> */
    public JLabel origemtex = new JLabel("ORIGEM :");/** A  variavél origemtex é usada para  infroma onde usuarao tem que indica com origem no sistema  . <br/> */
    public JLabel destinotex = new JLabel("DESTINO :");/** A  variavél destinotex é usada para  infroma onde usuarao tem que indica com destino no sistema  . <br/> */
    public JLabel posicEsp = new JLabel("SUA POSIÇAO NA LISTA DE ESPERA"); /**  variavél posicEsp é  usada para poder set na tela  uma mensagem para usuario. <br/>*/
    public JButton source = new JButton("OK"); /** variavel source  para  ser o botão origem  na tela  <br/>*/
    public JButton trecho = new JButton("TRECHOS DISPONIVEIS ");/** variavel trecho  para  ser o botão mostra trechos  disponivéis na tela .  <br/>*/
    public JButton comprar = new JButton("COMPRAR PASSAGEM ");/** variavel comprar  para  ser o botão realizar  a compra  do usuario na tela.   <br/>*/
    public JButton resevar = new JButton("REALIZAR RESEVAR = >");/** variavel resevar  para  ser o botão realizar a reseva   do usuario na tela . <br/>*/
    public JButton cancelar = new JButton("< = CANCELAR RESEVAR");/** variavel cancelar  para  ser o botão realizar o cancelamento da  reseva   do usuario na tela.   <br/>*/
    public JButton sair = new JButton("SAIR");/** variavel  sair   para o  botão para sair do sistema.  <br/>*/
    public JButton conecta = new JButton("CONECTAR");/** variavel  conecta  para o  botão para conecta na rede do sistema.  <br/>*/
    public JButton atualizar = new JButton("ATUALIZAR");/** variavel  atualizar  para o  botão para atualizar na rede do sistema.  <br/>*/
    public JLabel posicao = new JLabel(" ");/** variavel  posicao  que vai seta na tela  a posição na tela do sistema.  <br/>*/
    public Controller control;/** variavel control para   acessa e se comunica com o controller  da aplicação.  <br/>*/
    public Trecho mTrecho;/** variavel mtrecho  para  exibri os  osbjetos trechos para usuario .  <br/>*/
    ClienteRmi rmi;/** variavel rmi para poder  usar a comunicação rmi do no sistema. <br/>*/

    
    /** A seguir  o construtor  da classe  da  interface para start  as configurações do sistema.<br/>   */
    public UsuarioGui() {
        Incializar();

    }
    
    /**A seguir s função  que seta as configuraçãoes da interface  .<br/>*/
    private void Incializar() {
        /**
         * a seguir o if que vai set icones e cores na interface do sistema.
         * <br/>
         */
         /**  A segui  especifuca e seta  a configurações gerais da interface. <br/>*/
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        frame = new JFrame();/**criar   tela do sistema.  <br/>*/
        frame.setBounds(100, 40, 1050, 720);/**  seta as dimenções da tela. <br/>*/
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);/** criara açaõ de fechar. <br/>*/
        frame.getContentPane().setLayout(null);
        frame.setTitle("DECOLAGEM");/**  seta o nome da tela.  <br/>*/

        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);/**  criar o panel da tela. <br/>*/
        tabbedPane.setBounds(30, 30, 990, 640);/**  seta as dimenções do panel . <br/>*/
        frame.getContentPane().add(tabbedPane);/**  seta o panel na tela principal. <br/>*/

        tabbedPane.addTab(" BEM VINDO!  ", null, panel, null);/**  seta o nome  do panel. <br/>*/
        panel.setLayout(null);

        
        mostrarTrechos();/**  chama a função  que mostra os trechos. <br/>*/
        origemDestino();/**  chama a função  que mostra os destinos . <br/>*/
        lista(); /**  chama a função  que mostra as listas . <br/>*/

        
        mostrarTrechos();/**  chama a função  que mostra os trechos. <br/>*/
       // origemDestino();/**  chama a função  que mostra os destinos . <br/>*/
        //ista(); /**  chama a função  que mostra as listas . <br/>*/


    }

    private void mostrarTrechos() {
//<<<<<<< HEAD
         /** Dentro da função  mostrarTrechos  , vai seta  os parametros de configuraçãoes  das jlista  que vai mostra  os trechos,  resevas   <br/>
          * , criar a ação  que vai tratar o evento dos botões  principal   que vai ser exibida para o usuario . <br/>*/
        ButtonHandller btmH = new ButtonHandller();
        listaTrechos.setBounds(30, 75, 300, 450);

        frame.getContentPane().add(listaTrechos);
        panel.add(listaTrechos);

        trecho.addActionListener(btmH);
        trecho.setBounds(90, 550, 180, 40);
        frame.getContentPane().add(trecho);
        panel.add(trecho);

        resevar.addActionListener(btmH);
        resevar.setBounds(350, 190, 190, 40);
        frame.getContentPane().add(resevar);
        panel.add(resevar);

        cancelar.addActionListener(btmH);
        cancelar.setBounds(350, 290, 190, 40);
        frame.getContentPane().add(cancelar);
        panel.add(cancelar);

        listaReservas.setBounds(560, 75, 300, 450);
        frame.getContentPane().add(listaReservas);
        panel.add(listaReservas);

        comprar.addActionListener(btmH);
        comprar.setBounds(610, 550, 180, 40);
        frame.getContentPane().add(comprar);
        panel.add(comprar);

        sair.addActionListener(btmH);
        sair.setBounds(880, 40, 100, 40);
        frame.getContentPane().add(sair);
        panel.add(sair);

        conecta.addActionListener(btmH);
        conecta.setBounds(880, 190, 100, 40);
        frame.getContentPane().add(conecta);
        panel.add(conecta);

        atualizar.addActionListener(btmH);
        atualizar.setBounds(880, 360, 100, 40);
        frame.getContentPane().add(atualizar);
        panel.add(atualizar);

//=======
        /*  ButtonHandller btmH = new ButtonHandller();
         listaTrechos.setBounds(30, 75, 300, 450);
       
         frame.getContentPane().add(listaTrechos);
         panel.add(listaTrechos);
         
            src.addElement("teste");       
           listaTrechos.setModel(src);
           src.addElement("teste-2");       
           listaTrechos.setModel(src);
//             listaReservas.setModel(src);;
       
        
         trecho.addActionListener(btmH);
         trecho.setBounds(90, 550, 180, 40);
         frame.getContentPane().add(trecho);
         panel.add(trecho);
        
         resevar.addActionListener(btmH);
         resevar.setBounds(350, 190, 190, 40);
         frame.getContentPane().add(resevar);
         panel.add(resevar);
         
         cancelar.addActionListener(btmH);
         cancelar.setBounds(350, 290, 190, 40);
         frame.getContentPane().add( cancelar );
         panel.add( cancelar );
        
         listaReservas.setBounds(560, 75, 300, 450);
         frame.getContentPane().add(listaReservas);
         panel.add(listaReservas);
        
         comprar.addActionListener(btmH);
         comprar.setBounds(610, 550, 180, 40);
         frame.getContentPane().add(comprar);
         panel.add(comprar);
        
         sair.addActionListener(btmH);
         sair.setBounds(880, 40, 100, 40);
         frame.getContentPane().add( sair);
         panel.add( sair);
         
         conecta .addActionListener(btmH);
         conecta .setBounds(880,190, 100, 40);
         frame.getContentPane().add(conecta );
         panel.add(conecta);
         
         atualizar.addActionListener(btmH);
         atualizar.setBounds(880,360, 100, 40);
         frame.getContentPane().add(atualizar );
         panel.add(atualizar);
           
//>>>>>>> master*/
    }

    /*private void lista() {

=======
    private void lista() {
         /** A  função lista  vai  set  as configurações de exibição  de para o posicionamento  na tela da posição na lista de espera.  <br/>*/
        posicao.setHorizontalAlignment(SwingConstants.CENTER);
        posicao.setFont(new Font("Tahoma", Font.PLAIN, 40));
        posicao.setBounds(290, 440, 360, 75);
        frame.getContentPane().add(posicao);
        panel.add(posicao);
        control = new Controller(posicao);

        posicEsp.setHorizontalAlignment(SwingConstants.CENTER);
        posicEsp.setFont(new Font("Tahoma", Font.PLAIN, 12));
        posicEsp.setBounds(260, 400, 360, 75);
        frame.getContentPane().add(posicEsp);
        panel.add(posicEsp);
    }*/


 /* private void origemDestino() {
=======
    private void origemDestino() {
        
        /**  A função  origemDestino  , vai seta as  configurações de  botões  que  vai trada busca , quando usuario  infroma  a origem e o destino para  busca na tela.  <br/>*/
        ButtonHandller btmH = new ButtonHandller();

        source.addActionListener(btmH);
        source.setBounds(200, 15, 90, 40);
        frame.getContentPane().add(source);
        panel.add(source);

        origemtex.setHorizontalAlignment(SwingConstants.CENTER);
        origemtex.setFont(new Font("Tahoma", Font.PLAIN, 15));
        origemtex.setBounds(-125, -15, 360, 75);
        frame.getContentPane().add(origemtex);
        panel.add(origemtex);
        
        origem = new JTextField();
        origem.setBounds(90, 10, 89, 25);
        frame.getContentPane().add(origem);
        origem.setColumns(10);
        panel.add(origem);

        destinotex.setHorizontalAlignment(SwingConstants.CENTER);
        destinotex.setFont(new Font("Tahoma", Font.PLAIN, 15));
        destinotex.setBounds(-130, 15, 360, 75);
        frame.getContentPane().add(destinotex);
        panel.add(destinotex);

        destino = new JTextField();
        destino.setBounds(90, 40, 89, 25);
        frame.getContentPane().add(destino);
        destino.setColumns(10);
        panel.add(destino);

    }*/
    public void exibir() {
     /** A função  exibir para  exibir os destinos posivéis.   <br/>*/
        listaTrechos.setModel(dst);
    }

    public void exibir(int op) {
         /** A função  exibir para  exibir os destinos posivéis.   <br/>*/
        if (op == 1) {
            src.addElement(listaTrechos.getName());
            //src.addElement(listaTrechos.getSelectedValue());
            listaReservas.setModel(src);
        } else if (op == 0) {
            src.removeElement(listaReservas.getSelectedValue());
            listaReservas.setModel(src);
        }
    }

    private class ButtonHandller implements ActionListener {
        
 /** A função  ButtonHandller trata  do eventos   para  qual botão  o usuario clicou e assim executar   o que o usuario solicitou. <br/>*/
        @Override
        public void actionPerformed(ActionEvent e) {
            if ("OK".equals(e.getActionCommand())) {
                if (origem.getText() == null || origem.getText().trim().equals("")) {
                    JOptionPane.showMessageDialog(null, "O SENHOR TEM QUE INFORMA  A SUA  ORIGEM \n PARA O SISTEMA RELIZAR  A PESQUISAR ");
                } else if (destino.getText() == null || destino.getText().trim().equals("")) {
                    JOptionPane.showMessageDialog(null, "O SENHOR TEM QUE INFORMA  O SEU DESTINO \n  PARA O SISTEMA RELIZAR  A PESQUISAR ");
                } else {
                    control.buscar(origem.getText(), destino.getText());
                }
            } else if ("SAIR".equals(e.getActionCommand())) {
                frame.dispose();
            } else if ("TRECHOS DISPONIVEIS ".equals(e.getActionCommand())) {
                try {
                    trechosDisponiveis();
                } catch (RemoteException ex) {
                    Logger.getLogger(UsuarioGui.class.getName()).log(Level.SEVERE, null, ex);
                } catch (JSONException ex) {
                    Logger.getLogger(UsuarioGui.class.getName()).log(Level.SEVERE, null, ex);
                } catch (UnknownHostException ex) {
                    Logger.getLogger(UsuarioGui.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if ("CONECTAR".equals(e.getActionCommand())) {
                rmi = new ClienteRmi();
            } else if ("ATUALIZAR".equals(e.getActionCommand())) {
                try {
                    trechosDisponiveis();
                } catch (UnknownHostException ex) {
                    Logger.getLogger(UsuarioGui.class.getName()).log(Level.SEVERE, null, ex);
                } catch (RemoteException ex) {
                    Logger.getLogger(UsuarioGui.class.getName()).log(Level.SEVERE, null, ex);
                } catch (JSONException ex) {
                    Logger.getLogger(UsuarioGui.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if ("COMPRAR PASSAGEM ".equals(e.getActionCommand())) {
                if (src.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "O SENHOR SO PODE REALIZAR UMA COMPRAR \n  DEPOIS  QUE JA TEM REALIZADO UMA RESEVA! ");
                } else {
                    try {
                        rmi.comprarTrecho(listaReservas.getSelectedValue());
                        trechosReserva.remove(listaReservas.getSelectedValue());
                        src.removeElement(listaReservas.getSelectedValue());
                        listaReservas.setModel(src);
                        trechosDisponiveis();
                    } catch (RemoteException ex) {
                        Logger.getLogger(UsuarioGui.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (UnknownHostException ex) {
                        Logger.getLogger(UsuarioGui.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (JSONException ex) {
                        Logger.getLogger(UsuarioGui.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            } else if ("REALIZAR RESEVAR = >".equals(e.getActionCommand())) {
                //System.out.println(mTrecho.getId());
                Trecho t2 = buscartrecho(mTrecho);
                if (t2 != null) {
                    String destino = t2.getCidadeorigem();
                    String origem = t2.getCidadedestino();
                    if (t2.getSemaforo() == 0) {
                            try {
                                 rmi.reservarTrecho(t2);
                                    Trecho t3 = t2;
                                    t3.setCidadedestino(destino);
                                    t3.setCidadeorigem(origem);
                                    src.addElement(t3);
                                    listaReservas.setModel(src);
                                    trechosReserva.add(t2);
                                
                            } catch (RemoteException ex) {
                                Logger.getLogger(UsuarioGui.class.getName()).log(Level.SEVERE, null, ex);
                            }

                        //}
//                        else {
//                            System.out.println("Segunda verificação");
//                        }
                    } else {
                        System.out.println(mTrecho.getSemaforo());
                    }
                }
                try {
                    trechosDisponiveis();

                    /*if (src.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "O SENHOR SO PODE REALIZAR UMA RESEVAR \n  APOS SELECINAR UM TRECHO! ");
                    } else {
                    System.out.println("Teste");
                    src.addElement(listaTrechos.getSelectedValue());
                    listaReservas.setModel(src);
                    control.Resevar();
                    }*/
                } catch (UnknownHostException ex) {
                    Logger.getLogger(UsuarioGui.class.getName()).log(Level.SEVERE, null, ex);
                } catch (RemoteException ex) {
                    Logger.getLogger(UsuarioGui.class.getName()).log(Level.SEVERE, null, ex);
                } catch (JSONException ex) {
                    Logger.getLogger(UsuarioGui.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if ("< = CANCELAR RESEVAR".equals(e.getActionCommand())) {
                if (src.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "O SENHOR SO PODE CANSELAR UM RESEVAR \n  CASO JA TEM REALIZADO UM RESEVA! ");
                } else {
                    try {
                        rmi.cancelarTrecho(listaReservas.getSelectedValue());
                        trechosReserva.remove(listaReservas.getSelectedValue());
                        src.removeElement(listaReservas.getSelectedValue());
                        listaReservas.setModel(src);
//                        control.CancelarResevar();
                        trechosDisponiveis();
                        if (src.isEmpty()) {
                            JOptionPane.showMessageDialog(null, "O SENHOR SO PODE REALIZAR UMA RESEVAR \n  APOS SELECINAR UM TRECHO! ");
                        } else {
//                      src.addElement(listaTrechos.getSelectedValue());
//                     listaReservas.setModel(src);
//                        exibir(1);
                            control.Resevar();
                        }
                    } catch (RemoteException ex) {
                        Logger.getLogger(UsuarioGui.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (UnknownHostException ex) {
                        Logger.getLogger(UsuarioGui.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (JSONException ex) {
                        Logger.getLogger(UsuarioGui.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }

            }

            listaTrechos.addListSelectionListener(new ListSelectionListener() {
                @Override
                public void valueChanged(ListSelectionEvent lse) {
                    //  System.out.println(lse);
                    if (listaTrechos.getSelectedValue() != null) {
                        //System.out.println(listaTrechos.getSelectedValue());
                        //System.out.println(buscartrecho((Trecho)listaTrechos.getSelectedValue()));
                        mTrecho = listaTrechos.getSelectedValue();
                    }
                }
            });

        }

        public void trechosDisponiveis() throws UnknownHostException, RemoteException, JSONException {
           /** A função trechosDisponiveis pegando os dados  do sevidores das empreseas  .<br/>*/
             //   exibir(1);
            //control.atulizar();

            listaTrechos.removeAll();
            List<Trecho> mT = new ArrayList<>();

            JSONArray ja = new JSONArray(rmi.trechos());
            for (int i = 0; ja.length() > i; i++) {
                JSONObject jo = (JSONObject) ja.get(i);
                //System.out.println(jo.toString())
                Trecho t = new Trecho(jo.getString("cidadeorigem"), jo.getString("cidadedestino"), jo.getInt("id"), jo.getInt("quantAssentos"), jo.getInt("id"));
                JSONArray filaEspera = jo.getJSONArray("fila");
                if (filaEspera != null && filaEspera.length() > 0) {
                    //System.out.println(filaEspera.toString());
                    for (int j = 0; filaEspera.length() < j; j++) {
                        JSONObject mJo = (JSONObject) filaEspera.get(j);
                        Espera espera = new Espera();
                        espera.setIp(mJo.getString("ip"));
                        espera.setNum(mJo.getInt("num"));
                        List<Espera> mEsperas = new ArrayList<>();
                        mEsperas.add(espera);
                        t.setFila(mEsperas);
                    }
                }
                t.setSemaforo(jo.getInt("semaforo"));
                //System.out.println();
                mT.add(t);
            }
            Collections.sort(mT);
            for (int i = 0; mT.size() > i; i++) {
                // System.out.println(mT.get(i).getSemaforo());
                dst.add(i, mT.get(i));
                listaTrechos.setModel(dst);
            }
        }
    }

    public Trecho buscartrecho(Trecho t) {
          /** a função  buscartrecho busca os trechos que o sistema  tem para comercializar . <br/> */
        List<Trecho> trechos = Trechos.retornarListaTrechos();
        for (int i = 0; trechos.size() > i; i++) {
            if (t.getId() == trechos.get(i).getId()) {
                return trechos.get(i);
            }
        }
        return null;
    }

        
    public void reservar(Trecho t) {
          /** a função  resevar  faz as resevar  que o usuario  pretende fazer . <br/> */
        List<Trecho> trechos = Trechos.retornarListaTrechos();
        Trecho t2 = null;
        for (int i = 0; trechos.size() > i; i++) {
            if (t.getId() == trechos.get(i).getId()) {
                t2 = trechos.get(i);
                break;
            }
        }

        if (t2 != null) {
            List<Espera> fila = t2.getFila();

            if (fila != null && !fila.isEmpty()) {
                Espera espera = null;
                for (Espera e : fila) {
                    if (e.getIp().equals("ip")) {
                        espera = e;
                        break;
                    }
                }
                if (espera != null) {
                    espera = new Espera();
                    espera.setIp("ip");
                    espera.setNum(fila.size() + 1);
                    fila.add(espera);
                    t.setFila(fila);
                    Start.trechos.remove(t);
                    Start.trechos.add(t);
                } else {
                    espera = new Espera();
                    espera.setIp("ip");
                    espera.setNum(1);
                    fila.add(espera);
                    t.setFila(fila);
                    Start.trechos.remove(t);
                    Start.trechos.add(t);
                }
            } else {
                Espera espera = new Espera();
                espera.setIp("ip");
                espera.setNum(1);
                fila.add(espera);
                t.setFila(fila);
                Start.trechos.remove(t);
                Start.trechos.add(t);
            }
        }
    }

    public boolean verificarReserva(Trecho mt) {
        /** a função  verificarReserva verifica   a reseva do usuario. <br/> */
        List<Trecho> lista = trechosReserva;
        if (lista != null && !lista.isEmpty()) {
            for (Trecho t : lista) {
                //System.out.println(t.getId());
                if (t.getId() == mt.getId()) {
                    return true;
                }
            }
        }
        return false;
    }

}