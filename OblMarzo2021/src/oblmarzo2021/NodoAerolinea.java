
package oblmarzo2021;

public class NodoAerolinea {
    int dato;
    String aerolinea;
    ListaVuelo lv;
    NodoAerolinea siguiente;

    public NodoAerolinea(int dato,String Aerolinea) {
        this.dato = dato;
        this.aerolinea=Aerolinea;
        this.lv= new ListaVuelo();
        this.siguiente = null;
    }

    public int getDato() {
        return dato;
    }

    public void setDato(int dato) {
        this.dato = dato;
    }

    public NodoAerolinea getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoAerolinea siguiente) {
        this.siguiente = siguiente;
    }

    public String getAerolinea() {
        return aerolinea;
    }

    public void setAerolinea(String aerolinea) {
        this.aerolinea = aerolinea;
    }

    public ListaVuelo getLv() {
        return lv;
    }

    public void setLv(ListaVuelo lv) {
        this.lv = lv;
    }
 
}
