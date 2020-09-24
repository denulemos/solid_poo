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
public interface DiccionarioMultipleTDA {
    void inicializarDiccionarioMultiple();
    void agregar (int c, int x);
    void eliminar(int c);
    void eliminarValor(int c, int x);
    ConjuntoTDA obtener (int c);
    ConjuntoTDA claves();
}
