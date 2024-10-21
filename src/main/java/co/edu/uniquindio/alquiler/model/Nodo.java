package co.edu.uniquindio.alquiler.model;

public class Nodo<T> {

    private T valor;
    private Nodo<T> siguienteNodo;
    private int prioridad;

    public Nodo(T dato,int prioridad) {
        this.valor = dato;
        this.prioridad=prioridad;
    }

    public T getValor() {
        return valor;
    }

    public void setValor(T valor) {
        this.valor = valor;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    public Nodo<T> getSiguienteNodo() {
        return siguienteNodo;
    }

    public void setSiguienteNodo(Nodo<T> siguienteNodo) {
        this.siguienteNodo = siguienteNodo;
    }
}