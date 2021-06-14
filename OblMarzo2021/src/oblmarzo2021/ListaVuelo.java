package oblmarzo2021;

import java.util.Calendar;

public class ListaVuelo implements IListaVuelo {

    NodoVuelo primero;
    NodoVuelo ultimo;
    int cantidad;

    public ListaVuelo() {
        this.primero = null;
        this.ultimo = null;
        this.cantidad = 0;
    }

    public NodoVuelo getPrimero() {
        return primero;
    }

    public void setPrimero(NodoVuelo primero) {
        this.primero = primero;
    }

    public NodoVuelo getUltimo() {
        return ultimo;
    }

    public void setUltimo(NodoVuelo ultimo) {
        this.ultimo = ultimo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public boolean esVacia() {
        return this.getCantidad() == 0;
    }

    @Override
    public void agregarFinal(int numero, String aerolinea, String ciudadOrigen, String ciudadDestino, int estrellas, int capacidad, Calendar fechaHoraSalida, int duracion) {
        NodoVuelo nuevo = new NodoVuelo(numero, aerolinea, ciudadOrigen, ciudadDestino, estrellas, capacidad, fechaHoraSalida, duracion);
        if (this.esVacia()) {
            this.setPrimero(nuevo);
            this.setUltimo(nuevo);
        } else {
            this.ultimo.setSiguiente(nuevo);
            nuevo.setAnterior(this.ultimo);
            this.setUltimo(nuevo);
        }
        this.cantidad++;
    }

    @Override
    public void borrarUltimo() {
        if (!this.esVacia()) {
            if (this.cantidad == 1) {
                this.setPrimero(null);
                this.setUltimo(null);
            } else {
                this.ultimo = this.ultimo.anterior;
                this.ultimo.siguiente = null;
            }
            this.cantidad--;
        }
    }

    @Override
    public void agregarInicio(int numero, String aerolinea, String ciudadOrigen, String ciudadDestino, int estrellas, int capacidad, Calendar fechaHoraSalida, int duracion) {
        NodoVuelo nuevo = new NodoVuelo(numero, aerolinea, ciudadOrigen, ciudadDestino, estrellas, capacidad, fechaHoraSalida, duracion);
        if (this.esVacia()) {
            this.setPrimero(nuevo);
            this.setUltimo(nuevo);
        } else {
            nuevo.setSiguiente(this.getPrimero());
            this.getPrimero().setAnterior(nuevo);
            this.setPrimero(nuevo);
        }
        this.cantidad++;
    }

    @Override
    public void borrarInicio() {
        if (!this.esVacia()) {
            if (this.cantidad == 1) {
                this.setPrimero(null);
                this.setUltimo(null);
            } else {
                this.setPrimero(this.primero.getSiguiente());
                this.getPrimero().setAnterior(null);
            }
            this.cantidad--;
        }

    }

    @Override
    public int cantidad() {
        return this.getCantidad();
    }

    @Override
    public void mostrar() {
        NodoVuelo aux = this.getPrimero();
        while (aux != null) {
            System.out.print("Vuelo numero:"+ aux.getDato() + " Aerolinea: " +aux.getAerolinea()+ " cupo: "+ aux.getCupo()+"\n");
            aux = aux.getSiguiente();
        }
        System.out.println();
    }

    @Override
    public boolean buscarelemento(int dato) {
        NodoVuelo aux = this.getPrimero();
        if (this.primero.getDato() == dato || this.ultimo.getDato() == dato) {
            return true;
        }
        while (aux != null && aux.getDato() != dato) {
            aux = aux.getSiguiente();
        }
        if (aux == null) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public NodoVuelo obtenerelemento(int dato) {
        NodoVuelo aux = this.getPrimero();
        while (aux != null && aux.getDato() != dato) {
            aux = aux.getSiguiente();
        }
        return aux;
    }

    @Override
    public void eliminarelemento(int dato) {
        if (!this.esVacia()) {
            NodoVuelo aux = this.obtenerelemento(dato);
            if (aux != null) {
                if (aux == this.getPrimero()) {
                    this.borrarInicio();
                } else {
                    if (aux == this.getUltimo()) {
                        this.borrarUltimo();
                    }else{
                        aux.anterior.setSiguiente(aux.getSiguiente());
                        aux.siguiente.setAnterior(aux.getAnterior());
                        this.cantidad--;                         
                    }
                }
            }
        }
    }

    @Override
    public void agregarOrdenado(int numero, String aerolinea, String ciudadOrigen, String ciudadDestino, int estrellas, int capacidad, Calendar fechaHoraSalida, int duracion) {
        if (this.esVacia() || numero<this.getPrimero().getDato()){
            this.agregarInicio(numero, aerolinea, ciudadOrigen, ciudadDestino, estrellas, capacidad, fechaHoraSalida, duracion);
        }else{
            if (numero > this.getUltimo().getDato()){
                this.agregarFinal(numero, aerolinea, ciudadOrigen, ciudadDestino, estrellas, capacidad, fechaHoraSalida, duracion);
            }else{
                NodoVuelo aux= this.getPrimero();
                NodoVuelo nuevo = new NodoVuelo(numero, aerolinea, ciudadOrigen, ciudadDestino, estrellas, capacidad, fechaHoraSalida, duracion);
                while (aux!=null && numero > aux.getDato()){
                    aux=aux.getSiguiente();
                }
                nuevo.setSiguiente(aux);
                nuevo.setAnterior(aux.getAnterior());
                aux.setAnterior(nuevo);   
                nuevo.getAnterior().setSiguiente(nuevo);
                this.cantidad++;
            }
        }
    }

    @Override
    public void mostrardelultimoalprimero() {
        NodoVuelo aux = this.getPrimero();
        while (aux != null) {
            System.out.print(aux.getDato() + " - ");
            aux = aux.getSiguiente();
        }
        System.out.println();
    }

    @Override
    public void mostrardelprimeroalultimo() {
     NodoVuelo aux = this.getUltimo();
        while (aux != null) {
            System.out.print(aux.getDato() + " - ");
            aux = aux.getAnterior();
        }
        System.out.println();
    }

    @Override
    public void mostrarRec() {
        System.out.println(mostrarRec(this.getPrimero(),this.getUltimo()));

    }
    
    public String mostrarRec(NodoVuelo primero, NodoVuelo ultimo) {
        if (primero==ultimo)
            return " "+ primero.getDato();
       return     mostrarRec(primero.getSiguiente(),ultimo) +  " - " + primero.getDato()   ;
            

    }    
    

}
