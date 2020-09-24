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
public interface DiccionarioSimpleTDA {
    void inicializarDiccionarioSimple();
    //Clave y elemento
    void agregar(int c, int x);
    void eliminar(int c);
    int obtener (int c);
ConjuntoTDA claves();

}
