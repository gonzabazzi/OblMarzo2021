
package oblmarzo2021;

public class NodoCiudad {
    int dato;
    String nombre;
    NodoCiudad siguiente;

    public NodoCiudad(int dato,String nombre) {
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

    public NodoCiudad getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoCiudad siguiente) {
        this.siguiente = siguiente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    
    
}
