/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tonelitosmovil;

/**
 *
 * @author rick
 */
public class Arista {
    
    private long distancia;
    private Node nodoInicial;
    private Node nodoFinal;

    public Arista(long distancia, Node nodoInicial, Node nodoFinal) {
        this.distancia = distancia;
        this.nodoInicial = nodoInicial;
        this.nodoFinal = nodoFinal;
    }

    public long getDistancia() {
        return distancia;
    }

    public void setDistancia(long distancia) {
        this.distancia = distancia;
    }

    public Node getNodoInicial() {
        return nodoInicial;
    }

    public void setNodoInicial(Node nodoInicial) {
        this.nodoInicial = nodoInicial;
    }

    public Node getNodoFinal() {
        return nodoFinal;
    }

    public void setNodoFinal(Node nodoFinal) {
        this.nodoFinal = nodoFinal;
    }
    
    
    
    
}
