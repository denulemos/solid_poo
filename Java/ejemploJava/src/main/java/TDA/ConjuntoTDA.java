/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TDA;

/**
 *
 * @author denua
 */
public interface ConjuntoTDA {
    void inicializarConjunto();
    void agregar(int x);
    void sacar (int x);
    //Devuelve un valor del conjunto sin eliminarlo.
    int elegir();
    boolean conjuntoVacio();
    //Si el valor que mandamos como parametro existe en el conjunto, devuelve true
    boolean pertenece(int x);
    
}
