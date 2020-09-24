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
public class Pila implements PilaTDA{

    private int[] vector;
    private int cant;
    
    @Override
    public void Apilar(int x) {
        vector[cant] = x;
        cant +=1;
    }

    @Override
    public void desapilar() {
       cant -=1;
       
    }

    @Override
    public int tope() {
        return vector[cant-1];
    }

    @Override
    public boolean estaVacio() {
       return cant == 0;
    }

    @Override
    public void inicializarPila() {
       vector = new int[200];
       cant = 0;
    }
    
}
