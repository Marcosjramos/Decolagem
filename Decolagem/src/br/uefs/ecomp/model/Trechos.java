/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uefs.ecomp.model;

import br.uefs.ecomp.util.InterfaceData;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author marcos
 */
public enum Trechos {

    trecho1("Salvador", "Rio de Janeiro", 1, 2, 1),
    trecho2("Rio de Janeiro", "São Paulo", 2, 2, 2),
    trecho3("Brasília", "Fortaleza", 2, 2, 3),
    trecho4("Salvador", "Aracaju", 2, 2, 4),
    trecho5("Fortaleza", "Brasília", 2, 2, 5),
    trecho6("Recife", "São Paulo", 2, 2, 6),
    trecho7("Manaus", "Fortaleza", 2, 2, 7),
    trecho8("Natal", "Vitória", 3, 2, 8),
    trecho9("Recife", "São Paulo", 3, 2, 9),
    trecho10("São Paulo", "Salvador", 3, 2, 10),
    trecho11("Manaus", "São Paulo", 3, 2, 11),
    trecho12("Fortaleza", "Natal", 3, 2, 12),
    trecho13("Natal", "Brasília", 3, 2, 13),
    trecho14("Salvador", "Vitória", 3, 2, 14),
    trecho15("Salvador", "Manaus", 3, 2, 15),
    trecho16("Natal", "Recife", 3, 2, 16),
    trecho17("Salvador", "São Paulo", 1, 2, 17),
    trecho18("Natal", "Salvador", 1, 2, 18),
    trecho19("Cuiabá", "Vitória", 1, 2, 19),
    trecho20("Brasília", "Vitória", 1, 2, 20),
    trecho21("Manaus", "Vitória", 1, 2, 21),
    trecho22("Curitiba", "Aracaju", 1, 2, 22),
    trecho23("Recife", "Aracaju", 1, 2, 23),
    trecho24("Recife", "Manaus", 1, 2, 24),
    trecho25("Salvador", "São Paulo", 1, 2, 25),
    trecho26("São Paulo", "Recife", 1, 2, 26),
    trecho27("Aracaju", "Rio de Janeiro", 2, 2, 27),
    trecho28("Rio de Janeiro", "Natal", 2, 2, 28),
    trecho29("Rio de Janeiro", "Natal", 2, 2, 29),
    trecho30("Salvador", "Brasília", 2, 2, 30),
    trecho31("Salvador", "Florianópolis", 2, 2, 31),
    trecho32("Porto Alegre", "Cuiaba", 3, 2, 32);

    private final String origem;
    private final String destino;
    private final int companhia;
    private final int quantAssentos;
    private final int id;

    Trechos(String origem, String destino, int companhia, int quantAssentos, int id) {
        this.origem = origem;
        this.destino = destino;
        this.companhia = companhia;
        this.quantAssentos = quantAssentos;
        this.id = id;
    }

    private static Trechos[] trechos = values();
    private static List<Trecho> mTrechos;
    
    public static List<Trecho> retornarListaTrechos(int companhia) {
        Trecho trecho;
        List<Trecho> lista = new ArrayList<>();
        if (mTrechos == null) {
             for (Trechos trechos : trechos) {
            if (trechos.getCompanhia() == companhia) {
                trecho = new Trecho(trechos.getOrigem(), trechos.getDestino(), trechos.getCompanhia(),
                        trechos.getQuantAssentos(), trechos.getId());
                lista.add(trecho);
            }
        }
             mTrechos = lista;
        }
       
        
        return mTrechos;
    }

    public static void atualizarListaTrecho(Trecho t) {
        Trecho mTrecho = null;
        int j = -1;
        for (int i = 0; trechos.length > i; i++) {
            if (trechos[i].getId() == t.getId()) {
                mTrecho = t;
                j = i;
                break;
            }

        }
        if (mTrecho != null) {
            mTrechos.remove(mTrecho);
            mTrechos.add(mTrecho);
           //trechos[j] = mTrecho;
            System.out.println("Atualizou");
        }

    }

    public static List<Trecho> retornarListaTrechos() {
        Trecho trecho;
        List<Trecho> lista = new ArrayList<>();
        for (Trechos trechos : trechos) {
            trecho = new Trecho(trechos.getOrigem(), trechos.getDestino(), trechos.getCompanhia(),
                    trechos.getQuantAssentos(), trechos.getId());
            lista.add(trecho);

        }
        if (mTrechos == null) {
            mTrechos = lista;
        }
        return mTrechos;
    }

    public String getOrigem() {
        return origem;
    }

    public String getDestino() {
        return destino;
    }

    public int getCompanhia() {
        return companhia;
    }

    public int getQuantAssentos() {
        return quantAssentos;
    }

    public int getId() {
        return id;
    }

    /*@Override
    public List<Trecho> buscarTrecho(int id) throws RemoteException {
        //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Trecho trecho;
        List<Trecho> lista = new ArrayList<>();
        for (Trechos trechos : trechos) {
            if (trechos.companhia != id) {
                trecho = new Trecho(trechos.getOrigem(), trechos.getDestino(), trechos.getCompanhia(),
                        trechos.getQuantAssentos(), trechos.getId());
                lista.add(trecho);
            }
        }
        return lista;
    }*/
}
