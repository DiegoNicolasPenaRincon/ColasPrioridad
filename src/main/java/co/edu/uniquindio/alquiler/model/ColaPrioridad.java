package co.edu.uniquindio.alquiler.model;

import java.util.Collection;
import java.util.Collections;

public class ColaPrioridad<T> {

    public Nodo<T> nodoPrimero, nodoUltimo;
    public int tamanio;



    /**
     * Agrega un elemento en la Cola
     * @param valorNodo elemento a guardar en la Cola
     */
    public void encolar(T valorNodo, int prioridad) {
        Nodo<T> nuevoNodo = new Nodo<>(valorNodo, prioridad);

        // la cola esta vacia
        if (estaVacia()) {
            nodoPrimero = nuevoNodo;
            nodoUltimo = nuevoNodo;
        }
        // el nuevo nodo tiene mas prioridad que el primero
        else if (nuevoNodo.getPrioridad() > nodoPrimero.getPrioridad()) {
            nuevoNodo.setSiguienteNodo(nodoPrimero);
            nodoPrimero = nuevoNodo;
        }
        // encontrar la posicion del nuevo nodo
        else {
            Nodo<T> actual = nodoPrimero;
            while (actual.getSiguienteNodo() != null && actual.getSiguienteNodo() .getPrioridad() >= nuevoNodo.getPrioridad()) {
                actual = actual.getSiguienteNodo() ;}

            nuevoNodo.setSiguienteNodo(actual.getSiguienteNodo())  ;
            actual.setSiguienteNodo(nuevoNodo);

            // actualizar el nuevo nodo a ultimo
            if (nuevoNodo.getSiguienteNodo()  == null) {
                nodoUltimo = nuevoNodo;
            }
        }

        tamanio++; // incrementar tamaño
    }

    /**
     * Retorna y elimina el elemento que esta al incio de la Cola
     * @return Primer elemento de la Cola
     */
    public T desencolar() {

        if(estaVacia()) {
            throw new RuntimeException("La Cola esta vacia");
        }

        T dato = nodoPrimero.getValor();
        nodoPrimero = nodoPrimero.getSiguienteNodo();

        if(nodoPrimero==null) {
            nodoUltimo = null;
        }

        tamanio--;
        return dato;
    }

    /**
     * Verifica si la Cola est� vac�a
     * @return true si est� vac�a
     */
    public boolean estaVacia() {
        return nodoPrimero == null;
    }



    /**
     * Borra completamente la Cola
     */
    public void borrarCola() {
        nodoPrimero = nodoUltimo = null;
        tamanio = 0;
    }

    /**
     * @return the primero
     */
    public Nodo<T> getPrimero() {
        return nodoPrimero;
    }

    /**
     * @return the ultimo
     */
    public Nodo<T> getUltimo() {
        return nodoUltimo;
    }

    /**
     * @return the tamano
     */
    public int getTamano() {
        return tamanio;
    }

    /**
     * Verifica si la Cola es id�ntica a la actual
     * @param colaPrioridad Cola a comparar
     * @return True si son iguales
     */


    /**
     * Imprime una cola en consola
     */
    public void imprimir() {
        Nodo<T> aux = nodoPrimero;
        while(aux!=null) {
            System.out.print(aux.getValor()+"\t");
            aux = aux.getSiguienteNodo();
        }
        System.out.println();
    }


}