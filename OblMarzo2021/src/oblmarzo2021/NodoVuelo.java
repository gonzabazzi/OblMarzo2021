
package oblmarzo2021;

import java.util.Calendar;

public class NodoVuelo {
    int dato;
    int cupo;
    String  aerolinea;
    ListaPasajero lp;
    Cola colaespera;
    Pila pilacomentario;
    NodoVuelo siguiente;
    NodoVuelo anterior;

    public NodoVuelo(int dato, String aerolinea, String ciudadOrigen, String ciudadDestino, int estrellas, int cupo, Calendar fechaHoraSalida, int duracion) {
        this.dato = dato;
        this.cupo = cupo;
        this.aerolinea = aerolinea;
        this.lp = new ListaPasajero(cupo);
        this.colaespera = new Cola(10);
        this.pilacomentario = new Pila(cupo);
        this.siguiente = null;
        this.anterior = null;
    }

    
    
    public int getDato() {
        return dato;
    }

    public void setDato(int dato) {
        this.dato = dato;
    }

    public int getCupo() {
        return cupo;
    }

    public void setCupo(int cupo) {
        this.cupo = cupo;
    }

    public String getAerolinea() {
        return aerolinea;
    }

    public void setAerolinea(String aerolinea) {
        this.aerolinea = aerolinea;
    }

    public ListaPasajero getLp() {
        return lp;
    }

    public void setLp(ListaPasajero lp) {
        this.lp = lp;
    }

    public Cola getColaespera() {
        return colaespera;
    }

    public void setColaespera(Cola colaespera) {
        this.colaespera = colaespera;
    }

    public Pila getPilacomentario() {
        return pilacomentario;
    }

    public void setPilacomentario(Pila pilacomentario) {
        this.pilacomentario = pilacomentario;
    }

    public NodoVuelo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoVuelo siguiente) {
        this.siguiente = siguiente;
    }

    public NodoVuelo getAnterior() {
        return anterior;
    }

    public void setAnterior(NodoVuelo anterior) {
        this.anterior = anterior;
    }


    
}
