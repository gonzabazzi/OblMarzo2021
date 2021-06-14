
package oblmarzo2021;

public class NodoPasajero {
    int dato;
    String nombre;
    NodoPasajero siguiente;

    public NodoPasajero(int dato,String nombre) {
        this.dato = dato;
        this.siguiente = null;
        this.nombre=nombre;
    }

    public int getDato() {
        return dato;
    }

    public void setDato(int dato) {
        this.dato = dato;
    }

    public NodoPasajero getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoPasajero siguiente) {
        this.siguiente = siguiente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    
    
}
